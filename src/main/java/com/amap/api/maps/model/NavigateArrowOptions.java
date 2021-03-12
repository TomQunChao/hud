package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NavigateArrowOptions implements Parcelable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = Color.argb(221, 87, 235, 204);
    private int e = Color.argb(170, 0, 172, 146);
    private float f = 0.0f;
    private boolean g = true;

    public final NavigateArrowOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public final NavigateArrowOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.b.add(latLng);
        }
        return this;
    }

    public final NavigateArrowOptions width(float f2) {
        this.c = f2;
        return this;
    }

    public final NavigateArrowOptions topColor(int i) {
        this.d = i;
        return this;
    }

    @Deprecated
    public final NavigateArrowOptions sideColor(int i) {
        this.e = i;
        return this;
    }

    public final NavigateArrowOptions zIndex(float f2) {
        this.f = f2;
        return this;
    }

    public final NavigateArrowOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.b;
    }

    public final float getWidth() {
        return this.c;
    }

    public final int getTopColor() {
        return this.d;
    }

    @Deprecated
    public final int getSideColor() {
        return this.e;
    }

    public final float getZIndex() {
        return this.f;
    }

    public final boolean isVisible() {
        return this.g;
    }

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
    }
}
