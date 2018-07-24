package com.reformluach.fragments;

import android.Manifest;
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
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.reformluach.R;
import com.reformluach.activities.CustomEventsUtilityListActivity;
import com.reformluach.adapters.AdapterCustomEventsList;
import com.reformluach.adapters.CalenderPagerAdapter;
import com.reformluach.models.CustomEventsList;
import com.reformluach.models.ModelForYear;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.SharedPreferencesCalenderSync;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
    private CheckBox cb_major_holidays, cb_minor_holidays, cb_rosh_chodesh, cb_weekly_parshiyot, cb_sefirat, cb_shabatot, cb_modern_holiday,cb_custom_events;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calanderSyncFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.calandersync_fragment_layout, container, false);
        context = calanderSyncFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIds(calanderSyncFragmentView);

        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            getAllEventsDispora();

        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            getAllEventsIsrael();
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




        calenderPagerAdapter = new CalenderPagerAdapter(getActivity(),modelForYears);
        recyclerViewYear.setAdapter(calenderPagerAdapter);
        calenderPagerAdapter.setOnYearSelect(this);

    }

    private void getIds(View calanderSyncFragmentView) {
        tvAdd = calanderSyncFragmentView.findViewById(R.id.tvAdd);
        llMain = calanderSyncFragmentView.findViewById(R.id.llMain);
        cb_major_holidays = calanderSyncFragmentView.findViewById(R.id.cb_major_holidays);
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


        tvAdd.setOnClickListener(this);
        swSync.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                getSelectedCheckBox();
                if (b) {
                    if (getSelectedCheckBox() == 7) {
                        callSelectedJsonMethod();
                        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
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
                    } else {
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

    public void getAllEventsIsrael() {

        String getYear= SharedPreferencesCalenderSync.getInstance(getActivity()).getData("year");

        String url = Url.israelUrlBeforeDate+getYear+Url.israelUrlAfterDate;
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

                                String eventTitle = jsonObject.optString("title");
                                String eventDate  = jsonObject.optString("date");
                                String eventSubCategory = jsonObject.optString("subcat");

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday") &&
                                        eventSubCategory.equalsIgnoreCase("major") && eventSubCategory!=null
                                        && !eventSubCategory.equalsIgnoreCase("null"))
                                {
                                    getMajorHolidays(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday") &&
                                        eventSubCategory.equalsIgnoreCase("minor") && eventSubCategory!=null
                                        && !eventSubCategory.equalsIgnoreCase("null"))
                                {
                                    getMinorHolidays(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("roshchodesh"))
                                {
                                    getRoshChodesh(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("parashat") )
                                {
                                    getWeekendParshiyot(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("omer"))
                                {
                                    getSefiratHaOmer(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday") &&
                                        eventSubCategory.equalsIgnoreCase("shabbat") && eventSubCategory!=null
                                        && !eventSubCategory.equalsIgnoreCase("null"))
                                {
                                    getSpecialShabbat(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday") &&
                                        eventSubCategory.equalsIgnoreCase("modern") && eventSubCategory!=null
                                        && !eventSubCategory.equalsIgnoreCase("null"))
                                {
                                    getModernHolidays(eventTitle,eventDate);
                                    parseItemBeans.add(parseItemBean);
                                }

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


    public void getMajorHolidays(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }

    public void getMinorHolidays(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }

    public void getWeekendParshiyot(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }
    public void getRoshChodesh(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }
    public void getSefiratHaOmer(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }
    public void getSpecialShabbat(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }
    public void getModernHolidays(String title,String date){
        customEventsList = new CustomEventsList();
        customEventsList.setTitle(title);
        customEventsList.setDate(date);
        data.add(customEventsList);
    }

    CalenderPagerAdapter.OnYearSelected onYearSelected;
    @Override
    public void onCourseSelected(boolean isSelected, ModelForYear bean) {

        ArrayList<ModelForYear> modelForYearArrayList = new ArrayList<>();
        calenderPagerAdapter.setOnYearSelect(onYearSelected);
        if (isSelected){
            setSelectedYear = bean.getYear();
            bean.setYear(setSelectedYear);
            modelForYearArrayList.add(bean);
            SharedPreferencesCalenderSync.getInstance(getActivity()).saveData("year",setSelectedYear);
        }
    }
    private void getAllEventsDispora() {

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
                                parseItemBeans.add(parseItemBean);

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
            try {
                // Insert event to calendar
                cr.insert(REMINDERS_URI, values);
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

    private int getSelectedCheckBox() {
        if (cb_major_holidays.isChecked()) {
            return 1;
        }
        if (cb_minor_holidays.isChecked()) {
            return 2;
        }
        if (cb_rosh_chodesh.isChecked()) {
            return 3;
        }
        if (cb_weekly_parshiyot.isChecked()) {
            return 4;
        }
        if (cb_sefirat.isChecked()) {
            return 5;
        }
        if (cb_shabatot.isChecked()) {
            return 6;
        }
        if (cb_modern_holiday.isChecked()) {
            return 7;
        }
//        if (cb_custom_events.isChecked()) {
//            return 8;
//        }
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

    private void getJsonDataMajor() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Major_Holidays.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Json Data Parsing

    private void getJsonDataMinor() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Majer_miner.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonDataRosh() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Rosh_Chodush.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonDataWeekly() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Weakly_parshiyor.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonDataOmer() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("DaysOfOmer.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonDataSpecial() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Special_Shabbatot.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonDataModern() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("Morder_Holiday.json")));
            String temp;
            while ((temp = br.readLine()) != null) sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();
        try {
            JSONObject jsonObjMain = new JSONObject(myjsonstring);
            JSONArray jsonArray = jsonObjMain.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String subject = jsonObj.getString("Subject");
                String date = jsonObj.getString("Start Date");
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void callSelectedJsonMethod() {
        if (getSelectedCheckBox() == 1) {
            getJsonDataMajor();
        } else if (getSelectedCheckBox() == 2) {
            getJsonDataMinor();
        } else if (getSelectedCheckBox() == 3) {
            getJsonDataRosh();
        } else if (getSelectedCheckBox() == 4) {
            getJsonDataWeekly();
        } else if (getSelectedCheckBox() == 5) {
            getJsonDataOmer();
        } else if (getSelectedCheckBox() == 6) {
            getJsonDataSpecial();
        } else if (getSelectedCheckBox() == 7) {
            getJsonDataModern();
        }

//        else if (getSelectedCheckBox() == 8) {
//            getJsonDataCustom();
//        }
    }

    private void getJsonDataCustom() {
        if (controller.getArayList() != null) {
            datacustom = controller.getArayList();
            for (int i = 0; i < datacustom.size(); i++) {
                String subject = datacustom.get(i).getTitle();
                String date = String.valueOf(getMonthInt(datacustom.get(i).getMonth())) + "/" + String.valueOf(datacustom.get(i).getDay()) + "/" + String.valueOf(datacustom.get(i).getYear());
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(subject);
                customEventsList.setDate(date);
                data.add(customEventsList);
            }
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
                Log.e("Data Size", String.valueOf(data.size()));
                for (int i = 0; i < data.size(); i++) {
                    eventdate = data.get(i).date;
                    event = data.get(i).title;
                    timestamp = controller.getUtcTimeInMillis(eventdate);
                    Log.e("Timestamp", "Timestamp" + timestamp);
                    addReminderInCalendar(timestamp, event);
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
                cb_major_holidays.setChecked(false);
            }
            if (cb_minor_holidays.isChecked()) {
                cb_minor_holidays.setChecked(false);
            }
            if (cb_rosh_chodesh.isChecked()) {
                cb_rosh_chodesh.setChecked(false);
            }
            if (cb_weekly_parshiyot.isChecked()) {
                cb_weekly_parshiyot.setChecked(false);
            }
            if (cb_sefirat.isChecked()) {
                cb_sefirat.setChecked(false);
            }
            if (cb_shabatot.isChecked()) {
                cb_shabatot.setChecked(false);
            }
            if (cb_modern_holiday.isChecked()) {
                cb_modern_holiday.setChecked(false);
            }
//            if (cb_custom_events.isChecked()) {
//                cb_custom_events.setChecked(false);
//            }
        }
    }
}
