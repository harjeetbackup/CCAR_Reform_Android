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

public class EventsIsraelHolidayAdpater extends RecyclerView.Adapter<EventsIsraelHolidayAdpater.ViewHolder>{

    private final Context context;
    private final ArrayList<ParseIsraelItemBean> data;

    EventsIsraelHolidayAdpater eventsHolidayIsraelAdapter;

    public EventsIsraelHolidayAdpater(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventsIsraelHolidayAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_parshiyot, parent, false);
        return new EventsIsraelHolidayAdpater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventsIsraelHolidayAdpater.ViewHolder holder, final int position) {
        ParseIsraelItemBean model = data.get(position);

        if (model.getCategory().equalsIgnoreCase("holiday")){
            holder.tvEventName.setText(model.getTitle());
            holder.tvDate.setText(model.getDate());
        }

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventType", "holiday");
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

}
