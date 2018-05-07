package com.reformluach.utils;

import android.content.Context;
import android.content.SharedPreferences;

//Shared preference saved class for saving data in shared preferences
public class SharedPreferenceFileAll {
    private static String file = "ListLync";
    private SharedPreferences ListLync;

    //SharedPrefSave constructor
    public SharedPreferenceFileAll(Context context) {
        ListLync = context.getApplicationContext().getSharedPreferences(file, 0);
    }

    //Shared Preferences saved boolean value
    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor editors = ListLync.edit();
        editors.putBoolean(key, value);
        editors.commit();
    }

    //Shared Preferences saved string value
    public void setString(String key, String value) {
        SharedPreferences.Editor editors = ListLync.edit();
        editors.putString(key, value);
        editors.commit();
    }

    //Shared Preferences saved int value
    public void setInt(String key, int value) {
        SharedPreferences.Editor editors = ListLync.edit();
        editors.putInt(key, value);
        editors.commit();
    }

    //Shared Preferences saved long value
    public void setLong(String key, long value) {
        SharedPreferences.Editor editors = ListLync.edit();
        editors.putLong(key, value);
        editors.commit();
    }

    //Shared Preferences get long value
    public long getLong(String key) {
        long res = ListLync.getLong(key, 0);
        return res;
    }

    //Shared Preferences get boolean value
    public boolean getBoolean(String key) {
        boolean result = ListLync.getBoolean(key, false);
        return result;
    }

    //Shared Preferences get string value
    public String getString(String key) {
        String res = ListLync.getString(key, Appconstant.SHARED_PREFRENCE_NO_DATA_KEY_STRING);
        return res;
    }

    public int getInt(String key) {
        int res = ListLync.getInt(key, Appconstant.SHARED_PREFRENCE_NO_DATA_KEY_INT);
        return res;
    }

    public void clearSharedPreference() {
        SharedPreferences.Editor editors = ListLync.edit();
        editors.clear();
        editors.commit();
    }

    //Remove values from shared preferences
    public void removeSharedPreferences(String key) {
        ListLync.edit().remove(key).commit();
    }
}