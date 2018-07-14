package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.ParseDisporaItemBean;
import com.reformluach.models.ParseIsraelItemBean;

import java.util.ArrayList;

public class EventsDisporaAdapter extends RecyclerView.Adapter<EventsDisporaAdapter.ViewHolder>{

    private final Context context;
    private final ArrayList<ParseDisporaItemBean> data;

    private EventsDisporaAdapter.ReloadAllDataListener reloadAllDataListener;


    public EventsDisporaAdapter(Context context, ArrayList<ParseDisporaItemBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventsDisporaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_holiday, parent, false);
        return new EventsDisporaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventsDisporaAdapter.ViewHolder holder, final int position) {
        final ParseDisporaItemBean model = data.get(position);
        holder.tvEventName.setText(model.getTitle());
        holder.tvDate.setText(model.getDate());
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
        private final TextView tvDate, tvEventName;
        private LinearLayout llMain;

        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            llMain = itemView.findViewById(R.id.llMain);
        }
    }

    public void setReloadAllDataListener(EventsDisporaAdapter.ReloadAllDataListener reloadAllDataListener) {
        this.reloadAllDataListener = reloadAllDataListener;
    }

    public interface ReloadAllDataListener {
        void refreshAllDisporaData();
    }


    public void clearPreviousData() {
        if(this.data != null)
            this.data.clear();
    }

    public void addMessege(ArrayList<ParseDisporaItemBean> postsDataBeans, int page) {
        data.addAll(postsDataBeans);
        notifyDataSetChanged();
    }

}
