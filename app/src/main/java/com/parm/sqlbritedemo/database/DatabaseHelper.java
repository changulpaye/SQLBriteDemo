package com.parm.sqlbritedemo.database;


import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import rx.schedulers.Schedulers;

/**
 * Created by pchangul on 7/21/2016.
 */
public class DatabaseHelper {

    private MYSQLiteOpenHelper sqLiteOpenHelper;

    public DatabaseHelper(MYSQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }


    public BriteDatabase getSQLiteDatabase() {

        //SqlBrite instance which is an adapter for the library functionality.
        SqlBrite sqlBrite = SqlBrite.create();
        //Pass a SQLiteOpenHelper instance and a Scheduler to create a BriteDatabase.
        BriteDatabase db = sqlBrite.wrapDatabaseHelper(sqLiteOpenHelper, Schedulers.io());
        return db;
    }

}


