package com.example.cpera.storefront;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class cubeActivity extends AppCompatActivity {

    private final String cubeKey = "cubeKey";
    private final String cubeValue = "cubeValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Grab rating value
        RatingBar rating = findViewById(R.id.cubeBar);
        Float cubeRating = rating.getRating();

        // Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show();
    }

}

