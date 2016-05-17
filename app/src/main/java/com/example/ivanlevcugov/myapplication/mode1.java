package com.example.ivanlevcugov.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class mode1 extends Activity {



    AlertDialog.Builder ad;
    Context context;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    int mCounter;


    public SharedPreferences mSettings;
    int record;
    int lifes=3;
    String[] correct = new String[1000];
    String[] incorrect = new String[1000];
    private static final int MILLIS_PER_SECOND = 1000;
    private static final int SECONDS_TO_COUNTDOWN = 4;
    private TextView countdownDisplay;
    private CountDownTimer timer;
    String[] voprosi = new String[1000];
    Random r = new Random();
    public TextView textView2;
    public TextView textView;
    public TextView textView3;
    public TextView textView5;
    public Button button1;
    public ImageButton button2;
    public ImageButton button3;
    int n = r.nextInt(21) + 0;
    int v = n;
    int z = n;
    int k = 0;
    int pok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
        setContentView(R.layout.activity_mode1);
        Intent intent=getIntent();



        // Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.

        mSettings=getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        context =mode1.this;
        String msg = "Game Over";
        String button11 = "Попытваться снова";
        String button22 = "В главное меню";
        ad = new AlertDialog.Builder(context);
        ad.setTitle(msg);
        ad.setPositiveButton(button11, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "Нажмите начать игру",
                        Toast.LENGTH_LONG).show();
            }
        });
        ad.setNegativeButton(button22, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Intent intent = new Intent(mode1.this, MainActivity.class);
                startActivity(intent);

            }
        });
        ad.setCancelable(false);

        countdownDisplay = (TextView) findViewById(R.id.textView4);
        countdownDisplay.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));


        textView = (TextView) findViewById(R.id.textView);
        textView.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/font1.ttf"));
        button1 = (Button) findViewById(R.id.button3);
        button2 = (ImageButton) findViewById(R.id.button); //нет
        button3 = (ImageButton) findViewById(R.id.button2);//да



        button2.setEnabled(false);
        button3.setEnabled(false);
        record =mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
        textView3.setText("Record"+record);
        textView.setText("Example ");
        textView2.setText("Score" + k);
        textView5.setText("Lifes" + lifes);



        for (int j = 1; j <= 999; j++) {
            int chislo1 = r.nextInt(100) + 1;
            int chislo2 = r.nextInt(chislo1) + 1;
            int znak = r.nextInt(2) + 0;
            if (znak == 1) {
                int summa = chislo1 + chislo2;
                correct[j] = chislo1 + "+" + chislo2 + "=" + summa;
                int insumma = r.nextInt(7) + summa - 5;
                if (insumma != summa) {
                    incorrect[j] = chislo1 + "+" + chislo2 + "=" + insumma;
                } else {
                    insumma =insumma +1;
                    incorrect[j] = chislo1 + "+" + chislo2 + "=" + insumma;
                }

            }
            if (znak == 0) {
                int summa = chislo1 - chislo2;
                correct[j] = chislo1 + "-" + chislo2 + "=" + summa;
                int insumma=r.nextInt(7)+summa-5;
                if (insumma != summa) {
                    incorrect[j] = chislo1 + "-" + chislo2 + "=" + insumma;
                } else {
                    insumma =insumma +1;
                    incorrect[j] = chislo1 + "-" + chislo2 + "=" + insumma;
                }

            }

        }
    }




    private void showTimer(int countdownMillis) {
        if(timer != null) { timer.cancel(); }

        timer = new CountDownTimer(countdownMillis, MILLIS_PER_SECOND) {


            public void onTick(long millisUntilFinished) {

                countdownDisplay.setText("" +
                        millisUntilFinished / MILLIS_PER_SECOND);
            }
            @Override
            public void onFinish() {
                lifes=lifes-1;

                if (lifes>0){
                    textView5.setText("Ваши жизни " + lifes);
                    {pok=r.nextInt(2)+0;
                        try {
                            showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
                        } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
                        }
                        n = r.nextInt(100) + 0;
                        textView2.setText("Счет" + k);
                        button1.setEnabled(false);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        if (pok==0) {
                            textView.setText(correct[n]);
                        }
                        else{
                            textView.setText(incorrect[n]);

                        }}
                }
                else{

                    while ((n == v) || (n == z)) {
                        n = r.nextInt(999) + 0;
                    }
                    z = v;
// textView3.setText("n"+n);
                    textView2.setText("Счет" + k);
                    if (k > record) {
                        record = k;
                    }
                    textView.setText(correct[n]);


                    ad.setMessage("В следующий раз повезет больше! ");
                    countdownDisplay.setText("Time");

                    textView5.setText("Ваши жизни " + lifes);
                    textView3.setText("Рекорд" + record);
                    textView.setText("Ваш счет " + k);
                    button1.setEnabled(true);
                    k = 0;

                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    mCounter = record;
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
                    editor.apply();
                    ad.show();

                  }}
        }.start();
    }

    public void ClickButton(View view){

        v=n;
        if (pok==1)  {
            k++;


            while ((n == v) || (n == z)) {
                n = r.nextInt(999) + 0;
            }
            try {
                showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
            }
            z = v;
            n = r.nextInt(999) + 0;
//textView3.setText("n" + n);
            if (k>record) {
                record=k;
            }
            textView3.setText("Рекорд"+record);
            textView2.setText("Счет" + k);

            pok=r.nextInt(2)+0;
            if (pok==0) {
                textView.setText(correct[n]);
            }
            else{
                textView.setText(incorrect[n]);
            }
        }
        else{
            lifes=lifes-1;
            textView5.setText("Ваши жизни " + lifes);
if (lifes>0) {pok=r.nextInt(2)+0;
    try {
        showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
    } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
    }
    n = r.nextInt(100) + 0;
    textView2.setText("Счет" + k);
    button1.setEnabled(false);
    button2.setEnabled(true);
    button3.setEnabled(true);
    if (pok==0) {
        textView.setText(correct[n]);
    }
    else{
        textView.setText(incorrect[n]);

    }}
            else{
    countdownDisplay.setText("Time");
    ad.setMessage("Ты можешь лучше!");
    if (k>record) {
        record=k;
    }
    textView3.setText("Рекорд"+record);
    textView.setText("Ваш счет " + k);
    button1.setEnabled(true);
    k=0;


    button2.setEnabled(false);
            button3.setEnabled(false);
    ad.show();
    timer.cancel();
}}
mCounter=record;
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
    }
    public void ClickButton2(View view)
    {

        v =n;
        if (pok==0) {
            k = k + 1;

            while ((n == v) || (n == z)) {
                n = r.nextInt(100) + 0;
            }
            try {
                showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
            } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
            }
            z = v;
//textView3.setText("n" + n);
            if (k>record) {
                record=k;
            }
            textView3.setText("Рекорд"+record);
            textView2.setText("счет " + k);
            pok=r.nextInt(2)+0;
            if (pok==0) {
                textView.setText(correct[n]);
            }
            else{
                textView.setText(incorrect[n]);
            }
        }
        else{

            lifes=lifes-1;
            textView5.setText("Ваши жизни " + lifes);
            if (lifes>0) {pok=r.nextInt(2)+0;
                try {
                    showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
                } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
                }
                n = r.nextInt(100) + 0;
                textView2.setText("Счет" + k);
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                if (pok==0) {
                    textView.setText(correct[n]);
                }
                else{
                    textView.setText(incorrect[n]);

                }}
            else{
                countdownDisplay.setText("Time");
                ad.setMessage("Больше стараний!");
                if (k>record) {
                    record=k;
                }
                textView3.setText("Рекорд"+record);
                textView.setText("Ваш счет " + k);
                button1.setEnabled(true);
                k=0;


                button2.setEnabled(false);
                button3.setEnabled(false);
                ad.show();
                timer.cancel();
            }}
        mCounter=record;
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
    }
    public void ClickButton3(View view){
        lifes=3;
        textView5.setText("Ваши жизни " + lifes);
        pok=r.nextInt(2)+0;
        try {
            showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
        } catch (NumberFormatException e) {
// method ignores invalid (non-integer) input and waits
// for something it can use
        }
        n = r.nextInt(100) + 0;
        textView2.setText("Счет" + k);
        button1.setEnabled(false);
        button2.setEnabled(true);
        button3.setEnabled(true);
        if (pok==0) {
            textView.setText(correct[n]);
        }
        else{
            textView.setText(incorrect[n]);
        }


    }
    public void onBackPressed() {
        if(timer != null) { timer.cancel(); }
finish();

    }

   /* protected void onStart() {
        super.onStart();
        if (mSettings.contains(APP_PREFERENCES)){
            record =mSettings.getInt(APP_PREFERENCES_COUNTER, 0);


        }
    }

    protected void onStop(){
        super.onStop();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);

        editor.apply();
    }*/



}
