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
import com.reformluach.models.EventsRosh;

import java.util.List;

/**
 * Created by Naveen Mishra on 12/5/2017.
 */
public class AdapterEventsRosh extends RecyclerView.Adapter<AdapterEventsRosh.ViewHolder> {
    private final Context context;
    //  private final List<String> data;
    private final List<EventsRosh> data;

    public AdapterEventsRosh(Context context, List<EventsRosh> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public AdapterEventsRosh.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_rosh, parent, false);
        return new AdapterEventsRosh.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterEventsRosh.ViewHolder holder, final int position) {
        EventsRosh model = data.get(position);
        holder.tvEventName.setText(model.getSubject());
        holder.tvDate.setText(model.getStartDate());
        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventType", "Rosh");
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
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            llMain = itemView.findViewById(R.id.llMain);
        }
    }
}