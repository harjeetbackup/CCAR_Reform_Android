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
import com.reformluach.models.EventsParsiyor;

import java.util.ArrayList;

/**
 * Created by Naveen Mishra on 12/5/2017.
 */
public class AdapterEventsParshiyor extends RecyclerView.Adapter<AdapterEventsParshiyor.ViewHolder> {
    private final Context context;
    private final ArrayList<EventsParsiyor> data;

    public AdapterEventsParshiyor(Context context, ArrayList<EventsParsiyor> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public AdapterEventsParshiyor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_parshiyot, parent, false);
        return new AdapterEventsParshiyor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterEventsParshiyor.ViewHolder holder, final int position) {
        EventsParsiyor model = data.get(position);
        holder.tvEventName.setText(model.getSubject());
        holder.tvDate.setText(model.getStartDate());
        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventType", "Parshiyot");
                intent.putExtra("eventName", data.get(position).getSubject());
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
