package com.example.tictactoe;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button computer=findViewById(R.id.computer);
        Button multi=findViewById(R.id.multiplayer);
        LinearLayout hs=findViewById(R.id.homescreen);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popup=getLayoutInflater().inflate(R.layout.popchoice,null);
                Button easy=popup.findViewById(R.id.play);
                Button hard=popup.findViewById(R.id.quit);
                PopupWindow popupWindow=new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAtLocation(v, Gravity.CENTER,0,0);
                hs.setAlpha(0.2f);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        hs.setAlpha(1);
                    }
                });
                easy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        startActivity(new Intent(HomeScreen.this,computerScreen.class));
                    }
                });
                hard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        startActivity(new Intent(HomeScreen.this,Medium.class));
                    }
                });
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}