package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
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

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(MainActivity.this, HomeScreen.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private int arr[]={0,1,0,1,0,1,0,1,0};
    private int check[]={123,147,159,213,258,321,369,357,231,312,471,714,591,915,132,321,582,825,
            693,936,573,735,417,174,195,285,396,375,456,465,528,519,537,546,564,639,654,645,741,
            789,798,753,852,879,897,951,963,987,978};
    private int img[]={R.drawable.zero,R.drawable.cross};
    public  int i=0;
    public  int num=0;
    public  int cr=0;
    MediaPlayer mp;
    ConstraintLayout cons;
    TextView result,turnText;
    ImageView turn,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cons=findViewById(R.id.cons);
        turn=findViewById(R.id.turn);
        mp=MediaPlayer.create(this,R.raw.fire);
        turnText=findViewById(R.id.turntext);
        turn.setImageResource(R.drawable.zero);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("MULTIPLAYER");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button reset=findViewById(R.id.reset);
        result=findViewById(R.id.result);
        result.setText("");
        result.setVisibility(View.INVISIBLE);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9)
                {
                    imageView1.setTranslationY(-500f);
                    imageView1.setImageResource(img[arr[i]]);
                    imageView1.animate().translationYBy(500f).setDuration(100);
                    imageView1.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 1;
                    else
                        cr = cr * 10 + 1;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {

                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                i++;
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView2.setTranslationY(-500f);
                    imageView2.setImageResource(img[arr[i]]);
                    imageView2.animate().translationYBy(500f).setDuration(100);
                    imageView2.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 2;
                    else
                        cr = cr * 10 + 2;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView3.setTranslationY(-500f);
                    imageView3.setImageResource(img[arr[i]]);
                    imageView3.animate().translationYBy(500f).setDuration(100);
                    imageView3.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 3;
                    else
                        cr = cr * 10 + 3;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView4.setTranslationY(-500f);
                    imageView4.setImageResource(img[arr[i]]);
                    imageView4.animate().translationYBy(500f).setDuration(100);
                    imageView4.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 4;
                    else
                        cr = cr * 10 + 4;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView5.setTranslationY(-500f);
                    imageView5.setImageResource(img[arr[i]]);
                    imageView5.animate().translationYBy(500f).setDuration(100);
                    imageView5.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 5;
                    else
                        cr = cr * 10 + 5;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView6.setTranslationY(-500f);
                    imageView6.setImageResource(img[arr[i]]);
                    imageView6.animate().translationYBy(500f).setDuration(100);
                    imageView6.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 6;
                    else
                        cr = cr * 10 + 6;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView7.setTranslationY(-500f);
                    imageView7.setImageResource(img[arr[i]]);
                    imageView7.animate().translationYBy(500f).setDuration(100);
                    imageView7.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 7;
                    else
                        cr = cr * 10 + 7;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView8.setTranslationY(-500f);
                    imageView8.setImageResource(img[arr[i]]);
                    imageView8.animate().translationYBy(500f).setDuration(100);
                    imageView8.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 8;
                    else
                        cr = cr * 10 + 8;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(i<9) {
                    imageView9.setTranslationY(-500f);
                    imageView9.setImageResource(img[arr[i]]);
                    imageView9.animate().translationYBy(500f).setDuration(100);
                    imageView9.setClickable(false);
                    if(arr[i]==0)
                    {
                        turn.setImageResource(R.drawable.cross);
                    }
                    else {
                        turn.setImageResource(R.drawable.zero);
                    }
                    if (arr[i] == 0)
                        num = num * 10 + 9;
                    else
                        cr = cr * 10 + 9;
                    if(num > 999)
                        num=four(num);
                    if(cr>999)
                        cr=four(cr);
                    for (int j = 0; j < check.length; j++) {
                        if (num == check[j] || cr == check[j]) {
                            if (num == check[j]) {
                                Toast.makeText(MainActivity.this, " Zero won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : ZERO WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"zero");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Cross won", Toast.LENGTH_SHORT).show();
                                result.setText("RESULT : CROSS WON");
                                result.setVisibility(View.VISIBLE);
                                showPopup(v,"cross");
                            }
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            click();
                            break;
                        }
                    }
                    if(i==8)
                    {
                        if(result.getText().toString().equals(""))
                        {
                            turn.setVisibility(View.INVISIBLE);
                            turnText.setVisibility((View.INVISIBLE));
                            result.setText("MATCH DRAWN");
                            result.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Match drawn", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                i++;
            }
        });

    }
    public void click()
    {
        imageView1.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        imageView4.setClickable(false);
        imageView5.setClickable(false);
        imageView6.setClickable(false);
        imageView7.setClickable(false);
        imageView8.setClickable(false);
        imageView9.setClickable(false);
    }
    public int four(int n)
    {
        int n1=n;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while(n>0)
        {
            arrayList.add(n%10);
            n=n/10;
        }
        Collections.sort(arrayList);
        for(int j=0;j<check.length;j++)
        {
            int ct=0;
            int sum=0;
            int c=check[j];
            while(c>0)
            {
                int d=c%10;
                for(int k=0;k<arrayList.size();k++)
                {
                    if(arrayList.get(k)==d)
                    {
                        sum=sum*10+d;
                        ct++;
                        break;
                    }
                }
                c=c/10;
            }
            if(ct==3)
            {
                return sum;
            }
        }
        return n1;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showPopup(View v, String text)
    {
        mp.start();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        View popup=getLayoutInflater().inflate(R.layout.popup,null);
        ImageView pop=popup.findViewById(R.id.who);
        ImageView hu=popup.findViewById(R.id.hurray);
        Button play=popup.findViewById(R.id.play);
        Button quit=popup.findViewById(R.id.quit);
        hu.setImageResource(R.drawable.party);
        int height=LinearLayout.LayoutParams.WRAP_CONTENT;
        if(text.equals("zero"))
        {
            pop.setImageResource(R.drawable.zero);
        }
        else if(text.equals("cross"))
        {
            pop.setImageResource(R.drawable.cross);
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
                startActivity(new Intent(MainActivity.this,HomeScreen.class));
            }
        });
    }
    public void replay()
    {
        i=0;
        num=0;
        cr=0;
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
        result.setText("");
        result.setVisibility(View.INVISIBLE);
        turn.setImageResource(R.drawable.zero);
        turn.setVisibility(View.VISIBLE);
        turnText.setVisibility(View.VISIBLE);

        mp.stop();
    }
}