package com.reformluach.utils;

import android.content.Context;

import java.util.ArrayList;

public class SharedPreferencesCalenderSync {

    private static SharedPreferencesCalenderSync userSave;
    private android.content.SharedPreferences sharedPreferences;

    public static SharedPreferencesCalenderSync getInstance(Context context)
    {
        if(userSave==null) {
            userSave = new SharedPreferencesCalenderSync(context);
        }
        return userSave;
    }

    private SharedPreferencesCalenderSync(Context context)
    {
        sharedPreferences=context.getSharedPreferences("Your data has been saved",Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value)
    {
        android.content.SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putString(key,value);
//        spEditor.putBoolean(key,true);
        spEditor.commit();
    }

    public void setUserData(String key, boolean value)
    {
        android.content.SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putBoolean(key,true);
        spEditor.commit();
    }

    public String getData(String key)
    {
        if(sharedPreferences!=null){
            return sharedPreferences.getString(key,"");
        }
        return "";
    }

//    public String getDataArrayList(ArrayList key)
//    {
//        if(sharedPreferences!=null){
//            return sharedPreferences.getStringSet(key,"");
//        }
//        return "";
//    }

    public void clearData()
    {
        android.content.SharedPreferences.Editor csEditor = sharedPreferences.edit();
        csEditor.clear();
        csEditor.commit();
    }


}
