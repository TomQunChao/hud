package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: LatLonPoint */
public class li implements Parcelable, Serializable {
    public static final Parcelable.Creator<li> a = new Parcelable.Creator<li>() {
        /* class com.amap.api.col.stln3.li.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ li createFromParcel(Parcel parcel) {
            return new li(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ li[] newArray(int i) {
            return new li[i];
        }
    };
    private double b;
    private double c;

    public li(double d, double d2) {
        this.b = d;
        this.c = d2;
    }

    public final double a() {
        return this.c;
    }

    public final double b() {
        return this.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.c);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        li liVar = (li) obj;
        if (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(liVar.b) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(liVar.c)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.b + "," + this.c;
    }

    protected li(Parcel parcel) {
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
    }
}
