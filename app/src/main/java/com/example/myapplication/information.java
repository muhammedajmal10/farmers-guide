package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class information extends AppCompatActivity {
    private ImageButton button01;
    private ImageButton button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        button01 = findViewById(R.id.newsbtn);
        button02 = findViewById(R.id.weatherbtn);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button01("https://krishijagran.com");
            }
            public void button01(String url){

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {button02("https://www.accuweather.com");
            }
        });
    }
    public void button02(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}