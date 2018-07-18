package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.typeface.CustomtextViewFontRegular;
import com.reformluach.utils.AppDateUtil;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class EventsIsraelAdapter extends RecyclerView.Adapter<EventsIsraelAdapter.ViewHolder>{
    private final Context context;
    private final ArrayList<ParseIsraelItemBean> data;

    private ReloadAllDataListener reloadAllDataListener;


    public EventsIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventsIsraelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_rosh, parent, false);
        return new EventsIsraelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventsIsraelAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = data.get(position);
//        holder.tvEventName.setText(model.getTitle());

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);

        String date = model.getDate();
        String category = model.getCategory();


//        if (model.getCategory().equalsIgnoreCase("parashat") || model.getCategory().equalsIgnoreCase("holiday")
//                ||model.getCategory().equalsIgnoreCase("roshchodesh")==model.getDate().equals("date")){
//            holder.llMain.setBackgroundColor(Color.YELLOW);
//        }

        if (model.getTitle().contains("e")){
            holder.tvEventName.setText(model.getTitle().replace("e","'"));
        }
//        else if (model.getTitle().contains("-")){
//            holder.tvEventName.setText(model.getTitle().replace("-","/"));
//        } else if (model.getTitle().contains("'")){
//            holder.tvEventName.setText(model.getTitle().replace("'","-"));
//        }
        else {
            holder.tvEventName.setText(model.getTitle());
        }
//
//

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventName",data.get(position).getTitle());
                intent.putExtra("eventType",data.get(position).getCategory());
                ((Activity)context).startActivity(intent);
            }

        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final CustomtextViewFontRegular tvDate, tvEventName;
        private LinearLayout llMain;

        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
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
        if(this.data != null)
            this.data.clear();
    }

    public void addMessege(ArrayList<ParseIsraelItemBean> postsDataBeans, int year) {
        data.addAll(postsDataBeans);
        notifyDataSetChanged();
    }

    public void addAllData(ArrayList<ParseIsraelItemBean> postsDataBeans) {
        data.addAll(postsDataBeans);
        notifyDataSetChanged();
    }
    public ArrayList<ParseIsraelItemBean> getData() {
        return data;
    }

}
