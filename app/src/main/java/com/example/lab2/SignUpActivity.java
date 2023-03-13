package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName , etPass , etEmail;
    Button btnSubmit;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText)findViewById(R.id.etPass);
        //----------------------------------------
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        //----------------------------------------
        sp=getSharedPreferences("details1",0);


    }

    @Override
    public void onClick(View view) {
        if(view == btnSubmit){
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("Name",etName.getText().toString());
            editor.putString("Email",etEmail.getText().toString());
            editor.putString("Password",etPass.getText().toString());
            editor.commit();
            Intent intent = new Intent (this,home_page.class);
        }
    }
}