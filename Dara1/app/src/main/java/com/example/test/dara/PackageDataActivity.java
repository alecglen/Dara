package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class PackageDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make button lead to the New Request interface
        Button confirmDeliver = findViewById(R.id.deliverButton);
        confirmDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PackageDataActivity.this, HomeScreenActivity.class);
                Bundle attrs = getIntent().getExtras();
                String temp2 = attrs.getString("Destination");
                String city = temp2.split(",")[1];
                String trip = (attrs.getString("Trip Name") + " Trip - Delivering@@@To " + city + " on " +
                        attrs.getString("Travel Date") + ". Payment: $20");
                ArrayList<String> trips = new ArrayList<>(Collections.singleton(trip));
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("trips", trips);
                myIntent.putExtras(bundle);
                PackageDataActivity.this.startActivity(myIntent);
            }
        });
    }

}
