package com.example.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.ArrayList;

import model.EatenProduct;
import model.User;

public class CalendarActivity extends AppCompatActivity {
    CalendarView cw;
    User logedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cw = (CalendarView)findViewById(R.id.calendarView);
        logedUser = (User) getIntent().getParcelableExtra(User.class.getCanonicalName());




        cw.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month+1;
                int mDay = dayOfMonth;
                String selectedDate = new StringBuilder().append(mMonth + 1)
                        .append("-").append(mDay).append("-").append(mYear)
                        .append(" ").toString();

                Toast.makeText(getApplicationContext(), selectedDate, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CalendarActivity.this, CalendarDayActivity.class);
                intent.putExtra("year", String.valueOf(mYear));
                intent.putExtra("month",  String.valueOf(mMonth));
                intent.putExtra("day",  String.valueOf(mDay));
                intent.putExtra(User.class.getCanonicalName(),logedUser);

                startActivity(intent);

            }
        });
    }
}
