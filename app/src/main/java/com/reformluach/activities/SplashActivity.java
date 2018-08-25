package com.reformluach.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.reformluach.R;

import io.fabric.sdk.android.Fabric;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_plash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, DashBoardCheckActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
