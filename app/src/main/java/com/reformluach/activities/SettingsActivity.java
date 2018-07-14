package com.reformluach.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.reformluach.R;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;

public class SettingsActivity extends AppCompatActivity {
    private ImageView ivBack;
    private RadioButton rb_reform, rb_israel, rb_diaspora;
    private LinearLayout llMain;
    private Controller controller;
    private Context context;
    private RadioGroup rgSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context = this;
        controller = (Controller) context.getApplicationContext();
        getIds();
    }

    private void getIds() {
        ivBack = findViewById(R.id.ivBack);
        rgSettings = findViewById(R.id.rgSettings);
        rb_reform = findViewById(R.id.rb_reform);
        rb_israel = findViewById(R.id.rb_israel);
        rb_diaspora = findViewById(R.id.rb_diaspora);
        ivBack = findViewById(R.id.ivBack);
        llMain = findViewById(R.id.llMain);
        setBgAccordingToMonth(controller.getMonth());
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                controller.animationBackward(context);
            }
        });
        rb_reform.setChecked(true);
        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM) != null && controller.getPreferencesString((Activity) context, Appconstant.ISRAEL) != null && controller.getPreferencesString((Activity) context, Appconstant.DIASPORA) != null) {
            if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                rb_reform.setChecked(true);
            } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                rb_israel.setChecked(true);
            } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                rb_diaspora.setChecked(true);
            }
        } else {
            rb_reform.setChecked(true);
        }
        rgSettings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_reform) {
                    controller.savePreferencesString(context, Appconstant.REFORM, "selected");
                    controller.savePreferencesString(context, Appconstant.DIASPORA, "unselected");
                    controller.savePreferencesString(context, Appconstant.ISRAEL, "unselected");
//                    onBackPressed();
                } else if (i == R.id.rb_israel) {
                    controller.savePreferencesString(context, Appconstant.ISRAEL, "selected");
                    controller.savePreferencesString(context, Appconstant.DIASPORA, "unselected");
                    controller.savePreferencesString(context, Appconstant.REFORM, "unselected");
//                    onBackPressed();
                } else if (i == R.id.rb_diaspora) {
                    controller.savePreferencesString(context, Appconstant.DIASPORA, "selected");
                    controller.savePreferencesString(context, Appconstant.REFORM, "unselected");
                    controller.savePreferencesString(context, Appconstant.ISRAEL, "unselected");
//                    onBackPressed();
                }
            }
        });
    }

    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.jansss));
                break;
            case 2:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.febsss));
                break;
            case 3:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.marsss));
                break;
            case 4:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.aprsss));
                break;
            case 5:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.maysss));
                break;
            case 6:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.junsss));
                break;
            case 7:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.julsss));
                break;
            case 8:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.augsss));
                break;
            case 9:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.sepsss));
                break;
            case 10:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.octsss));
                break;
            case 11:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.novsss));
                break;
            case 12:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.decsss));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        controller.animationBackward(context);
    }
}
