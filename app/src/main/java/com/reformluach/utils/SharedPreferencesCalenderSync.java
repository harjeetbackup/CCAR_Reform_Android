package com.reformluach.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reformluach.fragments.CalenderSyncFragment;
import com.reformluach.models.ParseIsraelItemBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

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

    public void saveDataSet(String key, Set<String> set )
    {
        android.content.SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putStringSet(key,set);
//        spEditor.putBoolean(key,true);
        spEditor.commit();
    }

    public Set<String> getDataSet(Set<String> key)
    {
        if(sharedPreferences!=null){
            return sharedPreferences.getStringSet(String.valueOf(key),null);
        }
        return key;
    }

    public String getData(String key)
    {
        if(sharedPreferences!=null){
            return sharedPreferences.getString(key,"");
        }
        return "";
    }

    public void saveArrayList(ArrayList<ParseIsraelItemBean> list, String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<ParseIsraelItemBean> getArrayList(String key){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<ParseIsraelItemBean>>() {}.getType();
        return gson.fromJson(json, type);
    }



    public void clearData()
    {
        android.content.SharedPreferences.Editor csEditor = sharedPreferences.edit();
        csEditor.clear();
        csEditor.commit();
    }


}
