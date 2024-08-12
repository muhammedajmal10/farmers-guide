package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SearchView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class faq extends AppCompatActivity {
    SearchView mySearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        mySearchView = (SearchView) findViewById(R.id.mySearchView);


        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        Toast.makeText(this, "Your question have been posted wait for reply....", Toast.LENGTH_SHORT).show();
    }
}
