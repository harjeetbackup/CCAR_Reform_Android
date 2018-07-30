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
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.reformluach.R;
import com.reformluach.activities.CustomEventsUtilityListActivity;
import com.reformluach.adapters.AdapterCustomEventsList;
import com.reformluach.adapters.CalenderPagerAdapter;
import com.reformluach.adapters.CalenderSyncEventsAdapter;
import com.reformluach.models.CustomEventsList;
import com.reformluach.models.ModelForYear;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.typeface.CustomCheckBoxRegular;
import com.reformluach.typeface.CustomtextViewFontRegular;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.SharedPreferencesCalenderSync;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class CalenderSyncFragment extends Fragment implements View.OnClickListener, CalenderPagerAdapter.OnYearSelected {
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 123;
    private View calanderSyncFragmentView;
    private Context context;
    private TextView tvAdd/*, tvSettings*/;
    private ArrayList<CustomEventsList> data = new ArrayList<>();
    private ArrayList<CustomEventsList> datacustom = new ArrayList<>();
//    private CheckBox cb_major_holidays, cb_minor_holidays, cb_rosh_chodesh, cb_weekly_parshiyot, cb_sefirat, cb_shabatot, cb_modern_holiday,cb_custom_events;
    private SwitchCompat swSync;
    private String eventdate, event;
    private long timestamp;
    private ContentResolver resolver;
    private Controller controller;
    private RecyclerView rvCalendar;
    private AdapterCustomEventsList adapter;
    private LinearLayout llMain;
    private CustomEventsList customEventsList;

    CalenderPagerAdapter calenderPagerAdapter;
    RecyclerView recyclerViewYear;

    CustomCheckBoxRegular cb_major_holidays, cb_minor_holidays, cb_rosh_chodesh, cb_weekly_parshiyot, cb_sefirat, cb_shabatot, cb_modern_holiday,cb_custom_events;


    private ArrayList<ParseIsraelItemBean> dataToSync = new ArrayList<>();
    private ArrayList<ParseIsraelItemBean> itemBeanArrayList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calanderSyncFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.calandersync_fragment_layout, container, false);
        context = calanderSyncFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        cb_major_holidays = calanderSyncFragmentView.findViewById(R.id.cb_major_holidays);

        getIds(calanderSyncFragmentView);

        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            getAllEventsDispora();

        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            getAllEventsIsrael(setSelectedYear);
        }

        return calanderSyncFragmentView;

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

    private int getMonthInt(String month) {
        if (month.equalsIgnoreCase("January")) {
            return 1;
        } else if (month.equalsIgnoreCase("February")) {
            return 2;
        } else if (month.equalsIgnoreCase("March")) {
            return 3;
        } else if (month.equalsIgnoreCase("April")) {
            return 4;
        } else if (month.equalsIgnoreCase("May")) {
            return 5;
        } else if (month.equalsIgnoreCase("June")) {
            return 6;
        } else if (month.equalsIgnoreCase("July")) {
            return 7;
        } else if (month.equalsIgnoreCase("August")) {
            return 8;
        } else if (month.equalsIgnoreCase("September")) {
            return 9;
        } else if (month.equalsIgnoreCase("October")) {
            return 10;
        } else if (month.equalsIgnoreCase("November")) {
            return 11;
        } else if (month.equalsIgnoreCase("December")) {
            return 12;
        }
        return 0;
    }

    String setSelectedYear = "";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String year = "";

        Calendar calendar = Calendar.getInstance();
        int yearCount = calendar.get(Calendar.YEAR);


        ArrayList<ModelForYear> modelForYears = new ArrayList<>();
        for (int i=0;i<=3;i++){
            year = String.valueOf(yearCount);

            ModelForYear modelForYear = new ModelForYear();
            modelForYear.setYear(year);
            modelForYears.add(modelForYear);

            yearCount = yearCount+1;

        }

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewYear.setLayoutManager(layoutManager);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(false);

        calenderPagerAdapter = new CalenderPagerAdapter(getActivity(),modelForYears,this);
        recyclerViewYear.setAdapter(calenderPagerAdapter);
        calenderPagerAdapter.setOnYearSelect(this);


    }

    private void getIds(View calanderSyncFragmentView) {
        tvAdd = calanderSyncFragmentView.findViewById(R.id.tvAdd);
        llMain = calanderSyncFragmentView.findViewById(R.id.llMain);
//        cb_major_holidays = calanderSyncFragmentView.findViewById(R.id.cb_major_holidays);
        cb_minor_holidays = calanderSyncFragmentView.findViewById(R.id.cb_minor_holidays);
        cb_rosh_chodesh = calanderSyncFragmentView.findViewById(R.id.cb_rosh_chodesh);
        cb_weekly_parshiyot = calanderSyncFragmentView.findViewById(R.id.cb_weekly_parshiyot);
        cb_sefirat = calanderSyncFragmentView.findViewById(R.id.cb_sefirat);
        cb_shabatot = calanderSyncFragmentView.findViewById(R.id.cb_shabatot);
        cb_modern_holiday = calanderSyncFragmentView.findViewById(R.id.cb_modern_holiday);
        cb_custom_events = calanderSyncFragmentView.findViewById(R.id.cb_custom_events);
        swSync = calanderSyncFragmentView.findViewById(R.id.swSync);
        rvCalendar = calanderSyncFragmentView.findViewById(R.id.rvCalendar);
        recyclerViewYear = calanderSyncFragmentView.findViewById(R.id.rvYear);
//        recyclerViewEventList = calanderSyncFragmentView.findViewById(R.id.rvEvents);


        tvAdd.setOnClickListener(this);
        swSync.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                getSelectedCheckBox();
                if (b) {
                    if (getSelectedCheckBox() == 7) {
                        callSelectedJsonMethod();
//                        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
                        if (controller.getEventsList() != null && controller.getEventsList().size() > 0) {

                            controller.PdStart(context, getString(R.string.sync), R.color.text_grey);
                            new CalenderAsync().execute();
                        } else {
                            compoundButton.setChecked(false);
                            cb_custom_events.setChecked(false);
                            Toast.makeText(context, "No custom events found.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (getSelectedCheckBox() != 0 && getSelectedCheckBox() != 7) {
                        callSelectedJsonMethod();
                        controller.PdStart(context, getString(R.string.sync), R.color.text_grey);
                        new CalenderAsync().execute();
                        SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("year",setSelectedYear);
                        SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("majorHolidays", dataToSync.toString());

                    }
                    else {
                        compoundButton.setChecked(false);
                        Toast.makeText(context, getString(R.string.select_event), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




        setBgAccordingToMonth(controller.getMonth());
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvCalendar.getContext(), LinearLayoutManager.VERTICAL, false);
            rvCalendar.setLayoutManager(linearLayoutManager);
            adapter = new AdapterCustomEventsList(context, controller.getArayList());
            rvCalendar.setAdapter(adapter);
        }
    }

    CalenderPagerAdapter.OnYearSelected onYearSelected;
    @Override
    public void onCourseSelected(boolean isSelected, ModelForYear bean,int position) {

        String buttonId;
        ArrayList<ModelForYear> modelForYearArrayList = new ArrayList<>();
        calenderPagerAdapter.setOnYearSelect(onYearSelected);
            if (isSelected) {
                setSelectedYear = bean.getYear();
                bean.setYear(setSelectedYear);
                modelForYearArrayList.add(bean);
                buttonId = String.valueOf(position);
                getAllEventsIsrael(bean.getYear());

//                adapter.notifyItemChanged(position);
            }
    }

    public void getAllEventsIsrael(String year) {

        String selectedYear = setSelectedYear;
        String getYear= SharedPreferencesCalenderSync.getInstance(getActivity()).getData("year");

        String url = Url.israelUrlBeforeDate+setSelectedYear+Url.israelUrlAfterDate;
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", String.valueOf(response));
                        if (getActivity() == null || getContext() == null || getView() == null) {
                            return;
                        }

                        try {
                            JSONObject object = new JSONObject(String.valueOf(response));

                            JSONArray jsonArray = object.getJSONArray("items");
                            int dataLen = jsonArray.length();


                            for (int i = 0; i < dataLen; i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();

                                parseItemBean.setTitle(jsonObject.optString("title"));
                                parseItemBean.setDate(jsonObject.optString("date"));
                                parseItemBean.setCategory(jsonObject.optString("category"));
                                parseItemBean.setSubcat(jsonObject.optString("subcat"));

                                itemBeanArrayList.add(parseItemBean);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Response", String.valueOf(error));
            }

        });
        queue.add(objectRequest);
    }


    public void  major(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            String subcategory = parseIsraelItemBean.getSubcat();
            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("holiday") && subcategory!=null &&
                     !subcategory.equalsIgnoreCase("null")
                    && subcategory.equalsIgnoreCase("major")) {
                dataToSync.add(parseIsraelItemBean);
            }
        }

        Log.i("",""+dataToSync);
    }


    public void getMinorHolidays(){

        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("holiday") &&
                    parseIsraelItemBean.getSubcat().equalsIgnoreCase("minor")
                    && !parseIsraelItemBean.getSubcat().equalsIgnoreCase("null") && parseIsraelItemBean.getSubcat()!=null) {
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }

    public void getWeekendParshiyot(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("parashat")){
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }
    public void getRoshChodesh(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("roshchodesh")){
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }
    public void getSefiratHaOmer(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("omer")){
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }
    public void getSpecialShabbat(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            String subcategory = parseIsraelItemBean.getSubcat();
            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("holiday") &&
                    subcategory.equalsIgnoreCase("shabbat") && subcategory!=null
                    && !subcategory.equalsIgnoreCase("null")){
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }
    public void getModernHolidays(){
        for(ParseIsraelItemBean parseIsraelItemBean : itemBeanArrayList) {

            String subcategory = parseIsraelItemBean.getSubcat();
            if (parseIsraelItemBean.getCategory().equalsIgnoreCase("holiday") &&
                    subcategory.equalsIgnoreCase("modern") && subcategory!=null
                    && !subcategory.equalsIgnoreCase("null")){
                dataToSync.add(parseIsraelItemBean);
            }
        }
    }


    private void getAllEventsDispora() {

        String selectedYear = setSelectedYear;
        String getYear= SharedPreferencesCalenderSync.getInstance(getActivity()).getData("year");

        String url = Url.disporaUrlBeforeDate + getYear + Url.disporaUrlAfterDate;
        // Try to parse JSON

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", String.valueOf(response));
                        if (getActivity() == null || getContext() == null || getView() == null) {
                            return;
                        }

                        try {
                            JSONObject object = new JSONObject(String.valueOf(response));

                            JSONArray jsonArray = object.getJSONArray("items");
                            int dataLen = jsonArray.length();

                            ArrayList<ParseIsraelItemBean> parseItemBeans = new ArrayList<>();


                            for (int i = 0; i < dataLen; i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();

                                parseItemBean.setTitle(jsonObject.optString("title"));
                                parseItemBean.setDate(jsonObject.optString("date"));
                                parseItemBean.setCategory(jsonObject.optString("category"));
                                parseItemBean.setSubcat(jsonObject.optString("subcat"));

                               itemBeanArrayList.add(parseItemBean);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Response", String.valueOf(error));
            }

        });
        queue.add(objectRequest);
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
        if (cb_custom_events.isChecked()) {
            values.put(CalendarContract.Events.RRULE, "FREQ=YEARLY");
            //evt.getStartTime());
            values.put(CalendarContract.Events.DTSTART, open);
            values.put(CalendarContract.Events.DURATION, "PT1H");
        } else {
            values.put(CalendarContract.Events.DTSTART, open);
            //evt.getEndTime())
            values.put(CalendarContract.Events.DTEND, open + 82800000);
        }
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
            values.put(CalendarContract.Calendars.SYNC_EVENTS,1);
            values.put(CalendarContract.Calendars.VISIBLE,1);

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

    String selectedEventYear ="";
    private int getSelectedCheckBox() {
        if (cb_major_holidays.isChecked()) {
            cb_minor_holidays.refreshDrawableState();

            return 1;
        }
        if (cb_minor_holidays.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("minorHolidays",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("minorHolidays").equals("minorHolidays") && selectedEventYear.equals(setSelectedYear)) {
                cb_minor_holidays.setEnabled(false);
            }

            cb_minor_holidays.refreshDrawableState();

            return 2;
        }
        if (cb_rosh_chodesh.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("roshchodesh",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("roshchodesh").equals("roshchodesh") && selectedEventYear.equals(setSelectedYear)) {
                cb_rosh_chodesh.setEnabled(false);
            }
            cb_rosh_chodesh.refreshDrawableState();

            return 3;
        }
        if (cb_weekly_parshiyot.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("weeklyparshiyot",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("weeklyparshiyot").equals("weeklyparshiyot") && selectedEventYear.equals(setSelectedYear)) {
                cb_weekly_parshiyot.setEnabled(false);
            }
            cb_weekly_parshiyot.refreshDrawableState();


            return 4;
        }
        if (cb_sefirat.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("sefiratomer",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("sefiratomer").equals("sefiratomer") && selectedEventYear.equals(setSelectedYear)) {
                cb_sefirat.setEnabled(false);
            }
            cb_sefirat.refreshDrawableState();


            return 5;
        }
        if (cb_shabatot.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("specialshabbat",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("specialshabbat").equals("specialshabbat") && selectedEventYear.equals(setSelectedYear)) {
                cb_shabatot.setEnabled(false);
            }
            cb_shabatot.refreshDrawableState();

            return 6;
        }
        if (cb_modern_holiday.isChecked()) {
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("modernholidays",dataToSync.toString());
            if (SharedPreferencesCalenderSync.getInstance(getActivity()).getData("modernholidays").equals("modernholidays") && selectedEventYear.equals(setSelectedYear)) {
                cb_modern_holiday.setEnabled(false);
            }
            cb_modern_holiday.refreshDrawableState();

            return 7;
        }
        return 0;
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
                } else {
                    //code for deny
                    swSync.setEnabled(false);
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAdd:
                Intent intent = new Intent(context, CustomEventsUtilityListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvCalendar.getContext(), LinearLayoutManager.VERTICAL, false);
            rvCalendar.setLayoutManager(linearLayoutManager);
            adapter = new AdapterCustomEventsList(context, controller.getArayList());
            rvCalendar.setAdapter(adapter);
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




    private void callSelectedJsonMethod() {
        if (getSelectedCheckBox() == 1) {
            major();
        } else if (getSelectedCheckBox() == 2) {
            getMinorHolidays();
        } else if (getSelectedCheckBox() == 3) {
            getRoshChodesh();
        } else if (getSelectedCheckBox() == 4) {
            getWeekendParshiyot();
        } else if (getSelectedCheckBox() == 5) {
            getSefiratHaOmer();
        } else if (getSelectedCheckBox() == 6) {
            getSpecialShabbat();
        } else if (getSelectedCheckBox() == 7) {
            getModernHolidays();
        }


    }



    public class CalenderAsync extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            resolver = context.getContentResolver();
            Uri EVENTS_URI = Uri.parse(getCalendarUriBase(true) + "events");
            deleteEvent(resolver, EVENTS_URI, 1);
            boolean result = checkPermission();
            if (result) {
                Log.e("Data Size", String.valueOf(dataToSync.size()));
                for (int i = 0; i < dataToSync.size(); i++) {
                    eventdate = dataToSync.get(i).getDate();
                    event = dataToSync.get(i).getTitle();
                    timestamp = controller.getUtcTimeInMillisEvents(eventdate);
                    Log.e("Timestamp", "Timestamp" + timestamp);
                    addReminderInCalendar(timestamp, event);

                    String majorlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("majorHolidays");
                    String minorlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("minorHolidays");
                    String roshlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("roshchodesh");
                    String weeklylist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("weeklyparshiyot");
                    String omerlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("sefiratomer");
                    String shabbatlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("specialshabbat");
                    String modernlist = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("modernholidays");
                    String majorYear = SharedPreferencesCalenderSync.getInstance(getActivity()).getData("year");


                    if (result==true) {

                        if (cb_major_holidays.isChecked()) {

                            if (dataToSync.toString().equals(majorlist) && setSelectedYear.equals(majorYear)) {
                                cb_major_holidays.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                    @SuppressLint("NewApi")
                                    @Override
                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                        cb_major_holidays.setEnabled(false);
                                        cb_major_holidays.setBackgroundTintList(getResources().getColorStateList(R.color.color_gray));
                                    }
                                });
//                                cb_major_holidays.setEnabled(false);
                                cb_major_holidays.refreshDrawableState();

//                                cb_major_holidays.setChecked(true);
//                                cb_major_holidays.setBackground(getResources().getDrawable(R.drawable.checkbox_selector));

                            }
                        }
                        if (cb_rosh_chodesh.isChecked()) {

                            if (dataToSync.equals(roshlist)) {
                                cb_rosh_chodesh.setClickable(false);
                                cb_rosh_chodesh.setEnabled(false);

                            }
                        }

                        if (cb_minor_holidays.isChecked()) {

                            if (dataToSync.equals(minorlist)) {
                                cb_minor_holidays.setClickable(false);
                                cb_minor_holidays.setEnabled(false);

                            }
                        }
                        if (cb_sefirat.isChecked()) {

                            if (dataToSync.equals(omerlist)) {
                                cb_sefirat.setClickable(false);
                                cb_sefirat.setEnabled(false);

                            }
                        }

                        if (cb_shabatot.isChecked()) {

                            if (dataToSync.equals(shabbatlist)) {
                                cb_shabatot.setClickable(false);
                                cb_shabatot.setEnabled(false);

                            }
                        }
                        if (cb_weekly_parshiyot.isChecked()) {

                            if (dataToSync.equals(weeklylist)) {
                                cb_weekly_parshiyot.setClickable(false);
                                cb_weekly_parshiyot.setEnabled(false);

                            }
                        }

                        if (cb_modern_holiday.isChecked()) {

                            if (dataToSync.equals(modernlist)) {
                                cb_modern_holiday.setClickable(false);
                                cb_modern_holiday.setEnabled(false);

                            }
                        }
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            controller.PdStop();
            swSync.setChecked(false);
//            swSync.setClickable(false);


            if (cb_major_holidays.isChecked()) {

                cb_major_holidays.setClickable(true);
                cb_major_holidays.setEnabled(true);
            }
            if (cb_minor_holidays.isChecked()) {
                cb_minor_holidays.setChecked(true);
            }
            if (cb_rosh_chodesh.isChecked()) {
                cb_rosh_chodesh.setChecked(true);
            }
            if (cb_weekly_parshiyot.isChecked()) {
                cb_weekly_parshiyot.setChecked(true);
            }
            if (cb_sefirat.isChecked()) {
                cb_sefirat.setChecked(true);
            }
            if (cb_shabatot.isChecked()) {
                cb_shabatot.setChecked(true);
            }
            if (cb_modern_holiday.isChecked()) {
                cb_modern_holiday.setChecked(true);
            }

        }
    }

    private boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisibleToUser){
            if(isVisible && getView() != null) {

                if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                    getAllEventsDispora();

                } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                    getAllEventsIsrael(setSelectedYear);
                }
                getIds(calanderSyncFragmentView);

            }
            }

        }


//    private OnYearSelectedFromCalender onYearSelect;
//
//    public void setOnYearSelect(OnYearSelectedFromCalender onYearSelect) {
//        this.onYearSelect = onYearSelect;
//    }
//
//    public interface OnYearSelectedFromCalender {
//        void onYearSelected(boolean isSelected,int pos);
//    }

}
