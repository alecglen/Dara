package com.example.test.dara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


public class RouteMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make button lead to the New Request interface
        ImageButton mapSelect = findViewById(R.id.mapButton);
        mapSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RouteMapActivity.this, PackageDataActivity.class);
                Bundle attrs = getIntent().getExtras();
                myIntent.putExtras(attrs);
                RouteMapActivity.this.startActivity(myIntent);
            }
        });


    }

}
