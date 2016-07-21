package com.parm.sqlbritedemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.parm.sqlbritedemo.utils.Constants;

/**
 * Created by pchangul on 7/21/2016.
 */
public class MYSQLiteOpenHelper  extends SQLiteOpenHelper {



    // DatabaseHelper creation sql statement
    private static final String DATABASE_CREATE =
            "create table "+ Constants.TABLE_NAME +" (_id integer primary key, name text not null);";

    public MYSQLiteOpenHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(MYSQLiteOpenHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }

}
