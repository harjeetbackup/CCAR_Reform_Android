package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomtextViewFontThin extends TextView {
    public CustomtextViewFontThin(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoThinFont(context));
    }

    public CustomtextViewFontThin(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // this.setTypeface(CommonUtils.setFontRegular(context));
    }

    public CustomtextViewFontThin(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontRegular(context));
    }
}