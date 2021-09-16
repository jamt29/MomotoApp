package com.example.momotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void newaccount(View view) {
        Intent i = new Intent(login.this, newaccount.class);
        startActivity(i);
    }

    public void forgot(View view) {
        Intent i = new Intent(login.this, bienvenida.class);
        startActivity(i);
    }
}