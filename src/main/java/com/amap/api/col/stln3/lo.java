package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PoiItemExtension */
public class lo implements Parcelable {
    public static final Parcelable.Creator<lo> a = new Parcelable.Creator<lo>() {
        /* class com.amap.api.col.stln3.lo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ lo createFromParcel(Parcel parcel) {
            return new lo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ lo[] newArray(int i) {
            return new lo[i];
        }
    };
    private String b;
    private String c;

    public lo(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    protected lo(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public int describeContents() {
        return 0;
    }
}
