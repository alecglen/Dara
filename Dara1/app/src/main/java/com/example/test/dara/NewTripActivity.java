package com.example.test.dara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NewTripActivity extends AppCompatActivity {

    private Bundle attrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        attrs = getIntent().getExtras();
        String[] items = {"Starting Location", "Destination",
                "Cargo Capacity", "Travel Date"};
        ArrayList<String> attributes = new ArrayList<>();
        for (String item : items) {
            if (attrs!=null && attrs.containsKey(item)) {
                attributes.add(item + "@@@" + attrs.getString(item));
            } else {
                attributes.add(item + "@@@Not Set");
            }
        }
        attributes.add("View Sender Map@@@Select packages along your route to deliver.");

        final EditText title = findViewById(R.id.tripTitle);
        if (attrs!=null && attrs.containsKey("Trip Name")) {
            title.setText(attrs.getString("Trip Name"));
        }

        // Set ListView attributes
        RequestsAdapter adapter = new RequestsAdapter(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.newTripAttributes);
        listView.setAdapter(adapter);

        // Set ListView clickListeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                attrs.putString("Trip Name", title.getText().toString());
                if (position == 0) {
                    Intent myIntent = new Intent(NewTripActivity.this, TripStartActivity.class);
                    myIntent.putExtras(attrs);
                    NewTripActivity.this.startActivity(myIntent);
                } else if (position == 1) {
                    Intent myIntent = new Intent(NewTripActivity.this, TripEndActivity.class);
                    myIntent.putExtras(attrs);
                    NewTripActivity.this.startActivity(myIntent);
                } else if (position == 2) {
                    Intent myIntent = new Intent(NewTripActivity.this, CapacityActivity.class);
                    myIntent.putExtras(attrs);
                    NewTripActivity.this.startActivity(myIntent);
                } else if (position == 3) {
                    Intent myIntent = new Intent(NewTripActivity.this, TravelDateActivity.class);
                    myIntent.putExtras(attrs);
                    NewTripActivity.this.startActivity(myIntent);
                } else if (position == 4) {
                    Intent myIntent = new Intent(NewTripActivity.this, RouteMapActivity.class);
                    myIntent.putExtras(attrs);
                    NewTripActivity.this.startActivity(myIntent);
                }
            }
        });
    }
}
