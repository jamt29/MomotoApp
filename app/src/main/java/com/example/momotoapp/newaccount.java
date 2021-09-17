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
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios.db", null, 1);

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
        SQLiteDatabase bd = admin.getWritableDatabase();

        String firstname = etfirstname.getText().toString();
        String lastname = etlastname.getText().toString();
        String emailaddres = etemailaddres.getText().toString();
        String contra1 = etcontra1.getText().toString();
        String contra2 = etcontra2.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("firstname", firstname);
        registro.put("lastname", lastname);
        registro.put("emailaddres", emailaddres);
        registro.put("contra1", contra1);
        registro.put("contra2", contra2);

        if (firstname.isEmpty()) {
            etfirstname.setError("Campo Obligatorio");
            etfirstname.requestFocus();
        } else if (lastname.isEmpty()) {
            etlastname.setError("Campo Obligatorio");
            etlastname.requestFocus();
        } else if (emailaddres.isEmpty()) {
            etemailaddres.setError("Campo Obligatorio");
            etemailaddres.requestFocus();
        } else if (contra1.isEmpty()) {
            etcontra1.setError("Campo Obligatorio");
            etcontra1.requestFocus();
        } else if (contra2.isEmpty()) {
            etcontra2.setError("Campo Obligatorio");
            etcontra2.requestFocus();
        }/* else if (contra1 != contra2) {
            etcontra2.setError("Contraseñas no coinciden");
            etcontra2.requestFocus();
            if (!contra1.equals(contra2)){
                etcontra2.setError(null);
            }
        }*/ else

                bd.insert("usuarios", null, registro);
                bd.close();
            /*etfirstname.setText(null);
            etlastname.setText(null);
            etemailaddres.setText(null);
            etcontra1.setText(null);
            etcontra2.setText(null);*/

                Intent i = new Intent(newaccount.this, bienvenida.class);
                startActivity(i);

            }
        }


