package com.mj.globaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mj.globaltest.Home;


public class Splash extends Activity {

    private static int SPLASH_DURATION = 1100;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(Splash.this, Home.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_DURATION);
    }
}
