package com.example.cpera.storefront;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //version checker runs first
        checkVersion();
        //Implement onClick/Intents for images
        onImgClick();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    // set OR for onClick
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

    private void onImgClick() {
        ImageView cube = findViewById(R.id.imvCube);
            cube.setOnClickListener(this);
        ImageView candle = findViewById(R.id.imvCand);
            candle.setOnClickListener(this);
        ImageView call = findViewById(R.id.imvCall);
            call.setOnClickListener(this);
        ImageView ameth = findViewById(R.id.ameth);
            ameth.setOnClickListener(this);
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
}
