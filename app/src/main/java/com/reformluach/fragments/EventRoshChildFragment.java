package com.reformluach.fragments;

import android.app.Activity;
import android.content.Context;
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
import com.reformluach.adapters.AdapterEventsHolidays;
import com.reformluach.adapters.EventsDisporaAdapter;
import com.reformluach.adapters.EventsIsraelAdapter;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */

public class EventRoshChildFragment extends Fragment implements EventsIsraelAdapter.ReloadAllDataListener, EventsDisporaAdapter.ReloadAllDataListener {
    private View eventsHolidaysFragmentView;
    private Context context;
    private RecyclerView rv_events_holiday;
//    private AdapterEventsHolidays adapterEventsHolidays;
//    private ArrayList<EventsHolidays> data = new ArrayList();
    private EditText searchEditText;
    private Controller controller;
//    private int index = 0;
//    private int pos = 0;
    private int yearCount = 0;

    private EventsIsraelAdapter eventsIsraelAdapter;
//    private ArrayList<ParseIsraelItemBean> parseItemBeans = new ArrayList<>();

//    private EventsDisporaAdapter eventsDisporaAdapter;
//    private ArrayList<ParseDisporaItemBean> disporaItemBeanArrayList = new ArrayList<>();

    int mCurrentPage = -1;

    LinearLayoutManager layoutManager;
    private boolean isNeedToRefresh = false;

    int pageCount = 0;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        eventsHolidaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventholidays_fragment_layout, container, false);
        context = eventsHolidaysFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();

        // It is initialising Views
        initViews(eventsHolidaysFragmentView);

        pageCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        yearCount = Integer.parseInt(sdf.format(date));

        layoutManager = new LinearLayoutManager(getActivity());
        rv_events_holiday.setLayoutManager(layoutManager);

        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            getAllEventsDispora();
        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            getAllEventsIsrael();
        }
        return eventsHolidaysFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventsIsraelAdapter = new EventsIsraelAdapter(getActivity(), new ArrayList<ParseIsraelItemBean>());
        rv_events_holiday.setAdapter(eventsIsraelAdapter);
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getAllEventsIsrael() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        String year = "";

        if (pageCount == 0) {

            year = sdf.format(date);
        } else if (pageCount >= 1) {
            year = String.valueOf(yearCount + 1);
            yearCount++;
        }


        String url = Url.israelUrlBeforeDate + year + Url.israelUrlAfterDate;
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Response", String.valueOf(response));
                        if (getActivity() == null || getContext() == null || getView() == null) {
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

                            ArrayList<ParseIsraelItemBean> parseItemBeans = new ArrayList<>();

                            for (int i = 0; i < dataLen; i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();

                                parseItemBean.setTitle(jsonObject.optString("title"));
                                parseItemBean.setDate(jsonObject.optString("date"));
                                parseItemBean.setCategory(jsonObject.optString("category"));

                                parseItemBeans.add(parseItemBean);

                            }

//                                 rv_events_holiday.setLayoutManager(layoutManager);
//                                    eventsIsraelAdapter = new EventsIsraelAdapter(getContext(),parseItemBeans);
//                                    rv_events_holiday.setAdapter(eventsIsraelAdapter);

                            eventsIsraelAdapter.addMessege(parseItemBeans, pageCount);


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
                /*if (eventsDisporaAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {

                    if (eventsDisporaAdapter != null) {
                        pageCount = current_page + 1;
                    }
                    getAllEventsDispora();

                } else*/ if (eventsIsraelAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                    if (eventsIsraelAdapter != null) {
                        pageCount = current_page + 1;

                    }
                    getAllEventsIsrael();

                }

//                if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
//                   getAllEventsDispora();
//                }else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")){
//                    getAllEventsIsrael();
//
//                }
            }

        };
    }

    //
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void refreshAllIsraelData() {
        getAllEventsIsrael();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getAllEventsDispora() {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        String year = "";

        if (pageCount == 0) {

            year = sdf.format(date);
        } else if (pageCount >= 1) {
            year = String.valueOf(yearCount + 1);
            yearCount++;
        }
        String url = Url.disporaUrlBeforeDate + year + Url.disporaUrlAfterDate;
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
                        rv_events_holiday.clearOnScrollListeners();
                        rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                        rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());

                        mCurrentPage = pageCount;


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

//                                parseItemBeans.add(parseItemBean);

                            }

                        eventsIsraelAdapter.addMessege(parseItemBeans, pageCount);

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

    private void initViews(View eventsHolidaysFragmentView) {
        rv_events_holiday = eventsHolidaysFragmentView.findViewById(R.id.rv_events_holiday);
        searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                    callRefreshDispora(s.toString());
                } else*/ if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
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
        ArrayList<ParseIsraelItemBean> parseItemBeans = eventsIsraelAdapter.getData();
        for (int i = 0; i < parseItemBeans.size(); i++) {
            final String text = parseItemBeans.get(i).getTitle();
            if (text.contains(s)) {
                filteredList.add(parseItemBeans.get(i));
            }
        }
//        rv_events_holiday.setLayoutManager(layoutManager);
//        eventsIsraelAdapter = new EventsIsraelAdapter(getContext(),filteredList);
//
//        rv_events_holiday.setAdapter(eventsIsraelAdapter);

        eventsIsraelAdapter.clearPreviousData();
        pageCount = 0;
        eventsIsraelAdapter.addMessege(filteredList, pageCount);
    }




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onResume() {
        super.onResume();
        if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            if (isNeedToRefresh) {
                isNeedToRefresh = false;
                pageCount = 0;
                getAllEventsDispora();
            }

        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {

            if (isNeedToRefresh) {
                isNeedToRefresh = false;
                pageCount = 0;
                getAllEventsIsrael();
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void refreshAllDisporaData() {
        getAllEventsDispora();
    }
}
