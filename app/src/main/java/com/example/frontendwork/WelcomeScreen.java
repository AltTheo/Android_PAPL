package com.example.frontendwork;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        setTitle("task Helper (Generator)");
    }

    @SuppressLint("SetTextI18n")
    public void HomePage(View v){
        Intent i = new Intent(this, MainActivity.class);
//        EditText tv = findViewById(R.id.nameText);
//        String name = tv.getText().toString();
//        ((TextView) findViewById(R.id.wlcDisplay)).setText("HELLO THERE, "+name);
        startActivity(i);
    }



}