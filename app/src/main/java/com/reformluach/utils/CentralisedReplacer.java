package com.reformluach.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.reformluach.callbacks.ReplacerCallback;

/**
 * Created by admin on 5/3/2017.
 */
public class CentralisedReplacer {
    private Context context;
    private String type;
    private ReplacerCallback replacerCallback;

    public void replaceFragment(Object... args) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) args[0];
        Fragment fragment = (Fragment) args[1];
        int container = (int) args[2];
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        try {
            fragmentTransaction.replace(container, fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        try {
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            Log.e("commit_frag_replace ", e.toString());
        }
    }
}
