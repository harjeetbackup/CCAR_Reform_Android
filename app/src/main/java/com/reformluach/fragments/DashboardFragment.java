package com.reformluach.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.adapters.ViewPagerAdapterHomeDash;
import com.reformluach.utils.Controller;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    private View dashboardFragmentView;
    private ViewPager viewPager;
    private LinearLayout bottom_bar_parent, today_parent, events_parent, calander_sync_parent, date_converter_parent, about_parent;
    private TextView today_textview, events_textview, calander_sync_textview, date_converter_textview, about_textview;
    private ImageView today_imageview, events_imageview, calander_sync_imageview, date_converter_imageview, about_imageview;
    private Controller controller;
    private Context context;
    private TodaysFragment todaysFragment;
    private EventsFragment eventsFragment;
    private CalenderSyncFragment calenderSyncFragment;
    private DateConverterFragment dateConverterFragment;
    private AboutFragment aboutFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dashboardFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.dashboard_fragment_layout, container, false);
        context = dashboardFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        initialiseView(dashboardFragmentView);
        return dashboardFragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initialiseView(View rootView) {
        viewPager = rootView.findViewById(R.id.viewPager);
        todaysFragment = (TodaysFragment) controller.getFragmentInstance(0);
        eventsFragment = (EventsFragment) controller.getFragmentInstance(1);
        calenderSyncFragment = (CalenderSyncFragment) controller.getFragmentInstance(2);
        dateConverterFragment = (DateConverterFragment) controller.getFragmentInstance(3);
        aboutFragment = (AboutFragment) controller.getFragmentInstance(4);
        bottom_bar_parent = rootView.findViewById(R.id.bottom_bar_parent);
        today_parent = rootView.findViewById(R.id.today_parent);
        events_parent = rootView.findViewById(R.id.events_parent);
        calander_sync_parent = rootView.findViewById(R.id.calander_sync_parent);
        date_converter_parent = rootView.findViewById(R.id.date_converter_parent);
        date_converter_parent = rootView.findViewById(R.id.date_converter_parent);
        about_parent = rootView.findViewById(R.id.about_parent);
        today_textview = rootView.findViewById(R.id.today_textview);
        events_textview = rootView.findViewById(R.id.events_textview);
        calander_sync_textview = rootView.findViewById(R.id.calander_sync_textview);
        date_converter_textview = rootView.findViewById(R.id.date_converter_textview);
        about_textview = rootView.findViewById(R.id.about_textview);
        today_imageview = rootView.findViewById(R.id.today_imageview);
        events_imageview = rootView.findViewById(R.id.events_imageview);
        calander_sync_imageview = rootView.findViewById(R.id.calander_sync_imageview);
        date_converter_imageview = rootView.findViewById(R.id.date_converter_imageview);
        about_imageview = rootView.findViewById(R.id.about_imageview);
        today_parent.setOnClickListener(this);
        events_parent.setOnClickListener(this);
        calander_sync_parent.setOnClickListener(this);
        date_converter_parent.setOnClickListener(this);
        about_parent.setOnClickListener(this);
        setupViewPager(viewPager);
    }

    ViewPagerAdapterHomeDash viewPagerAdapterHomeDash;
    private void setupViewPager(ViewPager viewPager) {
        todaysFragment = (TodaysFragment) controller.getFragmentInstance(0);
        eventsFragment = (EventsFragment) controller.getFragmentInstance(1);
        calenderSyncFragment = (CalenderSyncFragment) controller.getFragmentInstance(2);
        dateConverterFragment = (DateConverterFragment) controller.getFragmentInstance(3);
        aboutFragment = (AboutFragment) controller.getFragmentInstance(4);
        viewPagerAdapterHomeDash = new ViewPagerAdapterHomeDash(getChildFragmentManager());
        viewPagerAdapterHomeDash.addFrag(todaysFragment);
        viewPagerAdapterHomeDash.addFrag(eventsFragment);
        viewPagerAdapterHomeDash.addFrag(calenderSyncFragment);
        viewPagerAdapterHomeDash.addFrag(dateConverterFragment);
        viewPagerAdapterHomeDash.addFrag(aboutFragment);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(viewPagerAdapterHomeDash);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    selectChanger(R.mipmap.todays_selected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                } else if (position == 1) {
                    selectChanger(R.mipmap.todays_unselected, R.mipmap.event_selected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                } else if (position == 2) {
                    selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_selected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey);
                } else if (position == 3) {
                    selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_selected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey);
                } else if (position == 4) {
                    selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_selected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.today_parent:
                viewPager.setCurrentItem(0);
                selectChanger(R.mipmap.todays_selected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                break;
            case R.id.events_parent:
                viewPager.setCurrentItem(1);
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_selected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                break;
            case R.id.calander_sync_parent:
                viewPager.setCurrentItem(2);
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_selected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey);
                break;
            case R.id.date_converter_parent:
                viewPager.setCurrentItem(3);
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_selected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey);
                break;
            case R.id.about_parent:
                viewPager.setCurrentItem(4);
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_selected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        setupViewPager(viewPager);

    }

    boolean isVisible;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        isVisible = isVisibleToUser;

        if(isVisible && getView() != null) {
            setupViewPager(viewPager);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        clearTabSetup();
    }

//    private void clearTabSetup() {
//        viewPagerAdapterHomeDash =null;
//        viewPager = null;
//    }

    public void selectChanger(Object... args) {
        int imageTodays, imageEvents, imageCalenderSync, imageDateConverter, imageAbout, textTodays, textEvents, textCalenderSync, textDateConverter, textAbout;
        imageTodays = (int) args[0];
        imageEvents = (int) args[1];
        imageCalenderSync = (int) args[2];
        imageDateConverter = (int) args[3];
        imageAbout = (int) args[4];
        textTodays = (int) args[5];
        textEvents = (int) args[6];
        textCalenderSync = (int) args[7];
        textDateConverter = (int) args[8];
        textAbout = (int) args[9];
        controller.imageBackgroundChange(today_imageview, imageTodays);
        controller.imageBackgroundChange(events_imageview, imageEvents);
        controller.imageBackgroundChange(calander_sync_imageview, imageCalenderSync);
        controller.imageBackgroundChange(date_converter_imageview, imageDateConverter);
        controller.imageBackgroundChange(about_imageview, imageAbout);
        controller.textColorChange(today_textview, textTodays, context);
        controller.textColorChange(events_textview, textEvents, context);
        controller.textColorChange(calander_sync_textview, textCalenderSync, context);
        controller.textColorChange(date_converter_textview, textDateConverter, context);
        controller.textColorChange(about_textview, textAbout, context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
