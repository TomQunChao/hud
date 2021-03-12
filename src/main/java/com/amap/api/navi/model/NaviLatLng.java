package com.amap.api.navi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NaviLatLng implements Parcelable {
    public static final Parcelable.Creator<NaviLatLng> CREATOR = new Parcelable.Creator<NaviLatLng>() {
        /* class com.amap.api.navi.model.NaviLatLng.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NaviLatLng createFromParcel(Parcel parcel) {
            return new NaviLatLng(parcel.readDouble(), parcel.readDouble());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NaviLatLng[] newArray(int i) {
            return new NaviLatLng[i];
        }
    };
    private double latitude;
    private double longitude;

    public NaviLatLng(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public NaviLatLng() {
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (hashCode() == obj.hashCode()) {
            return true;
        }
        if (!(obj instanceof NaviLatLng)) {
            return false;
        }
        NaviLatLng naviLatLng = (NaviLatLng) obj;
        if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(naviLatLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(naviLatLng.longitude)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }
}
