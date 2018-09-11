package com.reformluach.utils;

public class FunctionSpellChange {
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
//        name = name.replace("Erev Rosh Hashana",  "Erev Rosh Hashanah Weekday");
        //name = name.replacingOccurrences(of: "Rosh Hashana", with: "Rosh Hashanah 1")
        //name = name.replacingOccurrences(of: "Rosh Hashana II", with: "Rosh Hashanah 2")
        name = name.replace( "Yom HaShoah",  "Yom HaShoah V'hag'vurah");
        name = name.replace( "Yom HaAtzma'ut",  "Yom Ha'atzma'ut");
        name = name.replace( "Lag BaOmer",  "Lag Ba'Omer");
        name = name.replace( "Shmini Atzeret",  "Sh'mini Atzeret/Simchat Torah");
        name = name.replace( "Sukkot II (CH''M)",  "Sukkot 2 Weekday");
        name = name.replace( "Sukkot II",  "Sukkot 2 Weekday");
        name = name.replace("Sukkot 2 WeekdayI (CH''M)","Sukkot 3 Weekday");
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
        name = name.replace("Chanukah: 1 Candle", "Chanukah: 1st Night");
        name = name.replace("Chanukah: 2 Candles",  "Chanukah: 2nd Night");
        name = name.replace("Chanukah: 3 Candles",  "Chanukah: 3rd Night");
        name = name.replace("Chanukah: 4 Candles",  "Chanukah: 4th Night");
        name = name.replace("Chanukah: 5 Candles",  "Chanukah: 5th Night");
        name = name.replace("Chanukah: 6 Candles",  "Chanukah: 6th Night");
        name = name.replace("Chanukah: 7 Candles",  "Chanukah: 7th Night");
        name = name.replace("Chanukah: 8 Candles",  "Chanukah: 8th Night");

        return name;
    }

}
