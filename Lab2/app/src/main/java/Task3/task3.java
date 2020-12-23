package Task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lab2.DataAdapter;
import com.example.lab2.MainActivity;
import com.example.lab2.R;

import java.util.ArrayList;
import java.util.List;

import Employee.Employee;
import Employee.*;

public class task3 extends AppCompatActivity {

    EditText et_id;
    EditText et_name;
    RadioButton ra_fulltime;
    RadioButton ra_parttime;
    Button btn_submit;
    ListView lv_em;
    ArrayList<Employee> employees=new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter=null;
    Employee employee =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task3);
        setUIReference();
        arrayAdapter=new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1,employees);
        lv_em.setAdapter(arrayAdapter);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVailInput())
                {
                    addNewEmployee();
                }
            }
        });
    }

    public void addNewEmployee()
    {
        String id =et_id.getText().toString();
        String name=et_name.getText().toString();
        if (ra_parttime.isChecked())
        {
            employee=new partTimeEmployee();
        }
        else if (ra_fulltime.isChecked())
        {
            employee=new fullTimeEmployee();
        }
        employee.setId(id);
        employee.setName(name);
        employees.add(employee);
        arrayAdapter.notifyDataSetChanged();
        Toast.makeText(task3.this,"Employee added succesfull",Toast.LENGTH_LONG).show();
    }
    public boolean checkVailInput(){
        if (et_id.getText().toString().isEmpty())
        {
            Toast.makeText(task3.this,"ID isn't vail",Toast.LENGTH_SHORT).show();
            return false;
        }else  if (et_name.getText().toString().isEmpty())
        {
            Toast.makeText(task3.this,"Name isn't vail",Toast.LENGTH_SHORT).show();
            return false;
        }else if( (!ra_parttime.isChecked())&&(!ra_fulltime.isChecked()))
        {
            Toast.makeText(task3.this,"Choose employee category",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void setUIReference(){
        et_id=findViewById(R.id.et_em_id);
        et_name=findViewById(R.id.et_em_name);
        ra_fulltime=findViewById(R.id.ra_fulltime);
        ra_parttime=findViewById(R.id.ra_parttime);
        btn_submit=findViewById(R.id.btn_submit);
        lv_em=findViewById(R.id.lv_em);

    }
}