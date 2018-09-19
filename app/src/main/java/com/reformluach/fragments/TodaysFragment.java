package com.reformluach.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.EventTitle;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.RequestURL;
import com.reformluach.services.ServiceAsync;
import com.reformluach.services.ServiceStatus;
import com.reformluach.services.ServicesResponse;
import com.reformluach.utils.Appconstant;
import com.reformluach.utils.Controller;
import com.reformluach.utils.FunctionSpellChange;

import java.util.ArrayList;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class TodaysFragment extends Fragment implements View.OnClickListener {
    private View todaysFragmentView;
    private Context context;
    private Controller controller;
    private RelativeLayout rl_main;
    private TextView tv_date, tv_month, tv_year, tv_event, tv_gre_date;
    private String eventName;

    public static TodaysFragment getInstance(Bundle bundle) {
        TodaysFragment fragment = new TodaysFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private String month;
    private String date;
    private String year;

    private String eventDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        todaysFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.todays_fragment_layout, container, false);
        context = todaysFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIds(todaysFragmentView);
        if (controller.isOnline(context)) {
            callApi(controller.getMonth(), controller.getDate(), controller.getYear());
            month = String.valueOf(controller.getMonth());
            date = String.valueOf(controller.getDate());
            year = String.valueOf(controller.getYear());
            eventDate = year+"-"+date+"-"+month;
        } else {
            Toast.makeText(context, getString(R.string.please_check_internet), Toast.LENGTH_SHORT).show();
        }
        return todaysFragmentView;
    }

    private void getIds(View todaysFragmentView) {
        rl_main = todaysFragmentView.findViewById(R.id.rl_main);
        tv_date = todaysFragmentView.findViewById(R.id.tv_date);
        tv_month = todaysFragmentView.findViewById(R.id.tv_month);
        tv_year = todaysFragmentView.findViewById(R.id.tv_year);
        tv_event = todaysFragmentView.findViewById(R.id.tv_event);
        tv_gre_date = todaysFragmentView.findViewById(R.id.tv_gre_date);
        tv_event.setOnClickListener(this);
        setBgAccordingToMonth(controller.getMonth());
    }

    private void callApi(int month, final int date, final int year) {
        month = month + 1;
        final int finalMonth = month;
        ServiceAsync serviceAsync = new ServiceAsync(context, "", RequestURL.BASE_URL + "gy=" + year + "&gm=" + month + "&gd=" + date + "&g2h=1", RequestURL.GET, new ServiceStatus() {
            @Override
            public void onSuccess(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                tv_date.setText(String.valueOf(servicesResponse.hd));
                tv_month.setText(String.valueOf(servicesResponse.hm));
                tv_year.setText(String.valueOf(servicesResponse.hy));
                tv_gre_date.setText(getMonthString(finalMonth) + " " + date + ", " + year);
//                tv_event.setText(String.valueOf(servicesResponse.events.get(0)));
                tv_event.setText(String.valueOf( FunctionSpellChange.funcspellChangedForTitle(servicesResponse.events.get(0))));

                eventName = String.valueOf(servicesResponse.events.get(0));
                try {
                    controller.savePreferencesString(context, Appconstant.EVENTS_NAME, String.valueOf( FunctionSpellChange.funcspellChangedForTitle(servicesResponse.events.get(0))));
                    controller.savePreferencesString(context, Appconstant.HEBREW_MONTH, String.valueOf(servicesResponse.hy) + "/" + controller.getYear());
                    controller.savePreferencesString(context, Appconstant.CURRENT_DATE_MONTH, getMonthString(finalMonth) + " " + date);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Error occurred!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailed(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                Toast.makeText(context, servicesResponse.responseMessage, Toast.LENGTH_SHORT).show();
            }
        });
        serviceAsync.execute("");
    }

    private String getMonthString(int month) {
        if (month == 1) {
            return "January";
        } else if (month == 2) {
            return "February";
        } else if (month == 3) {
            return "March";
        } else if (month == 4) {
            return "April";
        } else if (month == 5) {
            return "May";
        } else if (month == 6) {
            return "June";
        } else if (month == 7) {
            return "July";
        } else if (month == 8) {
            return "August";
        } else if (month == 9) {
            return "September";
        } else if (month == 10) {
            return "October";
        } else if (month == 11) {
            return "November";
        } else if (month == 12) {
            return "December";
        }
        return "";
    }

    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.jan));
                break;
            case 2:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.feb));
                break;
            case 3:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.mar));
                break;
            case 4:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.apr));
                break;
            case 5:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.may));
                break;
            case 6:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.jun));
                break;
            case 7:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.jul));
                break;
            case 8:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.aug));
                break;
            case 9:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.sep));
                break;
            case 10:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.oct));
                break;
            case 11:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.nov));
                break;
            case 12:
                rl_main.setBackground(ContextCompat.getDrawable(context, R.mipmap.dec));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_event:
                Intent intent = new Intent(context, EventDetailsActivity.class);
                ArrayList<ParseIsraelItemBean> roshChodesh = new ArrayList<>();
//                intent.putExtra("eventType", "Todays");
                intent.putExtra("eventName",  FunctionSpellChange.funcspellChangedForTitle(eventName));
                intent.putExtra("eventDate",eventDate);
                intent.putExtra("roshChodeshTevet",roshChodesh);
                startActivity(intent);
                break;
        }
    }
}
