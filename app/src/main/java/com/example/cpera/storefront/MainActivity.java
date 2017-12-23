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

    //both for onActivityResult handling
    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //version checker runs first
        checkVersion();
        //Implement onClick/Intents for images
        onImgClick();

    }

    //I could not for the life of me figure out correct bundle useage to make this work so you get onActivityResult instead
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            //make sure it's coming from the right page
            if (resultCode == RESULT_OK) {
                // which page determines which stars
                if(num == 1) {
                    // get String data from Intent
                    String value = data.getStringExtra("cubeStar");
                    Float num = Float.parseFloat(value);
                    RatingBar cube = findViewById(R.id.cStar);
                    cube.setRating(num);
                } else if(num == 2) {
                    String value = data.getStringExtra("candStar");
                    Float num = Float.parseFloat(value);
                    RatingBar cand = findViewById(R.id.candStar);
                    cand.setRating(num);
                } else if(num == 3) {
                    String value = data.getStringExtra("callStar");
                    Float num = Float.parseFloat(value);
                    RatingBar call = findViewById(R.id.callStar);
                    call.setRating(num);
                } else if(num == 4) {
                    String value = data.getStringExtra("amethStar");
                    Float num = Float.parseFloat(value);
                    RatingBar ameth = findViewById(R.id.amethStar);
                    ameth.setRating(num);
                }
            }
        }
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imvCube) {
            Intent intent = new Intent(this, cubeActivity.class);
            num = 1;
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
            //startActivity(new Intent(this, cubeActivity.class));
        } else if (v.getId() == R.id.imvCand) {
            Intent intent = new Intent(this, candleActivity.class);
            num = 2;
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
        } else if (v.getId() == R.id.imvCall) {
            Intent intent = new Intent(this, callActivity.class);
            num = 3;
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
        } else if (v.getId() == R.id.ameth) {
            Intent intent = new Intent(this, amethActivity.class);
            num = 4;
            startActivityForResult(intent, SECOND_ACTIVITY_RESULT_CODE);
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

}