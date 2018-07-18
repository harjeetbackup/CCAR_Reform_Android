package com.reformluach.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;


public class AppDateUtil {

    public static final DateTime getDateTime(String source) {
        return DateTime.parse(source, ISODateTimeFormat.dateTimeParser());
    }

    public static final String onlyDate_ddMMyyyy(DateTime dateTime) {
        if(dateTime == null) {
            return "";
        }
        DateTimeFormatter builder = DateTimeFormat.forPattern( "MM/dd/yyyy" );
        return  builder.print(dateTime);
    }
}
