package com.reformluach.models;

public class CalenderSyncModel {
    private MajorHolidays majorHolidays;
    private MinorHolidays minorHolidays;

    private boolean isMajorHolidays;


    public MajorHolidays getOtoChat() {
        return majorHolidays;
    }

    public void setMajorHolidays(MajorHolidays otoChat) {
        this.majorHolidays = otoChat;
    }

    public MinorHolidays getGrpChat() {
        return minorHolidays;
    }

    public void setGrpChat(MinorHolidays grpChat) {
        this.minorHolidays = grpChat;
    }

    public boolean isMajor() {
        return isMajorHolidays;
    }

    public void setMajor(boolean grpChat) {
        isMajorHolidays = grpChat;
    }
}
