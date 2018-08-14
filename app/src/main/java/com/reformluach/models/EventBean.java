package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

public class EventBean implements Parcelable{
    String eventName;
    String eventCategory;
    String eventSubCategory;
    boolean isSynced;

    protected EventBean(Parcel in) {
        eventName = in.readString();
        eventCategory = in.readString();
        eventSubCategory = in.readString();
        isSynced = in.readByte() != 0;
    }

    public static final Creator<EventBean> CREATOR = new Creator<EventBean>() {
        @Override
        public EventBean createFromParcel(Parcel in) {
            return new EventBean(in);
        }

        @Override
        public EventBean[] newArray(int size) {
            return new EventBean[size];
        }
    };

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventSubCategory() {
        return eventSubCategory;
    }

    public void setEventSubCategory(String eventSubCategory) {
        this.eventSubCategory = eventSubCategory;
    }

    public boolean isSynced() {
        return isSynced;
    }

    public void setSynced(boolean synced) {
        isSynced = synced;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventName);
        dest.writeString(eventCategory);
        dest.writeString(eventSubCategory);
        dest.writeByte((byte) (isSynced ? 1 : 0));
    }
}
