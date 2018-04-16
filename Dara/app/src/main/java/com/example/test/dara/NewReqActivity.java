package com.example.test.dara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewReqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_req);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        String[] attributes = {"Pickup Location", "Destination", "Item Description", "Initial Offer", "Due Date"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);
    }

}
