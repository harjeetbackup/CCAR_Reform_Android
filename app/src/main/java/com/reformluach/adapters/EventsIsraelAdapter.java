package com.reformluach.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.reformluach.R;
import com.reformluach.activities.EventDetailsActivity;
import com.reformluach.models.EventBean;
import com.reformluach.models.EventTitle;
import com.reformluach.models.ParseIsraelItemBean;
import com.reformluach.typeface.CustomtextViewFontRegular;
import com.reformluach.utils.AppDateUtil;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventsIsraelAdapter extends RecyclerView.Adapter<EventsIsraelAdapter.ViewHolder>{
    private final Context context;
    private ArrayList<ParseIsraelItemBean> mPopulatingData;
    private ArrayList<ParseIsraelItemBean> mAllActualData;

//    private ReloadAllDataListener reloadAllDataListener;


    public EventsIsraelAdapter(Context context, ArrayList<ParseIsraelItemBean> data) {
        this.context = context;
        this.mPopulatingData = data;
        mAllActualData = new ArrayList<>(mPopulatingData);
    }

    @Override
    public EventsIsraelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_events_rosh, parent, false);
        return new EventsIsraelAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final EventsIsraelAdapter.ViewHolder holder, final int position) {
        final ParseIsraelItemBean model = mPopulatingData.get(position);
        final boolean isHighlighted = model.isHighlighted();
        final String subTitle = model.getSubTitle();

        String title = model.getTitle();

        DateTime dateTime = AppDateUtil.getDateTime(model.getDate());
        String date_ddMMyyyy = AppDateUtil.onlyDate_ddMMyyyy(dateTime);
        holder.tvDate.setText(date_ddMMyyyy);

        String[] out = model.getDate().split("-");
        int s1 = Integer.parseInt(out[2]);
        int s2 = Integer.parseInt(out[1]) - 1;
        String yr = out[0];
        char a, b, c, d;
        a = yr.charAt(0);
        b = yr.charAt(1);
        c = yr.charAt(2);
        d = yr.charAt(3);
        int s3 = Character.getNumericValue(a)*1000 +
                Character.getNumericValue(b)*100 +
                Character.getNumericValue(c)*10 +
                Character.getNumericValue(d);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(s3, s2, s1);

        int days = calendar1.get(Calendar.DAY_OF_WEEK);


        if(isHighlighted) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
        }

        if(subTitle != null && !TextUtils.isEmpty(subTitle)) {
            holder.tvEventSubtitle.setText("The Haftarah for "+subTitle +" should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        } else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
        }



        if (title.equals("Sukkot 2 Weekday") && days==7){
            title.replace("Sukkot 2 Weekday","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Sukkot 2 should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));

        }

        if (title.equals("Sukkot 3 Weekday") && days==7){
            title.replace("Sukkot 3 Weekday","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Sukkot 3 should be read.");
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));

            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
        }else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
        }

        if (title.equals("Sukkot 4 Weekday") && days==7){
            title.replace("Sukkot 4 Weekday","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Sukkot 4 should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
            }else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
           }
            if (title.equals("Sukkot 5 Weekday") && days==7){
            title.replace("Sukkot 5 Weekday","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Sukkot 5 should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
            }else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
            }
            if (title.equals("Sukkot 6 Weekday") && days==7){
            title.replace("Sukkot 6 Weekday","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Sukkot 6 should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
            }else {
                holder.tvEventSubtitle.setVisibility(View.GONE);
            }

        if (title.equals("Chanukah 2nd Night") && days==7){
//            title.replace("Chanukah 2nd Night","Chol Hamoed Sukkot Shabbat");
            holder.tvEventSubtitle.setText("The Haftarah for Chanukah: 2nd Night should be read.");
            holder.tvEventSubtitle.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.shabbat_select_color));
        }else {
            holder.tvEventSubtitle.setVisibility(View.GONE);
        }

        holder.tvEventName.setText(EventTitle.replacetitleWithSpecialChar(title));


        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventName", mPopulatingData.get(position).getTitle());
                intent.putExtra("eventType", mPopulatingData.get(position).getCategory());
                intent.putExtra("eventDate", mPopulatingData.get(position).getDate());
                ((Activity)context).startActivity(intent);

            }
        });
    }


//
//    public void removeItem(int position) {
//        mPopulatingData.remove(position);
//        // notify the item removed by position
//        // to perform recycler view delete animations
//        // NOTE: don't call notifyDataSetChanged()
//        notifyItemRemoved(position);
//    }



    @Override
    public int getItemCount() {
        if (mPopulatingData == null) {
            return 0;
        }
        return mPopulatingData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private  CustomtextViewFontRegular tvDate, tvEventName ,tvEventSubtitle;
        private LinearLayout llMain;

        private LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvEventSubtitle = itemView.findViewById(R.id.tvEventSubtitle);
            llMain = itemView.findViewById(R.id.linEventItems);
            linearLayout = itemView.findViewById(R.id.linearMain);
        }
    }

//    public void setReloadAllDataListener(ReloadAllDataListener reloadAllDataListener) {
//        this.reloadAllDataListener = reloadAllDataListener;
//    }

    public interface ReloadAllDataListener {
        void refreshAllIsraelData();
    }

    public void clearPreviousData() {
        if(this.mPopulatingData != null)
            this.mPopulatingData.clear();
    }

    public void addMessege(ArrayList<ParseIsraelItemBean> postsDataBeans, int year) {
        mPopulatingData.addAll(postsDataBeans);

        Log.i("Ashwani", "Size :: "+mPopulatingData.size()+" :: Year :: "+year);

        notifyDataSetChanged();
        mAllActualData = new ArrayList<>(mPopulatingData);

    }

    public void showFilteredData(ArrayList<ParseIsraelItemBean> postsDataBeans) {
        mPopulatingData.addAll(postsDataBeans);
        notifyDataSetChanged();
    }

    public ArrayList<ParseIsraelItemBean> getFilteredData() {
        return mPopulatingData;
    }

    public ArrayList<ParseIsraelItemBean> getAllActualData() {
        return mAllActualData;
    }

}
