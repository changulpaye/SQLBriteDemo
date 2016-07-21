package com.parm.sqlbritedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parm.sqlbritedemo.database.Database;
import com.parm.sqlbritedemo.model.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database database = new Database(getApplicationContext());
        List<Employee> employees =database.getEmployees();

    }
}
