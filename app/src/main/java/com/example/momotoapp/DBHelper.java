package com.example.momotoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodo para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," + "firstname text NOT NULL, lastname text NOT NULL, emailaddres text NOT NULL, password1 text NOT NULL, password2 text NOT NULL)");
        db.execSQL("insert into users(firstname,lastname, emailaddres, password1, password2) values('josue','morales','josue.morales@gmail.com','admin','admin')");

    }

    //Metodo para administrar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("create table users(id_user integer  PRIMARY KEY AUTOINCREMENT NOT NULL," + "firstname text NOT NULL, lastname text NOT NULL, emailaddres text NOT NULL, password1 text NOT NULL, password2 text NOT NULL)");
        db.execSQL("insert into users(firstname,lastname, emailaddres, password1, password2) values('josue','morales','josue.morales@gmail.com','admin','admin')");

    }
}
