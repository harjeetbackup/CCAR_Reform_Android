package com.reformluach.utils;

import android.util.Log;

public class CatchException {
    public static void ExceptionSend(Exception exception) {
        Log.e("exception", "exception ---  " + exception);
    }
}