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

            ParseIsraelItemBean parashatEvents = mAllActualData.get(i);

                if (parashatEvents.getTitle().startsWith("Parashat")) {
                    parashatEventsData.add(parashatEvents);

                    Log.i("", "" + parashatEventsData.size());

                }
                if (parashatEvents.getTitle().equals("Shabbat Parah") ||
                        parashatEvents.getTitle().equals("Shabbat Sh'kalim") ||
                        parashatEvents.getTitle().equals("Shabbat HaGadol") || parashatEvents.getTitle().equals("Shabbat Zachor") ||
                        parashatEvents.getTitle().equals("Shabbat HaChodesh") || parashatEvents.getTitle().equals("Shabbat Shuva")
                        || parashatEvents.getTitle().equals("Shabbat Chanukah") || parashatEvents.getTitle().startsWith("Chanukah")) {


                    shabbatEventsData.add(parashatEvents);
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
                        if (date_ddMMyyyyParashat.equals(date_ddMMyyyyShabbat)) {
//                            if (parashat.getTitle().startsWith("Parashat")) {
                                holder.tvEventSubtitle.setText("The Haftarah for " + shabbat.getTitle() + " should be read.");
                                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
                                holder.tvEventSubtitle.setVisibility(View.VISIBLE);
                                found = true;
//                            }else if (shabbat.getTitle().equals("Shabbat Parah") ||
//                                    shabbat.getTitle().equals("Shabbat Sh'kalim") ||
//                                    shabbat.getTitle().equals("Shabbat HaGadol") || shabbat.getTitle().equals("Shabbat Zachor") ||
//                                    shabbat.getTitle().equals("Shabbat HaChodesh") || shabbat.getTitle().equals("Shabbat Shuva")
//                                    || shabbat.getTitle().equals("Shabbat Chanukah") || shabbat.getTitle().startsWith("Chanukah")){
//                                holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
//                                holder.tvEventSubtitle.setVisibility(View.GONE);
//                            }
                        }else {
                            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                            holder.tvEventSubtitle.setVisibility(View.GONE);
                        }
                    }
                }
            }


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
