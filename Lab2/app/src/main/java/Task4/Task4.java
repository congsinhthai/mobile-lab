package Task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab2.R;

import java.util.ArrayList;
import java.util.List;

public class Task4 extends AppCompatActivity {

    EditText et_id;
    EditText et_name;
    CheckBox cb_isManager;
    ListView lv_em;
    Button btn_add;
    List<Employee_Task4> employeeTask4List =new ArrayList<Employee_Task4>();
    Adapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);
        setUIReference();
        //create adapter
        adapter=new Adapter(employeeTask4List,this);
        //set adapter to listview
        lv_em.setAdapter(adapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkVailInput())
                {
                    Boolean isManager;
                    if(cb_isManager.isChecked()) {
                        isManager=true;
                    }
                    else{
                        isManager=false;
                    }

                    Employee_Task4 employee_task4=new Employee_Task4(et_id.getText().toString(),et_name.getText().toString(),isManager);
                    employeeTask4List.add(employee_task4);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void setUIReference()    {
        et_id=findViewById(R.id.et_id2);
        et_name=findViewById(R.id.et_name2);
        btn_add=findViewById(R.id.btn_add);
        cb_isManager=findViewById(R.id.is_manager);
        lv_em=findViewById(R.id.lv_task4);

    }
    public boolean checkVailInput(   ){
        if (et_id.getText().toString().isEmpty())
        {
            Toast.makeText(Task4.this,"ID mustn't empty",Toast.LENGTH_SHORT).show();
            return false;
        } else
        if (et_name.getText().toString().isEmpty())
        {
            Toast.makeText(Task4.this,"Name mustn't empty",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}