package com.reformluach.utils;

import android.app.Activity;
import android.content.Context;

import com.reformluach.R;

public class Animationall {
    //For forward animation
    public void Animallforward(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_exit);
        ;
    }

    //For backward animation
    public void Animallbackward(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_exit);
    }
}