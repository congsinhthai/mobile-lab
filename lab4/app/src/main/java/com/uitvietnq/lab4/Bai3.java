package com.uitvietnq.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bai3 extends AppCompatActivity {


    private Button btnQuickJob, btnSlowJob;
    private TextView tvStatus;
    private SlowTask slowTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        setUIReference();
        //init slowtask
        slowTask=new SlowTask(Bai3.this,tvStatus);
        //handler on button click
        btnQuickJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                tvStatus.setText(simpleDateFormat.format(new Date()));
            }
        });
        btnSlowJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slowTask.execute();
            }
        });
    }

    private void setUIReference() {
        btnQuickJob=findViewById(R.id.btn_quick_job);
        btnSlowJob=findViewById(R.id.btn_slow_job);
        tvStatus=findViewById(R.id.tv_status);

    }

}