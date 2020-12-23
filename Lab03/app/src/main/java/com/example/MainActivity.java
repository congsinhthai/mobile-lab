package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab03.R;
import Task2.activity_task2;
import Task3.*;
import Task1.*;

public class MainActivity extends AppCompatActivity {

    Button btn_task1,btn_task2,btn_task3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_task1=findViewById(R.id.btn_taks1);
        btn_task2=findViewById(R.id.btn_taks2);
        btn_task3=findViewById(R.id.btn_taks3);
        btn_task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,activity_task1.class);
                startActivity(intent);
            }
        });

        btn_task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,activity_task2.class);
                startActivity(intent);
            }
        });
        btn_task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,task3.class);
                startActivity(intent);
            }
        });
    }
}