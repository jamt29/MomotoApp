package com.example.momotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newaccount extends AppCompatActivity {


    private EditText etfirstname, etlastname, etemailaddres, etcontra1, etcontra2;
    private Button btncreateaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);

        etfirstname = (EditText) findViewById(R.id.etfirstname);
        etlastname = (EditText) findViewById(R.id.etlastname);
        etemailaddres = (EditText) findViewById(R.id.etemailaddres);
        etcontra1 = (EditText) findViewById(R.id.etcontra1);
        etcontra2 = (EditText) findViewById(R.id.etcontra2);

        btncreateaccount = (Button) findViewById(R.id.btncreateaccount);

    }

    public void createaccount(View view) {
    //    SQLiteDatabase bd = admin.getWritableDatabase();

        String firstname = etfirstname.getText().toString();
        String lastname = etlastname.getText().toString();
        String emailaddres = etemailaddres.getText().toString();
        String contra1 = etcontra1.getText().toString();
        String contra2 = etcontra2.getText().toString();

            }
        }


