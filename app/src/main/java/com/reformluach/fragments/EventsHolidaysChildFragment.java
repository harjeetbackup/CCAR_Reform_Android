package com.reformluach.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.adapters.AdapterEventsHolidays;
import com.reformluach.adapters.EventsDisporaHolidayAdapter;
import com.reformluach.adapters.EventsIsraelHolidayAdpater;
import com.reformluach.adapters.EventsParshiyotDisporaAdpater;
import com.reformluach.adapters.EventsParshiyotIsraelAdapter;
import com.reformluach.interfaces.onClickItem;
import com.reformluach.models.EventsHolidays;
import com.reformluach.models.ParseDisporaItemBean;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.EndlessScrollListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */
public class EventsHolidaysChildFragment extends Fragment {
    private View eventsHolidaysFragmentView;
    private Context context;
    private RecyclerView rv_events_holiday;
    private AdapterEventsHolidays adapterEventsHolidays;
    private ArrayList<EventsHolidays> data = new ArrayList();
    private EditText searchEditText;
    private Controller controller;
    private int index = 0;
    private int pos=0;

    private EventsIsraelHolidayAdpater eventsIsraelHolidayAdpater ;
    private ArrayList<ParseIsraelItemBean> parseIsraelItemBeanArrayList = new ArrayList<>();

    private EventsDisporaHolidayAdapter eventsDisporaHolidayAdapter;
    private ArrayList<ParseDisporaItemBean> parseDisporaItemBeanArrayList = new ArrayList<>();
    int pageCount = 0;
    int mCurrentPage = -1;

    LinearLayoutManager layoutManager;
    private boolean isNeedToRefresh = false;
    private int yearCount = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        eventsHolidaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventholidays_fragment_layout, container, false);
        context = eventsHolidaysFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIds(eventsHolidaysFragmentView);

        pageCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        yearCount = Integer.parseInt(sdf.format(date));

        layoutManager = new LinearLayoutManager(getActivity());


        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            getAllEventsDispora();
        }else if (controller.getPreferencesString((Activity) context,Appconstant.ISRAEL).equalsIgnoreCase("selected")){
            getAllEventsIsrael();
        }

        return eventsHolidaysFragmentView;
    }


    private void getAllEventsIsrael() {

//        String url = Url.israelUrl;
        // Try to parse JSON
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        String year = "";

        if (pageCount == 0) {

            year = sdf.format(date);
        } else
        if (pageCount >= 1 ) {
            year = String.valueOf(yearCount+1);
            yearCount ++;
        }


        String url =  Url.israelUrlBeforeDate+year+Url.israelUrlAfterDate;
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", String.valueOf(response));
                        if (getActivity()==null||getContext()==null||getView()==null){
                            return;
                        }

                        rv_events_holiday.clearOnScrollListeners();
                        rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                        rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());

                        mCurrentPage = pageCount;


                        try {
                            JSONObject object = new JSONObject(String.valueOf(response));

                            JSONArray jsonArray = object.getJSONArray("items");
                            int dataLen = jsonArray.length();

                            parseIsraelItemBeanArrayList.clear();

                            for (int i = 0; i < dataLen; i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();

                                parseItemBean.setTitle(jsonObject.optString("title"));
                                parseItemBean.setDate(jsonObject.optString("date"));
                                parseItemBean.setCategory(jsonObject.optString("category"));

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday")) {
                                    parseIsraelItemBeanArrayList.add(parseItemBean);
                                }

                            }

//                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
                            rv_events_holiday.setLayoutManager(layoutManager);
                            eventsIsraelHolidayAdpater = new EventsIsraelHolidayAdpater(getContext(),parseIsraelItemBeanArrayList);
                            rv_events_holiday.setAdapter(eventsIsraelHolidayAdpater);
//                                    adapterEventsHolidays.notifyDataSetChanged();

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

//        String url = Url.disporaUrl;
        // Try to parse JSON

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        String year = "";

        if (pageCount == 0) {

            year = sdf.format(date);
        } else
        if (pageCount >= 1 ) {
            year = String.valueOf(yearCount+1);
            yearCount ++;
        }
        String url = Url.disporaUrlBeforeDate+year+Url.disporaUrlAfterDate;

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", String.valueOf(response));
                        if (getActivity()==null||getContext()==null||getView()==null){
                            return;
                        }

                        rv_events_holiday.clearOnScrollListeners();
                        rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                        rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());

                        mCurrentPage = pageCount;


                        try {
                            JSONObject object = new JSONObject(String.valueOf(response));

                            JSONArray jsonArray = object.getJSONArray("items");
                            int dataLen = jsonArray.length();

                                parseDisporaItemBeanArrayList.clear();

                            for (int i = 0; i < dataLen; i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                ParseDisporaItemBean parseItemBean = new ParseDisporaItemBean();

                                parseItemBean.setTitle(jsonObject.optString("title"));
                                parseItemBean.setDate(jsonObject.optString("date"));
                                parseItemBean.setCategory(jsonObject.optString("category"));

                                if (parseItemBean.getCategory().equalsIgnoreCase("holiday")) {
                                    parseDisporaItemBeanArrayList.add(parseItemBean);
                                }

                            }

//                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
                            rv_events_holiday.setLayoutManager(layoutManager);
                            eventsDisporaHolidayAdapter = new EventsDisporaHolidayAdapter(getContext(),parseDisporaItemBeanArrayList);
                            rv_events_holiday.setAdapter(eventsDisporaHolidayAdapter);
//                                    adapterEventsHolidays.notifyDataSetChanged();

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

    private EndlessScrollListener getRecyclerLoadMore() {
        return new EndlessScrollListener(layoutManager) {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onLoadMore(int current_page) {
                if(eventsDisporaHolidayAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
//
                    if (eventsDisporaHolidayAdapter != null) {
                        pageCount = current_page + 1;
                    }
                }
                else if(eventsIsraelHolidayAdpater != null && controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                    if (eventsIsraelHolidayAdpater != null) {
                        pageCount = current_page + 1;
                    }
                }

                if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                    getAllEventsDispora();
                }else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")){
                    getAllEventsIsrael();

                }
            }

        };
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
                if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                    callRefreshDispora(s.toString());
                }else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")){
                    callRefreshIsrael(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void callRefreshIsrael(String s) {
        final ArrayList<ParseIsraelItemBean> filteredList = new ArrayList<>();
        for (int i = 0; i < parseIsraelItemBeanArrayList.size(); i++) {
            final String text = parseIsraelItemBeanArrayList.get(i).getTitle();
            if (text.contains(s)) {
                filteredList.add(parseIsraelItemBeanArrayList.get(i));
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
        rv_events_holiday.setLayoutManager(linearLayoutManager);
        eventsIsraelHolidayAdpater = new EventsIsraelHolidayAdpater(getContext(),filteredList);

        rv_events_holiday.setAdapter(eventsIsraelHolidayAdpater);
    }

    private void callRefreshDispora(String s) {
        final ArrayList<ParseDisporaItemBean> filteredList = new ArrayList<>();
        for (int i = 0; i < parseDisporaItemBeanArrayList.size(); i++) {
            final String text = parseDisporaItemBeanArrayList.get(i).getTitle();
            if (text.contains(s)) {
                filteredList.add(parseDisporaItemBeanArrayList.get(i));
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rv_events_holiday.getContext(), LinearLayoutManager.VERTICAL, false);
        rv_events_holiday.setLayoutManager(linearLayoutManager);
        eventsDisporaHolidayAdapter = new EventsDisporaHolidayAdapter(getContext(),filteredList);

        rv_events_holiday.setAdapter(eventsDisporaHolidayAdapter);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isNeedToRefresh) {
            isNeedToRefresh = false;
            pageCount = 0;
            if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                getAllEventsDispora();
            }
        }
        if (isNeedToRefresh) {
            isNeedToRefresh = false;
            pageCount = 0;
            if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                getAllEventsIsrael();
            }
        }
    }
}
