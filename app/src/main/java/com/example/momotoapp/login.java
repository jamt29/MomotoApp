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
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this ,"usuarios.db",null,1);

    private EditText  etemail, etpassword;
    private Button btnlogin;


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

    public void btnlogin(View view) {
        SQLiteDatabase bd = admin.getWritableDatabase();

        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()){
            Cursor fila = bd.rawQuery("Select email, password from usuarios where email= '" + email + "' and password='" + password + "'",null);

            if (fila.moveToFirst()){
                Intent login = new Intent(this, finish.class);
                startActivity(login);
                bd.close();
            }else{

                Toast.makeText( this, "No se encontraron datos del usuario", Toast.LENGTH_SHORT ).show();
                bd.close();
            }
        }else{
            Toast.makeText( this, "Debes introducir un correo y una contraseña", Toast.LENGTH_SHORT).show();
        }
    }


    }


