package com.reformluach.typeface;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class CustomFont {
    public void fontNormal(TextView textView, Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/calibri.ttf");
        textView.setTypeface(face);
    }

    public void fontBold(TextView textView, Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/calibrib.ttf");
        textView.setTypeface(face);
    }

    public void fontLight(TextView textView, Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/calibril.ttf");
        textView.setTypeface(face);
    }
}

