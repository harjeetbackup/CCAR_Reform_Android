package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomButtonBold extends Button {
    public CustomButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoBoldFont(context));
    }

    public CustomButtonBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  this.setTypeface(CommonUtils.setFontLight(context));
    }

    public CustomButtonBold(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontLight(context));
    }
}