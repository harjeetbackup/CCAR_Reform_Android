package com.reformluach.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ParseDisporaItemBean implements Parcelable{
    /**
     * memo : The Jewish festival of rededication, also known as the Festival of Lights
     * date : 2017-01-01
     * subcat : major
     * category : holiday
     * hebrew : חנוכה: יום ח׳
     * link : https://www.hebcal.com/holidays/chanukah
     * title : Chanukah: 8th Day
     * leyning : {"1":"Genesis 44:18 - 44:30","2":"Genesis 44:31 - 45:7","3":"Genesis 45:8 - 45:18","4":"Genesis 45:19 - 45:27","5":"Genesis 45:28 - 46:27","6":"Genesis 46:28 - 47:10","7":"Genesis 47:11 - 47:27","maftir":"Genesis 47:25 - 47:27","haftarah":"Ezekiel 37:15 - 37:28","torah":"Genesis 44:18 - 47:27","triennial":{"1":"Genesis 44:18 - 44:20","2":"Genesis 44:21 - 44:24","3":"Genesis 44:25 - 44:30","4":"Genesis 44:31 - 44:34","5":"Genesis 45:1 - 45:7","6":"Genesis 45:8 - 45:18","7":"Genesis 45:19 - 45:27","maftir":"Genesis 45:25 - 45:27"}}
     * yomtov : true
     */

    private String memo;
    private String date;
    private String subcat;
    private String category;
    private String hebrew;
    private String link;
    private String title;
    private LeyningBean leyning;
    private boolean yomtov;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHebrew() {
        return hebrew;
    }

    public void setHebrew(String hebrew) {
        this.hebrew = hebrew;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LeyningBean getLeyning() {
        return leyning;
    }

    public void setLeyning(LeyningBean leyning) {
        this.leyning = leyning;
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

    public ParseDisporaItemBean(){

    }

    public ParseDisporaItemBean(Parcel in) {
        this.date = in.readString();
        this.category = in.readString();
        this.title = in.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.category);
        parcel.writeString(this.date);
        parcel.writeString(this.title);

    }

    public static final Parcelable.Creator<ParseDisporaItemBean> CREATOR = new Parcelable.Creator<ParseDisporaItemBean>() {
        @Override
        public ParseDisporaItemBean createFromParcel(Parcel source) {
            return new ParseDisporaItemBean(source);
        }

        @Override
        public ParseDisporaItemBean[] newArray(int size) {
            return new ParseDisporaItemBean[size];
        }
    };

    public static class LeyningBean {
        /**
         * 1 : Genesis 44:18 - 44:30
         * 2 : Genesis 44:31 - 45:7
         * 3 : Genesis 45:8 - 45:18
         * 4 : Genesis 45:19 - 45:27
         * 5 : Genesis 45:28 - 46:27
         * 6 : Genesis 46:28 - 47:10
         * 7 : Genesis 47:11 - 47:27
         * maftir : Genesis 47:25 - 47:27
         * haftarah : Ezekiel 37:15 - 37:28
         * torah : Genesis 44:18 - 47:27
         * triennial : {"1":"Genesis 44:18 - 44:20","2":"Genesis 44:21 - 44:24","3":"Genesis 44:25 - 44:30","4":"Genesis 44:31 - 44:34","5":"Genesis 45:1 - 45:7","6":"Genesis 45:8 - 45:18","7":"Genesis 45:19 - 45:27","maftir":"Genesis 45:25 - 45:27"}
         */

        @SerializedName("1")
        private String _$1;
        @SerializedName("2")
        private String _$2;
        @SerializedName("3")
        private String _$3;
        @SerializedName("4")
        private String _$4;
        @SerializedName("5")
        private String _$5;
        @SerializedName("6")
        private String _$6;
        @SerializedName("7")
        private String _$7;
        private String maftir;
        private String haftarah;
        private String torah;
        private TriennialBean triennial;

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

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }

        public String get_$4() {
            return _$4;
        }

        public void set_$4(String _$4) {
            this._$4 = _$4;
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

        public String get_$7() {
            return _$7;
        }

        public void set_$7(String _$7) {
            this._$7 = _$7;
        }

        public String getMaftir() {
            return maftir;
        }

        public void setMaftir(String maftir) {
            this.maftir = maftir;
        }

        public String getHaftarah() {
            return haftarah;
        }

        public void setHaftarah(String haftarah) {
            this.haftarah = haftarah;
        }

        public String getTorah() {
            return torah;
        }

        public void setTorah(String torah) {
            this.torah = torah;
        }

        public TriennialBean getTriennial() {
            return triennial;
        }

        public void setTriennial(TriennialBean triennial) {
            this.triennial = triennial;
        }

        public static class TriennialBean {
            /**
             * 1 : Genesis 44:18 - 44:20
             * 2 : Genesis 44:21 - 44:24
             * 3 : Genesis 44:25 - 44:30
             * 4 : Genesis 44:31 - 44:34
             * 5 : Genesis 45:1 - 45:7
             * 6 : Genesis 45:8 - 45:18
             * 7 : Genesis 45:19 - 45:27
             * maftir : Genesis 45:25 - 45:27
             */

            @SerializedName("1")
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;
            @SerializedName("5")
            private String _$5;
            @SerializedName("6")
            private String _$6;
            @SerializedName("7")
            private String _$7;
            private String maftir;

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

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
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

            public String get_$7() {
                return _$7;
            }

            public void set_$7(String _$7) {
                this._$7 = _$7;
            }

            public String getMaftir() {
                return maftir;
            }

            public void setMaftir(String maftir) {
                this.maftir = maftir;
            }
        }
    }
}
