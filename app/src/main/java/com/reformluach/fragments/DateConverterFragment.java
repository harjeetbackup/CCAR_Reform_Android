package com.reformluach.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.reformluach.R;
import com.reformluach.activities.CustomEventsUtilityListActivity;
import com.reformluach.services.RequestURL;
import com.reformluach.services.ServiceAsync;
import com.reformluach.services.ServiceStatus;
import com.reformluach.services.ServicesResponse;
import com.reformluach.utils.Controller;
import com.reformluach.utils.HintSpinner;

/**
 * Created by Naveen Mishra on 11/30/2017.
 */
public class DateConverterFragment extends Fragment implements View.OnClickListener {
    static final String[] Months = new String[]{"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final String[] MonthsHebrew = new String[]{"MONTH", "Nisan", "Iyyar", "Sivan", "Tamuz", "Av", "Elul", "Tishrei", "Cheshvan", "Kislev", "Tevet", "Sh'vat", "Adar"};
    static final String[] Date = new String[]{"DAY", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static final String[] Year = new String[]{"YEAR", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    static final String[] YearHebrew = new String[]{"YEAR", "5685", "5686", "5687", "5688", "5689", "5690", "5691", "5692", "5693", "5694", "5695", "5696", "5697", "5698", "5699", "5700", "5701", "5702", "5703", "5704", "5705", "5706", "5707", "5708", "5709", "5710", "5711", "5712", "5713", "5714", "5715", "5716", "5717", "5718", "5719", "5720", "5721", "5722", "5723", "5724", "5725", "5726", "5727", "5728", "5729", "5730", "5731", "5732", "5733", "5734", "5735", "5736", "5737", "5738", "5739", "5740", "5741", "5742", "5743", "5744", "5745", "5746", "5747", "5748", "5749", "5750", "5751", "5752", "5753", "5754", "5755", "5756", "5757", "5758", "5759", "5760", "5761", "5762", "5763", "5764", "5765", "5766", "5767", "5768", "5769", "5770", "5771", "5772", "5773", "5774", "5775", "5776", "5777", "5778", "5779", "5780", "5781", "5782", "5783", "5784", "5785", "5786", "5787", "5788", "5789", "5790", "5791", "5792", "5793", "5794", "5795", "5796", "5797", "5798", "5799", "5800", "5801", "5802", "5803", "5804", "5805", "5806", "5807", "5808", "5809", "5810", "5811"};
    private View dateConverterFragmentView;
    private Context context;
    private HintSpinner spMonth, spYear, spDay;
    private ImageView ivArrow;
    private TextView tvAdd, tvYear, tvMonth, tvDate, tvConvert;
    private Controller controller;
    private boolean hebrew = false;
    private RadioButton rbAfter, rbBefore;
    private LinearLayout llMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dateConverterFragmentView = getView() != null ? getView() : inflater.inflate(R.layout.dateconverter_fragment_layout, container, false);
        context = dateConverterFragmentView.getContext();
        controller = (Controller) context.getApplicationContext();
        getIds(dateConverterFragmentView);
        return dateConverterFragmentView;
    }

    private int getMonthInt(String month) {
        if (month.equalsIgnoreCase("January")) {
            return 1;
        } else if (month.equalsIgnoreCase("February")) {
            return 2;
        } else if (month.equalsIgnoreCase("March")) {
            return 3;
        } else if (month.equalsIgnoreCase("April")) {
            return 4;
        } else if (month.equalsIgnoreCase("May")) {
            return 5;
        } else if (month.equalsIgnoreCase("June")) {
            return 6;
        } else if (month.equalsIgnoreCase("July")) {
            return 7;
        } else if (month.equalsIgnoreCase("August")) {
            return 8;
        } else if (month.equalsIgnoreCase("September")) {
            return 9;
        } else if (month.equalsIgnoreCase("October")) {
            return 10;
        } else if (month.equalsIgnoreCase("November")) {
            return 11;
        } else if (month.equalsIgnoreCase("December")) {
            return 12;
        }
        return 0;
    }

    private void getIds(View dateConverterFragmentView) {
        spMonth = dateConverterFragmentView.findViewById(R.id.spMonth);
        spYear = dateConverterFragmentView.findViewById(R.id.spYear);
        spDay = dateConverterFragmentView.findViewById(R.id.spDay);
        ivArrow = dateConverterFragmentView.findViewById(R.id.ivArrow);
        tvAdd = dateConverterFragmentView.findViewById(R.id.tvAdd);
        tvDate = dateConverterFragmentView.findViewById(R.id.tvDate);
        tvMonth = dateConverterFragmentView.findViewById(R.id.tvMonth);
        tvConvert = dateConverterFragmentView.findViewById(R.id.tvConvert);
        tvYear = dateConverterFragmentView.findViewById(R.id.tvYear);
        rbBefore = dateConverterFragmentView.findViewById(R.id.rbBefore);
        rbAfter = dateConverterFragmentView.findViewById(R.id.rbAfter);
        llMain = dateConverterFragmentView.findViewById(R.id.llMain);
        setBgAccordingToMonth(controller.getMonth());
        tvConvert.setOnClickListener(this);
        ivArrow.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        rbBefore.setChecked(true);
        ivArrow.setImageResource(R.mipmap.arr);
        setSpinnerGreToHeb();
    }

    private void callApiGreToHeb(int month, final int date, final int year) {
        //  month=month+1;
        ServiceAsync serviceAsync = new ServiceAsync(context, "", RequestURL.BASE_URL + "gy=" + year + "&gm=" + month + "&gd=" + date + "&g2h=1", RequestURL.GET, new ServiceStatus() {
            @Override
            public void onSuccess(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                tvDate.setText(String.valueOf(servicesResponse.hd));
                tvMonth.setText(String.valueOf(servicesResponse.hm));
                tvYear.setText(String.valueOf(servicesResponse.hy));
            }

            @Override
            public void onFailed(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                Toast.makeText(context, servicesResponse.responseMessage, Toast.LENGTH_SHORT).show();
            }
        });
        serviceAsync.execute("");
    }

    private void callApiHebToGre(String month, final int date, final int year) {
        //   month=month+1;
        ServiceAsync serviceAsync = new ServiceAsync(context, "", RequestURL.BASE_URL + "hy=" + year + "&hm=" + month + "&hd=" + date + "&h2g=1", RequestURL.GET, new ServiceStatus() {
            @Override
            public void onSuccess(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                tvDate.setText(String.valueOf(servicesResponse.gd));
                tvMonth.setText(String.valueOf(servicesResponse.gm));
                tvYear.setText(String.valueOf(servicesResponse.gy));
            }

            @Override
            public void onFailed(Object o) {
                ServicesResponse servicesResponse = (ServicesResponse) o;
                Toast.makeText(context, servicesResponse.responseMessage, Toast.LENGTH_SHORT).show();
            }
        });
        serviceAsync.execute("");
    }

    private void setSpinnerGreToHeb() {
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(context, R.layout.spinner_layout, Months);
        adapterMonth.setDropDownViewResource(R.layout.spinner_layout);
        spMonth.setAdapter(adapterMonth);
        spMonth.setSelection(0);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(context, R.layout.spinner_layout, Year);
        adapterYear.setDropDownViewResource(R.layout.spinner_layout);
        spYear.setAdapter(adapterYear);
        spYear.setSelection(0);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay.setDropDownViewResource(R.layout.spinner_layout);
        spDay.setAdapter(adapterDay);
        spDay.setSelection(0);
    }

    private void setSpinnerHebToGre() {
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(context, R.layout.spinner_layout, MonthsHebrew);
        adapterMonth.setDropDownViewResource(R.layout.spinner_layout);
        spMonth.setAdapter(adapterMonth);
        spMonth.setSelection(0);
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(context, R.layout.spinner_layout, YearHebrew);
        adapterYear.setDropDownViewResource(R.layout.spinner_layout);
        spYear.setAdapter(adapterYear);
        spYear.setSelection(0);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(context, R.layout.spinner_layout, Date);
        adapterDay.setDropDownViewResource(R.layout.spinner_layout);
        spDay.setAdapter(adapterDay);
        spDay.setSelection(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvConvert:
                validate();
                break;
            case R.id.ivArrow:
                if (!hebrew) {
                    hebrew = true;
                    setSpinnerHebToGre();
                    ivArrow.setImageResource(R.mipmap.left);
                } else {
                    hebrew = false;
                    setSpinnerGreToHeb();
                    ivArrow.setImageResource(R.mipmap.arr);
                }
                break;
            case R.id.tvAdd:
                Intent intent = new Intent(context, CustomEventsUtilityListActivity.class);
                intent.putExtra("day", spDay.getSelectedItemPosition());
                intent.putExtra("month", spMonth.getSelectedItemPosition());
                intent.putExtra("year", spYear.getSelectedItemPosition());
                if (rbAfter.isChecked()) {
                    intent.putExtra("sunset", true);
                } else {
                    intent.putExtra("sunset", false);
                }
                startActivity(intent);
                break;
        }
    }

    private boolean validate() {
        if (spMonth.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_month), Toast.LENGTH_SHORT).show();
            return false;
        } else if (spDay.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_day), Toast.LENGTH_SHORT).show();
            return false;
        } else if (spYear.getSelectedItemPosition() == 0) {
            Toast.makeText(context, getString(R.string.please_select_year), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (hebrew) {
                if (rbAfter.isChecked()) {
                    if (controller.isOnline(context)) {
                        int dayHtoG = Integer.parseInt(spDay.getSelectedItem().toString()) + 1;
                        String monthHtoG = spMonth.getSelectedItem().toString();
                        int yearHtoG = Integer.parseInt(spYear.getSelectedItem().toString());
                        callApiHebToGre(monthHtoG, dayHtoG, yearHtoG);
                    } else {
                        Toast.makeText(context, getString(R.string.please_check_internet), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (controller.isOnline(context)) {
                        int dayHtoG = Integer.parseInt(spDay.getSelectedItem().toString());
                        String monthHtoG = spMonth.getSelectedItem().toString();
                        int yearHtoG = Integer.parseInt(spYear.getSelectedItem().toString());
                        callApiHebToGre(monthHtoG, dayHtoG, yearHtoG);
                    } else {
                        Toast.makeText(context, getString(R.string.please_check_internet), Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                if (rbAfter.isChecked()) {
                    int dayGtoH = Integer.parseInt(spDay.getSelectedItem().toString()) + 1;
                    int monthGtoH = getMonthInt(spMonth.getSelectedItem().toString());
                    int yearGtoH = Integer.parseInt(spYear.getSelectedItem().toString());
                    if (controller.isOnline(context)) {
                        callApiGreToHeb(monthGtoH, dayGtoH, yearGtoH);
                    } else {
                        Toast.makeText(context, getString(R.string.please_check_internet), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    int dayGtoH = Integer.parseInt(spDay.getSelectedItem().toString());
                    int monthGtoH = getMonthInt(spMonth.getSelectedItem().toString());
                    int yearGtoH = Integer.parseInt(spYear.getSelectedItem().toString());
                    if (controller.isOnline(context)) {
                        callApiGreToHeb(monthGtoH, dayGtoH, yearGtoH);
                    } else {
                        Toast.makeText(context, getString(R.string.please_check_internet), Toast.LENGTH_SHORT).show();
                    }
                }
            }
            spMonth.setSelection(0);
            spDay.setSelection(0);
            spYear.setSelection(0);
            return true;
        }
    }

    private void setBgAccordingToMonth(int month) {
        switch (month + 1) {
            case 1:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.jansss));
                break;
            case 2:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.febsss));
                break;
            case 3:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.marsss));
                break;
            case 4:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.aprsss));
                break;
            case 5:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.maysss));
                break;
            case 6:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.junsss));
                break;
            case 7:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.julsss));
                break;
            case 8:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.augsss));
                break;
            case 9:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.sepsss));
                break;
            case 10:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.octsss));
                break;
            case 11:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.novsss));
                break;
            case 12:
                llMain.setBackground(ContextCompat.getDrawable(context, R.mipmap.decsss));
                break;
        }
    }
}
