package com.example.momotoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Envio de pantalla a otra cuando termina los 3 segundos del splash screen
        TimerTask time = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(time, 3000);

    }
}