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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EventsIsraelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;
    private ArrayList<ParseIsraelItemBean> mAddAllYearData;
//    private ReloadAllDataListener reloadAllDataListener;


    public EventsIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.mPopulatingData = data;
        mAllActualData = new ArrayList<>(mPopulatingData);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_events_list_layout_all, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final EventsIsraelAdapter.ViewHolder viewHolder = (EventsIsraelAdapter.ViewHolder) holder;

        final ParseIsraelItemBean model = mPopulatingData.get(position);
        if (model==null){
            return;
        }
        final boolean isHighlighted = model.isHighlighted();
        final String subTitle = model.getSubTitle();
        final String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        viewHolder.tvDate.setText(date_ddMMyyyy);

        if(isHighlighted) {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.highligted_color_event));
        } else {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.event_background_color));
        }

        if(subTitle != null && !TextUtils.isEmpty(subTitle)) {
            viewHolder.tvEventSubtitle.setText(subTitle);
            viewHolder.tvEventSubtitle.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tvEventSubtitle.setVisibility(View.GONE);
        }

        if (title !=null && !TextUtils.isEmpty(title)){
//            viewHolder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));
            viewHolder.tvEventName.setText(title);

        }


//              if (model.getTitle().startsWith("Rosh Chodesh") || !model.getTitle().isEmpty() && (position == 0)) {
//
//                    model.setTitle("Erev Rosh Chodesh Weekday");
//                    model.setDate(getPreviousEventOfRoshChodesh(mPopulatingData.get(0).getDate()));
//                    mPopulatingData.set(0,model);
//                    mPopulatingData.add(0,model);
//                }
//                 if (model.getTitle().startsWith("Rosh Chodesh") || !model.getTitle().isEmpty() && position > 0) {
//                    model.setTitle("Erev Rosh Chodesh Weekday");
//                    model.setDate(getPreviousEventOfRoshChodesh(mPopulatingData.get(position).getDate()));
//                    mPopulatingData.set(position-1,model);
//                    mPopulatingData.add(position - 1, model);
//                }


        viewHolder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (mPopulatingData.size() !=0) {
                   Intent intent = new Intent(context, EventDetailsActivity.class);
                   intent.putExtra("eventName", mPopulatingData.get(position).getTitle());
                   intent.putExtra("eventType", mPopulatingData.get(position).getCategory());
                   intent.putExtra("eventDate", mPopulatingData.get(position).getDate());
                   ((Activity) context).startActivity(intent);
               }
            }
        });
    }

    public static String getPreviousEventOfRoshChodesh(String eventDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date newDate = calendar.getTime();
        // ---  Then, if you need to, convert it back to a String:

        eventDate = dateFormat.format(newDate);

        return eventDate;
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
//
        }

//        notifyItemInserted(mPopulatingData.size() - 1);
//        mPopulatingData.addAll(postsDataBeans);

        Log.i("Ashwani", "Size :: "+mPopulatingData.size()+" :: Year :: "+year);

        notifyDataSetChanged();
        mAllActualData = new ArrayList<>(mPopulatingData);

    }

    public void showFilteredData(ArrayList<ParseIsraelItemBean> postsDataBeans) {
        mPopulatingData.addAll(postsDataBeans);
        notifyDataSetChanged();
    }


    public  void getAllData(ArrayList<ParseIsraelItemBean> allData){
         allData.addAll(mAllActualData);
    }

    public ArrayList<ParseIsraelItemBean> getFilteredData() {
        return mPopulatingData;
    }

    public ArrayList<ParseIsraelItemBean> getAllActualData() {
        return mAllActualData;
    }

}
