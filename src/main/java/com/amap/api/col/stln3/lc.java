package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IndoorData */
public class lc implements Parcelable {
    public static final Parcelable.Creator<lc> a = new Parcelable.Creator<lc>() {
        /* class com.amap.api.col.stln3.lc.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ lc createFromParcel(Parcel parcel) {
            return new lc(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ lc[] newArray(int i) {
            return new lc[i];
        }
    };
    private String b;
    private int c;
    private String d;

    public lc(String str, int i, String str2) {
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    protected lc(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }
}
