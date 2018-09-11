package com.reformluach.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.services.Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpCall {

    public static void getAllEventsReform(final String from, final Context context, final RequestCall requestCall, final String url, final int pageCount) {

        RequestQueue queue = Volley.newRequestQueue(context);
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("Response", String.valueOf(response));

                            ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData = new ArrayList<>();

                            try {
                                JSONObject object = new JSONObject(String.valueOf(response));

                                JSONArray jsonArray = object.getJSONArray("items");
                                int dataLen = jsonArray.length();


                                HashMap<String, ArrayList<ParseIsraelItemBean>> itemGrp = new HashMap<>();

                                for (int i = 0; i < dataLen; i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    ParseIsraelItemBean parseItemBean = new ParseIsraelItemBean();
                                    String title = jsonObject.optString("title");
                                    String date = jsonObject.optString("date");
                                    String subCategory = jsonObject.optString("subcat");
                                    parseItemBean.setTitle(title);
                                    parseItemBean.setDate(date);
                                    parseItemBean.setSubcat(subCategory);
                                    parseItemBean.setActualIndex(i);

                                    parseItemBean.setCategory(jsonObject.optString("category"));


                                    ArrayList<ParseIsraelItemBean> dateItemList = itemGrp.get(date);
                                    if(dateItemList == null) {
                                        dateItemList = new ArrayList<>();
                                    }

                                    dateItemList.add(parseItemBean);

                                    itemGrp.put(date, dateItemList);

                                    // add values to this collection
                                    mAllEventsReformCalenderData.add(parseItemBean);

                                }


                                ////////////////////////////////////////////////////////////////////

                                ArrayList<ParseIsraelItemBean> newData = new ArrayList<>();
                                for (int i=0; i<mAllEventsReformCalenderData.size(); i++) {
                                    ParseIsraelItemBean bean = new ParseIsraelItemBean();
                                    if (mAllEventsReformCalenderData.get(i).getTitle().startsWith("Rosh Chodesh") ) {
                                        String previosDate = getPreviousEventOfRoshChodesh(mAllEventsReformCalenderData.get(i).getDate());
                                        bean.setTitle("Erev Rosh Chodesh Weekday");
                                        bean.setCategory(mAllEventsReformCalenderData.get(i).getCategory());
                                        bean.setSubTitle(mAllEventsReformCalenderData.get(i).getSubTitle());
                                        bean.setDate(previosDate);
                                        newData.add(bean);
                                    }
                                }

                                mAllEventsReformCalenderData.addAll(newData);


                                ////////////////////////////////////////////////////////////////////


                                if(requestCall != null) {
                                    requestCall.onSuccess(from, url, pageCount, mAllEventsReformCalenderData);
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                                if(requestCall != null) {
                                    requestCall.onError(url, pageCount, e.getMessage());
                                }
                            }

                        }
                    }
                    , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("Response", String.valueOf(error));
                    if(requestCall != null) {
                        requestCall.onError(url, pageCount, error.getMessage());
                    }

                }

            });



            queue.add(objectRequest);

    }




    public static void twoStep(HashMap<String, ArrayList<ParseIsraelItemBean>> twoStepLogic, ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData, boolean reverse) {

        for (Map.Entry me : twoStepLogic.entrySet()) {
            String date = (String)me.getKey();
            ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>)me.getValue();
            ParseIsraelItemBean item1 = null;
            ParseIsraelItemBean item2 = null;

            if(reverse) {
                item1 = dateItemList.get(1);
                item2 = dateItemList.get(0);
            } else {
                item1 = dateItemList.get(0);
                item2 = dateItemList.get(1);
            }

            String title1 = item1.getTitle();
            int actualIndex1 = item1.getActualIndex();

            String title2 = item2.getTitle();
            int actualIndex2 = item2.getActualIndex();

            boolean isParshat = false;
            boolean isShabat = false;

            if(title1.startsWith("Parashat")) {
                isParshat = true;
            }

            if (title2.equals("Shabbat Parah") ||
                    title2.equals("Shabbat Sh'kalim") ||
                    title2.equals("Shabbat HaGadol") || title2.equals("Shabbat Zachor") ||
                    title2.equals("Shabbat HaChodesh") || title2.equals("Shabbat Shuva")
                    || title2.equals("Shabbat Chanukah") || title2.startsWith("Chanukah")) {

                isShabat = true;

            }

            if(isParshat && isShabat) {
                int upcomingIndex = actualIndex1+1;

                if(upcomingIndex >= actualIndex2) {
                    mAllEventsReformCalenderData.get(actualIndex1).setSubTitle("The Haftarah for "+item2.getTitle() +" should be read.");
                }

//                mAllEventsReformCalenderData.get(actualIndex1).setHighlighted(true);

//                mAllEventsReformCalenderData.get(actualIndex2).setHighlighted(true);
            }


        }

    }


    public static void threeStep(HashMap<String, ArrayList<ParseIsraelItemBean>> threeStepLogic, ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData,
                                 int ocurrance) {
        // For Three Step Logic
        for (Map.Entry me : threeStepLogic.entrySet()) {
            String date = (String)me.getKey();
            ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>)me.getValue();

            ParseIsraelItemBean item1 = null;
            ParseIsraelItemBean item2 = null;
            ParseIsraelItemBean item3 = null;

            switch (ocurrance) {
                case 1:
                    item1 = dateItemList.get(0);
                    item2 = dateItemList.get(1);
                    item3 = dateItemList.get(2);

                    break;
                case 2:
                    item1 = dateItemList.get(0);
                    item2 = dateItemList.get(2);
                    item3 = dateItemList.get(1);

                    break;

                case 3:
                    item1 = dateItemList.get(1);
                    item2 = dateItemList.get(0);
                    item3 = dateItemList.get(2);

                    break;

                case 4:
                    item1 = dateItemList.get(1);
                    item2 = dateItemList.get(2);
                    item3 = dateItemList.get(0);

                    break;

                case 5:
                    item1 = dateItemList.get(2);
                    item2 = dateItemList.get(0);
                    item3 = dateItemList.get(1);

                    break;

                case 6:
                    item1 = dateItemList.get(2);
                    item2 = dateItemList.get(1);
                    item3 = dateItemList.get(0);

                    break;

                default:
                        item1 = dateItemList.get(0);
                        item2 = dateItemList.get(1);
                        item3 = dateItemList.get(2);

            }




            String title1 = item1.getTitle();
            int actualIndex1 = item1.getActualIndex();

            String title2 = item2.getTitle();
            int actualIndex2 = item2.getActualIndex();

            String title3 = item3.getTitle();
            int actualIndex3 = item3.getActualIndex();

            boolean isParshat = false;
            boolean isShabat = false;
            boolean isChodesh = false;

            if(title1.startsWith("Parashat")) {
                isParshat = true;
            }

            if (title2.contains("Shabbat Parah") ||
                    title2.equals("Shabbat Sh'kalim") ||
                    title2.equals("Shabbat HaGadol") || title2.equals("Shabbat Zachor") ||
                    title2.equals("Shabbat HaChodesh") || title2.equals("Shabbat Shuva")
                    || title2.equals("Shabbat Chanukah") || title2.startsWith("Chanukah")) {

                isShabat = true;
            }

            if (title3.startsWith("Rosh Chodesh")){
                isChodesh = true;
            }

//            if(title3.startsWith("Shabbat Hachodesh")
//                    || title3.equals("Shabbat Rosh Chodesh")
//                    || title3.equals("Shabbat Chanukah")
//                    ) {
//
//                isChodesh = true;
//            }


            if(isParshat && isShabat && isChodesh) {
//                mAllEventsReformCalenderData.get(actualIndex1).setHighlighted(true);
//                mAllEventsReformCalenderData.get(actualIndex2).setHighlighted(true);
//                mAllEventsReformCalenderData.get(actualIndex3).setHighlighted(true);
//
//                if (actualIndex1>actualIndex2 || actualIndex1>actualIndex3 || actualIndex2>actualIndex1 ||
//                        actualIndex2>actualIndex3 || actualIndex3>actualIndex1 || actualIndex3>actualIndex2) {
                    mAllEventsReformCalenderData.get(actualIndex1).setSubTitle("The Haftarah for " + title2 + " should be read.");
                    mAllEventsReformCalenderData.get(actualIndex3).setSubTitle("The Haftarah for " + title2 + " should be read.");
//                }
            }

        }
    }

    public static void returthreeEventsLogic(ArrayList<ParseIsraelItemBean> threeStepLogic){


        ParseIsraelItemBean parashatEvents = null;
        ParseIsraelItemBean shabbatEvents = null;
        ParseIsraelItemBean chodeshEvents = null;
        boolean isParshat = false;
        boolean isShabat = false;
        boolean isChodesh = false;


        for (int i=0;i<threeStepLogic.size(); i++){
            ParseIsraelItemBean events = threeStepLogic.get(i);


            if(events.getTitle().startsWith("Parashat")) {
                isParshat = true;
                parashatEvents = threeStepLogic.get(i);
            }

            if (events.getTitle().contains("Shabbat Parah") ||
                    events.getTitle().equals("Shabbat Sh'kalim") ||
                    events.getTitle().equals("Shabbat HaGadol") || events.getTitle().equals("Shabbat Zachor") ||
                    events.getTitle().equals("Shabbat HaChodesh") || events.getTitle().equals("Shabbat Shuva")
                    || events.getTitle().equals("Shabbat Chanukah") || events.getTitle().startsWith("Chanukah")) {

                isShabat = true;
                shabbatEvents = threeStepLogic.get(i);

            }

            if (events.getTitle().startsWith("Rosh Chodesh")){
                isChodesh = true;
                 chodeshEvents = threeStepLogic.get(i);
            }


            if(isParshat && isShabat && isChodesh) {
                if (parashatEvents.getDate().equals(shabbatEvents.getDate()) &&
                        shabbatEvents.getDate().equals(chodeshEvents.getDate()) &&
                        chodeshEvents.getDate().equals(parashatEvents.getDate())) {
                    String title = shabbatEvents.getTitle();
                    if (shabbatEvents.getTitle().equals("Chanukah: 2nd Night")   || shabbatEvents.getTitle().equals("Chanukah: 3rd Night")
                            ||shabbatEvents.getTitle().equals("Chanukah: 4th Night") || shabbatEvents.getTitle().equals("Chanukah: 5th Night") ||
                            shabbatEvents.getTitle().equals("Chanukah: 6th Night") || shabbatEvents.getTitle().equals("Chanukah: 7th Night") ||
                            shabbatEvents.getTitle().equals("Chanukah: 8th Night") || shabbatEvents.getTitle().equals("Chanukah: 8th Day")) {
//                        shabbatEvents.setTitle("Shabbat Chanukah");
                         title = "Shabbat Chanukah";
                    }
                    parashatEvents.setSubTitle("The Haftarah for " + title + " should be read.");
                    chodeshEvents.setSubTitle("The Haftarah for " + title + " should be read.");
                }
                }
            }
        }



    public static void firdaySaturdayLogic(ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData) {

        for (int i = 0; i < mAllEventsReformCalenderData.size(); i++) {
                ParseIsraelItemBean item1 = mAllEventsReformCalenderData.get(i);

                String title1 = item1.getTitle();


                boolean isSukkot2 = false;

                String[] out = item1.getDate().split("-");
                int s1 = Integer.parseInt(out[2]);
                int s2 = Integer.parseInt(out[1]) - 1;
                String yr = out[0];
                char a, b, c, d;
                a = yr.charAt(0);
                b = yr.charAt(1);
                c = yr.charAt(2);
                d = yr.charAt(3);
                int s3 = Character.getNumericValue(a) * 1000 +
                        Character.getNumericValue(b) * 100 +
                        Character.getNumericValue(c) * 10 +
                        Character.getNumericValue(d);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(s3, s2, s1);

                int days = calendar1.get(Calendar.DAY_OF_WEEK);


                if (title1.contains("Parashat")){
                    isSukkot2 = true;
                }
                // Saturday Logic for Sukkot -------------------------------------------------

                if (title1.equals("Sukkot 2 Weekday")) {
                    isSukkot2 = true;
                }

                if (title1.equals("Sukkot 3 Weekday")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Sukkot 4 Weekday")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Sukkot 5 Weekday")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Sukkot 6 Weekday")) {
                    isSukkot2 = true;
                }
                // END Saturday Logic for Sukkot -------------------------------------------------


                // Saturday Logic for Chanukah -------------------------------------------------

                if (title1.equals("Chanukah: 2nd Night")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 3rd Night")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 4th Night")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 5th Night")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 6th Night")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 7th Night")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 8th Night")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 8th Day")) {
                    isSukkot2 = true;
                }

                if (title1.equals("Erev Chanukah")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Erev Pesach")){
                    isSukkot2 = true;
                }
                if (title1.equals("Pesach I")){
                    isSukkot2 = true;
                }
                if (title1.equals("Pesach VII")){
                    isSukkot2 = true;
                }

                if (title1.startsWith("Rosh Chodesh")){
                    isSukkot2 = true;
                }
                if (title1.equals("Erev Sukkot")){
                    isSukkot2 = true;
                }
                if (title1.equals("Erev Yom Kippur")){
                    isSukkot2 = true;
                }
                if (title1.equals("Erev Shavout")){
                    isSukkot2 = true;
                }
                if (title1.equals("Erev Rosh Hashana")){
                    isSukkot2 = true;
                }
                if (title1.equals("Pesach Chol HaMoed Day 5 Weekday")){
                    isSukkot2 = true;
                }

                if (title1.equals("Sh'mini Atzeret/Simchat Torah")){
                    isSukkot2 = true;
                }

            if (title1.equals("Erev Rosh Chodesh Weekday")){
                isSukkot2 = true;
            }
                //END Saturday Logic for Chanukah -------------------------------------------------


                if (isSukkot2) {

                    // Saturday Logic for Sukkot -------------------------------------------------



                    if (title1.equals("Sukkot 2 Weekday") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Chol Hamoed Sukkot Shabbat");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 2");
                    }
                    if (title1.equals("Sukkot 3 Weekday") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Chol Hamoed Sukkot Shabbat");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 3");
                    }
                    if (title1.equals("Sukkot 4 Weekday") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Chol Hamoed Sukkot Shabbat");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 4");
                    }
                    if (title1.equals("Sukkot 5 Weekday") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Chol Hamoed Sukkot Shabbat");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 5");
                    }
                    if (title1.equals("Sukkot 6 Weekday") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Chol Hamoed Sukkot Shabbat");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 6");
                    }

                    if (title1.equals("Sh'mini Atzeret/Simchat Torah") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Sh'mini Atzeret/Simchat Torah Shabbat");
                    }
                    if (title1.equals("Pesach I") && days==7){
                        mAllEventsReformCalenderData.get(i).setTitle("Pesach Day 1 Shabbat");
                    }else if (title1.equals("Pesach I") && !(days==7)){
                        mAllEventsReformCalenderData.get(i).setTitle("Pesach Day 1 Weekday");
                    }
                    if (title1.equals("Pesach VII") && days==7){
                        mAllEventsReformCalenderData.get(i).setTitle("Pesach Day 7 Shabbat");
                    }else if (title1.equals("Pesach VII") && !(days==7)){
                        mAllEventsReformCalenderData.get(i).setTitle("Pesach Day VII");
                    }


                    // END Saturday Logic -Sukkot-------------------------------------------------------------


                    // Friday Logic for Sukkot -------------------------------------------------

                    if (title1.equals("Erev Sukkot") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Sukkot Friday");
                    }
                    if (title1.equals("Sukkot 2 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chol Hamoed Sukkot Friday");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 2");
                    }
                    if (title1.equals("Sukkot 3 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chol Hamoed Sukkot Friday");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 3");
                    }
                    if (title1.equals("Sukkot 4 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chol Hamoed Sukkot Friday");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 4");
                    }
                    if (title1.equals("Sukkot 5 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chol Hamoed Sukkot Friday");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 5");
                    }
                    if (title1.equals("Sukkot 6 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chol Hamoed Sukkot Friday");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Sukkot 6");
                    }

                    if (title1.equals("Erev Pesach") && days==6){
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Pesach/Ta’anit Bechorot Friday");
                    }else if (title1.equals("Erev Pesach") && !(days==6)){
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Pesach/Ta’anit Bechorot");
                    }

                    if (title1.equals("Pesach Chol HaMoed Day 5 Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Pesach Chol HaMoed Day 5 Friday");
                    }
                    if (title1.equals("Erev Yom Kippur") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Yom Kippur Friday");
                    }
                    if (title1.equals("Erev Rosh Hashana") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Rosh Hashanah Friday");
                    }if (title1.equals("Erev Rosh Hashana") && !(days == 6)) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Rosh Hashanah Weekday");
                    }
                    if (title1.equals("Erev Shavout") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Shavout Friday");
                    }

                    if (title1.equals("Erev Rosh Chodesh Weekday") && days == 6) {
                        mAllEventsReformCalenderData.get(i).setTitle("Erev Rosh Chodesh Friday");
                    }
                    // END Friday Logic --------------------------------------------------------------


                    // Saturday Logic for Chanukah -------------------------------------------------
                    if (title1.equals("Chanukah: 2nd Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 2nd Night");
                    }if (title1.equals("Chanukah: 3rd Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 3rd Night");
                    }if (title1.equals("Chanukah: 4th Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 4th Night");
                    }
                    if (title1.equals("Chanukah: 5th Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 5th Night");
                    }if (title1.equals("Chanukah: 6th Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 6th Night");
                    }if (title1.equals("Chanukah: 7th Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 7th Night");
                    }if (title1.equals("Chanukah: 8th Night") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 8th Night");
                    }if (title1.equals("Chanukah :8th Day") && days==7){
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: Ends at Sundown");
                    }
//                    if (title1.equals("Erev Chanukah")){
//                        mAllEventsReformCalenderData.get(i).setTitle("Chanukah: 1st Night");
//                    }
                    // END Saturday Logic --------------------------------------------------------------

                    if (title1.startsWith("Parashat")) {
                        mAllEventsReformCalenderData.get(i).setHighlighted(true);
                    }


                }

            }

    }



    public static String getPreviousEventOfRoshChodesh(String eventDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date newDate = calendar.getTime();
        // ---  Then, if you need to, convert it back to a String:

        eventDate = dateFormat.format(newDate);

        return eventDate;
    }


    public static String getSelectedCalendarType(Context context) {
        if (Controller.getPreferencesString((Activity) context, Appconstant.REFORM).equalsIgnoreCase("selected")) {
            return Appconstant.REFORM;
        } else if (Controller.getPreferencesString((Activity) context, Appconstant.DIASPORA).equalsIgnoreCase("selected")) {
            return Appconstant.DIASPORA;
        } else if (Controller.getPreferencesString((Activity) context, Appconstant.ISRAEL).equalsIgnoreCase("selected")) {
            return Appconstant.ISRAEL;
        }
        return Appconstant.REFORM;
    }

}
