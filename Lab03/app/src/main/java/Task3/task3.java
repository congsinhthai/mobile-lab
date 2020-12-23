package Task3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab03.R;

import java.util.ArrayList;
import java.util.List;

public class task3 extends AppCompatActivity  implements ItemClickListener{
    EditText et_name;
    EditText et_id;
    EditText et_phone;
    Button btn_add;
    RecyclerView recyclerView;
    List<Contact> contacts;
    Contact_Adapter contact_adapter;
    LinearLayoutManager linearLayoutManager;
    DataBaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        db = new DataBaseHandler(this);
        setUIReference();
        contacts = new ArrayList<>();

        contacts = db.getAllContacts();
        contact_adapter = new Contact_Adapter(contacts, task3.this);
        linearLayoutManager = new LinearLayoutManager(task3.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(contact_adapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        Contact contact = new Contact(Integer.parseInt(et_id.getText().toString()), et_name.getText().toString(), et_phone.getText().toString());
                        Contact cn = db.getContact(Integer.parseInt(et_id.getText().toString()));
                        if (cn == null) {
                            db.addContact(contact);
                            contacts.add(contact);
                            contact_adapter.notifyItemInserted(contacts.size());

                            getAllContact(db);

                        } else {
                            Toast.makeText(task3.this, "ID da ton tai", Toast.LENGTH_SHORT).show();
                        }
                    } catch (SQLiteConstraintException sqlEx) {
                        sqlEx.getMessage();
                    }
                }

        });
        contact_adapter.setClickListener(this);
    }

    public boolean checkVailInput() {
        if (et_name.getText().toString().isEmpty()) {
            et_name.setError("Input vail name");
            return false;
        }
        if (et_phone.getText().toString().isEmpty()) {
            et_phone.setError("Input vail phone number");
            return false;
        }

        if (et_id.getText().toString().isEmpty()) {
            et_id.setError("Input vail id");
            return false;
        }
        return true;
    }

    public void getAllContact(DataBaseHandler db) {
        List<Contact> contactList;
        contactList = db.getAllContacts();
        for (Contact cn : contactList) {
            Log.e("Name:", cn.toString());
        }
    }

    public void setUIReference() {
        et_id = findViewById(R.id.et_contact_id);
        et_name = findViewById(R.id.et_contact_name);
        et_phone = findViewById(R.id.et_contact_ph_num);
        btn_add = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.contact_list);
    }

    @Override
    public void onItemClick(View view, int position, boolean isLongClick) {
        try{

            db.deleteContact(contacts.get(position));
            contacts.remove(position);
            contact_adapter.notifyDataSetChanged();
            Toast.makeText(this,"Contact deleted",Toast.LENGTH_SHORT).show();
        }catch (SQLException sqlException)
        {
            sqlException.getCause();
        }
    }
}
