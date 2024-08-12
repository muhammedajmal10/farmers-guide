package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout regName, regNumber, regEmail, regPassword;
    private TextView msignup;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        msignup = (Button) findViewById(R.id.msignup);
        msignup.setOnClickListener(this);

        regName = (TextInputLayout) findViewById(R.id.reg_name);
        regNumber = (TextInputLayout) findViewById(R.id.reg_number);
        regEmail = (TextInputLayout) findViewById(R.id.reg_email);
        regPassword = (TextInputLayout) findViewById(R.id.reg_password);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.msignup:
                msignup();
                break;
        }
    }
    public void msignup() {
        String fullname = regName.getEditText().getText().toString().trim();
        String number = regNumber.getEditText().getText().toString().trim();
        String email = regEmail.getEditText().getText().toString().trim();
        String password = regPassword.getEditText().getText().toString().trim();

        if(fullname.isEmpty()){
            regName.setError("Name is required");
            regName.requestFocus();
            return;
        }
        if(number.isEmpty()){
            regNumber.setError("Enter valid phone number");
            regNumber.requestFocus();
            return;
        }
        if(number.length()<10) {
            regNumber.setError("Enter valid phone number");
            regNumber.requestFocus();
            return;
        }
        if(email.isEmpty()){
            regEmail.setError("Enter email address");
            regEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            regEmail.setError("Please provide valid mail address");
            regEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            regPassword.setError("Password is required");
            regPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            regPassword.setError("Minimum password length should be 6 character");
            regPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(fullname,number,email,password);

                            FirebaseDatabase.getInstance().getReference("farmer")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(signup.this, " registered successfully", Toast.LENGTH_LONG).show();
                                                startActivity(new Intent(signup.this,farmer.class));
                                            }else{
                                                Toast.makeText(signup.this, "Failed to register! Try Again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(signup.this, "Failed to register!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}