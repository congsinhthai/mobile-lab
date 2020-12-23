package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_name;
    TextView items;
    Button btn_submit;
    EditText et_name;
    List name=new ArrayList<String>();
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUIReference();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_name.getText().toString().isEmpty())
                {
                    //thong bao loi
                    Toast.makeText(MainActivity.this,"Input name",Toast.LENGTH_SHORT).show();
                }else{
                    //add data to arraylist
                    name.add(et_name.getText().toString());
                    //update listview
                   adapter=new DataAdapter (name);

                    lv_name.setAdapter(adapter);


                }
            }
        });
        lv_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_name.setText(name.get(position).toString());
            }
        });
        lv_name.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                name.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    public void setUIReference()
    {
        lv_name=findViewById(R.id.lv_name);
        items=findViewById(R.id.tv_name);
        btn_submit=findViewById(R.id.btn_add);
        et_name=findViewById(R.id.et_input);
    }


}