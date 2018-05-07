/*
package com.reformluach.utils;

import android.widget.Filter;

import com.reformluach.adapters.AdapterEventsParshiyor;

import java.util.ArrayList;

public class FilterClass extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // TODO Auto-generated method stub

                constraint = constraint.toString().toLowerCase();

                FilterResults newFilterResults = new FilterResults();

                if (constraint != null && constraint.length() > 0) {


                    ArrayList<String> auxData = new ArrayList<String>();

                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).toLowerCase().contains(constraint))
                            auxData.add(data.get(i));
                    }

                    newFilterResults.count = auxData.size();
                    newFilterResults.values = auxData;
                } else {

                    newFilterResults.count = data.size();
                    newFilterResults.values = data;
                }

                return newFilterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                ArrayList<String> resultData = new ArrayList<String>();

                resultData = (ArrayList<String>) results.values;

                AdapterEventsParshiyor adapter = new AdapterEventsParshiyor(context, resultData);
                list.setAdapter(adapter);

//              notifyDataSetChanged();
            }

        }*/
