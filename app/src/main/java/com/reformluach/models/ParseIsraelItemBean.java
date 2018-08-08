package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParseIsraelItemBean implements Parcelable{

    /**
     * date : 2020-01-04
     * link : https://www.hebcal.com/sedrot/vayigash
     * leyning : {"7":"Genesis 47:11 - 47:27","5":"Genesis 45:28 - 46:27","6":"Genesis 46:28 - 47:10","4":"Genesis 45:19 - 45:27","torah":"Genesis 44:18 - 47:27","1":"Genesis 44:18 - 44:30","2":"Genesis 44:31 - 45:7","haftarah":"Ezekiel 37:15 - 37:28","3":"Genesis 45:8 - 45:18","maftir":"Genesis 47:25 - 47:27"}
     * hebrew : פרשת ויגש
     * category : parashat
     * title : Parashat Vayigash
     * memo : Fast commemorating the siege of Jerusalem
     * subcat : fast
     * yomtov : true
     */

    private String date;
    private String link;
    private LeyningBean leyning;
    private String hebrew;
    private String category;
    private String title;
    private String memo;
    private String subcat;
    private boolean yomtov;

    private List<MajorHolidays> majorHolidays;

    public List<MajorHolidays> getMajorHolidays() {
        return majorHolidays;
    }

    public void setMajorHolidays(List<MajorHolidays> group_members) {
        this.majorHolidays = group_members;
    }

    private EventTitle replaceTitle;

    public EventTitle getReplaceTitle() {
        return replaceTitle;
    }

    public void setReplaceTitle() {
        this.replaceTitle = replaceTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LeyningBean getLeyning() {
        return leyning;
    }

    public void setLeyning(LeyningBean leyning) {
        this.leyning = leyning;
    }

    public String getHebrew() {
        return hebrew;
    }

    public void setHebrew(String hebrew) {
        this.hebrew = hebrew;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = EventTitle.replaceRecievedTitle(title);
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public boolean isYomtov() {
        return yomtov;
    }

    public void setYomtov(boolean yomtov) {
        this.yomtov = yomtov;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Parcelable.Creator<ParseIsraelItemBean> CREATOR = new Parcelable.Creator<ParseIsraelItemBean>() {
        @Override
        public ParseIsraelItemBean createFromParcel(Parcel source) {
            return new ParseIsraelItemBean(source);
        }

        @Override
        public ParseIsraelItemBean[] newArray(int size) {
            return new ParseIsraelItemBean[size];
        }
    };

    public ParseIsraelItemBean(){

    }

    public ParseIsraelItemBean(Parcel in) {
        this.date = in.readString();
        this.category = in.readString();
        this.title = in.readString();
        this.subcat = in.readString();
        this.replaceTitle = in.readParcelable(EventTitle.class.getClassLoader());
        this.majorHolidays = in.readParcelable(MajorHolidays.class.getClassLoader());

    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
     parcel.writeString(this.category);
     parcel.writeString(this.date);
     parcel.writeString(this.title);
     parcel.writeString(this.subcat);
     parcel.writeParcelable((Parcelable) this.replaceTitle, i);
     parcel.writeParcelable((Parcelable) this.majorHolidays,i);


    }

    public static class LeyningBean {
        /**
         * 7 : Genesis 47:11 - 47:27
         * 5 : Genesis 45:28 - 46:27
         * 6 : Genesis 46:28 - 47:10
         * 4 : Genesis 45:19 - 45:27
         * torah : Genesis 44:18 - 47:27
         * 1 : Genesis 44:18 - 44:30
         * 2 : Genesis 44:31 - 45:7
         * haftarah : Ezekiel 37:15 - 37:28
         * 3 : Genesis 45:8 - 45:18
         * maftir : Genesis 47:25 - 47:27
         */

        @SerializedName("7")
        private String _$7;
        @SerializedName("5")
        private String _$5;
        @SerializedName("6")
        private String _$6;
        @SerializedName("4")
        private String _$4;
        private String torah;
        @SerializedName("1")
        private String _$1;
        @SerializedName("2")
        private String _$2;
        private String haftarah;
        @SerializedName("3")
        private String _$3;
        private String maftir;

        public String get_$7() {
            return _$7;
        }

        public void set_$7(String _$7) {
            this._$7 = _$7;
        }

        public String get_$5() {
            return _$5;
        }

        public void set_$5(String _$5) {
            this._$5 = _$5;
        }

        public String get_$6() {
            return _$6;
        }

        public void set_$6(String _$6) {
            this._$6 = _$6;
        }

        public String get_$4() {
            return _$4;
        }

        public void set_$4(String _$4) {
            this._$4 = _$4;
        }

        public String getTorah() {
            return torah;
        }

        public void setTorah(String torah) {
            this.torah = torah;
        }

        public String get_$1() {
            return _$1;
        }

        public void set_$1(String _$1) {
            this._$1 = _$1;
        }

        public String get_$2() {
            return _$2;
        }

        public void set_$2(String _$2) {
            this._$2 = _$2;
        }

        public String getHaftarah() {
            return haftarah;
        }

        public void setHaftarah(String haftarah) {
            this.haftarah = haftarah;
        }

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }

        public String getMaftir() {
            return maftir;
        }

        public void setMaftir(String maftir) {
            this.maftir = maftir;
        }
    }

}
