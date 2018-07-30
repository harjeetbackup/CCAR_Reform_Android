package com.reformluach.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import com.reformluach.R;
import com.reformluach.models.EventTitle;
import com.reformluach.utils.AppDateUtil;
import com.reformluach.utils.Controller;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Controller controller;
    private ImageView ivCross;
    private WebView wvDetails;
    private String eventType, eventName;
    private Context context;

    private String eventDate;
    boolean reachedAFriday = false;
    String friday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        context = this;
        controller = (Controller) context.getApplicationContext();
        if (getIntent() != null) {
            eventType = getIntent().getStringExtra("eventType");
            eventName = getIntent().getStringExtra("eventName");
            eventDate = getIntent().getStringExtra("eventDate");
        }
        getIds();


//        // Get calendar set to current date and time
//        Calendar c = GregorianCalendar.getInstance();
//
//        System.out.println("Current week = " + Calendar.FRIDAY);
//
//// Set the calendar to monday of the current week
//        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
//
//// Print dates of the current week starting on Monday
//        DateFormat df = new SimpleDateFormat("EEEE", Locale.getDefault());
//
//        friday = df.format(c.getTime());
//        c.add(Calendar.DATE, 6);
//

//        Calendar c = GregorianCalendar.getInstance();
//        Date date = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy EEEE");
//        try {
//            date= df.parse(eventDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String formattedDate = df.format(c);
    }

    private void getIds() {
        ivCross = findViewById(R.id.ivCross);
        wvDetails = findViewById(R.id.wvDetails);
        wvDetails.loadUrl(EventTitle.loadHtmlFile(eventType,eventName,eventDate));
        ivCross.setOnClickListener(this);
    }


    private int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCross:
                finish();
                break;
        }
    }
}