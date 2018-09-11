package com.reformluach.utils;

import android.util.Log;

import com.reformluach.models.ParseIsraelItemBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EventManager {

    public static ArrayList<ParseIsraelItemBean> getSpecailDisporaTorahEvents(ArrayList<ParseIsraelItemBean> spEvent,ArrayList<ParseIsraelItemBean> newFilteredData){

        ArrayList<ParseIsraelItemBean> shiminiData = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> motData = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> nasoData = new ArrayList<>();


        newFilteredData.addAll(getShimini(spEvent));
        newFilteredData.addAll(getMot(spEvent));
        newFilteredData.addAll(getNaso(spEvent));
        return newFilteredData;
    }


    public static ArrayList<ParseIsraelItemBean> getShimini (ArrayList<ParseIsraelItemBean> parseIsraelItemBeans) {

        String next7DaysDate ="";
        String pesachSautrday = "";
        ArrayList<ParseIsraelItemBean> filteredWithShimini = new ArrayList<>();
        ParseIsraelItemBean parseIsraelItemBean = new ParseIsraelItemBean();

        for (int i=0; i<parseIsraelItemBeans.size(); i++) {
            ParseIsraelItemBean beanPesach = new ParseIsraelItemBean();
                   beanPesach = parseIsraelItemBeans.get(i);
            if (beanPesach.getTitle().equals("Pesach VIII") ) {
                String pesachDate = beanPesach.getDate();
                pesachSautrday = String.valueOf(getSaturdayLogic(pesachDate));

                if (pesachDate !=null || !pesachDate.isEmpty()) {
                    next7DaysDate = getFridaySaturdayLogic(pesachDate);
                }
            }
            if (pesachSautrday.equals("7") && beanPesach.getTitle().equals("Pesach VIII")) {
                parseIsraelItemBean = beanPesach;

            }
            if (parseIsraelItemBeans.get(i).getDate().equals(next7DaysDate) && parseIsraelItemBeans.get(i).getTitle().equals("Parashat Sh'mini") ) {
                parseIsraelItemBeans.get(i).setTitle("Parashat Shmini II");
                parseIsraelItemBeans.get(i).setCategory("parashat");
                beanPesach.setHighlighted(true);
                parseIsraelItemBean.setTitle("Parashat Shmini I");
                parseIsraelItemBean.setCategory("parashat");
                parseIsraelItemBean.setHighlighted(true);
                filteredWithShimini.add(parseIsraelItemBean);
                filteredWithShimini.add(parseIsraelItemBeans.get(i));
            }

        }
        return filteredWithShimini;
    }


    public static ArrayList<ParseIsraelItemBean> getMot (ArrayList<ParseIsraelItemBean> parseIsraelItemBeans) {

        String next7DaysArchaeiDate ="";
        String archreiSautrday = "";
        ArrayList<ParseIsraelItemBean> filteredWithMot =  new ArrayList<>();
        ParseIsraelItemBean parseIsraelItemBean = new ParseIsraelItemBean();

        for (int i=0; i<parseIsraelItemBeans.size(); i++) {

            ParseIsraelItemBean beanPesach = parseIsraelItemBeans.get(i);
            Log.i("WWW", " MOTDate " + beanPesach.getDate());
            Log.i("WWW", " MOTTitle " + beanPesach.getTitle());
            Log.i("WWW", " MOTCategory " + beanPesach.getCategory());
            if (beanPesach.getTitle().equals("Pesach VIII") ) {
                String pesachDate = beanPesach.getDate();
                archreiSautrday  = String.valueOf(getSaturdayLogic(pesachDate));
                if (pesachDate !=null || !pesachDate.isEmpty()) {
                    next7DaysArchaeiDate = getFridaySaturdayLogic(pesachDate);
                }

            }
            if (archreiSautrday.equals("7") && beanPesach.getTitle().equals("Pesach VIII")) {
                parseIsraelItemBean = beanPesach;


            }

            if (parseIsraelItemBeans.get(i).getDate().equals(next7DaysArchaeiDate) && parseIsraelItemBeans.get(i).getTitle().equals("Parashat Acharei Mot") ) {
                parseIsraelItemBeans.get(i).setTitle("Parashat Achrei Mot II");
                parseIsraelItemBeans.get(i).setCategory("parashat");
                beanPesach.setHighlighted(true);
                parseIsraelItemBean.setTitle("Parashat Achrei Mot I");
                parseIsraelItemBean.setCategory("parashat");
                parseIsraelItemBean.setHighlighted(true);
                filteredWithMot.add(parseIsraelItemBean);
                filteredWithMot.add(parseIsraelItemBeans.get(i));
            }
        }
        return filteredWithMot;
    }

    public static ArrayList<ParseIsraelItemBean> getNaso (ArrayList<ParseIsraelItemBean> parseIsraelItemBeans) {

        String next7DaysShavoutDate ="";
        String shavoutSautrday = "";
        ArrayList<ParseIsraelItemBean> filteredWithNaso =  new ArrayList<>();
        ParseIsraelItemBean parseIsraelItemBean = new ParseIsraelItemBean();

        for (int i=0; i<parseIsraelItemBeans.size(); i++) {
            ParseIsraelItemBean beanPesach = parseIsraelItemBeans.get(i);
            if (beanPesach.getTitle().equals("Shavuot II") ) {
                String pesachDate = beanPesach.getDate();
                shavoutSautrday = String.valueOf(getSaturdayLogic(pesachDate));

                if (pesachDate !=null || !pesachDate.isEmpty()) {
                    next7DaysShavoutDate = getFridaySaturdayLogic(pesachDate);
                }
            }

            if (shavoutSautrday.equals("7") && beanPesach.getTitle().equals("Shavuot II")) {
                parseIsraelItemBean = beanPesach;

            }
            if (parseIsraelItemBeans.get(i).getDate().equals(next7DaysShavoutDate) && parseIsraelItemBeans.get(i).getTitle().equals("Parashat Naso") ) {
                parseIsraelItemBeans.get(i).setTitle("Naso II");
                parseIsraelItemBeans.get(i).setCategory("parashat");
                beanPesach.setHighlighted(true);
                parseIsraelItemBean.setTitle("Naso I");
                parseIsraelItemBean.setCategory("parashat");
                parseIsraelItemBean.setHighlighted(true);
                filteredWithNaso.add(parseIsraelItemBean);
                filteredWithNaso.add(parseIsraelItemBeans.get(i));
            }
        }

        return filteredWithNaso;
    }


    public static int getSaturdayLogic(String date){
        String[] out = date.split("-");
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
        return days;
    }
    public static String getFridaySaturdayLogic(String eventDate){

        String[] out = eventDate.split("-");
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
        if (days ==7){
            eventDate = getCalculatedNext7Days(eventDate,7);
        }
        return eventDate;
    }

    public static String getCalculatedNext7Days(String date, int days) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date newDate = calendar.getTime();
        // ---  Then, if you need to, convert it back to a String:

        date = dateFormat.format(newDate);

        return date;
    }
}
