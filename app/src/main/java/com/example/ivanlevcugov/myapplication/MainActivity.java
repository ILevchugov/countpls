package com.example.ivanlevcugov.myapplication;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void rejim1(View view) {
        Intent intent = new Intent(MainActivity.this, mode2.class);
        startActivity(intent);

    }

    public void rejim2(View view) {
        Intent intent = new Intent(MainActivity.this, mode1.class);
        startActivity(intent);

    }

    public void rejim3(View v) {



    }
}
