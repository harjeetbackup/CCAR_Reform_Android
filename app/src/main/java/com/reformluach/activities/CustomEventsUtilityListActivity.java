package com.reformluach.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.reformluach.R;
import com.reformluach.adapters.AdapterAddMoreUtility;
import com.reformluach.callbacks.DeleteInterface;
import com.reformluach.models.CustomEventsList;
import com.reformluach.utils.Controller;
import com.reformluach.utils.HintSpinner;
import com.reformluach.utils.UtilityList;

import java.util.ArrayList;

public class CustomEventsUtilityListActivity extends AppCompatActivity implements DeleteInterface, View.OnClickListener {
    static final String[] Months = new String[]{"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final String[] Date = new String[]{"DAY", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static final String[] Year = new String[]{"YEAR", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    public ArrayList<CustomEventsList> arrayList, selectedList = new ArrayList<>();
    DeleteInterface deleteInterface;
    private ListView lv_custom;
    private AdapterAddMoreUtility mAdapter;
    private TextView tvAdd, tvCancel, tvAddMore;
    private LinearLayout llMain;
    private Context context;
    private Controller controller;
    private EditText et_event_title;
    private HintSpinner spMonth, spYear, spDay;
    private RadioButton rb_before, rb_after;
    private int selectedDay, selectedMonth, selectedYear;
    private boolean sunset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_events_utility_list);
        deleteInterface = this;
        context = this;
        controller = (Controller) context.getApplicationContext();
        try {
            selectedDay = getIntent().getIntExtra("day", 0);
            selectedMonth = getIntent().getIntExtra("month", 0);
            selectedYear = getIntent().getIntExtra("year", 0);
            sunset = getIntent().getBooleanExtra("sunset", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        selectedList = new ArrayList<CustomEventsList>();
        getIds();
        if (controller.getArayList() != null && controller.getArayList().size() > 0) {
            selectedList = controller.getArayList();
        }
    }

    private void getIds() {
        lv_custom = findViewById(R.id.lv_custom);
        tvAdd = findViewById(R.id.tvAdd);
        tvCancel = findViewById(R.id.tvCancel);
        llMain = findViewById(R.id.llMain);
        tvAddMore = findViewById(R.id.tvAddMore);
        llMain = findViewById(R.id.llMain);
        et_event_title = findViewById(R.id.et_event_title);
        spMonth = findViewById(R.id.spMonth);
        spDay = findViewById(R.id.spDay);
        spYear = findViewById(R.id.spYear);
        rb_before = findViewById(R.id.rb_before);
        rb_after = findViewById(R.id.rb_after);
        tvAddMore.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        setBgAccordingToMonth(controller.getMonth());
        setSpinner();
        spDay.setSelection(selectedDay);
        spMonth.setSelection(selectedMonth);
        spYear.setSelection(selectedYear);
        if (sunset) {
            rb_after.setChecked(true);
        } else {
            rb_before.setChecked(true);
        }
        arrayList = new ArrayList<>();
        mAdapter = new AdapterAddMoreUtility(this, arrayList, deleteInterface);
        lv_custom.setAdapter(mAdapter);
    }

    private void setSpinner() {
        ArrayAdapter<String> adapterMonth_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Months);
        adapterMonth_one.setDropDownViewResource(R.layout.spinner_layout);
        spMonth.setAdapter(adapterMonth_one);
        spMonth.setSelection(0);
        ArrayAdapter<String> adapterYear_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Year);
        adapterYear_one.setDropDownViewResource(R.layout.spinner_layout);
        spYear.setAdapter(adapterYear_one);
        spYear.setSelection(0);
        ArrayAdapter<String> adapterDay_one = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay_one.setDropDownViewResource(R.layout.spinner_layout);
        spDay.setAdapter(adapterDay_one);
        spDay.setSelection(0);
        rb_before.setChecked(true);
    }

    @Override
    public void onDelete(int position) {
        arrayList.remove(position);
        mAdapter.notifyDataSetChanged();
        UtilityList.setListViewHeightBasedOnChildren(lv_custom);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAdd:
                if (arrayList.size() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        CustomEventsList customEventsList = new CustomEventsList();
                        customEventsList.title = arrayList.get(i).title;
                        customEventsList.day = arrayList.get(i).day;
                        customEventsList.month = arrayList.get(i).month;
                        customEventsList.year = String.valueOf(controller.getYear());
                        selectedList.add(customEventsList);
                    }
                    controller.setArayList(selectedList);
                    finish();
                } else {
                    Toast.makeText(context, "Please add at least one event.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvAddMore:
                if (isValid()) {
                    CustomEventsList customEventsList = new CustomEventsList();
                    customEventsList.title = et_event_title.getText().toString().trim();
                    if (rb_before.isChecked()) {
                        customEventsList.sunset = "true";
                        customEventsList.day = spDay.getSelectedItemPosition();
                    } else if (rb_after.isChecked()) {
                        customEventsList.sunset = "false";
                        customEventsList.day = spDay.getSelectedItemPosition() + 1;
                    }
                    customEventsList.year = spYear.getSelectedItem().toString();
                    customEventsList.month = spMonth.getSelectedItem().toString();
                    arrayList.add(customEventsList);
                    mAdapter.notifyDataSetChanged();
                    UtilityList.setListViewHeightBasedOnChildren(lv_custom);
                    spMonth.setSelection(0);
                    spDay.setSelection(0);
                    spYear.setSelection(0);
                    et_event_title.setText("");
                    rb_before.setChecked(true);
                }
                break;
            case R.id.tvCancel:
                finish();
                break;
        }
    }

    private boolean isValid() {
        if (et_event_title.getText().toString().trim().length() == 0) {
            Toast.makeText(context, "Please enter event title.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (spMonth.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_month), Toast.LENGTH_SHORT).show();
            return false;
        } else if (spDay.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_day), Toast.LENGTH_SHORT).show();
            return false;
        }/* else if (spYear.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_year), Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }
}
