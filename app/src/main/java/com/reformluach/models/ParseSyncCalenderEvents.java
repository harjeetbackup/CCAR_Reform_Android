package com.reformluach.models;

public class ParseSyncCalenderEvents {

    private FirstYearEvent firstYearEvent;
    private SecondYearEvent secondYearEvent;
    private ThirdYearEvent thirdYearEvent;
    private FourthYearEvent fourthYearEvent;

    String eventYear;

    public String getEventYear() {
        return eventYear;
    }

    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }

    public FirstYearEvent getFirstYearEvent() {
        return firstYearEvent;
    }

    public SecondYearEvent getSecondYearEvent() {
        return secondYearEvent;

    }

    public ThirdYearEvent getThirdYearEvent() {
        return thirdYearEvent;
    }

    public FourthYearEvent getFourthYearEvent() {
        return fourthYearEvent;
    }


}
