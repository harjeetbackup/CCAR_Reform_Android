package com.reformluach.utils;

import com.reformluach.models.ParseIsraelItemBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface RequestCall {

    void onSuccess(String from, String url, int pageCount, ArrayList<ParseIsraelItemBean> allEventsReformCalenderData);
    void onError(String url, int pageCount, String error);
}
