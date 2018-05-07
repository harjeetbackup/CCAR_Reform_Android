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
import com.reformluach.interfaces.onClickItem;
import com.reformluach.models.EventsHolidays;

import java.util.List;

/**
 * Created by Naveen Mishra on 12/5/2017.
 */
public class AdapterEventsHolidays extends RecyclerView.Adapter<AdapterEventsHolidays.ViewHolder> {
    private final Context context;
    private final List<EventsHolidays> data;
    onClickItem onClickItem;

    public AdapterEventsHolidays(onClickItem onClickItem, Context context, List<EventsHolidays> data) {
        this.context = context;
        this.data = data;
        this.onClickItem=onClickItem;
    }

    @Override
    public AdapterEventsHolidays.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_holiday, parent, false);
        return new AdapterEventsHolidays.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterEventsHolidays.ViewHolder holder, final int position) {
        final EventsHolidays model = data.get(position);
        holder.tvEventName.setText(model.getSubject());
        holder.tvDate.setText(model.getStartDate());
        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onClickItem.onSelectedItem(position);
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
}