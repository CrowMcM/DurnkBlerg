package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class Game extends MainActivity {
Button flash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_game );

        Handler h = new Handler();
        h.postDelayed(new Runnable (){
            public void run(){
                startFlash();
            }
        },3000);


}

    private void startFlash() {
        flash=(Button)findViewById (R.id.RedBtn);
        Animation mAnimation = new AlphaAnimation (1,0);

       mAnimation.setDuration ( 200 );

       mAnimation.setInterpolator ( new LinearInterpolator (  ) );

       mAnimation.setRepeatCount (5  );

       mAnimation.setRepeatMode ( Animation.REVERSE );

       flash.startAnimation ( mAnimation );

    }
}
