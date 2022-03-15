package com.example.centennialsiqtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Helper.numbers();
    }
    public void backc(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    public void instructionsc(View view){
        Intent i = new Intent(getApplicationContext(), Instructions.class);
        startActivity(i);
    }
    public void stockinfob(View view){
        TextView stockvisual = (TextView) findViewById(R.id.StockInfo);
        if(stockvisual.getVisibility()==View.VISIBLE){
            stockvisual.setVisibility(View.INVISIBLE);
            stockvisual.setClickable(false);
        }
    }
    public void stockc(View view){
        TextView stockvisual = (TextView) findViewById(R.id.StockInfo);
        if(stockvisual.getVisibility()==View.VISIBLE){
            stockvisual.setVisibility(View.INVISIBLE);
            stockvisual.setClickable(false);
        }
        else
            stockvisual.setVisibility(View.VISIBLE);
        stockvisual.setClickable(true);
    }
    public void aClick(View view) throws InterruptedException {

        ImageView i1 = findViewById(R.id.Shape1);
        ImageView i2 = findViewById(R.id.Shape2);
        ImageView i3 = findViewById(R.id.Shape3);
        ImageView i4 = findViewById(R.id.Shape4);
        if(Helper.check(1) == false){
            i1.setVisibility(View.INVISIBLE);
            i2.setVisibility(View.INVISIBLE);
            i3.setVisibility(View.INVISIBLE);
            i4.setVisibility(View.INVISIBLE);
            Helper.pattern(i1,i2,i3,i4);
        }
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            //Runs code in method run() after .5 seconds
            public void run() {
                i1.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
                i4.setVisibility(View.VISIBLE);
            }
        }, 1000*(Helper.getScore()));

    }
    public void bClick(View view) throws InterruptedException {
        ImageView i1 = findViewById(R.id.Shape1);
        ImageView i2 = findViewById(R.id.Shape2);
        ImageView i3 = findViewById(R.id.Shape3);
        ImageView i4 = findViewById(R.id.Shape4);


        if(Helper.check(1) == false){
            Helper.pattern(i1,i2,i3,i4);
        }
    }
    public void cClick(View view) throws InterruptedException {
        ImageView i1 = findViewById(R.id.Shape1);
        ImageView i2 = findViewById(R.id.Shape2);
        ImageView i3 = findViewById(R.id.Shape3);
        ImageView i4 = findViewById(R.id.Shape4);


        if(Helper.check(2) == false){
            Helper.pattern(i1,i2,i3,i4);
        }
    }
    public void dClick(View view) throws InterruptedException {
        ImageView i1 = findViewById(R.id.Shape1);
        ImageView i2 = findViewById(R.id.Shape2);
        ImageView i3 = findViewById(R.id.Shape3);
        ImageView i4 = findViewById(R.id.Shape4);


        if(Helper.check(3) == false){
            Helper.pattern(i1,i2,i3,i4);
        }
    }
}