package com.example.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Medium extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(Medium.this, HomeScreen.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private int arr[] = {0, 1, 0, 1, 0, 1, 0, 1, 0};
    private int check[] = {123, 147, 159, 213, 258, 321, 369, 357, 231, 312, 471, 714, 591, 915, 132, 321, 582, 825,
            693, 936, 573, 735, 417, 174, 195, 285, 396, 375, 456, 465, 528, 519, 537, 546, 564, 639, 654, 645, 741,
            789, 798, 753, 852, 879, 897, 951, 963, 987, 978};
    private int img[] = {R.drawable.zero, R.drawable.cross};
    public int i = 0,m=0,you=0;
    public int comp=0,c=0,flag=0;
    public int r;
    MediaPlayer mp,sad;
    ConstraintLayout cons;
    TextView turnText;
    Button reset;
    int clickable[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    ImageView imageView[] = {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        turnText = findViewById(R.id.turntext);
        turnText.setText("YOUR TURN");
        reset = findViewById(R.id.reset);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Vs COMPUTER (H)");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        cons=findViewById(R.id.cons);
        mp=MediaPlayer.create(this,R.raw.fire);
        sad=MediaPlayer.create(this,R.raw.sad);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
            }
        });
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageView[0] = imageView1;
        imageView[1] = imageView2;
        imageView[2] = imageView3;
        imageView[3] = imageView4;
        imageView[4] = imageView5;
        imageView[5] = imageView6;
        imageView[6] = imageView7;
        imageView[7] = imageView8;
        imageView[8] = imageView9;

        imageView1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView1.setTranslationY(-500f);
                    imageView1.setImageResource(img[arr[i]]);
                    imageView1.animate().translationYBy(500f).setDuration(100);
                    imageView1.setClickable(false);
                    clickable[0] = 0;
                    you=you*10+1;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }

                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView2.setTranslationY(-500f);
                    imageView2.setImageResource(img[arr[i]]);
                    imageView2.animate().translationYBy(500f).setDuration(100);
                    imageView2.setClickable(false);
                    clickable[1] = 0;
                    you=you*10+2;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }


                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView3.setTranslationY(-500f);
                    imageView3.setImageResource(img[arr[i]]);
                    imageView3.animate().translationYBy(500f).setDuration(100);
                    imageView3.setClickable(false);
                    clickable[2] = 0;
                    you=you*10+3;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView4.setTranslationY(-500f);
                    imageView4.setImageResource(img[arr[i]]);
                    imageView4.animate().translationYBy(500f).setDuration(100);
                    imageView4.setClickable(false);
                    clickable[3] = 0;
                    you=you*10+4;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView5.setTranslationY(-500f);
                    imageView5.setImageResource(img[arr[i]]);
                    imageView5.animate().translationYBy(500f).setDuration(100);
                    imageView5.setClickable(false);
                    clickable[4] = 0;
                    you=you*10+5;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView6.setTranslationY(-500f);
                    imageView6.setImageResource(img[arr[i]]);
                    imageView6.animate().translationYBy(500f).setDuration(100);
                    imageView6.setClickable(false);
                    clickable[5] = 0;
                    you=you*10+6;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }


                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView7.setTranslationY(-500f);
                    imageView7.setImageResource(img[arr[i]]);
                    imageView7.animate().translationYBy(500f).setDuration(100);
                    imageView7.setClickable(false);
                    clickable[6] = 0;
                    you=you*10+7;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView8.setTranslationY(-500f);
                    imageView8.setImageResource(img[arr[i]]);
                    imageView8.animate().translationYBy(500f).setDuration(100);
                    imageView8.setClickable(false);
                    clickable[7] = 0;
                    you=you*10+8;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (i < 9) {
                    imageView9.setTranslationY(-500f);
                    imageView9.setImageResource(img[arr[i]]);
                    imageView9.animate().translationYBy(500f).setDuration(100);
                    imageView9.setClickable(false);
                    clickable[8] = 0;
                    you=you*10+9;
                    if(you > 999)
                        you=four(you);
                    for (int j = 0; j < check.length; j++) {
                        if (you == check[j])
                        {
                            Toast.makeText(Medium.this, " You won", Toast.LENGTH_SHORT).show();
                            turnText.setText("YOU WON");
                            showPopup(v,"you");
                            click();
                            break;
                        }
                    }
                    if(turnText.getText().toString().equals("YOU WON")!=true)
                    {
                        turnText.setText("COMPUTER TURN");
                    }
                    i++;
                    m=i;
                    comp=c;
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (i < 9 && check()) {
                                flag=0;
                                String yours,mine;
                                yours=you+"";
                                mine=comp+"";
                                if(mine.length()>=2)
                                {
                                    String submine = mine.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (submine.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(mine.length()>=3 && flag==0)
                                {
                                    String submine=mine.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(submine.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        submine=mine.substring(0,1)+mine.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(submine.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(yours.length()>=2 && flag==0)
                                {
                                    String subyours = yours.substring(0, 2);
                                    for (int h = 0; h < check.length; h++) {
                                        String ch = check[h] + "";
                                        String subch = ch.substring(0, 2);
                                        if (subyours.equals(subch)) {
                                            int t = check[h] % 10;
                                            if (clickable[t - 1] == 1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                }
                                if(yours.length()>=3 && flag==0)
                                {
                                    String subyours = yours.substring(1,3);
                                    for(int h=0;h<check.length;h++)
                                    {
                                        String ch=check[h]+"";
                                        String subch=ch.substring(0,2);
                                        if(subyours.equals(subch))
                                        {
                                            int t=check[h]%10;
                                            if(clickable[t-1]==1) {
                                                r = t - 1;
                                                flag = 1;
                                                break;
                                            }
                                            else
                                                break;
                                        }
                                    }
                                    if(flag==0)
                                    {
                                        subyours=yours.substring(0,1)+yours.substring(2,3);
                                        for(int h=0;h<check.length;h++)
                                        {
                                            String ch=check[h]+"";
                                            String subch=ch.substring(0,2);
                                            if(subyours.equals(subch))
                                            {
                                                int t=check[h]%10;
                                                if(clickable[t-1]==1) {
                                                    r = t - 1;
                                                    flag = 1;
                                                    break;
                                                }
                                                else
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if(flag==0)
                                {
                                    r = new Random().nextInt(9);
                                    while (clickable[r] == 0) {
                                        r = new Random().nextInt(9);
                                    }
                                }
                                imageView[r].setTranslationY(-500f);
                                imageView[r].setImageResource(img[arr[m]]);
                                imageView[r].animate().translationYBy(500f).setDuration(100);
                                imageView[r].setClickable(false);
                                clickable[r] = 0;
                                comp=comp*10+r+1;
                                if(comp > 999)
                                    comp=four(comp);
                                c=comp;
                                for (int j = 0; j < check.length; j++) {
                                    if (comp == check[j])
                                    {
                                        Toast.makeText(Medium.this, " Computer won", Toast.LENGTH_SHORT).show();
                                        turnText.setText("COMPUTER WON");
                                        showPopup(v,"comp");
                                        click();
                                        break;
                                    }
                                }
                                if(turnText.getText().toString().equals("COMPUTER WON")!=true)
                                {
                                    turnText.setText("YOUR TURN");
                                }
                            }
                        }
                    }.start();
                    if(i==9 && (turnText.getText().toString().equals("YOUR TURN") ||
                            turnText.getText().toString().equals("COMPUTER TURN") ))
                    {
                        turnText.setText("MATCH DRAWN");
                        Toast.makeText(Medium.this, "Match Drawn", Toast.LENGTH_SHORT).show();
                    }
                }
                i++;
            }
        });
    }

    public void replay() {

        i = 0;
        you=0;
        comp=0;
        c=0;
        imageView1.setImageResource(android.R.color.transparent);
        imageView2.setImageResource(android.R.color.transparent);
        imageView3.setImageResource(android.R.color.transparent);
        imageView4.setImageResource(android.R.color.transparent);
        imageView5.setImageResource(android.R.color.transparent);
        imageView6.setImageResource(android.R.color.transparent);
        imageView7.setImageResource(android.R.color.transparent);
        imageView8.setImageResource(android.R.color.transparent);
        imageView9.setImageResource(android.R.color.transparent);

        imageView1.setClickable(true);
        imageView2.setClickable(true);
        imageView3.setClickable(true);
        imageView4.setClickable(true);
        imageView5.setClickable(true);
        imageView6.setClickable(true);
        imageView7.setClickable(true);
        imageView8.setClickable(true);
        imageView9.setClickable(true);

        turnText.setText("YOUR TURN");
        turnText.setVisibility(View.VISIBLE);
        for (int l = 0; l < clickable.length; l++) {
            clickable[l] = 1;
        }

        mp.stop();
        sad.stop();
    }

    public void click() {
        imageView1.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        imageView4.setClickable(false);
        imageView5.setClickable(false);
        imageView6.setClickable(false);
        imageView7.setClickable(false);
        imageView8.setClickable(false);
        imageView9.setClickable(false);

        for (int n = 0; n < clickable.length; n++) {
            clickable[n] = 0;
        }

    }

    public int four(int n) {
        int n1 = n;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (n > 0) {
            arrayList.add(n % 10);
            n = n / 10;
        }
        Collections.sort(arrayList);
        for (int j = 0; j < check.length; j++) {
            int ct = 0;
            int sum = 0;
            int c = check[j];
            while (c > 0) {
                int d = c % 10;
                for (int k = 0; k < arrayList.size(); k++) {
                    if (arrayList.get(k) == d) {
                        sum = sum * 10 + d;
                        ct++;
                        break;
                    }
                }
                c = c / 10;
            }
            if (ct == 3) {
                return sum;
            }
        }
        return n1;
    }
    public boolean check()
    {
        if(clickable[0]==1 || clickable[1]==1 || clickable[2]==1 || clickable[3]==1 ||clickable[4]==1
                ||clickable[5]==1 ||clickable[6]==1 ||clickable[7]==1 ||clickable[8]==1)
        {
            return true;
        }
        return false;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showPopup(View v, String text)
    {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        View popup=getLayoutInflater().inflate(R.layout.popcomp,null);
        ImageView hu=popup.findViewById(R.id.hurray);
        TextView what=popup.findViewById(R.id.what);
        TextView woo=popup.findViewById(R.id.woo);
        Button play=popup.findViewById(R.id.play);
        Button quit=popup.findViewById(R.id.quit);
        int height=LinearLayout.LayoutParams.WRAP_CONTENT;
        if(text.equals("you"))
        {
            mp.start();
            hu.setImageResource(R.drawable.party);
            what.setText("YOU WON");
            what.setTextColor(Color.parseColor("#60AF0D"));
            woo.setText("WooHoo!");
        }
        else if(text.equals("comp"))
        {
            sad.start();
            hu.setImageResource(R.drawable.cry);
            what.setText("YOU LOSE");
            what.setTextColor(Color.parseColor("#CA0E0A"));
            woo.setText("OhNOO!");
        }
        PopupWindow popupWindow=new PopupWindow(popup,width-100,height,false);
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);
        cons.setAlpha(0.2f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                cons.setAlpha(1);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                replay();
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Medium.this,HomeScreen.class));
            }
        });
    }
}