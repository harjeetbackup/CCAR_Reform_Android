package com.reformluach.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.models.EventListCalenderSync;
import com.reformluach.models.ModelForYear;

import java.util.ArrayList;

public class CalenderSyncEventsAdapter extends RecyclerView.Adapter<CalenderSyncEventsAdapter.EventsView>{

    Context context;

    ArrayList<EventListCalenderSync> syncArrayList = new ArrayList<>();


    public CalenderSyncEventsAdapter(Context context, ArrayList<EventListCalenderSync> arrayList ,CalenderSyncEventsAdapter.OnEventSelected onEventSelected) {
        this.context = context;
        this.syncArrayList = arrayList;
        this.onEventSelect = onEventSelected;
    }


    @Override
    public EventsView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_list_layout_calendersync,parent,false);
        return new CalenderSyncEventsAdapter.EventsView(view);
    }

    @Override
    public void onBindViewHolder(final EventsView holder, final int position) {
        final CalenderSyncEventsAdapter.EventsView sportsView = (CalenderSyncEventsAdapter.EventsView) holder;
          EventListCalenderSync event = syncArrayList.get(position);

        sportsView.checkBoxEvent.setText(event.getEventname());
        sportsView.txtSubTitle.setText(event.getSubTitle());

        final boolean isSelected = syncArrayList.get(position).isSelected();

        if (isSelected){
            sportsView.checkBoxEvent.setButtonDrawable(context.getResources().getDrawable(R.mipmap.checkboxsel));
        }
        else {
            sportsView.checkBoxEvent.setButtonDrawable(context.getResources().getDrawable(R.mipmap.checkboxunsel));
        }

        sportsView.checkBoxEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventListCalenderSync bean = syncArrayList.get(position);

                syncArrayList.get(position).setSelected(!bean.isSelected());
                bean.setEventname(syncArrayList.get(position).getEventname());
                notifyDataSetChanged();


                if(onEventSelect != null) {
                    onEventSelect.onEventSelected(bean.isSelected(), bean,position);

                }

            }
        });
//
//        sportsView.checkBoxEvent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                int adapterPosition = holder.getAdapterPosition();
//                if (syncArrayList.get(adapterPosition).isSelected()) {
//                    sportsView.checkBoxEvent.setChecked(false);
//                    syncArrayList.get(adapterPosition).setSelected(false);
//                }
//                else {
//                    sportsView.checkBoxEvent.setChecked(true);
//                    syncArrayList.get(adapterPosition).setSelected(true);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return syncArrayList.size();
    }

    class EventsView extends RecyclerView.ViewHolder{
        TextView txtSubTitle;
        CheckBox checkBoxEvent;
        public EventsView(View itemView) {
            super(itemView);

            checkBoxEvent = itemView.findViewById(R.id.checkboxEvents);
            txtSubTitle = itemView.findViewById(R.id.txtSubTitle);
        }
    }

    public CalenderSyncEventsAdapter.OnEventSelected onEventSelect;

    public void setOnEventSelect(CalenderSyncEventsAdapter.OnEventSelected onEventSelect) {
        this.onEventSelect = onEventSelect;
    }

    public interface OnEventSelected {
        void onEventSelected(boolean isSelected, EventListCalenderSync bean, int pos);
    }

}
