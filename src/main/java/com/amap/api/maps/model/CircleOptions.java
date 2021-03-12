package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    String a;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;
    private List<BaseHoleOptions> i = new ArrayList();
    private int j = -1;

    public final void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.b;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.c);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeString(this.a);
        parcel.writeList(this.i);
        parcel.writeInt(this.j);
    }

    public final int describeContents() {
        return 0;
    }

    public final CircleOptions center(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public final CircleOptions radius(double d2) {
        this.c = d2;
        return this;
    }

    public final CircleOptions strokeWidth(float f2) {
        this.d = f2;
        return this;
    }

    public final CircleOptions strokeColor(int i2) {
        this.e = i2;
        return this;
    }

    public final CircleOptions fillColor(int i2) {
        this.f = i2;
        return this;
    }

    public final CircleOptions zIndex(float f2) {
        this.g = f2;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public final LatLng getCenter() {
        return this.b;
    }

    public final double getRadius() {
        return this.c;
    }

    public final float getStrokeWidth() {
        return this.d;
    }

    public final int getStrokeColor() {
        return this.e;
    }

    public final int getFillColor() {
        return this.f;
    }

    public final float getZIndex() {
        return this.g;
    }

    public final boolean isVisible() {
        return this.h;
    }

    public final CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        try {
            this.i.addAll(Arrays.asList(baseHoleOptionsArr));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        try {
            for (BaseHoleOptions baseHoleOptions : iterable) {
                this.i.add(baseHoleOptions);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.i;
    }

    public final CircleOptions setStrokeDottedLineType(int i2) {
        this.j = i2;
        return this;
    }

    public final int getStrokeDottedLineType() {
        return this.j;
    }
}
