package com.example.cpera.storefront;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class callActivity extends AppCompatActivity {
    private float cubeStar, candStar, amethStar;
    private RatingBar callStar;
    private Button back;
    private Bundle extras;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        callStar = findViewById(R.id.callBar);
        back = findViewById(R.id.back);
        bundleGet();

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //also acts as bundleSet() for rating bar state return via bundles
                intent = new Intent(getApplicationContext(), MainActivity.class);
                extras = new Bundle();
                extras.putFloat("cubeStar", cubeStar);
                extras.putFloat("candStar", candStar);
                extras.putFloat("callStar", callStar.getRating());
                extras.putFloat("amethStar", amethStar);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    private void bundleGet() {
        extras = getIntent().getExtras();
        if (extras != null) { //If Papa's got a brand new bag
            cubeStar = extras.getFloat("cubeStar");
            candStar = extras.getFloat("candStar");
            callStar.setRating(extras.getFloat("callStar"));
            amethStar = extras.getFloat("amethStar");
        }
    }
}
