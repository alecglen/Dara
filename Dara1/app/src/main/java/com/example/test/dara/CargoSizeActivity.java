package com.example.test.dara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CargoSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_size);

        // Make button lead back to the New Req interface
        ImageButton cell = findViewById(R.id.cellButton);
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "Fits in hand");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton laptop = findViewById(R.id.laptopButton);
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "fits in a vehicle front seat");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton wallet = findViewById(R.id.tvButton);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "fits in a vehicle back seat");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton couch = findViewById(R.id.couchButton);
        couch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "fits in a pickup truck");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton bike = findViewById(R.id.bikeButton);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "large vehicle needed to transport");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton paw = findViewById(R.id.pawButton);
        paw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "small animal (crated)");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });
    }
}
