package com.reformluach.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.reformluach.R;
import com.reformluach.models.ModelForYear;

import java.util.ArrayList;


public class CalenderPagerAdapter extends RecyclerView.Adapter<CalenderPagerAdapter.YearsView> {

    Context context;
    ArrayList<ModelForYear> model;
    private static Button lastChecked = null;
    private static int lastCheckedPos = 0;


    public CalenderPagerAdapter(Context context, ArrayList<ModelForYear> modelForYear,CalenderPagerAdapter.OnYearSelected onYearSelected) {
        this.context = context;
        this.model = modelForYear;
        this.onCourseSelect = onYearSelected;
    }


    @Override
    public CalenderPagerAdapter.YearsView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_layout_calsync, parent, false);
        return new CalenderPagerAdapter.YearsView(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final CalenderPagerAdapter.YearsView holder, final int position) {
       final CalenderPagerAdapter.YearsView sportsView = (CalenderPagerAdapter.YearsView) holder;

        final ModelForYear modelForYear = model.get(position);

//        sportsView.btnYear.setSelected(model.get(0).isSelected());


//        if(position == 0 && model.get(0).isSelected() && sportsView.btnYear.isSelected())
//        {
//            sportsView.btnYear.setBackground(context.getResources().getDrawable(R.drawable.button_year_selected_shape));
//            lastChecked = sportsView.btnYear;
//            lastCheckedPos = 0;
//        }



        sportsView.btnYear.setText(modelForYear.getYear());
        final boolean isSelected = model.get(position).isSelected();

        if (isSelected){
            sportsView.btnYear.setBackground(context.getResources().getDrawable(R.drawable.button_year_selected_shape));
            sportsView.btnYear.setTextColor(context.getResources().getColor(R.color.color_gray));
//            sportsView.btnYear.setTextColor(Color.TRANSPARENT);
        }else if (!isSelected){
            sportsView.btnYear.setBackground(context.getResources().getDrawable(R.drawable.button_year_shape));
        }else {
          sportsView.btnYear.setText(model.get(0).getYear());
          sportsView.btnYear.setSelected(true);
          sportsView.btnYear.setBackground(context.getResources().getDrawable(R.drawable.button_year_selected_shape));
        }

        sportsView.btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedYear(position, !isSelected);
            }
        });

    }


    class YearsView extends RecyclerView.ViewHolder {
        private Button btnYear;

        YearsView(View itemView) {
            super(itemView);
            btnYear = itemView.findViewById(R.id.btnyear);
        }

    }



    @Override
    public int getItemCount() {
        return model.size();
    }

    public CalenderPagerAdapter.OnYearSelected onCourseSelect;

    public void setOnYearSelect(CalenderPagerAdapter.OnYearSelected onCourseSelect) {
        this.onCourseSelect = onCourseSelect;
    }

    public interface OnYearSelected {
        void onYearSelected(boolean isSelected, ModelForYear bean);
    }

    public void selectedYear(int position, boolean isSelected) {
        ModelForYear bean = model.get(position);
        bean.setSelected(!isSelected);
        notifyDataSetChanged();


        for(int i = 0; i<model.size(); i++) {
            if(i == position) {

                model.get(position).setSelected(true);
            }else {
                model.get(i).setSelected(false);
            }
        }
        if(onCourseSelect != null) {
            onCourseSelect.onYearSelected(bean.isSelected(), bean);
        }
    }


}
