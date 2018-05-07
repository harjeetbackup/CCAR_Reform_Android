package com.reformluach.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class ViewsChanges {
    public void imageBackgroundChange(ImageView imageView, int res) {
        imageView.setBackgroundResource(res);
    }

    public void textColorChange(TextView textView, int color, Context context) {
        textView.setTextColor(ContextCompat.getColor(context, color));
    }

    public void textColorChange(RadioButton radioButton, int color, Context context) {
        radioButton.setTextColor(ContextCompat.getColor(context, color));
    }
}