package com.example.momotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    private EditText  etemail, etpassword;
    private Button btnlogin;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = (EditText) findViewById(R.id.etemail);
        etpassword = (EditText) findViewById(R.id.etpassword);

    }

    public void newaccount(View view) {
        Intent i = new Intent(login.this, newaccount.class);
        startActivity(i);
    }



    public void btnlogin(View view) {

         DBHelper admin = new DBHelper(this, "usuarios", null, 1);

        SQLiteDatabase db = admin.getWritableDatabase();

        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        fila = db.rawQuery("select emailaddres, password1 from users where emailaddres='"+email+"' and password1='"+password+"'",null);

        try {
            if (fila.moveToFirst()){
                String usua = fila.getString(0);
                String pass = fila.getString(1);

                if (email.equals(usua)&&password.equals(pass)){
                    Intent i = new Intent(this, bienvenida.class);
                    startActivity(i);
                    etemail.setText("");
                    etpassword.setText("");
                }
            } else {
                Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                //mostramos el toast
                toast.show();
            }

        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);
            //mostramos el mensaje
            toast.show();

            }


    }


    }


