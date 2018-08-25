package com.reformluach.utils;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reformluach.R;
import com.reformluach.fragments.AboutFragment;
import com.reformluach.fragments.CalenderSyncFragment;
import com.reformluach.fragments.DashboardFragment;
import com.reformluach.fragments.DateConverterFragment;
import com.reformluach.fragments.EventAllTabFragment;
import com.reformluach.fragments.EventsFragment;
import com.reformluach.fragments.EventsHolidaysChildFragment;
import com.reformluach.fragments.EventsParshiyotChildFragment;
import com.reformluach.fragments.TodaysFragment;
import com.reformluach.models.CustomEventsList;
import com.reformluach.models.ParseIsraelItemBean;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

//Controller centralized call calling in whole application extended Application
public class Controller extends Application {
    public static final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    private static Controller sInstance;
    private ProgressDialog pDialog;
    private ViewsChanges viewsChanges = new ViewsChanges();
    private TodaysFragment todaysFragment;
    private EventsFragment eventsFragment;
    private CalenderSyncFragment calenderSyncFragment;
    private DateConverterFragment dateConverterFragment;
    private AboutFragment aboutFragment;
//    private EventsHolidaysChildFragment eventsHolidaysChildFragment;
//    private EventsParshiyotChildFragment eventsParshiyotChildFragment;
//    private EventAllTabFragment eventRoshChildFragment;
    private DashboardFragment dashboardFragment;
    private CentralisedReplacer centralisedReplacer = new CentralisedReplacer();
    private SharedPreferenceFileAll sharedPreferenceFileAll;
    private Date date = new Date();
    private Animationall animationall = new Animationall();

    public static void adjustFontScale(Context context, Configuration configuration) {
        if (configuration.fontScale != 1) {
            configuration.fontScale = 1;
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(metrics);
            metrics.scaledDensity = configuration.fontScale * metrics.density;
            context.getResources().updateConfiguration(configuration, metrics);
        }
    }

    public static void hide_keyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    // Typeface Setup
    public static Typeface setRobotoBoldFont(Context context) {
        Typeface typeLobster = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        return typeLobster;
    }

    public static void setFragment(Fragment fragment, boolean removeStack, AppCompatActivity activity, FrameLayout mContainer) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction ftTransaction = fragmentManager.beginTransaction();
        if (removeStack) {
            fragmentManager.popBackStack((String) null, 1);
            ftTransaction.replace(mContainer.getId(), fragment);
        } else {
            ftTransaction.replace(mContainer.getId(), fragment);
            ftTransaction.addToBackStack(fragment.getTag());
        }
        ftTransaction.commit();
    }

    public static Typeface setRobotoRegularFont(Context context) {
        Typeface typeLobster = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        return typeLobster;
    }

    public static Typeface setRobotoThinFont(Context context) {
        Typeface typeLobster = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");
        return typeLobster;
    }

    public static Typeface setLightFont(Context context) {
        Typeface typeLobster = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        return typeLobster;
    }

    public static Typeface setMediumFont(Context context) {
        Typeface typeLobster = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
        return typeLobster;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        return !(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable());
    }

    public static void savePreferencesString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferencesString(Activity context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, "");
    }

    public static boolean checkCalendarPermissions(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_CALENDAR);
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CALENDAR);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestCalenderPermissions(Activity activity, int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CALENDAR) || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CALENDAR)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_CALENDAR, Manifest.permission.READ_CALENDAR}, REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_CALENDAR, Manifest.permission.READ_CALENDAR}, REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        }
    }

    public static Date closerDate(Date originalDate, Collection<Date> unsortedDates) {
        List<Date> dateList = new LinkedList<Date>(unsortedDates);
        Collections.sort(dateList);
        Iterator<Date> iterator = dateList.iterator();
        Date previousDate = null;
        while (iterator.hasNext()) {
            Date nextDate = iterator.next();
            if (nextDate.before(originalDate)) {
                previousDate = nextDate;
                continue;
            } else if (nextDate.after(originalDate)) {
                if (previousDate == null || isCloserToNextDate(originalDate, previousDate, nextDate)) {
                    return nextDate;
                }
            } else {
                return nextDate;
            }
        }
        return previousDate;
    }

    private static boolean isCloserToNextDate(Date originalDate, Date previousDate, Date nextDate) {
        if (previousDate.after(nextDate))
            throw new IllegalArgumentException("previousDate > nextDate");
        return ((nextDate.getTime() - previousDate.getTime()) / 2 + previousDate.getTime() <= originalDate.getTime());
    }

    public void animationForward(Context context) {
        animationall.Animallforward(context);
    }

    public void animationBackward(Context context) {
        animationall.Animallbackward(context);
    }

    public void ShowProgressBar() {
        pDialog = new ProgressDialog(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = Controller.this;
        sInstance.ShowProgressBar();
        sInstance.initFragments();
    }

    public Object getFragmentInstance(int type) {
        switch (type) {
            case 0:
                return todaysFragment;
            case 1:
                return eventsFragment;
            case 2:
                return calenderSyncFragment;
            case 3:
                return dateConverterFragment;
            case 4:
                return aboutFragment;
            /*case 5:
                return eventsParshiyotChildFragment;
            case 6:
                return eventsHolidaysChildFragment;
            case 7:
                return eventRoshChildFragment;*/
            case 8:
                return dashboardFragment;
            default:
                return dashboardFragment;
        }
    }

    public void initFragments() {
        todaysFragment = new TodaysFragment();
        eventsFragment = new EventsFragment();
        calenderSyncFragment = new CalenderSyncFragment();
        dateConverterFragment = new DateConverterFragment();
        aboutFragment = new AboutFragment();
//        eventsParshiyotChildFragment = new EventsParshiyotChildFragment();
//        eventsHolidaysChildFragment = new EventsHolidaysChildFragment();
//        eventRoshChildFragment = new EventAllTabFragment();
        dashboardFragment = new DashboardFragment();
    }

    public void imageBackgroundChange(ImageView imageView, int res) {
        viewsChanges.imageBackgroundChange(imageView, res);
    }

    public void textColorChange(TextView textView, int color, Context context) {
        viewsChanges.textColorChange(textView, color, context);
    }

    public void fragmentReplacer(Object... args) {
        centralisedReplacer.replaceFragment(args);
    }

    public void bottomBarShowHide(LinearLayout bottomBar, int type) {
        if (bottomBar != null) {
            switch (type) {
                case 0:
                    if (bottomBar.getVisibility() != View.GONE) {
                        bottomBar.setVisibility(View.GONE);
                    }
                    break;
                case 1:
                    if (bottomBar.getVisibility() != View.VISIBLE) {
                        bottomBar.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }
    }

    //Start Progress Dialog
    public void PdStart(Context context, String message, int colorProgressDialogText) {
        //
        pDialog = new ProgressDialog(context);
        try {
            try {
                pDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (WindowManager.BadTokenException e) {
            Log.e("Except", "Except" + e);
        }
        try {
            pDialog.setCancelable(false);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setContentView(R.layout.progress_dailog);
            TextView progressDialogText = (TextView) pDialog.findViewById(R.id.progressdialog_text);
            progressDialogText.setText(message);
            progressDialogText.setTextColor(ContextCompat.getColor(context, colorProgressDialogText));
        } catch (Exception e) {
            Log.e("Exception_error", "Exception_error" + e);
        }
    }

    //Stop Progress Dialog
    public void PdStop() {
        if (pDialog != null) {
            pDialog.dismiss();
        }
    }

    public static int getMonth() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.get(Calendar.MONTH);
        Log.e("Month Selected", "Month Selected" + calendar.get(Calendar.MONTH));
        return calendar.get(Calendar.MONTH);
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.get(Calendar.YEAR);
        Log.e("YEAR Selected", "YEAR Selected" + calendar.get(Calendar.YEAR));
        return calendar.get(Calendar.YEAR);
    }

    public ArrayList getArayList() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(TAG, null);
        Type type = new TypeToken<ArrayList<CustomEventsList>>() {
        }.getType();
        ArrayList<CustomEventsList> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public ArrayList getEventsList() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPrefs.getString(TAG, null);
        Type type = new TypeToken<ArrayList<ParseIsraelItemBean>>() {
        }.getType();
        ArrayList<ParseIsraelItemBean> arrayList = gson.fromJson(json, type);
        return arrayList;
    }
    public void setArayList(ArrayList<CustomEventsList> arrayList) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(TAG, json);
        editor.commit();
    }

    public int getDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.get(Calendar.DATE);
        Log.e("DATE Selected", "DATE Selected" + calendar.get(Calendar.DATE));
        return calendar.get(Calendar.DATE);
    }

    public Date getCurrentDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("M/d/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(String.valueOf(date));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    public String getDateF() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatt = new SimpleDateFormat("M/d/yyyy");
        String currentdate = formatt.format(c.getTime());
        return currentdate;
    }

    public Date stringToDate(String stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
        Date dateObject = null;
        try {
            dateObject = format.parse(stringDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateObject);
        return dateObject;
    }

    public String dateToString(Date stringDate) {
        Format dformat = new SimpleDateFormat("M/d/yyyy");
        String dateString = null;
       /* Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);*/
        dateString = dformat.format(stringDate);
        //System.out.println(dateObject);
        return dateString;
    }

    public long getTimestamp(String eventdate) {
        DateFormat formatter = new SimpleDateFormat("M/d/yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(eventdate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        long output = date.getTime() / 1000L;
        String str = Long.toString(output);
        long timestamp = Long.parseLong(str) * 1000;
        return timestamp;
    }

    public boolean compareDates(String subscriptionEndDate, String currentdate, Context context) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            Date subscriptionEndDateinDateFormat = null;
            try {
                subscriptionEndDateinDateFormat = sdf.parse(subscriptionEndDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            Date currentdateInDateFormat = null;
            try {
                currentdateInDateFormat = sdf.parse(currentdate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            if (subscriptionEndDateinDateFormat.equals(currentdateInDateFormat)) {
                return true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Date closestDate() {
        final long now = System.currentTimeMillis();
        // Create a sample list of dates
        List<Date> dates = new ArrayList<Date>();
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            dates.add(new Date(now + r.nextInt(10000) - 5000));
        // Get date closest to "now"
        Date closest = Collections.min(dates, new Comparator<Date>() {
            public int compare(Date d1, Date d2) {
                long diff1 = Math.abs(d1.getTime() - now);
                long diff2 = Math.abs(d2.getTime() - now);
                return Long.compare(diff1, diff2);
            }
        });
        return closest;
    }

    public long getUtcTimeInMillis(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        // getInstance() provides TZ info which can be used to adjust to UTC
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // Get timezone offset then use it to adjust the return value
        int offset = cal.getTimeZone().getOffset(cal.getTimeInMillis());
        return cal.getTimeInMillis() + offset - 19800000;
    }

    public long getUtcTimeInMillisEvents(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        // getInstance() provides TZ info which can be used to adjust to UTC
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // Get timezone offset then use it to adjust the return value
        int offset = cal.getTimeZone().getOffset(cal.getTimeInMillis());
        return cal.getTimeInMillis() + offset - 19800000;
    }
}