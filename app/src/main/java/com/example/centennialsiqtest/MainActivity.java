package com.example.centennialsiqtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playc(View view){
        Intent gamescreen = new Intent(this, GameActivity.class);
        startActivity(gamescreen);
    }
    public void instc(View view){
        Intent instscreen = new Intent(this, Instructions.class);
        startActivity(instscreen);
    }
    public void settc(View view){
        Intent settscreen = new Intent(this, Settings.class);
        startActivity(settscreen);
    }
}