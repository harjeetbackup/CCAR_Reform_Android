package com.reformluach.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.fragments.AboutFragment;
import com.reformluach.fragments.CalenderSyncFragment;
import com.reformluach.fragments.DateConverterFragment;
import com.reformluach.fragments.EventsFragment;
import com.reformluach.fragments.TodaysFragment;
import com.reformluach.utils.Controller;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
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
    // private DashboardFragment dashboardFragment;
    private boolean mHasSaveInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        controller = (Controller) context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_dash_board);
        initialiseView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mHasSaveInstanceState = true;
        super.onSaveInstanceState(outState);
    }

    private void initialiseView() {
        todaysFragment = (TodaysFragment) controller.getFragmentInstance(0);
        eventsFragment = (EventsFragment) controller.getFragmentInstance(1);
        calenderSyncFragment = (CalenderSyncFragment) controller.getFragmentInstance(2);
        dateConverterFragment = (DateConverterFragment) controller.getFragmentInstance(3);
        aboutFragment = (AboutFragment) controller.getFragmentInstance(4);
        //dashboardFragment = (DashboardFragment) controller.getFragmentInstance(8);
        bottom_bar_parent = findViewById(R.id.bottom_bar_parent);
        today_parent = findViewById(R.id.today_parent);
        events_parent = findViewById(R.id.events_parent);
        calander_sync_parent = findViewById(R.id.calander_sync_parent);
        date_converter_parent = findViewById(R.id.date_converter_parent);
        date_converter_parent = findViewById(R.id.date_converter_parent);
        about_parent = findViewById(R.id.about_parent);
        today_textview = findViewById(R.id.today_textview);
        events_textview = findViewById(R.id.events_textview);
        calander_sync_textview = findViewById(R.id.calander_sync_textview);
        date_converter_textview = findViewById(R.id.date_converter_textview);
        about_textview = findViewById(R.id.about_textview);
        today_imageview = findViewById(R.id.today_imageview);
        events_imageview = findViewById(R.id.events_imageview);
        calander_sync_imageview = findViewById(R.id.calander_sync_imageview);
        date_converter_imageview = findViewById(R.id.date_converter_imageview);
        about_imageview = findViewById(R.id.about_imageview);
        today_parent.setOnClickListener(this);
        events_parent.setOnClickListener(this);
        calander_sync_parent.setOnClickListener(this);
        date_converter_parent.setOnClickListener(this);
        about_parent.setOnClickListener(this);
        checkIdDataAvailable(todaysFragment.getClass().getName(), todaysFragment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.today_parent:
                selectChanger(R.mipmap.todays_selected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                checkIdDataAvailable(todaysFragment.getClass().getName(), todaysFragment);
                break;
            case R.id.events_parent:
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_selected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey);
                checkIdDataAvailable(eventsFragment.getClass().getName(), eventsFragment);
                break;
            case R.id.calander_sync_parent:
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_selected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey);
                checkIdDataAvailable(calenderSyncFragment.getClass().getName(), calenderSyncFragment);
                break;
            case R.id.date_converter_parent:
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_selected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey);
                checkIdDataAvailable(dateConverterFragment.getClass().getName(), dateConverterFragment);
                break;
            case R.id.about_parent:
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_selected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue);
                checkIdDataAvailable(aboutFragment.getClass().getName(), aboutFragment);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHasSaveInstanceState = false;
    }

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

    private void checkIdDataAvailable(String name, Fragment fragment) {
        boolean fragmentPopped = false;
        try {
            fragmentPopped = getSupportFragmentManager().popBackStackImmediate(name, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragmentPopped) {
            Fragment fragmentGet = getSupportFragmentManager().findFragmentByTag(name);
            if (fragmentGet instanceof TodaysFragment) {
                selectChanger(R.mipmap.todays_selected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof EventsFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_selected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof CalenderSyncFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_selected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof DateConverterFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_selected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey);
            } else if (fragmentGet instanceof AboutFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_selected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue);
            }
        } else {
            controller.fragmentReplacer(DashBoardActivity.this, fragment, R.id.replace_container);
        }
    }

    public void onBackPressed() {
        if (!mHasSaveInstanceState) {
            Log.e("onBackPressed", "onBackPressed   ");
            getSupportFragmentManager().popBackStackImmediate();
            Fragment fragmentGet = getSupportFragmentManager().findFragmentById(R.id.replace_container);
            if (fragmentGet instanceof TodaysFragment) {
                selectChanger(R.mipmap.todays_selected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof EventsFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_selected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof CalenderSyncFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_selected, R.mipmap.datecon_unselected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey, R.color.text_grey);
            } else if (fragmentGet instanceof DateConverterFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_selected, R.mipmap.about_unselected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue, R.color.text_grey);
            } else if (fragmentGet instanceof AboutFragment) {
                selectChanger(R.mipmap.todays_unselected, R.mipmap.event_unselected, R.mipmap.calsync_unselected, R.mipmap.datecon_unselected, R.mipmap.about_selected, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_grey, R.color.text_blue);
            } else {
                finish();
            }
        }
    }
}
