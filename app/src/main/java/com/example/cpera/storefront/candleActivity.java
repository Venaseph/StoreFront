package com.example.cpera.storefront;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class candleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle);

        final RatingBar candStar = findViewById(R.id.candBar);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String csr = String.valueOf(candStar.getRating());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("candStar", csr);
                startActivity(intent);
            }
        });
    }
}
