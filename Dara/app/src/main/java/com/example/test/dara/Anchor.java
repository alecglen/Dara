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

public class Anchor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anchor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText priceBox = findViewById(R.id.editText6);

        // Make button autofill price
        Button suggested = findViewById(R.id.button3);
        suggested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceBox.setText("20");
            }});

        // Make button continue back to new req home
        Button price_continue = findViewById(R.id.button4);
        price_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Anchor.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                EditText temp = findViewById(R.id.editText6);
                String offer = temp.getText().toString();
                bundle.putString("Initial Offer", "$" + offer);
                myIntent.putExtras(bundle);
                Anchor.this.startActivity(myIntent);
            }});


    }

}
