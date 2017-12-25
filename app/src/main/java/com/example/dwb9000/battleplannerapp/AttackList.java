package com.example.dwb9000.battleplannerapp;

import android.app.Fragment;
import android.app.TabActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AttackList extends AppCompatActivity {

    private DatabaseHelper actionDB;
    private ArrayList<String> listOfAbilities = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        actionDB = new DatabaseHelper(this);
        setContentView(R.layout.activity_attack_list);
        populateListView();
    }

    public void populateListView()
    {
        // We'll likely have to find a better way to do this

        //Populate views for each tab.

        populateArrayList();
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, //The layout needs to be ListViewItems xml file.
                //If you use your xml file as the layout, it will automatically convert
                //your task to a textview
                listOfAbilities);

            ListView list = (ListView) findViewById(R.id.ActionList);
            list.setAdapter(adapter);
    }

    private void populateArrayList()
    {
        listOfAbilities.clear();

        Cursor res = actionDB.getDataByAbilityType("Action");

        if(res.getCount() == 0) {
            listOfAbilities.add("No Abilities Available");
        }

        while(res.moveToNext())
        {
            listOfAbilities.add(res.getString(0));
        }
    }


}
