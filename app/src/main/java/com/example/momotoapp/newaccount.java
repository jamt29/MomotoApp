package com.example.momotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newaccount extends AppCompatActivity {

    //Mapeo de variables del activity_newaccount.xml
    private EditText etfirstname, etlastname, etemailaddres, etcontra1, etcontra2;
    private Button btncreateaccount;
    private Cursor fila;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);

        //Mapeo de variables del activity_newaccount.xml
        etfirstname = (EditText) findViewById(R.id.etfirstname);
        etlastname = (EditText) findViewById(R.id.etlastname);
        etemailaddres = (EditText) findViewById(R.id.etemailaddres);
        etcontra1 = (EditText) findViewById(R.id.etcontra1);
        etcontra2 = (EditText) findViewById(R.id.etcontra2);



    }
    //metodo de creacion de cuentas
    public void createaccount(View view) {
        DBHelper admin = new DBHelper(this,"usuarios",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();


        //variables y capturas de los datos ingresados por el usuario
        String firstname = etfirstname.getText().toString();
        String lastname = etlastname.getText().toString();
        String emailaddres = etemailaddres.getText().toString();
        String contra1 = etcontra1.getText().toString();
        String contra2 = etcontra2.getText().toString();

        ContentValues values = new ContentValues();

        //captura de los valores
        values.put("firstname",firstname);
        values.put("lastname",lastname);
        values.put("emailaddres",emailaddres);
        values.put("password1",contra1);
        values.put("password2",contra2);


        //Sentencias de campos vacios
        if (firstname.isEmpty()) {
            etfirstname.setError("Campo Obligatorio");

        } else if (lastname.isEmpty()) {
            etlastname.setError("Campo Obligatorio");

        } else if (emailaddres.isEmpty()) {
            etemailaddres.setError("Campo Obligatorio");

        } else if (contra1.isEmpty()) {
            etcontra1.setError("Campo Obligatorio");

        } else if (contra2.isEmpty()) {
            etcontra2.setError("Campo Obligatorio");
        } //else if (contra1 != contra2 ){
            //etcontra2.setError("Contraseñas no coinciden");}
         else {

            //Si las sentencias anteriories no ecumplen efectua el ingreso de los datos a la base
            db.insert("users",null,values);
            db.close();

            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, bienvenida.class);
            startActivity(i);

        }
    }
}


