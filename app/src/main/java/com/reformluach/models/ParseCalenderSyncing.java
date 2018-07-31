package com.reformluach.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParseCalenderSyncing {

    /**
     * date : 2018-07-30T04:15:44-00:00
     * location : {"geo":"none"}
     * items : [{"leyning":{"torah":"Exodus 1:1 - 6:1","6":"Exodus 4:18 - 4:31","3":"Exodus 2:11 - 2:25","1":"Exodus 1:1 - 1:17","5":"Exodus 3:16 - 4:17","2":"Exodus 1:18 - 2:10","4":"Exodus 3:1 - 3:15","maftir":"Exodus 5:22 - 6:1","haftarah":"Isaiah 27:6 - 28:13; 29:22 - 29:23","7":"Exodus 5:1 - 6:1"},"hebrew":"פרשת שמות","date":"2018-01-06","category":"parashat","link":"https://www.hebcal.com/sedrot/shemot","title":"Parashat Shemot"},{"date":"2018-01-13","leyning":{"torah":"Exodus 6:2 - 9:35","6":"Exodus 8:19 - 9:16","3":"Exodus 6:29 - 7:7","1":"Exodus 6:2 - 6:13","5":"Exodus 8:7 - 8:18","4":"Exodus 7:8 - 8:6","haftarah":"Ezekiel 28:25 - 29:21","2":"Exodus 6:14 - 6:28","maftir":"Exodus 9:33 - 9:35","7":"Exodus 9:17 - 9:35"},"hebrew":"פרשת וארא","title":"Parashat Vaera","link":"https://www.hebcal.com/sedrot/vaera","category":"parashat"},{"category":"roshchodesh","link":"https://www.hebcal.com/holidays/rosh-chodesh-shvat","title":"Rosh Chodesh Sh'vat","hebrew":"ראש חודש שבט","memo":"Beginning of new Hebrew month of Sh'vat","date":"2018-01-17"},{"date":"2018-01-20","leyning":{"haftarah":"Jeremiah 46:13 - 46:28","maftir":"Exodus 13:14 - 13:16","4":"Exodus 11:4 - 12:20","2":"Exodus 10:12 - 10:23","7":"Exodus 13:1 - 13:16","3":"Exodus 10:24 - 11:3","torah":"Exodus 10:1 - 13:16","6":"Exodus 12:29 - 12:51","5":"Exodus 12:21 - 12:28","1":"Exodus 10:1 - 10:11"},"hebrew":"פרשת בא","link":"https://www.hebcal.com/sedrot/bo","title":"Parashat Bo","category":"parashat"},{"title":"Parashat Beshalach","link":"https://www.hebcal.com/sedrot/beshalach","category":"parashat","date":"2018-01-27","leyning":{"5":"Exodus 15:27 - 16:10","1":"Exodus 13:17 - 14:8","3":"Exodus 14:15 - 14:25","6":"Exodus 16:11 - 16:36","torah":"Exodus 13:17 - 17:16","7":"Exodus 17:1 - 17:16","2":"Exodus 14:9 - 14:14","4":"Exodus 14:26 - 15:26","maftir":"Exodus 17:14 - 17:16","haftarah":"Judges 4:4 - 5:31"},"hebrew":"פרשת בשלח"},{"title":"Tu BiShvat","link":"https://www.hebcal.com/holidays/tu-bishvat","subcat":"minor","category":"holiday","memo":"New Year for Trees","date":"2018-01-31","hebrew":"טו בשבט"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/yitro","title":"Parashat Yitro","leyning":{"maftir":"Exodus 20:19 - 20:23","4":"Exodus 19:1 - 19:6","haftarah":"Isaiah 6:1 - 7:6; 9:5 - 9:6","2":"Exodus 18:13 - 18:23","7":"Exodus 20:15 - 20:23","6":"Exodus 19:20 - 20:14","torah":"Exodus 18:1 - 20:23","3":"Exodus 18:24 - 18:27","1":"Exodus 18:1 - 18:12","5":"Exodus 19:7 - 19:19"},"hebrew":"פרשת יתרו","date":"2018-02-03"},{"date":"2018-02-10","leyning":{"5":"Exodus 23:6 - 23:19","1":"Exodus 21:1 - 21:19","3":"Exodus 22:4 - 22:26","torah":"Exodus 21:1 - 24:18","6":"Exodus 23:20 - 23:25","7":"Exodus 23:26 - 24:18","4":"Exodus 22:27 - 23:5","maftir":"Exodus 30:11 - 30:16 | Shabbat Shekalim","haftarah":"II Kings 12:1 - 12:17 | Shabbat Shekalim","2":"Exodus 21:20 - 22:3"},"hebrew":"פרשת משפטים","link":"https://www.hebcal.com/sedrot/mishpatim","title":"Parashat Mishpatim","category":"parashat"},{"hebrew":"שבת שקלים","memo":"Shabbat before Rosh Chodesh Adar","date":"2018-02-10","category":"holiday","subcat":"shabbat","title":"Shabbat Shekalim","link":"https://www.hebcal.com/holidays/shabbat-shekalim"},{"memo":"Beginning of new Hebrew month of Adar","date":"2018-02-15","hebrew":"ראש חודש אדר","title":"Rosh Chodesh Adar","link":"https://www.hebcal.com/holidays/rosh-chodesh-adar","category":"roshchodesh"},{"category":"roshchodesh","title":"Rosh Chodesh Adar","link":"https://www.hebcal.com/holidays/rosh-chodesh-adar","hebrew":"ראש חודש אדר","memo":"Beginning of new Hebrew month of Adar","date":"2018-02-16"},{"date":"2018-02-17","hebrew":"פרשת תרומה","leyning":{"haftarah":"I Kings 5:26 - 6:13","maftir":"Exodus 27:17 - 27:19","4":"Exodus 26:15 - 26:30","2":"Exodus 25:17 - 25:30","7":"Exodus 27:9 - 27:19","3":"Exodus 25:31 - 26:14","torah":"Exodus 25:1 - 27:19","6":"Exodus 27:1 - 27:8","5":"Exodus 26:31 - 26:37","1":"Exodus 25:1 - 25:16"},"title":"Parashat Terumah","link":"https://www.hebcal.com/sedrot/terumah","category":"parashat"},{"date":"2018-02-24","leyning":{"maftir":"Deuteronomy 25:17 - 25:19 | Shabbat Zachor","4":"Exodus 29:1 - 29:18","2":"Exodus 28:13 - 28:30","haftarah":"I Samuel 15:2 - 15:34 | Shabbat Zachor","7":"Exodus 30:1 - 30:10","torah":"Exodus 27:20 - 30:10","6":"Exodus 29:38 - 29:46","3":"Exodus 28:31 - 28:43","1":"Exodus 27:20 - 28:12","5":"Exodus 29:19 - 29:37"},"hebrew":"פרשת תצוה","link":"https://www.hebcal.com/sedrot/tetzaveh","title":"Parashat Tetzaveh","category":"parashat"},{"link":"https://www.hebcal.com/holidays/shabbat-zachor","title":"Shabbat Zachor","category":"holiday","subcat":"shabbat","memo":"Shabbat before Purim","date":"2018-02-24","hebrew":"שבת זכור"},{"date":"2018-02-28","memo":"Fast of Esther","hebrew":"תענית אסתר","link":"https://www.hebcal.com/holidays/taanit-esther","title":"Ta'anit Esther","category":"holiday","subcat":"fast"},{"link":"https://www.hebcal.com/holidays/purim","title":"Erev Purim","subcat":"major","category":"holiday","date":"2018-02-28","memo":"Purim is one of the most joyous and fun holidays on the Jewish calendar","hebrew":"ערב פורים"},{"category":"holiday","subcat":"major","title":"Purim","link":"https://www.hebcal.com/holidays/purim","hebrew":"פורים","memo":"Purim is one of the most joyous and fun holidays on the Jewish calendar","date":"2018-03-01"},{"category":"holiday","subcat":"minor","link":"https://www.hebcal.com/holidays/shushan-purim","title":"Shushan Purim","hebrew":"שושן פורים","memo":"Purim celebrated in Jerusalem and walled cities","date":"2018-03-02"},{"title":"Parashat Ki Tisa","link":"https://www.hebcal.com/sedrot/kitisa","category":"parashat","date":"2018-03-03","leyning":{"3":"Exodus 33:12 - 33:16","torah":"Exodus 30:11 - 34:35","6":"Exodus 34:10 - 34:26","5":"Exodus 34:1 - 34:9","1":"Exodus 30:11 - 31:17","4":"Exodus 33:17 - 33:23","maftir":"Exodus 34:33 - 34:35","2":"Exodus 31:18 - 33:11","haftarah":"I Kings 18:1 - 18:39","7":"Exodus 34:27 - 34:35"},"hebrew":"פרשת כי תשא"},{"leyning":{"torah":"Exodus 35:1 - 40:38","6":"Exodus 39:22 - 39:43","3":"Exodus 37:17 - 37:29","1":"Exodus 35:1 - 35:29","5":"Exodus 39:2 - 39:21","haftarah":"Ezekiel 36:16 - 36:38 | Shabbat Parah","maftir":"Numbers 19:1 - 19:22 | Shabbat Parah","4":"Exodus 38:1 - 39:1","2":"Exodus 35:30 - 37:16","7":"Exodus 40:1 - 40:38"},"hebrew":"פרשת ויקהל־פקודי","date":"2018-03-10","category":"parashat","link":"https://www.hebcal.com/sedrot/vayakhelpekudei","title":"Parashat Vayakhel-Pekudei"},{"hebrew":"שבת פרה","memo":"Shabbat of the Red Heifer","date":"2018-03-10","subcat":"shabbat","category":"holiday","link":"https://www.hebcal.com/holidays/shabbat-parah","title":"Shabbat Parah"},{"category":"parashat","title":"Parashat Vayikra","link":"https://www.hebcal.com/sedrot/vayikra","leyning":{"3":"Leviticus 2:7 - 2:16","6":"Leviticus 4:27 - 5:26","torah":"Leviticus 1:1 - 5:26","5":"Leviticus 4:1 - 4:26","1":"Leviticus 1:1 - 1:13","4":"Leviticus 3:1 - 3:17","2":"Leviticus 1:14 - 2:6","maftir":"Exodus 12:1 - 12:20 | Shabbat HaChodesh (on Rosh Chodesh)","haftarah":"Ezekiel 45:16 - 46:18 | Shabbat HaChodesh (on Rosh Chodesh)","7":"Numbers 28:9 - 28:15 | Shabbat HaChodesh (on Rosh Chodesh)"},"hebrew":"פרשת ויקרא","date":"2018-03-17"},{"link":"https://www.hebcal.com/holidays/rosh-chodesh-nisan","title":"Rosh Chodesh Nisan","category":"roshchodesh","date":"2018-03-17","memo":"Beginning of new Hebrew month of Nisan","hebrew":"ראש חודש ניסן"},{"date":"2018-03-17","memo":"Shabbat before Rosh Chodesh Nissan","hebrew":"שבת החדש","title":"Shabbat HaChodesh","link":"https://www.hebcal.com/holidays/shabbat-hachodesh","category":"holiday","subcat":"shabbat"},{"date":"2018-03-24","hebrew":"פרשת צו","leyning":{"7":"Leviticus 8:30 - 8:36","haftarah":"Malachi 3:4 - 3:24 | Shabbat HaGadol","2":"Leviticus 6:12 - 7:10","4":"Leviticus 8:1 - 8:13","maftir":"Leviticus 8:33 - 8:36","5":"Leviticus 8:14 - 8:21","1":"Leviticus 6:1 - 6:11","3":"Leviticus 7:11 - 7:38","6":"Leviticus 8:22 - 8:29","torah":"Leviticus 6:1 - 8:36"},"link":"https://www.hebcal.com/sedrot/tzav","title":"Parashat Tzav","category":"parashat"},{"title":"Shabbat HaGadol","link":"https://www.hebcal.com/holidays/shabbat-hagadol","subcat":"shabbat","category":"holiday","date":"2018-03-24","memo":"Shabbat before Pesach","hebrew":"שבת הגדול"},{"hebrew":"תענית בכורות","memo":"Fast of the First Born","date":"2018-03-30","category":"holiday","subcat":"fast","title":"Ta'anit Bechorot","link":"https://www.hebcal.com/holidays/taanit-bechorot"},{"memo":"Passover, the Feast of Unleavened Bread","date":"2018-03-30","hebrew":"ערב פסח","title":"Erev Pesach","link":"https://www.hebcal.com/holidays/pesach","category":"holiday"},{"subcat":"major","date":"2018-03-31","memo":"Passover, the Feast of Unleavened Bread","hebrew":"פסח יום א׳","yomtov":true,"link":"https://www.hebcal.com/holidays/pesach","title":"Pesach I","category":"holiday"},{"subcat":"major","category":"holiday","title":"Pesach II (CH''M)","link":"https://www.hebcal.com/holidays/pesach","hebrew":"פסח יום ב׳ (חול המועד)","date":"2018-04-01","memo":"Passover, the Feast of Unleavened Bread"},{"date":"2018-04-01","hebrew":"א׳ בעומר","title":"1st day of the Omer","category":"omer"},{"hebrew":"פסח יום ג׳ (חול המועד)","date":"2018-04-02","memo":"Passover, the Feast of Unleavened Bread","category":"holiday","subcat":"major","link":"https://www.hebcal.com/holidays/pesach","title":"Pesach III (CH''M)"},{"hebrew":"ב׳ בעומר","date":"2018-04-02","category":"omer","title":"2nd day of the Omer"},{"subcat":"major","category":"holiday","title":"Pesach IV (CH''M)","link":"https://www.hebcal.com/holidays/pesach","hebrew":"פסח יום ד׳ (חול המועד)","memo":"Passover, the Feast of Unleavened Bread","date":"2018-04-03"},{"category":"omer","title":"3rd day of the Omer","hebrew":"ג׳ בעומר","date":"2018-04-03"},{"link":"https://www.hebcal.com/holidays/pesach","title":"Pesach V (CH''M)","subcat":"major","category":"holiday","date":"2018-04-04","memo":"Passover, the Feast of Unleavened Bread","hebrew":"פסח יום ה׳ (חול המועד)"},{"hebrew":"ד׳ בעומר","date":"2018-04-04","category":"omer","title":"4th day of the Omer"},{"category":"holiday","subcat":"major","link":"https://www.hebcal.com/holidays/pesach","title":"Pesach VI (CH''M)","hebrew":"פסח יום ו׳ (חול המועד)","date":"2018-04-05","memo":"Passover, the Feast of Unleavened Bread"},{"category":"omer","title":"5th day of the Omer","hebrew":"ה׳ בעומר","date":"2018-04-05"},{"yomtov":true,"link":"https://www.hebcal.com/holidays/pesach","title":"Pesach VII","category":"holiday","subcat":"major","date":"2018-04-06","memo":"Passover, the Feast of Unleavened Bread","hebrew":"פסח יום ז׳"},{"title":"6th day of the Omer","category":"omer","date":"2018-04-06","hebrew":"ו׳ בעומר"},{"link":"https://www.hebcal.com/sedrot/shmini","title":"Parashat Shmini","category":"parashat","date":"2018-04-07","leyning":{"torah":"Leviticus 9:1 - 11:47","6":"Leviticus 11:1 - 11:32","3":"Leviticus 9:24 - 10:11","1":"Leviticus 9:1 - 9:16","5":"Leviticus 10:16 - 10:20","maftir":"Leviticus 11:45 - 11:47","4":"Leviticus 10:12 - 10:15","haftarah":"II Samuel 6:1 - 7:17","2":"Leviticus 9:17 - 9:23","7":"Leviticus 11:33 - 11:47"},"hebrew":"פרשת שמיני"},{"date":"2018-04-07","hebrew":"ז׳ בעומר","title":"7th day of the Omer","category":"omer"},{"hebrew":"ח׳ בעומר","date":"2018-04-08","category":"omer","title":"8th day of the Omer"},{"hebrew":"ט׳ בעומר","date":"2018-04-09","category":"omer","title":"9th day of the Omer"},{"category":"omer","title":"10th day of the Omer","hebrew":"י׳ בעומר","date":"2018-04-10"},{"title":"11th day of the Omer","category":"omer","date":"2018-04-11","hebrew":"י״א בעומר"},{"category":"holiday","subcat":"modern","link":"https://www.hebcal.com/holidays/yom-hashoah","title":"Yom HaShoah","hebrew":"יום השואה","memo":"Holocaust Memorial Day","date":"2018-04-12"},{"title":"12th day of the Omer","category":"omer","date":"2018-04-12","hebrew":"י״ב בעומר"},{"hebrew":"י״ג בעומר","date":"2018-04-13","category":"omer","title":"13th day of the Omer"},{"date":"2018-04-14","hebrew":"פרשת תזריע־מצרע","leyning":{"torah":"Leviticus 12:1 - 15:33","6":"Leviticus 14:33 - 15:15","3":"Leviticus 13:40 - 13:54","1":"Leviticus 12:1 - 13:23","5":"Leviticus 14:21 - 14:32","2":"Leviticus 13:24 - 13:39","maftir":"Leviticus 15:31 - 15:33","haftarah":"I Samuel 20:18 - 20:42 | Shabbat Machar Chodesh","4":"Leviticus 13:55 - 14:20","7":"Leviticus 15:16 - 15:33"},"link":"https://www.hebcal.com/sedrot/tazriametzora","title":"Parashat Tazria-Metzora","category":"parashat"},{"title":"14th day of the Omer","category":"omer","date":"2018-04-14","hebrew":"י״ד בעומר"},{"category":"roshchodesh","link":"https://www.hebcal.com/holidays/rosh-chodesh-iyyar","title":"Rosh Chodesh Iyyar","hebrew":"ראש חודש אייר","memo":"Beginning of new Hebrew month of Iyyar","date":"2018-04-15"},{"title":"15th day of the Omer","category":"omer","date":"2018-04-15","hebrew":"ט״ו בעומר"},{"memo":"Beginning of new Hebrew month of Iyyar","date":"2018-04-16","hebrew":"ראש חודש אייר","link":"https://www.hebcal.com/holidays/rosh-chodesh-iyyar","title":"Rosh Chodesh Iyyar","category":"roshchodesh"},{"title":"16th day of the Omer","category":"omer","date":"2018-04-16","hebrew":"ט״ז בעומר"},{"hebrew":"י״ז בעומר","date":"2018-04-17","category":"omer","title":"17th day of the Omer"},{"link":"https://www.hebcal.com/holidays/yom-hazikaron","title":"Yom HaZikaron","subcat":"modern","category":"holiday","date":"2018-04-18","memo":"Israeli Memorial Day","hebrew":"יום הזכרון"},{"title":"18th day of the Omer","category":"omer","date":"2018-04-18","hebrew":"י״ח בעומר"},{"hebrew":"יום העצמאות","date":"2018-04-19","memo":"Israeli Independence Day","category":"holiday","subcat":"modern","title":"Yom HaAtzma'ut","link":"https://www.hebcal.com/holidays/yom-haatzmaut"},{"hebrew":"י״ט בעומר","date":"2018-04-19","category":"omer","title":"19th day of the Omer"},{"hebrew":"כ׳ בעומר","date":"2018-04-20","category":"omer","title":"20th day of the Omer"},{"category":"parashat","title":"Parashat Achrei Mot-Kedoshim","link":"https://www.hebcal.com/sedrot/achreimotkedoshim","hebrew":"פרשת אחרי מות־קדשים","leyning":{"7":"Leviticus 20:8 - 20:27","maftir":"Leviticus 20:25 - 20:27","2":"Leviticus 16:25 - 17:7","haftarah":"Amos 9:7 - 9:15","4":"Leviticus 18:22 - 19:14","5":"Leviticus 19:15 - 19:32","1":"Leviticus 16:1 - 16:24","3":"Leviticus 17:8 - 18:21","6":"Leviticus 19:33 - 20:7","torah":"Leviticus 16:1 - 20:27"},"date":"2018-04-21"},{"title":"21st day of the Omer","category":"omer","date":"2018-04-21","hebrew":"כ״א בעומר"},{"category":"omer","title":"22nd day of the Omer","hebrew":"כ״ב בעומר","date":"2018-04-22"},{"date":"2018-04-23","hebrew":"כ״ג בעומר","title":"23rd day of the Omer","category":"omer"},{"title":"24th day of the Omer","category":"omer","date":"2018-04-24","hebrew":"כ״ד בעומר"},{"date":"2018-04-25","hebrew":"כ״ה בעומר","title":"25th day of the Omer","category":"omer"},{"title":"26th day of the Omer","category":"omer","date":"2018-04-26","hebrew":"כ״ו בעומר"},{"category":"omer","title":"27th day of the Omer","hebrew":"כ״ז בעומר","date":"2018-04-27"},{"title":"Parashat Emor","link":"https://www.hebcal.com/sedrot/emor","category":"parashat","date":"2018-04-28","hebrew":"פרשת אמור","leyning":{"5":"Leviticus 23:23 - 23:32","1":"Leviticus 21:1 - 21:15","3":"Leviticus 22:17 - 22:33","torah":"Leviticus 21:1 - 24:23","6":"Leviticus 23:33 - 23:44","7":"Leviticus 24:1 - 24:23","haftarah":"Ezekiel 44:15 - 44:31","maftir":"Leviticus 24:21 - 24:23","2":"Leviticus 21:16 - 22:16","4":"Leviticus 23:1 - 23:22"}},{"hebrew":"כ״ח בעומר","date":"2018-04-28","category":"omer","title":"28th day of the Omer"},{"memo":"Second Passover, one month after Passover","date":"2018-04-29","hebrew":"פסח שני","title":"Pesach Sheni","link":"https://www.hebcal.com/holidays/pesach-sheni","category":"holiday","subcat":"minor"},{"hebrew":"כ״ט בעומר","date":"2018-04-29","category":"omer","title":"29th day of the Omer"},{"date":"2018-04-30","hebrew":"ל׳ בעומר","title":"30th day of the Omer","category":"omer"},{"date":"2018-05-01","hebrew":"ל״א בעומר","title":"31st day of the Omer","category":"omer"},{"hebrew":"ל״ב בעומר","date":"2018-05-02","category":"omer","title":"32nd day of the Omer"},{"memo":"33rd day of counting the Omer","date":"2018-05-03","hebrew":"ל״ג בעומר","title":"Lag BaOmer","link":"https://www.hebcal.com/holidays/lag-baomer","subcat":"minor","category":"holiday"},{"date":"2018-05-03","hebrew":"ל״ג בעומר","title":"33rd day of the Omer","category":"omer"},{"date":"2018-05-04","hebrew":"ל״ד בעומר","title":"34th day of the Omer","category":"omer"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/behar","title":"Parashat Behar","hebrew":"פרשת בהר","leyning":{"5":"Leviticus 25:29 - 25:38","1":"Leviticus 25:1 - 25:13","3":"Leviticus 25:19 - 25:24","torah":"Leviticus 25:1 - 26:2","6":"Leviticus 25:39 - 25:46","7":"Leviticus 25:47 - 26:2","4":"Leviticus 25:25 - 25:28","maftir":"Leviticus 25:55 - 26:2","2":"Leviticus 25:14 - 25:18","haftarah":"Jeremiah 32:6 - 32:27"},"date":"2018-05-05"},{"category":"omer","title":"35th day of the Omer","hebrew":"ל״ה בעומר","date":"2018-05-05"},{"category":"omer","title":"36th day of the Omer","hebrew":"ל״ו בעומר","date":"2018-05-06"},{"hebrew":"ל״ז בעומר","date":"2018-05-07","category":"omer","title":"37th day of the Omer"},{"hebrew":"ל״ח בעומר","date":"2018-05-08","category":"omer","title":"38th day of the Omer"},{"category":"omer","title":"39th day of the Omer","hebrew":"ל״ט בעומר","date":"2018-05-09"},{"hebrew":"מ׳ בעומר","date":"2018-05-10","category":"omer","title":"40th day of the Omer"},{"category":"omer","title":"41st day of the Omer","hebrew":"מ״א בעומר","date":"2018-05-11"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/bechukotai","title":"Parashat Bechukotai","hebrew":"פרשת בחקתי","leyning":{"7":"Leviticus 27:29 - 27:34","4":"Leviticus 27:1 - 27:15","haftarah":"Jeremiah 16:19 - 17:14","2":"Leviticus 26:6 - 26:9","maftir":"Leviticus 27:32 - 27:34","5":"Leviticus 27:16 - 27:21","1":"Leviticus 26:3 - 26:5","3":"Leviticus 26:10 - 26:46","6":"Leviticus 27:22 - 27:28","torah":"Leviticus 26:3 - 27:34"},"date":"2018-05-12"},{"date":"2018-05-12","hebrew":"מ״ב בעומר","title":"42nd day of the Omer","category":"omer"},{"date":"2018-05-13","memo":"Jerusalem Day","hebrew":"יום ירושלים","link":"https://www.hebcal.com/holidays/yom-yerushalayim","title":"Yom Yerushalayim","subcat":"modern","category":"holiday"},{"hebrew":"מ״ג בעומר","date":"2018-05-13","category":"omer","title":"43rd day of the Omer"},{"title":"44th day of the Omer","category":"omer","date":"2018-05-14","hebrew":"מ״ד בעומר"},{"hebrew":"ראש חודש סיון","memo":"Beginning of new Hebrew month of Sivan","date":"2018-05-15","category":"roshchodesh","link":"https://www.hebcal.com/holidays/rosh-chodesh-sivan","title":"Rosh Chodesh Sivan"},{"date":"2018-05-15","hebrew":"מ״ה בעומר","title":"45th day of the Omer","category":"omer"},{"hebrew":"מ״ו בעומר","date":"2018-05-16","category":"omer","title":"46th day of the Omer"},{"hebrew":"מ״ז בעומר","date":"2018-05-17","category":"omer","title":"47th day of the Omer"},{"hebrew":"מ״ח בעומר","date":"2018-05-18","category":"omer","title":"48th day of the Omer"},{"date":"2018-05-19","hebrew":"פרשת במדבר","leyning":{"2":"Numbers 1:20 - 1:54","haftarah":"Hosea 2:1 - 2:22","maftir":"Numbers 4:17 - 4:20","4":"Numbers 3:1 - 3:13","7":"Numbers 4:1 - 4:20","3":"Numbers 2:1 - 2:34","torah":"Numbers 1:1 - 4:20","6":"Numbers 3:40 - 3:51","5":"Numbers 3:14 - 3:39","1":"Numbers 1:1 - 1:19"},"title":"Parashat Bamidbar","link":"https://www.hebcal.com/sedrot/bamidbar","category":"parashat"},{"category":"holiday","link":"https://www.hebcal.com/holidays/shavuot","title":"Erev Shavuot","hebrew":"ערב שבועות","date":"2018-05-19","memo":"Festival of Weeks, commemorates the giving of the Torah at Mount Sinai"},{"date":"2018-05-19","hebrew":"מ״ט בעומר","title":"49th day of the Omer","category":"omer"},{"date":"2018-05-20","memo":"Festival of Weeks, commemorates the giving of the Torah at Mount Sinai","hebrew":"שבועות יום א׳","subcat":"major","yomtov":true,"link":"https://www.hebcal.com/holidays/shavuot","title":"Shavuot I","category":"holiday"},{"leyning":{"maftir":"Numbers 7:87 - 7:89","2":"Numbers 4:38 - 4:49","haftarah":"Judges 13:2 - 13:25","4":"Numbers 5:11 - 6:27","7":"Numbers 7:72 - 7:89","torah":"Numbers 4:21 - 7:89","6":"Numbers 7:42 - 7:71","3":"Numbers 5:1 - 5:10","1":"Numbers 4:21 - 4:37","5":"Numbers 7:1 - 7:41"},"hebrew":"פרשת נשא","date":"2018-05-26","category":"parashat","link":"https://www.hebcal.com/sedrot/nasso","title":"Parashat Nasso"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/behaalotcha","title":"Parashat Beha'alotcha","hebrew":"פרשת בהעלתך","leyning":{"haftarah":"Zechariah 2:14 - 4:7","maftir":"Numbers 12:14 - 12:16","4":"Numbers 9:15 - 10:10","2":"Numbers 8:15 - 8:26","7":"Numbers 11:30 - 12:16","torah":"Numbers 8:1 - 12:16","6":"Numbers 10:35 - 11:29","3":"Numbers 9:1 - 9:14","1":"Numbers 8:1 - 8:14","5":"Numbers 10:11 - 10:34"},"date":"2018-06-02"},{"category":"parashat","title":"Parashat Sh'lach","link":"https://www.hebcal.com/sedrot/shlach","hebrew":"פרשת שלח־לך","leyning":{"7":"Numbers 15:27 - 15:41","2":"Numbers 13:21 - 14:7","maftir":"Numbers 15:37 - 15:41","4":"Numbers 14:26 - 15:7","haftarah":"Joshua 2:1 - 2:24","5":"Numbers 15:8 - 15:16","1":"Numbers 13:1 - 13:20","3":"Numbers 14:8 - 14:25","6":"Numbers 15:17 - 15:26","torah":"Numbers 13:1 - 15:41"},"date":"2018-06-09"},{"link":"https://www.hebcal.com/holidays/rosh-chodesh-tamuz","title":"Rosh Chodesh Tamuz","category":"roshchodesh","date":"2018-06-13","memo":"Beginning of new Hebrew month of Tamuz","hebrew":"ראש חודש תמוז"},{"date":"2018-06-14","memo":"Beginning of new Hebrew month of Tamuz","hebrew":"ראש חודש תמוז","link":"https://www.hebcal.com/holidays/rosh-chodesh-tamuz","title":"Rosh Chodesh Tamuz","category":"roshchodesh"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/korach","title":"Parashat Korach","leyning":{"3":"Numbers 16:20 - 17:8","6":"Numbers 17:25 - 18:20","torah":"Numbers 16:1 - 18:32","5":"Numbers 17:16 - 17:24","1":"Numbers 16:1 - 16:13","maftir":"Numbers 18:30 - 18:32","haftarah":"I Samuel 11:14 - 12:22","2":"Numbers 16:14 - 16:19","4":"Numbers 17:9 - 17:15","7":"Numbers 18:21 - 18:32"},"hebrew":"פרשת קורח","date":"2018-06-16"},{"date":"2018-06-23","leyning":{"1":"Numbers 19:1 - 19:17","5":"Numbers 20:22 - 21:9","torah":"Numbers 19:1 - 22:1","6":"Numbers 21:10 - 21:20","3":"Numbers 20:7 - 20:13","7":"Numbers 21:21 - 22:1","haftarah":"Judges 11:1 - 11:33","maftir":"Numbers 21:34 - 22:1","4":"Numbers 20:14 - 20:21","2":"Numbers 19:18 - 20:6"},"hebrew":"פרשת חקת","title":"Parashat Chukat","link":"https://www.hebcal.com/sedrot/chukat","category":"parashat"},{"link":"https://www.hebcal.com/sedrot/balak","title":"Parashat Balak","category":"parashat","date":"2018-06-30","hebrew":"פרשת בלק","leyning":{"4":"Numbers 22:39 - 23:12","haftarah":"Micah 5:6 - 6:8","maftir":"Numbers 25:7 - 25:9","2":"Numbers 22:13 - 22:20","7":"Numbers 24:14 - 25:9","torah":"Numbers 22:2 - 25:9","6":"Numbers 23:27 - 24:13","3":"Numbers 22:21 - 22:38","1":"Numbers 22:2 - 22:12","5":"Numbers 23:13 - 23:26"}},{"category":"holiday","subcat":"fast","title":"Tzom Tammuz","link":"https://www.hebcal.com/holidays/tzom-tammuz","hebrew":"צום תמוז","memo":"Fast commemorating breaching of the walls of Jerusalem before the destruction of the Second Temple","date":"2018-07-01"},{"category":"parashat","title":"Parashat Pinchas","link":"https://www.hebcal.com/sedrot/pinchas","hebrew":"פרשת פינחס","leyning":{"7":"Numbers 29:12 - 30:1","maftir":"Numbers 29:35 - 30:1","haftarah":"Jeremiah 1:1 - 2:3 | Pinchas occurring after 17 Tammuz","4":"Numbers 27:6 - 27:23","2":"Numbers 26:5 - 26:51","5":"Numbers 28:1 - 28:15","1":"Numbers 25:10 - 26:4","3":"Numbers 26:52 - 27:5","6":"Numbers 28:16 - 29:11","torah":"Numbers 25:10 - 30:1"},"date":"2018-07-07"},{"category":"roshchodesh","title":"Rosh Chodesh Av","link":"https://www.hebcal.com/holidays/rosh-chodesh-av","hebrew":"ראש חודש אב","memo":"Beginning of new Hebrew month of Av","date":"2018-07-13"},{"title":"Parashat Matot-Masei","link":"https://www.hebcal.com/sedrot/matotmasei","category":"parashat","date":"2018-07-14","leyning":{"3":"Numbers 32:1 - 32:19","torah":"Numbers 30:2 - 36:13","6":"Numbers 34:16 - 35:8","5":"Numbers 33:50 - 34:15","1":"Numbers 30:2 - 31:12","4":"Numbers 32:20 - 33:49","maftir":"Numbers 36:11 - 36:13","2":"Numbers 31:13 - 31:54","haftarah":"Jeremiah 2:4 - 28; 3:4","7":"Numbers 35:9 - 36:13"},"hebrew":"פרשת מטות־מסעי"},{"category":"parashat","title":"Parashat Devarim","link":"https://www.hebcal.com/sedrot/devarim","leyning":{"7":"Deuteronomy 3:15 - 3:22","4":"Deuteronomy 1:39 - 2:1","maftir":"Deuteronomy 3:20 - 3:22","2":"Deuteronomy 1:11 - 1:21","haftarah":"Isaiah 1:1 - 1:27","1":"Deuteronomy 1:1 - 1:10","5":"Deuteronomy 2:2 - 2:30","6":"Deuteronomy 2:31 - 3:14","torah":"Deuteronomy 1:1 - 3:22","3":"Deuteronomy 1:22 - 1:38"},"hebrew":"פרשת דברים","date":"2018-07-21"},{"hebrew":"שבת חזון","memo":"Shabbat before Tish'a B'Av (Shabbat of Prophecy/Shabbat of Vision)","date":"2018-07-21","category":"holiday","subcat":"shabbat","title":"Shabbat Chazon","link":"https://www.hebcal.com/holidays/shabbat-chazon"},{"hebrew":"ערב תשעה באב","memo":"The Ninth of Av, fast commemorating the destruction of the two Temples","date":"2018-07-21","subcat":"major","category":"holiday","link":"https://www.hebcal.com/holidays/tisha-bav","title":"Erev Tish'a B'Av"},{"hebrew":"תשעה באב","date":"2018-07-22","memo":"The Ninth of Av, fast commemorating the destruction of the two Temples","subcat":"major","category":"holiday","title":"Tish'a B'Av","link":"https://www.hebcal.com/holidays/tisha-bav"},{"link":"https://www.hebcal.com/holidays/tu-bav","title":"Tu B'Av","category":"holiday","subcat":"minor","date":"2018-07-27","memo":"Jewish holiday of love, similar to Valentine's Day","hebrew":"טו באב"},{"leyning":{"7":"Deuteronomy 7:1 - 7:11","maftir":"Deuteronomy 7:9 - 7:11","4":"Deuteronomy 5:1 - 5:18","haftarah":"Isaiah 40:1 - 40:26","2":"Deuteronomy 4:5 - 4:40","5":"Deuteronomy 5:19 - 6:3","1":"Deuteronomy 3:23 - 4:4","3":"Deuteronomy 4:41 - 4:49","6":"Deuteronomy 6:4 - 6:25","torah":"Deuteronomy 3:23 - 7:11"},"hebrew":"פרשת ואתחנן","date":"2018-07-28","category":"parashat","title":"Parashat Vaetchanan","link":"https://www.hebcal.com/sedrot/vaetchanan"},{"date":"2018-07-28","memo":"Shabbat after Tish'a B'Av (Shabbat of Consolation)","hebrew":"שבת נחמו","link":"https://www.hebcal.com/holidays/shabbat-nachamu","title":"Shabbat Nachamu","category":"holiday","subcat":"shabbat"},{"category":"parashat","title":"Parashat Eikev","link":"https://www.hebcal.com/sedrot/eikev","leyning":{"7":"Deuteronomy 11:22 - 11:25","maftir":"Deuteronomy 11:22 - 11:25","4":"Deuteronomy 10:1 - 10:11","haftarah":"Isaiah 49:14 - 51:3","2":"Deuteronomy 8:11 - 9:3","1":"Deuteronomy 7:12 - 8:10","5":"Deuteronomy 10:12 - 11:9","6":"Deuteronomy 11:10 - 11:21","torah":"Deuteronomy 7:12 - 11:25","3":"Deuteronomy 9:4 - 9:29"},"hebrew":"פרשת עקב","date":"2018-08-04"},{"date":"2018-08-11","hebrew":"פרשת ראה","leyning":{"7":"Deuteronomy 15:19 - 16:17","maftir":"Numbers 28:9 - 28:15 | Shabbat Rosh Chodesh","4":"Deuteronomy 14:1 - 14:21","haftarah":"Isaiah 66:1 - 66:24 | Shabbat Rosh Chodesh","2":"Deuteronomy 12:11 - 12:28","5":"Deuteronomy 14:22 - 14:29","1":"Deuteronomy 11:26 - 12:10","3":"Deuteronomy 12:29 - 13:19","6":"Deuteronomy 15:1 - 15:18","torah":"Deuteronomy 11:26 - 16:17"},"title":"Parashat Re'eh","link":"https://www.hebcal.com/sedrot/reeh","category":"parashat"},{"category":"roshchodesh","title":"Rosh Chodesh Elul","link":"https://www.hebcal.com/holidays/rosh-chodesh-elul","hebrew":"ראש חודש אלול","date":"2018-08-11","memo":"Beginning of new Hebrew month of Elul"},{"category":"roshchodesh","title":"Rosh Chodesh Elul","link":"https://www.hebcal.com/holidays/rosh-chodesh-elul","hebrew":"ראש חודש אלול","memo":"Beginning of new Hebrew month of Elul","date":"2018-08-12"},{"hebrew":"פרשת שופטים","leyning":{"3":"Deuteronomy 18:1 - 18:5","torah":"Deuteronomy 16:18 - 21:9","6":"Deuteronomy 19:14 - 20:9","5":"Deuteronomy 18:14 - 19:13","1":"Deuteronomy 16:18 - 17:13","2":"Deuteronomy 17:14 - 17:20","maftir":"Deuteronomy 21:7 - 21:9","haftarah":"Isaiah 51:12 - 52:12","4":"Deuteronomy 18:6 - 18:13","7":"Deuteronomy 20:10 - 21:9"},"date":"2018-08-18","category":"parashat","title":"Parashat Shoftim","link":"https://www.hebcal.com/sedrot/shoftim"},{"category":"parashat","title":"Parashat Ki Teitzei","link":"https://www.hebcal.com/sedrot/kiteitzei","leyning":{"maftir":"Deuteronomy 25:17 - 25:19","4":"Deuteronomy 23:8 - 23:24","haftarah":"Isaiah 54:1 - 54:10","2":"Deuteronomy 21:22 - 22:7","7":"Deuteronomy 24:14 - 25:19","3":"Deuteronomy 22:8 - 23:7","6":"Deuteronomy 24:5 - 24:13","torah":"Deuteronomy 21:10 - 25:19","5":"Deuteronomy 23:25 - 24:4","1":"Deuteronomy 21:10 - 21:21"},"hebrew":"פרשת כי־תצא","date":"2018-08-25"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/kitavo","title":"Parashat Ki Tavo","hebrew":"פרשת כי־תבוא","leyning":{"haftarah":"Isaiah 60:1 - 60:22","maftir":"Deuteronomy 29:6 - 29:8","4":"Deuteronomy 27:1 - 27:10","2":"Deuteronomy 26:12 - 26:15","7":"Deuteronomy 29:1 - 29:8","3":"Deuteronomy 26:16 - 26:19","torah":"Deuteronomy 26:1 - 29:8","6":"Deuteronomy 28:7 - 28:69","5":"Deuteronomy 27:11 - 28:6","1":"Deuteronomy 26:1 - 26:11"},"date":"2018-09-01"},{"subcat":"minor","category":"holiday","title":"Leil Selichot","link":"https://www.hebcal.com/holidays/leil-selichot","hebrew":"סליחות","memo":"Prayers for forgiveness in preparation for the High Holidays","date":"2018-09-01"},{"title":"Parashat Nitzavim","link":"https://www.hebcal.com/sedrot/nitzavim","category":"parashat","date":"2018-09-08","hebrew":"פרשת נצבים","leyning":{"1":"Deuteronomy 29:9 - 29:11","5":"Deuteronomy 30:7 - 30:10","torah":"Deuteronomy 29:9 - 30:20","6":"Deuteronomy 30:11 - 30:14","3":"Deuteronomy 29:15 - 29:28","7":"Deuteronomy 30:15 - 30:20","haftarah":"Isaiah 61:10 - 63:9","maftir":"Deuteronomy 30:15 - 30:20","4":"Deuteronomy 30:1 - 30:6","2":"Deuteronomy 29:12 - 29:14"}},{"hebrew":"ערב ראש השנה","date":"2018-09-09","memo":"The Jewish New Year","category":"holiday","link":"https://www.hebcal.com/holidays/rosh-hashana","title":"Erev Rosh Hashana"},{"date":"2018-09-10","memo":"The Jewish New Year","hebrew":"ראש השנה 5779","yomtov":true,"title":"Rosh Hashana 5779","link":"https://www.hebcal.com/holidays/rosh-hashana","category":"holiday"},{"category":"holiday","link":"https://www.hebcal.com/holidays/rosh-hashana","title":"Rosh Hashana II","yomtov":true,"hebrew":"ראש השנה יום ב׳","memo":"The Jewish New Year","date":"2018-09-11","subcat":"major"},{"date":"2018-09-12","memo":"Fast of the Seventh Month, commemorates the assassination of the Jewish governor of Judah","hebrew":"צום גדליה","title":"Tzom Gedaliah","link":"https://www.hebcal.com/holidays/tzom-gedaliah","category":"holiday","subcat":"fast"},{"link":"https://www.hebcal.com/sedrot/vayeilech","title":"Parashat Vayeilech","category":"parashat","date":"2018-09-15","hebrew":"פרשת וילך","leyning":{"maftir":"Deuteronomy 31:28 - 31:30","4":"Deuteronomy 31:10 - 31:13","haftarah":"Hosea 14:2-10; Micah 7:18-20; Joel 2:15-27 | Shabbat Shuva","2":"Deuteronomy 31:4 - 31:6","7":"Deuteronomy 31:25 - 31:30","torah":"Deuteronomy 31:1 - 31:30","6":"Deuteronomy 31:20 - 31:24","3":"Deuteronomy 31:7 - 31:9","1":"Deuteronomy 31:1 - 31:3","5":"Deuteronomy 31:14 - 31:19"}},{"category":"holiday","subcat":"shabbat","title":"Shabbat Shuva","link":"https://www.hebcal.com/holidays/shabbat-shuva","hebrew":"שבת שובה","date":"2018-09-15","memo":"Shabbat that falls between Rosh Hashanah and Yom Kippur (Shabbat of Returning)"},{"memo":"Day of Atonement","date":"2018-09-18","hebrew":"ערב יום כפור","title":"Erev Yom Kippur","link":"https://www.hebcal.com/holidays/yom-kippur","category":"holiday"},{"category":"holiday","link":"https://www.hebcal.com/holidays/yom-kippur","title":"Yom Kippur","yomtov":true,"subcat":"major","hebrew":"יום כפור","memo":"Day of Atonement","date":"2018-09-19"},{"title":"Parashat Ha'Azinu","link":"https://www.hebcal.com/sedrot/haazinu","category":"parashat","date":"2018-09-22","hebrew":"פרשת האזינו","leyning":{"3":"Deuteronomy 32:13 - 32:18","6":"Deuteronomy 32:40 - 32:43","torah":"Deuteronomy 32:1 - 32:52","5":"Deuteronomy 32:29 - 32:39","1":"Deuteronomy 32:1 - 32:6","maftir":"Deuteronomy 32:48 - 32:52","haftarah":"II Samuel 22:1 - 22:51","2":"Deuteronomy 32:7 - 32:12","4":"Deuteronomy 32:19 - 32:28","7":"Deuteronomy 32:44 - 32:52"}},{"link":"https://www.hebcal.com/holidays/sukkot","title":"Erev Sukkot","category":"holiday","date":"2018-09-23","memo":"Feast of Tabernacles","hebrew":"ערב סוכות"},{"date":"2018-09-24","memo":"Feast of Tabernacles","hebrew":"סוכות יום א׳","subcat":"major","yomtov":true,"link":"https://www.hebcal.com/holidays/sukkot","title":"Sukkot I","category":"holiday"},{"subcat":"major","category":"holiday","link":"https://www.hebcal.com/holidays/sukkot","title":"Sukkot II (CH''M)","hebrew":"סוכות יום ב׳ (חול המועד)","date":"2018-09-25","memo":"Feast of Tabernacles"},{"title":"Sukkot III (CH''M)","link":"https://www.hebcal.com/holidays/sukkot","category":"holiday","subcat":"major","memo":"Feast of Tabernacles","date":"2018-09-26","hebrew":"סוכות יום ג׳ (חול המועד)"},{"hebrew":"סוכות יום ד׳ (חול המועד)","memo":"Feast of Tabernacles","date":"2018-09-27","category":"holiday","subcat":"major","title":"Sukkot IV (CH''M)","link":"https://www.hebcal.com/holidays/sukkot"},{"category":"holiday","subcat":"major","title":"Sukkot V (CH''M)","link":"https://www.hebcal.com/holidays/sukkot","hebrew":"סוכות יום ה׳ (חול המועד)","memo":"Feast of Tabernacles","date":"2018-09-28"},{"date":"2018-09-29","memo":"Feast of Tabernacles","hebrew":"סוכות יום ו׳ (חול המועד)","link":"https://www.hebcal.com/holidays/sukkot","title":"Sukkot VI (CH''M)","category":"holiday","subcat":"major"},{"hebrew":"סוכות יום ז׳ (הושענא רבה)","date":"2018-09-30","memo":"Feast of Tabernacles","category":"holiday","subcat":"major","link":"https://www.hebcal.com/holidays/sukkot","title":"Sukkot VII (Hoshana Raba)"},{"category":"holiday","title":"Shmini Atzeret","link":"https://www.hebcal.com/holidays/shmini-atzeret","yomtov":true,"hebrew":"שמיני עצרת","memo":"Eighth Day of Assembly","date":"2018-10-01","subcat":"major"},{"date":"2018-10-06","hebrew":"פרשת בראשית","leyning":{"4":"Genesis 3:22 - 4:18","haftarah":"Isaiah 42:5 - 43:10","maftir":"Genesis 6:5 - 6:8","2":"Genesis 2:4 - 2:19","7":"Genesis 5:25 - 6:8","3":"Genesis 2:20 - 3:21","torah":"Genesis 1:1 - 6:8","6":"Genesis 4:23 - 5:24","5":"Genesis 4:19 - 4:22","1":"Genesis 1:1 - 2:3"},"title":"Parashat Bereshit","link":"https://www.hebcal.com/sedrot/bereshit","category":"parashat"},{"hebrew":"ראש חודש חשון","date":"2018-10-09","memo":"Beginning of new Hebrew month of Cheshvan","category":"roshchodesh","link":"https://www.hebcal.com/holidays/rosh-chodesh-cheshvan","title":"Rosh Chodesh Cheshvan"},{"memo":"Beginning of new Hebrew month of Cheshvan","date":"2018-10-10","hebrew":"ראש חודש חשון","title":"Rosh Chodesh Cheshvan","link":"https://www.hebcal.com/holidays/rosh-chodesh-cheshvan","category":"roshchodesh"},{"title":"Parashat Noach","link":"https://www.hebcal.com/sedrot/noach","category":"parashat","date":"2018-10-13","leyning":{"torah":"Genesis 6:9 - 11:32","6":"Genesis 9:18 - 10:32","3":"Genesis 7:17 - 8:14","1":"Genesis 6:9 - 6:22","5":"Genesis 9:8 - 9:17","maftir":"Genesis 11:29 - 11:32","haftarah":"Isaiah 54:1 - 55:5","2":"Genesis 7:1 - 7:16","4":"Genesis 8:15 - 9:7","7":"Genesis 11:1 - 11:32"},"hebrew":"פרשת נח"},{"hebrew":"יום העלייה","date":"2018-10-16","memo":"Recognizes Aliyah, immigration to the Jewish State of Israel","category":"holiday","subcat":"modern","title":"Yom HaAliyah","link":"https://www.hebcal.com/holidays/yom-haaliyah"},{"category":"parashat","title":"Parashat Lech-Lecha","link":"https://www.hebcal.com/sedrot/lechlecha","hebrew":"פרשת לך־לך","leyning":{"7":"Genesis 17:7 - 17:27","maftir":"Genesis 17:24 - 17:27","2":"Genesis 12:14 - 13:4","4":"Genesis 14:1 - 14:20","haftarah":"Isaiah 40:27 - 41:16","1":"Genesis 12:1 - 12:13","5":"Genesis 14:21 - 15:6","torah":"Genesis 12:1 - 17:27","6":"Genesis 15:7 - 17:6","3":"Genesis 13:5 - 13:18"},"date":"2018-10-20"},{"link":"https://www.hebcal.com/sedrot/vayera","title":"Parashat Vayera","category":"parashat","date":"2018-10-27","hebrew":"פרשת וירא","leyning":{"2":"Genesis 18:15 - 18:33","maftir":"Genesis 22:20 - 22:24","haftarah":"II Kings 4:1 - 4:37","4":"Genesis 19:21 - 21:4","7":"Genesis 22:1 - 22:24","3":"Genesis 19:1 - 19:20","torah":"Genesis 18:1 - 22:24","6":"Genesis 21:22 - 21:34","5":"Genesis 21:5 - 21:21","1":"Genesis 18:1 - 18:14"}},{"date":"2018-11-03","leyning":{"3":"Genesis 24:10 - 24:26","6":"Genesis 25:1 - 25:11","torah":"Genesis 23:1 - 25:18","5":"Genesis 24:53 - 24:67","1":"Genesis 23:1 - 23:16","maftir":"Genesis 25:16 - 25:18","4":"Genesis 24:27 - 24:52","2":"Genesis 23:17 - 24:9","haftarah":"I Kings 1:1 - 1:31","7":"Genesis 25:12 - 25:18"},"hebrew":"פרשת חיי שרה","title":"Parashat Chayei Sara","link":"https://www.hebcal.com/sedrot/chayeisara","category":"parashat"},{"date":"2018-11-07","memo":"Ethiopian Jewish holiday occurring 50 days after Yom Kippur","hebrew":"סיגד","title":"Sigd","link":"https://www.hebcal.com/holidays/sigd","category":"holiday","subcat":"modern"},{"memo":"Beginning of new Hebrew month of Kislev","date":"2018-11-08","hebrew":"ראש חודש כסלו","link":"https://www.hebcal.com/holidays/rosh-chodesh-kislev","title":"Rosh Chodesh Kislev","category":"roshchodesh"},{"hebrew":"ראש חודש כסלו","date":"2018-11-09","memo":"Beginning of new Hebrew month of Kislev","category":"roshchodesh","title":"Rosh Chodesh Kislev","link":"https://www.hebcal.com/holidays/rosh-chodesh-kislev"},{"leyning":{"1":"Genesis 25:19 - 26:5","5":"Genesis 26:30 - 27:27","6":"Genesis 27:28 - 28:4","torah":"Genesis 25:19 - 28:9","3":"Genesis 26:13 - 26:22","7":"Genesis 28:5 - 28:9","4":"Genesis 26:23 - 26:29","2":"Genesis 26:6 - 26:12","maftir":"Genesis 28:7 - 28:9","haftarah":"Malachi 1:1 - 2:7"},"hebrew":"פרשת תולדות","date":"2018-11-10","category":"parashat","link":"https://www.hebcal.com/sedrot/toldot","title":"Parashat Toldot"},{"leyning":{"3":"Genesis 29:18 - 30:13","6":"Genesis 31:17 - 31:42","torah":"Genesis 28:10 - 32:3","5":"Genesis 30:28 - 31:16","1":"Genesis 28:10 - 28:22","haftarah":"Hosea 12:13 - 14:10","2":"Genesis 29:1 - 29:17","4":"Genesis 30:14 - 30:27","maftir":"Genesis 32:1 - 32:3","7":"Genesis 31:43 - 32:3"},"hebrew":"פרשת ויצא","date":"2018-11-17","category":"parashat","title":"Parashat Vayetzei","link":"https://www.hebcal.com/sedrot/vayetzei"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/vayishlach","title":"Parashat Vayishlach","hebrew":"פרשת וישלח","leyning":{"7":"Genesis 36:20 - 36:43","4":"Genesis 33:6 - 33:20","haftarah":"Obadiah 1:1 - 1:21","2":"Genesis 32:14 - 32:30","maftir":"Genesis 36:40 - 36:43","1":"Genesis 32:4 - 32:13","5":"Genesis 34:1 - 35:11","6":"Genesis 35:12 - 36:19","torah":"Genesis 32:4 - 36:43","3":"Genesis 32:31 - 33:5"},"date":"2018-11-24"},{"category":"parashat","link":"https://www.hebcal.com/sedrot/vayeshev","title":"Parashat Vayeshev","leyning":{"7":"Genesis 40:1 - 40:23","haftarah":"Amos 2:6 - 3:8","maftir":"Genesis 40:20 - 40:23","4":"Genesis 38:1 - 38:30","2":"Genesis 37:12 - 37:22","1":"Genesis 37:1 - 37:11","5":"Genesis 39:1 - 39:6","torah":"Genesis 37:1 - 40:23","6":"Genesis 39:7 - 39:23","3":"Genesis 37:23 - 37:36"},"hebrew":"פרשת וישב","date":"2018-12-01"},{"date":"2018-12-02","memo":"The Jewish festival of rededication, also known as the Festival of Lights","hebrew":"חנוכה: א׳ נר","link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 1 Candle","subcat":"major","category":"holiday"},{"link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 2 Candles","category":"holiday","subcat":"major","memo":"The Jewish festival of rededication, also known as the Festival of Lights","date":"2018-12-03","hebrew":"חנוכה: ב׳ נרות"},{"link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 3 Candles","subcat":"major","category":"holiday","memo":"The Jewish festival of rededication, also known as the Festival of Lights","date":"2018-12-04","hebrew":"חנוכה: ג׳ נרות"},{"link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 4 Candles","category":"holiday","subcat":"major","memo":"The Jewish festival of rededication, also known as the Festival of Lights","date":"2018-12-05","hebrew":"חנוכה: ד׳ נרות"},{"hebrew":"חנוכה: ה׳ נרות","date":"2018-12-06","memo":"The Jewish festival of rededication, also known as the Festival of Lights","subcat":"major","category":"holiday","link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 5 Candles"},{"hebrew":"חנוכה: ו׳ נרות","memo":"The Jewish festival of rededication, also known as the Festival of Lights","date":"2018-12-07","subcat":"major","category":"holiday","link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 6 Candles"},{"leyning":{"2":"Genesis 41:15 - 41:38","maftir":"Numbers 7:42 - 7:47 | Shabbat Rosh Chodesh Chanukah","4":"Genesis 41:53 - 42:18","haftarah":"Zechariah 2:14-4:7 | Shabbat Rosh Chodesh Chanukah","8":"Numbers 28:9 - 28:15 | Shabbat Rosh Chodesh Chanukah","7":"Genesis 43:30 - 44:17","6":"Genesis 43:16 - 43:29","torah":"Genesis 41:1 - 44:17","3":"Genesis 41:39 - 41:52","1":"Genesis 41:1 - 41:14","5":"Genesis 42:19 - 43:15"},"hebrew":"פרשת מקץ","date":"2018-12-08","category":"parashat","title":"Parashat Miketz","link":"https://www.hebcal.com/sedrot/miketz"},{"category":"roshchodesh","link":"https://www.hebcal.com/holidays/rosh-chodesh-tevet","title":"Rosh Chodesh Tevet","hebrew":"ראש חודש טבת","date":"2018-12-08","memo":"Beginning of new Hebrew month of Tevet"},{"category":"holiday","subcat":"major","title":"Chanukah: 7 Candles","link":"https://www.hebcal.com/holidays/chanukah","hebrew":"חנוכה: ז׳ נרות","memo":"The Jewish festival of rededication, also known as the Festival of Lights","date":"2018-12-08"},{"link":"https://www.hebcal.com/holidays/rosh-chodesh-tevet","title":"Rosh Chodesh Tevet","category":"roshchodesh","date":"2018-12-09","memo":"Beginning of new Hebrew month of Tevet","hebrew":"ראש חודש טבת"},{"title":"Chanukah: 8 Candles","link":"https://www.hebcal.com/holidays/chanukah","subcat":"major","category":"holiday","date":"2018-12-09","memo":"The Jewish festival of rededication, also known as the Festival of Lights","hebrew":"חנוכה: ח׳ נרות"},{"hebrew":"חנוכה: יום ח׳","date":"2018-12-10","memo":"The Jewish festival of rededication, also known as the Festival of Lights","category":"holiday","subcat":"major","link":"https://www.hebcal.com/holidays/chanukah","title":"Chanukah: 8th Day"},{"leyning":{"4":"Genesis 45:19 - 45:27","maftir":"Genesis 47:25 - 47:27","2":"Genesis 44:31 - 45:7","haftarah":"Ezekiel 37:15 - 37:28","7":"Genesis 47:11 - 47:27","3":"Genesis 45:8 - 45:18","torah":"Genesis 44:18 - 47:27","6":"Genesis 46:28 - 47:10","5":"Genesis 45:28 - 46:27","1":"Genesis 44:18 - 44:30"},"hebrew":"פרשת ויגש","date":"2018-12-15","category":"parashat","link":"https://www.hebcal.com/sedrot/vayigash","title":"Parashat Vayigash"},{"category":"holiday","subcat":"fast","link":"https://www.hebcal.com/holidays/asara-btevet","title":"Asara B'Tevet","hebrew":"עשרה בטבת","memo":"Fast commemorating the siege of Jerusalem","date":"2018-12-18"},{"title":"Parashat Vayechi","link":"https://www.hebcal.com/sedrot/vayechi","category":"parashat","date":"2018-12-22","leyning":{"3":"Genesis 48:17 - 48:22","6":"Genesis 49:27 - 50:20","torah":"Genesis 47:28 - 50:26","5":"Genesis 49:19 - 49:26","1":"Genesis 47:28 - 48:9","4":"Genesis 49:1 - 49:18","maftir":"Genesis 50:23 - 50:26","haftarah":"I Kings 2:1 - 2:12","2":"Genesis 48:10 - 48:16","7":"Genesis 50:21 - 50:26"},"hebrew":"פרשת ויחי"},{"link":"https://www.hebcal.com/sedrot/shemot","title":"Parashat Shemot","category":"parashat","date":"2018-12-29","hebrew":"פרשת שמות","leyning":{"3":"Exodus 2:11 - 2:25","6":"Exodus 4:18 - 4:31","torah":"Exodus 1:1 - 6:1","5":"Exodus 3:16 - 4:17","1":"Exodus 1:1 - 1:17","maftir":"Exodus 5:22 - 6:1","4":"Exodus 3:1 - 3:15","2":"Exodus 1:18 - 2:10","haftarah":"Isaiah 27:6 - 28:13; 29:22 - 29:23","7":"Exodus 5:1 - 6:1"}}]
     * link : http://www.hebcal.com/hebcal/?v=1;i=on;maj=on;min=on;mod=on;nx=on;year=2018;month=x;ss=on;mf=on;c=off;geo=none;s=on;o=on
     * title : Hebcal 2018
     */

    private String date;
    private LocationBean location;
    private String link;
    private String title;
    private List<ItemsBean> items;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class LocationBean {
        /**
         * geo : none
         */

        private String geo;

        public String getGeo() {
            return geo;
        }

        public void setGeo(String geo) {
            this.geo = geo;
        }
    }

    public static class ItemsBean {
        /**
         * leyning : {"torah":"Exodus 1:1 - 6:1","6":"Exodus 4:18 - 4:31","3":"Exodus 2:11 - 2:25","1":"Exodus 1:1 - 1:17","5":"Exodus 3:16 - 4:17","2":"Exodus 1:18 - 2:10","4":"Exodus 3:1 - 3:15","maftir":"Exodus 5:22 - 6:1","haftarah":"Isaiah 27:6 - 28:13; 29:22 - 29:23","7":"Exodus 5:1 - 6:1"}
         * hebrew : פרשת שמות
         * date : 2018-01-06
         * category : parashat
         * link : https://www.hebcal.com/sedrot/shemot
         * title : Parashat Shemot
         * memo : Beginning of new Hebrew month of Sh'vat
         * subcat : minor
         * yomtov : true
         */

        private LeyningBean leyning;
        private String hebrew;
        private String date;
        private String category;
        private String link;
        private String title;
        private String memo;
        private String subcat;
        private boolean yomtov;

        public LeyningBean getLeyning() {
            return leyning;
        }

        public void setLeyning(LeyningBean leyning) {
            this.leyning = leyning;
        }

        public String getHebrew() {
            return hebrew;
        }

        public void setHebrew(String hebrew) {
            this.hebrew = hebrew;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getSubcat() {
            return subcat;
        }

        public void setSubcat(String subcat) {
            this.subcat = subcat;
        }

        public boolean isYomtov() {
            return yomtov;
        }

        public void setYomtov(boolean yomtov) {
            this.yomtov = yomtov;
        }

        public static class LeyningBean {
            /**
             * torah : Exodus 1:1 - 6:1
             * 6 : Exodus 4:18 - 4:31
             * 3 : Exodus 2:11 - 2:25
             * 1 : Exodus 1:1 - 1:17
             * 5 : Exodus 3:16 - 4:17
             * 2 : Exodus 1:18 - 2:10
             * 4 : Exodus 3:1 - 3:15
             * maftir : Exodus 5:22 - 6:1
             * haftarah : Isaiah 27:6 - 28:13; 29:22 - 29:23
             * 7 : Exodus 5:1 - 6:1
             */

            private String torah;
            @SerializedName("6")
            private String _$6;
            @SerializedName("3")
            private String _$3;
            @SerializedName("1")
            private String _$1;
            @SerializedName("5")
            private String _$5;
            @SerializedName("2")
            private String _$2;
            @SerializedName("4")
            private String _$4;
            private String maftir;
            private String haftarah;
            @SerializedName("7")
            private String _$7;

            public String getTorah() {
                return torah;
            }

            public void setTorah(String torah) {
                this.torah = torah;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String getMaftir() {
                return maftir;
            }

            public void setMaftir(String maftir) {
                this.maftir = maftir;
            }

            public String getHaftarah() {
                return haftarah;
            }

            public void setHaftarah(String haftarah) {
                this.haftarah = haftarah;
            }

            public String get_$7() {
                return _$7;
            }

            public void set_$7(String _$7) {
                this._$7 = _$7;
            }
        }
    }
}
