package com.reformluach.adapters;

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
import com.reformluach.models.ParseIsraelItemBean;

import java.util.ArrayList;

public class EventsParshiyotIsraelAdapter extends RecyclerView.Adapter<EventsParshiyotIsraelAdapter.ViewHolder>{

    private final Context context;
    private final ArrayList<ParseIsraelItemBean> data;

    private EventsParshiyotIsraelAdapter.ReloadAllDataListener reloadAllDataListener;


    public EventsParshiyotIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventsParshiyotIsraelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_parshiyot, parent, false);
        return new EventsParshiyotIsraelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventsParshiyotIsraelAdapter.ViewHolder holder, final int position) {
        ParseIsraelItemBean model = data.get(position);

        if (model.getCategory().equalsIgnoreCase("parashat")){
            holder.tvEventName.setText(model.getTitle());
            holder.tvDate.setText(model.getDate());
        }


        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventType", "parashat");
                intent.putExtra("eventName", data.get(position).getTitle());
                context.startActivity(intent);
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
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            llMain = itemView.findViewById(R.id.llMain);
        }
    }

    public void setReloadAllDataListener(EventsParshiyotIsraelAdapter.ReloadAllDataListener reloadAllDataListener) {
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

}
