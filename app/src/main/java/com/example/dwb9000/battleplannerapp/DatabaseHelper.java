package com.example.dwb9000.battleplannerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by DWB9000 on 11/7/2017.
 * This class is called when the app starts. If DnDDatabase.db has not been created, this program will create it.
 * This program uses a corresponding database file in the assets folder, to generate the new database.
 */

public class DatabaseHelper extends SQLiteAssetHelper{

    //Name of the database I want to be created in the assets folder.
    private static final String DATABASE_NAME = "DnDDatabase.db";
    //Version of the database to be updated. Increment database number to update the database.
    private static final int DATABASE_VERSION = 1;

    //Constructor
    public DatabaseHelper(Context context) {

        //This method creates the new database, using a predetermined database in the assets folder.

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    public Cursor getDataByAbilityType(String AbilityTypeToFind)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Ability WHERE AbilityType = '" + AbilityTypeToFind + "'",null);
        return res;
    }



}



    /* Old code from SQLiteOpenHelper

        //Constructor
    public DatabaseHelper(Context context, String name) {
        //Creates Database file if it doesn't already exist. getWritableDatabase() checks if the database exists
        //and will run the onCreate() or onUpgrade() depending on if the database exists or not.

        super(context, name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Ability Table when Database is created

        //Might change this to read the tables that need to be create from a text file
        db.execSQL("create table Ability (AbilityName TEXT NOT NULL PRIMARY KEY,AbilityType TEXT,Description TEXT,Damage TEXT,FollowupType TEXT)");
        InsertData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS TEST");
        onCreate(db);

    }

    public void CreateTable(String TableName)
    {// Might use this for dynamically creating default tables. We'll see.

    }

    public Boolean InsertData(SQLiteDatabase db)
    {   //Inserts data into the default database

        //Create a table in the assets folder which already has the data in it. Then copy it over when the application is created
        //Best practice is using the SQLiteAssetHelper library. Research this Tool.

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("AbilityName", "Stunning Strike");
        contentValues.put("AbilityType", "Action");
        contentValues.put("Description", "Spend 1 Ki Point. Target must succeed on a saving throw or be stunned until the end of your next turn");
        contentValues.put("Damage", "5");
        contentValues.put("FollowupType", "N/A");
        long result = db.insert("Ability",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }


    }
}*/
