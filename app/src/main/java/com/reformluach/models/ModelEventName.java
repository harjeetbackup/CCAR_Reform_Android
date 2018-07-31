package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ModelEventName implements Parcelable{

   String date;
   ArrayList<EventDetailModel> eventDetailModels;

    public ModelEventName(Parcel in) {
        date = in.readString();
        eventDetailModels = in.createTypedArrayList(EventDetailModel.CREATOR);
    }

    public static final Creator<ModelEventName> CREATOR = new Creator<ModelEventName>() {
        @Override
        public ModelEventName createFromParcel(Parcel in) {
            return new ModelEventName(in);
        }

        @Override
        public ModelEventName[] newArray(int size) {
            return new ModelEventName[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<EventDetailModel> getEventDetailModels() {
        return eventDetailModels;
    }

    public void setEventDetailModels(ArrayList<EventDetailModel> eventDetailModels) {
        this.eventDetailModels = eventDetailModels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeTypedList(eventDetailModels);
    }
}
