package com.reformluach.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import com.reformluach.R;
import com.reformluach.models.EventTitle;
import com.reformluach.models.ParseIsraelItemBean;
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
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        context = this;
        controller = (Controller) context.getApplicationContext();
//         String eventType="";
//         String eventName ="";
//         String eventDate ="";

        Intent intent = new Intent();
        ArrayList<ParseIsraelItemBean> roshChodeshTevetList = new ArrayList<>();
//        String eventType = getIntent().getStringExtra("eventType");
        String eventName = getIntent().getStringExtra("eventName");
        String eventDate = getIntent().getStringExtra("eventDate");
          roshChodeshTevetList = getIntent().getExtras().getParcelableArrayList("roshChodeshTevet");

        ivCross = findViewById(R.id.ivCross);
        wvDetails = findViewById(R.id.wvDetails);
        if (roshChodeshTevetList.size()!=0) {
            wvDetails.loadUrl(EventTitle.loadHtmlFile(eventName, eventDate, roshChodeshTevetList));
        }else {
            wvDetails.loadUrl(EventTitle.loadHtmlFile(eventName, eventDate, roshChodeshTevetList));
        }
        ivCross.setOnClickListener(this);
//        getIds();

    }

//    private void getIds() {
//        ivCross = findViewById(R.id.ivCross);
//        wvDetails = findViewById(R.id.wvDetails);
//        wvDetails.loadUrl(EventTitle.loadHtmlFile(eventType,eventName,eventDate,roshChodeshTevetList));
//        ivCross.setOnClickListener(this);
//    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCross:
                finish();
                break;
        }
    }
}
