package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomSwitchRegular extends android.widget.Switch {
    public CustomSwitchRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoRegularFont(context));
    }

    public CustomSwitchRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomSwitchRegular(Context context) {
        super(context);
    }
}