package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private final int a;
    private TileProvider b;
    private boolean c;
    private float d;
    private int e;
    private long f;
    private String g;
    private boolean h;
    private boolean i;

    public TileOverlayOptions() {
        this.c = true;
        this.e = 5242880;
        this.f = 20971520;
        this.g = null;
        this.h = true;
        this.i = true;
        this.a = 1;
    }

    TileOverlayOptions(int i2, boolean z, float f2) {
        this.c = true;
        this.e = 5242880;
        this.f = 20971520;
        this.g = null;
        this.h = true;
        this.i = true;
        this.a = i2;
        this.c = z;
        this.d = f2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeValue(this.b);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeLong(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeByte(this.i ? (byte) 1 : 0);
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.b = tileProvider;
        return this;
    }

    public final TileOverlayOptions zIndex(float f2) {
        this.d = f2;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.c = z;
        return this;
    }

    public final TileOverlayOptions memCacheSize(int i2) {
        this.e = i2;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i2) {
        this.f = (long) (i2 * 1024);
        return this;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.g = str;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z) {
        this.i = z;
        return this;
    }

    public final TileProvider getTileProvider() {
        return this.b;
    }

    public final float getZIndex() {
        return this.d;
    }

    public final boolean isVisible() {
        return this.c;
    }

    public final int getMemCacheSize() {
        return this.e;
    }

    public final long getDiskCacheSize() {
        return this.f;
    }

    public final String getDiskCacheDir() {
        return this.g;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.h;
    }

    public final boolean getDiskCacheEnabled() {
        return this.i;
    }
}
