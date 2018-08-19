package com.reformluach.models;


public class EventListCalenderSync {

    String eventname;
    String subTitle;
    boolean isSelected;
    boolean isSynced;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }


    public EventListCalenderSync(String eventname, String subTitle) {
        this.eventname = eventname;
        this.subTitle = subTitle;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname =eventname;
    }

    public boolean isSynced() {
        return isSynced;
    }

    public void setSynced(boolean synced) {
        isSynced = synced;
    }
}
