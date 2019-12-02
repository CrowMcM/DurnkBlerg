package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Game extends AppCompatActivity {

    Button b_test, b_main, b_set, b_drunk, b_main2, b_main3, b_main4;


    TextView tv_info, tv_info2;

    long startTime, endTime, currentTime, bestTime = 400, i =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_test = findViewById(R.id.b_test);
        b_main = findViewById(R.id.b_main);
        b_main2 = findViewById(R.id.b_main2);
        b_main3 = findViewById(R.id.b_main3);
        b_main4 = findViewById(R.id.b_main4);
        b_set = findViewById(R.id.b_set);
        b_drunk = findViewById(R.id.b_drunk);

        tv_info = findViewById(R.id.tv_info);
        tv_info2 = findViewById(R.id.tv_info2);

        b_test.setEnabled(false);
        b_main.setEnabled(false);
        b_main2.setEnabled(false);
        b_main3.setEnabled(false);
        b_main4.setEnabled(false);
        b_set.setEnabled(true);
        b_drunk.setEnabled(false);
        tv_info2.setText("Please set average time");


        tv_info.setText("SOBER TIME "+bestTime+"ms");



        b_test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv_info2.setText("Press when blue");
                b_main.setText("");
                b_main2.setText("");
                b_main3.setText("");
                b_main4.setText("");
                Random r = new Random();
                int number;

                b_test.setEnabled(false);
                b_main.setText("");

                for(int counter = 0; counter <1; counter++ ) {
                    number = r.nextInt(4);
                    System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy" + number);

                    if (number == 0) {

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
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
                                        ContextCompat.getColor(getApplicationContext(), R.color.yellow));
                                b_main.setText(currentTime + "ms");
                                b_test.setEnabled(true);
                                b_main.setEnabled(false);

                                if (currentTime >= (bestTime + i) || currentTime <= (bestTime - i)) {
                                    b_main.setText("You failed try again in ten seconds " + currentTime + "ms");
                                    b_test.setEnabled(false);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b_test.setEnabled(true);
                                        }
                                    }, 10000);
                                } else {
                                    b_main.setText("Success " + currentTime + "ms");
                                    b_set.setEnabled(true);
                                    b_test.setEnabled(false);
                                    b_drunk.setEnabled(true);
                                }
                            }
                        });
                    }

                    if (number == 1) {

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main2.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main2.setText("PRESS");
                                b_main2.setEnabled(true);
                            }
                        }, 2000);

                        b_main2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main2.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.pink));
                                b_main2.setText(currentTime + "ms");
                                b_test.setEnabled(true);
                                b_main2.setEnabled(false);

                                if (currentTime >= (bestTime + i) || currentTime <= (bestTime - i)) {
                                    b_main2.setText("You failed try again in ten seconds " + currentTime + "ms");
                                    b_test.setEnabled(false);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b_test.setEnabled(true);
                                        }
                                    }, 10000);
                                } else {
                                    b_main2.setText("Success " + currentTime + "ms");
                                    b_set.setEnabled(true);
                                    b_test.setEnabled(false);
                                    b_drunk.setEnabled(true);
                                }
                            }
                        });
                    }

                    if (number == 2) {

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main3.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main3.setText("PRESS");
                                b_main3.setEnabled(true);
                            }
                        }, 2000);

                        b_main3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main3.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.green));
                                b_main3.setText(currentTime + "ms");
                                b_test.setEnabled(true);
                                b_main3.setEnabled(false);

                                if (currentTime >= (bestTime + i) || currentTime <= (bestTime - i)) {
                                    b_main3.setText("You failed try again in ten seconds " + currentTime + "ms");
                                    b_test.setEnabled(false);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b_test.setEnabled(true);
                                        }
                                    }, 10000);
                                } else {
                                    b_main3.setText("Success " + currentTime + "ms");
                                    b_set.setEnabled(true);
                                    b_test.setEnabled(false);
                                    b_drunk.setEnabled(true);
                                }
                            }
                        });
                    }

                    if (number == 3) {

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main4.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main4.setText("PRESS");
                                b_main4.setEnabled(true);
                            }
                        }, 2000);

                        b_main4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main4.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.orange));
                                b_main4.setText(currentTime + "ms");
                                b_test.setEnabled(true);
                                b_main4.setEnabled(false);

                                if (currentTime >= (bestTime + i) || currentTime <= (bestTime - i)) {
                                    b_main4.setText("You failed try again in ten seconds " + currentTime + "ms");
                                    b_test.setEnabled(false);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b_test.setEnabled(true);
                                        }
                                    }, 10000);
                                } else {
                                    b_main4.setText("Success " + currentTime + "ms");
                                    b_set.setEnabled(true);
                                    b_test.setEnabled(false);
                                    b_drunk.setEnabled(true);
                                }
                            }
                        });
                    }
                }
                tv_info2.setText("Please set average time");
            }
        });

        b_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info2.setText("Press when blue");
                b_main.setText("");
                b_main2.setText("");
                b_main3.setText("");
                b_main4.setText("");
                Random r = new Random();
                int number;

                b_set.setEnabled(false);
                b_drunk.setEnabled(false);

                for(int counter = 0; counter <1; counter++ ) {
                    number = r.nextInt(4);
                    System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+number);

                    if(number == 0) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
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
                                        ContextCompat.getColor(getApplicationContext(), R.color.yellow));
                                b_main.setText(currentTime + "ms");
                                b_main.setEnabled(false);
                                bestTime = currentTime;
                                tv_info.setText("SOBER TIME: " + bestTime + "ms");
                                b_drunk.setEnabled(true);
                                b_set.setEnabled(true);
                                tv_info2.setText("Activate drunk mode");
                            }
                        });
                    }

                    if(number == 1) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main2.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main2.setText("PRESS");
                                b_main2.setEnabled(true);
                            }
                        }, 2000);


                        b_main2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main2.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.pink));
                                b_main2.setText(currentTime + "ms");
                                b_main2.setEnabled(false);
                                bestTime = currentTime;
                                tv_info.setText("SOBER TIME: " + bestTime + "ms");
                                b_drunk.setEnabled(true);
                                b_set.setEnabled(true);
                                tv_info2.setText("Activate drunk mode");
                            }
                        });
                    }

                    if(number == 2) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main3.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main3.setText("PRESS");
                                b_main3.setEnabled(true);
                            }
                        }, 2000);


                        b_main3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main3.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.green));
                                b_main3.setText(currentTime + "ms");
                                b_main3.setEnabled(false);
                                bestTime = currentTime;
                                tv_info.setText("SOBER TIME: " + bestTime + "ms");
                                b_drunk.setEnabled(true);
                                b_set.setEnabled(true);
                                tv_info2.setText("Activate drunk mode");
                            }
                        });
                    }

                    if(number == 3) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startTime = System.currentTimeMillis();
                                b_main4.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                b_main4.setText("PRESS");
                                b_main4.setEnabled(true);
                            }
                        }, 2000);


                        b_main4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                endTime = System.currentTimeMillis();
                                currentTime = endTime - startTime;
                                b_main4.setBackgroundColor(
                                        ContextCompat.getColor(getApplicationContext(), R.color.orange));
                                b_main4.setText(currentTime + "ms");
                                b_main4.setEnabled(false);
                                bestTime = currentTime;
                                tv_info.setText("SOBER TIME: " + bestTime + "ms");
                                b_drunk.setEnabled(true);
                                b_set.setEnabled(true);
                                tv_info2.setText("Activate drunk mode");
                            }
                        });
                    }
                }


            }
        });

        b_drunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info2.setText("Test yourself");
                b_main.setText("");
                b_main2.setText("");
                b_main3.setText("");
                b_main4.setText("");
                b_test.setEnabled(true);
                b_drunk.setEnabled(false);
                b_set.setEnabled(false);
            }
        });


    }
}