package com.reformluach.services;

import com.reformluach.models.DateConverted;

import java.util.List;

@SuppressWarnings("ALL")
public class ServicesResponse {
    public String responseCode;
    public String responseMessage;
    public DateConverted dateConverted;
    public int gy;
    public int gm;
    public int gd;
    public int hy;
    public String hm;
    public String hebrew;
    public int hd;
    public List<String> events;
}