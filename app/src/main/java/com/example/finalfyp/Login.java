package com.example.finalfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Email , Password;
    String email, password;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }
    void login()
    {
        Email = findViewById(R.id.email_signIn);
        Password = findViewById(R.id.password_signIn);
        signIn = findViewById(R.id.login);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();
                if(email.isEmpty() || password.isEmpty())
                    Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
                else if(Start.myAppDb.myDao().getUserEmail(email)==null || Start.myAppDb.myDao().getUserPass(password)==null)
                    Toast.makeText(getApplicationContext(), "Invalid Email or Password",Toast.LENGTH_SHORT).show();
                else
                {

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("email", email);
                    // intent.putExtra("image", getIntent().getStringExtra("image"));
                    startActivity(intent);
                }
            }

        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Start.class);
        startActivity(intent);
    }
}
