package com.reformluach.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SyncCalendarPref {

    private static SyncCalendarPref sSyncCalendarPref;

    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;

    private String delimeter = "_";


    public static SyncCalendarPref getInstance(Context context) {
        if(sSyncCalendarPref == null) {
            sSyncCalendarPref = new SyncCalendarPref(context);
        }
        return sSyncCalendarPref;
    }

    private SyncCalendarPref(Context context) {
        mSharedPreference = context.getSharedPreferences("sync.xml", Context.MODE_PRIVATE);
        mEditor = mSharedPreference.edit();
    }

    public boolean isEventSynced(String year, String holidayCatType, String calType) {
        return mSharedPreference.getBoolean(year+delimeter+holidayCatType+delimeter+calType, false);
    }

    public void successEventSyncStatus(String year, String holidayCatType, boolean syncStatus, String calType) {
        mEditor.putBoolean(year+delimeter+holidayCatType+delimeter+calType, syncStatus);
        mEditor.commit();
    }


}
