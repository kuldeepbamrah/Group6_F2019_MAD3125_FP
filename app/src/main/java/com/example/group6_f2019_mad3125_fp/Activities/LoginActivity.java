package com.example.group6_f2019_mad3125_fp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group6_f2019_mad3125_fp.CustomDialog;
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

        username.setText(R.string.login);
        pass.setText(R.string.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user@employee.com") && pass.getText().toString().equals("s3cr3t"))
                {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
               // else if(username.getText().toString().equals("") && pass.getText().toString().equals(""))
                else
                    {
                    CustomDialog mydialog = new CustomDialog();
                    mydialog.showSingleDialog(LoginActivity.this,"Please enter correct values");
                    Toast.makeText(LoginActivity.this,"sdfs",Toast.LENGTH_SHORT).show();
                }
                }
            });
        }


    }

