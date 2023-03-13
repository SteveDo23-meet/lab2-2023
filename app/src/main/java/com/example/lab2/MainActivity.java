package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etMain , etPassword;
    Button btnSignin , btnSignup ,btnLogout;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = (EditText) findViewById(R.id.etMain);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(this);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
        sp=getSharedPreferences("details1",0);
        String strUsername = sp.getString("Username",null);
        String strPassword=sp.getString("Password",null);
        if(strUsername!=null)
        {
            etMain.setText(strUsername);
        }
        if(strPassword!=null){
            etPassword.setText(strPassword);
        }




    }

    @Override
    public void onClick(View view) {
        if(view == btnSignup){
            Intent intent=new Intent(this,SignUpActivity.class);
        }
        else if(view == btnSignin){
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("Username",etMain.getText().toString());
            editor.putString("Password",etPassword.getText().toString());
            editor.commit();
            Intent intent = new Intent (this,home_page.class);
        }
    }
}