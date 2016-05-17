package com.example.ivanlevcugov.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class lvl1 extends Activity {
    Button button1, button2, button3, button4;
    ImageButton begin;
    TextView tv, resultview, lifetv, recordview;
    Random r;
    int pokazatel;
    int a, b, c, i, x, r1, life, result, record;
    int n = 4;
    String records;
    String counters;
    int mass[] = new int[n];
    String s1, s2;
    // timer
    private static final int MILLIS_PER_SECOND = 1000;
    private static final int SECONDS_TO_COUNTDOWN = 5;
    private TextView countdownDisplay;
    private CountDownTimer timer;

    //record
    public SharedPreferences mSettings2;

    public static  String APP_PREFERENCES; //= "mysettings2";
    public static  String APP_PREFERENCES_COUNTER;// = "counter2";
    int mCounter1;

    //всплывающее окно
    AlertDialog.Builder ad;
    Context context;



    public void end()
    {
        begin.setEnabled(true);
        countdownDisplay.setText("Timer");
        timer.cancel();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
      /*  Intent intent = new Intent(this, prosto.class);
        intent.putExtra("result", result);
        startActivity(intent);*/
        ad.setTitle("ваш результат" + result);
        ad.show(); //всплывающее
    }
    private void showTimer1(int countdownMillis)
    {
        if(timer != null) { timer.cancel(); }
        timer = new CountDownTimer(countdownMillis, MILLIS_PER_SECOND) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdownDisplay.setText("TIME LEFT: " +
                        millisUntilFinished / MILLIS_PER_SECOND);
            }
            @Override
            public void onFinish() {
                life--;
                if (life == 0)
                {
                    end();
                    lifetv.setText("lifes: "+life);
                }
                if (life > 0 )
                {
                    try {
                        showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
                    } catch (NumberFormatException e) {
                        // method ignores invalid (non-integer) input and waits
                        // for something it can use
                    }
                    if (life >= 0 )
                    {
                        lifetv.setText("lifes: "+life);
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        pokazatel = getIntent().getExtras().getInt("lvl",pokazatel);
        if (pokazatel==1){
            records="mysettings2";
            counters="counter2";
             r1=10;

        }
        if (pokazatel==2){
            records="mysettings3";
            counters="counter3";
            r1=50;

        }
        if (pokazatel==3){
            records="mysettings4";
            counters="counter4";
            r1=100;

        }
        if (pokazatel==4){
            records="mysettings5";
            counters="counter5";
            r1=500;

        }
        if (pokazatel==5){
            records="mysettings6";
            counters="counter6";
            r1=1000;

        }
        APP_PREFERENCES=records;
        APP_PREFERENCES_COUNTER=counters;
        mSettings2=getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        a=0;b=0;c=0;result=0;x=0;
        button1 = (Button) findViewById(R.id.button1);//lefttop
        button1.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        button1.setEnabled(false);
        button2 = (Button) findViewById(R.id.button2);//righttop
        button2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        button2.setEnabled(false);
        button3 = (Button) findViewById(R.id.button3);//leftbottom
        button3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        button3.setEnabled(false);
        button4 = (Button) findViewById(R.id.button4);//rightbottom
        button4.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        button4.setEnabled(false);
        begin = (ImageButton) findViewById(R.id.begin);
        tv   = (TextView) findViewById(R.id.textView);//answer right now
        tv.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        lifetv   = (TextView) findViewById(R.id.textView3);//life
        lifetv.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        resultview = (TextView) findViewById(R.id.textView2);//result right now
        resultview.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        recordview = (TextView) findViewById(R.id.recordView);//result right now
        recordview.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        countdownDisplay = (TextView) findViewById(R.id.timer);//timer
        countdownDisplay.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));

        context = lvl1.this;
        String title = "your result: "+result;
        String message = "You lost. Don't worry, play again?";
        String button1String = "В главное меню";
        String button2String = "Начать снова";

        ad = new AlertDialog.Builder(context);
        ad.setTitle(title);  // заголовок
        ad.setMessage(message); // сообщение
        ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) { //главное меню

                Intent intent = new Intent(lvl1.this, MainActivity.class);
                startActivity(intent);

            }
        });
        ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Жаль!", Toast.LENGTH_LONG).show();
               /* Intent intent = new Intent(mode2.this, prosto.class);
                startActivity(intent);*/
                life = 3;


                lifetv.setText("lifes: " + life);
                result = 0;
                resultview.setText("" + result);
            }
        });
        ad.setCancelable(false);
        ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(context, "Жаль", Toast.LENGTH_LONG).show();
             /*  Intent intent = new Intent(mode2.this, prosto.class);
                startActivity(intent);*/
                life = 3;
                try {
                    showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
                } catch (NumberFormatException e) {
                    // method ignores invalid (non-integer) input and waits
                    // for something it can use
                }
                lifetv.setText("lifes: " + life);
                result = 0;
                resultview.setText("" + result);
            }
        });



        /*try {
            showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
        } catch (NumberFormatException e) {
            // method ignores invalid (non-integer) input and waits
            // for something it can use
        }*/
        r = new Random();
        life = 3;
        lifetv.setText("lifes:"+life);
        countdownDisplay.setText("Time");
        tv.setText("Examples");
        record =mSettings2.getInt(APP_PREFERENCES_COUNTER, 0);
        recordview.setText("record: "+record);
        //numgenerate();//generate generate
        begin.setEnabled(true);

    }
    public void generate1()//generate +
    {

        a = r.nextInt(r1)+1;
        b = r.nextInt(r1)+1;
        c = a + b;

        for (i = 0; i<n-1; i++)
        {
            if (c<=15)
            {
                mass[i] = c + (r.nextInt(10)-5);
                if (mass[i] == c)
                {
                    while (mass[i] == c)
                    {
                        mass[i] = c + (r.nextInt(10)-5);
                    }
                }
            }

            if ((c>15) && (c<50))
            {

                mass[i] = c + (r.nextInt(20)-10);
                if (mass[i] == c)
                {
                    while (mass[i] == c)
                    {
                        mass[i] = c + (r.nextInt(10)-5);
                    }
                }
            }

            if (c>=50)
            {
                mass[i] = c + (r.nextInt(30)-15);
                if (mass[i] == c)
                {
                    while (mass[i] == c)
                    {
                        mass[i] = c + (r.nextInt(10)-5);
                    }
                }
            }
        }
        tv.setText(a+"+"+b+"=");
        resultview.setText(""+result);
        mass[3] = c;
        i = r.nextInt(4);

        switch (i)
        {
            case 0:
            {
                button1.setText(""+mass[0]);
                button2.setText(""+mass[1]);
                button3.setText(""+mass[2]);
                button4.setText(""+mass[3]);
                break;
            }
            case 1:
            {

                button1.setText(""+mass[1]);
                button2.setText(""+mass[2]);
                button3.setText(""+mass[3]);
                button4.setText(""+mass[0]);
                break;
            }
            case 2:
            {
                button1.setText(""+mass[2]);
                button2.setText(""+mass[3]);
                button3.setText(""+mass[0]);
                button4.setText(""+mass[1]);
                break;

            }
            case 3:
            {
                button1.setText(""+mass[3]);
                button2.setText(""+mass[0]);
                button3.setText(""+mass[1]);
                button4.setText(""+mass[2]);
                break;
            }
        }

    }
    public void onClick1 (View view)
    {
        switch (i)
        {
            case 0: x = mass[0];break;
            case 1: x = mass[1];break;
            case 2: x = mass[2];break;
            case 3: x = mass[3];break;
        }
        if ( x == mass[3])
        {
            result++;
            if (result > record)
            {
                record = result;
                recordview.setText("record: "+record);
                mCounter1=record;
                SharedPreferences.Editor editor = mSettings2.edit();
                editor.putInt(APP_PREFERENCES_COUNTER, mCounter1);
                editor.apply();

            }
            resultview.setText(""+result);
        } else
        {
            life--;
            lifetv.setText("lifes: "+life);
            if (life <= 0)
            {
                timer.cancel();
                end();
            }
        }
        generate1();
        if (life!=0) {
            try {
                showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
                // method ignores invalid (non-integer) input and waits
                // for something it can use
            }
        }
    }

    public void onClick2 (View view)
    {
        switch (i)
        {
            case 0: x = mass[1];break;
            case 1: x = mass[2];break;
            case 2: x = mass[3];break;
            case 3: x = mass[0];break;
        }
        if (x == mass[3])
        {
            result++;
            if (result > record)
            {
                record = result;
                recordview.setText("record: "+record);
                mCounter1=record;
                SharedPreferences.Editor editor = mSettings2.edit();
                editor.putInt(APP_PREFERENCES_COUNTER, mCounter1);
                editor.apply();

            }
            resultview.setText(""+result);
        } else
        {
            life--;
            lifetv.setText("lifes: "+life);
            if (life <= 0)
            {
                timer.cancel();
                end();
            }
        }
        if (life!=0) {
            try {
                showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
                // method ignores invalid (non-integer) input and waits
                // for something it can use
            }
        }
        generate1();
    }

    public void onClick3 (View view)
    {
        switch (i)
        {
            case 0: x = mass[2];break;
            case 1: x = mass[3];break;
            case 2: x = mass[0];break;
            case 3: x = mass[1];break;
        }
        if (x == mass[3])
        {
            result++;
            if (result > record)
            {
                record = result;
                recordview.setText("record: "+record);
                mCounter1=record;
                SharedPreferences.Editor editor = mSettings2.edit();
                editor.putInt(APP_PREFERENCES_COUNTER, mCounter1);
                editor.apply();

            }
            resultview.setText(""+result);
        } else
        {
            life--;
            lifetv.setText("lifes: "+life);
            if (life <= 0)
            {timer.cancel();
                end();
            }
        }
        if (life!=0) {
            try {
                showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
                // method ignores invalid (non-integer) input and waits
                // for something it can use
            }
        }
        generate1();
    }

    public void onClick4 (View view)
    {
        switch (i)
        {
            case 0: x = mass[3];break;
            case 1: x = mass[0];break;
            case 2: x = mass[1];break;
            case 3: x = mass[2];break;
        }
        if (x == mass[3])
        {
            result++;
            if (result > record)
            {
                record = result;
                recordview.setText("record: "+record);
                mCounter1=record;
                SharedPreferences.Editor editor = mSettings2.edit();
                editor.putInt(APP_PREFERENCES_COUNTER, mCounter1);
                editor.apply();

            }
            resultview.setText(""+result);
        } else
        {
            life--;
            lifetv.setText("lifes: "+life);
            if (life <= 0)
            {
                timer.cancel();
                end();
            }
        }
        generate1();
        if (life!=0) {
            try {
                showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
                // method ignores invalid (non-integer) input and waits
                // for something it can use
            }
        }
    }
    public void begin(View view) {
        begin.setEnabled(false);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        generate1();
        try {
            showTimer1(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
        } catch (NumberFormatException e) {
            // method ignores invalid (non-integer) input and waits
            // for something it can use
        }

    }

    public void back(View view)
    {
        if(timer != null) { timer.cancel(); }
        Intent intent = new Intent(lvl1.this, sum.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed() {
        if(timer != null) { timer.cancel(); }

        finish();
    }
}
