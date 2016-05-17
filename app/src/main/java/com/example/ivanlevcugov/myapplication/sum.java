package com.example.ivanlevcugov.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sum extends Activity {
    Button lvl1,lvl2,lvl3,lvl4,lvl5;

    public SharedPreferences mSettings2;
    public static  String APP_PREFERENCES; //= "mysettings2";
    public static  String APP_PREFERENCES_COUNTER;// = "counter2";
int record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        lvl1= (Button) findViewById(R.id.button9);
        lvl2= (Button) findViewById(R.id.button10);
        lvl3= (Button) findViewById(R.id.button11);
        lvl4= (Button) findViewById(R.id.button12);
        lvl5= (Button) findViewById(R.id.button13);

        for(int i=2; i<=6; i++) {

            APP_PREFERENCES = "mysettings"+i;
            APP_PREFERENCES_COUNTER = "counter"+i;
            //record=5;
            //SharedPreferences.Editor editor = mSettings2.edit();
            mSettings2=getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);


            record = mSettings2.getInt(APP_PREFERENCES_COUNTER, 0);
           if ((record < 10) && (i==2)) {
                lvl2.setEnabled(false);

            }
            if ((record < 20) && (i==3)) {
                lvl3.setEnabled(false);

            }
            if ((record < 20) && (i==4)) {
                lvl4.setEnabled(false);

            }
            if ((record < 10) && (i==5)) {
                lvl5.setEnabled(false);

            }
        }


    }

    public void level1(View view){
        Intent intent = new Intent(sum.this, lvl1.class);

        intent.putExtra("lvl", 1);
        startActivity(intent);

    }
    public void level2(View view){

        Intent intent = new Intent(sum.this, lvl1.class);

        intent.putExtra("lvl", 2);
        startActivity(intent);

    }
    public void level3(View view){
        Intent intent = new Intent(sum.this, lvl1.class);

        intent.putExtra("lvl", 3);
        startActivity(intent);

    }
    public void level4(View view){
        Intent intent = new Intent(sum.this, lvl1.class);

        intent.putExtra("lvl", 4);
        startActivity(intent);

    }
    public void level5(View view){
        Intent intent = new Intent(sum.this, lvl1.class);

        intent.putExtra("lvl", 5);
        startActivity(intent);

    }






}
