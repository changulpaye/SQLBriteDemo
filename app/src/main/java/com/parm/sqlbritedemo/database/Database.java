package com.parm.sqlbritedemo.database;

import android.content.Context;
import android.database.Cursor;

import com.parm.sqlbritedemo.model.Employee;
import com.parm.sqlbritedemo.utils.Constants;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by pchangul on 7/21/2016.
 */
public class Database {


    private DatabaseHelper databaseHelper;
    private BriteDatabase db;
    public Database(Context context) {

        MYSQLiteOpenHelper mysqLiteOpenHelper = new MYSQLiteOpenHelper(context);
        databaseHelper = new DatabaseHelper(mysqLiteOpenHelper);
        db = databaseHelper.getSQLiteDatabase();
    }


    public List<Employee> getEmployees(){
        final List<Employee> employees = new ArrayList<>();
        Observable<SqlBrite.Query> users = db.createQuery(Constants.TABLE_NAME,
                "SELECT * FROM " + Constants.TABLE_NAME);
        users.subscribe(new Action1<SqlBrite.Query>() {
            @Override public void call(SqlBrite.Query query) {
                Cursor cursor = query.run();
                // TODO parse data...
                if(cursor != null && cursor.moveToFirst()){
                    do{
                        Employee employee = new Employee();
                        employee.setId(cursor.getInt(cursor.getColumnIndex(Constants.EMPLOYEE_ID)));
                        employee.setName(cursor.getString(cursor.getColumnIndex(Constants.EMPLOYEE_NAME)));
                        employees.add(employee);
                    }while(cursor.moveToNext());

                }

            }
        });
        return employees;
    }






}
