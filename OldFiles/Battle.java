package com.example.dwb9000.battleplannerapp;

import android.app.TabActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;


public class Battle extends TabActivity {

    private DatabaseHelper myDB;
    private ArrayList<String> listOfAbilities = new ArrayList<String>();
    private AttackList actlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        setContentView(R.layout.activity_battle);

        //populateListView("Action");
        //populateListView("Bonus Action");
        //populateListView("Reaction");
        instantializeTabs();
    }

    public DatabaseHelper getDBInstance(DatabaseHelper newDB)
    {
        newDB = this.myDB;
        return newDB;
    }

    /*public void populateListView(String AttackType)
    {
        // We'll likely have to find a better way to do this

        //Populate views for each tab.

        populateArrayList(AttackType);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, //The layout needs to be ListViewItems xml file.
                //If you use your xml file as the layout, it will automatically convert
                //your task to a textview
                listOfAbilities);

        if(AttackType == "Action") {
            ListView list = (ListView) findViewById(R.id.ActionList);
            list.setAdapter(adapter);
        }
        else if(AttackType == "Bonus Action")
        {
            ListView list = (ListView) findViewById(R.id.BonusList);
            list.setAdapter(adapter);
        }
        else if(AttackType == "Reaction")
        {
            ListView list = (ListView) findViewById(R.id.ReactionList);
            list.setAdapter(adapter);
        }

    }

    private void populateArrayList(String AttackType)
    {
        listOfAbilities.clear();

       Cursor res = myDB.getDataByAbilityType(AttackType);

        if(res.getCount() == 0) {
            listOfAbilities.add("No Abilities Available");
        }

        while(res.moveToNext())
        {
            listOfAbilities.add(res.getString(0));
        }
    }

    */

    public void instantializeTabs()
    {
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Action");
       // TabHost.TabSpec tab2 = tabHost.newTabSpec("Bonus");
        //TabHost.TabSpec tab3 = tabHost.newTabSpec("Reaction");

        tab1.setIndicator("Action");

        Intent intent = new Intent(this,AttackList.class);
        tab1.setContent(intent);
        //tab1.setContent(new Intent(this, AttackList.class));

        //tab2.setIndicator("Bonus");
        //tab2.setContent(R.id.Bonus);

        //tab3.setIndicator("Reaction");
        //tab3.setContent(R.id.Reaction);

        tabHost.addTab(tab1);
        //tabHost.addTab(tab2);
        //tabHost.addTab(tab3);
    }
}
