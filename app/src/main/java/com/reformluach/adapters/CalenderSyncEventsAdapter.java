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
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public EventsView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_list_layout_calendersync,parent,false);
        return new CalenderSyncEventsAdapter.EventsView(view);
    }

    @Override
    public void onBindViewHolder(final EventsView holder, final int position) {
        final CalenderSyncEventsAdapter.EventsView sportsView = (CalenderSyncEventsAdapter.EventsView) holder;

        final EventListCalenderSync event = syncArrayList.get(position);

        final boolean isSync = event.isSynced();
        final boolean isSelected = event.isSelected();

        sportsView.checkBoxEvent.setText(event.getEventname());
        sportsView.txtSubTitle.setText(event.getSubTitle());

//        holder.setIsRecyclable(true);

        if(isSync) {
            sportsView.checkBoxEvent.setButtonDrawable(context.getResources().getDrawable(R.mipmap.checkboxsel));
            sportsView.checkBoxEvent.setEnabled(false);
        } else if(isSelected){
            sportsView.checkBoxEvent.setButtonDrawable(context.getResources().getDrawable(R.mipmap.checkboxsel));
            sportsView.checkBoxEvent.setEnabled(true);
        } else {
            sportsView.checkBoxEvent.setButtonDrawable(context.getResources().getDrawable(R.mipmap.checkboxunsel));
            sportsView.checkBoxEvent.setEnabled(true);
        }

        sportsView.checkBoxEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (onEventSelect!=null) {
                        event.setSelected(!event.isSelected());
                        onEventSelect.onEventSelected(event);
                        notifyDataSetChanged();
                    }
            }
        });

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

//    public void updateData(ArrayList<EventListCalenderSync> list) {
//        if (syncArrayList!= null) {
//            syncArrayList.clear();
//            syncArrayList.addAll(list);
//
//            for (EventListCalenderSync bean : this.selectedEventLists) {
//
//                final String id = bean.getEventname();
//
//                if (selectedIds.contains(id)) {
//                    EventListCalenderSync bean1 = selectedEventLists.get(0);
//                    bean1.setEventname(id);
//                    int indexOf = syncArrayList.indexOf(bean1);
//                    syncArrayList.get(indexOf).setSelected(true);
//                }
//            }
//
//            notifyDataSetChanged();
//        }
//    }

    public void updateData(ArrayList<EventListCalenderSync> arrayList) {
        syncArrayList = arrayList;
        notifyDataSetChanged();
    }

    public ArrayList<EventListCalenderSync>  getdata() {
        return syncArrayList;
    }

    public CalenderSyncEventsAdapter.OnEventSelected onEventSelect;

    public void setOnEventSelect(CalenderSyncEventsAdapter.OnEventSelected onEventSelect) {
        this.onEventSelect = onEventSelect;
    }

    public interface OnEventSelected {
        void onEventSelected(EventListCalenderSync bean);
    }

//    public interface OnEventSelected {
//        void onEventSelected(ArrayList<EventListCalenderSync> bean);
//    }
}
