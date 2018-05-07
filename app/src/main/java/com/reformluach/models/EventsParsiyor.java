package com.reformluach.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Naveen Mishra on 12/5/2017.
 */
public class EventsParsiyor implements Serializable {
    public String subject;
    public String startDate;
    public String Location;
    public Date eventDate;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

   /* public EventsParsiyor(String subject, String start_date, String location) {


    }*/
}
/*
"Subject": "8th of Tevet 5777",
        "Start Date": "1/6/2017",
        "Start Time": "",
        "End Date": "",
        "End Time": "",
        "All day event": true,
        "Description": "",
        "Show time as": 3,
        "Location": "Jewish Holidays"*/
