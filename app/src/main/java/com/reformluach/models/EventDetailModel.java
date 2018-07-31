package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

public class EventDetailModel implements Parcelable{

    String eventdate;
    String eventname;
    String eventsubcategory;
    String eventCategory;

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventsubcategory() {
        return eventsubcategory;
    }

    public void setEventsubcategory(String eventsubcategory) {
        this.eventsubcategory = eventsubcategory;
    }

    boolean isSync;

    public EventDetailModel(Parcel in) {
        eventdate = in.readString();
        eventname = in.readString();
        eventCategory = in.readString();
        eventsubcategory = in.readString();
        isSync = in.readByte() != 0;
    }

    public static final Creator<EventDetailModel> CREATOR = new Creator<EventDetailModel>() {
        @Override
        public EventDetailModel createFromParcel(Parcel in) {
            return new EventDetailModel(in);
        }

        @Override
        public EventDetailModel[] newArray(int size) {
            return new EventDetailModel[size];
        }
    };

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventdate);
        dest.writeString(eventname);
        dest.writeString(eventCategory);
        dest.writeString(eventsubcategory);
        dest.writeByte((byte) (isSync ? 1 : 0));
    }
}
