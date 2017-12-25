package com.example.dwb9000.battleplannerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayTurnAbilities extends AppCompatActivity {

    private String activityView = "Action";
    //private String activityView = extras.getString("BUTTON_PRESSED");
    private ArrayList<String> listOfAbilities = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_turn_abilities);
        Bundle extras = this.getIntent().getExtras();
        activityView = extras.getString("BUTTON_PRESSED");
        populateListView();
    }

    public void populateListView()
    {
        populateArrayList(activityView);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, //The layout needs to be ListViewItems xml file.
                //If you use your xml file as the layout, it will automatically convert
                //your task to a textview
                listOfAbilities);

        ListView list = (ListView) findViewById(R.id.Available_Abilities);
        list.setAdapter(adapter);

    }

    public void populateArrayList(String buttonPressed)
    {

        listOfAbilities.clear();

        if(buttonPressed.equals("Action") )
        {
            listOfAbilities.add("Attack");
            listOfAbilities.add("Use Spell");
            listOfAbilities.add("Dash");
            listOfAbilities.add("Dodge");
            listOfAbilities.add("Disengage");
            listOfAbilities.add("Help");
            listOfAbilities.add("Hide");
            listOfAbilities.add("Ready");
            listOfAbilities.add("Search");
            listOfAbilities.add("Use Object");
            listOfAbilities.add("Stunning Strike");
            listOfAbilities.add("ExtraAttack");
        }
        else if(buttonPressed.equals("BonusAction"))
        {
            listOfAbilities.add("Flurry of Blows");
            listOfAbilities.add("Patient Defence");
            listOfAbilities.add("Step of the Wind");
        }
        else
        {listOfAbilities.add("Move (40ft)");
        }
    }

    public void updateActivityView(String buttonPressed)
    {
        activityView = buttonPressed;
    }
}
