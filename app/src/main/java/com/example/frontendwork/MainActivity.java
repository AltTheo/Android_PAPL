package com.example.frontendwork;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Node;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static int direction;
    NodeMap nodeMap;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream prc = getCSVRes();
        nodeMap = new NodeMap(prc);    //This part allows to link the backend and manipulate it for the frontend code

        //This part displays the first part of the questions on the get go

        TextView Description = findViewById(R.id.textID);
        TextView Question = findViewById(R.id.textID2);
        Description.setText(nodeMap.currentNode().getDescription() + "\n");
        Question.setText(nodeMap.currentNode().getQuestion() + "\n");
    }

    protected InputStream getCSVRes() {
        Resources res = getResources();
        return res.openRawResource(R.raw.generator4);
    }

    public void yesClick(View v) {
//        nodeMap.currentNode().getQuestion();
        ((Button) findViewById(R.id.button)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                move(nodeMap, 1);
                nodeDisplay(nodeMap);
            }});

//        ((TextView) findViewById(R.id.textID)).setText(nodeMap.currentNode().getQuestion());
//        (Button) findViewById(R.id.button).setOnClickListener();
    }

    public void noClick(View v) {
        ((Button) findViewById(R.id.button2)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                move(nodeMap, 2);
                nodeDisplay(nodeMap);
            }});
//        Toast.makeText(this, "you clicked No", Toast.LENGTH_SHORT).show();
//        ((TextView) findViewById(R.id.textID)).setText("No");
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);    //this does like a refresh
    }

    public static void move(NodeMap nodeMap, int direction){
        if (nodeMap.currentNode().getQuestion().equals("-"))
        {
            nodeMap.noDecision(); }
        nodeMap.decision(direction);
    }

    @SuppressLint("SetTextI18n")
    public void nodeDisplay(NodeMap nodeMap){

        TextView Description = findViewById(R.id.textID);

        TextView Question = findViewById(R.id.textID2);

        if(Description.getText().equals("-")){
            Description.setText("Tasks Tasks Tasks Tasks Tasks Tasks Tasks Tasks Tasks ");
        }
        else {
            Description.setText(nodeMap.currentNode().getDescription() + "\n");
        }
        Question.setText(nodeMap.currentNode().getQuestion() + "\n");

        if(Description.getText().)
//        ((TextView) findViewById(R.id.textID)).setText(nodeMap.currentNode().getDescription() + "\n");
//        ((TextView) findViewById(R.id.textID2)).setText(nodeMap.currentNode().getQuestion() + "\n");
    }
}