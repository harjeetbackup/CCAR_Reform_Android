package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class EventsIsraelAdapter extends RecyclerView.Adapter<EventsIsraelAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;

    private ReloadAllDataListener reloadAllDataListener;
     boolean your_date_is_outdated;

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

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);

        String date = model.getDate();
        String category = model.getCategory();
        String title = model.getTitle();

        String sameEventDay ="";

        holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));

         if (title.equals("Shabbat HaGadol")){
            holder.tvEventSubtitle.setText("The Haftarah for "+EventTitle.replaceRecievedTitle(title)+ " should be read.");
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        }
        else if (title.equals("Shabbat Sh'kalim")){
            holder.tvEventSubtitle.setText("The Haftarah for "+EventTitle.replaceRecievedTitle(title)+ " should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));

         }else if (title.equals("Shabbat Zachor")){
             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Zachor should be read.");
             holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));

         }else if (title.equals("Shabbat HaChodesh")){
             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Hachodesh should be read.");
             holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));

         }else if (title.equals("Shabbat Shuva")){
             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Shuva should be read.");
             holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
         }else if (title.equals("Shabbat Parah")){
             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Shuva should be read.");
             holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
         }else if (title.equals("Shabbat Hachodesh") && title.equals("Shabbat Rosh Chodesh") == sameEventDay.equalsIgnoreCase(date) ){
//             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Shuva should be read){
             holder.tvEventSubtitle.setText("The Haftarah for Shabbat Rosh Codesh should be read.");
             holder.tvEventSubtitle.setVisibility(View.VISIBLE);
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.shabbat_select_color));
         }
         else {
             holder.llMain.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
         }


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
