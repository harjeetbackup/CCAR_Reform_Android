package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomRadioButtonBold extends RadioButton {
    public CustomRadioButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoBoldFont(context));
    }

    public CustomRadioButtonBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  this.setTypeface(CommonUtils.setFontLight(context));
    }

    public CustomRadioButtonBold(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontLight(context));
    }
}