package com.example.dwb9000.battleplannerapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.ListAdapter;

import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();
        //myDb = new DatabaseHelper(this,"DnDDatabase");

        //populateListView();
    }

    public void selectEnterCombat(View view)
    {
        Intent intent = new Intent(this,DecideTurns.class);
        startActivity(intent);
    }

    public void Temp(View view)
    {
        Intent intent = new Intent(this,Battle.class);
        startActivity(intent);
    }
}
