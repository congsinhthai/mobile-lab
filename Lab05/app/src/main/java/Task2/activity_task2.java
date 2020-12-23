package Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab05.R;

import Task1.activity_task1;

public class activity_task2 extends AppCompatActivity {

    Button btn_back;
    TextView tv_new_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        setUIReference();


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_task2.this, activity_task1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }



    private void setUIReference() {
        btn_back=(Button)findViewById(R.id.btn_back);
        tv_new_activity=(TextView)findViewById(R.id.tv_new_activity);
    }
}