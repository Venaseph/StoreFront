package com.example.cpera.storefront;

import android.content.Intent;
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
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        final String cubeRating = "cubeRating";
        RatingBar rating = findViewById(R.id.cubeBar);
        savedInstanceState.putString("string", "string");
        savedInstanceState.putFloat(cubeRating, rating.getRating());
        //Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show(); this runs correctly
        super.onSaveInstanceState(savedInstanceState);
    }

}

