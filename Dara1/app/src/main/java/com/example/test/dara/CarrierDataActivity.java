package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class CarrierDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make button lead to the New Request interface
        Button confirmDeliver = findViewById(R.id.confirmRequestButton);
        confirmDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CarrierDataActivity.this, HomeScreenActivity.class);
                Bundle attrs = getIntent().getExtras();
                ArrayList<String> requests = attrs.getStringArrayList("requests");
                String request = requests.get(0);
                String row1 = request.split("@@@")[0].split(" - ")[0];
                String row2 = request.split("@@@")[1];
                String compRequest = row1 + " - Carrier confirmed!@@@" + row2;
                ArrayList<String> compRequests = new ArrayList<>(Collections.singleton(compRequest));
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("requests", compRequests);
                myIntent.putExtras(bundle);
                CarrierDataActivity.this.startActivity(myIntent);
            }
        });
    }

}
