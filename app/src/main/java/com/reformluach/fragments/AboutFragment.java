package com.reformluach.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.reformluach.R;
import com.reformluach.activities.SettingsActivity;
import com.reformluach.utils.Controller;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class AboutFragment extends Fragment implements View.OnClickListener {
    private View aboutFragmentView;
    private Context context;
    private LinearLayout llMain;
    private Controller controller;
    private ImageView ivSettings;
    private RelativeLayout rlSetting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        aboutFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.about_fragment_layout, container, false);
        context = aboutFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIs(aboutFragmentView);
        return aboutFragmentView;
    }

    private void getIs(View aboutFragmentView) {
        WebView wvAbout = aboutFragmentView.findViewById(R.id.wvAbout);
        llMain = aboutFragmentView.findViewById(R.id.llMain);
        ivSettings = aboutFragmentView.findViewById(R.id.ivSettings);
        rlSetting = aboutFragmentView.findViewById(R.id.rlSetting);
        ivSettings.setOnClickListener(this);
        rlSetting.setOnClickListener(this);
        setBgAccordingToMonth(controller.getMonth());
        wvAbout.loadUrl("file:///android_asset/about.html");
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlSetting:
                Intent intentSetting = new Intent(context, SettingsActivity.class);
                startActivity(intentSetting);
                controller.animationForward(context);
                break;
        }
    }
}
