package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class NewReqActivity extends AppCompatActivity {

    private Bundle attrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_req);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Populate attributes list
        attrs = getIntent().getExtras();
        String[] items = {"Pick-up Location", "Drop-off Location",
                "Item Description", "Initial Offer", "Due Date"};
        ArrayList<String> attributes = new ArrayList<>();
        for (String item : items) {
            if (attrs!=null && attrs.containsKey(item)) {
                attributes.add(item + "@@@" + attrs.getString(item));
            } else {
                attributes.add(item + "@@@Not Set");
            }
        }

        final EditText title = findViewById(R.id.itemTitle);
        if (attrs!=null && attrs.containsKey("Item Name")) {
            title.setText(attrs.getString("Item Name"));
        }

        // Set ListView attributes
        RequestsAdapter adapter = new RequestsAdapter(this, R.layout.job_lists, attributes);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);

        // Set ListView clickListeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                attrs.putString("Item Name", title.getText().toString());
                if (position == 0) {
                    Intent myIntent = new Intent(NewReqActivity.this, StartingLocationActivity.class);
                    myIntent.putExtras(attrs);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 1) {
                    Intent myIntent = new Intent(NewReqActivity.this, EndingLocationActivity.class);
                    myIntent.putExtras(attrs);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 2) {
                    Intent myIntent = new Intent(NewReqActivity.this, CargoSizeActivity.class);
                    myIntent.putExtras(attrs);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 3) {
                    Intent myIntent = new Intent(NewReqActivity.this, Anchor.class);
                    myIntent.putExtras(attrs);
                    NewReqActivity.this.startActivity(myIntent);
                } else if (position == 4) {
                    Intent myIntent = new Intent(NewReqActivity.this, DueDateActivity.class);
                    myIntent.putExtras(attrs);
                    NewReqActivity.this.startActivity(myIntent);
                }
            }
        });

        // Make button lead to the New Request interface
        Button newReqConfirm = findViewById(R.id.newReqSubmit);
        newReqConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(NewReqActivity.this, HomeScreenActivity.class);
                Bundle bundle = new Bundle();
                EditText temp = findViewById(R.id.itemTitle);
                String name = temp.getText().toString();
                String temp2 = attrs.getString("Drop-off Location");
                String city = temp2.split(",")[1];
                String request = (name + " - Match found!@@@To " + city + " by " + attrs.getString("Due Date") +
                        ". Offer: " + attrs.getString("Initial Offer"));
                ArrayList<String> requests = new ArrayList<>(Collections.singleton(request));
                bundle.putStringArrayList("requests", requests);
                myIntent.putExtras(bundle);
                NewReqActivity.this.startActivity(myIntent);
            }
        });
    }
}