package com.example.centennialsiqtest;

import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

import android.view.View;

import java.util.concurrent.TimeUnit;

public class Helper {

    public static int[] pattern = new int[50];
    public static int score = 0;
    public static int hearts = 5;

    public static boolean check(int n){
        if(pattern[score]==n){
            if(score==pattern.length-1){
                //win
            }
            else
                score++;
            Log.d("myTag", "Correct"+score);
            return true;
        }
        else {
            //repeat
            if(hearts==0){
                score=0;
                Log.d("myTag", "Die"+score);
            }
            else
                hearts-=1;
            Log.d("myTag", "Incorrect"+hearts);
            return false;
        }

    }

    public static int[] numbers(){
        Random rand = new Random();
        for (int i = 0; i < 50; i++){
            int x = rand.nextInt(4);
            pattern[i] = x;
        }
        return pattern;
    }
    public static int getScore(){
        return score;
    }

    public static void pattern(ImageView b0, ImageView b1, ImageView b2, ImageView b3) {
        for (int i = 0; i <= score; i++){

            final Handler handlerx = new Handler();
            handlerx.postDelayed(new Runnable() {
                @Override
                //Runs code in method run() after .5 seconds
                public void run() {
                }
            }, 1000);

            if (pattern[i] == 0){
                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    //Runs code in method run() after .5 seconds
                    public void run() {
                        b0.setVisibility(View.VISIBLE); b0.setClickable(true);
                    }
                }, 1000);

            }else if (pattern[i] == 1){
                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    //Runs code in method run() after .5 seconds
                    public void run() {
                        b1.setVisibility(View.VISIBLE); b1.setClickable(true);
                    }
                }, 1000);


            }else if (pattern[i] == 2){
                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    //Runs code in method run() after .5 seconds
                    public void run() {
                        b2.setVisibility(View.VISIBLE); b2.setClickable(true);
                    }
                }, 1000);


            }else{
                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    //Runs code in method run() after .5 seconds
                    public void run() {
                        b3.setVisibility(View.VISIBLE); b3.setClickable(true);
                    }
                }, 1000);
            }

        }

    }
}
