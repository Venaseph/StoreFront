package com.example.cpera.storefront;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //version checker runs first
        checkVersion();
        //

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
