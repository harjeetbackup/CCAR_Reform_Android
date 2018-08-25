package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.EventTitle;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.typeface.CustomtextViewFontRegular;
import com.reformluach.utils.AppDateUtil;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HolidaysEventRecyclerAdapter extends RecyclerView.Adapter<HolidaysEventRecyclerAdapter.ViewHolder>{

    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;

    private EventsIsraelAdapter.ReloadAllDataListener reloadAllDataListener;


    public HolidaysEventRecyclerAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.mPopulatingData = data;
        mAllActualData = new ArrayList<>(mPopulatingData);
    }

    @Override
    public HolidaysEventRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_rosh, parent, false);
        return new HolidaysEventRecyclerAdapter.ViewHolder(view);
    }

    private String getDay(String date_in_string_format){
        DateFormat df = DateFormat.getDateInstance();
        Date date;
        try {
            date = df.parse(date_in_string_format);
        } catch (Exception e) {
            Log.e("Error:","Exception " + e);
            return null;
        }
        return new SimpleDateFormat("EEEE").format(date);
    }

    private Date getDateFromSpecificFormat(String dateStr, SimpleDateFormat sdf) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    private int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // return cal.get(Calendar.MONTH)-1;
        return cal.get(Calendar.MONTH);
    }

    private int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onBindViewHolder(final HolidaysEventRecyclerAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = mPopulatingData.get(position);

        if (model==null){
            return;
        }
        String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);


//        SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            Date date = inFormat.parse(model.getDate());
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
//            String day = days[calendar.get(Calendar.DAY_OF_WEEK)];
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String dateStr = "";
        if (mAllActualData.size() > 0) {
            dateStr = model.getDate();
        } else {
//            long currentTimeInMillis = System.currentTimeMillis();
//            Date date = new Date(currentTimeInMillis);
//            dateStr = sdf.format(date);
            dateStr = "01" ;
        }
        String my = dateStr.substring(2, dateStr.length());

        String monthDateFromFirstDay = "01" + my;

        Date date = getDateFromSpecificFormat(monthDateFromFirstDay, sdf);

        // Uncomment following line, in case it should start from first selected date.


        int iYear = getYear(date);
        int iMonth = getMonth(date);
        int iDay = 1;
//// Create a calendar object and set year and month
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        final String dayOfMonth = String.valueOf(mycal.get(Calendar.DAY_OF_WEEK));

        if (dayOfMonth.equals("6")){
            holder.tvEventName.setText(title+" Friday");
        }
        if (dayOfMonth.equals("7")){
            holder.tvEventName.setText(title+" Saturday");
        }

        final int positionList = holder.getAdapterPosition();

        ArrayList<ParseIsraelItemBean> parashatEventsData = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> shabbatEventsData = new ArrayList<>();

        for (int i=0;i<mAllActualData.size();i++) {

            ParseIsraelItemBean filteredEvents = mAllActualData.get(i);

            if (filteredEvents.getTitle().startsWith("Parashat")) {
                parashatEventsData.add(filteredEvents);

                Log.i("", "" + parashatEventsData.size());
            }
            if (filteredEvents.getTitle().equals("Shabbat Parah") ||
                    filteredEvents.getTitle().equals("Shabbat Sh'kalim") ||
                    filteredEvents.getTitle().equals("Shabbat HaGadol") || filteredEvents.getTitle().equals("Shabbat Zachor") ||
                    filteredEvents.getTitle().equals("Shabbat HaChodesh") || filteredEvents.getTitle().equals("Shabbat Shuva")
                    || filteredEvents.getTitle().equals("Shabbat Chanukah") || filteredEvents.getTitle().startsWith("Chanukah")) {


                shabbatEventsData.add(filteredEvents);
                Log.i("", "" + shabbatEventsData.size());

            }

            if (parashatEventsData.size() != 0 && shabbatEventsData.size() != 0) {

                // Loop arrayList2 items
                for (ParseIsraelItemBean shabbat : shabbatEventsData) {
                    // Loop arrayList1 items
                    boolean found = false;
                    DateTime dateTimeShabbat = AppDateUtil.getDateTime(shabbat.getDate());
                    String date_ddMMyyyyShabbat = AppDateUtil.onlyDate_ddMMyyyy(dateTimeShabbat);
                    for (ParseIsraelItemBean parashat : parashatEventsData) {
                        DateTime dateTimeParashat = AppDateUtil.getDateTime(parashat.getDate());
                        String date_ddMMyyyyParashat = AppDateUtil.onlyDate_ddMMyyyy(dateTimeParashat);
                        if (date_ddMMyyyyParashat.equals(date_ddMMyyyyShabbat) ) {
                            if (parashat.getTitle().startsWith("Parashat")) {
                                holder.tvEventSubtitle.setText("The Haftarah for " + parashat.getTitle() + " should be read.");
                                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
                                holder.tvEventSubtitle.setVisibility(View.VISIBLE);
                            }
                            if (shabbat.getTitle().equals("Shabbat Parah") ||
                                    shabbat.getTitle().equals("Shabbat Sh'kalim") ||
                                    shabbat.getTitle().equals("Shabbat HaGadol") || shabbat.getTitle().equals("Shabbat Zachor") ||
                                    shabbat.getTitle().equals("Shabbat HaChodesh") || shabbat.getTitle().equals("Shabbat Shuva")
                                    || shabbat.getTitle().equals("Shabbat Chanukah") || shabbat.getTitle().startsWith("Chanukah")) {
                                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
                                holder.tvEventSubtitle.setVisibility(View.GONE);
                            }
                        }
//
                        else if (!date_ddMMyyyyParashat.equals(date_ddMMyyyyShabbat)){
                            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                            holder.tvEventSubtitle.setVisibility(View.GONE);
                        }else {
                            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                            holder.tvEventSubtitle.setVisibility(View.GONE);
                        }
                    }
                }
            }


        }


        holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));

//        if (model.isSpecialDayForSubtitle()){
//            holder.tvEventSubtitle.setText("The Haftarah for " + EventTitle.replaceRecievedTitle(title)+ " should be read.");
//            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//        }else {
//            holder.tvEventSubtitle.setVisibility(View.GONE);
//            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.white_transparency));
//        }


//       if (model.isComparableDayForSubTitle() && model.isThreeEventsOfSpecialDayForSubTitle() ){
//           holder.tvEventSubtitle.setText("The Haftarah for Shabbat Rosh Codesh should be read.");
//           holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//           holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//       }

//       if (EventTitle.applyForSubtitleLogic(mAllActualData)){
//           holder.tvEventSubtitle.setText("The Haftarah for Shabbat Rosh Codesh should be read.");
//           holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//           holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//       }


        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventName", mPopulatingData.get(position).getTitle());
                intent.putExtra("eventType", mPopulatingData.get(position).getCategory());
                intent.putExtra("eventDate", mPopulatingData.get(position).getDate());
                ((Activity)context).startActivity(intent);

            }
        });
    }





    @Override
    public int getItemCount() {
        return mPopulatingData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CustomtextViewFontRegular tvDate, tvEventName ,tvEventSubtitle;
        private LinearLayout llMain;

        private LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEventSubtitle = itemView.findViewById(R.id.tvEventSubtitle);
            llMain = itemView.findViewById(R.id.linEventItems);
            linearLayout = itemView.findViewById(R.id.linearMain);
        }
    }

    public void setReloadAllDataListener(EventsIsraelAdapter.ReloadAllDataListener reloadAllDataListener) {
        this.reloadAllDataListener = reloadAllDataListener;
    }

    public interface ReloadAllDataListener {
        void refreshAllIsraelData();
    }

    public void clearPreviousData() {
        if(this.mPopulatingData != null)
            this.mPopulatingData.clear();
    }

    public void addMessege(ArrayList<ParseIsraelItemBean> postsDataBeans, int year) {
        mPopulatingData.addAll(postsDataBeans);
        notifyDataSetChanged();
        mAllActualData = new ArrayList<>(mPopulatingData);

    }

    public void showFilteredData(ArrayList<ParseIsraelItemBean> postsDataBeans) {
        mPopulatingData.addAll(postsDataBeans);
        notifyDataSetChanged();
    }

    public ArrayList<ParseIsraelItemBean> getFilteredData() {
        return mPopulatingData;
    }

    public ArrayList<ParseIsraelItemBean> getAllActualData() {
        return mAllActualData;
    }

}
