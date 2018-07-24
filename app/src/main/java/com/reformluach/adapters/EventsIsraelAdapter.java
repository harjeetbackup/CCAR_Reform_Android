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

//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        Date strDate = null;
//        try {
//            strDate = sdf.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (new Date().after(strDate)) {
//            your_date_is_outdated = true;
//        }
//        else{
//            your_date_is_outdated = false;
//        }


        holder.tvEventName.setText(title);
//        holder.tvEventName.setText(e);

//        holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));



         if (title.equals("Shabbat HaGadol")){
            holder.tvEventSubtitle.setText("The Haftarah for "+EventTitle.replaceRecievedTitle(title)+ " should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        }
        else if (title.equals("Shabbat Shekalim")){
            holder.tvEventSubtitle.setText("The Haftarah for "+EventTitle.replaceRecievedTitle(title)+ " should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        }else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
        }
//        holder.scrollToPosition(mAdapter.getItemCount() - 1); // update based on adapter


        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String todayAsString = dateFormat.format(today);
        String tomorrowAsString = dateFormat.format(tomorrow);

//        final int indexPosition = holder.getAdapterPosition();
//        if (date.equals(formattedDate)){
//
//        }



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

        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEventSubtitle = itemView.findViewById(R.id.tvEventSubtitle);
            llMain = itemView.findViewById(R.id.linEventItems);
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
