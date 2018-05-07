package com.reformluach.typeface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.reformluach.utils.Controller;

/**
 * Created by Shishupal Shakya on 10/12/2017.
 */
@SuppressLint("AppCompatCustomView")
public class CustomTextViewFontBold extends TextView {
    public CustomTextViewFontBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Controller.setRobotoBoldFont(context));
    }

    public CustomTextViewFontBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // this.setTypeface(CommonUtils.setFontRegular(context));
    }

    public CustomTextViewFontBold(Context context) {
        super(context);
        //this.setTypeface(CommonUtils.setFontRegular(context));
    }
}