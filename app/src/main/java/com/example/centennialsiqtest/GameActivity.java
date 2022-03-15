package com.example.centennialsiqtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
}