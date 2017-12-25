package com.example.dwb9000.battleplannerapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dwb9000.battleplannerapp.dummy.DummyContent;
import com.example.dwb9000.battleplannerapp.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class ActionFragment extends Fragment {

    private DatabaseHelper myDB;
    private ArrayList<String> listOfAbilities = new ArrayList<String>();
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static ActionFragment newInstance(int page)
    {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ActionFragment fragment = new ActionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_attack_list, container, false);
        return view;
    }

    public DatabaseHelper getDBInstance(DatabaseHelper newDB)
    {
        newDB = this.myDB;
        return newDB;
    }

    public void populateListView(View rootView)
    {
        // We'll likely have to find a better way to do this

        //Populate views for each tab.

        populateArrayList();
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1, //The layout needs to be ListViewItems xml file.
                //If you use your xml file as the layout, it will automatically convert
                //your task to a textview
                listOfAbilities);

        ListView list = (ListView)rootView.findViewById(R.id.ActionList);
        list.setAdapter(adapter);
    }

    private void populateArrayList()
    {
        listOfAbilities.clear();

        Cursor res = myDB.getDataByAbilityType("Action");

        if(res.getCount() == 0) {
            listOfAbilities.add("No Abilities Available");
        }

        while(res.moveToNext())
        {
            listOfAbilities.add(res.getString(0));
        }
    }
}
