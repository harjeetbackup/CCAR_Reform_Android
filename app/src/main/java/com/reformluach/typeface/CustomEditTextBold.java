package com.reformluach.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.reformluach.utils.Controller;

@SuppressWarnings("ALL")
public class CustomEditTextBold extends EditText {
    public CustomEditTextBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoBoldFont(context));
    }

    public CustomEditTextBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //  this.setTypeface(CommonUtils.setFontLight(context));
    }

    public CustomEditTextBold(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontLight(context));
    }
}