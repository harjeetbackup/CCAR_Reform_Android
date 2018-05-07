package com.reformluach.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.callbacks.DeleteInterface;
import com.reformluach.models.CustomEventsList;

import java.util.List;

/**
 * Created by Naveen Mishra on 12/21/2017.
 */
public class AdapterAddMoreUtility extends BaseAdapter {
    private Context context;
    private List<CustomEventsList> customEventsLists;
    private DeleteInterface deleteInterface;

    public AdapterAddMoreUtility(Context context, List<CustomEventsList> customEventsLists, DeleteInterface deleteInterface) {
        this.context = context;
        this.customEventsLists = customEventsLists;
        this.deleteInterface = deleteInterface;
    }

    @Override
    public int getCount() {
        return customEventsLists.size();
    }

    @Override
    public Object getItem(int i) {
        return customEventsLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return customEventsLists.indexOf(getItem(i));
    }

    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LayoutInflater diInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertview == null) {
            convertview = diInflater.inflate(R.layout.item_custom_events_list_utility, null);
            holder = new ViewHolder();
            holder.tvTitle = convertview.findViewById(R.id.tvTitle);
            holder.tvMonth = convertview.findViewById(R.id.tvMonth);
            holder.tvDay = convertview.findViewById(R.id.tvDay);
            holder.tvYear = convertview.findViewById(R.id.tvYear);
            holder.ivCross = convertview.findViewById(R.id.ivCross);
            holder.rb_after = convertview.findViewById(R.id.rb_after);
            holder.rb_before = convertview.findViewById(R.id.rb_before);
            convertview.setTag(holder);
        } else {
            holder = (ViewHolder) convertview.getTag();
        }
        holder.tvTitle.setText(customEventsLists.get(i).title);
        holder.tvMonth.setText(customEventsLists.get(i).month);
        holder.tvDay.setText(Integer.toString(customEventsLists.get(i).day));
        holder.tvYear.setText(customEventsLists.get(i).year);
        if (customEventsLists.get(i).sunset.equalsIgnoreCase("true")) {
            holder.rb_before.setChecked(true);
        } else {
            holder.rb_after.setChecked(true);
        }
        holder.ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDeleteDialog(i);
            }
        });
        return convertview;
    }

    private void callDeleteDialog(final int i) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        // Delete Dialog Message .
        alertDialog.setMessage(context.getString(R.string.delete_message));
        // Delete Dialog Yes Button  .
        alertDialog.setPositiveButton(context.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                if (customEventsLists.size() > 0) {
                    deleteInterface.onDelete(i);
                }
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton(context.getString(R.string.no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    private class ViewHolder {
        ImageView ivCross;
        RadioButton rb_before, rb_after;
        TextView tvYear, tvDay, tvMonth, tvTitle;
    }
}
