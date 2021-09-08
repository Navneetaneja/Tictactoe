package com.example.tictactoe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ImageView img=findViewById(R.id.splash);
        img.setImageResource(R.mipmap.icon);
        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                Intent i=new Intent(SplashScreen.this ,HomeScreen.class);

                startActivity(i);

                finish();

            }

        }, SPLASH_SCREEN_TIME_OUT);
    }
}