package com.reformluach.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.reformluach.fragments.AboutFragment;
import com.reformluach.fragments.CalenderSyncFragment;
import com.reformluach.fragments.DateConverterFragment;
import com.reformluach.fragments.EventsFragment;
import com.reformluach.fragments.TodaysFragment;

public class TabMainAdapter extends FragmentPagerAdapter{

    private final int FRAGMENT_1=0;
    private final int FRAGMENT_2=1;
    private final int FRAGMENT_3=2;
    private final int FRAGMENT_4=3;
    private final int FRAGMENT_5=4;


    public TabMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        switch (position){
            case FRAGMENT_1:
                return TodaysFragment.getInstance(bundle);
            case FRAGMENT_2:
                return EventsFragment.getInstance(bundle);
            case FRAGMENT_3:
                return CalenderSyncFragment.getInstance(bundle);
            case FRAGMENT_4:
                return DateConverterFragment.getInstance(bundle);
            case FRAGMENT_5:
                return AboutFragment.getInstance(bundle);

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case FRAGMENT_1:
                return "";
            case FRAGMENT_2:
                return "";
            case FRAGMENT_3:
                return "";
            case FRAGMENT_4:
                return "";
            case FRAGMENT_5:
                return "";

        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }


}
