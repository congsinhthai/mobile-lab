package com.uitvietnq.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBai1 = (Button) findViewById(R.id.btnBai1);
        Button btnBai2 = (Button) findViewById(R.id.btnBai2);
        Button btnBai3 = (Button) findViewById(R.id.btnBai3);
        Button btnBai4 = findViewById(R.id.btnBai4);


        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Bai1.class);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Bai2.class);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(Bai3.class);
            }
        });

        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Bai4.class);
            }
        });

    }

    public void openActivity(Class className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
    }

}
