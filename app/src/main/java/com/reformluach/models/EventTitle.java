package com.reformluach.models;


public  class EventTitle {

    public static final String replaceRecievedTitle(String title){
        if (title.contains("Parashat Bereshit")){
            title = title.replace("Parashat Bereshit","Parashat B'reishit");
        }
        else if (title.contains("Parashat Lech-Lecha")){
            title= title.replace("Parashat Lech-Lecha","Parashat Lech L'cha");
        }else if (title.contains("Parashat Vaera")){
            title= title.replace("Parashat Vaera","Parashat Vayeira");
        }else if (title.contains("Parashat Toldot")){
            title= title.replace("Parashat Toldot","Parashat Tol'dot");
        }else if (title.contains("Parashat Vayetzei")){
            title= title.replace("Parashat Vayetzei","Parashat Vayeitzei");
        }else if (title.contains("Parashat Vayeshev")){
            title=title.replace("Parashat Vayeshev","Parashat Vayeishev");
        }else if (title.contains("Parashat Miketz")){
            title=title.replace("Parashat Miketz","Parashat Mikeitz");
        }else if (title.contains("Parashat Vayechi")){
            title = title.replace("Parashat Vayechi","Parashat Va-y'chi");
        }else if (title.contains("Parashat Shemot")){
            title= title.replace("Parashat Shemot","Parashat Sh'mot");
        }else if (title.contains("Parashat Beshalach")){
            title=title.replace("Parashat Beshalach","Parashat B'shalach");
        }else if (title.contains("Parashat Terumah")){
            title= title.replace("Parashat Terumah","Parashat T'rumah");
        }else if (title.contains("Parashat Tetzaveh")){
            title= title.replace("Parashat Tetzaveh","Parashat T'tzaveh");
        }

        else if (title.contains("Parashat Vayakhel")){
            title=title.replace("Parashat Vayakhel","Parashat Vayak'heil");
        }else if (title.contains("Parashat Pekudei")){
            title=title.replace("Parashat Pekudei","Parashat P'kudei");
        }else if (title.contains("Parashat Shmini")){
            title=title.replace("Parashat Shmini","Parashat Sh'mini");
        }else if (title.contains("Parashat Metzora")){
            title=title.replace("Parashat Metzora","Parashat M'tzora");
        }else if (title.contains("Parashat Achrei Mot")){
            title=title.replace("Parashat Achrei Mot","Parashat Acharei Mot");
        }else if (title.contains("Parashat Kedoshim")){
            title = title.replace("Parashat Kedoshim","Parashat K'doshim");
        }else if (title.contains("Parashat Behar")){
            title = title.replace("Parashat Behar","Parashat B'har");
        }else if (title.contains("Parashat Bechukotai")){
            title= title.replace("Parashat Bechukotai","Parashat B'chukotai");
        }else if (title.contains("Parashat Bamidbar")){
            title= title.replace("Parashat Bamidbar","Parashat B'midbar");
        }else if (title.contains("Parashat Nasso")){
            title= title.replace("Parashat Nasso","Parashat Naso");
        }else if (title.contains("Parashat Beha'alotcha")){
            title=title.replace("Parashat Beha'alotcha","Parashat B'haalot'cha");
        }else if (title.contains("Parashat Sh'lach")){
            title= title.replace("Parashat Sh'lach","Parashat Sh'lach L'cha");
        }else if (title.contains("Parashat Devarim")){
            title=title.replace("Parashat Devarim","Parashat D'varim");
        }else if (title.contains("Parashat Vaetchanan")){
            title=title.replace("Parashat Vaetchanan","Parashat Va-et'chanan");
        }else if (title.contains("Parashat Re'eh")){
            title=title.replace("Parashat Re'eh","Parashat R'eih");
        }else if (title.contains("Parashat Shoftim")){
            title=title.replace("Parashat Shoftim","Parashat Shof'tim");
        }else if (title.contains("Parashat Ki Teitzei")){
            title=title.replace("Parashat Ki Teitzei","Parashat Ki Teitzei");
        }else if (title.contains("Parashat Ha'Azinu")){
            title=title.replace("Parashat Ha'Azinu","Parashat Haazinu");
        }else if (title.contains("Parashat Vezot Haberakhah")){
            title=title.replace("Parashat Vezot Haberakhah","Parashat V'zot Hab'rachah");
        }else if (title.contains("Parashat Vayakhel-Pekudei")){
            title=title.replace("Parashat Vayakhel-Pekudei","Parashat Vayak’heil/P’kudei");
        }else if (title.contains("Parashat Tazria-Metzora")){
            title=title.replace("Parashat Tazria-Metzora","Parashat Tazria/M'tzora");
        }else if (title.contains("Parashat Achrei Mot-Kedoshim")){
            title=title.replace("Parashat Achrei Mot-Kedoshim","Parashat Acharei Mot/K'doshim");
        }else if (title.contains("Parashat Behar-Bechukotai")){
            title=title.replace("Parashat Behar-Bechukotai","Parashat B'har/B'chukotai");
        }else if (title.contains("Parashat Chukat-Balak")){
            title=title.replace("Parashat Chukat-Balak","Parashat Chukat/Balak");
        }else if (title.contains("Parashat Matot-Masei")){
            title=title.replace("Parashat Matot-Masei","Parashat Matot/Mas-ei");
        }else if (title.contains("Parashat Nitzavim-Vayeilech")){
            title=title.replace("Parashat Nitzavim-Vayeilech","Parashat Nitzavim/Vayeilech");
        }else if (title.contains("Erev Pesach")){
            title=title.replace("Erev Pesach","Erev Pesach/Ta’anit Bechorot");
        }else if (title.contains("Shabbat Shekalim")){
            title=title.replace("Shabbat Shekalim","Shabbat Sh'kalim");
        }else if (title.contains("Tu BiShvat")){
            title=title.replace("Tu BiShvat","Tu B'Sh'vat");
        }else if (title.contains("Tzom Tammuz")){
            title=title.replace("Tzom Tammuz","Shiva Asar b'Tammuz");
        }else if (title.contains("Tish'a B'Av")){
            title=title.replace("Tish'a B'Av","Tisha B'Av");
        }else if (title.contains("Erev Tisha B'\'Av")){
            title=title.replace("Erev Tisha B'\'Av","Erev Tisha b'Av");
        }else if (title.contains("Erev Rosh Hashana")){
            title=title.replace("Erev Rosh Hashana","Erev Rosh Hashanah Weekday");
        }else if (title.contains("Rosh Hashana")){
            title=title.replace("Rosh Hashana","Rosh Hashanah 1");
        }else if (title.contains("Rosh Hashana II")){
            title=title.replace("Rosh Hashana II","Rosh Hashanah 2");
        }else if (title.contains("Yom HaShoah")){
            title=title.replace("Yom HaShoah","Yom HaShoah V'hag'vurah");
        }else if (title.contains("Yom HaAtzma'ut")){
            title=title.replace("Yom HaAtzma'ut","Yom Ha'atzma'ut");
        }else if (title.contains("Lag BaOmer")){
            title=title.replace("Lag BaOmer","Lag Ba'Omer");
        }else if (title.contains("Shmini Atzeret")){
            title=title.replace("Shmini Atzeret","Sh'mini Atzeret/Simchat Torah");
        }else if (title.contains("Sukkot II (CH''M)")){
            title=title.replace("Sukkot II (CH''M)","Sukkot 2 Weekday");
        }else if (title.contains("Sukkot III (CH''M)")){
            title=title.replace("Sukkot III (CH''M)","Sukkot 3 Weekday");
        }else if (title.contains("Sukkot IV (CH''M)")){
            title=title.replace("Sukkot IV (CH''M)","Sukkot 4 Weekday");
        }else if (title.contains("Sukkot V (CH''M)")){
            title=title.replace("Sukkot V (CH''M)","Sukkot 5 Weekday");
        }else if (title.contains("Sukkot VI (CH''M)")){
            title=title.replace("Sukkot VI (CH''M)","Sukkot 6 Weekday");
        }else if (title.contains("Sukkot VII (Hoshana Raba)")){
            title=title.replace("Sukkot VII (Hoshana Raba)","Hoshana Raba");
        }else if (title.contains("Pesach Sheni")){
            title=title.replace("Pesach Sheni","Pesach Sheini");
        }else if (title.contains("Pesach II (CH''M)")){
            title=title.replace("Pesach II (CH''M)","Pesach Chol Hamoed Day 1");
        }else if (title.contains("Pesach III (CH''M)")){
            title=title.replace("Pesach III (CH''M)","Pesach Chol Hamoed Day 2");
        }else if (title.contains("Pesach IV (CH''M)")){
            title=title.replace("Pesach IV (CH''M)","Pesach Chol Hamoed Day 3");
        }else if (title.contains("Pesach V (CH''M)")){
            title=title.replace("Pesach V (CH''M)","Pesach Chol Hamoed Day 4");
        }else if (title.contains("Pesach VI (CH''M)")){
            title=title.replace("Pesach VI (CH''M)","Pesach Chol HaMoed Day 5 Weekday");
        }else if (title.contains("Chanukah: 1 Candle")){
            title=title.replace("Chanukah: 1 Candle","Erev Chanukah");
        }else if (title.contains("Chanukah: 8th Day")){
            title=title.replace("Chanukah: 8th Day","Chanukah 8 Weekday");
        }
        return title;
    }

    public static final String replacetitleWithSpecialChar(String subtitle){
        if (subtitle.contains(":")){
        subtitle = subtitle.replace(":","");
        }
        else if (subtitle.contains("/")){
            subtitle =subtitle.replace("/","-");
        }else if (subtitle.contains("")){
            subtitle =subtitle.replace("","_");
        }
        return subtitle;
    }

    public static final String htmlFileUrl = "file:///android_asset/";

    public static final String loadHtmlFile(String eventType,String eventName) {
        String url = null;


        if (eventType.contains("Todays")) {
            if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                url = htmlFileUrl + "Acharei_Mot.html";
            } else if (eventName.contains("Parashat Behar-Bechukotai")) {
                url = htmlFileUrl + "B'chukotai.html";
            } else if (eventName.contains("Parashat Beha'alotcha")) {
                url = htmlFileUrl + "B'haalot'cha.html";
            } else if (eventName.contains("chukotai") || eventName.contains("har")) {
                url = htmlFileUrl + "B'har-B'chukotai.html";
            } else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                url = htmlFileUrl + "B'har.html";
            } else if (eventName.contains("Parashat Bamidbar")) {
                url = htmlFileUrl + "B'midbar.html";
            } else if (eventName.contains("Parashat Bereshit")) {
                url = htmlFileUrl + "B'reishit.html";
            } else if (eventName.contains("Parashat Beshalach") || eventName.contains("Beshalach")) {
                url = htmlFileUrl + "B'shalach.html";
            } else if (eventName.contains("Balak")) {
                url = htmlFileUrl + "Balak.html";
            } else if (eventName.contains("Bo")) {
                url = htmlFileUrl + "Bo.html";
            } else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                url = htmlFileUrl + "Chayei_Sara.html";
            } else if (eventName.contains("Chukat-Balak")) {
                url = htmlFileUrl + "Chukat-Balak.html";
            } else if (eventName.contains("Chukat")) {
                url = htmlFileUrl + "Chukat.html";
            } else if (eventName.contains("Parashat Devarim") || eventType.contains("Devarim")) {
                url = htmlFileUrl + "D'varim.html";
            } else if (eventName.contains("Eikev")) {
                url = htmlFileUrl + "Eikev.html";
            } else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                url = htmlFileUrl + "Emor.html";
            } else if (eventName.contains("Parashat Ha'Azinu")) {
                url = htmlFileUrl + "Haazinu.html";
            } else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                url = htmlFileUrl + "K'doshim.html";
            } else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                url = htmlFileUrl + "Ki_Tavo.html";
            } else if (eventName.contains("Ki_Teitzei") || eventName.contains("Teitzei")) {
                url = htmlFileUrl + "Ki_Teitzei.html";
            } else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                url = htmlFileUrl + "Ki_Tisa.html";
            } else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                url = htmlFileUrl + "Korach.html";
            } else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                url = htmlFileUrl + "Lech_L'cha.html";
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                url = htmlFileUrl + "M'tzora.html";
            } else if (eventName.contains("Parashat Matot-Masei")) {
                url = htmlFileUrl + "Matot-Mas-ei.html";
            } else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                url = htmlFileUrl + "Mas-ei.html";
            } else if (eventName.contains("Matot")) {
                url = htmlFileUrl + "Matot.html";
            } else if (eventName.contains("Mikeitz-2")) {
                url = htmlFileUrl + "Mikeitz-2.html";
            } else if (eventName.contains("Mikeitz") || eventName.contains("Miketz")) {
                url = htmlFileUrl + "Mikeitz.html";
            } else if (eventName.contains("Mishpatim")) {
                url = htmlFileUrl + "Mishpatim.html";
            } else if (eventName.contains("Parashat Nasso")) {
                url = htmlFileUrl + "Naso.html";
            } else if (eventName.contains("Nitzavim-Vayeilech")) {
                url = htmlFileUrl + "Nitzavim-Vayeilech.html";
            } else if (eventName.contains("Nitzavim")) {
                url = htmlFileUrl + "Nitzavim.html";
            } else if (eventName.contains("Parashat Noach")) {
                url = htmlFileUrl + "Noach.html";
            } else if (eventName.contains("Parashat Vayakhel-Pekudei") || eventName.contains("Vayakhel-Pekudei")) {
                url = htmlFileUrl + "P'kudei.html";
            } else if (eventName.contains("Pinchas")) {
                url = htmlFileUrl + "Pinchas.html";
            }
//            else if (eventName.contains("R'eih")) {
//                wvDetails.loadUrl("file:///android_asset/R'eih.html");
//            } else if (eventName.contains("Sh'lach")) {
//                wvDetails.loadUrl("file:///android_asset/Sh'lach_L'cha.html");
//            } else if (eventName.contains("Shmini")) {
//                wvDetails.loadUrl("file:///android_asset/Sh'mini.html");
//            } else if (eventName.contains("Shemot")) {
//                wvDetails.loadUrl("file:///android_asset/Sh'mot.html");
//            } else if (eventName.contains("Shoftim")) {
//                wvDetails.loadUrl("file:///android_asset/Shof'tim.html");
//            } else if (eventName.contains("Terumah")) {
//                wvDetails.loadUrl("file:///android_asset/T'rumah.html");
//            } else if (eventName.contains("Tetzaveh")) {
//                wvDetails.loadUrl("file:///android_asset/T'tzaveh.html");
//            } else if (eventName.contains("Tazria-M'tzora")) {
//                wvDetails.loadUrl("file:///android_asset/Tazria-M'tzora.html");
//            } else if (eventName.contains("Parashat Tazria-Metzora")) {
//                wvDetails.loadUrl("file:///android_asset/Tazria.html");
//            } else if (eventName.contains("Toldot")) {
//                wvDetails.loadUrl("file:///android_asset/Tol'dot.html");
//            } else if (eventName.contains("Tzav")) {
//                wvDetails.loadUrl("file:///android_asset/Tzav.html");
//            } else if (eventName.contains("rachah")) {
//                wvDetails.loadUrl("file:///android_asset/V'zot_Hab'rachah.html");
//            } else if (eventName.contains("Vaera")) {
//                wvDetails.loadUrl("file:///android_asset/Va-eira.html");
//            } else if (eventName.contains("Vaetchanan")) {
//                wvDetails.loadUrl("file:///android_asset/Va-et'chanan.html");
//            } else if (eventName.contains("Vayechi")) {
//                wvDetails.loadUrl("file:///android_asset/Va-y'chi.html");
//            } else if (eventName.contains("Vayakhel")) {
//                wvDetails.loadUrl("file:///android_asset/Vayak'heil.html");
//            } else if (eventName.contains("Vayak’heil-P’kudei")) {
//                wvDetails.loadUrl("file:///android_asset/Vayak’heil-P’kudei.html");
//            } else if (eventName.contains("Vayeilech")) {
//                wvDetails.loadUrl("file:///android_asset/Vayeilech.html");
//            } else if (eventName.contains("Vayeira")) {
//                wvDetails.loadUrl("file:///android_asset/Vayeira.html");
//            } else if (eventName.contains("Vayera") || eventName.contains("Vayeira")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
//            } else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
//                wvDetails.loadUrl("file:///android_asset/Vayeishev.html");
//            } else if (eventName.contains("Vayeitzei") || eventName.contains("Vayetzei")) {
//                wvDetails.loadUrl("file:///android_asset/Vayeitzei.html");
//            } else if (eventName.contains("Vayigash")) {
//                wvDetails.loadUrl("file:///android_asset/Vayigash.html");
//            } else if (eventName.contains("Vayikra")) {
//                wvDetails.loadUrl("file:///android_asset/Vayikra.html");
//            } else if (eventName.contains("Vayishlach")) {
//                wvDetails.loadUrl("file:///android_asset/Vayishlach.html");
//            } else if (eventName.contains("Parashat Re'eh") || eventName.contains("Re'eh")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
//            } else if (eventName.contains("Rosh Chodesh Adar")) {
//                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Adar_I.html");
//            } else if (eventName.contains("Rosh Chodesh Av")) {
//                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Av.html");
//            } else if (eventName.contains("Rosh Chodesh Elul")) {
//                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Elul.html");
//            } else if (eventName.contains("Rosh Chodesh Cheshvan") || (eventName.contains("Erev Rosh Hashanah Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Cheshvan.html");
//            } else if (eventName.contains("Asara B'Tevet")) {
//                wvDetails.loadUrl("file:///android_asset/Asara_B'Tevet.html");
//            } else if (eventName.contains("Aseret Y'mei T'shuva")) {
//                wvDetails.loadUrl("file:///android_asset/Aseret_Y'mei_T'shuva.html");
//            } else if (eventName.contains("B'dikat and Biur Chametz")) {
//                wvDetails.loadUrl("file:///android_asset/B'dikat_and_Biur_Chametz.html");
//            } else if (eventName.contains("Erev Chanukah")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_1_Weekday.html");
//            } else if (eventName.contains("Chanukah: 2 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_2_Weekday.html");
//            } else if (eventName.contains("Chanukah: 3 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_3_Weekday.html");
//            } else if (eventName.contains("Chanukah: 4 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_4_Weekday.html");
//            } else if (eventName.contains("Chanukah: 5 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_5_Weekday.html");
//            } else if (eventName.contains("Chanukah: 6 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_6_Weekday.html");
//            } else if (eventName.contains("Chanukah: 7 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_7_Weekday.html");
//            } else if (eventName.contains("Chanukah 8 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday_Rosh_Chodesh _Tevet_1.html");
//            } else if (eventName.contains("Chanukah: 8 Candles")) {
//                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday.html");
//            } else if (eventName.contains("Counting the Omer")) {
//                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
//            } else if (eventName.contains("Erev Chanukah")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Chanukah.html");
//            } else if (eventName.contains("Erev Pesach")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot.html");
//            } else if (eventName.contains("Erev Pesach/Ta'anit Bechorot Friday")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot_Friday.html");
//            } else if (eventName.contains("Erev Purim")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Purim.html");
//            } else if (eventName.contains("Erev Rosh Hashanah Friday")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Friday.html");
//            } else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Weekday.html");
//            } else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html");
//            } else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Simchat_Torah.html");
//            } else if (eventName.contains("Erev Shavuot Friday")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot_Friday.html");
//            } else if (eventName.contains("Erev Shavuot")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot.html");
//            } else if (eventName.contains("Erev Tisha b'Av")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Tisha_b'Av.html");
//            } else if (eventName.contains("Erev Yom Kippur Friday")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Yom_Kippur.html");
//            } else if (eventName.contains("Hoshana Raba")) {
//                wvDetails.loadUrl("file:///android_asset/Hoshana_Raba.html");
//            } else if (eventName.contains("Lag BaOmer")) {
//                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
//            } else if (eventName.contains("Leil Selichot")) {
//                wvDetails.loadUrl("file:///android_asset/Leil_Selichot.html");
//            } else if (eventName.contains("Machar Chodesh")) {
//                wvDetails.loadUrl("file:///android_asset/Machar_Chodesh.html");
//            } else if (eventName.contains("Pesach Chol Hamoed Day 2")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_3.html");
//            } else if (eventName.contains("Pesach Chol Hamoed Day 1")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_2.html");
//            } else if (eventName.contains("Pesach Chol Hamoed Day 3")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_4.html");
//            } else if (eventName.contains("Pesach I")) {
//
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_1.html");
//            } else if (eventName.contains("Pesach Chol Hamoed Day 4")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Friday.html");
//            } else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Weekday.html");
//            } else if (eventName.contains("Pesach_Day_1")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Shabbat.html");
//            } else if (eventName.contains("Pesach VIII")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Weekday.html");
//            } else if (eventName.contains("Pesach_Day_7")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7_Shabbat.html");
//            } else if (eventName.contains("Pesach VII")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7.html");
//            } else if (eventName.contains("Pesach Sheini")) {
//                wvDetails.loadUrl("file:///android_asset/Pesach_Sheini.html");
//            } else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan"))) {
//                wvDetails.loadUrl("file:///android_asset/Purim_Katan.html");
//            } else if (eventName.contains("Purim")) {
//                wvDetails.loadUrl("file:///android_asset/Purim.html");
//            } else if (eventName.contains("Rosh Hashana I")) {
//                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_1.html");
//            } else if (eventName.contains("Rosh Hashanah 2")) {
//                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_2.html");
//            } else if (eventName.contains("Sh'mini Atzeret-Simchat Torah")) {
//                wvDetails.loadUrl("file:///android_asset/Sh'mini_Atzeret-Simchat_Torah.html");
//            } else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot-K'doshim.html");
//            } else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot.html");
//            } else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'chukotai.html");
//            } else if ((eventName.contains("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'ha'alot'cha.html");
//            } else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har-B'chukotai.html");
//            } else if (eventName.contains("Shabbat B'har")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har.html");
//            } else if (eventName.contains("Shabbat B'reishit")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'reishit.html");
//            } else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_B'shalach-Shabbat_Shirah.html");
//            } else if (eventName.contains("Shabbat Balak")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Balak.html");
//            } else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Bamidbar.html");
//            } else if (eventName.contains("Shabbat Bo")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Bo.html");
//            } else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah_Rosh_Chodesh.html");
//            } else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah.html");
//            } else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chayei_Sara.html");
//            } else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_HaMoed_Pesach.html");
//            } else if (eventName.contains("Shabbat Chol Hamoed Sukkot")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_Hamoed_Sukkot_Friday.html");
//            } else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat-Balak.html");
//            } else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat.html");
//            } else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_D'varim-Shabbat_Chazon.html");
//            } else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Eikev.html");
//            } else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Emor.html");
//            } else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu-Shabbat_Shuva.html");
//            } else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu.html");
//            } else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_HaChodesh.html");
//            } else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_HaGadol.html");
//            } else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_K'doshim.html");
//            } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tavo.html");
//            } else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Teitze.html");
//            } else if (eventName.contains("Shabbat Ki Tisa")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tisa.html");
//            } else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Korach.html");
//            } else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Lech_L'cha.html");
//            } else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_M'tzora.html");
//            } else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_M'varchim.html");
//            } else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Mas'ei.html");
//            } else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot-Mas'ei.html");
//            } else if (eventName.contains("Shabbat Matot")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot.html");
//            } else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Mishpatim.html");
//            } else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim_Vayeilech.html");
//            } else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim.html");
//            } else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Naso.html");
//            } else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Noach.html");
//            } else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_P'kudei.html");
//            } else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Parah.html");
//            } else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Pinchas.html");
//            } else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
//            } else if ((eventName.contains("Shabbat Rosh Chodesh I")) || (eventName.contains("Rosh")) || (eventName.contains("Chodesh_I"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Rosh_Chodesh_I.html");
//            } else if (eventName.contains("Shabbat Sh'kalim")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'kalim.html");
//            } else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mini.html");
//            } else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mot.html");
//            } else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Shoftim.html");
//            } else if (eventName.contains("Shabbat Trumah")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_T'rumah.html");
//            } else if (eventName.contains("tzaveh")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_T'tzaveh.html");
//            } else if (eventName.contains("tzora")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria-M'tzora.html");
//            } else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria.html");
//            } else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Toldot.html");
//            } else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Tzav.html");
//            } else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_V'etchanan-Nachamu.html");
//            } else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Va'eira.html");
//            } else if (eventName.contains("habbat Vay'chi")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vay'chi.html");
//            } else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayakheil.html");
//            } else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeilech.html");
//            } else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
//            } else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeishev.html");
//            } else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeitzei.html");
//            } else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayigash.html");
//            } else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra"))) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayikra.html");
//            } else if (eventName.contains("Shabbat Vayishlach")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayishlach.html");
//            } else if (eventName.contains("Shabbat Yitro")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Yitro.html");
//            } else if (eventName.contains("Shabbat Zachor")) {
//                wvDetails.loadUrl("file:///android_asset/Shabbat_Zachor.html");
//            } else if (eventName.contains("Shavuot Shabbat")) {
//                wvDetails.loadUrl("file:///android_asset/Shavuot_Shabbat.html");
//            } else if (eventName.contains("Shavuot I")) {
//                wvDetails.loadUrl("file:///android_asset/Shavuot.html");
//            } else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz"))) {
//                wvDetails.loadUrl("file:///android_asset/Shiva_Asar_b'Tammuz.html");
//            } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim"))) {
//                wvDetails.loadUrl("file:///android_asset/Shushan_Purim.html");
//            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Shabbat"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Shabbat.html");
//            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
//            } else if ((eventName.contains("Sukkot_2")) || (eventName.contains("Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
//            } else if ((eventName.contains("Sukkot_3")) || (eventName.contains("Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
//            } else if (((eventName.contains("Sukkot_4")) || (eventName.contains("Weekday")))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
//            } else if ((eventName.contains("Sukkot_5")) || (eventName.contains("Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
//            } else if ((eventName.contains("Sukkot_6")) || (eventName.contains("Weekday"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
//            } else if ((eventName.contains("Sukkot")) || (eventName.contains("Preparation"))) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
//            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Bechorot"))) {
//                wvDetails.loadUrl("file:///android_asset/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html");
//            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Esther"))) {
//                wvDetails.loadUrl("file:///android_asset/Ta'anit_Esther.html");
//            } else if (eventName.contains("Tisha b'Av")) {
//                wvDetails.loadUrl("file:///android_asset/Tisha b'Av.html");
//            } else if (eventName.contains("Tisha B'Av")) {
//                wvDetails.loadUrl("file:///android_asset/Tisha_B'Av.html");
//            } else if (eventName.contains("Tu B'Av")) {
//                wvDetails.loadUrl("file:///android_asset/Tu_B'Av.html");
//            } else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat"))) {
//                wvDetails.loadUrl("file:///android_asset/Tu_B'Sh'vat.html");
//            } else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah"))) {
//                wvDetails.loadUrl("file:///android_asset/Tzom_Gedaliah.html");
//            } else if (eventName.contains("Yom Ha'atzma'ut")) {
//                wvDetails.loadUrl("file:///android_asset/Yom_Ha'atzma'ut.html");
//            } else if (eventName.contains("Yom HaShoah V'hag'vurah")) {
//                wvDetails.loadUrl("file:///android_asset/Yom_HaShoah_V'hag'vurah.html");
//            } else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
//                wvDetails.loadUrl("file:///android_asset/Yom_HaZikaron.html");
//            } else if (eventName.contains("Yom Kippur Shabbat")) {
//                wvDetails.loadUrl("file:///android_asset/Yom_Kippur_Shabbat.html");
//            } else if (eventName.contains("Yom Kippur")) {
//                wvDetails.loadUrl("file:///android_asset/Yom_Kippur.html");
//            } else if (eventName.contains("Yom Yerushalayim")) {
//                wvDetails.loadUrl("file:///android_asset/Yom_Yerushalayim.html");
//            } else if (eventName.contains("Erev Sukkot")) {
//                wvDetails.loadUrl("file:///android_asset/Erev_Sukkot.html");
//            } else if (eventName.contains("Sukkot I")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
//            } else if (eventName.contains("Sukkot 2 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
//            } else if (eventName.contains("Sukkot 3 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
//            } else if (eventName.contains("Sukkot 4 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
//            } else if (eventName.contains("Sukkot 5 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
//            } else if (eventName.contains("Sukkot 6 Weekday")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
//            } else if (eventName.contains("Hoshana Raba")) {
//                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
//            } else {
//                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html");
//            }
        }


                else if (eventType.contains("parashat")) {
                    if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                        url = htmlFileUrl + "Acharei_Mot.html";
                    } else if (eventName.contains("Parashat B'har/B'chukotai")) {
                        url = htmlFileUrl + "B'chukotai.html";
                    } else if (eventName.contains("Parashat B'haalot'cha")) {
                        url = htmlFileUrl + "B'haalot'cha.html";
                    } else if (eventName.contains("chukotai") || eventName.contains("har")) {
                        url = htmlFileUrl + "B'har-B'chukotai.html";
                    } else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                        url = htmlFileUrl + "B'har.html";
                    } else if (eventName.contains("Parashat B'midbar")) {
                        url = htmlFileUrl + "B'midbar.html";
                    } else if (eventName.contains("Parashat B'reishit")) {
                        url = htmlFileUrl + "B'reishit.html";
                    } else if (eventName.contains("Parashat B'shalach") || eventName.contains("B'shalach")) {
                        url = htmlFileUrl + "B'shalach.html";
                    } else if (eventName.contains("Balak")) {
                        url = htmlFileUrl + "Balak.html";
                    } else if (eventName.contains("Bo")) {
                        url = htmlFileUrl + "Bo.html";
                    } else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                        url = htmlFileUrl + "Chayei_Sara.html";
                    } else if (eventName.contains("Chukat-Balak")) {
                        url = htmlFileUrl + "Chukat-Balak.html";
                    } else if (eventName.contains("Chukat")) {
                        url = htmlFileUrl + "Chukat.html";
                    } else if (eventName.contains("Parashat D'varim") || eventType.contains("Devarim")) {
                        url = htmlFileUrl + "D'varim.html";
                    } else if (eventName.contains("Eikev")) {
                        url = htmlFileUrl + "Eikev.html";
                    } else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                        url = htmlFileUrl + "Emor.html";
                    } else if (eventName.contains("Parashat Ha'Azinu")) {
                        url = htmlFileUrl + "Haazinu.html";
                    } else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                        url = htmlFileUrl + "K'doshim.html";
                    } else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                        url = htmlFileUrl + "Ki_Tavo.html";
                    } else if (eventName.contains("Ki Teitzei") || eventName.contains("Teitzei")) {
                        url = htmlFileUrl + "Ki_Teitzei.html";
                    } else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                        url = htmlFileUrl + "Ki_Tisa.html";
                    } else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                        url = htmlFileUrl + "Korach.html";
                    } else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                        url = htmlFileUrl + "Lech_L'cha.html";
                    } else if (eventName.contains("Parashat Tazria/M'tzora")) {
                        url = htmlFileUrl + "M'tzora.html";
                    } else if (eventName.contains("Parashat Matot-Masei")) {
                        url = htmlFileUrl + "Matot-Mas-ei.html";
                    } else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                        url = htmlFileUrl + "Mas-ei.html";
                    } else if (eventName.contains("Matot")) {
                        url = htmlFileUrl + "Matot.html";
                    } else if (eventName.contains("Mikeitz-2")) {
                        url = htmlFileUrl + "Mikeitz-2.html";
                    } else if (eventName.contains("Mikeitz") || eventName.contains("Mikeitz")) {
                        url = htmlFileUrl + "Mikeitz.html";
                    } else if (eventName.contains("Mishpatim")) {
                        url = htmlFileUrl + "Mishpatim.html";
                    } else if (eventName.contains("Parashat Naso")) {
                        url = htmlFileUrl + "Naso.html";
                    } else if (eventName.contains("Nitzavim/Vayeilech")) {
                        url = htmlFileUrl + "Nitzavim-Vayeilech.html";
                    } else if (eventName.contains("Nitzavim")) {
                        url = htmlFileUrl + "Nitzavim.html";
                    } else if (eventName.contains("Parashat Noach")) {
                        url = htmlFileUrl + "Noach.html";
                    } else if (eventName.contains("Parashat Vayak’heil/P’kudei") || eventName.contains("Vayakhel-Pekudei")) {
                        url = htmlFileUrl + "P'kudei.html";
                    } else if (eventName.contains("Pinchas")) {
                        url = htmlFileUrl + "Pinchas.html";
                    } else if (eventName.contains("R'eih")) {
                        url = htmlFileUrl + "R'eih.html";
                    } else if (eventName.contains("Sh'lach L'cha")) {
                        url = htmlFileUrl + "Sh'lach_L'cha.html";
                    } else if (eventName.contains("Sh'mini")) {
                        url = htmlFileUrl + "Sh'mini.html";
                    } else if (eventName.contains("Sh'mot")) {
                        url = htmlFileUrl + "Sh'mot.html";
                    } else if (eventName.contains("Shof'tim")) {
                        url = htmlFileUrl + "Shof'tim.html";
                    } else if (eventName.contains("T'rumah")) {
                        url = htmlFileUrl + "T'rumah.html";
                    } else if (eventName.contains("T'tzaveh")) {
                        url = htmlFileUrl + "T'tzaveh.html";
                    } else if (eventName.contains("Tazria-M'tzora")) {
                        url = htmlFileUrl + "Tazria-M'tzora.html";
                    } else if (eventName.contains("Parashat Tazria-Metzora")) {
                        url = htmlFileUrl + "Tazria.html";
                    } else if (eventName.contains("Parashat Tazria")) {
                        url = htmlFileUrl + "Tazria-M'tzora.html";
                    } else if (eventName.contains("Tol'dot")) {
                        url = htmlFileUrl + "Tol'dot.html";
                    } else if (eventName.contains("Tzav")) {
                        url = htmlFileUrl + "Tzav.html";
                    } else if (eventName.contains("rachah")) {
                        url = htmlFileUrl + "V'zot_Hab'rachah.html";
                    } else if (eventName.contains("Va-eira")) {
                        url = htmlFileUrl + "Va-eira.html";
                    } else if (eventName.contains("Va-et'chanan")) {
                        url = htmlFileUrl + "Va-et'chanan.html";
                    } else if (eventName.contains("Va-y'chi")) {
                        url = htmlFileUrl + "Va-y'chi.html";
                    } else if (eventName.contains("Vayak'heil")) {
                        url = htmlFileUrl + "Vayak'heil.html";
                    } else if (eventName.contains("Vayak’heil-P’kudei")) {
                        url = htmlFileUrl + "Vayak’heil-P’kudei.html";
                    } else if (eventName.contains("Vayeilech")) {
                        url = htmlFileUrl + "Vayeilech.html";
                    } else if (eventName.contains("Vayeira")) {
                        url = htmlFileUrl + "Vayeira.html";
                    } else if (eventName.contains("Vayeira") || eventName.contains("Vayeira")) {
                        url = htmlFileUrl + "Shabbat_Vayeira.html";
                    } else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
                        url = htmlFileUrl + "Vayeishev.html";
                    } else if (eventName.contains("Vayeitzei") || eventName.contains("Vayeitzei")) {
                        url = htmlFileUrl + "Vayeitzei.html";
                    } else if (eventName.contains("Vayigash")) {
                        url = htmlFileUrl + "Vayigash.html";
                    } else if (eventName.contains("Vayikra")) {
                        url = htmlFileUrl + "Vayikra.html";
                    } else if (eventName.contains("Vayishlach")) {
                        url = htmlFileUrl + "Vayishlach.html";
                    } else if (eventName.contains("Parashat R'eih") || eventName.contains("Re'eh")) {
                        url = htmlFileUrl + "Shabbat_Re'eh.html";
                    } else {
                        url = htmlFileUrl + "Yitro.html";
                    }
                } else if (eventType.contains("holiday")) {

                    if (eventName.contains("Asara B'Tevet")) {
                        url = htmlFileUrl + "Asara_B'Tevet.html";
                    } else if (eventName.contains("Aseret Y'mei T'shuva")) {
                        url = htmlFileUrl + "Aseret_Y'mei_T'shuva.html";
                    } else if (eventName.contains("B'dikat and Biur Chametz")) {
                        url = htmlFileUrl + "B'dikat_and_Biur_Chametz.html";
                    } else if (eventName.contains("Erev Chanukah")) {
                        url = htmlFileUrl + "Chanukah_1_Weekday.html";
                    } else if (eventName.contains("Chanukah: 2 Candles")) {
                        url = htmlFileUrl + "Chanukah_2_Weekday.html";
                    } else if (eventName.contains("Chanukah: 3 Candles")) {
                        url = htmlFileUrl + "Chanukah_3_Weekday.html";
                    } else if (eventName.contains("Chanukah: 4 Candles")) {
                        url = htmlFileUrl + "Chanukah_4_Weekday.html";
                    } else if (eventName.contains("Chanukah: 5 Candles")) {
                        url = htmlFileUrl + "Chanukah_5_Weekday.html";
                    } else if (eventName.contains("Chanukah: 6 Candles")) {
                        url = htmlFileUrl + "Chanukah_6_Weekday.html";
                    } else if (eventName.contains("Chanukah: 7 Candles")) {
                        url = htmlFileUrl + "Chanukah_7_Weekday.html";
                    } else if (eventName.contains("Chanukah 8 Weekday")) {
                        url = htmlFileUrl + "Chanukah_8_Weekday_Rosh_Chodesh _Tevet_1.html";
                    } else if (eventName.contains("Chanukah: 8 Candles")) {
                        url = htmlFileUrl + "Chanukah_8_Weekday.html";
                    } else if (eventName.contains("Counting the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("Erev Chanukah")) {
                        url = htmlFileUrl + "Erev_Chanukah.html";
                    } else if (eventName.contains("Erev Pesach")) {
                        url = htmlFileUrl + "Erev_Pesach-Ta'anit_Bechorot.html";
                    } else if (eventName.contains("Erev Pesach/Ta'anit Bechorot Friday")) {
                        url = htmlFileUrl + "Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                    } else if (eventName.contains("Erev Purim")) {
                        url = htmlFileUrl + "Erev_Purim.html";
                    } else if (eventName.contains("Erev Rosh Hashanah Friday")) {
                        url = htmlFileUrl + "Erev_Rosh_Hashanah_Friday.html";
                    } else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday"))) {
                        url = htmlFileUrl + "Erev_Rosh_Hashanah_Weekday.html";
                    } else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah")) {
                        url = htmlFileUrl + "Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html";
                    } else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah")) {
                        url = htmlFileUrl + "Erev_Sh'mini_Atzeret-Simchat_Torah.html";
                    } else if (eventName.contains("Erev Shavuot Friday")) {
                        url = htmlFileUrl + "Erev_Shavuot_Friday.html";
                    } else if (eventName.contains("Erev Shavuot")) {
                        url = htmlFileUrl + "Erev_Shavuot.html";
                    } else if (eventName.contains("Erev Tisha b'Av")) {
                        url = htmlFileUrl + "Erev_Tisha_b'Av.html";
                    } else if (eventName.contains("Erev Yom Kippur Friday")) {
                        url = htmlFileUrl + "Erev_Yom_Kippur.html";
                    } else if (eventName.contains("Hoshana Raba")) {
                        url = htmlFileUrl + "Hoshana_Raba.html";
                    } else if (eventName.contains("Lag BaOmer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("Leil Selichot")) {
                        url = htmlFileUrl + "Leil_Selichot.html";
                    } else if (eventName.contains("Machar Chodesh")) {
                        url = htmlFileUrl + "Machar_Chodesh.html";
                    } else if (eventName.contains("Pesach Chol Hamoed Day 2")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_3.html";
                    } else if (eventName.contains("Pesach Chol Hamoed Day 1")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_2.html";
                    } else if (eventName.contains("Pesach Chol Hamoed Day 3")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_4.html";
                    } else if (eventName.contains("Pesach I")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_1.html";
                    } else if (eventName.contains("Pesach Chol Hamoed Day 4")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_5_Friday.html";
                    } else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday")) {
                        url = htmlFileUrl + "Pesach_Chol_Hamoed_Day_5_Weekday.html";
                    } else if (eventName.contains("Pesach_Day_1")) {
                        url = htmlFileUrl + "Pesach_Day_1_Shabbat.html";
                    } else if (eventName.contains("Pesach VIII")) {
                        url = htmlFileUrl + "Pesach_Day_1_Weekday.html";
                    } else if (eventName.contains("Pesach_Day_7")) {
                        url = htmlFileUrl + "Pesach_Day_7_Shabbat.html";
                    } else if (eventName.contains("Pesach VII")) {
                        url = htmlFileUrl + "Pesach_Day_7.html";
                    } else if (eventName.contains("Pesach Sheini")) {
                        url = htmlFileUrl + "Pesach_Sheini.html";
                    } else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan"))) {
                        url = htmlFileUrl + "Purim_Katan.html";
                    } else if (eventName.contains("Purim")) {
                        url = htmlFileUrl + "Purim.html";
                    } else if (eventName.contains("Rosh Hashana I")) {
                        url = htmlFileUrl + "Rosh_Hashanah_1.html";
                    } else if (eventName.contains("Rosh Hashanah 2")) {
                        url = htmlFileUrl + "Rosh_Hashanah_2.html";
                    } else if (eventName.contains("Sh'mini Atzeret-Simchat Torah")) {
                        url = htmlFileUrl + "Sh'mini_Atzeret-Simchat_Torah.html";
                    } else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim"))) {
                        url = htmlFileUrl + "Shabbat_Acharei_Mot-K'doshim.html";
                    } else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot"))) {
                        url = htmlFileUrl + "Shabbat_Acharei_Mot.html";
                    } else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai"))) {
                        url = htmlFileUrl + "Shabbat_B'chukotai.html";
                    } else if ((eventName.contains("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha"))) {
                        url = htmlFileUrl + "Shabbat_B'ha'alot'cha.html";
                    } else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
                        url = htmlFileUrl + "Shabbat_B'har-B'chukotai.html";
                    } else if (eventName.contains("Shabbat B'har")) {
                        url = htmlFileUrl + "Shabbat_B'har.html";
                    } else if (eventName.contains("Shabbat B'reishit")) {
                        url = htmlFileUrl + "Shabbat_B'reishit.html";
                    } else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah"))) {
                        url = htmlFileUrl + "Shabbat_B'shalach-Shabbat_Shirah.html";
                    } else if (eventName.contains("Shabbat Balak")) {
                        url = htmlFileUrl + "Shabbat_Balak.html";
                    } else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
                        url = htmlFileUrl + "Shabbat_Bamidbar.html";
                    } else if (eventName.contains("Shabbat Bo")) {
                        url = htmlFileUrl + "Shabbat_Bo.html";
                    } else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
                        url = htmlFileUrl + "Shabbat_Chanukah_Rosh_Chodesh.html";
                    } else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
                        url = htmlFileUrl + "Shabbat_Chanukah.html";
                    } else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
                        url = htmlFileUrl + "Shabbat_Chayei_Sara.html";
                    } else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach"))) {
                        url = htmlFileUrl + "Shabbat_Chol_HaMoed_Pesach.html";
                    } else if (eventName.contains("Shabbat Chol Hamoed Sukkot")) {
                        url = htmlFileUrl + "Shabbat_Chol_Hamoed_Sukkot_Friday.html";
                    } else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
                        url = htmlFileUrl + "Shabbat_Chukat-Balak.html";
                    } else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat"))) {
                        url = htmlFileUrl + "Shabbat_Chukat.html";
                    } else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon"))) {
                        url = htmlFileUrl + "Shabbat_D'varim-Shabbat_Chazon.html";
                    } else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
                        url = htmlFileUrl + "Shabbat_Eikev.html";
                    } else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor"))) {
                        url = htmlFileUrl + "Shabbat_Emor.html";
                    } else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu"))) {
                        url = htmlFileUrl + "Shabbat_Ha'azinu-Shabbat_Shuva.html";
                    } else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))) {
                        url = htmlFileUrl + "Shabbat_Ha'azinu.html";
                    } else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh"))) {
                        url = htmlFileUrl + "Shabbat_HaChodesh.html";
                    } else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol"))) {
                        url = htmlFileUrl + "Shabbat_HaGadol.html";
                    } else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim"))) {
                        url = htmlFileUrl + "Shabbat_K'doshim.html";
                    } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo"))) {
                        url = htmlFileUrl + "Shabbat_Ki_Tavo.html";
                    } else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze"))) {
                        url = htmlFileUrl + "Shabbat_Ki_Teitze.html";
                    } else if (eventName.contains("Shabbat Ki Tisa")) {
                        url = htmlFileUrl + "Shabbat_Ki_Tisa.html";
                    } else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach"))) {
                        url = htmlFileUrl + "Shabbat_Korach.html";
                    } else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha"))) {
                        url = htmlFileUrl + "Shabbat_Lech_L'cha.html";
                    } else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
                        url = htmlFileUrl + "Shabbat_M'tzora.html";
                    } else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim"))) {
                        url = htmlFileUrl + "Shabbat_M'varchim.html";
                    } else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei"))) {
                        url = htmlFileUrl + "Shabbat_Mas'ei.html";
                    } else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei"))) {
                        url = htmlFileUrl + "Shabbat_Matot-Mas'ei.html";
                    } else if (eventName.contains("Shabbat Matot")) {
                        url = htmlFileUrl + "Shabbat_Matot.html";
                    } else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
                        url = htmlFileUrl + "Shabbat_Mishpatim.html";
                    } else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech"))) {
                        url = htmlFileUrl + "Shabbat_N'tzavim_Vayeilech.html";
                    } else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim"))) {
                        url = htmlFileUrl + "Shabbat_N'tzavim.html";
                    } else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso"))) {
                        url = htmlFileUrl + "Shabbat_Naso.html";
                    } else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach"))) {
                        url = htmlFileUrl + "Shabbat_Noach.html";
                    } else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei"))) {
                        url = htmlFileUrl + "Shabbat_P'kudei.html";
                    } else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah"))) {
                        url = htmlFileUrl + "Shabbat_Parah.html";
                    } else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas"))) {
                        url = htmlFileUrl + "Shabbat_Pinchas.html";
                    } else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh"))) {
                        url = htmlFileUrl + "Shabbat_Re'eh.html";
                    } else if ((eventName.contains("Shabbat Rosh Chodesh I")) || (eventName.contains("Rosh")) || (eventName.contains("Chodesh_I"))) {
                        url = htmlFileUrl + "Shabbat_Rosh_Chodesh_I.html";
                    } else if (eventName.contains("Shabbat Sh'kalim")) {
                        url = htmlFileUrl + "Shabbat_Sh'kalim.html";
                    } else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini"))) {
                        url = htmlFileUrl + "Shabbat_Sh'mini.html";
                    } else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot"))) {
                        url = htmlFileUrl + "Shabbat_Sh'mot.html";
                    } else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim"))) {
                        url = htmlFileUrl + "Shabbat_Shoftim.html";
                    } else if (eventName.contains("Shabbat Trumah")) {
                        url = htmlFileUrl + "Shabbat_T'rumah.html";
                    } else if (eventName.contains("tzaveh")) {
                        url = htmlFileUrl + "Shabbat_T'tzaveh.html";
                    } else if (eventName.contains("tzora")) {
                        url = htmlFileUrl + "Shabbat_Tazria-M'tzora.html";
                    } else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria"))) {
                        url = htmlFileUrl + "Shabbat_Tazria.html";
                    } else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot"))) {
                        url = htmlFileUrl + "Shabbat_Toldot.html";
                    } else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav"))) {
                        url = htmlFileUrl + "Shabbat_Tzav.html";
                    } else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu"))) {
                        url = htmlFileUrl + "Shabbat_V'etchanan-Nachamu.html";
                    } else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira"))) {
                        url = htmlFileUrl + "Shabbat_Va'eira.html";
                    } else if (eventName.contains("habbat Vay'chi")) {
                        url = htmlFileUrl + "Shabbat_Vay'chi.html";
                    } else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil"))) {
                        url = htmlFileUrl + "Shabbat_Vayakheil.html";
                    } else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech"))) {
                        url = htmlFileUrl + "Shabbat_Vayeilech.html";
                    } else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira"))) {
                        url = htmlFileUrl + "Shabbat_Vayeira.html";
                    } else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev"))) {
                        url = htmlFileUrl + "Shabbat_Vayeishev.html";
                    } else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
                        url = htmlFileUrl + "Shabbat_Vayeitzei.html";
                    } else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash"))) {
                        url = htmlFileUrl + "Shabbat_Vayigash.html";
                    } else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra"))) {
                        url = htmlFileUrl + "Shabbat_Vayikra.html";
                    } else if (eventName.contains("Shabbat Vayishlach")) {
                        url = htmlFileUrl + "Shabbat_Vayishlach.html";
                    } else if (eventName.contains("Shabbat Yitro")) {
                        url = htmlFileUrl + "Shabbat_Yitro.html";
                    } else if (eventName.contains("Shabbat Zachor")) {
                        url = htmlFileUrl + "Shabbat_Zachor.html";
                    } else if (eventName.contains("Shavuot Shabbat")) {
                        url = htmlFileUrl + "Shavuot_Shabbat.html";
                    } else if (eventName.contains("Shavuot I")) {
                        url = htmlFileUrl + "Shavuot.html";
                    } else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz"))) {
                        url = htmlFileUrl + "Shiva_Asar_b'Tammuz.html";
                    } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim"))) {
                        url = htmlFileUrl + "Shushan_Purim.html";
                    } else if ((eventName.contains("Sukkot 1")) || (eventName.contains("Shabbat"))) {
                        url = htmlFileUrl + "Sukkot_1_Shabbat.html";
                    } else if ((eventName.contains("Sukkot 1"))) {
                        url = htmlFileUrl + "Sukkot_1_Weekday.html";
                    } else if ((eventName.contains("Sukkot_2"))) {
                        url = htmlFileUrl + "Sukkot_2_Weekday.html";
                    } else if ((eventName.contains("Sukkot_3"))) {
                        url = htmlFileUrl + "Sukkot_3_Weekday.html";
                    } else if (((eventName.contains("Sukkot_4")))) {
                        url = htmlFileUrl + "Sukkot_4_Weekday.html";
                    } else if ((eventName.contains("Sukkot_5"))) {
                        url = htmlFileUrl + "Sukkot_5_Weekday.html";
                    } else if ((eventName.contains("Sukkot_6"))) {
                        url = htmlFileUrl + "Sukkot_6_Weekday.html";
                    } else if ((eventName.contains("Preparation"))) {
                        url = htmlFileUrl + "Sukkot_Preparation.html";
                    } else if ((eventName.contains("Ta")) && (eventName.contains("anit_Bechorot"))) {
                        url = htmlFileUrl + "Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html";
                    } else if ((eventName.contains("Ta")) && (eventName.contains("anit_Esther"))) {
                        url = htmlFileUrl + "Ta'anit_Esther.html";
                    } else if (eventName.contains("Tisha b'Av")) {
                        url = htmlFileUrl + "Tisha b'Av.html";
                    } else if (eventName.contains("Tisha B'Av")) {
                        url = htmlFileUrl + "Tisha_B'Av.html";
                    } else if (eventName.contains("Tu B'Av")) {
                        url = htmlFileUrl + "Tu_B'Av.html";
                    } else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat"))) {
                        url = htmlFileUrl + "Tu_B'Sh'vat.html";
                    } else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah"))) {
                        url = htmlFileUrl + "Tzom_Gedaliah.html";
                    } else if (eventName.contains("Yom Ha'atzma'ut")) {
                        url = htmlFileUrl + "Yom_Ha'atzma'ut.html";
                    } else if (eventName.contains("Yom HaShoah V'hag'vurah")) {
                        url = htmlFileUrl + "Yom_HaShoah_V'hag'vurah.html";
                    } else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
                        url = htmlFileUrl + "Yom_HaZikaron.html";
                    } else if (eventName.contains("Yom Kippur Shabbat")) {
                        url = htmlFileUrl + "Yom_Kippur_Shabbat.html";
                    } else if (eventName.contains("Yom Kippur")) {
                        url = htmlFileUrl + "Yom_Kippur.html";
                    } else if (eventName.contains("Yom Yerushalayim")) {
                        url = htmlFileUrl + "Yom_Yerushalayim.html";
                    } else if (eventName.contains("Erev Sukkot")) {
                        url = htmlFileUrl + "Erev_Sukkot.html";
                    } else if (eventName.contains("Sukkot I")) {
                        url = htmlFileUrl + "Sukkot_1_Weekday.html";
                    } else if (eventName.contains("Sukkot 2 Weekday")) {
                        url = htmlFileUrl + "Sukkot_2_Weekday.html";
                    } else if (eventName.contains("Sukkot 3 Weekday")) {
                        url = htmlFileUrl + "Sukkot_3_Weekday.html";
                    } else if (eventName.contains("Sukkot 4 Weekday")) {
                        url = htmlFileUrl + "Sukkot_4_Weekday.html";
                    } else if (eventName.contains("Sukkot 5 Weekday")) {
                        url = htmlFileUrl + "Sukkot_5_Weekday.html";
                    } else if (eventName.contains("Sukkot 6 Weekday")) {
                        url = htmlFileUrl + "Sukkot_6_Weekday.html";
                    } else if (eventName.contains("Hoshana Raba")) {
                        url = htmlFileUrl + "Sukkot_Preparation.html";
                    } else if (eventName.contains("Yom")) {
                        url = htmlFileUrl + "Yom_Ha'atzma'ut.html";
                    } else if (eventName.contains("Sigd")) {
                        url = htmlFileUrl + "Asara_B'Tevet.html";
                    }
                }

                else if (eventType.contains("roshchodesh")) {
                    if (eventName.contains("Rosh Chodesh Adar")) {
                        url = htmlFileUrl + "Rosh_Chodesh_Adar_I.html";
                    } else if (eventName.contains("Rosh Chodesh Av")) {
                        url = htmlFileUrl + "Rosh_Chodesh_Av.html";
                    } else if (eventName.contains("Rosh Chodesh Elul")) {
                        url = htmlFileUrl + "Rosh_Chodesh_Elul.html";
                    } else if (eventName.contains("Rosh Chodesh Cheshvan") || (eventName.contains("Erev Rosh Hashanah Weekday"))) {
                        url = htmlFileUrl + "Rosh_Chodesh_Cheshvan.html";
                    } else {
                        url = htmlFileUrl + "Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html";
                    }
                } else if (eventType.contains("omer")) {
                    if (eventName.contains("15th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("15th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("16th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("17th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("18th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("19th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("20th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("21th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("22th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("23th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("24th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("25th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("26th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("27th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("28th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("29th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("30th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("31th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("32th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("34th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("35th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("36th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("37th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("38th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("39th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("40th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("41th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("42th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("43th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("44th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("45th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("46th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("47th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("48th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("49th day of the Omer")) {
                        url = htmlFileUrl + "Counting_the_Omer.html";
                    } else if (eventName.contains("33rd day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("14th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("1st day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("2nd day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("3rd day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("4th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("5th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("5th day of the Omer")) {
                        url = htmlFileUrl + "Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                    } else if (eventName.contains("6th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    }

//            else if (eventName.contains("6th day of the Omer") && eventDate.equals(friday)){
//                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot_Friday.html");
//            }
                    else if (eventName.contains("7th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("8th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("9th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("10th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("11th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("12th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    } else if (eventName.contains("13th day of the Omer")) {
                        url = htmlFileUrl + "Lag_Ba'Omer.html";
                    }



        }
            return url;

        }
    }



