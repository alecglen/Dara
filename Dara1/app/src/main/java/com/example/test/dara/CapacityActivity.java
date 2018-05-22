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
        ImageButton cell = findViewById(R.id.carriercellButton);
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "Fits in hand");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton laptop = findViewById(R.id.carrierlaptopButton);
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "fits in a vehicle front seat");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton wallet = findViewById(R.id.carriertvButton);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "fits in a vehicle back seat");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton couch = findViewById(R.id.carriercouchButton);
        couch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "fits in a pickup truck");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton bike = findViewById(R.id.carrierbikeButton);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "large vehicle needed to transport");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton paw = findViewById(R.id.carrierpawButton);
        paw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CapacityActivity.this, NewTripActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Cargo Capacity", "small animal (crated)");
                myIntent.putExtras(bundle);
                CapacityActivity.this.startActivity(myIntent);
            }
        });
    }
}
