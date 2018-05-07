/*
package com.reformluach.typeface;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CustomTabLayoutProfile extends android.support.design.widget.TabLayout {
    public CustomTabLayoutProfile(Context context) {
        super(context);
    }

    public CustomTabLayoutProfile(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayoutProfile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setupWithViewPager(ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        Typeface com.reformluach.typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/MavenPro-Bold.ttf");
        if (com.reformluach.typeface != null) {
            this.removeAllTabs();
            ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);
            FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
            for (int i = 0, count = adapter.getCount(); i < count; i++) {
                Tab tab = this.newTab();
                this.addTab(tab.setText(adapter.getPageTitle(i)));
                AppCompatTextView view = (AppCompatTextView) ((ViewGroup) slidingTabStrip.getChildAt(i)).getChildAt(1);
                view.setTypeface(com.reformluach.typeface, Typeface.NORMAL);
            }
        }
    }
}*/
