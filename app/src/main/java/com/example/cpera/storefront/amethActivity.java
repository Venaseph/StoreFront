package com.example.cpera.storefront;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class amethActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ameth);

        final RatingBar amethStar = findViewById(R.id.amethBar);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String csr = String.valueOf(amethStar.getRating());
                Intent intent = new Intent();
                intent.putExtra("amethStar", csr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
