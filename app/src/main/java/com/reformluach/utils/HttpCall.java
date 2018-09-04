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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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



                                HashMap<String, ArrayList<ParseIsraelItemBean>> twoStepLogic = new HashMap<>();
                                HashMap<String, ArrayList<ParseIsraelItemBean>> threeStepLogic = new HashMap<>();

                                for (Map.Entry me : itemGrp.entrySet()) {
                                    String date = (String)me.getKey();
                                    ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>)me.getValue();

                                     if(dateItemList.size()==2) {
                                        twoStepLogic.put(date, dateItemList);
                                    } else if(dateItemList.size()==3) {
                                        threeStepLogic.put(date, dateItemList);
                                    }
                                }

                                // For Two Step Logic
                                twoStep(twoStepLogic, mAllEventsReformCalenderData, false);

                                // For Three Step Logic
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 1);
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 2);
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 3);
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 4);
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 5);
                                threeStep(threeStepLogic, mAllEventsReformCalenderData, 6);


                                firdaySaturdayLogic(mAllEventsReformCalenderData);

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




    private static void twoStep(HashMap<String, ArrayList<ParseIsraelItemBean>> twoStepLogic, ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData, boolean reverse) {

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

                if(upcomingIndex == actualIndex2) {
                    mAllEventsReformCalenderData.get(actualIndex1).setSubTitle(item2.getTitle());
                }

//                mAllEventsReformCalenderData.get(actualIndex1).setHighlighted(true);

//                mAllEventsReformCalenderData.get(actualIndex2).setHighlighted(true);
            }


        }

    }


    private static void threeStep(HashMap<String, ArrayList<ParseIsraelItemBean>> threeStepLogic, ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData,
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

            if(title3.equals("Shabbat Hachodesh")
                    || title3.equals("Shabbat Rosh Chodesh")
                    || title3.equals("Shabbat Chanukah")
                    || title3.equals("Shabbat Rosh Chodesh")) {

                isChodesh = true;
            }


            if(isParshat && isShabat && isChodesh) {
//                mAllEventsReformCalenderData.get(actualIndex1).setHighlighted(true);
//                mAllEventsReformCalenderData.get(actualIndex2).setHighlighted(true);
//                mAllEventsReformCalenderData.get(actualIndex3).setHighlighted(true);

                if(title3.equals("Shabbat Rosh Chodesh")) {
                    mAllEventsReformCalenderData.get(actualIndex1).setSubTitle(title3);
                }
            }


        }
    }


    private static void firdaySaturdayLogic(ArrayList<ParseIsraelItemBean> mAllEventsReformCalenderData) {

//        for (Map.Entry me : fridaySaturdayLogic.entrySet()) {
//            String date = (String) me.getKey();
//            ArrayList<ParseIsraelItemBean> dateItemList = (ArrayList<ParseIsraelItemBean>) me.getValue();
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

                if (title1.equals("Chanukah: 2 Candles")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 3 Candles")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 4 Candles")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 5 Candles")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 6 Candles")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 7 Candles")) {
                    isSukkot2 = true;
                } if (title1.equals("Chanukah: 8 Candles")) {
                    isSukkot2 = true;
                }
                if (title1.equals("Chanukah: 8th Day")) {
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
                    // END Friday Logic --------------------------------------------------------------


                    // Saturday Logic for Chanukah -------------------------------------------------
                    if (title1.equals("Chanukah: 2 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 2nd Night");
                    }if (title1.equals("Chanukah: 3 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 3rd Night");
                    }if (title1.equals("Chanukah: 4 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 4th Night");
                    }
                    if (title1.equals("Chanukah: 5 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 5th Night");
                    }if (title1.equals("Chanukah: 6 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 6th Night");
                    }if (title1.equals("Chanukah: 7 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 7th Night");
                    }if (title1.equals("Chanukah: 8 Candles") && days == 7) {
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: 8th Night");
                        mAllEventsReformCalenderData.get(i).setTitle("Shabbat_Chanukah");
                        mAllEventsReformCalenderData.get(i).setSubTitle("Chanukah: Ends at Sundown");
//                        mAllEventsReformCalenderData.get(i).setHighlighted(true);
                    }
                    // END Saturday Logic --------------------------------------------------------------

                    if (title1.startsWith("Parashat")) {
                        mAllEventsReformCalenderData.get(i).setHighlighted(true);
                    }

//                    if (title1.startsWith("Rosh Chodesh")){
//                        mAllEventsReformCalenderData.get(item1.getActualIndex()-1).setTitle("Erev Rosh Chodesh Weekday");
//                        mAllEventsReformCalenderData.get(item1.getActualIndex()-1).setDate(getPreviousEventOfRoshChodesh(item1.getDate()));
//                    }
//                }
            }
        }
    }


    public static String getPreviousEventOfRoshChodesh(String eventDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

//Substract one day to current date.
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        eventDate = dateFormat.format(cal.getTime());
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
