package com.reformluach.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.models.CustomEventsList;
import com.reformluach.utils.Controller;

import java.util.ArrayList;

/**
 * Created by Naveen Mishra on 12/8/2017.
 */
public class AdapterCustomEventsList extends RecyclerView.Adapter<AdapterCustomEventsList.ViewHolder> {
    private final Context context;
    private final ArrayList<CustomEventsList> data;
    Controller controller;

    public AdapterCustomEventsList(Context context, ArrayList<CustomEventsList> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public AdapterCustomEventsList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_events_list, parent, false);
        controller = (Controller) context.getApplicationContext();
        return new AdapterCustomEventsList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCustomEventsList.ViewHolder holder, final int position) {
        final CustomEventsList model = data.get(position);
        holder.tvEvents.setText(model.getTitle());
        holder.ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    data.remove(position);
                    notifyItemRemoved(position);
                    notifyDataSetChanged();
                    controller.setArayList(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (data.size() > 1) {
            holder.viewBar.setVisibility(View.VISIBLE);
        } /*else if(data.get(position)){

        }*/ else {
            holder.viewBar.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvEvents;
        private final ImageView ivCross;
        private View viewBar;

        ViewHolder(View itemView) {
            super(itemView);
            tvEvents = itemView.findViewById(R.id.tvEvents);
            ivCross = itemView.findViewById(R.id.ivCross);
            viewBar = itemView.findViewById(R.id.viewBar);
        }
    }
}