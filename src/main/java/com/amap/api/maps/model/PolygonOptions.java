package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private float f = 0.0f;
    private boolean g = true;
    private List<BaseHoleOptions> h = new ArrayList();

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeString(this.a);
        parcel.writeList(this.h);
    }

    public final PolygonOptions add(LatLng latLng) {
        try {
            this.b.add(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        try {
            this.b.addAll(Arrays.asList(latLngArr));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        try {
            for (LatLng latLng : iterable) {
                this.b.add(latLng);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        try {
            this.h.addAll(Arrays.asList(baseHoleOptionsArr));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        try {
            for (BaseHoleOptions baseHoleOptions : iterable) {
                this.h.add(baseHoleOptions);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public final PolygonOptions strokeWidth(float f2) {
        this.c = f2;
        return this;
    }

    public final PolygonOptions strokeColor(int i) {
        this.d = i;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public final PolygonOptions zIndex(float f2) {
        this.f = f2;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.b;
    }

    public final float getStrokeWidth() {
        return this.c;
    }

    public final int getStrokeColor() {
        return this.d;
    }

    public final int getFillColor() {
        return this.e;
    }

    public final float getZIndex() {
        return this.f;
    }

    public final boolean isVisible() {
        return this.g;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.h;
    }
}
