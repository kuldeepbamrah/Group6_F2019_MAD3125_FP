package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.group6_f2019_mad3125_fp.R;

public class LoginActivity extends AppCompatActivity {

    TextView login;
    EditText username,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_login);

        login = findViewById(R.id.login);
        username = findViewById(R.id.username_input);
        pass = findViewById(R.id.pass);

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user@employee.com") && pass.getText().toString().equals("s3cr3t"))
                {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else
                {
                    MaterialDialog(this).show {
                    title(R.string.your_title)
                    message(R.string.your_message)
                }
                }
            }
        });


    }
}
