package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SubPoiItem */
public class lv implements Parcelable {
    public static final Parcelable.Creator<lv> a = new Parcelable.Creator<lv>() {
        /* class com.amap.api.col.stln3.lv.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ lv createFromParcel(Parcel parcel) {
            return new lv(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ lv[] newArray(int i) {
            return null;
        }
    };
    private String b;
    private String c;
    private String d;
    private int e;
    private li f;
    private String g;
    private String h;

    public lv(String str, li liVar, String str2, String str3) {
        this.b = str;
        this.f = liVar;
        this.c = str2;
        this.g = str3;
    }

    public lv(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = (li) parcel.readValue(li.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeValue(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
