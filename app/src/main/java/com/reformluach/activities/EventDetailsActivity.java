package com.reformluach.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import com.reformluach.R;
import com.reformluach.utils.Controller;

import java.util.Calendar;
import java.util.Date;

public class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Controller controller;
    private ImageView ivCross;
    private WebView wvDetails;
    private String eventType, eventName;
    private Context context;

//    private String startDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        context = this;
        controller = (Controller) context.getApplicationContext();
        if (getIntent() != null) {
            eventType = getIntent().getStringExtra("eventType");
            eventName = getIntent().getStringExtra("eventName");
//            startDate = getIntent().getStringExtra("startDate");
        }
        getIds();
    }

    private void getIds() {
        ivCross = findViewById(R.id.ivCross);
        wvDetails = findViewById(R.id.wvDetails);
        loadHtml();
        ivCross.setOnClickListener(this);
    }
    private void loadHtml() {
        if (eventType.contains("Todays")) {
            if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                wvDetails.loadUrl("file:///android_asset/Acharei_Mot.html");
            } else if (eventName.contains("Parashat Behar-Bechukotai")) {
                wvDetails.loadUrl("file:///android_asset/B'chukotai.html");
            } else if (eventName.contains("Parashat Beha'alotcha")) {
                wvDetails.loadUrl("file:///android_asset/B'haalot'cha.html");
            } else if (eventName.contains("chukotai") || eventName.contains("har")) {
                wvDetails.loadUrl("file:///android_asset/B'har-B'chukotai.html");
            } else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                wvDetails.loadUrl("file:///android_asset/B'har.html");
            } else if (eventName.contains("Parashat Bamidbar")) {
                wvDetails.loadUrl("file:///android_asset/B'midbar.html");
            } else if (eventName.contains("Parashat Bereshit")) {
                wvDetails.loadUrl("file:///android_asset/B'reishit.html");
            } else if (eventName.contains("Parashat Beshalach") || eventName.contains("Beshalach")) {
                wvDetails.loadUrl("file:///android_asset/B'shalach.html");
            } else if (eventName.contains("Balak")) {
                wvDetails.loadUrl("file:///android_asset/Balak.html");
            } else if (eventName.contains("Bo")) {
                wvDetails.loadUrl("file:///android_asset/Bo.html");
            } else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                wvDetails.loadUrl("file:///android_asset/Chayei_Sara.html");
            } else if (eventName.contains("Chukat-Balak")) {
                wvDetails.loadUrl("file:///android_asset/Chukat-Balak.html");
            } else if (eventName.contains("Chukat")) {
                wvDetails.loadUrl("file:///android_asset/Chukat.html");
            } else if (eventName.contains("Parashat Devarim") || eventType.contains("Devarim")) {
                wvDetails.loadUrl("file:///android_asset/D'varim.html");
            } else if (eventName.contains("Eikev")) {
                wvDetails.loadUrl("file:///android_asset/Eikev.html");
            } else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                wvDetails.loadUrl("file:///android_asset/Emor.html");
            } else if (eventName.contains("Parashat Ha'Azinu")) {
                wvDetails.loadUrl("file:///android_asset/Haazinu.html");
            } else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                wvDetails.loadUrl("file:///android_asset/K'doshim.html");
            } else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Tavo.html");
            } else if (eventName.contains("Ki_Teitzei") || eventName.contains("Teitzei")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Teitzei.html");
            } else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Tisa.html");
            } else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                wvDetails.loadUrl("file:///android_asset/Korach.html");
            } else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                wvDetails.loadUrl("file:///android_asset/Lech_L'cha.html");
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                wvDetails.loadUrl("file:///android_asset/M'tzora.html");
            } else if (eventName.contains("Parashat Matot-Masei")) {
                wvDetails.loadUrl("file:///android_asset/Matot-Mas-ei.html");
            } else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                wvDetails.loadUrl("file:///android_asset/Mas-ei.html");
            } else if (eventName.contains("Matot")) {
                wvDetails.loadUrl("file:///android_asset/Matot.html");
            } else if (eventName.contains("Mikeitz-2")) {
                wvDetails.loadUrl("file:///android_asset/Mikeitz-2.html");
            } else if (eventName.contains("Mikeitz") || eventName.contains("Miketz")) {
                wvDetails.loadUrl("file:///android_asset/Mikeitz.html");
            } else if (eventName.contains("Mishpatim")) {
                wvDetails.loadUrl("file:///android_asset/Mishpatim.html");
            } else if (eventName.contains("Parashat Nasso")) {
                wvDetails.loadUrl("file:///android_asset/Naso.html");
            } else if (eventName.contains("Nitzavim-Vayeilech")) {
                wvDetails.loadUrl("file:///android_asset/Nitzavim-Vayeilech.html");
            } else if (eventName.contains("Nitzavim")) {
                wvDetails.loadUrl("file:///android_asset/Nitzavim.html");
            } else if (eventName.contains("Parashat Noach")) {
                wvDetails.loadUrl("file:///android_asset/Noach.html");
            } else if (eventName.contains("Parashat Vayakhel-Pekudei") || eventName.contains("Vayakhel-Pekudei")) {
                wvDetails.loadUrl("file:///android_asset/P'kudei.html");
            } else if (eventName.contains("Pinchas")) {
                wvDetails.loadUrl("file:///android_asset/Pinchas.html");
            } else if (eventName.contains("R'eih")) {
                wvDetails.loadUrl("file:///android_asset/R'eih.html");
            } else if (eventName.contains("Sh'lach")) {
                wvDetails.loadUrl("file:///android_asset/Sh'lach_L'cha.html");
            } else if (eventName.contains("Shmini")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mini.html");
            } else if (eventName.contains("Shemot")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mot.html");
            } else if (eventName.contains("Shoftim")) {
                wvDetails.loadUrl("file:///android_asset/Shof'tim.html");
            } else if (eventName.contains("Terumah")) {
                wvDetails.loadUrl("file:///android_asset/T'rumah.html");
            } else if (eventName.contains("Tetzaveh")) {
                wvDetails.loadUrl("file:///android_asset/T'tzaveh.html");
            } else if (eventName.contains("Tazria-M'tzora")) {
                wvDetails.loadUrl("file:///android_asset/Tazria-M'tzora.html");
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                wvDetails.loadUrl("file:///android_asset/Tazria.html");
            } else if (eventName.contains("Toldot")) {
                wvDetails.loadUrl("file:///android_asset/Tol'dot.html");
            } else if (eventName.contains("Tzav")) {
                wvDetails.loadUrl("file:///android_asset/Tzav.html");
            } else if (eventName.contains("rachah")) {
                wvDetails.loadUrl("file:///android_asset/V'zot_Hab'rachah.html");
            } else if (eventName.contains("Vaera")) {
                wvDetails.loadUrl("file:///android_asset/Va-eira.html");
            } else if (eventName.contains("Vaetchanan")) {
                wvDetails.loadUrl("file:///android_asset/Va-et'chanan.html");
            } else if (eventName.contains("Vayechi")) {
                wvDetails.loadUrl("file:///android_asset/Va-y'chi.html");
            } else if (eventName.contains("Vayakhel")) {
                wvDetails.loadUrl("file:///android_asset/Vayak'heil.html");
            } else if (eventName.contains("Vayak’heil-P’kudei")) {
                wvDetails.loadUrl("file:///android_asset/Vayak’heil-P’kudei.html");
            } else if (eventName.contains("Vayeilech")) {
                wvDetails.loadUrl("file:///android_asset/Vayeilech.html");
            } else if (eventName.contains("Vayeira")) {
                wvDetails.loadUrl("file:///android_asset/Vayeira.html");
            } else if (eventName.contains("Vayera") || eventName.contains("Vayeira")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
            } else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
                wvDetails.loadUrl("file:///android_asset/Vayeishev.html");
            } else if (eventName.contains("Vayeitzei") || eventName.contains("Vayetzei")) {
                wvDetails.loadUrl("file:///android_asset/Vayeitzei.html");
            } else if (eventName.contains("Vayigash")) {
                wvDetails.loadUrl("file:///android_asset/Vayigash.html");
            } else if (eventName.contains("Vayikra")) {
                wvDetails.loadUrl("file:///android_asset/Vayikra.html");
            } else if (eventName.contains("Vayishlach")) {
                wvDetails.loadUrl("file:///android_asset/Vayishlach.html");
            } else if (eventName.contains("Parashat Re'eh") || eventName.contains("Re'eh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
            } else if (eventName.contains("Rosh Chodesh Adar")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Adar_I.html");
            } else if (eventName.contains("Rosh Chodesh Av")) {
                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Av.html");
            } else if (eventName.contains("Rosh Chodesh Elul")) {
                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Elul.html");
            } else if (eventName.contains("Rosh Chodesh Cheshvan") || (eventName.contains("Erev Rosh Hashanah Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Rosh Chodesh Cheshvan.html");
            } else if (eventName.contains("Asara B'Tevet")) {
                wvDetails.loadUrl("file:///android_asset/Asara_B'Tevet.html");
            } else if (eventName.contains("Aseret Y'mei T'shuva")) {
                wvDetails.loadUrl("file:///android_asset/Aseret_Y'mei_T'shuva.html");
            } else if (eventName.contains("B'dikat and Biur Chametz")) {
                wvDetails.loadUrl("file:///android_asset/B'dikat_and_Biur_Chametz.html");
            } else if (eventName.contains("Erev Chanukah")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_1_Weekday.html");
            } else if (eventName.contains("Chanukah: 2 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_2_Weekday.html");
            } else if (eventName.contains("Chanukah: 3 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_3_Weekday.html");
            } else if (eventName.contains("Chanukah: 4 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_4_Weekday.html");
            } else if (eventName.contains("Chanukah: 5 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_5_Weekday.html");
            } else if (eventName.contains("Chanukah: 6 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_6_Weekday.html");
            } else if (eventName.contains("Chanukah: 7 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_7_Weekday.html");
            } else if (eventName.contains("Chanukah 8 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday_Rosh_Chodesh _Tevet_1.html");
            } else if (eventName.contains("Chanukah: 8 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday.html");
            } else if (eventName.contains("Counting the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            } else if (eventName.contains("Erev Chanukah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Chanukah.html");
            } else if (eventName.contains("Erev Pesach")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot.html");
            } else if (eventName.contains("Erev Pesach/Ta'anit Bechorot Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot_Friday.html");
            } else if (eventName.contains("Erev Purim")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Purim.html");
            } else if (eventName.contains("Erev Rosh Hashanah Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Friday.html");
            } else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Weekday.html");
            } else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html");
            } else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Simchat_Torah.html");
            } else if (eventName.contains("Erev Shavuot Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot_Friday.html");
            } else if (eventName.contains("Erev Shavuot")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot.html");
            } else if (eventName.contains("Erev Tisha b'Av")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Tisha_b'Av.html");
            } else if (eventName.contains("Erev Yom Kippur Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Yom_Kippur.html");
            } else if (eventName.contains("Hoshana Raba")) {
                wvDetails.loadUrl("file:///android_asset/Hoshana_Raba.html");
            } else if (eventName.contains("Lag BaOmer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            } else if (eventName.contains("Leil Selichot")) {
                wvDetails.loadUrl("file:///android_asset/Leil_Selichot.html");
            } else if (eventName.contains("Machar Chodesh")) {
                wvDetails.loadUrl("file:///android_asset/Machar_Chodesh.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 2")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_3.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 1")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_2.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 3")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_4.html");
            } else if (eventName.contains("Pesach I")) {

                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_1.html");
                } else if (eventName.contains("Pesach Chol Hamoed Day 4")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Friday.html");
            } else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Weekday.html");
            } else if (eventName.contains("Pesach_Day_1")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Shabbat.html");
            } else if (eventName.contains("Pesach VIII")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Weekday.html");
            } else if (eventName.contains("Pesach_Day_7")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7_Shabbat.html");
            } else if (eventName.contains("Pesach VII")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7.html");
            } else if (eventName.contains("Pesach Sheini")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Sheini.html");
            } else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan"))) {
                wvDetails.loadUrl("file:///android_asset/Purim_Katan.html");
            } else if (eventName.contains("Purim")) {
                wvDetails.loadUrl("file:///android_asset/Purim.html");
            } else if (eventName.contains("Rosh Hashana I")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_1.html");
            } else if (eventName.contains("Rosh Hashanah 2")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_2.html");
            } else if (eventName.contains("Sh'mini Atzeret-Simchat Torah")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mini_Atzeret-Simchat_Torah.html");
            } else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot-K'doshim.html");
            } else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot.html");
            } else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'chukotai.html");
            } else if ((eventName.contains("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'ha'alot'cha.html");
            } else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har-B'chukotai.html");
            } else if (eventName.contains("Shabbat B'har")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har.html");
            } else if (eventName.contains("Shabbat B'reishit")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'reishit.html");
            } else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'shalach-Shabbat_Shirah.html");
            } else if (eventName.contains("Shabbat Balak")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Balak.html");
            } else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Bamidbar.html");
            } else if (eventName.contains("Shabbat Bo")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Bo.html");
            } else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah_Rosh_Chodesh.html");
            } else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah.html");
            } else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chayei_Sara.html");
            } else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_HaMoed_Pesach.html");
            } else if (eventName.contains("Shabbat Chol Hamoed Sukkot")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_Hamoed_Sukkot_Friday.html");
            } else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat-Balak.html");
            } else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat.html");
            } else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_D'varim-Shabbat_Chazon.html");
            } else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Eikev.html");
            } else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Emor.html");
            } else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu-Shabbat_Shuva.html");
            } else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu.html");
            } else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_HaChodesh.html");
            } else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_HaGadol.html");
            } else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_K'doshim.html");
            } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tavo.html");
            } else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Teitze.html");
            } else if (eventName.contains("Shabbat Ki Tisa")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tisa.html");
            } else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Korach.html");
            } else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Lech_L'cha.html");
            } else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_M'tzora.html");
            } else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_M'varchim.html");
            } else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Mas'ei.html");
            } else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot-Mas'ei.html");
            } else if (eventName.contains("Shabbat Matot")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot.html");
            } else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Mishpatim.html");
            } else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim_Vayeilech.html");
            } else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim.html");
            } else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Naso.html");
            } else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Noach.html");
            } else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_P'kudei.html");
            } else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Parah.html");
            } else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Pinchas.html");
            } else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
            } else if ((eventName.contains("Shabbat Rosh Chodesh I")) || (eventName.contains("Rosh")) || (eventName.contains("Chodesh_I"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Rosh_Chodesh_I.html");
            } else if (eventName.contains("Shabbat Sh'kalim")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'kalim.html");
            } else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mini.html");
            } else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mot.html");
            } else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Shoftim.html");
            } else if (eventName.contains("Shabbat Trumah")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_T'rumah.html");
            } else if (eventName.contains("tzaveh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_T'tzaveh.html");
            } else if (eventName.contains("tzora")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria-M'tzora.html");
            } else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria.html");
            } else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Toldot.html");
            } else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tzav.html");
            } else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_V'etchanan-Nachamu.html");
            } else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Va'eira.html");
            } else if (eventName.contains("habbat Vay'chi")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vay'chi.html");
            } else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayakheil.html");
            } else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeilech.html");
            } else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
            } else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeishev.html");
            } else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeitzei.html");
            } else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayigash.html");
            } else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayikra.html");
            } else if (eventName.contains("Shabbat Vayishlach")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayishlach.html");
            } else if (eventName.contains("Shabbat Yitro")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Yitro.html");
            } else if (eventName.contains("Shabbat Zachor")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Zachor.html");
            } else if (eventName.contains("Shavuot Shabbat")) {
                wvDetails.loadUrl("file:///android_asset/Shavuot_Shabbat.html");
            } else if (eventName.contains("Shavuot I")) {
                wvDetails.loadUrl("file:///android_asset/Shavuot.html");
            } else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz"))) {
                wvDetails.loadUrl("file:///android_asset/Shiva_Asar_b'Tammuz.html");
            } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim"))) {
                wvDetails.loadUrl("file:///android_asset/Shushan_Purim.html");
            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Shabbat"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Shabbat.html");
            } else if ((eventName.contains("Sukkot_1")) || (eventName.contains("Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
            } else if ((eventName.contains("Sukkot_2")) || (eventName.contains("Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
            } else if ((eventName.contains("Sukkot_3")) || (eventName.contains("Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
            } else if (((eventName.contains("Sukkot_4")) || (eventName.contains("Weekday")))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
            } else if ((eventName.contains("Sukkot_5")) || (eventName.contains("Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
            } else if ((eventName.contains("Sukkot_6")) || (eventName.contains("Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
            } else if ((eventName.contains("Sukkot")) || (eventName.contains("Preparation"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Bechorot"))) {
                wvDetails.loadUrl("file:///android_asset/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html");
            } else if ((eventName.contains("Ta")) || (eventName.contains("anit_Esther"))) {
                wvDetails.loadUrl("file:///android_asset/Ta'anit_Esther.html");
            } else if (eventName.contains("Tisha b'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tisha b'Av.html");
            } else if (eventName.contains("Tisha B'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tisha_B'Av.html");
            } else if (eventName.contains("Tu B'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tu_B'Av.html");
            } else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat"))) {
                wvDetails.loadUrl("file:///android_asset/Tu_B'Sh'vat.html");
            } else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah"))) {
                wvDetails.loadUrl("file:///android_asset/Tzom_Gedaliah.html");
            } else if (eventName.contains("Yom Ha'atzma'ut")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Ha'atzma'ut.html");
            } else if (eventName.contains("Yom HaShoah V'hag'vurah")) {
                wvDetails.loadUrl("file:///android_asset/Yom_HaShoah_V'hag'vurah.html");
            } else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
                wvDetails.loadUrl("file:///android_asset/Yom_HaZikaron.html");
            } else if (eventName.contains("Yom Kippur Shabbat")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Kippur_Shabbat.html");
            } else if (eventName.contains("Yom Kippur")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Kippur.html");
            } else if (eventName.contains("Yom Yerushalayim")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Yerushalayim.html");
            } else if (eventName.contains("Erev Sukkot")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sukkot.html");
            } else if (eventName.contains("Sukkot I")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
            } else if (eventName.contains("Sukkot 2 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
            } else if (eventName.contains("Sukkot 3 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
            } else if (eventName.contains("Sukkot 4 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
            } else if (eventName.contains("Sukkot 5 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
            } else if (eventName.contains("Sukkot 6 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
            } else if (eventName.contains("Hoshana Raba")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
            } else {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html");
            }
        } else if (eventType.contains("parashat")) {
            if (eventName.contains("Mot") || eventName.contains("Acharei") || eventName.contains("Acharei_Mot")) {
                wvDetails.loadUrl("file:///android_asset/Acharei_Mot.html");
            } else if (eventName.contains("Parashat B'har/B'chukotai")) {
                wvDetails.loadUrl("file:///android_asset/B'chukotai.html");
            } else if (eventName.contains("Parashat B'haalot'cha")) {
                wvDetails.loadUrl("file:///android_asset/B'haalot'cha.html");
            } else if (eventName.contains("chukotai") || eventName.contains("har")) {
                wvDetails.loadUrl("file:///android_asset/B'har-B'chukotai.html");
            } else if (eventName.contains("Parashat Behar-Bechukotai") || eventName.contains("Parashat Behar")) {
                wvDetails.loadUrl("file:///android_asset/B'har.html");
            } else if (eventName.contains("Parashat B'midbar")) {
                wvDetails.loadUrl("file:///android_asset/B'midbar.html");
            } else if (eventName.contains("Parashat B'reishit")) {
                wvDetails.loadUrl("file:///android_asset/B'reishit.html");
            } else if (eventName.contains("Parashat B'shalach") || eventName.contains("B'shalach")) {
                wvDetails.loadUrl("file:///android_asset/B'shalach.html");
            } else if (eventName.contains("Balak")) {
                wvDetails.loadUrl("file:///android_asset/Balak.html");
            } else if (eventName.contains("Bo")) {
                wvDetails.loadUrl("file:///android_asset/Bo.html");
            } else if (eventName.contains("Chayei_Sara") || eventName.contains("Sara") || (eventName.contains("Chayei"))) {
                wvDetails.loadUrl("file:///android_asset/Chayei_Sara.html");
            } else if (eventName.contains("Chukat-Balak")) {
                wvDetails.loadUrl("file:///android_asset/Chukat-Balak.html");
            } else if (eventName.contains("Chukat")) {
                wvDetails.loadUrl("file:///android_asset/Chukat.html");
            } else if (eventName.contains("Parashat D'varim") || eventType.contains("Devarim")) {
                wvDetails.loadUrl("file:///android_asset/D'varim.html");
            } else if (eventName.contains("Eikev")) {
                wvDetails.loadUrl("file:///android_asset/Eikev.html");
            } else if (eventName.contains("Emor") || eventName.contains("Parashat Emor")) {
                wvDetails.loadUrl("file:///android_asset/Emor.html");
            } else if (eventName.contains("Parashat Ha'Azinu")) {
                wvDetails.loadUrl("file:///android_asset/Haazinu.html");
            } else if (eventName.contains("Parashat Kedoshim") || eventName.contains("Kedoshim")) {
                wvDetails.loadUrl("file:///android_asset/K'doshim.html");
            } else if (eventName.contains("Ki_Tavo") || eventName.contains("Tavo")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Tavo.html");
            } else if (eventName.contains("Ki Teitzei") || eventName.contains("Teitzei")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Teitzei.html");
            } else if (eventName.contains("Ki_Tisa") || eventName.contains("Tisa")) {
                wvDetails.loadUrl("file:///android_asset/Ki_Tisa.html");
            } else if (eventName.contains("Parashat Korach") || eventName.contains("Korach")) {
                wvDetails.loadUrl("file:///android_asset/Korach.html");
            } else if (eventName.contains("Lech_L'cha") || eventName.contains("Lech") || (eventName.contains("cha"))) {
                wvDetails.loadUrl("file:///android_asset/Lech_L'cha.html");
            } else if (eventName.contains("Parashat Tazria/M'tzora")) {
                wvDetails.loadUrl("file:///android_asset/M'tzora.html");
            } else if (eventName.contains("Parashat Matot-Masei")) {
                wvDetails.loadUrl("file:///android_asset/Matot-Mas-ei.html");
            } else if (eventName.contains("Parashat Matot-Masei") || eventName.contains("Matot-Masei")) {
                wvDetails.loadUrl("file:///android_asset/Mas-ei.html");
            } else if (eventName.contains("Matot")) {
                wvDetails.loadUrl("file:///android_asset/Matot.html");
            } else if (eventName.contains("Mikeitz-2")) {
                wvDetails.loadUrl("file:///android_asset/Mikeitz-2.html");
            } else if (eventName.contains("Mikeitz") || eventName.contains("Mikeitz")) {
                wvDetails.loadUrl("file:///android_asset/Mikeitz.html");
            } else if (eventName.contains("Mishpatim")) {
                wvDetails.loadUrl("file:///android_asset/Mishpatim.html");
            } else if (eventName.contains("Parashat Naso")) {
                wvDetails.loadUrl("file:///android_asset/Naso.html");
            } else if (eventName.contains("Nitzavim/Vayeilech")) {
                wvDetails.loadUrl("file:///android_asset/Nitzavim-Vayeilech.html");
            } else if (eventName.contains("Nitzavim")) {
                wvDetails.loadUrl("file:///android_asset/Nitzavim.html");
            } else if (eventName.contains("Parashat Noach")) {
                wvDetails.loadUrl("file:///android_asset/Noach.html");
            } else if (eventName.contains("Parashat Vayak’heil/P’kudei") || eventName.contains("Vayakhel-Pekudei")) {
                wvDetails.loadUrl("file:///android_asset/P'kudei.html");
            } else if (eventName.contains("Pinchas")) {
                wvDetails.loadUrl("file:///android_asset/Pinchas.html");
            } else if (eventName.contains("R'eih")) {
                wvDetails.loadUrl("file:///android_asset/R'eih.html");
            } else if (eventName.contains("Sh'lach L'cha")) {
                wvDetails.loadUrl("file:///android_asset/Sh'lach_L'cha.html");
            } else if (eventName.contains("Sh'mini")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mini.html");
            } else if (eventName.contains("Sh'mot")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mot.html");
            } else if (eventName.contains("Shof'tim")) {
                wvDetails.loadUrl("file:///android_asset/Shof'tim.html");
            } else if (eventName.contains("T'rumah")) {
                wvDetails.loadUrl("file:///android_asset/T'rumah.html");
            } else if (eventName.contains("T'tzaveh")) {
                wvDetails.loadUrl("file:///android_asset/T'tzaveh.html");
            } else if (eventName.contains("Tazria-M'tzora")) {
                wvDetails.loadUrl("file:///android_asset/Tazria-M'tzora.html");
            } else if (eventName.contains("Parashat Tazria-Metzora")) {
                wvDetails.loadUrl("file:///android_asset/Tazria.html");
            } else if (eventName.contains("Parashat Tazria")) {
                wvDetails.loadUrl("file:///android_asset/Tazria-M'tzora.html");
            } else if (eventName.contains("Tol'dot")) {
                wvDetails.loadUrl("file:///android_asset/Tol'dot.html");
            } else if (eventName.contains("Tzav")) {
                wvDetails.loadUrl("file:///android_asset/Tzav.html");
            } else if (eventName.contains("rachah")) {
                wvDetails.loadUrl("file:///android_asset/V'zot_Hab'rachah.html");
            } else if (eventName.contains("Va-eira")) {
                wvDetails.loadUrl("file:///android_asset/Va-eira.html");
            } else if (eventName.contains("Va-et'chanan")) {
                wvDetails.loadUrl("file:///android_asset/Va-et'chanan.html");
            } else if (eventName.contains("Va-y'chi")) {
                wvDetails.loadUrl("file:///android_asset/Va-y'chi.html");
            } else if (eventName.contains("Vayak'heil")) {
                wvDetails.loadUrl("file:///android_asset/Vayak'heil.html");
            } else if (eventName.contains("Vayak’heil-P’kudei")) {
                wvDetails.loadUrl("file:///android_asset/Vayak’heil-P’kudei.html");
            } else if (eventName.contains("Vayeilech")) {
                wvDetails.loadUrl("file:///android_asset/Vayeilech.html");
            } else if (eventName.contains("Vayeira")) {
                wvDetails.loadUrl("file:///android_asset/Vayeira.html");
            } else if (eventName.contains("Vayeira") || eventName.contains("Vayeira")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
            } else if (eventName.contains("Vayeishev") || eventName.contains("Vayeshev")) {
                wvDetails.loadUrl("file:///android_asset/Vayeishev.html");
            } else if (eventName.contains("Vayeitzei") || eventName.contains("Vayeitzei")) {
                wvDetails.loadUrl("file:///android_asset/Vayeitzei.html");
            } else if (eventName.contains("Vayigash")) {
                wvDetails.loadUrl("file:///android_asset/Vayigash.html");
            } else if (eventName.contains("Vayikra")) {
                wvDetails.loadUrl("file:///android_asset/Vayikra.html");
            } else if (eventName.contains("Vayishlach")) {
                wvDetails.loadUrl("file:///android_asset/Vayishlach.html");
            } else if (eventName.contains("Parashat R'eih") || eventName.contains("Re'eh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
            } else {
                wvDetails.loadUrl("file:///android_asset/Yitro.html");
            }
//        } else if (eventType.contains("Holidays")) {
        } else if (eventType.contains("holiday")) {

            if (eventName.contains("Asara B'Tevet")) {
                wvDetails.loadUrl("file:///android_asset/Asara_B'Tevet.html");
            } else if (eventName.contains("Aseret Y'mei T'shuva")) {
                wvDetails.loadUrl("file:///android_asset/Aseret_Y'mei_T'shuva.html");
            } else if (eventName.contains("B'dikat and Biur Chametz")) {
                wvDetails.loadUrl("file:///android_asset/B'dikat_and_Biur_Chametz.html");
            } else if (eventName.contains("Erev Chanukah")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_1_Weekday.html");
            } else if (eventName.contains("Chanukah: 2 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_2_Weekday.html");
            } else if (eventName.contains("Chanukah: 3 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_3_Weekday.html");
            } else if (eventName.contains("Chanukah: 4 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_4_Weekday.html");
            } else if (eventName.contains("Chanukah: 5 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_5_Weekday.html");
            } else if (eventName.contains("Chanukah: 6 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_6_Weekday.html");
            } else if (eventName.contains("Chanukah: 7 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_7_Weekday.html");
            } else if (eventName.contains("Chanukah 8 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday_Rosh_Chodesh _Tevet_1.html");
            } else if (eventName.contains("Chanukah: 8 Candles")) {
                wvDetails.loadUrl("file:///android_asset/Chanukah_8_Weekday.html");
            } else if (eventName.contains("Counting the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            } else if (eventName.contains("Erev Chanukah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Chanukah.html");
            } else if (eventName.contains("Erev Pesach")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot.html");
            } else if (eventName.contains("Erev Pesach/Ta'anit Bechorot Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Pesach-Ta'anit_Bechorot_Friday.html");
            } else if (eventName.contains("Erev Purim")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Purim.html");
            } else if (eventName.contains("Erev Rosh Hashanah Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Friday.html");
            } else if ((eventName.contains("Rosh Hashana 5778")) || (eventName.contains("Hashanah_Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Erev_Rosh_Hashanah_Weekday.html");
            } else if (eventName.contains("Erev Sh'mini Atzeret-Erev Simchat_Torah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Erev_Simchat_Torah_Friday.html");
            } else if (eventName.contains("Erev Sh'mini Atzeret-Simchat Torah")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sh'mini_Atzeret-Simchat_Torah.html");
            } else if (eventName.contains("Erev Shavuot Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot_Friday.html");
            } else if (eventName.contains("Erev Shavuot")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Shavuot.html");
            } else if (eventName.contains("Erev Tisha b'Av")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Tisha_b'Av.html");
            } else if (eventName.contains("Erev Yom Kippur Friday")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Yom_Kippur.html");
            } else if (eventName.contains("Hoshana Raba")) {
                wvDetails.loadUrl("file:///android_asset/Hoshana_Raba.html");
            } else if (eventName.contains("Lag BaOmer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            } else if (eventName.contains("Leil Selichot")) {
                wvDetails.loadUrl("file:///android_asset/Leil_Selichot.html");
            } else if (eventName.contains("Machar Chodesh")) {
                wvDetails.loadUrl("file:///android_asset/Machar_Chodesh.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 2")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_3.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 1")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_2.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 3")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_4.html");
            } else if (eventName.contains("Pesach I")) {

//                Date d1 = new Date(startDate);
//
//                Calendar c1 = Calendar.getInstance();
////                c1.setTime(d1);
////                System.out.println(c1.get(Calendar.DAY_OF_WEEK));
//
//                if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)){
//                    wvDetails.loadUrl("file:///android_asset/Pesach I Shabbat.html");
//                }else {
                    wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_1.html");

//                }

//                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_1.html");
            } else if (eventName.contains("Pesach Chol Hamoed Day 4")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Friday.html");
            } else if (eventName.contains("Pesach Chol HaMoed Day 5 Friday")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Chol_Hamoed_Day_5_Weekday.html");
            } else if (eventName.contains("Pesach_Day_1")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Shabbat.html");
            } else if (eventName.contains("Pesach VIII")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_1_Weekday.html");
            } else if (eventName.contains("Pesach_Day_7")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7_Shabbat.html");
            } else if (eventName.contains("Pesach VII")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Day_7.html");
            } else if (eventName.contains("Pesach Sheini")) {
                wvDetails.loadUrl("file:///android_asset/Pesach_Sheini.html");
            } else if ((eventName.contains("Purim Katan")) || (eventName.contains("Katan"))) {
                wvDetails.loadUrl("file:///android_asset/Purim_Katan.html");
            } else if (eventName.contains("Purim")) {
                wvDetails.loadUrl("file:///android_asset/Purim.html");
            } else if (eventName.contains("Rosh Hashana I")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_1.html");
            } else if (eventName.contains("Rosh Hashanah 2")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Hashanah_2.html");
            } else if (eventName.contains("Sh'mini Atzeret-Simchat Torah")) {
                wvDetails.loadUrl("file:///android_asset/Sh'mini_Atzeret-Simchat_Torah.html");
            } else if ((eventName.contains("Shabbat Acharei Mot-K'doshim")) || (eventName.contains("Acharei")) || (eventName.contains("K'doshim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot-K'doshim.html");
            } else if ((eventName.contains("Shabbat Acharei_Mot")) || (eventName.contains("Acharei Mot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Acharei_Mot.html");
            } else if ((eventName.contains("Shabbat B'chukotai")) || (eventName.contains("chukotai"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'chukotai.html");
            } else if ((eventName.contains("Shabbat B'ha'alot'cha")) || (eventName.contains("ha")) || (eventName.contains("alot")) || (eventName.contains("cha"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'ha'alot'cha.html");
            } else if ((eventName.contains("Shabbat B'har-B'chukotai")) || (eventName.contains("chukotai"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har-B'chukotai.html");
            } else if (eventName.contains("Shabbat B'har")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'har.html");
            } else if (eventName.contains("Shabbat B'reishit")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'reishit.html");
            } else if ((eventName.contains("Shabbat B'shalach-Shabbat Shirah")) || (eventName.contains("shalach-Shabbat_Shirah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_B'shalach-Shabbat_Shirah.html");
            } else if (eventName.contains("Shabbat Balak")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Balak.html");
            } else if ((eventName.contains("Shabbat Bamidbar")) || (eventName.contains("Bamidbar"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Bamidbar.html");
            } else if (eventName.contains("Shabbat Bo")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Bo.html");
            } else if (eventName.contains("Shabbat Chanukah Rosh Chodesh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah_Rosh_Chodesh.html");
            } else if ((eventName.contains("Shabbat Chanukah")) || (eventName.contains("Chanukah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chanukah.html");
            } else if ((eventName.contains("Shabbat Chayei Sara")) || (eventName.contains("Chayei Sara"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chayei_Sara.html");
            } else if ((eventName.contains("Shabbat Chol HaMoed Pesach")) || (eventName.contains("HaMoed Pesach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_HaMoed_Pesach.html");
            } else if (eventName.contains("Shabbat Chol Hamoed Sukkot")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chol_Hamoed_Sukkot_Friday.html");
            } else if ((eventName.contains("Parashat Chukat")) || (eventName.contains("Chukat"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat-Balak.html");
            } else if ((eventName.contains("Shabbat Chukat")) || (eventName.contains("Chukat"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Chukat.html");
            } else if ((eventName.contains("Shabbat D'varim-Shabbat Chazon")) || (eventName.contains("varim")) || (eventName.contains("Shabbat_Chazon"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_D'varim-Shabbat_Chazon.html");
            } else if ((eventName.contains("Shabbat Eikev")) || (eventName.contains("Eikev"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Eikev.html");
            } else if ((eventName.contains("Shabbat Emor")) || (eventName.contains("Emor"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Emor.html");
            } else if ((eventName.contains("Shabbat Ha'azinu-Shabbat Shuva")) || (eventName.contains("Shabbat_Shuva")) || (eventName.contains("azinu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu-Shabbat_Shuva.html");
            } else if ((eventName.contains("Shabbat Ha'azinu")) || (eventName.contains("azinu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ha'azinu.html");
            } else if ((eventName.contains("Shabbat HaChodesh")) || (eventName.contains("HaChodesh"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_HaChodesh.html");
            } else if ((eventName.contains("Shabbat HaGadol")) || (eventName.contains("HaGadol"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_HaGadol.html");
            } else if ((eventName.contains("Shabbat K'doshim")) || (eventName.contains("doshim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_K'doshim.html");
            } else if ((eventName.contains("Shabbat Ki Tavo")) || (eventName.contains("Ki_Tavo"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tavo.html");
            } else if ((eventName.contains("Shabbat Ki Teitze")) || (eventName.contains("Teitze"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Teitze.html");
            } else if (eventName.contains("Shabbat Ki Tisa")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Ki_Tisa.html");
            } else if ((eventName.contains("Shabbat Korach")) || (eventName.contains("Korach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Korach.html");
            } else if ((eventName.contains("Shabbat Lech L'cha")) || (eventName.contains("Lech_L'cha"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Lech_L'cha.html");
            } else if ((eventName.contains("Shabbat M'tzora")) || (eventName.contains("M'tzora"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_M'tzora.html");
            } else if ((eventName.contains("Shabbat M'varchim")) || (eventName.contains("varchim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_M'varchim.html");
            } else if ((eventName.contains("Shabbat Mas'ei")) || (eventName.contains("Mas'ei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Mas'ei.html");
            } else if ((eventName.contains("Shabbat Matot-Mas'ei")) || (eventName.contains("Matot Mas'ei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot-Mas'ei.html");
            } else if (eventName.contains("Shabbat Matot")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Matot.html");
            } else if ((eventName.contains("Shabbat Mishpatim")) || (eventName.contains("Mishpatim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Mishpatim.html");
            } else if ((eventName.contains("Shabbat N'tzavim Vayeilech")) || (eventName.contains("tzavim_Vayeilech"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim_Vayeilech.html");
            } else if ((eventName.contains("Shabbat N'tzavim")) || (eventName.contains("N'tzavim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_N'tzavim.html");
            } else if ((eventName.contains("Shabbat Naso")) || (eventName.contains("Naso"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Naso.html");
            } else if ((eventName.contains("Shabbat Noach")) || (eventName.contains("Noach"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Noach.html");
            } else if ((eventName.contains("Shabbat P'kudei")) || (eventName.contains("kudei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_P'kudei.html");
            } else if ((eventName.contains("Shabbat Parah")) || (eventName.contains("Parah"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Parah.html");
            } else if ((eventName.contains("Shabbat Pinchas")) || (eventName.contains("Pinchas"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Pinchas.html");
            } else if ((eventName.contains("Parashat Re'eh")) || (eventName.contains("Re'eh"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Re'eh.html");
            } else if ((eventName.contains("Shabbat Rosh Chodesh I")) || (eventName.contains("Rosh")) || (eventName.contains("Chodesh_I"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Rosh_Chodesh_I.html");
            } else if (eventName.contains("Shabbat Sh'kalim")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'kalim.html");
            } else if ((eventName.contains("Shabbat Sh'mini")) || (eventName.contains("mini"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mini.html");
            } else if ((eventName.contains("Shabbat Sh'mot")) || (eventName.contains("mot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Sh'mot.html");
            } else if ((eventName.contains("Shabbat Shoftim")) || (eventName.contains("Shoftim"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Shoftim.html");
            } else if (eventName.contains("Shabbat Trumah")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_T'rumah.html");
            } else if (eventName.contains("tzaveh")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_T'tzaveh.html");
            } else if (eventName.contains("tzora")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria-M'tzora.html");
            } else if ((eventName.contains("Shabbat Tazria")) || (eventName.contains("Tazria"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tazria.html");
            } else if ((eventName.contains("Shabbat Toldot")) || (eventName.contains(" Toldot"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Toldot.html");
            } else if ((eventName.contains("Shabbat Tzav")) || (eventName.contains("Tzav"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Tzav.html");
            } else if ((eventName.contains("Shabbat V'etchanan-Nachamu")) || (eventName.contains("etchanan-Nachamu"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_V'etchanan-Nachamu.html");
            } else if ((eventName.contains("Shabbat Va'eira")) || (eventName.contains("eira"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Va'eira.html");
            } else if (eventName.contains("habbat Vay'chi")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vay'chi.html");
            } else if ((eventName.contains("Shabbat Vayakheil")) || (eventName.contains("Vayakheil"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayakheil.html");
            } else if ((eventName.contains("Shabbat Vayeilech")) || (eventName.contains("Vayeilech"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeilech.html");
            } else if ((eventName.contains("Shabbat Vayeira")) || (eventName.contains("Vayeira"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeira.html");
            } else if ((eventName.contains("Shabbat Vayeishev")) || (eventName.contains("Vayeishev"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeishev.html");
            } else if ((eventName.contains("Shabbat Vayeitzei")) || (eventName.contains("Vayeitzei"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayeitzei.html");
            } else if ((eventName.contains("Shabbat Vayigash")) || (eventName.contains("Vayigash"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayigash.html");
            } else if ((eventName.contains("Shabbat Vayikra")) || (eventName.contains("Vayikra"))) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayikra.html");
            } else if (eventName.contains("Shabbat Vayishlach")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Vayishlach.html");
            } else if (eventName.contains("Shabbat Yitro")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Yitro.html");
            } else if (eventName.contains("Shabbat Zachor")) {
                wvDetails.loadUrl("file:///android_asset/Shabbat_Zachor.html");
            } else if (eventName.contains("Shavuot Shabbat")) {
                wvDetails.loadUrl("file:///android_asset/Shavuot_Shabbat.html");
            } else if (eventName.contains("Shavuot I")) {
                wvDetails.loadUrl("file:///android_asset/Shavuot.html");
            } else if ((eventName.contains("Shiva")) || (eventName.contains("Tammuz"))) {
                wvDetails.loadUrl("file:///android_asset/Shiva_Asar_b'Tammuz.html");
            } else if ((eventName.contains("Shushan")) || (eventName.contains("Shushan Purim"))) {
                wvDetails.loadUrl("file:///android_asset/Shushan_Purim.html");
            } else if ((eventName.contains("Sukkot 1")) || (eventName.contains("Shabbat"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Shabbat.html");
            } else if ((eventName.contains("Sukkot 1")) ) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
            } else if ((eventName.contains("Sukkot_2")) ) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
            } else if ((eventName.contains("Sukkot_3")) ) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
            } else if (((eventName.contains("Sukkot_4")) )) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
            } else if ((eventName.contains("Sukkot_5")) ) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
            } else if ((eventName.contains("Sukkot_6"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
            } else if ((eventName.contains("Preparation"))) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
            } else if ((eventName.contains("Ta")) && (eventName.contains("anit_Bechorot"))) {
                wvDetails.loadUrl("file:///android_asset/Ta'anit_Bechorot-B'dikat_Chametz_Thursday.html");
            } else if ((eventName.contains("Ta")) && (eventName.contains("anit_Esther"))) {
                wvDetails.loadUrl("file:///android_asset/Ta'anit_Esther.html");
            } else if (eventName.contains("Tisha b'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tisha b'Av.html");
            } else if (eventName.contains("Tisha B'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tisha_B'Av.html");
            } else if (eventName.contains("Tu B'Av")) {
                wvDetails.loadUrl("file:///android_asset/Tu_B'Av.html");
            } else if ((eventName.contains("Tu B'Sh'vat")) || (eventName.contains("BiShvat"))) {
                wvDetails.loadUrl("file:///android_asset/Tu_B'Sh'vat.html");
            } else if ((eventName.contains("Tzom")) || (eventName.contains("Gedaliah"))) {
                wvDetails.loadUrl("file:///android_asset/Tzom_Gedaliah.html");
            } else if (eventName.contains("Yom Ha'atzma'ut")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Ha'atzma'ut.html");
            } else if (eventName.contains("Yom HaShoah V'hag'vurah")) {
                wvDetails.loadUrl("file:///android_asset/Yom_HaShoah_V'hag'vurah.html");
            } else if (eventName.contains("Yom HaZikaron") || (eventName.contains("HaZikaron"))) {
                wvDetails.loadUrl("file:///android_asset/Yom_HaZikaron.html");
            } else if (eventName.contains("Yom Kippur Shabbat")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Kippur_Shabbat.html");
            } else if (eventName.contains("Yom Kippur")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Kippur.html");
            } else if (eventName.contains("Yom Yerushalayim")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Yerushalayim.html");
            } else if (eventName.contains("Erev Sukkot")) {
                wvDetails.loadUrl("file:///android_asset/Erev_Sukkot.html");
            } else if (eventName.contains("Sukkot I")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_1_Weekday.html");
            } else if (eventName.contains("Sukkot 2 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_2_Weekday.html");
            } else if (eventName.contains("Sukkot 3 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_3_Weekday.html");
            } else if (eventName.contains("Sukkot 4 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_4_Weekday.html");
            } else if (eventName.contains("Sukkot 5 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_5_Weekday.html");
            } else if (eventName.contains("Sukkot 6 Weekday")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_6_Weekday.html");
            } else if (eventName.contains("Hoshana Raba")) {
                wvDetails.loadUrl("file:///android_asset/Sukkot_Preparation.html");
            } else if (eventName.contains("Yom")) {
                wvDetails.loadUrl("file:///android_asset/Yom_Ha'atzma'ut.html");
            } else if (eventName.contains("Sigd")) {
                wvDetails.loadUrl("file:///android_asset/Asara_B'Tevet.html");
            }
//        } else if (eventType.contains("Rosh")) {
        } else if (eventType.contains("roshchodesh")) {
            if (eventName.contains("Rosh Chodesh Adar")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Adar_I.html");
            } else if (eventName.contains("Rosh Chodesh Av")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Av.html");
            } else if (eventName.contains("Rosh Chodesh Elul")) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Elul.html");
            } else if (eventName.contains("Rosh Chodesh Cheshvan") || (eventName.contains("Erev Rosh Hashanah Weekday"))) {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_Cheshvan.html");
            } else {
                wvDetails.loadUrl("file:///android_asset/Rosh_Chodesh_II_or_One_Day_Rosh_Chodesh_Weekday.html");
            }
        }else if (eventType.contains("omer")){
            if (eventName.contains("15th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("15th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("16th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("17th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("18th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("19th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("20th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("21th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("22th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("23th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("24th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("25th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("26th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("27th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("28th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("29th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("30th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("31th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("32th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("34th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("35th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("36th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("37th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("38th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("39th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("40th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("41th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("42th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("43th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("44th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("45th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("46th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("47th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("48th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }else  if (eventName.contains("49th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Counting_the_Omer.html");
            }
            else  if (eventName.contains("33rd day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("14th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("1st day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("2nd day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("3rd day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("4th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("5th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("6th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("7th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("8th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("9th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("10th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("11th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("12th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }else  if (eventName.contains("13th day of the Omer")) {
                wvDetails.loadUrl("file:///android_asset/Lag_Ba'Omer.html");
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCross:
                finish();
                break;
        }
    }
}
