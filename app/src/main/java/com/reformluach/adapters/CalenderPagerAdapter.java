package com.reformluach.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reformluach.R;
import com.reformluach.models.ParseIsraelItemBean;


public class CalenderPagerAdapter extends RecyclerView.Adapter<CalenderPagerAdapter.ViewHolder> {

    Context context;
    String[] title;
    LayoutInflater inflater;

    public CalenderPagerAdapter(Context context, String[] title) {
        this.context = context;
        this.title = title;
    }


    @Override
    public CalenderPagerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_layout_calsync, parent, false);
        return new CalenderPagerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalenderPagerAdapter.ViewHolder holder, int position) {
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private Button btnYear;

        ViewHolder(View itemView) {
            super(itemView);
            btnYear = itemView.findViewById(R.id.btnyear);
        }
    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
