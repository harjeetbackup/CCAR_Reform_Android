package com.reformluach.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.activities.SettingsActivity;
import com.reformluach.adapters.ViewPagerAdapterHome;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class EventsFragment extends Fragment {
    public EditText events_search_edittext;
//    private View eventsFragmentView;
    private Context context;
    private ViewPager viewPager;
    private EventsParshiyotChildFragment eventsParshiyotChildFragment;
    private EventsHolidaysChildFragment eventsHolidaysFragment;
    private EventAllTabFragment mEventAllTabFragment;
//    private Controller controller;
    public TextView tvEvent, tvDate, tvCancel;
    private LinearLayout llMain;

    private ImageButton imgBtnSetting;
    private TabLayout tabLayout;
    private boolean isVisible;
    public TextView tvEventCalenderType;


    public EventsFragment () {
        Log.i("", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View eventsFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.events_fragment_layout, container, false);
        context = eventsFragmentView.getContext();
//        controller = (Controller) context.getApplicationContext();

//        initialiseView(eventsFragmentView);
        return eventsFragmentView;
    }





    private void initialiseView(View rootView) {
        viewPager = rootView.findViewById(R.id.viewPagerEvents);
        tabLayout = rootView.findViewById(R.id.tab_layout);
        tvEvent = rootView.findViewById(R.id.tvEvent);
        tvDate = rootView.findViewById(R.id.tvDate);
        tvCancel = rootView.findViewById(R.id.tvCancelEvents);
        llMain = rootView.findViewById(R.id.llMain);

        tvEventCalenderType = rootView.findViewById(R.id.tvEventCalenderType);

        imgBtnSetting = rootView.findViewById(R.id.ImgBtnSetting);

        imgBtnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);

            }
        });

        setBgAccordingToMonth(Controller.getMonth());


        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    events_search_edittext.setText("");
                }
        });
        events_search_edittext = rootView.findViewById(R.id.events_search_edittext);
        tvEvent.setText(Controller.getPreferencesString((Activity) context, Appconstant.EVENTS_NAME));
        tvDate.setText(Controller.getPreferencesString((Activity) context, Appconstant.HEBREW_MONTH) + " " + getString(R.string.dot) + " " + Controller.getPreferencesString((Activity) context, Appconstant.CURRENT_DATE_MONTH));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        try {
            tabLayout.setupWithViewPager(viewPager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void setupViewPager(ViewPager viewPager) {
//        eventsParshiyotChildFragment = (EventsParshiyotChildFragment) controller.getFragmentInstance(5);
//        eventsHolidaysFragment = (EventsHolidaysChildFragment) controller.getFragmentInstance(6);
//        mEventAllTabFragment = (EventAllTabFragment) controller.getFragmentInstance(7);


        eventsParshiyotChildFragment = new EventsParshiyotChildFragment();
        eventsHolidaysFragment = new EventsHolidaysChildFragment();
        mEventAllTabFragment = new EventAllTabFragment();

        ViewPagerAdapterHome viewPagerAdapterHome = new ViewPagerAdapterHome(getChildFragmentManager());
        viewPagerAdapterHome.addFrag(mEventAllTabFragment, "All");

        viewPagerAdapterHome.addFrag(eventsParshiyotChildFragment, getString(R.string.eventparshiyot_childfragment_name));
        viewPagerAdapterHome.addFrag(eventsHolidaysFragment, getString(R.string.eventholidays_childfragment_name));


        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(viewPagerAdapterHome);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.janss));
                break;
            case 2:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.febss));
                break;
            case 3:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.marss));
                break;
            case 4:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.aprss));
                break;
            case 5:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.mayss));
                break;
            case 6:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.junss));
                break;
            case 7:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.julss));
                break;
            case 8:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.augss));
                break;
            case 9:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.sepss));
                break;
            case 10:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.octss));
                break;
            case 11:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.novss));
                break;
            case 12:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.decss));
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

//        if (selected==true) {
//            setupViewPager(viewPager);
//            tabLayout.setupWithViewPager(viewPager);
//        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        isVisible = isVisibleToUser;

        if(isVisible && getView() != null) {
            if(viewPager == null) {
                initialiseView(getView());
                setupViewPager(viewPager);
            }
        }

    }
//
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        clearTabSetup();
    }
//
    private void clearTabSetup() {
        ViewPagerAdapterHome viewPagerAdapterHome =null;
        viewPager = null;
    }
//
//    public void openEventsAllTab() {
//        if(viewPager != null) {
//            viewPager.setCurrentItem(0);
//        }
//    }


    public void openEventsParshiyotTab() {
        if(viewPager != null) {
            viewPager.setCurrentItem(1);
        }
    }

    public void openEventsHolidayTab() {
        if(viewPager != null) {
            viewPager.setCurrentItem(2);
        }
    }
}
