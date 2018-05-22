package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartingLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_location);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make button lead back to the New Req interface
        Button getAddress = findViewById(R.id.addressContinue);
        getAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText temp = findViewById(R.id.editText7);
                String addr1 = temp.getText().toString();
                EditText temp2 = findViewById(R.id.EndingeditText13);
                String city = temp2.getText().toString();
                EditText temp3 = findViewById(R.id.editText8);
                String state = temp3.getText().toString();
                String address = addr1 + ", " + city + ", " + state;
                if (address.length() > 35) address = address.substring(0, 32) + "...";

                Intent myIntent = new Intent(StartingLocationActivity.this, NewReqActivity.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("Pick-up Location", address);
                myIntent.putExtras(bundle);
                StartingLocationActivity.this.startActivity(myIntent);
            }
        });
    }

}
