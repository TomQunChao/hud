package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
    String a;
    private LatLng b;
    private String c;
    private Typeface d = Typeface.DEFAULT;
    private float e;
    private int f = 4;
    private int g = 32;
    private int h = -1;
    private int i = ViewCompat.MEASURED_STATE_MASK;
    private Object j;
    private int k = 20;
    private float l = 0.0f;
    private boolean m = true;

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        Bundle bundle = new Bundle();
        LatLng latLng = this.b;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.c);
        parcel.writeInt(this.d.getStyle());
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        if (this.j instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.j);
            parcel.writeBundle(bundle2);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final TextOptions position(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public final TextOptions text(String str) {
        this.c = str;
        return this;
    }

    public final TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.d = typeface;
        }
        return this;
    }

    public final TextOptions visible(boolean z) {
        this.m = z;
        return this;
    }

    public final TextOptions zIndex(float f2) {
        this.l = f2;
        return this;
    }

    public final TextOptions rotate(float f2) {
        this.e = f2;
        return this;
    }

    public final TextOptions align(int i2, int i3) {
        this.f = i2;
        this.g = i3;
        return this;
    }

    public final TextOptions backgroundColor(int i2) {
        this.h = i2;
        return this;
    }

    public final TextOptions setObject(Object obj) {
        this.j = obj;
        return this;
    }

    public final TextOptions fontColor(int i2) {
        this.i = i2;
        return this;
    }

    public final TextOptions fontSize(int i2) {
        this.k = i2;
        return this;
    }

    public final LatLng getPosition() {
        return this.b;
    }

    public final String getText() {
        return this.c;
    }

    public final Typeface getTypeface() {
        return this.d;
    }

    public final float getRotate() {
        return this.e;
    }

    public final int getAlignX() {
        return this.f;
    }

    public final int getAlignY() {
        return this.g;
    }

    public final int getBackgroundColor() {
        return this.h;
    }

    public final int getFontColor() {
        return this.i;
    }

    public final Object getObject() {
        return this.j;
    }

    public final int getFontSize() {
        return this.k;
    }

    public final float getZIndex() {
        return this.l;
    }

    public final boolean isVisible() {
        return this.m;
    }
}
