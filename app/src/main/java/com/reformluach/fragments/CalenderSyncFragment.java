package com.reformluach.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.activities.SettingsActivity;
import com.reformluach.adapters.AdapterCustomEventsList;
import com.reformluach.adapters.CalenderPagerAdapter;
import com.reformluach.adapters.CalenderSyncEventsAdapter;
import com.reformluach.models.CustomEventsList;
import com.reformluach.models.EventListCalenderSync;
import com.reformluach.models.ModelForYear;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.EventManager;
import com.reformluach.utils.HttpCall;
import com.reformluach.utils.RequestCall;
import com.reformluach.utils.SyncCalendarPref;
import com.reformluach.utils.UrlModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class CalenderSyncFragment extends Fragment implements CalenderPagerAdapter.OnYearSelected,CalenderSyncEventsAdapter.OnEventSelected {
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 123;
    private Context context;
    private String eventdate, event;
    private long timestamp;
    private ContentResolver resolver;
    private Controller controller;
    private RecyclerView rvCalendar;
    private AdapterCustomEventsList mAdapter;
    private LinearLayout llMain;
    private ImageButton imgBtnSettingCalender;
    private Button btnDownloadEvents;
    private TextView tvCalenderType;

    CalenderPagerAdapter calenderPagerAdapter;
    RecyclerView recyclerViewYear;

    RecyclerView recyclerViewEventName;
    CalenderSyncEventsAdapter calenderSyncEventsAdapter;
    LinearLayoutManager linearLayoutManager;


    private ArrayList<ModelForYear> mYearsList = new ArrayList<>();
    private Map<String, ArrayList<EventListCalenderSync>> mYearsHolidayCatMap = new HashMap<>();
    String mSelectedYear = "";
    private String mSelectedCalType;

    private boolean mIsLoading0, mIsLoading1, mIsLoading2;

    private ArrayList<ParseIsraelItemBean> mReformDataList = new ArrayList<>();
    private ArrayList<ParseIsraelItemBean> mIsarailDataList = new ArrayList<>();
    private ArrayList<ParseIsraelItemBean> mDesporaDataList = new ArrayList<>();

    View calanderSyncFragmentView;
    private boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calanderSyncFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.calandersync_fragment_layout, container, false);
        context = calanderSyncFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        tvCalenderType = calanderSyncFragmentView.findViewById(R.id.txtCalenderType);
        recyclerViewEventName = calanderSyncFragmentView.findViewById(R.id.rvEvents);
        recyclerViewYear = calanderSyncFragmentView.findViewById(R.id.rvYear);
        getIds(calanderSyncFragmentView);

        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("R");
        } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("D");
        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("I");
        }
        else {
            tvCalenderType.setText("R");
        }


        return calanderSyncFragmentView;

    }


    private void getServerCall(final int year) {

        if (getActivity() == null || getContext() == null || getView() == null ) {
            return;
        }

        // TODO, Show Progress Dialog

        UrlModel urlModel = getUrls(""+year);

        ArrayList<String> urls = urlModel.getUrls();
        String from = urlModel.getFrom();


        if(urls.size() == 3 && (mIsLoading0 || mIsLoading1 || mIsLoading2)) {
            return;
        }

        if(urls.size() == 1  && mIsLoading0) {
            return;
        }

        if(urls.size() == 3) {
            mReformDataList = new ArrayList<>();
        }

        mIsLoading0 = true;
        mIsLoading1 = true;
        mIsLoading2 = true;


//        Toast.makeText(getActivity(), "Request", Toast.LENGTH_LONG).show();

        for(String url : urls) {

            HttpCall.getAllEventsReform(from, getActivity(), new RequestCall() {
                @Override
                public void onSuccess(String from, String url, int pageCount, ArrayList<ParseIsraelItemBean> allEventsReformCalenderData) {

                    Log.i("", "");
                    if (getActivity() == null || getContext() == null || getView() == null) {
                        return;
                    }

                    String url0 = Url.israelHolidayUrlBeforeDate + year + Url.israelHolidayUrlAfterDate;
                    String url1 = Url.disporahTorahUrlBeforeDate + year + Url.disporahTorahUrlAfterDate;
                    String url2 = Url.disporahTorahSpecialUrlBeforeDate + year + Url.disporahTorahSpecialUrlAfterDate;

                    if (from.equals(Appconstant.REFORM)) {

                        if (url0.equals(url)) {
                            mIsLoading0 = false;
                        }

                        if (url1.equals(url)) {
                            mIsLoading1 = false;
                        }

                        if (url2.equals(url)) {
                            mIsLoading2 = false;
                        }

                        if (mReformDataList != null) {

                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                            for (ParseIsraelItemBean bean : allEventsReformCalenderData) {
                                String dateStr = bean.getDate();

                                Date date = null;
                                try {
                                    date = format.parse(dateStr);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                bean.setDateTime(date);

                            }

                            if (url0.equals(url) || url1.equals(url)) {
                                mReformDataList.addAll(allEventsReformCalenderData);
                            }
                            if (url1.equals(url) || url2.equals(url)) {
                                mDesporaDataList.addAll(allEventsReformCalenderData);

                            }
//                            mReformDataList.addAll(allEventsReformCalenderData);
//                        }
                            ArrayList<ParseIsraelItemBean> mSpecialDisporaFilteredEvent = new ArrayList<>();

                            if (!mIsLoading2 && !mIsLoading0 && !mIsLoading1) {
                                EventManager.getSpecailDisporaTorahEvents(mDesporaDataList, mSpecialDisporaFilteredEvent);
                                if (mSpecialDisporaFilteredEvent.size()>0) {
                                    for (int i=0; i<mSpecialDisporaFilteredEvent.size(); i++)
                                        mReformDataList.add(mSpecialDisporaFilteredEvent.get(i));
                                }


                                Set<ParseIsraelItemBean> hs = new HashSet<>();
                                hs.addAll(mReformDataList);
                                mReformDataList.clear();
                                mReformDataList.addAll(hs);


                                Collections.sort(mReformDataList);

//                                Collections.sort(mReformDataList);
                                // TODO, Dismiss Progress Dialog
                            }
                        }
                    } else if (from.equals(Appconstant.ISRAEL)) {
                        mIsLoading0 = false;
                        mIsarailDataList.addAll(allEventsReformCalenderData);
                        // TODO, Dismiss Progress Dialog
                    } else if (from.equals(Appconstant.DIASPORA)) {
                        mIsLoading0 = false;
                        mDesporaDataList.addAll(allEventsReformCalenderData);
                        // TODO, Dismiss Progress Dialog
                    }

                }

                @Override
                public void onError(String url, int pageCount, String error) {
                    mIsLoading0 = false;
                    mIsLoading1 = false;
                    mIsLoading2 = false;
                }
            }, url, Integer.parseInt(mSelectedYear));
        }

    }

    private UrlModel getUrls(String year) {
        UrlModel urlModel = new UrlModel();

        if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
            urlModel.add(Url.israelHolidayUrlBeforeDate + year + Url.israelHolidayUrlAfterDate);
            urlModel.add(Url.disporahTorahUrlBeforeDate + year + Url.disporahTorahUrlAfterDate);
            urlModel.add(Url.disporahTorahSpecialUrlBeforeDate + year + Url.disporahTorahSpecialUrlAfterDate);

            urlModel.setFrom(Appconstant.REFORM);
        }
        else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            urlModel.add(Url.disporaUrlBeforeDate + year + Url.disporaUrlAfterDate);
            urlModel.setFrom(Appconstant.DIASPORA);

        }
        else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            urlModel.add(Url.israelUrlBeforeDate + year + Url.israelUrlAfterDate);
            urlModel.setFrom(Appconstant.ISRAEL);
        }
        else {  // Default should be Reform
            urlModel.add(Url.israelHolidayUrlBeforeDate + year + Url.israelHolidayUrlAfterDate);
            urlModel.add(Url.disporahTorahUrlBeforeDate + year + Url.disporahTorahUrlAfterDate);
            urlModel.add(Url.disporahTorahSpecialUrlBeforeDate + year + Url.disporahTorahSpecialUrlAfterDate);
            urlModel.setFrom(Appconstant.REFORM);
        }
        return urlModel;
    }


    private void deleteEvent(ContentResolver resolver, Uri baseUri, int calendarId) {
        try {
            Cursor cursor;
            if (Build.VERSION.SDK_INT <= 7) { //up-to Android 2.1
                cursor = resolver.query(baseUri, new String[]{"_id"}, "Calendars._id=" + calendarId, null, null);
            } else { //8 is Android 2.2 (Froyo) (http://developer.android.com/reference/android/os/Build.VERSION_CODES.html)
                cursor = resolver.query(baseUri, new String[]{"_id"}, "calendar_id=" + calendarId, null, null);
            }
            assert cursor != null;
            while (cursor.moveToNext()) {
                long eventId = cursor.getLong(cursor.getColumnIndex("_id"));
                resolver.delete(ContentUris.withAppendedId(baseUri, eventId), null, null);
                Log.e("Event deleted :: ID :: ", "Event deleted :: ID :: " + eventId);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



//        String year = "";

        getCalEventList();


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onResume() {
        super.onResume();

        if(!isVisible) {
            return;
        }


        if(mSelectedCalType == null || !mSelectedCalType.equalsIgnoreCase(HttpCall.getSelectedCalendarType(getActivity())) || !mSelectedCalType.equals("null")) {
            mSelectedCalType = HttpCall.getSelectedCalendarType(getActivity());

//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvCalendar.getContext(), LinearLayoutManager.VERTICAL, false);
//            rvCalendar.setLayoutManager(linearLayoutManager);
//            mAdapter = new AdapterCustomEventsList(context, new ArrayList<CustomEventsList>());
//            rvCalendar.setAdapter(mAdapter);
//            final LinearLayoutManager layoutManagerEvent = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerViewEventName.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setStackFromEnd(true);
            linearLayoutManager.setReverseLayout(false);

            calenderSyncEventsAdapter = new CalenderSyncEventsAdapter(getActivity(),
                    mYearsHolidayCatMap.get(mSelectedYear), this);
            recyclerViewEventName.setAdapter(calenderSyncEventsAdapter);

            mDesporaDataList.clear();
            mReformDataList.clear();
            mIsarailDataList.clear();
        }

        if (isVisible ){
            getServerCall(Integer.parseInt(mSelectedYear));
            getSelectedCalendar(controller);
        }

        if (isVisible){
            if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                tvCalenderType.setText("R");
            } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                tvCalenderType.setText("D");
            } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                tvCalenderType.setText("I");
            }
            else {
                tvCalenderType.setText("R");
            }
        }

        getIds(calanderSyncFragmentView);
        getCalEventList();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisibleToUser){
            if(isVisible && getView() != null) {
                getIds(getView());
                checkPermission();
//                registerCalenderType();

            }
        }


        if (isVisible ) {
            if(shouldRequestDataAgain()) {
                getServerCall(Integer.parseInt(mSelectedYear));
                registerCalenderType();
            }
        }


    }

    @SuppressLint("NewApi")
    private void getIds(View calanderSyncFragmentView) {
        llMain = calanderSyncFragmentView.findViewById(R.id.llMainCalender);
//        recyclerViewYear = calanderSyncFragmentView.findViewById(R.id.rvYear);
//        recyclerViewEventName = calanderSyncFragmentView.findViewById(R.id.rvEvents);
        imgBtnSettingCalender = calanderSyncFragmentView.findViewById(R.id.ImgBtnSettingCalender);
        btnDownloadEvents = calanderSyncFragmentView.findViewById(R.id.btnDownloadEvents);

        imgBtnSettingCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        btnDownloadEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( getCheckedItems().size()!=0) {
                    controller.PdStart(context, getString(R.string.sync), R.color.text_grey);
                    new CalenderAsync(getCheckedItems()).execute();
                }
            }
        });


        setBgAccordingToMonth(controller.getMonth());
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvCalendar.getContext(), LinearLayoutManager.VERTICAL, false);
            rvCalendar.setLayoutManager(linearLayoutManager);
            mAdapter = new AdapterCustomEventsList(context, controller.getArayList());
            rvCalendar.setAdapter(mAdapter);
        }
    }

    @Override
    public void onYearSelected(boolean isSelected, ModelForYear bean) {

        mDesporaDataList.clear();
        mReformDataList.clear();
        mIsarailDataList.clear();

        mSelectedYear = bean.getYear();
        getServerCall(Integer.parseInt(bean.getYear()));
        calenderSyncEventsAdapter.updateData(mYearsHolidayCatMap.get(mSelectedYear));
    }

    @Override
    public void onEventSelected(EventListCalenderSync bean) {


    }


    public HashMap<String, ArrayList<ParseIsraelItemBean>> getCheckedItems() {

        HashMap<String, ArrayList<ParseIsraelItemBean>> mapEventSync = new HashMap<>();

        ArrayList<EventListCalenderSync> actualEventsList = calenderSyncEventsAdapter.getSelectedData();
        ArrayList<ParseIsraelItemBean> checkedItems = new ArrayList<>();

        final ArrayList<ParseIsraelItemBean> selectedCalHolidayList = new ArrayList<>(getSelectedCalHolidayList());

        for (ParseIsraelItemBean parseItemBean : selectedCalHolidayList) {

            String eventSubCateg = "";
            if (parseItemBean.getSubcat()!=null) {
                 eventSubCateg = parseItemBean.getSubcat();
            }else {
                eventSubCateg = "";
            }
            String eventCateg = parseItemBean.getCategory();

            for (int i = 0; i < actualEventsList.size(); i++) {
                EventListCalenderSync eventListCalenderSync = actualEventsList.get(i);

                boolean slectedEvent = actualEventsList.get(i).isSelected();
                if (eventListCalenderSync.getEventname().equals("Major Holidays") && slectedEvent == true) {

                        if (eventCateg.equals("holiday") && eventSubCateg.equals("major")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Major Holidays", checkedItems);
                        }

                }

                if (eventListCalenderSync.getEventname().equals("Minor Holidays") && slectedEvent == true) {
                        if (eventCateg.equals("holiday") && eventSubCateg.equals("minor")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Minor Holidays", checkedItems);
                        }
                }

                if (eventListCalenderSync.getEventname().equals("Weekly Parshiyot") && slectedEvent == true) {
                        if (eventCateg.equals("parashat")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Weekly Parshiyot", checkedItems);
                        }
                }

                if (eventListCalenderSync.getEventname().equals("Rosh Chodesh") && slectedEvent == true) {
                        if (eventCateg.equals("roshchodesh")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Rosh Chodesh", checkedItems);
                        }

                }

                if (eventListCalenderSync.getEventname().equals("Sefirat Ha'Omer") && slectedEvent == true) {
                        if (eventCateg.equals("omer")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Sefirat Ha'Omer", checkedItems);
                        }

                }

                if (eventListCalenderSync.getEventname().equals("Special Shabatot") && slectedEvent == true) {
                        if (eventCateg.equals("holiday") && eventSubCateg.equals("shabbat")|| eventSubCateg.equals("")) {
                            ArrayList<ParseIsraelItemBean> shab = new ArrayList<>();
                            if (eventCateg.equals("holiday") && eventSubCateg.equals("shabbat")) {
                                shab.add(parseItemBean);
                            }
                            if (eventCateg.equals("holiday") && eventSubCateg.equals("")) {
                                shab.add(parseItemBean);
                            }
                            checkedItems.addAll(shab);
//                                checkedItems.add(parseItemBean);
                            mapEventSync.put("Special Shabatot", checkedItems);
                        }
                }
                if (eventListCalenderSync.getEventname().equals("Modern Holidays") && slectedEvent == true) {
                        if (eventCateg.equals("holiday") && eventSubCateg.equals("modern")) {
                            checkedItems.add(parseItemBean);
                            mapEventSync.put("Modern Holidays", checkedItems);
                        }
                }

            }

        }
        return mapEventSync;
    }


    private void addReminderInCalendar(long open, String name) {
        Calendar cal = Calendar.getInstance();
        Uri EVENTS_URI = Uri.parse(getCalendarUriBase(true) + "events");
        ContentResolver cr = context.getContentResolver();
        TimeZone timeZone = TimeZone.getDefault();
        /** Inserting an event in calendar. */
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        values.put(CalendarContract.Events.TITLE, name);
        values.put(CalendarContract.Events.DTSTART, open);
        //evt.getEndTime())
        values.put(CalendarContract.Events.DTEND, open + 82800000);
//        }
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
        values.put(CalendarContract.Events.ALL_DAY, 1);
        values.put(CalendarContract.Events.HAS_ALARM, 1);
        Uri event = cr.insert(EVENTS_URI, values);
        // Display event id.
        Log.e("Event added :: ID :: ", "Event added :: ID :: " + event.getLastPathSegment());
        /** Adding reminder for event added. */
        try {
            Uri REMINDERS_URI = Uri.parse(getCalendarUriBase(true) + "reminders");
            values = new ContentValues();
            values.put(CalendarContract.Reminders.EVENT_ID, Long.parseLong(event.getLastPathSegment()));
            values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
            values.put(CalendarContract.Reminders.MINUTES, 15);
            values.put(CalendarContract.Calendars.SYNC_EVENTS, 1);
            values.put(CalendarContract.Calendars.VISIBLE, 1);

            cr.update(
                    ContentUris.withAppendedId(REMINDERS_URI,
                            Long.parseLong(event.getLastPathSegment())), values, null, null);
            try {
                // Insert event to calendar
                cr.insert(REMINDERS_URI, values);
//                cr.update(REMINDERS_URI,values,name,name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private String getCalendarUriBase(boolean eventUri) {
        Uri calendarURI = null;
        try {
            if (android.os.Build.VERSION.SDK_INT <= 7) {
                calendarURI = (eventUri) ? Uri.parse("content://calendar/") : Uri.parse("content://calendar/calendars");
            } else {
                calendarURI = (eventUri) ? Uri.parse("content://com.android.calendar/") : Uri.parse("content://com.android.calendar/calendars");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendarURI.toString();
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public boolean checkPermission() {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.WRITE_CALENDAR)) {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_CALENDAR:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    addReminderInCalendar(timestamp, event);
//                    btnDownloadEvents.setEnabled(true);

                } else {
                    //code for deny
                    btnDownloadEvents.setEnabled(false);
                }
                break;
        }
    }





    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.jans));
                break;
            case 2:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.febs));
                break;
            case 3:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.mars));
                break;
            case 4:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.aprs));
                break;
            case 5:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.mays));
                break;
            case 6:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.juns));
                break;
            case 7:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.juls));
                break;
            case 8:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.augs));
                break;
            case 9:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.seps));
                break;
            case 10:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.octs));
                break;
            case 11:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.novs));
                break;
            case 12:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.decs));
                break;
        }
    }


    public class CalenderAsync extends AsyncTask {

        private HashMap<String, ArrayList<ParseIsraelItemBean>> mapEvent;
        private String selectedCal;

        public CalenderAsync (HashMap<String, ArrayList<ParseIsraelItemBean>> mapEvent) {
            this.mapEvent= mapEvent;
            selectedCal = getSelectedCalendar(controller);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // TODO, Show update dialog
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            resolver = context.getContentResolver();
            Uri EVENTS_URI = Uri.parse(getCalendarUriBase(true) + "events");
//            deleteEvent(resolver, EVENTS_URI, 1);
            boolean result = checkPermission();
            if (result) {

                for (Map.Entry<String, ArrayList<ParseIsraelItemBean>> entry : mapEvent.entrySet()) {
                    String key = entry.getKey();
                    final ArrayList<ParseIsraelItemBean> checkedItems = entry.getValue();

                    Log.e("Data Size", String.valueOf(checkedItems.size()));
                    for (int i = 0; i < checkedItems.size(); i++) {
                        eventdate = checkedItems.get(i).getDate();
                        event = checkedItems.get(i).getTitle();
                        timestamp = controller.getUtcTimeInMillisEvents(eventdate);
                        Log.e("Timestamp", "Timestamp" + timestamp);
                        addReminderInCalendar(timestamp, event);
                    }
                    SyncCalendarPref.getInstance(context).successEventSyncStatus(mSelectedYear, key, true, selectedCal);
                    for (int i=0; i<mYearsHolidayCatMap.get(mSelectedYear).size(); i++) {
                       if (mYearsHolidayCatMap.get(mSelectedYear).get(i).getEventname().equalsIgnoreCase(key)) {
                           mYearsHolidayCatMap.get(mSelectedYear).get(i).setSync(true);
                           mYearsHolidayCatMap.get(mSelectedYear).get(i).setSelected(false);
                       }
                    }
                }
            }
            return null;
        }

        @SuppressLint("NewApi")
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            controller.PdStop();
            calenderSyncEventsAdapter.updateData(mYearsHolidayCatMap.get(mSelectedYear));
            btnDownloadEvents.setEnabled(true);
        }

    }


    public void registerCalenderType(){
//        tvCalenderType = getView().findViewById(R.id.txtCalenderType);

        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("R");
        } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("D");
        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            tvCalenderType.setText("I");
        }
        else {
            tvCalenderType.setText("R");
        }
    }

        private String getSelectedCalendar(Controller controller) {

            if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                return Appconstant.REFORM;
            } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                return Appconstant.DIASPORA;
            } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                return Appconstant.ISRAEL;
            }
            else {
                return Appconstant.REFORM;
            }
//            return "";
        }


        private ArrayList<ParseIsraelItemBean> getSelectedCalHolidayList() {

            if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                return mReformDataList;
            } else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                return mDesporaDataList;
            } else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                return mIsarailDataList;
            }
            else {
                return mReformDataList;
            }
        }


        private boolean shouldRequestDataAgain() {
            if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                return mReformDataList.size()==0;
            } else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                return mDesporaDataList.size()==0;
            } else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                return mIsarailDataList.size()==0;
            } else {
                return mReformDataList.size()==0;
            }
        }

        public void getCalEventList() {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);

            final String selectedCalendar = getSelectedCalendar(controller);
            mYearsList.clear();
            for (int i = 0; i <= 3; i++) {
                ModelForYear modelForYear = new ModelForYear();
                String yearStr = "" + year;
                modelForYear.setYear(yearStr);
                if (i == 0) {
                    modelForYear.setSelected(true);
                    mSelectedYear = yearStr;
                }
                mYearsList.add(modelForYear);


                ArrayList<EventListCalenderSync> eventListCalenderSyncArrayList = new ArrayList<>();


                // Add item to mAdapter
                EventListCalenderSync event1 = new EventListCalenderSync("Major Holidays", "");
                EventListCalenderSync newUser2 = new EventListCalenderSync("Minor Holidays", "(Tu B'Sh'vat, Lag Ba'Omer,...)");
                EventListCalenderSync newUser3 = new EventListCalenderSync("Rosh Chodesh", "");
                EventListCalenderSync newUser4 = new EventListCalenderSync("Weekly Parshiyot", "");
                EventListCalenderSync newUser5 = new EventListCalenderSync("Sefirat Ha'Omer", "");
                EventListCalenderSync newUser6 = new EventListCalenderSync("Special Shabatot", "(Shabbat Sh'kalim, Zachor,...)");
                EventListCalenderSync newUser7 = new EventListCalenderSync("Modern Holidays", "(Yom HaShoah V'hag'vurah, Yom Ha'atzma'ut,...)");

                eventListCalenderSyncArrayList.add(event1);
                eventListCalenderSyncArrayList.add(newUser2);
                eventListCalenderSyncArrayList.add(newUser3);
                eventListCalenderSyncArrayList.add(newUser4);
                eventListCalenderSyncArrayList.add(newUser5);
                eventListCalenderSyncArrayList.add(newUser6);
                eventListCalenderSyncArrayList.add(newUser7);

                for (EventListCalenderSync event : eventListCalenderSyncArrayList) {
                    boolean isSync = SyncCalendarPref.getInstance(getActivity()).isEventSynced(yearStr, event.getEventname(), selectedCalendar);
                    event.setSync(isSync);
                }

                mYearsHolidayCatMap.put("" + year, eventListCalenderSyncArrayList);

                year++;
            }

            final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerViewYear.setLayoutManager(layoutManager);
            layoutManager.setStackFromEnd(true);
            layoutManager.setReverseLayout(false);

            calenderPagerAdapter = new CalenderPagerAdapter(getActivity(), mYearsList, this);
            recyclerViewYear.setAdapter(calenderPagerAdapter);
            calenderPagerAdapter.setOnYearSelect(this);


//            final LinearLayoutManager layoutManagerEvent = new LinearLayoutManager(getActivity());
//            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            linearLayoutManager = new LinearLayoutManager(getActivity());

            recyclerViewEventName.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setStackFromEnd(true);
            linearLayoutManager.setReverseLayout(false);

            calenderSyncEventsAdapter = new CalenderSyncEventsAdapter(getActivity(),
                    mYearsHolidayCatMap.get(mSelectedYear), this);
            recyclerViewEventName.setAdapter(calenderSyncEventsAdapter);
        }

}
