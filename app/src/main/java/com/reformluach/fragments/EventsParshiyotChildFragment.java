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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.adapters.EventsIsraelAdapter;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.EventManager;
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
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Created by Naveen Mishra on 12/1/2017.
 */
public class EventsParshiyotChildFragment extends Fragment  {
    private Context context;
    private RecyclerView mRecyclerView;
    private Controller controller;

    private EventsIsraelAdapter mEventAllAdapter;

    private int mCurrentYear = 0;

    private boolean isVisible;

    private boolean mIsLoading0, mIsLoading1, mIsLoading2;

    private String mSelectedCalType;
    ProgressBar mProgressBar;
    Button mBtnTryAgain;
    private int scrolledState = 1;
    LinearLayoutManager layoutManager;

    public EventsParshiyotChildFragment () {
        Log.i("", "");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View eventsParshiyotFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.eventparshiyot_fragment_layout, container, false);

        context = eventsParshiyotFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        mRecyclerView = eventsParshiyotFragmentView.findViewById(R.id.rv_events_parshiyot);
        mProgressBar = eventsParshiyotFragmentView.findViewById(R.id.progressBarParshiyotTab);
        mBtnTryAgain = eventsParshiyotFragmentView.findViewById(R.id.btn_tryAgainParshiyot);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Calendar myCal = Calendar.getInstance();
        myCal.setTime(date);
        mCurrentYear = Integer.parseInt(sdf.format(date));

        mBtnTryAgain.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);

        return eventsParshiyotFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventAllAdapter = new EventsIsraelAdapter(getActivity(), new ArrayList<ParseIsraelItemBean>());
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

        }

        if (isVisible){
            registerSearch();
        }

//        mRecyclerView.getRecycledViewPool().clear();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    scrolledState = recyclerView.getScrollState();
                    getServerCall(mCurrentYear);

                }
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;

        if (!isVisible){
            return;
        }

        if (isVisible){
            getServerCall(mCurrentYear);
        }


        if(isVisible) {
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        TextView tvEventsName = ((EventsFragment) getParentFragment()).tvEvent;

        tvEventsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrolledToTop();
            }
        });

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
                    if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    }
                    else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    } else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    }else {
                        if (!searchEditText.getText().toString().isEmpty()) {
                            callRefreshIsrael(searchEditText.getText().toString());
                            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                        }
                    }

                    if (searchEditText.getText().length()==0){
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
                mEventAllAdapter.clearPreviousData();
                searchEditText.setText("");
                showFullData();
                isFilterEnable=false;
            }
        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<ParseIsraelItemBean> mReformDataList = new ArrayList<>();

    private ArrayList<ParseIsraelItemBean> mSpecialDisporaEvent = new ArrayList<>();

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


        for(String url : urls) {

            HttpCall.getAllEventsReform(from, getActivity(), new RequestCall() {
                @Override
                public void onSuccess(String from, String url, int pageCount, ArrayList<ParseIsraelItemBean> allEventsReformCalenderData) {

                    if (getActivity() == null || getContext() == null || getView() == null) {
                        return;
                    }
                    mProgressBar.setVisibility(View.VISIBLE);

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
                                mSpecialDisporaEvent.addAll(allEventsReformCalenderData);

                            }
                            Collections.sort(mSpecialDisporaEvent);

                            ArrayList<ParseIsraelItemBean> mSpecialDisporaFilteredEvent = new ArrayList<>();

//                            if(mReformDataList != null || mReformDataList.size()!=0) {
//
//                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//                            mParshiyotDataList.clear();
//
//                            for(ParseIsraelItemBean bean : allEventsReformCalenderData) {
//                                String dateStr = bean.getDate();
//                                Date date = null;
//                                try {
//                                    date = format.parse(dateStr);
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
//                                }
//
//                                bean.setDateTime(date);
//                                mReformDataList.add(bean);
//
//                            }

//                                mReformDataList.addAll(allEventsReformCalenderData);
//                        }

                            if (!mIsLoading2 && !mIsLoading0 && !mIsLoading1) {
                                mCurrentYear = year + 1;
                                EventManager.getSpecailDisporaTorahEvents(mSpecialDisporaEvent,mSpecialDisporaFilteredEvent);
                                       if (mSpecialDisporaFilteredEvent.size()>0) {
                                    for (int i=0; i<mSpecialDisporaFilteredEvent.size(); i++)
                                        mReformDataList.add(mSpecialDisporaFilteredEvent.get(i));
                                }


                                Set<ParseIsraelItemBean> hs = new HashSet<>();
                                hs.addAll(mReformDataList);
                                mReformDataList.clear();
                                mReformDataList.addAll(hs);

                                Collections.sort(mReformDataList);
                                mProgressBar.setVisibility(View.GONE);

                                for (int i = 0; i < mReformDataList.size(); i++) {
                                    mReformDataList.get(i).setActualIndex(i);
                                }
                                HashMap<String, ArrayList<ParseIsraelItemBean>> itemGrp = new HashMap<>();
                                for (int i = 0; i < mReformDataList.size(); i++) {

                                    ArrayList<ParseIsraelItemBean> dateItemList = itemGrp.get(mReformDataList.get(i).getDate());

                                    if (dateItemList == null) {
                                        dateItemList = new ArrayList<>();
                                    }

                                    dateItemList.add(mReformDataList.get(i));

                                    itemGrp.put(mReformDataList.get(i).getDate(), dateItemList);

                                }

                                HashMap<String, ArrayList<ParseIsraelItemBean>> twoStepLogic = new HashMap<>();
                                HashMap<String, ArrayList<ParseIsraelItemBean>> threeStepLogic = new HashMap<>();

                                for (Map.Entry me : itemGrp.entrySet()) {
                                    String date = (String) me.getKey();
                                    ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>) me.getValue();

                                    if (dateItemList.size() == 2) {
                                        twoStepLogic.put(date, dateItemList);
                                    } else if (dateItemList.size() == 3) {
                                        threeStepLogic.put(date, dateItemList);
                                    }
                                }

                                // For Two Step Logic
                                HttpCall.twoStep(twoStepLogic, mReformDataList, false);

                                // For Three Step Logic
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 1);
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 2);
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 3);
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 4);
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 5);
                                HttpCall.threeStep(threeStepLogic, mReformDataList, 6);


                                HttpCall.firdaySaturdayLogic(mReformDataList);
                                ArrayList<ParseIsraelItemBean> duplicate = new ArrayList<>();
                                for (int i = 0; i < mReformDataList.size(); i++) {
                                    if (mReformDataList.get(i).getCategory().equals("parashat")) {
                                        duplicate.add(mReformDataList.get(i));
                                    }
                                }

                                mReformDataList = duplicate;

                                if (mReformDataList.size() !=0) {
                                    mEventAllAdapter.addMessege(mReformDataList, year);
                                }

                                String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                                int position = 0;
                                int count = 0;
                                for (int j = 0; j < mReformDataList.size(); j++) {
                                    String eventDate = mReformDataList.get(j).getDate();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    try {
                                        Date date1 = sdf.parse(TodaysDate);
                                        Date date2 = sdf.parse(eventDate);
                                        if (date2.after(date1)) {
                                            count = count + 1;

                                            if (count == 1) {
                                                position = j;
                                            }
                                        }
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (mCurrentYear == Calendar.getInstance().get(Calendar.YEAR)+1) {
                                    mRecyclerView.scrollToPosition(position);
                                } else {
                                    int pos = layoutManager.findLastCompletelyVisibleItemPosition();
                                    mRecyclerView.scrollToPosition(pos);
                                }
//                            mRecyclerView.scrollToPosition(position);

                            }
                        }

                    } else if (from.equals(Appconstant.ISRAEL) || from.equals(Appconstant.DIASPORA)) {
                        mCurrentYear = year+1;
                        mIsLoading0 = false;

                        Collections.sort(allEventsReformCalenderData);
//                        Set<ParseIsraelItemBean> hs = new HashSet<>();
//                        hs.addAll(allEventsReformCalenderData);
//                        allEventsReformCalenderData.clear();
//                        allEventsReformCalenderData.addAll(hs);


                        for (int i=0; i<allEventsReformCalenderData.size(); i++) {
                            allEventsReformCalenderData.get(i).setActualIndex(i);
                        }
                        HashMap<String, ArrayList<ParseIsraelItemBean>> itemGrp = new HashMap<>();
                        for(int i=0; i< allEventsReformCalenderData.size(); i++) {

                            ArrayList<ParseIsraelItemBean> dateItemList = itemGrp.get(allEventsReformCalenderData.get(i).getDate());

                            if(dateItemList == null) {
                                dateItemList = new ArrayList<>();
                            }

                            dateItemList.add(allEventsReformCalenderData.get(i));

                            itemGrp.put(allEventsReformCalenderData.get(i).getDate(), dateItemList);

                        }

                        HashMap<String, ArrayList<ParseIsraelItemBean>> twoStepLogic = new HashMap<>();
                        HashMap<String, ArrayList<ParseIsraelItemBean>> threeStepLogic = new HashMap<>();

                        for (Map.Entry me : itemGrp.entrySet()) {
                            String date = (String)me.getKey();
                            ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>)me.getValue();

                            if(dateItemList.size()==2) {
                                twoStepLogic.put(date, dateItemList);
                            } else if(dateItemList.size()==3) {
                                threeStepLogic.put(date, dateItemList);
                            }
                        }

                        // For Two Step Logic
                        HttpCall.twoStep(twoStepLogic, allEventsReformCalenderData, false);

                        // For Three Step Logic
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 1);
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 2);
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 3);
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 4);
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 5);
                        HttpCall.threeStep(threeStepLogic, allEventsReformCalenderData, 6);


                        HttpCall.firdaySaturdayLogic(allEventsReformCalenderData);
                        ArrayList<ParseIsraelItemBean> duplicate = new ArrayList<>();
                        for (int i=0; i<allEventsReformCalenderData.size(); i++) {
                            if (allEventsReformCalenderData.get(i).getCategory().equals("parashat")) {
                                duplicate.add(allEventsReformCalenderData.get(i));
                            }
                        }
                        allEventsReformCalenderData = duplicate;


//                        Collections.sort(mReformDataList);
                        mProgressBar.setVisibility(View.GONE);

                        if (allEventsReformCalenderData.size() !=0) {
                            mEventAllAdapter.addMessege(allEventsReformCalenderData, year);
                        }
                        String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                        int position = 0;
                        int count = 0;
                        for (int j=0; j<allEventsReformCalenderData.size(); j++) {
                            String eventDate = allEventsReformCalenderData.get(j).getDate();
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
                        if (mCurrentYear == Calendar.getInstance().get(Calendar.YEAR)+1) {
                            mRecyclerView.scrollToPosition(position);
                        } else {
                            int pos = layoutManager.findLastCompletelyVisibleItemPosition();
                            mRecyclerView.scrollToPosition(pos);
                        }
//                        mRecyclerView.scrollToPosition(position);

                    }



                }

                @Override
                public void onError(String url, int pageCount, String error) {
                    mIsLoading0 = false;
                    mIsLoading1 = false;
                    mIsLoading2 = false;

                    mProgressBar.setVisibility(View.GONE);
                    mBtnTryAgain.setVisibility(View.VISIBLE);
                    mRecyclerView.setVisibility(View.GONE);

                    mBtnTryAgain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mProgressBar.setVisibility(View.VISIBLE);
                            mBtnTryAgain.setVisibility(View.GONE);
                            mRecyclerView.setVisibility(View.VISIBLE);
                            getServerCall(mCurrentYear);

                        }
                    });
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

    private void scrolledToTop(){

        ArrayList<ParseIsraelItemBean> allDataList = mEventAllAdapter.getAllActualData();

        String TodaysDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        int position = 0;
        int count = 0;
        for (int j=0; j<allDataList.size(); j++) {
            String eventDate = allDataList.get(j).getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date1 = sdf.parse(eventDate);
                Date date2 = sdf.parse(TodaysDate);
                if (date2.after(date1)) {
                    count = count+1;

                    if (count >1) {
                        position = j;
                    }

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        ((LinearLayoutManager) mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(position+1, 0);
    }


}
