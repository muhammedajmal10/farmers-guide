
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class officer extends AppCompatActivity {
    TextInputLayout username5,password5;
    Button alogin;
    String correct_username="alappuzha";
    String correct_password="alp123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer);
        username5= (TextInputLayout) findViewById(R.id.username);
        password5= (TextInputLayout) findViewById(R.id.password);
        alogin= (Button) findViewById((R.id.hlogin));

        alogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username5.getEditText().getText().toString()) || TextUtils.isEmpty(password5.getEditText().getText().toString())) {
                    Toast.makeText(officer.this, "Empty data provided", Toast.LENGTH_LONG).show();
                } else if (password5.getEditText().getText().toString().equals(correct_password)) {
                    if (password5.getEditText().getText().toString().equals(correct_password)) {
                        Toast.makeText(officer.this, "successfully login", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(officer.this, officer1.class));
                    } else {
                        Toast.makeText(officer.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(officer.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                }
            }


        });

    }
}