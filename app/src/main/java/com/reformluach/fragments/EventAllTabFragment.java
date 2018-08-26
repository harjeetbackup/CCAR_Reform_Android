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
import android.widget.Toast;

import com.reformluach.R;
import com.reformluach.adapters.EventsIsraelAdapter;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.HttpCall;
import com.reformluach.utils.RequestCall;
import com.reformluach.utils.UrlModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */

public class EventAllTabFragment extends Fragment  {
//    private View eventsHolidaysFragmentView;
    private Context context;
    private RecyclerView mRecyclerView;
//    private EditText searchEditText;
    private Controller controller;


    private EventsIsraelAdapter mEventAllAdapter;

    LinearLayoutManager layoutManager;
    private int mCurrentYear = 0;

    private boolean isVisible;

    private boolean mIsLoading0, mIsLoading1, mIsLoading2;

    private String mSelectedCalType;

    public EventAllTabFragment () {
        Log.i("", "");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        View eventsHolidaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventrosh_fragment_layout, container, false);
        context = eventsHolidaysFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();

        mRecyclerView = eventsHolidaysFragmentView.findViewById(R.id.rv_events_rosh);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        mCurrentYear = Integer.parseInt(sdf.format(date));

        return eventsHolidaysFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEventAllAdapter = new EventsIsraelAdapter(getActivity(), new ArrayList<ParseIsraelItemBean>());
        layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(mEventAllAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        if(!isVisible) {
            return;
        }

        if(mSelectedCalType == null || !mSelectedCalType.equals(HttpCall.getSelectedCalendarType(getActivity()))) {
            mSelectedCalType = HttpCall.getSelectedCalendarType(getActivity());
            mEventAllAdapter.clearPreviousData();
        }


        if(mEventAllAdapter.getItemCount() == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            Calendar myCal = Calendar.getInstance();
            myCal.setTime(date);
            String yearStr = sdf.format(date);
            mCurrentYear = Integer.parseInt(yearStr);
            mIsLoading0 = false;
            mIsLoading1 = false;
            mIsLoading2 = false;
            getServerCall(mCurrentYear);

            registerSearch();
        }

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    getServerCall(mCurrentYear);

                }
            }
        });

    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;

        if(isVisible) {
            registerSearch();
        }

    }


    boolean isFilterEnable = false;
    private void callRefreshIsrael(String s) {
        final ArrayList<ParseIsraelItemBean> filteredList = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> parseItemBeans = mEventAllAdapter.getAllActualData();
        for (int i = 0; i < parseItemBeans.size(); i++) {
            final String text = parseItemBeans.get(i).getTitle();
            if (text.contains(s)) {
                    filteredList.add(parseItemBeans.get(i));
            }
        }
        mEventAllAdapter.clearPreviousData();
        isFilterEnable =true;
        mEventAllAdapter.showFilteredData(filteredList);
    }

    public void showFullData(){
        ArrayList<ParseIsraelItemBean> parseItemBeans = mEventAllAdapter.getAllActualData();
        mEventAllAdapter.showFilteredData(parseItemBeans);
    }

    private void registerSearch() {
        if((EventsFragment) getParentFragment() == null || ((EventsFragment) getParentFragment()).events_search_edittext == null ) {
            return;
        }
        final EditText searchEditText = ((EventsFragment) getParentFragment()).events_search_edittext;
        TextView tvCanc = ((EventsFragment) getParentFragment()).tvCancel;

        TextView tvEventCalenderType = ((EventsFragment) getParentFragment()).tvEventCalenderType;

        if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                tvEventCalenderType.setText("R");
        } else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                tvEventCalenderType.setText("D");
        } else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                tvEventCalenderType.setText("I");
        }else {
            tvEventCalenderType.setText("R");
        }

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



        tvCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                showFullData();
                isFilterEnable=false;
            }
        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<ParseIsraelItemBean> mReformDataList = null;

    private void getServerCall(final int year) {

        if (getActivity() == null || getContext() == null || getView() == null || isFilterEnable) {
            return;
        }

        UrlModel urlModel = getUrls(""+year);

        ArrayList<String> urls = urlModel.getUrls();
        String from = urlModel.getFrom();


        if(urls.size() == 3 && (mIsLoading0 || mIsLoading1 || mIsLoading2)) {
            return;
        }

        if(urls.size() == 1 && mIsLoading0) {
            return;
        }

        if(urls.size() == 3) {
            mReformDataList = new ArrayList<>();
        }

        mIsLoading0 = true;
        mIsLoading1 = true;
        mIsLoading2 = true;

        Toast.makeText(getActivity(), "Request", Toast.LENGTH_LONG).show();

        for(String url : urls) {

            HttpCall.getAllEventsReform(from, getActivity(), new RequestCall() {
                @Override
                public void onSuccess(String from, String url, int pageCount, ArrayList<ParseIsraelItemBean> allEventsReformCalenderData) {

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

                        if(mReformDataList != null) {

                            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                            for(ParseIsraelItemBean bean : allEventsReformCalenderData) {
                                String dateStr = bean.getDate();

                                Date date = null;
                                try {
                                    date = format.parse(dateStr);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                bean.setDateTime(date);

                            }

                            mReformDataList.addAll(allEventsReformCalenderData);
                        }

                        if (!mIsLoading2 && !mIsLoading0 && !mIsLoading1) {
                            mCurrentYear = year+1;
                            Collections.sort(mReformDataList);
                            mEventAllAdapter.addMessege(mReformDataList, year);
                        }

                    } else if (from.equals(Appconstant.ISRAEL) || from.equals(Appconstant.DIASPORA)) {
                        mCurrentYear = year+1;
                        mIsLoading0 = false;
                        mEventAllAdapter.addMessege(allEventsReformCalenderData, year);
                    }



                }

                @Override
                public void onError(String url, int pageCount, String error) {
                    mIsLoading0 = false;
                    mIsLoading1 = false;
                    mIsLoading2 = false;
                }
            }, url, mCurrentYear);
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





}