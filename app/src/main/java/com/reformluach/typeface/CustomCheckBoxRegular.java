package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomCheckBoxRegular extends CheckBox {
    public CustomCheckBoxRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoRegularFont(context));
    }

    public CustomCheckBoxRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  this.setTypeface(CommonUtils.setFontLight(context));
    }

    public CustomCheckBoxRegular(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontLight(context));
    }
}