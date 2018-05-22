package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DueDateActivity extends AppCompatActivity {

    private String mYear;
    private String mMonth;
    private String mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due_date);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mYear = Integer.toString(year);
                mMonth = Integer.toString(month + 1);
                mDate = Integer.toString(dayOfMonth);
            }
        });

        // Make button lead back to the New Req interface
        Button confirmDate = findViewById(R.id.confirmDateButton);
        confirmDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DueDateActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Due Date", mMonth + "/" + mDate + "/" + mYear);
                myIntent.putExtras(bundle);
                DueDateActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        Button noRush = findViewById(R.id.noRushButton);
        noRush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DueDateActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Due Date", "No Rush");
                myIntent.putExtras(bundle);
                DueDateActivity.this.startActivity(myIntent);
            }
        });
    }

}
