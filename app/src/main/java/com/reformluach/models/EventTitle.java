package com.reformluach.models;


import java.util.Calendar;

public  class EventTitle {

   public static String funcspellChangedForTitle(String name)  {
        //==============================     Parashat     ============================================
            name = name.replace("Parashat Bereshit", "Parashat B'reishit");
        name = name.replace( "Parashat Lech-Lecha",  "Parashat Lech L'cha");
        name = name.replace( "Parashat Vayera",  "Parashat Vayeira");
        name = name.replace( "Parashat Toldot",  "Parashat Tol'dot");
        name = name.replace( "Parashat Vayetzei",  "Parashat Vayeitzei");
        name = name.replace( "Parashat Vayeshev", "Parashat Vayeishev");
        name = name.replace( "Parashat Miketz",  "Parashat Mikeitz");
        name = name.replace( "Parashat Vayechi",  "Parashat Va-y'chi");
        name = name.replace( "Parashat Shemot", "Parashat Sh'mot");
        name = name.replace( "Parashat Vaera",  "Parashat Va-eira");
        name = name.replace( "Parashat Beshalach", "Parashat B'shalach");
        name = name.replace( "Parashat Terumah",  "Parashat T'rumah");
        name = name.replace( "Parashat Tetzaveh",  "Parashat T'tzaveh");
        name = name.replace( "Parashat Vayakhel",  "Parashat Vayak'heil");
        name = name.replace( "Parashat Pekudei",  "Parashat P'kudei");
        name = name.replace( "Parashat Shmini",  "Parashat Sh'mini");
        name = name.replace("Parashat Metzora",  "Parashat M'tzora");
        name = name.replace( "Parashat Achrei Mot",  "Parashat Acharei Mot");
        name = name.replace( "Parashat Kedoshim",  "Parashat K'doshim");
        name = name.replace( "Parashat Behar",  "Parashat B'har");
        name = name.replace( "Parashat Bechukotai",  "Parashat B'chukotai");
        name = name.replace( "Parashat Bamidbar",  "Parashat B'midbar");
        name = name.replace( "Parashat Nasso",  "Parashat Naso");
        name = name.replace( "Parashat Beha'alotcha", "Parashat B'haalot'cha");
        name = name.replace( "Parashat Sh'lach",  "Parashat Sh'lach L'cha");
        name = name.replace("Parashat Masei",  "Parashat Mas-ei");
        name = name.replace( "Parashat Devarim", "Parashat D'varim");
        name = name.replace( "Parashat Vaetchanan",  "Parashat Va-et'chanan");
        name = name.replace( "Parashat Re'eh",  "Parashat R'eih");
        name = name.replace( "Parashat Shoftim",  "Parashat Shof'tim");
        name = name.replace( "Parashat Ki Teitzei",  "Parashat Ki Teitzei");
        name = name.replace( "Parashat Ha'Azinu",  "Parashat Haazinu");
        name = name.replace( "Parashat Vezot Haberakhah",  "Parashat V'zot Hab'rachah");
        name = name.replace( "Parashat Vayakhel-Pekudei",  "Parashat Vayak’heil/P’kudei");
        name = name.replace( "Parashat Tazria-Metzora",  "Parashat Tazria/M'tzora");
        name = name.replace( "Parashat Achrei Mot-Kedoshim",  "Parashat Acharei Mot/K'doshim");
        name = name.replace( "Parashat Behar-Bechukotai",  "Parashat B'har/B'chukotai");
        name = name.replace( "Parashat Chukat-Balak", "Parashat Chukat/Balak");
        name = name.replace( "Parashat Matot-Masei",  "Parashat Matot/Mas-ei");
        name = name.replace( "Parashat Nitzavim-Vayeilech",  "Parashat Nitzavim/Vayeilech");
//        name = name.replace( "Erev Pesach",  "Erev Pesach/Ta’anit Bechorot");
        name = name.replace("Shabbat Shekalim",  "Shabbat Sh'kalim");
        name = name.replace( "Tu BiShvat", "Tu B'Sh'vat");
        name = name.replace( "Tzom Tammuz",  "Shiva Asar b'Tammuz");
        name = name.replace( "Tish'a B'Av", "Tisha B'Av");
        name = name.replace( "Erev Tisha B\'Av",  "Erev Tisha b'Av");
        name = name.replace("Erev Rosh Hashana",  "Erev Rosh Hashanah Weekday");
        //name = name.replacingOccurrences(of: "Rosh Hashana", with: "Rosh Hashanah 1")
        //name = name.replacingOccurrences(of: "Rosh Hashana II", with: "Rosh Hashanah 2")
        name = name.replace( "Yom HaShoah",  "Yom HaShoah V'hag'vurah");
        name = name.replace( "Yom HaAtzma'ut",  "Yom Ha'atzma'ut");
        name = name.replace( "Lag BaOmer",  "Lag Ba'Omer");
        name = name.replace( "Shmini Atzeret",  "Sh'mini Atzeret/Simchat Torah");
        name = name.replace( "Sukkot II (CH''M)",  "Sukkot 2 Weekday");
        name = name.replace( "Sukkot III (CH''M)",  "Sukkot 3 Weekday");
        name = name.replace( "Sukkot IV (CH''M)",  "Sukkot 4 Weekday");
        name = name.replace("Sukkot V (CH''M)",  "Sukkot 5 Weekday");
        name = name.replace( "Sukkot VI (CH''M)",  "Sukkot 6 Weekday");
        name = name.replace( "Sukkot VII (Hoshana Raba)",  "Hoshana Raba");
        name = name.replace("Pesach Sheni",  "Pesach Sheini");
        name = name.replace( "Pesach II (CH''M)",  "Pesach Chol Hamoed Day 1");
        name = name.replace( "Pesach III (CH''M)",  "Pesach Chol Hamoed Day 2");
        name = name.replace( "Pesach IV (CH''M)",  "Pesach Chol Hamoed Day 3");
        name = name.replace( "Pesach V (CH''M)",  "Pesach Chol Hamoed Day 4");
        name = name.replace( "Pesach VI (CH''M)", "Pesach Chol HaMoed Day 5 Weekday");
        name = name.replace("Chanukah: 1 Candle", "Erev Chanukah");
        name = name.replace("Chanukah: 2 Candles",  "Chanukah: 2nd Night");
        name = name.replace("Chanukah: 3 Candles",  "Chanukah: 3rd Night");
        name = name.replace("Chanukah: 4 Candles",  "Chanukah: 4th Night");
        name = name.replace("Chanukah: 5 Candles",  "Chanukah: 5th Night");
       name = name.replace("Chanukah: 6 Candles",  "Chanukah: 6th Night");
       name = name.replace("Chanukah: 7 Candles",  "Chanukah: 7th Night");
       name = name.replace("Chanukah: 8 Candles",  "Chanukah: 8th Night");

       return name;
    }


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
        } else if (title.contains("Parashat Vayakhel")){
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
        }

        else if (title.contains("Erev Pesach")){
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
        }

        else if (title.contains("Erev Rosh Hashana")){
            title=title.replace("Erev Rosh Hashana","Erev_Rosh_Hashanah_Weekday");
        }else if (title.contains("Rosh Hashana")){
            title=title.replace("Rosh Hashana","Rosh Hashanah 1");
        }else if (title.contains("Rosh Chodesh Tamuz")){
            title=title.replace("Rosh Chodesh Tamuz","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Hashana 5779")){
            title=title.replace("Rosh Hashana 5779","Rosh_Hashanah_1");
        }else if (title.contains("Rosh Hashana 5780")){
            title=title.replace("Rosh Hashana 5780","Rosh_Hashanah_1");
        } else if (title.contains("Rosh Chodesh Cheshvan")){
            title=title.replace("Rosh Chodesh Cheshvan","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Sh'\'vat")){
            title=title.replace("Rosh Chodesh Sh'\'vat","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Adar I")){
            title=title.replace("Rosh Chodesh Adar I","Rosh_Chodesh_Adar_I");
        }else if (title.contains("Rosh Chodesh Adar")){
            title=title.replace("Rosh Chodesh Adar","Rosh_Chodesh_Adar_I");
        }else if (title.contains("Rosh Chodesh Nisan")){
            title=title.replace("Rosh Chodesh Nisan","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Iyyar")){
            title=title.replace("Rosh Chodesh Iyyar","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Nisan")){
            title=title.replace("Rosh Chodesh Nisan","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Sivan")){
            title=title.replace("Rosh Chodesh Sivan","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Kislev")){
            title=title.replace("Rosh Chodesh Kislev","Rosh_Chodesh_I_Weekday");
        }else if (title.contains("Rosh Chodesh Tevet")) {
            title = title.replace("Rosh Chodesh Tevet", "Rosh_Chodesh_I_Weekday");
        } else if (title.contains("Rosh Hashana II")){
            title=title.replace("Rosh Hashana II","Rosh Hashanah 2");
        }

        else if (title.contains("Yom HaShoah")){
            title=title.replace("Yom HaShoah","Yom HaShoah V'hag'vurah");
        }else if (title.contains("Yom HaAtzma'ut")){
            title=title.replace("Yom HaAtzma'ut","Yom Ha'atzma'ut");
        }else if (title.contains("Yom HaAliyah")){
            title=title.replace("Yom HaAliyah","Yom_HaZikaron");
        }

        else if (title.contains("Lag BaOmer")){
            title=title.replace("Lag BaOmer","Lag Ba'Omer");
        }else if (title.contains("Shmini Atzeret")){
            title=title.replace("Shmini Atzeret","Sh'mini Atzeret/Simchat Torah");
        }else if (title.equals("Sukkot I")){
            title=title.replace("Sukkot I","Sukkot_1_Weekday");
        } else if (title.equals("Sukkot II (CH''M)")){
            title=title.replace("Sukkot II (CH''M)","Sukkot 2 Weekday");
        }else if (title.equals("Sukkot III (CH''M)")){
            title=title.replace("Sukkot III (CH''M)","Sukkot 3 Weekday");
        }else if (title.equals("Sukkot IV (CH''M)")){
            title=title.replace("Sukkot IV (CH''M)","Sukkot 4 Weekday");
        }else if (title.equals("Sukkot V (CH''M)")){
            title=title.replace("Sukkot V (CH''M)","Sukkot 5 Weekday");
        }
        else if (title.equals("Sukkot VI (CH''M)")){
            title=title.replace("Sukkot VI (CH''M)","Sukkot 6 Weekday");
        }else if (title.equals("Chol Hamoed Sukkot Shabbat")){
            title=title.replace("Chol Hamoed Sukkot Shabbat","Chol Hamoed Sukkot Shabbat");
        }
        else if (title.equals("Sukkot VII (Hoshana Raba)")){
            title=title.replace("Sukkot VII (Hoshana Raba)","Hoshana Raba");
        }

        else if (title.contains("Pesach Sheni")){
            title=title.replace("Pesach Sheni","Pesach Sheini");
        }else if (title.contains("Pesach II (CH''M)")){
            title=title.replace("Pesach II (CH''M)","Pesach Chol Hamoed Day 1");
        }else if (title.contains("Pesach III (CH''M)")){
            title=title.replace("Pesach III (CH''M)","Pesach Chol Hamoed Day 2");
        }else if (title.contains("Pesach IV (CH''M)")){
            title=title.replace("Pesach IV (CH''M)","Pesach Chol Hamoed Day 3");
        }else if (title.contains("Pesach V (CH''M)")){
            title=title.replace("Pesach V (CH''M)","Pesach Chol Hamoed Day 4");
        }else if (title.contains("Pesach VI (CH''M")){
            title=title.replace("Pesach VI (CH''M","Pesach Chol HaMoed Day 5 Weekday");
        }else if (title.contains("Pesach VII")){
            title=title.replace("Pesach VII","Pesach_Day_7");
        }else if (title.contains("Pesach I")){
            title=title.replace("Pesach I","Pesach Day 1 Weekday");
        }

//        else if (title.contains("Chanukah: 1 Candle")){
//            title=title.replace("Chanukah: 1 Candle","Erev Chanukah");
//        }else if (title.contains("Chanukah: 8th Day")) {
//            title = title.replace("Chanukah: 8th Day", "Chanukah 8 Weekday");
//        } else if (title.contains("Chanukah: 2 Candles")){
//            title=title.replace("Chanukah: 2 Candles","Chanukah_2_Weekday");
//        }else if (title.contains("Chanukah: 3 Candles")){
//            title=title.replace("Chanukah: 3 Candles","Chanukah_3_Weekday");
//        }else if (title.contains("Chanukah: 4 Candles")){
//            title=title.replace("Chanukah: 4 Candles","Chanukah_4_Weekday");
//        }else if (title.contains("Chanukah: 5 Candles")){
//            title=title.replace("Chanukah: 5 Candles","Chanukah_5_Weekday");
//        }else if (title.contains("Chanukah: 6 Candles")){
//            title=title.replace("Chanukah: 6 Candles","Chanukah_6_Weekday");
//        }else if (title.contains("Chanukah: 7 Candles")){
//            title=title.replace("Chanukah: 7 Candles","Chanukah_8_Weekday");
//        }else if (title.contains("Chanukah: 8 Candles")){
//            title=title.replace("Chanukah: 8 Candles","Chanukah_8_Weekday");
//        }

        else if (title.contains("Chanukah: 1 Candle")){
            title=title.replace("Chanukah: 1 Candle","Erev Chanukah");
        }else if (title.contains("Chanukah: 8 Weekday")) {
            title = title.replace("Chanukah 8 Weekday", "Chanukah: 8th Day");
        } else if (title.contains("Chanukah: 2 Candles")){
            title=title.replace("Chanukah: 2 Candles","Chanukah: 2nd Night");
        }else if (title.contains("Chanukah: 3 Candles")){
            title=title.replace("Chanukah: 3 Candles","Chanukah: 3rd Night");
        }else if (title.contains("Chanukah: 4 Candles")){
            title=title.replace("Chanukah: 4 Candles","Chanukah: 4th Night");
        }else if (title.contains("Chanukah: 5 Candles")){
            title=title.replace("Chanukah: 5 Candles","Chanukah: 5th Night");
        }else if (title.contains("Chanukah: 6 Candles")){
            title=title.replace("Chanukah: 6 Candles","Chanukah: 6th Night");
        }
        else if (title.contains("Chanukah: 7 Candles")){
            title=title.replace("Chanukah: 7 Candles","Chanukah: 7th Night");
        }else if (title.contains("Chanukah: 8 Candles")){
            title=title.replace("Chanukah: 8 Candles","Chanukah: 8th Night");
        }

        else if (title.contains("Shabbat Chazon")){
            title=title.replace("Shabbat Chazon","Shabbat_D'varim-Shabbat_Chazon");
        }else if (title.contains("Shabbat Nachamu")){
            title=title.replace("Shabbat Nachamu","Shabbat_V'etchanan-Nachamu");
        }
//        else if (title.contains("Shabbat Shuva")){
//            title=title.replace("Shabbat Shuva","Shabbat_Ha'azinu-Shabbat_Shuva");
//        }
        else if (title.contains("Shavuot I")){
            title=title.replace("Shavuot I","Shavuot");
        }

        else if (title.contains("Chukat-Balak")){
            title=title.replace("Chukat-Balak","Chukat/Balak");
        }else if (title.contains("Shmini Atzeret")){
            title=title.replace("Shmini Atzeret","Sh'mini Atzeret/Simchat Torah");
        }
        return title;
    }

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

    public static final String loadHtmlFile(String eventType,String eventName,String eventDate) {
        String url = null;


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

        if (eventType.contains("Todays")) {
            if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                url = htmlFileUrl + "OlderHtmlFile/Acharei_Mot.html";
            } else if (eventName.contains("Parashat Behar-Bechukotai")) {
                url = htmlFileUrl + "OlderHtmlFile/B'chukotai.html";
            } else if (eventName.contains("Parashat Beha'alotcha")) {
                url = htmlFileUrl + "OlderHtmlFile/B'haalot'cha.html";
            } else if (eventName.contains("chukotai") || eventName.contains("har")) {
                url = htmlFileUrl + "OlderHtmlFile/B'har-B'chukotai.html";
            } else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                url = htmlFileUrl + "OlderHtmlFile/B'har.html";
            } else if (eventName.contains("Parashat Bamidbar")) {
                url = htmlFileUrl + "OlderHtmlFile/B'midbar.html";
            } else if (eventName.contains("Parashat Bereshit")) {
                url = htmlFileUrl + "OlderHtmlFile/B'reishit.html";
            } else if (eventName.contains("Parashat Beshalach") || eventName.contains("Beshalach")) {
                url = htmlFileUrl + "OlderHtmlFile/B'shalach.html";
            } else if (eventName.contains("Balak")) {
                url = htmlFileUrl + "OlderHtmlFile/Balak.html";
            } else if (eventName.contains("Bo")) {
                url = htmlFileUrl + "OlderHtmlFile/Bo.html";
            } else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                url = htmlFileUrl + "OlderHtmlFile/Chayei_Sara.html";
            } else if (eventName.contains("Chukat-Balak")) {
                url = htmlFileUrl + "OlderHtmlFile/Chukat-Balak.html";
            } else if (eventName.contains("Chukat")) {
                url = htmlFileUrl + "OlderHtmlFile/Chukat.html";
            } else if (eventName.contains("Parashat Devarim") || eventType.contains("Devarim")) {
                url = htmlFileUrl + "OlderHtmlFile/D'varim.html";
            } else if (eventName.contains("Eikev")) {
                url = htmlFileUrl + "OlderHtmlFile/Eikev.html";
            } else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                url = htmlFileUrl + "OlderHtmlFile/Emor.html";
            } else if (eventName.contains("Parashat Ha'Azinu")) {
                url = htmlFileUrl + "OlderHtmlFile/Haazinu.html";
            } else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                url = htmlFileUrl + "OlderHtmlFile/K'doshim.html";
            } else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                url = htmlFileUrl + "OlderHtmlFile/Ki_Tavo.html";
            } else if (eventName.contains("Ki_Teitzei") || eventName.contains("Teitzei")) {
                url = htmlFileUrl + "OlderHtmlFile/Ki_Teitzei.html";
            } else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                url = htmlFileUrl + "OlderHtmlFile/Ki_Tisa.html";
            } else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                url = htmlFileUrl + "OlderHtmlFile/Korach.html";
            } else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                url = htmlFileUrl + "OlderHtmlFile/Lech_L'cha.html";
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                url = htmlFileUrl + "OlderHtmlFile/M'tzora.html";
            } else if (eventName.contains("Parashat Matot-Masei")) {
                url = htmlFileUrl + "OlderHtmlFile/Matot-Mas-ei.html";
            } else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                url = htmlFileUrl + "OlderHtmlFile/Mas-ei.html";
            } else if (eventName.contains("Matot")) {
                url = htmlFileUrl + "OlderHtmlFile/Matot.html";
            } else if (eventName.contains("Mikeitz-2")) {
                url = htmlFileUrl + "OlderHtmlFile/Mikeitz-2.html";
            } else if (eventName.contains("Mikeitz") || eventName.contains("Miketz")) {
                url = htmlFileUrl + "OlderHtmlFile/Mikeitz.html";
            } else if (eventName.contains("Mishpatim")) {
                url = htmlFileUrl + "OlderHtmlFile/Mishpatim.html";
            } else if (eventName.contains("Parashat Nasso")) {
                url = htmlFileUrl + "OlderHtmlFile/Naso.html";
            } else if (eventName.contains("Nitzavim-Vayeilech")) {
                url = htmlFileUrl + "OlderHtmlFile/Nitzavim-Vayeilech.html";
            } else if (eventName.contains("Nitzavim")) {
                url = htmlFileUrl + "OlderHtmlFile/Nitzavim.html";
            } else if (eventName.contains("Parashat Noach")) {
                url = htmlFileUrl + "OlderHtmlFile/Noach.html";
            } else if (eventName.contains("Parashat Vayakhel-Pekudei") || eventName.contains("Vayakhel-Pekudei")) {
                url = htmlFileUrl + "OlderHtmlFile/P'kudei.html";
            } else if (eventName.contains("Pinchas")) {
                url = htmlFileUrl + "OlderHtmlFile/Pinchas.html";
            }
            else if (eventName.contains("R'eih")) {
                url = htmlFileUrl+ "OlderHtmlFile/R'eih.html";
            } else if (eventName.contains("Sh'lach")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sh'lach_L'cha.html";
            } else if (eventName.contains("Shmini")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sh'mini.html";
            } else if (eventName.contains("Shemot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sh'mot.html";
            } else if (eventName.contains("Shoftim")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shof'tim.html";
            } else if (eventName.contains("Terumah")) {
                url = htmlFileUrl+ "OlderHtmlFile/T'rumah.html";
            } else if (eventName.contains("Tetzaveh")) {
                url = htmlFileUrl+ "OlderHtmlFile/T'tzaveh.html";
            } else if (eventName.contains("Tazria-M'tzora")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tazria-M'tzora.html";
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tazria.html";
            } else if (eventName.contains("Toldot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tol'dot.html";
            } else if (eventName.contains("Tzav")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tzav.html";
            } else if (eventName.contains("rachah")) {
                url = htmlFileUrl+ "OlderHtmlFile/V'zot_Hab'rachah.html";
            } else if (eventName.contains("Vaera")) {
                url = htmlFileUrl+ "OlderHtmlFile/Va-eira.html";
            } else if (eventName.contains("Vaetchanan")) {
                url = htmlFileUrl+ "OlderHtmlFile/Va-et'chanan.html";
            } else if (eventName.contains("Vayechi")) {
                url = htmlFileUrl+ "OlderHtmlFile/Va-y'chi.html";
            } else if (eventName.contains("Vayakhel")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayak'heil.html";
            } else if (eventName.contains("Vayak’heil-P’kudei")) {
                url = htmlFileUrl+"Vayak’heil-P’kudei.html";
            } else if (eventName.contains("Vayeilech")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayeilech.html";
            } else if (eventName.contains("Vayeira")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayeira.html";
            } else if (eventName.contains("Vayera") || eventName.contains("Vayeira")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayeira.html";
            } else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayeishev.html";
            } else if (eventName.contains("Vayeitzei") || eventName.contains("Vayetzei")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayeitzei.html";
            } else if (eventName.contains("Vayigash")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayigash.html";
            } else if (eventName.contains("Vayikra")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayikra.html";
            } else if (eventName.contains("Vayishlach")) {
                url = htmlFileUrl+ "OlderHtmlFile/Vayishlach.html";
            } else if (eventName.contains("Parashat Re'eh") || eventName.contains("Re'eh")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Re'eh.html";
            } else if (eventName.contains("Rosh Chodesh Adar")) {
                url = htmlFileUrl+ "OlderHtmlFile/Rosh_Chodesh_Adar_I.html";
            } else if (eventName.contains("Rosh Chodesh Av")) {
                url = htmlFileUrl+"Rosh Chodesh Av.html";
            } else if (eventName.contains("Rosh Chodesh Elul")) {
                url = htmlFileUrl+"Rosh Chodesh Elul.html";
            } else if (eventName.contains("Rosh Chodesh Cheshvan") || (eventName.contains("Erev Rosh Hashanah Weekday"))) {
                url = htmlFileUrl+"Rosh Chodesh Cheshvan.html";
            } else if (eventName.contains("Asara B'Tevet")) {
                url = htmlFileUrl+ "OlderHtmlFile/Asara_B'Tevet.html";
            } else if (eventName.contains("Aseret Y'mei T'shuva")) {
                url = htmlFileUrl+ "OlderHtmlFile/Aseret_Y'mei_T'shuva.html";
            } else if (eventName.contains("B'dikat and Biur Chametz")) {
                url = htmlFileUrl+ "OlderHtmlFile/B'dikat_and_Biur_Chametz.html";
            } else if (eventName.contains("Erev Chanukah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_1_Weekday.html";
            } else if (eventName.contains("Chanukah: 2 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_2_Weekday.html";
            } else if (eventName.contains("Chanukah: 3 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_3_Weekday.html";
            } else if (eventName.contains("Chanukah: 4 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_4_Weekday.html";
            } else if (eventName.contains("Chanukah: 5 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_5_Weekday.html";
            } else if (eventName.contains("Chanukah: 6 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_6_Weekday.html";
            } else if (eventName.contains("Chanukah: 7 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_7_Weekday.html";
            } else if (eventName.contains("Chanukah 8 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_8_Weekday_Rosh_Chodesh _Tevet_1.html";
            } else if (eventName.contains("Chanukah: 8 Candles")) {
                url = htmlFileUrl+ "OlderHtmlFile/Chanukah_8_Weekday.html";
            } else if (eventName.contains("Counting the Omer")) {
                url = htmlFileUrl+ "OlderHtmlFile/Counting_the_Omer.html";
            } else if (eventName.contains("Erev Chanukah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Chanukah.html";
            } else if (eventName.contains("Erev Pesach")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot.html";
            } else if (eventName.contains("Erev Pesach/Ta'anit Bechorot Friday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
            } else if (eventName.contains("Erev Purim")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Purim.html";
            } else if (eventName.contains("Erev Rosh Hashanah Friday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
            } else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Rosh_Hashanah_Weekday.html";
            } else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html";
            } else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Sh'mini_Atzeret-Simchat_Torah.html";
            } else if (eventName.contains("Erev Shavuot Friday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Shavuot_Friday.html";
            } else if (eventName.contains("Erev Shavuot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Shavuot.html";
            } else if (eventName.contains("Erev Tisha b'Av")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Tisha_b'Av.html";
            } else if (eventName.contains("Erev Yom Kippur Friday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Yom_Kippur.html";
            } else if (eventName.contains("Hoshana Raba")) {
                url = htmlFileUrl+ "OlderHtmlFile/Hoshana_Raba.html";
            } else if (eventName.contains("Lag BaOmer")) {
                url = htmlFileUrl+ "OlderHtmlFile/Lag_Ba'Omer.html";
            } else if (eventName.contains("Leil Selichot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Leil_Selichot.html";
            } else if (eventName.contains("Machar Chodesh")) {
                url = htmlFileUrl+ "OlderHtmlFile/Machar_Chodesh.html";
            }

         else if (eventName.contains("Pesach Chol Hamoed Day 2")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_3.html";
            } else if (eventName.contains("Pesach Chol Hamoed Day 1")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_2.html";
            } else if (eventName.contains("Pesach Chol Hamoed Day 3")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_4.html";
            } else if (eventName.contains("Pesach I")) {

                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_1.html";
            } else if (eventName.contains("Pesach Chol Hamoed Day 4")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Friday.html";
            } else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Chol_Hamoed_Day_5_Weekday.html";
            } else if (eventName.contains("Pesach_Day_1")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Day_1_Shabbat.html";
            } else if (eventName.contains("Pesach VIII")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Day_1_Weekday.html";
            } else if (eventName.contains("Pesach_Day_7")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
            } else if (eventName.contains("Pesach VII")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Day_7.html";
            } else if (eventName.contains("Pesach Sheini")) {
                url = htmlFileUrl+ "OlderHtmlFile/Pesach_Sheini.html";
            } else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Purim_Katan.html";
            } else if (eventName.contains("Purim")) {
                url = htmlFileUrl+ "OlderHtmlFile/Purim.html";
            }
            else if (eventName.contains("Rosh Hashana I")) {
                url = htmlFileUrl+ "OlderHtmlFile/Rosh_Hashanah_1.html";
            } else if (eventName.contains("Rosh Hashanah 2")) {
                url = htmlFileUrl+ "OlderHtmlFile/Rosh_Hashanah_2.html";
            } else if (eventName.contains("Sh'mini Atzeret-Simchat Torah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sh'mini_Atzeret-Simchat_Torah.html";
            } else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Acharei_Mot-K'doshim.html";
            } else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Acharei_Mot.html";
            } else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'chukotai.html";
            } else if ((eventName.contains("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'ha'alot'cha.html";
            } else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'har-B'chukotai.html";
            } else if (eventName.contains("Shabbat B'har")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'har.html";
            } else if (eventName.contains("Shabbat B'reishit")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'reishit.html";
            } else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_B'shalach-Shabbat_Shirah.html";
            } else if (eventName.contains("Shabbat Balak")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Balak.html";
            } else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Bamidbar.html";
            } else if (eventName.contains("Shabbat Bo")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Bo.html";
            } else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chanukah_Rosh_Chodesh.html";
            } else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chanukah.html";
            } else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chayei_Sara.html";
            } else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chol_HaMoed_Pesach.html";
            } else if (eventName.contains("Shabbat Chol Hamoed Sukkot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chol_Hamoed_Sukkot_Friday.html";
            } else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chukat-Balak.html";
            } else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Chukat.html";
            } else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
            } else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Eikev.html";
            } else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Emor.html";
            } else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Ha'azinu-Shabbat_Shuva.html";
            } else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Ha'azinu.html";
            } else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_HaChodesh.html";
            } else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_HaGadol.html";
            } else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_K'doshim.html";
            } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Ki_Tavo.html";
            } else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Ki_Teitze.html";
            } else if (eventName.contains("Shabbat Ki Tisa")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Ki_Tisa.html";
            } else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Korach.html";
            } else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Lech_L'cha.html";
            } else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_M'tzora.html";
            } else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_M'varchim.html";
            } else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Mas'ei.html";
            } else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Matot-Mas'ei.html";
            } else if (eventName.contains("Shabbat Matot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Matot.html";
            } else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Mishpatim.html";
            } else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_N'tzavim_Vayeilech.html";
            } else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_N'tzavim.html";
            } else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Naso.html";
            } else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Noach.html";
            } else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_P'kudei.html";
            } else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Parah.html";
            } else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Pinchas.html";
            } else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Re'eh.html";
            } else if ((eventName.contains("Shabbat Rosh Chodesh I")) || (eventName.contains("Rosh")) || (eventName.contains("Chodesh_I"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Rosh_Chodesh_I.html";
            } else if (eventName.contains("Shabbat Sh'kalim")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Sh'kalim.html";
            } else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Sh'mini.html";
            } else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Sh'mot.html";
            } else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Shoftim.html";
            } else if (eventName.contains("Shabbat Trumah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_T'rumah.html";
            } else if (eventName.contains("tzaveh")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_T'tzaveh.html";
            } else if (eventName.contains("tzora")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Tazria-M'tzora.html";
            } else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Tazria.html";
            } else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Toldot.html";
            } else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Tzav.html";
            } else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_V'etchanan-Nachamu.html";
            } else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Va'eira.html";
            } else if (eventName.contains("habbat Vay'chi")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vay'chi.html";
            } else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayakheil.html";
            } else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayeilech.html";
            } else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayeira.html";
            } else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayeishev.html";
            } else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayeitzei.html";
            } else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayigash.html";
            } else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayikra.html";
            } else if (eventName.contains("Shabbat Vayishlach")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Vayishlach.html";
            } else if (eventName.contains("Shabbat Yitro")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Yitro.html";
            } else if (eventName.contains("Shabbat Zachor")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shabbat_Zachor.html";
            } else if (eventName.contains("Shavuot Shabbat")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shavuot_Shabbat.html";
            } else if (eventName.contains("Shavuot I")) {
                url = htmlFileUrl+ "OlderHtmlFile/Shavuot.html";
            } else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shiva_Asar_b'Tammuz.html";
            } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Shushan_Purim.html";
            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Shabbat"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_1_Shabbat.html";
            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_1_Weekday.html";
            } else if ((eventName.contains("Sukkot_2")) || (eventName.contains("Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_2_Weekday.html";
            } else if ((eventName.contains("Sukkot_3")) || (eventName.contains("Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_3_Weekday.html";
            } else if (((eventName.contains("Sukkot_4")) || (eventName.contains("Weekday")))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_4_Weekday.html";
            } else if ((eventName.contains("Sukkot_5")) || (eventName.contains("Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_5_Weekday.html";
            } else if ((eventName.contains("Sukkot_6")) || (eventName.contains("Weekday"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_6_Weekday.html";
            } else if ((eventName.contains("Sukkot")) || (eventName.contains("Preparation"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_Preparation.html";
            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Bechorot"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html";
            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Esther"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Ta'anit_Esther.html";
            } else if (eventName.contains("Tisha b'Av")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tisha b'Av.html";
            } else if (eventName.contains("Tisha B'Av")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tisha_B'Av.html";
            } else if (eventName.contains("Tu B'Av")) {
                url = htmlFileUrl+ "OlderHtmlFile/Tu_B'Av.html";
            } else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Tu_B'Sh'vat.html";
            } else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Tzom_Gedaliah.html";
            } else if (eventName.contains("Yom Ha'atzma'ut")) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_Ha'atzma'ut.html";
            } else if (eventName.contains("Yom HaShoah V'hag'vurah")) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_HaShoah_V'hag'vurah.html";
            } else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_HaZikaron.html";
            } else if (eventName.contains("Yom Kippur Shabbat")) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_Kippur_Shabbat.html";
            } else if (eventName.contains("Yom Kippur")) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_Kippur.html";
            } else if (eventName.contains("Yom Yerushalayim")) {
                url = htmlFileUrl+ "OlderHtmlFile/Yom_Yerushalayim.html";
            } else if (eventName.contains("Erev Sukkot")) {
                url = htmlFileUrl+ "OlderHtmlFile/Erev_Sukkot.html";
            } else if (eventName.contains("Sukkot I")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_1_Weekday.html";
            } else if (eventName.contains("Sukkot 2 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_2_Weekday.html";
            } else if (eventName.contains("Sukkot 3 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_3_Weekday.html";
            } else if (eventName.contains("Sukkot 4 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_4_Weekday.html";
            } else if (eventName.contains("Sukkot 5 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_5_Weekday.html";
            } else if (eventName.contains("Sukkot 6 Weekday")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_6_Weekday.html";
            } else if (eventName.contains("Hoshana Raba")) {
                url = htmlFileUrl+ "OlderHtmlFile/Sukkot_Preparation.html";
            }
//            else {
//                url = htmlFileUrl+ "OlderHtmlFile/Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html";
//            }
        }


        else if (eventType.contains("parashat")) {
               if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                url = htmlFileUrl + "OlderHtmlFile/Acharei_Mot.html";
                }
                else if (eventName.contains("Parashat Yitro")) {
                url = htmlFileUrl + "OlderHtmlFile/Yitro.html";
                }
                    else if (eventName.contains("Parashat B'har/B'chukotai")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'chukotai.html";
                    }
                    else if (eventName.contains("Parashat B'haalot'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'haalot'cha.html";
                    }
                    else if (eventName.contains("chukotai") || eventName.contains("har")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'har-B'chukotai.html";
                    }
                    else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'har.html";
                    }
                    else if (eventName.contains("Parashat B'midbar")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'midbar.html";
                    }
                    else if (eventName.contains("Parashat B'reishit")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'reishit.html";
                    }
                    else if (eventName.contains("Parashat B'shalach") || eventName.contains("B'shalach")) {
                        url = htmlFileUrl + "OlderHtmlFile/B'shalach.html";
                    }
                    else if (eventName.contains("Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Balak.html";
                    }
                    else if (eventName.contains("Bo")) {
                        url = htmlFileUrl + "OlderHtmlFile/Bo.html";
                    }
                    else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Chayei_Sara.html";
                    }
                    else if (eventName.contains("Chukat-Balak")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chukat-Balak.html";
                    }
                    else if (eventName.contains("Chukat")) {
                        url = htmlFileUrl + "OlderHtmlFile/Chukat.html";
                    }
                    else if (eventName.contains("Parashat D'varim") || eventType.contains("Devarim")) {
                        url = htmlFileUrl + "OlderHtmlFile/D'varim.html";
                    }
                    else if (eventName.contains("Eikev")) {
                        url = htmlFileUrl + "OlderHtmlFile/Eikev.html";
                    }
                    else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                        url = htmlFileUrl + "OlderHtmlFile/Emor.html";
                    }
                    else if (eventName.contains("Parashat Haazinu")) {
                        url = htmlFileUrl + "OlderHtmlFile/Haazinu.html";
                    }
                    else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                        url = htmlFileUrl + "OlderHtmlFile/K'doshim.html";
                    }
                    else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Tavo.html";
                    }
                    else if (eventName.contains("Ki Teitzei") || eventName.contains("Teitzei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Teitzei.html";
                    }
                    else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                        url = htmlFileUrl + "OlderHtmlFile/Ki_Tisa.html";
                    }
                    else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Korach.html";
                    }
                    else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Lech_L'cha.html";
                    }
                    else if (eventName.contains("Parashat Tazria/M'tzora")) {
                        url = htmlFileUrl + "OlderHtmlFile/M'tzora.html";
                    }
                    else if (eventName.contains("Parashat Matot-Masei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Matot-Mas-ei.html";
                    }
                    else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mas-ei.html";
                    }
                    else if (eventName.contains("Matot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Matot.html";
                    }
                    else if (eventName.contains("Mikeitz-2")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mikeitz-2.html";
                    }
                    else if (eventName.contains("Mikeitz") || eventName.contains("Mikeitz")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mikeitz.html";
                    }
                    else if (eventName.contains("Mishpatim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Mishpatim.html";
                    }
                    else if (eventName.contains("Parashat Naso")) {
                        url = htmlFileUrl + "OlderHtmlFile/Naso.html";
                    }
                    else if (eventName.contains("Nitzavim/Vayeilech")) {
                        url = htmlFileUrl + "OlderHtmlFile/Nitzavim-Vayeilech.html";
                    }
                    else if (eventName.contains("Nitzavim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Nitzavim.html";
                    }
                    else if (eventName.contains("Parashat Noach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Noach.html";
                    }
                    else if (eventName.contains("Parashat Vayak'heil-Pekudei") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayakheil-P'kudei.html";
                    }
                    else if (eventName.contains("Pinchas")) {
                        url = htmlFileUrl + "OlderHtmlFile/Pinchas.html";
                    }
                    else if (eventName.contains("R'eih")) {
                        url = htmlFileUrl + "OlderHtmlFile/R'eih.html";
                    }
                    else if (eventName.contains("Sh'lach L'cha")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'lach_L'cha.html";
                    }
                    else if (eventName.contains("Sh'mini")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini.html";
                    }
                    else if (eventName.contains("Sh'mot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mot.html";
                    }
                    else if (eventName.contains("Shof'tim")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shof'tim.html";
                    }
                    else if (eventName.contains("T'rumah")) {
                        url = htmlFileUrl + "OlderHtmlFile/T'rumah.html";
                    }
                    else if (eventName.contains("T'tzaveh")) {
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
                    else if (eventName.contains("Tol'dot")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tol'dot.html";
                    }

                    else if (eventName.contains("Tzav")) {
                        url = htmlFileUrl + "OlderHtmlFile/Tzav.html";
                    }
                    else if (eventName.contains("rachah")) {
                        url = htmlFileUrl + "OlderHtmlFile/V'zot_Hab'rachah.html";
                    }
                    else if (eventName.contains("Va-eira")) {
                        url = htmlFileUrl + "OlderHtmlFile/Va-eira.html";
                    }
                    else if (eventName.contains("Va-et'chanan")) {
                        url = htmlFileUrl + "OlderHtmlFile/Va-et'chanan.html";
                    }
                    else if (eventName.contains("Va-y'chi")) {
                        url = htmlFileUrl + "OlderHtmlFile/Va-y'chi.html";
                    }
                    else if (eventName.equals("Vayak'heil")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayak'heil.html";
                    }

                    else if (eventName.contains("Vayeilech")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeilech.html";
                    }
                    else if (eventName.contains("Vayeira")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeira.html";
                    }
                    else if (eventName.contains("Vayeira") || eventName.contains("Vayeira")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeira.html";
                    }
                    else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeishev.html";
                    }
                    else if (eventName.contains("Vayeitzei") || eventName.contains("Vayeitzei")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayeitzei.html";
                    }
                    else if (eventName.contains("Vayigash")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayigash.html";
                    }
                    else if (eventName.contains("Vayikra")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayikra.html";
                    }
                    else if (eventName.contains("Vayishlach")) {
                        url = htmlFileUrl + "OlderHtmlFile/Vayishlach.html";
                    }
                    else if (eventName.contains("Parashat R'eih") || eventName.contains("Re'eh")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Re'eh.html";
                    }
//                    else {
//                        url = htmlFileUrl + "OlderHtmlFile/Yitro.html";
//                    }
                }


                else if (eventType.contains("holiday")) {

                  if (eventName.contains("Erev Pesach/Ta’anit Bechorot") && (days==6)) {
                  url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                  }
                   else if (eventName.contains("Asara B'Tevet") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Asara_B'Tevet.html";
                    }
                    else if (eventName.contains("Aseret Y'mei T'shuva") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Aseret_Y'mei_T'shuva.html";
                    }
                    else if (eventName.contains("B'dikat and Biur Chametz") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/B'dikat_and_Biur_Chametz.html";
                    }
                    else if (eventName.contains("Erev Chanukah") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_1_Weekday.html";
                    }

                    else if (eventName.equals("Rosh Hashana 5779")){
                      url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_1.html";
                    }
                  else if (eventName.equals("Rosh Hashana II")){
                      url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
                  }

                    else if (eventName.contains("Chanukah: 2 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_2nd_Night.html";
                    } else if (eventName.contains("Chanukah: 2 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 3 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_3rd_Night.html";
                    }else if (eventName.contains("Chanukah: 3 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 4 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_4th_Night.html";
                    } else if (eventName.contains("Chanukah: 4 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 5 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_5th_Night.html";
                    }else if (eventName.contains("Chanukah: 5 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
                    else if (eventName.contains("Chanukah: 6 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_6th_Night.html";
                    }else if (eventName.contains("Chanukah: 6 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
                    else if (eventName.contains("Chanukah: 7 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_7th_Night.html";
                    }else if (eventName.contains("Chanukah: 7 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
                    else if (eventName.contains("Chanukah: 8 Candles") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_8th_Night.html";
                    } else if (eventName.contains("Chanukah: 8 Candles") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                    else if (eventName.contains("Chanukah: 8 Weekday") && !(days==7)) {
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
//                    else if (eventName.contains("Erev Rosh Hashanah Friday") && !(days==6)) {
//                        url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
//                    }
                    else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Weekday.html";
                    }
                    else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
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

                    else if (eventName.contains("Erev Shavuot Friday") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Shavuot_Friday.html";
                    }
                    else if (eventName.contains("Erev Shavuot") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Shavuot.html";
                    }
                    else if (eventName.contains("Erev Tisha b'Av") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Tisha_b'Av.html";
                    }
                    else if (eventName.contains("Erev Yom Kippur Friday") && !(days==6)) {
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

                    else if (eventName.contains("Pesach_Day_7") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
                    } else if (eventName.contains("Pesach_Day_7") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7.html";
                    }

                    else if (eventName.contains("Pesach VII") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7.html";
                    }else if (eventName.contains("Pesach VII") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Day_7_Shabbat.html";
                    }

                    else if (eventName.contains("Rosh Hashana II") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
                    }

                    else if (eventName.contains("Pesach Sheini") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Pesach_Sheini.html";
                    }
                    else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan")) && (days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Purim_Katan.html";
                    }
                    else if (eventName.contains("Purim") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Purim.html";
                    }
                    else if (eventName.contains("Rosh Hashana I") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_1.html";
                    }
                    else if (eventName.contains("Rosh Hashanah 2") && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Hashanah_2.html";
                    }

                    // Saturday
                    else if (eventName.contains("Sh'mini Atzeret/Simchat Torah") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Sh'mini_Atzeret-Simchat_Torah.html";
                    }
                    else if (eventName.contains("Sh'mini Atzeret/Simchat Torah") && (days==7)) {
                        url = htmlFileUrl + "Sh'mini_Atzeret-Simchat_Torah_Shabbat.html";
                    }
                    else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot-K'doshim.html";
                    }
                    else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Acharei_Mot.html";
                    }
                    else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai")) && !(days==6)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'chukotai.html";
                    }
//                    else if ((eventName.equals("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha")) ) {
//                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'ha'alot'cha.html";
//                    }

                    else if (eventName.contains("Chanukah 2nd Night") && !(days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Chanukah_2nd_Night.html";
                    }else if (eventName.contains("Chanukah 2nd Night") && (days==7)) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }

                   else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'har-B'chukotai.html";
                    }
                    else if (eventName.contains("Shabbat B'har")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'har.html";
                    }
                    else if (eventName.contains("Shabbat B'reishit")) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_B'reishit.html";
                    }
                    else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah")) && !(days==6)) {
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
                    else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chanukah.html";
                    }
                    else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chayei_Sara.html";
                    }
                    else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chol_HaMoed_Pesach.html";
                    }
                    else if (eventName.contains("Shabbat Chol Hamoed Sukkot") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chol_Hamoed_Sukkot_Friday.html";
                    }
                    else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chukat-Balak.html";
                    }
                    else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Chukat.html";
                    }
                    else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_D'varim-Shabbat_Chazon.html";
                    }
                    else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Eikev.html";
                    }
                    else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Emor.html";
                    }
                    else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ha'azinu-Shabbat_Shuva.html";
                    }
                    else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))  ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Ha'azinu.html";
                    }
                    else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_HaChodesh.html";
                    }
                    else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_HaGadol.html";
                    }
                    else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_K'doshim.html";
                    } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo")) ) {
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
                    else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_P'kudei.html";
                    }
                    else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah")) ) {
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
                    else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Shoftim.html";
                    }
                    else if (eventName.contains("Shabbat Trumah") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_T'rumah.html";
                    }
                    else if (eventName.contains("tzaveh") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_T'tzaveh.html";
                    }
                    else if (eventName.contains("tzora") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tazria-M'tzora.html";
                    }
                    else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tazria.html";
                    }
                    else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Toldot.html";
                    }
                    else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Tzav.html";
                    }
                    else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu")) ) {
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
                    else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeilech.html";
                    }
                    else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeira.html";
                    }
                    else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeishev.html";
                    }
                    else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayeitzei.html";
                    }
                    else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayigash.html";
                    }
                    else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra")) ) {
                        url = htmlFileUrl + "OlderHtmlFile/Shabbat_Vayikra.html";
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
                    }else if (eventName.contains("Sukkot 5 Weekday") && (days==7)) {
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
//                    else if (eventName.contains("Sigd") && !(days==6)) {
//                        url = htmlFileUrl + "OlderHtmlFile/Asara_B'Tevet.html";
//                    }


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
                  else if (eventName.equals("Erev Rosh Hashanah Weekday") && (days==6)) {
                      url = htmlFileUrl + "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
                  }
        }

        else if (eventType.contains("roshchodesh")) {
             if (eventName.equals("Rosh Chodesh Tamuz")){
                url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }else if (eventName.equals("Rosh Chodesh Cheshvan")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.equals("Rosh Chodesh Sh'vat")){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_I_Weekday.html";
             }
             else if (eventName.contains("Rosh_Chodesh_Adar_I") ){
                 url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_Adar_I.html";
             }
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
                    else if (eventName.contains("Rosh Chodesh Adar") ) {
                        url = htmlFileUrl + "OlderHtmlFile/Erev_Pesach-Ta'anit_Bechorot_Friday.html";
                    } else if (eventName.contains("Erev Rosh Hashanah Weekday") && (days==6)){
                        url = htmlFileUrl+ "OlderHtmlFile/Erev_Rosh_Hashanah_Friday.html";
                    }

//                   else {
//                        url = htmlFileUrl + "OlderHtmlFile/Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html";
//                    }
        }
            // ----- Omer --------------------------------------
                    else if (eventType.contains("omer")) {
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
        }
        return url;

        }

//        public String getFridayLogic(String event){
//            String url = null;
//
//            if (event.equals("")){
//                url = htmlFileUrl + "Lag_Ba'Omer.html";
//            }
//            return url;
//        }

    }



