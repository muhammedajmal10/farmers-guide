package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class farmer1 extends AppCompatActivity {
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer1);

        button1 =findViewById(R.id.imageButton2);
        button2 =findViewById(R.id.imageButton3);
        button3 = findViewById(R.id.imageButton4);
        button4 = findViewById(R.id.imageButton5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(farmer1.this, faq.class);
                startActivity(intent);

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(farmer1.this, information.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(farmer1.this, crops.class);
                startActivity(intent);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(farmer1.this,enquiry.class);
                startActivity(intent);
            }
        });
    }
}