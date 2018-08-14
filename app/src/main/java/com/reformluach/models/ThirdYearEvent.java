package com.reformluach.models;

import java.util.ArrayList;

public class ThirdYearEvent {
//    @com.google.gson.annotations.SerializedName("Management, Law & Arts")
    private ArrayList<EventBean> majorHolidays;

    //    @com.google.gson.annotations.SerializedName("Medicine & Science")
    private ArrayList<EventBean> minorHolidays;

    //    @com.google.gson.annotations.SerializedName("Engineering")
    private ArrayList<EventBean> roshChodeshHolidays;
    private ArrayList<EventBean> weeklyParshiyotHolidays;
    private ArrayList<EventBean> sefiratOmerHolidays;
    private ArrayList<EventBean> shabatotHolidays;
    private ArrayList<EventBean> modernHolidays;

    public ArrayList<EventBean> getMajorHolidays() {
        return majorHolidays;
    }

    public ArrayList<EventBean> getMinorHolidays() {
        return minorHolidays;
    }

    public ArrayList<EventBean> getRoshChodeshHolidays() {
        return roshChodeshHolidays;
    }
    public ArrayList<EventBean> getWeeklyParshiyotHolidays() {
        return roshChodeshHolidays;
    }
    public ArrayList<EventBean> getSefiratOmerHolidays() {
        return sefiratOmerHolidays;
    }
    public ArrayList<EventBean> getShabatotHolidays() {
        return shabatotHolidays;
    }
    public ArrayList<EventBean> getModernHolidays() {
        return modernHolidays;
    }
}
