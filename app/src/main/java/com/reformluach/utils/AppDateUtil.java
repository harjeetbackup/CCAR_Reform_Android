package com.reformluach.utils;

import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;


public class AppDateUtil {

    public static final DateTime getDateTime(String source) {
        return DateTime.parse(source, ISODateTimeFormat.dateTimeParser());
    }


    public static final DateTime getDateTimeParashat(String source) {
        return DateTime.parse(source, ISODateTimeFormat.dateTimeParser());
    }


    public static final DateTime getDateTimeShabbat(String source) {
        return DateTime.parse(source, ISODateTimeFormat.dateTimeParser());
    }


    public static final DateTime getDateTimeRoshchodesh(String source) {
        return DateTime.parse(source, ISODateTimeFormat.dateTimeParser());
    }


    public static final boolean isToday(DateTime dateTime) {
        if(dateTime == null) {
            return false;
        }
        return DateUtils.isToday(dateTime);
    }


    public static final boolean isTomorrow(DateTime dateTime) {
        if(dateTime == null) {
            return false;
        }
        return DateUtils.isToday(dateTime.plus(1));
    }

    public static final String onlyDate_ddMMyyyy(DateTime dateTime) {
        if(dateTime == null) {
            return "";
        }
        DateTimeFormatter builder = DateTimeFormat.forPattern( "MM/dd/yyyy" );
        return  builder.print(dateTime);
    }
}
