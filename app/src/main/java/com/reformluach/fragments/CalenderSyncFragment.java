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
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.reformluach.R;
import com.reformluach.activities.SettingsActivity;
import com.reformluach.adapters.AdapterCustomEventsList;
import com.reformluach.adapters.CalenderPagerAdapter;
import com.reformluach.adapters.CalenderSyncEventsAdapter;
import com.reformluach.models.EventListCalenderSync;
import com.reformluach.models.ModelForYear;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.SyncCalendarPref;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class CalenderSyncFragment extends Fragment implements CalenderPagerAdapter.OnYearSelected,CalenderSyncEventsAdapter.OnEventSelected {
    public static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 123;
    private View calanderSyncFragmentView;
    private Context context;
    private SwitchCompat swSync;
    private String eventdate, event;
    private long timestamp;
    private ContentResolver resolver;
    private Controller controller;
    private RecyclerView rvCalendar;
    private AdapterCustomEventsList adapter;
    private LinearLayout llMain;
    private ImageButton imgBtnSettingCalender;
    private Button btnDownloadEvents;
    private TextView tvCalenderType;

    CalenderPagerAdapter calenderPagerAdapter;
    RecyclerView recyclerViewYear;

    RecyclerView recyclerViewEventName;
    CalenderSyncEventsAdapter calenderSyncEventsAdapter;

    private ArrayList<ParseIsraelItemBean> itemBeanArrayList = new ArrayList<>();

    private ArrayList<ModelForYear> mYearsList = new ArrayList<>();
    private Map<String, ArrayList<EventListCalenderSync>> mYearsHolidayCatMap = new HashMap<>();
    String mSelectedYear = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calanderSyncFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.calandersync_fragment_layout, container, false);
        context = calanderSyncFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        tvCalenderType = calanderSyncFragmentView.findViewById(R.id.txtCalenderType);


        getIds(calanderSyncFragmentView);
//
            if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                getAllEventsReform();
                tvCalenderType.setText("R");
            } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                getAllEventsDispora();
                tvCalenderType.setText("D");
            } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                getAllEventsIsrael();
                tvCalenderType.setText("I");
            }
           else {
            tvCalenderType.setText("R");
            getAllEventsReform();
           }

        return calanderSyncFragmentView;

    }

    Iterator iterator;
    private void getAllEventsReform() {

        String urls[] = {Url.israelHolidayUrlBeforeDate + mSelectedYear + Url.israelHolidayUrlAfterDate,
                Url.disporahTorahUrlBeforeDate + mSelectedYear + Url.disporahTorahUrlAfterDate,
                Url.disporahTorahSpecialUrlBeforeDate + mSelectedYear + Url.disporahTorahSpecialUrlAfterDate};
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        for (int i = 0; i < urls.length; i++) {
            final int j = i;
            String urlarray = urls[i];
//        }
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, urlarray, null,
                    new Response.Listener<JSONObject>() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
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


                                itemBeanArrayList.clear();

                                for (int i = 0; i < dataLen; i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    ArrayList<ParseIsraelItemBean> mAllThreeSpecialEvent1 = new ArrayList<>();
                                    ArrayList<ParseIsraelItemBean> mAllThreeSpecialEvent2 = new ArrayList<>();
                                    ArrayList<ParseIsraelItemBean> mAllThreeSpecialEvent3 = new ArrayList<>();


                                    ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();
                                        parseItemBean.setTitle(jsonObject.optString("title"));
                                        parseItemBean.setDate(jsonObject.optString("date"));

                                        parseItemBean.setCategory(jsonObject.optString("category"));
                                        // add values to this collection

                                    if (j==0) {
                                        mAllThreeSpecialEvent1.add(parseItemBean);
                                    }
                                    if (j==1) {
                                        mAllThreeSpecialEvent2.add(parseItemBean);
                                    }if (j==2) {
                                        mAllThreeSpecialEvent3.add(parseItemBean);
                                    }
//                                        itemBeanArrayList.clear();
                                        itemBeanArrayList.addAll(mAllThreeSpecialEvent1);
                                    itemBeanArrayList.addAll(mAllThreeSpecialEvent2);
                                    itemBeanArrayList.addAll(mAllThreeSpecialEvent3);


                                    /* Sorting in decreasing order*/
//                                Collections.sort(mAllEventsReformCalenderData, new Comparator<ParseIsraelItemBean>() {
//                                    @Override
//                                    public int compare(ParseIsraelItemBean o1, ParseIsraelItemBean o2) {
//                                        String date1 = ((ParseIsraelItemBean) o1).getDate();
//                                        String date2 = ((ParseIsraelItemBean) o2).getDate();
//
//                                        return date1.compareTo(date2);
//                                    }
//                                });

                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Response", String.valueOf(error));

                }

            });

            queue.add(objectRequest);
        }

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
        tvCalenderType = calanderSyncFragmentView.findViewById(R.id.txtCalenderType);


//        String year = "";

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


            // Add item to adapter
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


        final LinearLayoutManager layoutManagerEvent = new LinearLayoutManager(getActivity());
        layoutManagerEvent.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEventName.setLayoutManager(layoutManagerEvent);
        layoutManagerEvent.setStackFromEnd(true);
        layoutManagerEvent.setReverseLayout(false);

        calenderSyncEventsAdapter = new CalenderSyncEventsAdapter(getActivity(),
                mYearsHolidayCatMap.get(mSelectedYear), this);
        recyclerViewEventName.setAdapter(calenderSyncEventsAdapter);
    }

    @SuppressLint("NewApi")
    private void getIds(View calanderSyncFragmentView) {
        llMain = calanderSyncFragmentView.findViewById(R.id.llMain);
        swSync = calanderSyncFragmentView.findViewById(R.id.swSync);
        rvCalendar = calanderSyncFragmentView.findViewById(R.id.rvCalendar);
        recyclerViewYear = calanderSyncFragmentView.findViewById(R.id.rvYear);
        recyclerViewEventName = calanderSyncFragmentView.findViewById(R.id.rvEvents);
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

        /*swSync.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            Toast.makeText(context, "No custom events found.", Toast.LENGTH_SHORT).show();
                        }
                    } else if (getSelectedCheckBox() != 0 && getSelectedCheckBox() != 7) {
                        callSelectedJsonMethod();
                        controller.PdStart(context, getString(R.string.sync), R.color.text_grey);
                        new CalenderAsync().execute();

                    }
                    else {
                        compoundButton.setChecked(false);
                        Toast.makeText(context, getString(R.string.select_event), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });*/

        setBgAccordingToMonth(controller.getMonth());
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvCalendar.getContext(), LinearLayoutManager.VERTICAL, false);
            rvCalendar.setLayoutManager(linearLayoutManager);
            adapter = new AdapterCustomEventsList(context, controller.getArayList());
            rvCalendar.setAdapter(adapter);
        }
    }

    @Override
    public void onYearSelected(boolean isSelected, ModelForYear bean) {
        mSelectedYear = bean.getYear();
        calenderSyncEventsAdapter.updateData(mYearsHolidayCatMap.get(mSelectedYear));
    }

    @Override
    public void onEventSelected(EventListCalenderSync bean) {


    }


    public HashMap<String, ArrayList<ParseIsraelItemBean>> getCheckedItems() {

        HashMap<String, ArrayList<ParseIsraelItemBean>> mapEventSync = new HashMap<>();

        ArrayList<EventListCalenderSync> actualEventsList = calenderSyncEventsAdapter.getSelectedData();
        ArrayList<ParseIsraelItemBean> checkedItems = new ArrayList<>();

        for (ParseIsraelItemBean parseItemBean : itemBeanArrayList) {

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
                        if (eventCateg.equals("holiday") && eventSubCateg.equals("shabbat")) {
                            checkedItems.add(parseItemBean);
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


    public void getAllEventsIsrael() {

        String url = Url.israelUrlBeforeDate + mSelectedYear + Url.israelUrlAfterDate;
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

                            itemBeanArrayList.clear();
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


    private void getAllEventsDispora() {

        String url = Url.disporaUrlBeforeDate + mSelectedYear + Url.disporaUrlAfterDate;
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
//        if (cb_custom_events.isChecked()) {
//            values.put(CalendarContract.Events.RRULE, "FREQ=YEARLY");
//            //evt.getStartTime());
//            values.put(CalendarContract.Events.DTSTART, open);
//            values.put(CalendarContract.Events.DURATION, "PT1H");
//        } else {
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
//            values.put(CalendarContract.Calendars.VISIBLE, 1);

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
                } else {
                    //code for deny
//                    swSync.setEnabled(false);
                    btnDownloadEvents.setEnabled(false);
                }
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

//        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
//            getAllEventsReform();
//            tvCalenderType.setText("R");
//        } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
//            getAllEventsDispora();
//            tvCalenderType.setText("D");
//
//        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
//            getAllEventsIsrael();
//            tvCalenderType.setText("I");
//        }
//        else {
//        getAllEventsReform();
//        tvCalenderType.setText("R");
//        }
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




//    private void callSelectedJsonMethod() {
//
//    }



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
                }
            }
            return null;
        }

        @SuppressLint("NewApi")
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            controller.PdStop();
//            swSync.setChecked(false);
            btnDownloadEvents.setEnabled(false);
        }
    }

    private boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisibleToUser){
            if(isVisible && getView() != null) {

                if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                    getAllEventsReform();
                    tvCalenderType.setText("R");
                } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                    getAllEventsDispora();
                    tvCalenderType.setText("D");
                } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                    getAllEventsIsrael();
                    tvCalenderType.setText("I");
                }
                else {
                    getAllEventsReform();
                    tvCalenderType.setText("R");
                }
                getIds(calanderSyncFragmentView);

            }
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
               else  {
                return Appconstant.REFORM;
            }

//            return "";
        }

}
