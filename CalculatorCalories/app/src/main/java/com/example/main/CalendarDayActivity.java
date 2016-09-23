package com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import DBWorking.DBHelper;
import DBWorking.DBMethods;
import adapters.CalendarDayAdapter;
import adapters.CustomListAdapter;
import model.EatenProduct;
import model.User;

public class CalendarDayActivity extends AppCompatActivity {
    final String LOG_TAG = "Calendar";
    DBMethods dbMethods;
    DBHelper dbHelper;
    User logedUser;
    ArrayList<EatenProduct> products = new ArrayList<EatenProduct>();

    ArrayList<EatenProduct> eatenProducts = new ArrayList<EatenProduct>();
    CalendarDayAdapter calendarDayAdapter;

    String year;
    String month;
    String day ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_day);
        Intent intent = getIntent();
        month = intent.getStringExtra("month");
        day = intent.getStringExtra("day");
        logedUser = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());

        dbHelper = new DBHelper(this);
        dbMethods = new DBMethods();
        Log.d(LOG_TAG,"Month =  " + month + " Day = " + day);


        fillData();

        calendarDayAdapter = new CalendarDayAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.listDayEatenFood);
        lvMain.setAdapter(calendarDayAdapter);

    }


    void fillData() {
        products = dbMethods.getAllEatenProducts(dbHelper,dbMethods.getAllProducts(dbHelper),month,day,100,logedUser.getId()+"");
        Log.d(LOG_TAG, "Array size = " + products.size());

    }
}
