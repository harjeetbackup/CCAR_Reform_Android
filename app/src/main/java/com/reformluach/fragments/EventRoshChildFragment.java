package com.reformluach.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.adapters.AdapterEventsHolidays;
import com.reformluach.adapters.AdapterEventsRosh;
import com.reformluach.interfaces.onClickItem;
import com.reformluach.models.EventsHolidays;
import com.reformluach.models.EventsRosh;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */

public class EventRoshChildFragment extends Fragment {
        private View eventsHolidaysFragmentView;
        private Context context;
        private RecyclerView rv_events_holiday;
        private AdapterEventsHolidays adapterEventsHolidays;
        private ArrayList<EventsHolidays> data = new ArrayList();
        private EditText searchEditText;
        private Controller controller;
        private int index = 0;
        private int pos=0;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            eventsHolidaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventholidays_fragment_layout, container, false);
            context = eventsHolidaysFragmentView.getContext();
            controller = (Controller) context.getApplicationContext();
            getIds(eventsHolidaysFragmentView);
            if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                getJsonDataDiaspora();
            } else {
                getJsonData();
            }
            return eventsHolidaysFragmentView;
        }

        private void getJsonDataDiaspora() {
            if (data != null && data.size() > 0) {
                data.clear();
            }
            // Reading json file from assets folder
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(context.getAssets().open("Jewish_holiday.json")));
                String temp;
                while ((temp = br.readLine()) != null) sb.append(temp);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close(); // stop reading
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String myjsonstring = sb.toString();
            // Try to parse JSON
            try {
                // Creating JSONObject from String
                JSONObject jsonObjMain = new JSONObject(myjsonstring);
                // Creating JSONArray from JSONObject
                JSONArray jsonArray = jsonObjMain.getJSONArray("result");
                // JSONArray has x JSONObject
                NavigableSet<Date> dates = new TreeSet<Date>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    // Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    String subject = jsonObj.getString("Subject");
                    String start_date = jsonObj.getString("Start_Date");
                    String location = jsonObj.getString("Location");
                    EventsHolidays eventsHolidays = new EventsHolidays();
                    eventsHolidays.setSubject(subject);
                    eventsHolidays.setLocation(location);
                    eventsHolidays.setStartDate(start_date);
                    data.add(eventsHolidays);
                    dates.add(controller.stringToDate(start_date));
                }



                StringBuffer sb1 = new StringBuffer();
                BufferedReader br1 = null;
                try {
                    br1 = new BufferedReader(new InputStreamReader(context.getAssets().open("Rosh_Chodush.json")));
                    String temp1;
                    while ((temp1 = br1.readLine()) != null) sb1.append(temp1);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        br1.close(); // stop reading
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String myjsonstring1 = sb1.toString();

                // Creating JSONObject from String
                JSONObject jsonObjMain1 = new JSONObject(myjsonstring1);
                // Creating JSONArray from JSONObject
                JSONArray jsonArray1 = jsonObjMain1.getJSONArray("result");
                // JSONArray has x JSONObject
                NavigableSet<Date> dates1 = new TreeSet<Date>();
                for (int i = 0; i < jsonArray1.length(); i++) {
                    // Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray1.getJSONObject(i);
                    String subject = jsonObj.getString("Subject");
                    String start_date = jsonObj.getString("Start_Date");
                    String location = jsonObj.getString("Location");
                    EventsHolidays eventsHolidays = new EventsHolidays();
                    eventsHolidays.setSubject(subject);
                    eventsHolidays.setLocation(location);
                    eventsHolidays.setStartDate(start_date);
                    data.add(eventsHolidays);
                    dates.add(controller.stringToDate(start_date));
                }






                // add some dates to dates
                Date now = new Date();
                // Date lowesthighestDateUpUntilNow = dates.lower(now);
                Date highestDateUpUntilNow = dates.higher(now);
                String dt = controller.dateToString(highestDateUpUntilNow);
                for (int j = 0; j < data.size(); j++) {
                    if (dt.equals(data.get(j).getStartDate())) {
                        index = j;
                    }
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
                rv_events_holiday.setLayoutManager(linearLayoutManager);
                adapterEventsHolidays = new AdapterEventsHolidays(new onClickItem() {
                    @Override
                    public void onSelectedItem(int o) {
                        pos=o;

                        Intent intent = new Intent(context, EventDetailsActivity.class);
                        intent.putExtra("eventType", "Holidays");
                        intent.putExtra("eventName", data.get(pos).getSubject());
                        context.startActivity(intent);
                    }
                },context, data);
                rv_events_holiday.setAdapter(adapterEventsHolidays);
                rv_events_holiday.scrollToPosition(pos);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private void getJsonData() {
            // Reading json file from assets folder
            if (data != null && data.size() > 0) {
                data.clear();
            }
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(context.getAssets().open("Jewish_holiday_Israel.json")));
                String temp;
                while ((temp = br.readLine()) != null) sb.append(temp);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close(); // stop reading
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String myjsonstring = sb.toString();
            // Try to parse JSON
            try {
                // Creating JSONObject from String
                JSONObject jsonObjMain = new JSONObject(myjsonstring);
                // Creating JSONArray from JSONObject
                JSONArray jsonArray = jsonObjMain.getJSONArray("result");
                // JSONArray has x JSONObject
                NavigableSet<Date> dates = new TreeSet<Date>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    // Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    String subject = jsonObj.getString("Subject");
                    String start_date = jsonObj.getString("Start_Date");
                    String location = jsonObj.getString("Location");
                    EventsHolidays eventsHolidays = new EventsHolidays();
                    eventsHolidays.setSubject(subject);
                    eventsHolidays.setLocation(location);
                    eventsHolidays.setStartDate(start_date);
                    data.add(eventsHolidays);
                    dates.add(controller.stringToDate(start_date));
                }








                StringBuffer sb1 = new StringBuffer();
                BufferedReader br1 = null;
                try {
                    br1 = new BufferedReader(new InputStreamReader(context.getAssets().open("Rosh_Chodush_Israel.json")));
                    String temp1;
                    while ((temp1 = br1.readLine()) != null) sb1.append(temp1);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        br1.close(); // stop reading
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String myjsonstring1 = sb1.toString();

                // Creating JSONObject from String
                JSONObject jsonObjMain1 = new JSONObject(myjsonstring1);
                // Creating JSONArray from JSONObject
                JSONArray jsonArray1 = jsonObjMain1.getJSONArray("result");
                // JSONArray has x JSONObject
                NavigableSet<Date> dates1 = new TreeSet<Date>();
                for (int i = 0; i < jsonArray1.length(); i++) {
                    // Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray1.getJSONObject(i);
                    String subject = jsonObj.getString("Subject");
                    String start_date = jsonObj.getString("Start Date");
                    String location = jsonObj.getString("Location");
                    EventsHolidays eventsHolidays = new EventsHolidays();
                    eventsHolidays.setSubject(subject);
                    eventsHolidays.setLocation(location);
                    eventsHolidays.setStartDate(start_date);
                    data.add(eventsHolidays);
                    dates1.add(controller.stringToDate(start_date));
                }






                // add some dates to dates
                Date now = new Date();
                // Date lowesthighestDateUpUntilNow = dates.lower(now);
                Date highestDateUpUntilNow = dates.higher(now);
                String dt = controller.dateToString(highestDateUpUntilNow);
                for (int j = 0; j < data.size(); j++) {
                    if (dt.equals(data.get(j).getStartDate())) {
                        index = j;
                    }
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
                rv_events_holiday.setLayoutManager(linearLayoutManager);
                adapterEventsHolidays = new AdapterEventsHolidays(new onClickItem() {
                    @Override
                    public void onSelectedItem(int o) {
                        pos=o;

                        Intent intent = new Intent(context, EventDetailsActivity.class);
                        intent.putExtra("eventType", "Holidays");
                        intent.putExtra("eventName", data.get(pos).getSubject());
                        context.startActivity(intent);
                    }
                }, context, data);
                rv_events_holiday.setAdapter(adapterEventsHolidays);
                rv_events_holiday.scrollToPosition(pos);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private void getIds(View eventsHolidaysFragmentView) {
            rv_events_holiday = eventsHolidaysFragmentView.findViewById(R.id.rv_events_holiday);
            searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
            searchEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    callRefresh(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

        private void callRefresh(String s) {
            final ArrayList<EventsHolidays> filteredList = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                final String text = data.get(i).getSubject();
                if (text.contains(s)) {
                    filteredList.add(data.get(i));
                }
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
            rv_events_holiday.setLayoutManager(linearLayoutManager);
            adapterEventsHolidays = new AdapterEventsHolidays(new onClickItem() {
                @Override
                public void onSelectedItem(int o) {
                    pos=o;

                    Intent intent = new Intent(context, EventDetailsActivity.class);
                    intent.putExtra("eventType", "Holidays");
                    intent.putExtra("eventName", data.get(pos).getSubject());
                    context.startActivity(intent);
                }
            }, context, filteredList);
            rv_events_holiday.setAdapter(adapterEventsHolidays);
            adapterEventsHolidays.notifyDataSetChanged();
        }

        @Override
        public void onResume() {
            super.onResume();
            if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                getJsonDataDiaspora();
            } else {
                getJsonData();
            }
        }
    }
