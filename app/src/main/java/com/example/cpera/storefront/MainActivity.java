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

    private RatingBar cubeStar, candStar, callStar, amethStar;
    private Intent intent;
    private Bundle extras;
    private ImageView cube, cand, call, ameth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cubeStar = findViewById(R.id.cubeStar);
        candStar = findViewById(R.id.candStar);
        callStar = findViewById(R.id.callStar);
        amethStar = findViewById(R.id.amethStar);

        //version checker runs first
        checkVersion();
        //Implement onClick listeners for IMGs
        onImgClick();
        //Deal with bundle if returning
        bundleGet();
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
        cube = findViewById(R.id.imvCube);
            cube.setOnClickListener(this);
        cand = findViewById(R.id.imvCand);
            cand.setOnClickListener(this);
        call = findViewById(R.id.imvCall);
            call.setOnClickListener(this);
        ameth = findViewById(R.id.ameth);
            ameth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        extras = new Bundle();
        if (v.getId() == R.id.imvCube) {
            intent = new Intent(getApplicationContext(), cubeActivity.class);;
        } else if (v.getId() == R.id.imvCand) {
            intent = new Intent(getApplicationContext(), candleActivity.class);
        } else if (v.getId() == R.id.imvCall) {
            intent = new Intent(getApplicationContext(), callActivity.class);
        } else {
            intent = new Intent(getApplicationContext(), amethActivity.class);
        }
        extras.putFloat("cubeStar", cubeStar.getRating());
        extras.putFloat("candStar", candStar.getRating());
        extras.putFloat("callStar", callStar.getRating());
        extras.putFloat("amethStar", amethStar.getRating());
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void bundleGet() {
        //Papa's got a brand new bag
        extras = getIntent().getExtras();
        //if extras exists
        if (extras != null) {
            cubeStar.setRating(extras.getFloat("cubeStar"));
            candStar.setRating(extras.getFloat("candStar"));
            callStar.setRating(extras.getFloat("callStar"));
            amethStar.setRating(extras.getFloat("amethStar"));
        }
    }

    //Not sure if save/restor is functioning yet, or how to properly test
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

