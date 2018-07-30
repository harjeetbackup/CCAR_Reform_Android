package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

public class EventListCalenderSync {

    String eventname;

    public EventListCalenderSync(String eventname) {
        this.eventname = eventname;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

}
