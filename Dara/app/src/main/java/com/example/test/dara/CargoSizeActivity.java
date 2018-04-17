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
        ImageButton couch = findViewById(R.id.couchButton);
        couch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "Large Size");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton luggage = findViewById(R.id.luggageButton);
        luggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "Medium Size");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

        // Make button lead back to the New Req interface
        ImageButton wallet = findViewById(R.id.walletButton);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CargoSizeActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Item Description", "Small Size");
                myIntent.putExtras(bundle);
                CargoSizeActivity.this.startActivity(myIntent);
            }
        });

    }
}
