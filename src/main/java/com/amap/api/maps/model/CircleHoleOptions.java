package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() {
        /* class com.amap.api.maps.model.CircleHoleOptions.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CircleHoleOptions[] newArray(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng a = null;
    private double b = 0.0d;

    public CircleHoleOptions() {
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public CircleHoleOptions radius(double d) {
        this.b = d;
        return this;
    }

    public LatLng getCenter() {
        return this.a;
    }

    public double getRadius() {
        return this.b;
    }

    protected CircleHoleOptions(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        this.a = new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.b = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.a;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.a.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.b);
    }
}
