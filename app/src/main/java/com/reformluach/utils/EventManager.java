package com.reformluach.utils;

import com.reformluach.models.ParseIsraelItemBean;

import java.util.ArrayList;
import java.util.Calendar;

public class EventManager {

    public static ArrayList<ParseIsraelItemBean> getSpecailDisporaTorahEvents(ArrayList<ParseIsraelItemBean> spEvent){

        for (ParseIsraelItemBean beanPesach : spEvent){
            if (beanPesach.getTitle().equals("Pesach VIII")){

                String[] out = beanPesach.getDate().split("-");
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

            }



        }

        for (ParseIsraelItemBean beanShavout : spEvent){
            if (beanShavout.getTitle().equals("Shavuot II")){

            }
        }

        for (ParseIsraelItemBean beanArchaei : spEvent){
            if (beanArchaei.getTitle().equals("Parashat Achrei Mot")){

            }
        }

        return spEvent;
    }
}
