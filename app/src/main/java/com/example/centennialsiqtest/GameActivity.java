package com.example.centennialsiqtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GameActivity extends AppCompatActivity {
    public int tempscore=0;
    public int speed=(Helper.getSpeed())/2;
    MediaPlayer music = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Helper.reset();
        Helper.numbers();
        updatetext();
        final Handler handlestart = new Handler();
        handlestart.postDelayed(new Runnable() {
            @Override
            //Runs code in method run() after .5 seconds
            public void run() {
                startpattern();
            }
        }, speed);

        if (Helper.musics == true){
            music = MediaPlayer.create(GameActivity.this, R.raw.precarious);
            music.start();
        }

        if(Helper.stocks == false){
            TextView sto = (TextView)  findViewById(R.id.Stockb);
            sto.setClickable(false);
        }
    }

    // stock

    public class doit extends AsyncTask<Void, Void, Void> {
        String apple;
        String tesla;
        String micro;
        String netflix;
        String amazon;
        String alphabet;
        String td;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("https://www.google.com/finance/quote/AAPL:NASDAQ?hl=en").get();
                apple = doc.text();
                doc = Jsoup.connect("https://www.google.com/finance/quote/TSLA:NASDAQ?hl=en").get();
                tesla = doc.text();
                doc = Jsoup.connect("https://www.google.com/finance/quote/MSFT:NASDAQ?hl=en").get();
                micro = doc.text();
                doc = Jsoup.connect("https://www.google.com/finance/quote/NFLX:NASDAQ?hl=en").get();
                netflix = doc.text();
                doc = Jsoup.connect("https://www.google.com/finance/quote/AMZN:NASDAQ?hl=en").get();
                amazon = doc.text();
                doc = Jsoup.connect("https://www.google.com/finance/quote/GOOGL:NASDAQ?hl=en").get();
                alphabet = doc.text();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView stockvisual = (TextView) findViewById(R.id.StockInfo);

            String ans = "Stock Prices:\nApple:\t\t"+Helper.StringToStock(apple)+"\n"+"tesla:\t\t"+Helper.StringToStock(tesla)+"\n"+"Microsoft:\t\t"+Helper.StringToStock(micro)+"\n"+"Netflix:\t\t"+Helper.StringToStock(netflix)+"\n"+"Amazon:\t\t"+Helper.StringToStock(amazon)+"\n"+"Alphabet:\t\t"+Helper.StringToStock(alphabet);

            stockvisual.setText(ans);
        }
    }


    //stock end

    public void backc(View view){
        finish();
        music.stop();
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
    public void stockc(View view) throws IOException {
        TextView stockvisual = (TextView) findViewById(R.id.StockInfo);
        if(stockvisual.getVisibility()==View.VISIBLE){
            stockvisual.setVisibility(View.INVISIBLE);
            stockvisual.setClickable(false);
        }
        else {

            new doit().execute();
            stockvisual.setVisibility(View.VISIBLE);
        }
        stockvisual.setClickable(true);
    }
    public void Repeat(View view){
        startpattern();

    }
    public void aClick(View view) throws InterruptedException {
        if(Helper.check(0) == false){
            redflash();
            startpattern();
        }
        else
            checkscore();
        updatetext();

    }
    public void bClick(View view) throws InterruptedException {
        checkscore();
        if(Helper.check(1) == false){
            redflash();
            startpattern();
        }
        else
            checkscore();
        updatetext();
    }
    public void cClick(View view) throws InterruptedException {
        if(Helper.check(2) == false){
            redflash();
            startpattern();
        }
        else
            checkscore();
        updatetext();
    }
    public void dClick(View view) throws InterruptedException {
        if(Helper.check(3) == false){
            redflash();
            startpattern();
        }
        else
            checkscore();
        updatetext();
    }

    public void checkscore(){
        if(Helper.getScore()==Helper.getfinalpatternlength()){
            Helper.reset();
            ViewDialog alert = new ViewDialog();
            alert.showDialog(GameActivity.this, "You won! Congratulations!");
        }
        else if(Helper.getScore()>tempscore){
            startpattern();
            tempscore=Helper.getScore();
            greenflash();
        }
    }
    public void startpattern(){
        ImageView i1 = findViewById(R.id.Shape1);
        ImageView i2 = findViewById(R.id.Shape2);
        ImageView i3 = findViewById(R.id.Shape3);
        ImageView i4 = findViewById(R.id.Shape4);
        Helper.pattern(i1,i2,i3,i4);
    }
    public void updatetext(){
        TextView t1 = findViewById(R.id.patternnumber);
        TextView t2 = findViewById(R.id.CurrentScoret);
        if(Helper.getpatternlength()==0){
            t1.setText(String.format("Pattern Number: %d/%d",Helper.getOrder(),Helper.getpatternlength()+1));
        }
        else
            t1.setText(String.format("Pattern Number: %d/%d",Helper.getOrder(),Helper.getpatternlength()));
        t2.setText(String.format("Current Score: %d",Helper.getScore()));

        TextView t3 = findViewById(R.id.highscore);
        TextView t4 = findViewById(R.id.lives);
        t3.setText(String.format("Highscore: %d",Helper.getHighScore()));
        t4.setText(String.format("Lives: %d",Helper.getLives()));
    }
    public void redflash(){
        ConstraintLayout c = findViewById(R.id.bg);
        c.setBackgroundColor(getResources().getColor(R.color.t1red));
        final Handler handlerend = new Handler();
        handlerend.postDelayed(new Runnable() {
            @Override
            //Runs code in method run() after .5 seconds
            public void run() {
                c.setBackgroundColor(getResources().getColor(R.color.t1blue));
            }
        }, speed);
    }
    public void greenflash(){
        ConstraintLayout c = findViewById(R.id.bg);
        c.setBackgroundColor(getResources().getColor(R.color.t1green));
        final Handler handlerend = new Handler();
        handlerend.postDelayed(new Runnable() {
            @Override
            //Runs code in method run() after .5 seconds
            public void run() {
                c.setBackgroundColor(getResources().getColor(R.color.t1blue));
            }
        }, speed);
    }
    public class ViewDialog {
        public void showDialog(Activity activity, String msg){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.win);

            TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
            text.setText(msg);

            Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();
                }
            });

            dialog.show();

        }
    }
}