package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        /* class com.amap.api.maps.offlinemap.City.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return new City(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ City[] newArray(int i) {
            return new City[i];
        }
    };
    private String a = "";
    private String b = "";
    private String c;
    private String d;
    private String e = "";

    public City() {
    }

    public void setCity(String str) {
        this.a = str;
    }

    public String getCity() {
        return this.a;
    }

    public void setCode(String str) {
        if (str != null && !"[]".equals(str)) {
            this.b = str;
        }
    }

    public String getCode() {
        return this.b;
    }

    public String getJianpin() {
        return this.c;
    }

    public void setJianpin(String str) {
        this.c = str;
    }

    public String getPinyin() {
        return this.d;
    }

    public void setPinyin(String str) {
        this.d = str;
    }

    public String getAdcode() {
        return this.e;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public City(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
