package com.reformluach.fragments;

import android.app.Activity;
import android.content.Context;
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
import com.reformluach.adapters.AdapterEventsParshiyor;
import com.reformluach.models.EventsParsiyor;
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
public class EventsParshiyotChildFragment extends Fragment {
    private View eventsParshiyotFragmentView;
    private Context context;
    private RecyclerView rv_events_parshiyot;
    private AdapterEventsParshiyor adapterEventsParshiyor;
    private ArrayList<EventsParsiyor> data = new ArrayList();
    private EditText searchEditText;
    private Controller controller;
    private int index = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        eventsParshiyotFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventparshiyot_fragment_layout, container, false);
        context = eventsParshiyotFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIds(eventsParshiyotFragmentView);
        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            getJsonDataDiaspora();
        } else {
            getJsonData();
        }
        //controller.getDate();
        return eventsParshiyotFragmentView;
    }

    private void getJsonDataDiaspora() {
        if (data != null && data.size() > 0) {
            data.clear();
        }
        // Reading json file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("torah-diaspora.json")));
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
                String start_date = jsonObj.getString("Start Date");
                String location = jsonObj.getString("Location");
                EventsParsiyor eventsParsiyor = new EventsParsiyor();
                eventsParsiyor.setSubject(subject);
                eventsParsiyor.setLocation(location);
                eventsParsiyor.setStartDate(start_date);
                data.add(eventsParsiyor);
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_parshiyot.getContext(), LinearLayoutManager.VERTICAL, false);
            rv_events_parshiyot.setLayoutManager(linearLayoutManager);
            adapterEventsParshiyor = new AdapterEventsParshiyor(context, data);
            rv_events_parshiyot.setAdapter(adapterEventsParshiyor);
            rv_events_parshiyot.scrollToPosition(index);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getJsonData() {
        if (data != null && data.size() > 0) {
            data.clear();
        }
        // Reading json file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open("torah-israel.json")));
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
                String start_date = jsonObj.getString("Start Date");
                String location = jsonObj.getString("Location");
                EventsParsiyor eventsParsiyor = new EventsParsiyor();
                eventsParsiyor.setSubject(subject);
                eventsParsiyor.setLocation(location);
                eventsParsiyor.setStartDate(start_date);
                data.add(eventsParsiyor);
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_parshiyot.getContext(), LinearLayoutManager.VERTICAL, false);
            rv_events_parshiyot.setLayoutManager(linearLayoutManager);
            adapterEventsParshiyor = new AdapterEventsParshiyor(context, data);
            rv_events_parshiyot.setAdapter(adapterEventsParshiyor);
            rv_events_parshiyot.scrollToPosition(index);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getIds(View eventsParshiyotFragmentView) {
        rv_events_parshiyot = eventsParshiyotFragmentView.findViewById(R.id.rv_events_parshiyot);
        searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //refreshData(s.toString());
                //   adapterEventsParshiyor.refreshData(s);
                callRefresh(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void callRefresh(String s) {
        final ArrayList<EventsParsiyor> filteredList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            final String text = data.get(i).getSubject();
            if (text.contains(s)) {
                filteredList.add(data.get(i));
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_parshiyot.getContext(), LinearLayoutManager.VERTICAL, false);
        rv_events_parshiyot.setLayoutManager(linearLayoutManager);
        adapterEventsParshiyor = new AdapterEventsParshiyor(context, filteredList);
        rv_events_parshiyot.setAdapter(adapterEventsParshiyor);
        adapterEventsParshiyor.notifyDataSetChanged();
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
