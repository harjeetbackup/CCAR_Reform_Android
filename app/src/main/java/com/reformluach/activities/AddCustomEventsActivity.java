package com.reformluach.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.reformluach.R;
import com.reformluach.models.CustomEventsList;
import com.reformluach.utils.Controller;
import com.reformluach.utils.HintSpinner;

import java.util.ArrayList;

public class AddCustomEventsActivity extends AppCompatActivity implements View.OnClickListener {
    static final String[] Months = new String[]{"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final String[] Date = new String[]{"DAY", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static final String[] Year = new String[]{"YEAR", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    public ArrayList<CustomEventsList> data;
    private Context context;
    private HintSpinner spMonth_one, spMonth_two, spMonth_three, spDay_one, spDay_two, spDay_three, spYear_one, spYear_two, spYear_three;
    private TextView tvAdd, tvCancel;
    private EditText event_title_one, event_title_two, event_title_three;
    private RadioButton rb_before_one, rb_before_two, rb_before_three, rb_after_one, rb_after_two, rb_after_three;
    private CustomEventsList customEventsList;
    private Controller controller;
    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_events);
        context = this;
        controller = (Controller) context.getApplicationContext();
        getIds();
        data = new ArrayList<>();
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            data = controller.getArayList();
        }
    }

    private void prepareData() {
        if (spMonth_one.getSelectedItemPosition() != 0 && spDay_one.getSelectedItemPosition() != 0 && spYear_one.getSelectedItemPosition() != 0) {
            if (!event_title_one.getText().toString().equalsIgnoreCase("") && spMonth_one.getSelectedItemPosition() != 0 && spDay_one.getSelectedItemPosition() != 0 && spYear_one.getSelectedItemPosition() != 0) {
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(event_title_one.getText().toString());
                customEventsList.setMonth(spMonth_one.getSelectedItem().toString());
                customEventsList.setDay(spDay_one.getSelectedItemPosition());
                customEventsList.setYear(spYear_one.getSelectedItem().toString());
                if (rb_before_one.isChecked()) {
                    customEventsList.setSunset("before");
                    customEventsList.setDay(spDay_one.getSelectedItemPosition());
                } else {
                    customEventsList.setSunset("after");
                    customEventsList.setDay(spDay_one.getSelectedItemPosition() + 1);
                }
                data.add(customEventsList);
            } else {
                if (event_title_one.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(context, "Please enter event title.", Toast.LENGTH_SHORT).show();
                } else if (spMonth_one.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select month.", Toast.LENGTH_SHORT).show();
                } else if (spYear_one.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select year.", Toast.LENGTH_SHORT).show();
                } else if (spDay_one.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select day.", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if (spMonth_two.getSelectedItemPosition() != 0 && spDay_two.getSelectedItemPosition() != 0 && spYear_two.getSelectedItemPosition() != 0) {
            if (!event_title_two.getText().toString().equalsIgnoreCase("") && spMonth_two.getSelectedItemPosition() != 0 && spDay_two.getSelectedItemPosition() != 0 && spYear_two.getSelectedItemPosition() != 0) {
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(event_title_two.getText().toString());
                customEventsList.setMonth(spMonth_two.getSelectedItem().toString());
                customEventsList.setDay(spDay_two.getSelectedItemPosition());
                customEventsList.setYear(spYear_one.getSelectedItem().toString());
                if (rb_before_two.isChecked()) {
                    customEventsList.setSunset("before");
                    customEventsList.setDay(spDay_two.getSelectedItemPosition());
                } else {
                    customEventsList.setSunset("after");
                    customEventsList.setDay(spDay_two.getSelectedItemPosition() + 1);
                }
                data.add(customEventsList);
            } else {
                if (event_title_two.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(context, "Please enter event title.", Toast.LENGTH_SHORT).show();
                } else if (spMonth_two.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select month.", Toast.LENGTH_SHORT).show();
                } else if (spYear_two.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select year.", Toast.LENGTH_SHORT).show();
                } else if (spDay_two.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select day.", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if (spMonth_three.getSelectedItemPosition() != 0 && spDay_three.getSelectedItemPosition() != 0 && spYear_one.getSelectedItemPosition() != 0) {
            if (!event_title_three.getText().toString().equalsIgnoreCase("") && spMonth_three.getSelectedItemPosition() != 0 && spDay_three.getSelectedItemPosition() != 0 && spYear_one.getSelectedItemPosition() != 0) {
                customEventsList = new CustomEventsList();
                customEventsList.setTitle(event_title_three.getText().toString());
                customEventsList.setMonth((spMonth_three.getSelectedItem().toString()));
                customEventsList.setYear(spYear_three.getSelectedItem().toString());
                if (rb_before_three.isChecked()) {
                    customEventsList.setSunset("before");
                    customEventsList.setDay(spDay_three.getSelectedItemPosition());
                } else {
                    customEventsList.setSunset("after");
                    customEventsList.setDay(spDay_three.getSelectedItemPosition() + 1);
                }
                data.add(customEventsList);
            } else {
                if (event_title_three.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(context, "Please enter event title.", Toast.LENGTH_SHORT).show();
                } else if (spMonth_three.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select month.", Toast.LENGTH_SHORT).show();
                } else if (spYear_three.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select year.", Toast.LENGTH_SHORT).show();
                } else if (spDay_three.getSelectedItemPosition() == 0) {
                    Toast.makeText(context, "Please select day.", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if (data != null && data.size() > 0) {
            controller.setArayList(data);
        }
    }

    private void getIds() {
        spMonth_one = findViewById(R.id.spMonth_one);
        spMonth_two = findViewById(R.id.spMonth_two);
        spMonth_three = findViewById(R.id.spMonth_three);
        spDay_one = findViewById(R.id.spDay_one);
        spDay_two = findViewById(R.id.spDay_two);
        spDay_three = findViewById(R.id.spDay_three);
        spYear_one = findViewById(R.id.spYear_one);
        spYear_two = findViewById(R.id.spYear_two);
        spYear_three = findViewById(R.id.spYear_three);
        tvAdd = findViewById(R.id.tvAdd);
        tvCancel = findViewById(R.id.tvCancel);
        event_title_one = findViewById(R.id.event_title_one);
        event_title_two = findViewById(R.id.event_title_two);
        event_title_three = findViewById(R.id.event_title_three);
        rb_before_one = findViewById(R.id.rb_before_one);
        rb_before_two = findViewById(R.id.rb_before_two);
        rb_before_three = findViewById(R.id.rb_before_three);
        rb_after_one = findViewById(R.id.rb_after_one);
        rb_after_two = findViewById(R.id.rb_after_two);
        rb_after_three = findViewById(R.id.rb_after_three);
        llMain = findViewById(R.id.llMain);
        setBgAccordingToMonth(controller.getMonth());
        rb_before_one.setChecked(true);
        rb_before_two.setChecked(true);
        rb_before_three.setChecked(true);
        tvAdd.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        setSpinner();
    }

    private void setSpinner() {
        //First Row
        ArrayAdapter<String> adapterMonth_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Months);
        adapterMonth_one.setDropDownViewResource(R.layout.spinner_layout);
        spMonth_one.setAdapter(adapterMonth_one);
        spMonth_one.setSelection(0);
        ArrayAdapter<String> adapterYear_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Year);
        adapterYear_one.setDropDownViewResource(R.layout.spinner_layout);
        spYear_one.setAdapter(adapterYear_one);
        spYear_one.setSelection(0);
        ArrayAdapter<String> adapterDay_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay_one.setDropDownViewResource(R.layout.spinner_layout);
        spDay_one.setAdapter(adapterDay_one);
        spDay_one.setSelection(0);
        //Second Row
        ArrayAdapter<String> adapterMonth_two = new ArrayAdapter<String>(context, R.layout.spinner_layout, Months);
        adapterMonth_two.setDropDownViewResource(R.layout.spinner_layout);
        spMonth_two.setAdapter(adapterMonth_two);
        spMonth_two.setSelection(0);
        ArrayAdapter<String> adapterYear_two = new ArrayAdapter<String>(context, R.layout.spinner_layout, Year);
        adapterYear_two.setDropDownViewResource(R.layout.spinner_layout);
        spYear_two.setAdapter(adapterYear_two);
        spYear_two.setSelection(0);
        ArrayAdapter<String> adapterDay_two = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay_two.setDropDownViewResource(R.layout.spinner_layout);
        spDay_two.setAdapter(adapterDay_two);
        spDay_two.setSelection(0);
        //Second Row
        ArrayAdapter<String> adapterMonth_three = new ArrayAdapter<String>(context, R.layout.spinner_layout, Months);
        adapterMonth_three.setDropDownViewResource(R.layout.spinner_layout);
        spMonth_three.setAdapter(adapterMonth_three);
        spMonth_three.setSelection(0);
        ArrayAdapter<String> adapterYear_three = new ArrayAdapter<String>(context, R.layout.spinner_layout, Year);
        adapterYear_three.setDropDownViewResource(R.layout.spinner_layout);
        spYear_three.setAdapter(adapterYear_three);
        spYear_three.setSelection(0);
        ArrayAdapter<String> adapterDay_three = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay_three.setDropDownViewResource(R.layout.spinner_layout);
        spDay_three.setAdapter(adapterDay_three);
        spDay_three.setSelection(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAdd:
                prepareData();
                if (customEventsList != null) {
                    controller.setArayList(data);
                    finish();
                } else {
                    Toast.makeText(context, "Please add at least one event.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvCancel:
                finish();
                break;
        }
    }

    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.jans));
                break;
            case 2:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.febs));
                break;
            case 3:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.mars));
                break;
            case 4:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.aprs));
                break;
            case 5:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.mays));
                break;
            case 6:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.juns));
                break;
            case 7:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.juls));
                break;
            case 8:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.augs));
                break;
            case 9:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.seps));
                break;
            case 10:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.octs));
                break;
            case 11:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.novs));
                break;
            case 12:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.decs));
                break;
        }
    }
}
