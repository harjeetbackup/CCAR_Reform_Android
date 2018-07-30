package com.reformluach.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.reformluach.R;
import com.reformluach.models.EventListCalenderSync;
import com.reformluach.models.ModelForYear;

import java.util.ArrayList;
import java.util.Collection;

public class CalenderSyncEventsAdapter extends RecyclerView.Adapter<CalenderSyncEventsAdapter.EventsView>{

    Context context;
    ArrayList<EventListCalenderSync> calenderSyncArrayList;
    String[] spacecrafts;


    public CalenderSyncEventsAdapter(Context context, String[] spacecrafts) {
        this.context = context;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public EventsView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_list_layout_calendersync,parent,false);
        return new CalenderSyncEventsAdapter.EventsView(view);
    }

    @Override
    public void onBindViewHolder(EventsView holder, int position) {
        final CalenderSyncEventsAdapter.EventsView sportsView = (CalenderSyncEventsAdapter.EventsView) holder;

        sportsView.checkBoxEvent.setText(spacecrafts[position]);

    }

    @Override
    public int getItemCount() {
        return spacecrafts.length;
    }

    class EventsView extends RecyclerView.ViewHolder{

        CheckBox checkBoxEvent;
        public EventsView(View itemView) {
            super(itemView);

            checkBoxEvent = itemView.findViewById(R.id.checkboxEvents);
        }
    }
}
