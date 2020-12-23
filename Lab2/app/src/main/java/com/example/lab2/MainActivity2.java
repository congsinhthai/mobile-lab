package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Task3.task3;
import Task3.*;
import Task4.*;
import Task5.*;

public class MainActivity2 extends AppCompatActivity {

    Button btn_task1, btn_task2,btn_task3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_task1=findViewById(R.id.btn_taks1);
        btn_task2=findViewById(R.id.btn_taks2);
        btn_task3=findViewById(R.id.btn_taks3);
        btn_task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,task3.class);
                startActivity(intent);
            }
        });

        btn_task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,Task4.class);
                startActivity(intent);
            }
        });
        btn_task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, task5.class);
                startActivity(intent);
            }
        });
    }
}