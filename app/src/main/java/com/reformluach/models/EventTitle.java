package com.reformluach.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class EventTitle {

    public static final String replacetitleWithSpecialChar(String subtitle){
        if (subtitle.contains(":")){
        subtitle = subtitle.replace(":","");
        }
        if (subtitle.contains("-")){
            subtitle =subtitle.replace("-","/");
        }
        if (subtitle.contains("_")){
            subtitle =subtitle.replace("_"," ");
        }
        return subtitle;
    }

    public static final String htmlFileUrl = "file:///android_asset/";

    public static final String loadHtmlFile( String eventName, String eventDate, ArrayList<ParseIsraelItemBean> roshChodeshTevet) {
        String url = null;

        ParseIsraelItemBean roshChodesh = null;
        boolean isRoshChodeshTevet = false;
        for (int i=0; i<roshChodeshTevet.size(); i++) {
            ParseIsraelItemBean rochChodeshTevetEvent = roshChodeshTevet.get(i);
            if (rochChodeshTevetEvent.getTitle().equals("Rosh Chodesh Tevet")){
                isRoshChodeshTevet = true;
                roshChodesh = roshChodeshTevet.get(i);
            }

            ///  Todays logic for for chanukah 8th ,8th day and 7th ------
             if (eventName.equals("Chanukah: 7th Night") || eventName.equals("Chanukah: 8th Night")
                    || eventName.equals("Chanukah: 8th Day")) {
                if (eventDate.equals(roshChodesh.getCategory()) && eventName.equals("Chanukah: 8th Night")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_8th_Night_Rosh_Chodesh_Tevet_1.html";
                    }else if (eventDate.equals(roshChodesh.getCategory()) && eventName.equals("Chanukah: 7th Night")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_7th_Night_Erev_Rosh_Chodesh_Tevet.html";
                    }else if (eventDate.equals(roshChodesh.getCategory()) &&eventName.equals("Chanukah: 8th Day")){
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_8th_Day_Rosh_Chodesh_Tevet_1.html";
                    }
            }

            ///  Next Day logic chanukah 6th and 7th ------
            else if (eventName.equals("Chanukah: 7th Night") || eventName.equals("Chanukah: 6th Night")) {
                String nextEventDate = getNextDayLogic(eventDate);
//
                if (nextEventDate.equals(roshChodesh.getCategory()) && eventName.equals("Chanukah: 7th Night")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_7th_Night_Erev_Rosh_Chodesh_Tevet.html";
                    }else if (nextEventDate.equals(roshChodesh.getCategory()) && eventName.equals("Chanukah: 6th Night")){
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_6th_Night_Erev_Rosh_Chodesh_Tevet.html";
                }
            }
        }

        String[] out = eventDate.split("-");
        int s1 = Integer.parseInt(out[2]);
        int s2 = Integer.parseInt(out[1]) - 1;
        String yr = out[0];
        char a, b, c, d;
        a = yr.charAt(0);
        b = yr.charAt(1);
        c = yr.charAt(2);
        d = yr.charAt(3);
        int s3 = Character.getNumericValue(a)*1000 +
                Character.getNumericValue(b)*100 +
                Character.getNumericValue(c)*10 +
                Character.getNumericValue(d);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(s3, s2, s1);

        int days = calendar1.get(Calendar.DAY_OF_WEEK);


////        else if (eventType.contains("parashat")) {
              if (eventName.equals("Parashat Vayak'heil/Pekudei")) {
                url = htmlFileUrl + "OlderHtmlFile/P'kudei.html";
             }
             else if (eventName.equals("Parashat Acharei Mot-Kedoshim")) {
                  url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot-K'doshim.html";
              }
               if (eventName.equals("Mot") || eventName.equals("Acharei") || eventName.contains("Acharei_Mot")) {
                url = htmlFileUrl + "OlderHtmlFile/Acharei_Mot.html";
                }
                else if (eventName.equals("Parashat Yitro")) {
                url = htmlFileUrl + "OlderHtmlFile/Yitro.html";
                }
               else if (eventName.equals("Parashat Tazria/M'tzora")) {
                   url = htmlFileUrl + "OlderHtmlFile/Tazria-M'tzora.html";
               }
               else if (eventName.equals("Naso I")) {
                   url = htmlFileUrl + "OlderHtmlFile/Naso_I.html";
               }
               else if (eventName.equals("Naso II")) {
                   url = htmlFileUrl + "OlderHtmlFile/Naso_II.html";
               }
               else if (eventName.equals("Parashat T'rumah")) {
                   url = htmlFileUrl + "OlderHtmlFile/T'rumah.html";
               }
               else if (eventName.equals("Parashat Sh'mini")) {
                   url = htmlFileUrl + "OlderHtmlFile/Sh'mini.html";
               }


               else if (eventName.equals("Erev Rosh Chodesh Weekday")){
                   url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Chodesh_Weekday.html";
               }else if (eventName.equals("Erev Rosh Chodesh Friday")){
                   url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Chodesh_Friday.html";
               }
               else if (eventName.equals("Parashat K'doshim")) {
                   url = htmlFileUrl + "OlderHtmlFile/K'doshim.html";
               }
               else if (eventName.equals("Parashat Va-et'chanan")) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_V'etchanan-Nachamu.html";
               }
               else if (eventName.equals("Parashat Pinchas")) {
                   url = htmlFileUrl + "OlderHtmlFile/Pinchas.html";
               }
               else if (eventName.equals("Parashat M'tzora")) {
                   url = htmlFileUrl + "OlderHtmlFile/M'tzora.html";
               }
               else if (eventName.equals("Parashat Sh'lach L'cha")) {
                   url = htmlFileUrl + "OlderHtmlFile/Sh'lach_L'cha.html";
               }
               else if (eventName.equals("Parashat P'kudei")) {
                   url = htmlFileUrl + "OlderHtmlFile/P'kudei.html";
               }
               else if (eventName.equals("Parashat Vayak'heil")) {
                   url = htmlFileUrl + "OlderHtmlFile/Vayak'heil.html";
               }
                    else if (eventName.equals("Parashat B'har/B'chukotai")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'chukotai.html";
                    }
                    else if (eventName.equals("Parashat B'haalot'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'haalot'cha.html";
                    }
                  else if (eventName.equals("Parashat B'har")) {
                   url = htmlFileUrl + "OlderHtmlFile/B'har.html";
                  }
                    else if (eventName.equals("Parashat Behar-Bechukotai")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'har.html";
                    }
                    else if (eventName.equals("Parashat B'midbar")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'midbar.html";
                    }
                    else if (eventName.equals("Parashat B'reishit")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'reishit.html";
                    }
                   else if (eventName.equals("Parashat Mishpatim")) {
                   url = htmlFileUrl + "OlderHtmlFile/Mishpatim.html";
                   }
                    else if (eventName.equals("Parashat B'shalach") || eventName.contains("B'shalach")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'shalach.html";
                    }
                    else if (eventName.equals("Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Balak.html";
                    }
                    else if (eventName.contains("Bo")) {
                        url = htmlFileUrl + "OlderHtmlFile/Bo.html";
                    }
                    else if (eventName.equals("Chayei_Sara") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Chayei_Sara.html";
                    }
                    else if (eventName.equals("Chukat-Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chukat-Balak.html";
                    }
                    else if (eventName.equals("Chukat")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chukat.html";
                    }
               else if (eventName.equals("Parashat D'varim") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
               }

                    else if (eventName.equals("Emor") || eventName.contains("Parashat Emor")) {
                        url = htmlFileUrl + "OlderHtmlFile/Emor.html";
                    }
                    else if (eventName.equals("Parashat Haazinu")) {
                        url = htmlFileUrl + "OlderHtmlFile/Haazinu.html";
                    }
                    else if (eventName.equals("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                        url = htmlFileUrl + "OlderHtmlFile/K'doshim.html";
                    }
                    else if (eventName.equals("Ki_Tavo") || eventName.contains("Tavo")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Tavo.html";
                    }
                    else if (eventName.equals("Ki Teitzei") || eventName.contains("Teitzei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Teitzei.html";
                    }
                    else if (eventName.equals("Ki_Tisa") || eventName.contains("Tisa")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Tisa.html";
                    }
                    else if (eventName.equals("Parashat Korach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Korach.html";
                    }
                    else if (eventName.equals("Parashat Lech_L'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/Lech_L'cha.html";
                    }
                    else if (eventName.equals("Parashat Tazria/M'tzora")) {
                        url = htmlFileUrl + "OlderHtmlFile/M'tzora.html";
                    }
                   else if (eventName.equals("Parashat Matot/Mas-ei")) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_Matot-Mas'ei.html";
                   }
                    else if (eventName.equals("Matot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Matot.html";
                    }
                    else if (eventName.equals("Mikeitz-2")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mikeitz-2.html";
                    }
                    else if (eventName.equals("Mikeitz")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mikeitz.html";
                    }
                    else if (eventName.equals("Mishpatim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mishpatim.html";
                    }
                  else if (eventName.equals("Parashat Shof'tim")) {
                   url = htmlFileUrl + "OlderHtmlFile/Shof'tim.html";
                  }
                 else if (eventName.equals("Parashat Vayishlach")) {
                   url = htmlFileUrl + "OlderHtmlFile/Vayishlach.html";
                 }
                 else if (eventName.equals("Parashat Nitzavim")) {
                   url = htmlFileUrl + "OlderHtmlFile/Nitzavim.html";
                  }
                    else if (eventName.equals("Parashat Naso")) {
                        url = htmlFileUrl + "OlderHtmlFile/Naso.html";
                    }
                    else if (eventName.equals("Nitzavim/Vayeilech")) {
                        url = htmlFileUrl + "OlderHtmlFile/Nitzavim-Vayeilech.html";
                    }
                    else if (eventName.equals("Nitzavim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Nitzavim.html";
                    }
                    else if (eventName.equals("Parashat Noach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Noach.html";
                    }
                    else if (eventName.equals("Pinchas")) {
                        url = htmlFileUrl + "OlderHtmlFile/Pinchas.html";
                    }
                    else if (eventName.equals("R'eih")) {
                        url = htmlFileUrl + "OlderHtmlFile/R'eih.html";
                    }
                    else if (eventName.equals("Sh'lach L'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'lach_L'cha.html";
                    }
                    else if (eventName.equals("Sh'mini")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini.html";
                    }
                    else if (eventName.equals("Parashat Sh'mot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mot.html";
                    }
                    else if (eventName.equals("Shof'tim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shof'tim.html";
                    }
                    else if (eventName.equals("T'rumah")) {
                        url = htmlFileUrl + "OlderHtmlFile/T'rumah.html";
                    }
                    else if (eventName.equals("T'tzaveh")) {
                        url = htmlFileUrl + "OlderHtmlFile/T'tzaveh.html";
                    }
                    else if (eventName.equals("Tazria-M'tzora")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tazria-M'tzora.html";
                    }
                    else if (eventName.equals("Parashat Tazria-Metzora")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tazria.html";
                    }
                    else if (eventName.equals("Parashat Tazria")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tazria-M'tzora.html";
                    }
                    else if (eventName.equals("Tol'dot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tol'dot.html";
                    }

                    else if (eventName.equals("Tzav")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tzav.html";
                    }
                    else if (eventName.equals("rachah")) {
                        url = htmlFileUrl + "OlderHtmlFile/V'zot_Hab'rachah.html";
                    }
                    else if (eventName.equals("Parashat Va-eira")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeira.html";
                    }
                 else if (eventName.equals("Parashat B'har")) {
                   url = htmlFileUrl + "OlderHtmlFile/B'har.html";
                 }
               else if (eventName.equals("Parashat Chayei Sara")) {
                   url = htmlFileUrl + "OlderHtmlFile/Chayei_Sara.html";
               }
                    else if (eventName.equals("Va-et'chanan")) {
                        url = htmlFileUrl + "OlderHtmlFile/Va-et'chanan.html";
                    }
                    else if (eventName.contains("Va-y'chi")) {
                        url = htmlFileUrl + "OlderHtmlFile/Va-y'chi.html";
                    }
                    else if (eventName.equals("Vayak'heil")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayak'heil.html";
                    }

                    else if (eventName.equals("Vayeilech")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeilech.html";
                    }
//                    else if (eventName.equals("Vayeira")) {
//                        url = htmlFileUrl + "OlderHtmlFile/Vayeira.html";
//                    }
                    else if (eventName.equals("Vayeira") || eventName.contains("Vayeira")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeira.html";
                    }
                    else if (eventName.equals("Vayeishev") || eventName.contains("Vayeshev")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeishev.html";
                    }
                    else if (eventName.equals("Vayeitzei") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeitzei.html";
                    }
                    else if (eventName.equals("Vayigash")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayigash.html";
                    }
                    else if (eventName.equals("Vayikra")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayikra.html";
                    }
                    else if (eventName.equals("Vayishlach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayishlach.html";
                    }
                    else if (eventName.equals("Parashat R'eih")) {
                        url = htmlFileUrl + "OlderHtmlFile/R'eih.html";
                    }
                  else if (eventName.equals("Parashat Sh'mini I")) {
                   url = htmlFileUrl + "OlderHtmlFile/Sh'mini_I.html";
                  }
                 else if (eventName.equals("Parashat Sh'mini II")) {
                   url = htmlFileUrl + "OlderHtmlFile/Sh'mini_II.html";
                 }
               else if (eventName.equals("Parashat Tol'dot")) {
                   url = htmlFileUrl + "OlderHtmlFile/Tol'dot.html";
               }
//                }


//                else if (eventType.contains("holiday")) {

                 else if (eventName.contains("Erev Pesach/Ta’anit Bechorot") && (days==6)) {
                  url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                  }

                 else if (eventName.startsWith("Rosh Hashana") ) {


                      String lastFour = null;
                      if (eventName != null && eventName.length() >= 4) {
                          lastFour = eventName.substring(eventName.length() - 4);
                      }
//                      else if (eventName != null && eventName.length() >= 2) {
//                          lastFour = eventName.substring(eventName.length() - 2);
//                      }
                      String regex = "(.)*(\\d)(.)*";
                      Pattern pattern = Pattern.compile(regex);
                      boolean containsNumber = pattern.matcher(lastFour).matches();
                      if (containsNumber){
                          url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_1.html";
                      }else {
                          url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
                      }
                  }
                   else if (eventName.contains("Chol Hamoed Sukkot Shabbat") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }
                  else if (eventName.equals("Yom HaAliyah")) {
                      url = htmlFileUrl + "OlderHtmlFile/Yom_HaZikaron.html";
                  }
                  else if (eventName.equals("Asara B'Tevet") ) {
                      url = htmlFileUrl + "OlderHtmlFile/Asara_B'Tevet.html";
                  }
                  else if (eventName.contains("Erev Chanukah") ) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Chanukah.html";
                  }
                  else if (eventName.contains("Ta'anit Bechorot") ) {
                      url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Bechorot.html";
                  }
                    else if (eventName.contains("Aseret Y'mei T'shuva") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Aseret_Y'mei_T'shuva.html";
                    }
                    else if (eventName.contains("B'dikat and Biur Chametz") ) {
                        url = htmlFileUrl + "OlderHtmlFile/B'dikat_and_Biur_Chametz.html";
                    }
                    else if (eventName.contains("Erev Chanukah") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_1_Weekday.html";
                    }

                  else if (eventName.contains("Lag Ba'Omer")) {
                      url = htmlFileUrl + "OlderHtmlFile/Lag_Ba'Omer.html";
                  }
//                    else if (eventName.equals("Rosh Hashana 5779")){
//                      url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_1.html";
//                    }
//                  else if (eventName.equals("Rosh Hashana II")){
//                      url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
//                  }

                  else if (eventName.contains("Chanukah: 1st Night")) {
                      url = htmlFileUrl + "OlderHtmlFile/Chanukah_1st_Night.html";
                  }
                  else if (eventName.contains("Erev Chanukah")) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Chanukah.html";
                  }
                    else if (eventName.contains("Chanukah: 2nd Night") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_2nd_Night.html";
                    } else if (eventName.contains("Chanukah: 2nd Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 3rd Night") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_3rd_Night.html";
                    }else if (eventName.contains("Chanukah: 3rd Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 4th Night") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_4th_Night.html";
                    } else if (eventName.contains("Chanukah: 4th Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 5th Night") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_5th_Night.html";
                    }else if (eventName.contains("Chanukah: 5th Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
//
//                    else if (eventName.contains("Chanukah: 7th Night") && !(days==7)) {
//                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_7th_Night.html";
//                    }
                    else if (eventName.contains("Chanukah: 7th Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
//                    else if (eventName.contains("Chanukah: 8th Night") && !(days==7)) {
//                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_8th_Night.html";
//                    }
                    else if (eventName.contains("Chanukah: 8th Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }






                    else if (eventName.contains("Chanukah: 8th Day") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_8th_Day.html";
                    } else if (eventName.contains("Chanukah: 8 Weekday") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Counting the Omer") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    } else if (eventName.contains("Erev Chanukah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Chanukah.html";
                    } else if (eventName.contains("Erev Pesach") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot.html";
                    }
                    else if (eventName.contains("Erev Pesach/Ta'anit Bechorot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot.html";
                    }
                    else if (eventName.contains("Erev Pesach/Ta'anit Bechorot") && (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                    }
                    else if (eventName.contains("Erev Purim") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Purim.html";
                    }

                    else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Sh'mini_Atzeret-Simchat_Torah.html";
                    }

                    else if (eventName.contains("Shabbat Nachamu")){
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_V'etchanan-Nachamu.html";
                    }
                    else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Sh'mini_Atzeret-Simchat_Torah.html";
                    }
                    else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html";
                    }

                    else if (eventName.contains("Erev Shavuot Friday") && (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Shavuot_Friday.html";
                    }
                    else if (eventName.contains("Erev Shavuot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Shavuot.html";
                    }
                    else if (eventName.contains("Erev Tisha b'Av") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Tisha_b'Av.html";
                    }
                    else if (eventName.contains("Erev Yom Kippur Friday") && (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Yom_Kippur_Friday.html";
                    }else if (eventName.contains("Erev Yom Kippur") && !(days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Yom_Kippur.html";
                   }
                    else if (eventName.contains("Hoshana Raba") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Hoshana_Raba.html";
                    }
                    else if (eventName.contains("Lag BaOmer") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Lag_Ba'Omer.html";
                    }
                    else if (eventName.contains("Leil Selichot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Leil_Selichot.html";
                    }
                    else if (eventName.contains("Machar Chodesh") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Machar_Chodesh.html";
                    }
                    else if (eventName.contains("Pesach Chol Hamoed Day 2") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_2.html";
                    }
                    else if (eventName.contains("Pesach Chol Hamoed Day 1") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_1.html";
                    }
                    else if (eventName.contains("Pesach Chol Hamoed Day 3") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_3.html";
                    }
                    else if (eventName.contains("Pesach I") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_1.html";
                    }
                    else if (eventName.contains("Pesach Chol Hamoed Day 4") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_4.html";
                    }
                    else if (eventName.contains("Pesach Chol HaMoed Day 5 Weekday") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Weekday.html";
                    }else if (eventName.contains("Pesach Chol HaMoed Day 5 Weekday") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Friday.html";
                    }
                    else if (eventName.contains("Pesach Day 1") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Shabbat.html";
                    }
                    else if (eventName.contains("Pesach Day 1 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Shabbat.html";
                    }
                    else if (eventName.contains("Pesach VIII") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Weekday.html";
                    }else if (eventName.contains("Pesach VIII") && (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Shabbat.html";
                    }
                    else if (eventName.contains("Shabbat Chazon")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
                    }

                    else if (eventName.contains("Pesach Day 7") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
                    } else if (eventName.contains("Pesach Day 7") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7.html";
                    }

                    else if (eventName.contains("Pesach VII") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7.html";
                    }else if (eventName.contains("Pesach VII") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
                    }

                  else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday") && (days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Friday.html";
                  } else if (eventName.contains("Pesach Chol HaMoed Day 5 Weekday") && !(days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Weekday.html";
                  }
                    else if (eventName.contains("Rosh Hashana II") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
                    }

                    else if (eventName.contains("Pesach Sheini")) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Sheini.html";
                    }
                    else if (eventName.contains("Purim Katan")&& (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Purim_Katan.html";
                    }
                    else if (eventName.equals("Shushan Purim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shushan_Purim.html";
                    }
//
                    // Saturday
                    else if (eventName.contains("Sh'mini Atzeret/Simchat Torah") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini_Atzeret-Simchat_Torah.html";
                    } else if (eventName.contains("Sh'mini Atzeret/Simchat Torah") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini_Atzeret-Simchat_Torah_Shabbat.html";
                    }
                    else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot-K'doshim.html";
                    }
                    else if ((eventName.contains("Shabbat Acharei_Mot")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot.html";
                    }
                    else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'chukotai.html";
                    }
                  else if (eventName.contains("Parashat Vayeilech") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Vayeilech.html";
                  }
                 else if (eventName.contains("Parashat D'varim") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
                 }
                 else if (eventName.contains("Parashat Va-et'chanan") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_V'etchanan-Nachamu.html";
                 }


                   else if (eventName.contains("Shabbat B'har-B'chukotai")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'har-B'chukotai.html";
                    }
                    else if (eventName.contains("Shabbat B'har")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'har.html";
                    }
                    else if (eventName.contains("Shabbat B'reishit")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'reishit.html";
                    }
                    else if (eventName.contains("Shabbat B'shalach-Shabbat Shirah")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'shalach-Shabbat_Shirah.html";
                    }
                    else if (eventName.contains("Shabbat Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Balak.html";
                    }
                    else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Bamidbar.html";
                    }
                    else if (eventName.contains("Shabbat Bo") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Bo.html";
                    }
                    else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah_Rosh_Chodesh.html";
                    }
                    else if (eventName.contains("Shabbat Chanukah")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
                    else if (eventName.contains("Shabbat Chayei Sara")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chayei_Sara.html";
                    }
                    else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chol_HaMoed_Pesach.html";
                    }
                    else if (eventName.contains("Shabbat Chol Hamoed Sukkot") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chol_Hamoed_Sukkot_Friday.html";
                    }
                    else if (eventName.equals("Parashat Chukat")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chukat.html";
                    }
                    else if ((eventName.contains("Shabbat Chukat")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chukat.html";
                    }
                    else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.equals("Shabbat Chazon")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
                    }
//
                    else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Emor.html";
                    }
                    else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ha'azinu-Shabbat_Shuva.html";
                    }
                    else if (eventName.contains("Shabbat Ha'azinu")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ha'azinu.html";
                    }
                    else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_HaChodesh.html";
                    }
                    else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_HaGadol.html";
                    }
                    else if (eventName.contains("Shabbat K'doshim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_K'doshim.html";
                    } else if (eventName.contains("Shabbat Ki Tavo")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ki_Tavo.html";
                    }
                    else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ki_Teitze.html";
                    }
                    else if (eventName.contains("Shabbat Ki Tisa") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ki_Tisa.html";
                    }
                    else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Korach.html";
                    }
                    else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Lech_L'cha.html";
                    }
                    else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_M'tzora.html";
                    }
                    else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_M'varchim.html";
                    }
                    else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Mas'ei.html";
                    }
                    else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Matot-Mas'ei.html";
                    }
                    else if (eventName.contains("Shabbat Matot") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Matot.html";
                    }
                    else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Mishpatim.html";
                    }
                    else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_N'tzavim_Vayeilech.html";
                    }
                    else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_N'tzavim.html";
                    }
                    else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Naso.html";
                    }
                    else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Noach.html";
                    }
                    else if (eventName.contains("Shabbat P'kudei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_P'kudei.html";
                    }

                   else if (eventName.equals("Parashat Vayak'heil-Pekudei") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayakheil-P'kudei.html";
                   }

                    else if (eventName.equals("Shabbat Parah") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Parah.html";
                    }
                    else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Pinchas.html";
                    }
                    else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Re'eh.html";
                    }
                    else if ((eventName.contains("Shabbat Rosh Chodesh I")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Rosh_Chodesh_I.html";
                    }
                    else if (eventName.contains("Shabbat Sh'kalim") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Sh'kalim.html";
                    }
                    else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Sh'mini.html";
                    }
                    else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Sh'mot.html";
                    }
                    else if (eventName.contains("Shabbat Shoftim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Shoftim.html";
                    }
                    else if (eventName.contains("Shabbat Trumah") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_T'rumah.html";
                    }
                    else if (eventName.equals("tzaveh") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_T'tzaveh.html";
                    }
                   else if (eventName.equals("Parashat T'tzaveh") ) {
                   url = htmlFileUrl + "OlderHtmlFile/T'tzaveh.html";
                   }
                  else if (eventName.equals("Parashat Shof'tim") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Shof'tim.html";
                  }
                 else if (eventName.equals("Parashat Eikev") ) {
                   url = htmlFileUrl + "OlderHtmlFile/Eikev.html";
                 }
                    else if (eventName.contains("tzora") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tazria-M'tzora.html";
                    }
                    else if (eventName.contains("Shabbat Tazria") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tazria.html";
                    }
                    else if (eventName.contains("Shabbat Toldot") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Toldot.html";
                    }
                    else if (eventName.contains("Shabbat Tzav")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tzav.html";
                    }
                    else if (eventName.contains("Shabbat V'etchanan-Nachamu") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_V'etchanan-Nachamu.html";
                    }
                    else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Va'eira.html";
                    }
                    else if (eventName.contains("habbat Vay'chi")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vay'chi.html";
                    }
                    else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayakheil.html";
                    }
//                    else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech")) ) {
//                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeilech.html";
//                    }
                    else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeira.html";
                    }
                    else if (eventName.contains("Parashat Vayeishev")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeishev.html";
                    }
                    else if ((eventName.contains("Shabbat Vayeitzei")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeitzei.html";
                    }
                    else if (eventName.contains("Shabbat Vayigash") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayigash.html";
                    }
                    else if (eventName.equals("Parashat Vayikra")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayikra.html";
                    }
                 else if (eventName.equals("Parashat Vayigash")) {
                   url = htmlFileUrl + "OlderHtmlFile/Vayigash.html";
                  }
               else if (eventName.equals("Purim")) {
                   url = htmlFileUrl + "OlderHtmlFile/Purim.html";
               }
                  else if (eventName.equals("Parashat Vayeitzei")) {
                   url = htmlFileUrl + "OlderHtmlFile/Vayeitzei.html";
                   }
               else if (eventName.equals("Parashat Mikeitz")) {
                   url = htmlFileUrl + "OlderHtmlFile/Mikeitz.html";
               }
                    else if (eventName.contains("Shabbat Vayishlach") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayishlach.html";
                    }
                    else if (eventName.contains("Shabbat Yitro") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Yitro.html";
                    }
                    else if (eventName.contains("Shabbat Zachor") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Zachor.html";
                    }
                    else if (eventName.equals("Shabbat Sh'kalim") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Sh'kalim.html";
                    }

                    else if (eventName.contains("Shabbat Shuva")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Shuva.html";
                    }

                    else if (eventName.contains("Shavuot Shabbat") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shavuot_Shabbat.html";
                    }
                    else if (eventName.equals("Shabbat HaChodesh") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_HaChodesh.html";
                    }
                    else if (eventName.contains("Shavuot I") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shavuot.html";
                    }else if (eventName.contains("Shavuot I") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shavuot_Shabbat.html";
                    }

                    else if (eventName.contains("Shavuot") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shavuot.html";
                    }else if (eventName.contains("Shavuot") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shavuot_Shabbat.html";
                    }
                  else if (eventName.contains("Shavuot II")) {
                      url = htmlFileUrl + "OlderHtmlFile/Shavuot-II.html";
                  }

                    else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shiva_Asar_b'Tammuz.html";
                    } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shushan_Purim.html";
                    } else if ((eventName.contains("Sukkot 1")) || (eventName.contains("Shabbat")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_1_Shabbat.html";
                    }

                    else if ((eventName.contains("Sukkot_1_Weekday")) && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_1_Weekday.html";
                    }
                    else if ((eventName.contains("Sukkot_1_Weekday")) && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_1_Shabbat.html";
                    }

                    else if ((eventName.contains("Sukkot_2")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_2_Weekday.html";
                    }
                    else if ((eventName.contains("Sukkot_3")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_3_Weekday.html";
                    }
                    else if (eventName.contains("Sukkot_4") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_4_Weekday.html";
                    }
                    else if ((eventName.contains("Sukkot_5")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_5_Weekday.html";
                    }
                    else if ((eventName.contains("Sukkot_6")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_6_Weekday.html";
                    }
                    else if ((eventName.contains("Preparation")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_Preparation.html";
                    }
                    else if ((eventName.contains("Ta")) && (eventName.contains("anit_Bechorot")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html";
                    }
                    else if ((eventName.contains("Ta")) && (eventName.contains("anit_Esther")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Esther.html";
                    }
                    else if (eventName.contains("Ta'anit Bechorot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html";
                    }
                    else if (eventName.contains("Ta'anit Esther") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Esther.html";
                    }
                    else if (eventName.contains("Tisha b'Av") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Tisha b'Av.html";
                    }
                    else if (eventName.contains("Tisha B'Av") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Tisha_B'Av.html";
                    }
                    else if (eventName.contains("Tu B'Av") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Tu_B'Av.html";
                    }
                    else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Tu_B'Sh'vat.html";
                    }
                    else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Tzom_Gedaliah.html";
                    }
                    else if (eventName.contains("Yom Ha'atzma'ut") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_Ha'atzma'ut.html";
                    }
                    else if (eventName.contains("Yom HaShoah V'hag'vurah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_HaShoah_V'hag'vurah.html";
                    }
                    else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_HaZikaron.html";
                    }
                    else if (eventName.contains("Yom Kippur Shabbat") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_Kippur_Shabbat.html";
                    }
                    else if (eventName.contains("Yom Kippur") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_Kippur.html";
                    }
                    else if (eventName.contains("Yom Yerushalayim") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_Yerushalayim.html";
                    }
                    else if (eventName.contains("Erev Sukkot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Sukkot.html";
                    }
                    else if (eventName.contains("Sukkot I") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_1_Weekday.html";
                    }
                    else if (eventName.contains("Sukkot 2 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_2_Weekday.html";
                    }
                    else if (eventName.contains("Sukkot 2 Weekday") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }
                    else if (eventName.contains("Sukkot 3 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_3_Weekday.html";
                    }
                    else if (eventName.contains("Sukkot 3 Weekday") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }

                    else if (eventName.contains("Sukkot 4 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_4_Weekday.html";
                    }
                    else if (eventName.contains("Sukkot 4 Weekday") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }
                    else if (eventName.contains("Sukkot 5 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_5_Weekday.html";
                    }else if (eventName.equals("Chol Hamoed Sukkot Shabbat") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }
                    else if (eventName.contains("Sukkot 6 Weekday") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_6_Weekday.html";
                    }else if (eventName.contains("Sukkot 6 Weekday") && (days==7)) {
                        url = htmlFileUrl + "Chol_Hamoed_Sukkot_Shabbat.html";
                    }

                    else if (eventName.contains("Hoshana Raba") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sukkot_Preparation.html";
                    }
                    else if (eventName.contains("Yom") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Yom_Ha'atzma'ut.html";
                    }
                    else if (eventName.contains("Parashat Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Balak.html";
                    }


             else if (eventName.contains("Erev Pesach/Ta'anit Bechorot") && (days==6)) {
                url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
            }
            else if (eventName.contains("Erev Shavuot") && (days==6)) {
                url = htmlFileUrl + "OlderHtmlFile/Erev_Shavuot_Friday.html";
            }
            else if (eventName.contains("Yom Kippur") && (days==6)) {
                url = htmlFileUrl + "OlderHtmlFile/Erev_Yom_Kippur_Friday.html";
            }
            else if (eventName.contains("Erev Sukkot") && (days==6)) {
                url = htmlFileUrl + "OlderHtmlFile/Erev_Sukkot_Friday.html";
            }
                 else if (eventName.contains("Pesach Day 7 Shabbat") && (days==7)) {
                      url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
                    }
                    else if (eventName.contains("Pesach Day VII") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7.html";
                    }

                    else if (eventName.contains("Pesach I") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Shabbat.html";
                    }
                    else if (eventName.contains("Pesach I") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_1_Weekday.html";
                    }
                    else if (eventName.contains("Pesach VIII") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach-VIII.html";
                    }
                    else if (eventName.contains("Tu B'Av") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Tu_B'Av.html";
                    }
                  else if (eventName.equals("Erev Rosh Hashanah Weekday") && !(days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Weekday.html";
                  }
                  else if (eventName.equals("Erev Rosh Hashanah Friday") && (days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
                  }

                  else if (eventName.equals("Chol Hamoed Sukkot Shabbat") && (days==7)) {
                      url = htmlFileUrl + "OlderHtmlFile/Chol_Hamoed_Sukkot_Shabbat.html";
                  }

//        }

//        else if (eventType.contains("roshchodesh")) {

             if (eventName.equals("Rosh Chodesh Tamuz")){
                url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }else if (eventName.equals("Rosh Chodesh Cheshvan")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Sh'vat")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Adar I") ){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Adar_I.html";
             }
             else if (eventName.equals("Rosh Chodesh Adar II") ){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Adar_II.html";
             }
//             else if (eventName.contains("Rosh Hashanna 5780") ){
//                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Adar_I.html";
//             }
             else if (eventName.contains("Rosh Chodesh Adar") ) {
                url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Adar_I.html";
             }
             else if (eventName.equals("Rosh Chodesh Nisan")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Iyyar")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Sivan")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Kislev")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Tevet")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.contains("Rosh Chodesh Av") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Av.html";
                    } else if (eventName.contains("Rosh Chodesh Elul") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Elul.html";
                    }
                    else if (eventName.contains("Erev Rosh Hashanah Weekday")) {
                        url = htmlFileUrl + "Rosh_Chodesh_Cheshvan.html";
                    }

                  else if (eventName.contains("Erev Rosh Chodesh Weekday") ) {
                  url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Chodesh_Weekday.html";
                  }else if (eventName.contains("Erev Rosh Chodesh Friday") && (days==6)) {
                  url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Chodesh_Friday.html";
                  }
                    else if (eventName.contains("Parashat Acharei Mot-Kedoshim") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot-K'doshim.html";
                    }
                    else if (eventName.contains("Erev Rosh Hashanah Weekday")){
                        url = htmlFileUrl+ "OlderHtmlFile/Erev_Rosh_Hashanah_Weekday.html";
                    }else if (eventName.contains("Erev Rosh Hashanah Friday") && (days==6)){
                    url = htmlFileUrl+ "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
                    }

//        }
            // ----- Omer --------------------------------------
//                    else if (eventType.contains("omer")) {
                    if (eventName.contains("15th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("15th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("Lag BaOmer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Lag_Ba'Omer.html";
                    }
                    else if (eventName.contains("33rd day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Lag_Ba'Omer.html";
                    }
                    else if (eventName.contains("Ta'anit Bechorot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ta'anit_Bechorot.html";
                    }
                    else if (eventName.contains("16th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("17th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("18th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("19th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("20th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("21th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("22th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("23th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("24th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("25th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("26th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("27th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("28th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("29th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("30th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("31th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("32th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("34th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("35th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("36th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("37th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("38th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("39th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("40th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("41th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("42th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("43th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("44th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("45th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("46th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("47th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("48th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("49th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("33rd day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("14th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("1st day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("2nd day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("3rd day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("4th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("5th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("6th day of the Omer") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("7th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("8th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("9th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("10th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("11th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("12th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("13th day of the Omer")) {
                        url = htmlFileUrl + "OlderHtmlFile/Counting_the_Omer.html";
                    }
                    else if (eventName.contains("Parashat Acharei Mot I")) {
                        url = htmlFileUrl + "OlderHtmlFile/Acharei_Mot_I.html";
                    }
                    else if (eventName.contains("Parashat Acharei Mot II")) {
                        url = htmlFileUrl + "OlderHtmlFile/Acharei_Mot_II.html";
                    }
                    else if (eventName.contains("Parashat Lech L'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/Lech_L'cha.html";
                    }
                    else if (eventName.contains("Sh'mini Atzeret")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini_Atzeret.html";
                    }
//        }
        return url;

        }

    public static String getNextDayLogic(String eventDate){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date newDate = calendar.getTime();
        // ---  Then, if you need to, convert it back to a String:

        eventDate = dateFormat.format(newDate);

        return eventDate;
    }


    }



