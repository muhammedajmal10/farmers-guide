package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class market extends AppCompatActivity implements View.OnClickListener {

    private Button hsignup;
    private TextInputLayout editTextemail, editTextpassword;
    private Button login;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        hsignup = (Button) findViewById(R.id.hsignup);
        hsignup.setOnClickListener(this);

        login = (Button) findViewById(R.id.hlogin);
        login.setOnClickListener(this);

        editTextemail = (TextInputLayout) findViewById(R.id.username);
        editTextpassword = (TextInputLayout) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hsignup:
                startActivity(new Intent(this,marketsignup.class));
                break;
            case R.id.hlogin:
                userLogin();
                break;

        }

    }

    private void userLogin() {
        String username = editTextemail.getEditText().getText().toString().trim();
        String password = editTextpassword.getEditText().getText().toString().trim();

        if(username.isEmpty()) {
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            editTextemail.setError("Please enter a valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length() < 6) {
            editTextpassword.setError("Minimum password length is 6 characters");
            editTextpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    //redirect to hotel dashboard
                    startActivity(new Intent(market.this,buyorsell.class));
                } else {
                    Toast.makeText(market.this, "Failed to login... Please check your Username or password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
