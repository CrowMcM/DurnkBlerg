package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Game extends AppCompatActivity {

    Button b_start, b_main, b_set, b_drunk;


    TextView tv_info;

    long startTime, endTime, currentTime, bestTime = 400, i =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_start = findViewById(R.id.b_start);
        b_main = findViewById(R.id.b_main);
        b_set = findViewById(R.id.b_set);
        b_drunk = findViewById(R.id.b_drunk);

        tv_info = findViewById(R.id.tv_info);

        b_start.setEnabled(false);
        b_main.setEnabled(false);
        b_set.setEnabled(true);
        b_drunk.setEnabled(true);
        b_main.setText("Please set average time");


        tv_info.setText("SOBER TIME " + bestTime);

        b_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                b_start.setEnabled(false);
                b_main.setText("");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        startTime = System.currentTimeMillis();
                        b_main.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.blue));
                        b_main.setText("PRESS");
                        b_main.setEnabled(true);
                    }
                }, 2000);

                b_main.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endTime = System.currentTimeMillis();
                        currentTime = endTime - startTime;
                        b_main.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.red));
                        b_main.setText(currentTime + "ms");
                        b_start.setEnabled(true);
                        b_main.setEnabled(false);

                        if(currentTime >= (bestTime + i) || currentTime <= (bestTime - i)){
                            b_main.setText("You failed try again in ten seconds" +currentTime+"ms");
                            b_start.setEnabled(false);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable(){
                                @Override
                                public void run(){
                                    b_start.setEnabled(true);
                                }
                            }, 10000);
                        }
                        else{
                            b_main.setText("Success "+currentTime+"ms");
                            b_set.setEnabled(true);
                            b_start.setEnabled(false);
                            b_drunk.setEnabled(true);
                        }
                    }
                });
            }
        });

        b_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_set.setEnabled(false);
                b_drunk.setEnabled(false);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        startTime = System.currentTimeMillis();
                        b_main.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.blue));
                        b_main.setText("PRESS");
                        b_main.setEnabled(true);
                    }
                }, 2000);



                b_main.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endTime = System.currentTimeMillis();
                        currentTime = endTime - startTime;
                        b_main.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.red));
                        b_main.setText(currentTime + "ms");
                        b_main.setEnabled(false);

                        //if(currentTime < bestTime){
                        bestTime = currentTime;
                        tv_info.setText("SOBER TIME: " + bestTime + "ms");


                        //}
                        b_drunk.setEnabled(true);
                        b_set.setEnabled(true);
                    }
                });



            }
        });

        b_drunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_start.setEnabled(true);
                b_drunk.setEnabled(false);
                b_set.setEnabled(false);
            }
        });


    }
}