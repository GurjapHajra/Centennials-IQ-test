package com.example.centennialsiqtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner dropdown = (Spinner) findViewById(R.id.Dropdown);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Settings.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.schemes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(myAdapter);

    }
    public void backd(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    public void music(View view){

    }
    public void slow(View view){
        Helper.setSpeed(1000);
        Helper.reset();
    }
    public void fast(View view){
        Helper.setSpeed(500);
        Helper.reset();
    }
    public void stockswitch(View view){

    }
}