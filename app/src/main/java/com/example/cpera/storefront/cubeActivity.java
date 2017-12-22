package com.example.cpera.storefront;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class cubeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        final String cubeRating = "cubeRating";
        RatingBar rating = findViewById(R.id.cubeBar);
        savedInstanceState.putFloat(cubeRating, rating.getRating());
    }

}

