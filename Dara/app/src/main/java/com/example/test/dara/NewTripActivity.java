package com.example.test.dara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NewTripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        String[] items = {"Starting Location@@@Not Set", "Destination@@@Not Set",
                "Cargo Capacity@@@Not Set", "Travel Date@@@Not Set"};
        ArrayList<String> attributes = new ArrayList<>(Arrays.asList(items));
        RequestsAdapter adapter = new RequestsAdapter(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);

        // Set ListView clickListeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(NewTripActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(NewTripActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Intent myIntent = new Intent(NewTripActivity.this, CargoSizeActivity.class);
                    NewTripActivity.this.startActivity(myIntent);
                } else if (position == 3) {
                    Toast.makeText(NewTripActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
