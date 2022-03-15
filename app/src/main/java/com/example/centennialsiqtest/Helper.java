package com.example.centennialsiqtest;

import android.widget.ImageView;

import java.util.Random;

import android.view.View;

import java.util.concurrent.TimeUnit;

public class Helper {

    public int[] pattern = new int[50];
    public int score = 0;

    public int[] numbers(){
        Random rand = new Random();
        for (int i = 0; i < 50; i++){
            int x = rand.nextInt(4);
            this.pattern[i] = x;
        }
        return pattern;
    }

    public void pattern(ImageView b0, ImageView b1, ImageView b2, ImageView b3)
            throws InterruptedException {

        b0.setVisibility(View.INVISIBLE); b0.setClickable(false);
        b1.setVisibility(View.INVISIBLE); b1.setClickable(false);
        b2.setVisibility(View.INVISIBLE); b2.setClickable(false);
        b3.setVisibility(View.INVISIBLE); b3.setClickable(false);

        for (int i = 0; i <= this.score; i++){
            if (pattern[i] == 0){
                b0.setVisibility(View.VISIBLE);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b0.setVisibility(View.INVISIBLE);
            }else if (pattern[i] == 1){
                b1.setVisibility(View.VISIBLE);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b1.setVisibility(View.INVISIBLE);
            }else if (pattern[i] == 2){
                b2.setVisibility(View.VISIBLE);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b2.setVisibility(View.INVISIBLE);
            }else{
                b3.setVisibility(View.VISIBLE);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b3.setVisibility(View.INVISIBLE);
            }
        }
        b0.setVisibility(View.VISIBLE); b0.setClickable(true);
        b1.setVisibility(View.VISIBLE); b1.setClickable(true);
        b2.setVisibility(View.VISIBLE); b2.setClickable(true);
        b3.setVisibility(View.VISIBLE); b3.setClickable(true);
    }

}
