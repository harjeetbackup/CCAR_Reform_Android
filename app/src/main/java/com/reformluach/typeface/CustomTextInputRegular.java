package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Switch;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomTextInputRegular extends Switch {
    public CustomTextInputRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoRegularFont(context));
    }

    public CustomTextInputRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  this.setTypeface(CommonUtils.setFontLight(context));
    }

    public CustomTextInputRegular(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontLight(context));
    }
}