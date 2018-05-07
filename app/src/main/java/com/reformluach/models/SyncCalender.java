package com.reformluach.models;

import java.io.Serializable;

/**
 * Created by Naveen Mishra on 12/7/2017.
 */
public class SyncCalender implements Serializable {
    public String date;
    public String event;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
