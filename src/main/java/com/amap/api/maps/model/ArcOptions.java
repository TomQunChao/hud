package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class ArcOptions implements Parcelable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
    String a;
    private LatLng b;
    private LatLng c;
    private LatLng d;
    private float e = 10.0f;
    private int f = ViewCompat.MEASURED_STATE_MASK;
    private float g = 0.0f;
    private boolean h = true;

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.b;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.b.longitude);
        }
        LatLng latLng2 = this.c;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.c.longitude);
        }
        LatLng latLng3 = this.d;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.d.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeString(this.a);
    }

    public final int describeContents() {
        return 0;
    }

    public final ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.b = latLng;
        this.c = latLng2;
        this.d = latLng3;
        return this;
    }

    public final ArcOptions strokeWidth(float f2) {
        this.e = f2;
        return this;
    }

    public final ArcOptions strokeColor(int i) {
        this.f = i;
        return this;
    }

    public final ArcOptions zIndex(float f2) {
        this.g = f2;
        return this;
    }

    public final ArcOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public final float getStrokeWidth() {
        return this.e;
    }

    public final int getStrokeColor() {
        return this.f;
    }

    public final float getZIndex() {
        return this.g;
    }

    public final boolean isVisible() {
        return this.h;
    }

    public final LatLng getStart() {
        return this.b;
    }

    public final LatLng getPassed() {
        return this.c;
    }

    public final LatLng getEnd() {
        return this.d;
    }
}
