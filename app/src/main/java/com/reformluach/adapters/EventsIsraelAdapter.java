package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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

import java.util.ArrayList;
import java.util.Calendar;

public class EventsIsraelAdapter extends RecyclerView.Adapter<EventsIsraelAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;

//    private ReloadAllDataListener reloadAllDataListener;


    public EventsIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.mPopulatingData = data;
        mAllActualData = new ArrayList<>(mPopulatingData);
    }

    @Override
    public EventsIsraelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_list_layout_all, parent, false);
        return new EventsIsraelAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final EventsIsraelAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = mPopulatingData.get(position);
        final boolean isHighlighted = model.isHighlighted();
        final String subTitle = model.getSubTitle();
        final String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);

//        if (title.equals("Sigd")){
////            removeItem(position);
//            mAllActualData.remove(position).getTitle();
//        }

//        holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));




        if(isHighlighted) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.highligted_color_event));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.event_background_color));
        }

        if(subTitle != null && !TextUtils.isEmpty(subTitle)) {
            holder.tvEventSubtitle.setText("The Haftarah for "+subTitle +" should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        } else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
        }

        if (title !=null && !TextUtils.isEmpty(title)){
            holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));
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


    public void removeItem(int position) {
        mPopulatingData.remove(position);
        notifyItemRemoved(position);
    }



    @Override
    public int getItemCount() {
        return mPopulatingData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private  CustomtextViewFontRegular tvDate, tvEventName ,tvEventSubtitle;
        private LinearLayout llMain;

        private LinearLayout linearLayout;
        private LinearLayout linEventItems;
        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.eventNameTxt);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEventSubtitle = itemView.findViewById(R.id.tvEventSubtitle);
            llMain = itemView.findViewById(R.id.linEventItems);
            linearLayout = itemView.findViewById(R.id.linearMain);
            linEventItems = itemView.findViewById(R.id.linEventItems);
        }
    }

//    public void setReloadAllDataListener(ReloadAllDataListener reloadAllDataListener) {
//        this.reloadAllDataListener = reloadAllDataListener;
//    }

    public interface ReloadAllDataListener {
        void refreshAllIsraelData();
    }

    public void clearPreviousData() {
        if(this.mPopulatingData != null)
            this.mPopulatingData.clear();
    }


    public void addMessege(ArrayList<ParseIsraelItemBean> postsDataBeans, int year) {
        for (int i=0;i<postsDataBeans.size();i++){
            if (!postsDataBeans.get(i).getTitle().equals("Sigd")) {
                mPopulatingData.add(postsDataBeans.get(i));
            }
        }
//        mPopulatingData.addAll(postsDataBeans);

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
