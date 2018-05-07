package com.reformluach.models;

import java.io.Serializable;

/**
 * Created by Naveen Mishra on 12/8/2017.
 */
public class CustomEventsList implements Serializable {
    public String title;
    public String month;
    public int day;
    public String year;
    public String sunset;
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

   /* public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }*/
}
