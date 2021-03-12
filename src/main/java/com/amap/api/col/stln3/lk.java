package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Photo */
public final class lk implements Parcelable {
    public static final Parcelable.Creator<lk> a = new Parcelable.Creator<lk>() {
        /* class com.amap.api.col.stln3.lk.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ lk createFromParcel(Parcel parcel) {
            return new lk(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ lk[] newArray(int i) {
            return null;
        }
    };
    private String b;
    private String c;

    public lk() {
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public lk(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
