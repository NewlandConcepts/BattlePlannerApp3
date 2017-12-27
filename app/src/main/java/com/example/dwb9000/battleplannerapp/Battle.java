package com.example.dwb9000.battleplannerapp;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;


public class Battle extends AppCompatActivity {

    /*
    static final int NUM_ITEMS = 10;

    MyAdapter mAdapter;

    //ViewPager mPager;

    private DatabaseHelper myDB;
    private ArrayList<String> listOfAbilities = new ArrayList<String>();
    private AttackList actlist;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        setContentView(R.layout.activity_battle);

        final ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }
        };

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageSelected(int position)
                    {
                        //When swiping between pages, select the corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                }
        );




        //populateListView("Action");
        //populateListView("Bonus Action");
        //populateListView("Reaction");
        //instantializeTabs();


    }

    public DatabaseHelper getDBInstance(DatabaseHelper newDB) {
        newDB = this.myDB;
        return newDB;
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            return ArrayListFragment.newInstance(position);
        }
    }

    public static class ArrayListFragment extends ListFragment {
        int mNum;

        /**
         * Create a new instance of CountingFragment, providing "num"
         * as an argument.
         */

    /*
        static ArrayListFragment newInstance(int num) {
            ArrayListFragment f = new ArrayListFragment();

            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);

            return f;
        }

        /**
         * When creating, retrieve this instance's number from its arguments.
         */

        /*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView) tv).setText("Fragment #" + mNum);
            return v;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item Clicked: " + id);
        }


    }
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

   /* public void instantializeTabs()
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
    } */ }

