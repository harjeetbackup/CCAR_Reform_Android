package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.EventBean;
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

public class EventsIsraelAdapter extends RecyclerView.Adapter<EventsIsraelAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;

    private ReloadAllDataListener reloadAllDataListener;


    public EventsIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.mPopulatingData = data;
        mAllActualData = new ArrayList<>(mPopulatingData);
    }

    @Override
    public EventsIsraelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_rosh, parent, false);
        return new EventsIsraelAdapter.ViewHolder(view);
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
    public void onBindViewHolder(final EventsIsraelAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = mPopulatingData.get(position);
        final boolean isHighlighted = model.isHighlighted();
        final String subTitle = model.getSubTitle();

        String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);

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

        if(isHighlighted) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
        }

        if(subTitle != null && !TextUtils.isEmpty(subTitle)) {
            holder.tvEventSubtitle.setText(subTitle);
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        } else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
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
        private  CustomtextViewFontRegular tvDate, tvEventName ,tvEventSubtitle;
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

    public void setReloadAllDataListener(ReloadAllDataListener reloadAllDataListener) {
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

        Log.i("Ashwani", "Size :: "+mPopulatingData.size()+" :: Year :: "+year);

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
