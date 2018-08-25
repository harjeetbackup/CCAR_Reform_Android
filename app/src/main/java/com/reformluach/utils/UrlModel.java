package com.reformluach.utils;

import java.util.ArrayList;

public class UrlModel {

    private ArrayList<String> urls = new ArrayList<>();
    private String from = "";

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void add(String url) {
        this.urls.add(url);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
