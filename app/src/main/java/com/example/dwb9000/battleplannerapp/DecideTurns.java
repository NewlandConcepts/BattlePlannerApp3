package com.example.dwb9000.battleplannerapp;

/**
 * Created by DWB9000 on 10/15/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class DecideTurns extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.decide_turns);
    }

    public void yourTurn(View view)
    {
        Intent intent = new Intent(this, TurnScreen.class);
        startActivity(intent);
    }
}
