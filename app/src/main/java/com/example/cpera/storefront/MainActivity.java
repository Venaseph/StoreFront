package com.example.cpera.storefront;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //version checker runs first
        checkVersion();
        //Implement onClick listeners for IMGs
        onImgClick();
        //Deal with bundle if returning
        bundleStuff();
    }

    private void checkVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        if (sdkVersion < 20) {
            //create alert to be nice
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false)
                    .setTitle("Unsupported Version")
                    .setMessage("Please update to run Hearth Market")
                    .setNeutralButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //close Activity on OK click
                                    MainActivity.this.finish();
                                }
                            });
            final AlertDialog alert = builder.create();
            alert.show();
            //building doesn't actually create the dialog, so you do after it's set
        }
    }

    private void onImgClick() {
        final ImageView cube = findViewById(R.id.imvCube);
        cube.setOnClickListener(this);
        final ImageView candle = findViewById(R.id.imvCand);
        candle.setOnClickListener(this);
        final ImageView call = findViewById(R.id.imvCall);
        call.setOnClickListener(this);
        final ImageView ameth = findViewById(R.id.ameth);
        ameth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imvCube) {
            startActivity(new Intent(this, cubeActivity.class));
        } else if (v.getId() == R.id.imvCand) {
            startActivity(new Intent(this, candleActivity.class));
        } else if (v.getId() == R.id.imvCall) {
            startActivity(new Intent(this, callActivity.class));
        } else if (v.getId() == R.id.ameth) {
            startActivity(new Intent(this, amethActivity.class));
        }
    }

    private void bundleStuff() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getFloat("cubeStar") != 0) {
                RatingBar cStar = findViewById(R.id.cubeStar);
                cStar.setRating(extras.getFloat("cubeStar"));
            }

            if (extras.getFloat("candStar") != 0) {
                RatingBar candStar = findViewById(R.id.candStar);
                candStar.setRating(extras.getFloat("candStar"));
            }

            if (extras.getFloat("callStar") != 0) {
                RatingBar callStar = findViewById(R.id.callStar);
                callStar.setRating(extras.getFloat("callStar"));
            }

            if (extras.getFloat("amethStar") != 0) {
                RatingBar amethStar = findViewById(R.id.amethStar);
                amethStar.setRating(extras.getFloat("amethStar"));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        RatingBar cube = findViewById(R.id.cubeStar);
        RatingBar cand = findViewById(R.id.candStar);
        RatingBar call = findViewById(R.id.callStar);
        RatingBar ameth = findViewById(R.id.amethStar);

        outState.putFloat("r1", cube.getRating());
        outState.putFloat("r2", cand.getRating());
        outState.putFloat("r3", call.getRating());
        outState.putFloat("r4", ameth.getRating());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getString("r1") != null) {
            RatingBar cube = findViewById(R.id.cubeStar);
            cube.setRating(savedInstanceState.getFloat("r1"));
        }
        if (savedInstanceState.getString("r2") != null) {
            RatingBar cand = findViewById(R.id.candStar);
            cand.setRating(savedInstanceState.getFloat("r1"));
        }
        if (savedInstanceState.getString("r3") != null) {
            RatingBar call = findViewById(R.id.cubeStar);
            call.setRating(savedInstanceState.getFloat("r1"));
        }
        if (savedInstanceState.getString("r4") != null) {
            RatingBar ameth = findViewById(R.id.cubeStar);
            ameth.setRating(savedInstanceState.getFloat("r1"));
        }
    }
}