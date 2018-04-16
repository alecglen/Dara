package com.example.test.dara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class NewReqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_req);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        String[] attributes = {"Pick-up Location@@@Not Set", "Drop-off Location@@@Not Set",
                "Item Description@@@Not Set", "Initial Offer@@@Not Set", "Due Date@@@Not Set"};
        RequestsAdapter adapter = new RequestsAdapter(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);
    }

}