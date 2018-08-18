package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    public void onBindViewHolder(final EventsIsraelAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = mPopulatingData.get(position);

        if (model==null){
            return;
        }
        String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);



        ArrayList<ParseIsraelItemBean> parashatEventsData = new ArrayList<>();
        ArrayList<ParseIsraelItemBean> shabbatEventsData = new ArrayList<>();

        for (int i=0;i<mAllActualData.size();i++) {

            String comparingParashatDate = "";
            String comparingShabbatDate = "";
            String comparingShabbatTitle = "";

            ParseIsraelItemBean parashatEvents = mAllActualData.get(i);
//            ParseIsraelItemBean shabbatEvents = mAllActualData.get(i);

            if (parashatEvents.getTitle().startsWith("Parashat")) {
                DateTime dateTimeComparing = AppDateUtil.getDateTime(parashatEvents.getDate());
                String eventDate = AppDateUtil.onlyDate_ddMMyyyy(dateTimeComparing);
                comparingParashatDate = eventDate;
                parashatEventsData.add(parashatEvents);
                String shabbatEventName = parashatEvents.getTitle();

                Log.i("",""+parashatEventsData.size());

                }
            if ( parashatEvents.getTitle().equals("Shabbat Parah") ||
                    parashatEvents.getTitle().equals("Shabbat Sh'kalim") ||
                    parashatEvents.getTitle().equals("Shabbat HaGadol") || parashatEvents.getTitle().equals("Shabbat Zachor") ||
                    parashatEvents.getTitle().equals("Shabbat HaChodesh") || parashatEvents.getTitle().equals("Shabbat Shuva")
                    || parashatEvents.getTitle().equals("Shabbat Chanukah") || parashatEvents.getTitle().startsWith("Chanukah")) {

                String shabbatEventName = parashatEvents.getTitle();
                String shabbatEventDate = parashatEvents.getDate();
                DateTime dateTimeComparing = AppDateUtil.getDateTime(shabbatEventDate);
                String shabbatConvertedEventDate = AppDateUtil.onlyDate_ddMMyyyy(dateTimeComparing);
                comparingShabbatTitle = shabbatEventName;
                comparingShabbatDate = shabbatConvertedEventDate;

                shabbatEventsData.add(parashatEvents);
                Log.i("",""+shabbatEventsData.size());


            }

//            if (parashatEventsData.size()!=0 && shabbatEventsData.size()!=0) {
//
//                if (comparingParashatDate.equals(comparingShabbatDate)) {
//                if (parashatEvents.getTitle().startsWith("Parashat")) {
//
//
//                        holder.tvEventSubtitle.setText("The Haftarah for " + comparingShabbatTitle + " should be read.");
//                        holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//                        holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//                    }
//                }
//                if (shabbatEvents.getTitle().equals("Shabbat Parah") ||
//                        shabbatEvents.getTitle().equals("Shabbat Sh'kalim") ||
//                        shabbatEvents.getTitle().equals("Shabbat HaGadol") || shabbatEvents.getTitle().equals("Shabbat Zachor") ||
//                        shabbatEvents.getTitle().equals("Shabbat HaChodesh") || shabbatEvents.getTitle().equals("Shabbat Shuva")
//                        || shabbatEvents.getTitle().equals("Shabbat Chanukah") || shabbatEvents.getTitle().startsWith("Chanukah")) {
//
//                    if (comparingParashatDate.equals(comparingShabbatDate)) {
//                        holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//                        holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//                    }
//                }
//            }

        }







//            if (parashatdate.equals(shabbatdate)) {
//
//                if (title.startsWith("Parashat")) {
//                    holder.tvEventSubtitle.setText("The Haftarah for " + title + " should be read.");
//                    holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//                    holder.tvEventSubtitle.setVisibility(View.VISIBLE);
//                }
//            } else {
//                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.white_transparency));
//                holder.tvEventSubtitle.setVisibility(View.GONE);
//            }

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
