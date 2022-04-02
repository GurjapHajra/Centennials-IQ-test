package com.example.centennialsiqtest;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Helper {

    public static int[] pattern = new int[50];//Full 50 steps pattern
    public static int score = 0; //Score to check which
    public static int hearts = 5;
    public static int order = 0;
    public static int[] checkpattern;
    public static int highscore = 0;
    public static int ms = 1000;
    public static boolean musics = true;
    public static boolean stocks = true;
    public static int colorScheme = 1;

    public static boolean check(int n) {
        checkpattern = new int[score + 1];
        for (int i = 0; i < checkpattern.length; i++) {
            checkpattern[i] = pattern[i];
        }
        if (checkpattern[order] == n) {
            if (order == checkpattern.length - 1) {
                score++;
                order = 0;
                checkpattern = new int[score + 1];
            } else {
                order++;
            }
            return true;
        } else {
            if (hearts == 1) {
                if (highscore < score) {
                    highscore = score;
                }
                checkpattern = new int[0];
                score = 0;
                order = 0;
                hearts = 5;
                numbers();
            } else {
                hearts -= 1;
                order = 0;
            }
            return false;
        }

    }

    public static int[] numbers() {
        Random rand = new Random();
        for (int i = 0; i < pattern.length; i++) {
            int x = rand.nextInt(4);
            pattern[i] = x;
        }
        return pattern;
    }

    public static int getScore() {
        return score;
    }

    public static int getOrder() {
        return order;
    }

    public static int getfinalpatternlength() {
        return pattern.length;
    }

    public static int getpatternlength() {
        if (checkpattern == null) {
            return 0;
        } else
            return checkpattern.length;
    }

    public static int getLives() {
        return hearts;
    }

    public static int getHighScore() {
        return highscore;
    }

    public static int getSpeed() {
        return ms;
    }

    public static void setSpeed(int speed) {
        ms = speed;
    }

    public static void reset() {
        if (highscore < score) {
            highscore = score;
        }
        checkpattern = new int[0];
        score = 0;
        order = 0;
        hearts = 5;
        numbers();
    }

    public static String StringToStock(String line){
        int ind = line.indexOf("After Hours");
        String sub = line.substring(ind-10,ind);

        int index = sub.indexOf("$");

        String result = sub.substring(index);

        return result;
    }

    public static void pattern(ImageView b0, ImageView b1, ImageView b2, ImageView b3) {
        int ms2= ms;
        int tempms=ms*2;
        int insidems=ms;
        b0.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        for(int i=0;i<score+1;i++){
            final Handler handler2 = new Handler();
            int finalI = i;
            handler2.postDelayed(new Runnable() {
                @Override
                //Runs code in method run() after ms milliseconds
                public void run() {
                    if(pattern[finalI]==0){
                        b0.setVisibility(View.VISIBLE);
                        final Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            //Runs code in method run() after .5 seconds
                            public void run() {
                                b0.setVisibility(View.INVISIBLE);
                            }
                        }, insidems);
                    }
                    else if(pattern[finalI]==1){
                        b1.setVisibility(View.VISIBLE);
                        final Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            //Runs code in method run() after .5 seconds
                            public void run() {
                                b1.setVisibility(View.INVISIBLE);
                            }
                        }, insidems);
                    }
                    else if(pattern[finalI]==2){
                        b2.setVisibility(View.VISIBLE);
                        final Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            //Runs code in method run() after .5 seconds
                            public void run() {
                                b2.setVisibility(View.INVISIBLE);
                            }
                        }, insidems);
                    }
                    else if(pattern[finalI]==3){
                        b3.setVisibility(View.VISIBLE);
                        final Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            //Runs code in method run() after .5 seconds
                            public void run() {
                                b3.setVisibility(View.INVISIBLE);
                            }
                        }, insidems);
                    }
                }
            }, ms2);
            ms2+=tempms;
        }
        final Handler handlerend = new Handler();
        handlerend.postDelayed(new Runnable() {
            @Override
            //Runs code in method run() after .5 seconds
            public void run() {
                b0.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
            }
        }, ms2);
    }
}
