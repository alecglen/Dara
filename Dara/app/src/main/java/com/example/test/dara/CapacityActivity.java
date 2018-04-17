package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class CapacityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacity);

        // Make button lead back to the New Req interface
        ImageButton couch = findViewById(R.id.couchButton);
        couch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "Plenty");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton luggage = findViewById(R.id.luggageButton);
        luggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "Some extra room in the car");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton wallet = findViewById(R.id.walletButton);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "Just a little bit");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

    }
}
