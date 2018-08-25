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
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.reformluach.R;
import com.reformluach.adapters.EventsIsraelAdapter;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.EndlessScrollListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */

public class EventRoshChildFragment extends Fragment  {
    private View eventsHolidaysFragmentView;
    private Context context;
    private RecyclerView rv_events_holiday;
//    private EditText searchEditText;
    private Controller controller;


    private EventsIsraelAdapter eventsIsraelAdapter;

    int pageCount = 0;
    int mCurrentPage = -1;

    LinearLayoutManager layoutManager;
    private boolean isNeedToRefresh = false;
    private int yearCount = 0;

    private boolean isVisible;
    public TextView tvCanc;

    TextView tvEventCalenderType;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        eventsHolidaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventrosh_fragment_layout, container, false);
        context = eventsHolidaysFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();

        rv_events_holiday = eventsHolidaysFragmentView.findViewById(R.id.rv_events_rosh);
//        searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
        tvCanc = ((EventsFragment) getParentFragment()).tvCancel;
        tvEventCalenderType = ((EventsFragment) getParentFragment()).tvEventCalenderType;
//         It is initialising Views
        initViews(eventsHolidaysFragmentView);

        pageCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        yearCount = Integer.parseInt(sdf.format(date));

        layoutManager = new LinearLayoutManager(getActivity());

        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
            if (isVisible) {
//                getAllEventsReform();
                tvEventCalenderType.setText("R");
            }
        } else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
          if (isVisible) {
              getAllEventsDispora();
              tvEventCalenderType.setText("D");
          }
        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            if (isVisible) {
                getAllEventsIsrael();
                tvEventCalenderType.setText("I");
            }
        }else {
//            getAllEventsReform();
            tvEventCalenderType.setText("R");
        }
        return eventsHolidaysFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        eventsIsraelAdapter = new EventsIsraelAdapter(getActivity(), new ArrayList<ParseIsraelItemBean>());
            rv_events_holiday.setLayoutManager(layoutManager);
            rv_events_holiday.setAdapter(eventsIsraelAdapter);

//        int top = 0;
//        rv_events_holiday.smoothScrollToPosition(top); // for top

//        int bottom = rv_events_holiday.getAdapter().getItemCount()-1;
//
//        RecyclerView.State state = new RecyclerView.State();
//        layoutmanager.smoothScrollToPosition(rv_events_holiday, state, bottom);


//        Calendar calendar = Calendar.getInstance();
//        Date today = calendar.getTime();
//
//        calendar.add(Calendar.DAY_OF_YEAR, 1);
//        Date tomorrow = calendar.getTime();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//
//        String todayAsString = dateFormat.format(today);
//        String tomorrowAsString = dateFormat.format(tomorrow);
//

//        if (comparingDate.contains(todayAsString) || comparingDate.contains(tomorrowAsString)) {
//            int firstItem = layoutManager.findFirstVisibleItemPosition();
//            View firstItemView = layoutManager.findViewByPosition(firstItem);
//            float topOffset = firstItemView.getTop();
//        }

//        initViews(eventsHolidaysFragmentView);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;

        if(isVisible && getView() != null) {

            if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                getAllEventsReform();
                tvEventCalenderType.setText("R");
            }
            else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                getAllEventsDispora();
                tvEventCalenderType.setText("D");

            } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                getAllEventsIsrael();
                tvEventCalenderType.setText("I");
            }else {
                getAllEventsReform();
                tvEventCalenderType.setText("R");
            }
            initViews(eventsHolidaysFragmentView);
            showFullData();
            isFilterEnable = false;
        }

        if(isVisible) {
            registerSearch();
        }

    }

//    boolean isMenuVisible = false;
//    @Override
//    public void setMenuVisibility(boolean menuVisible) {
//        super.setMenuVisibility(menuVisible);
//        isMenuVisible = menuVisible;
//        if (menuVisible){
//            if(isMenuVisible) {
//                tvCanc = ((EventsFragment) getParentFragment()).tvCancel;
//                isMenuVisible = true;
//            }
//        }
//    }

    ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData = new ArrayList<>();
    private void getAllEventsReform() {
        if (isFilterEnable) {
            return;
        }

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

            String urls[] = {Url.israelHolidayUrlBeforeDate + year + Url.israelHolidayUrlAfterDate,
                    Url.disporahTorahUrlBeforeDate + year + Url.disporahTorahUrlAfterDate,
                    Url.disporahTorahSpecialUrlBeforeDate + year + Url.disporahTorahSpecialUrlAfterDate};
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
                                if (pageCount == 0) {
                                    rv_events_holiday.clearOnScrollListeners();
                                    rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                                    rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());
                                    eventsIsraelAdapter.clearPreviousData();
                                }

                                mCurrentPage = pageCount;

                                try {
                                    JSONObject object = new JSONObject(String.valueOf(response));

                                    JSONArray jsonArray = object.getJSONArray("items");
                                    int dataLen = jsonArray.length();

                                    mAllEventsReformCalenderData.clear();
                                    for (int i = 0; i < dataLen; i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                                        ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();
                                        parseItemBean.setTitle(jsonObject.optString("title"));
                                        parseItemBean.setDate(jsonObject.optString("date"));

                                        parseItemBean.setCategory(jsonObject.optString("category"));
                                        // add values to this collection

                                        mAllEventsReformCalenderData.add(parseItemBean);
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
                                    eventsIsraelAdapter.addMessege(mAllEventsReformCalenderData, pageCount);
                                    String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                    int position = 0;
                                    int count = 0;
                                    for (int j=0; j<mAllEventsReformCalenderData.size(); j++) {
                                        String eventDate = mAllEventsReformCalenderData.get(j).getDate();
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        try {
                                            Date date1 = sdf.parse(TodaysDate);
                                            Date date2 = sdf.parse(eventDate);
                                            if (date2.after(date1)) {
                                                count = count+1;

                                                if (count == 1) {
                                                    position = j;
                                                }
                                            }
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    rv_events_holiday.scrollToPosition(position);



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


    private void getAllEventsIsrael() {

        if (isFilterEnable){
            return;
        }

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

                            if (pageCount == 0) {
                                rv_events_holiday.clearOnScrollListeners();
                                rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                                rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());
                                eventsIsraelAdapter.clearPreviousData();
                            }
                            mCurrentPage = pageCount;

                            try {
                                JSONObject object = new JSONObject(String.valueOf(response));

                                JSONArray jsonArray = object.getJSONArray("items");
                                int dataLen = jsonArray.length();

//                                ArrayList<ParseIsraelItemBean> parseItemBeans = new ArrayList<>();

                                mAllEventsReformCalenderData.clear();
                                for (int i = 0; i < dataLen; i++) {

                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();
                                    parseItemBean.setTitle(jsonObject.optString("title"));
                                    parseItemBean.setDate(jsonObject.optString("date"));

                                    parseItemBean.setCategory(jsonObject.optString("category"));
                                    mAllEventsReformCalenderData.add(parseItemBean);

                                }

//                            Calendar calendar = Calendar.getInstance();
//                            Date today = calendar.getTime();
//
//                            calendar.add(Calendar.DAY_OF_YEAR, 1);
//                            Date tomorrow = calendar.getTime();
//                            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//
//                            String todayAsString = dateFormat.format(today);
//                            String tomorrowAsString = dateFormat.format(tomorrow);

//                            if (comparingDate.contains(todayAsString) || comparingDate.contains(tomorrowAsString)) {
//                                int firstItem = layoutManager.findFirstVisibleItemPosition();
//                                View firstItemView = layoutManager.findViewByPosition(firstItem);
//                                float topOffset = firstItemView.getTop();
//                            }

                                eventsIsraelAdapter.addMessege(mAllEventsReformCalenderData, pageCount);
                                String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                int position = 0;
                                int count = 0;
                                for (int j=0; j<mAllEventsReformCalenderData.size(); j++) {
                                    String eventDate = mAllEventsReformCalenderData.get(j).getDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    try {
                                        Date date1 = sdf.parse(TodaysDate);
                                        Date date2 = sdf.parse(eventDate);
                                        if (date2.after(date1)) {
                                            count = count+1;

                                            if (count == 1) {
                                                position = j;
                                            }
                                        }
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }

                                rv_events_holiday.scrollToPosition(position);



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
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

                if (eventsIsraelAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                    if (eventsIsraelAdapter != null) {
                        pageCount = current_page + 1;
                    }
                    getAllEventsReform();
                }
                else if (eventsIsraelAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {

                    if (eventsIsraelAdapter != null) {
                        pageCount = current_page + 1;
                    }
                    getAllEventsDispora();
                } else if (eventsIsraelAdapter != null && controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                    if (eventsIsraelAdapter != null) {
                        pageCount = current_page + 1;
                    }
                    getAllEventsIsrael();
                }else {
                    if (eventsIsraelAdapter != null) {
                        pageCount = current_page + 1;
                    }
                    getAllEventsReform();
                }
            }

        };
    }


    private void getAllEventsDispora() {

        if (isFilterEnable){
            return;
        }

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

                            if (pageCount == 0) {
                                rv_events_holiday.clearOnScrollListeners();
                                rv_events_holiday.removeOnScrollListener(getRecyclerLoadMore());
                                rv_events_holiday.addOnScrollListener(getRecyclerLoadMore());
                                eventsIsraelAdapter.clearPreviousData();
                            }

                            mCurrentPage = pageCount;


                            try {
                                JSONObject object = new JSONObject(String.valueOf(response));

                                JSONArray jsonArray = object.getJSONArray("items");
                                int dataLen = jsonArray.length();

//                                ArrayList<ParseIsraelItemBean> parseItemBeans = new ArrayList<>();

                                mAllEventsReformCalenderData.clear();
                                for (int i = 0; i < dataLen; i++) {

                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();
                                    parseItemBean.setTitle(jsonObject.optString("title"));
                                    parseItemBean.setDate(jsonObject.optString("date"));
                                    parseItemBean.setCategory(jsonObject.optString("category"));

                                    String recievedDate = jsonObject.optString("date");
                                    String recievedTitle = jsonObject.optString("title");
                                    if (recievedTitle.startsWith("Parashat")) {
                                        parseItemBean.setParashatDate(recievedDate);
                                    }
                                    if (recievedTitle.startsWith("Rosh Chodesh")) {
                                        parseItemBean.setRoshChodesh(recievedDate);
                                    }
                                    if (recievedTitle.equals("Shabbat Parah") || recievedTitle.equals("Shabbat Parah") ||
                                            recievedTitle.equals("Shabbat Sh'kalim") ||
                                            recievedTitle.equals("Shabbat HaGadol") || recievedTitle.equals("Shabbat Zachor") ||
                                            recievedTitle.equals("Shabbat HaChodesh") || recievedTitle.equals("Shabbat Shuva")
                                            || recievedTitle.equals("Shabbat Chanukah") || recievedTitle.startsWith("Chanukah")) {
                                        parseItemBean.setShabbat(recievedDate);
                                    }

                                    mAllEventsReformCalenderData.add(parseItemBean);

                                }

                                eventsIsraelAdapter.addMessege(mAllEventsReformCalenderData, pageCount);
                                String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                int position = 0;
                                int count = 0;
                                for (int j=0; j<mAllEventsReformCalenderData.size(); j++) {
                                    String eventDate = mAllEventsReformCalenderData.get(j).getDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    try {
                                        Date date1 = sdf.parse(TodaysDate);
                                        Date date2 = sdf.parse(eventDate);
                                        if (date2.after(date1)) {
                                            count = count+1;

                                            if (count == 1) {
                                                position = j;
                                            }
                                        }
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }

                                rv_events_holiday.scrollToPosition(position);


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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvCanc = ((EventsFragment) getParentFragment()).tvCancel;
        setHasOptionsMenu(true);
//        searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
    }



    private void initViews(View eventsHolidaysFragmentView) {
       final EditText searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
//        TextView tvCanc = ((EventsFragment) getParentFragment()).tvCancel;

        tvCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                    searchEditText.getText().clear();
                    isFilterEnable=false;
                    getAllEventsReform();

                }
                else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                        searchEditText.getText().clear();
                        isFilterEnable=false;
                        getAllEventsDispora();

                    } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                        searchEditText.getText().clear();
                        isFilterEnable=false;
                        getAllEventsIsrael();
                }else {
                    searchEditText.getText().clear();
                    isFilterEnable=false;
                    showFullData();

                }
            }
        });
    }


    boolean isFilterEnable = false;
    private void callRefreshIsrael(String s) {
        final ArrayList<ParseIsraelItemBean> filteredList = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> parseItemBeans = eventsIsraelAdapter.getAllActualData();
        for (int i = 0; i < parseItemBeans.size(); i++) {
            final String text = parseItemBeans.get(i).getTitle();
            if (text.contains(s)) {
                    filteredList.add(parseItemBeans.get(i));
            }
        }
        eventsIsraelAdapter.clearPreviousData();
        isFilterEnable =true;
        eventsIsraelAdapter.showFilteredData(filteredList);
    }

    public void showFullData(){
        ArrayList<ParseIsraelItemBean> parseItemBeans = eventsIsraelAdapter.getAllActualData();
        eventsIsraelAdapter.addMessege(parseItemBeans, pageCount);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected") ){
            if (isNeedToRefresh) {
                isNeedToRefresh = true;
                pageCount = 0;
                getAllEventsReform();
                tvEventCalenderType.setText("R");
            }

        }
        else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected") ){
            if (isNeedToRefresh) {
                isNeedToRefresh = true;
                pageCount = 0;
                getAllEventsDispora();
                tvEventCalenderType.setText("D");
            }

        } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {

            if (isNeedToRefresh) {
                isNeedToRefresh = true;
                pageCount = 0;
                getAllEventsIsrael();
                tvEventCalenderType.setText("I");
            }
        }else {
            if (isNeedToRefresh) {
                isNeedToRefresh = true;
                pageCount = 0;
                getAllEventsReform();
                tvEventCalenderType.setText("R");
            }
        }

    }


    private void registerSearch() {
        if((EventsFragment) getParentFragment() == null || ((EventsFragment) getParentFragment()).events_search_edittext == null ) {
            return;
        }
        final EditText searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    }
                    else if (controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    } else if (controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    }

                    if (searchEditText.getText().toString().isEmpty()){
                        showFullData();
                        isFilterEnable=false;
                    }

                    return true;
                }


                return false;
            }
        });
    }


}
