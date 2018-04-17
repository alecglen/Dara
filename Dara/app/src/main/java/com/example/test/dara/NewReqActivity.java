package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NewReqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_req);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        String[] items = {"Pick-up Location@@@Not Set", "Drop-off Location@@@Not Set",
                "Item Description@@@Not Set", "Initial Offer@@@Not Set", "Due Date@@@Not Set"};
        ArrayList<String> attributes = new ArrayList<>(Arrays.asList(items));
        RequestsAdapter adapter = new RequestsAdapter(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);

        // Set ListView clickListeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(NewReqActivity.this, StartingLocationActivity.class);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 1) {
                    Toast.makeText(NewReqActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Intent myIntent = new Intent(NewReqActivity.this, CargoSizeActivity.class);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 3) {
                    Intent myIntent = new Intent(NewReqActivity.this, Anchor.class);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 4) {
                    Toast.makeText(NewReqActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}