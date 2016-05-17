package com.example.ivanlevcugov.myapplication;



import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {


    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void rejim1(View view) {
        Intent intent = new Intent(MainActivity.this, mode1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);

    }

    public void rejim2(View view) {
        Intent intent = new Intent(MainActivity.this, mode2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
    }

    public void rejim3(View v) {
        Intent intent = new Intent(MainActivity.this, rejim3.class);
        startActivity(intent);



    }
}
