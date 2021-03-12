package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    String a;
    float b = 1.0f;
    boolean c = false;
    boolean d = true;
    int e = 5;
    float f;
    private LatLng g;
    private String h;
    private String i;
    private float j = 0.5f;
    private float k = 1.0f;
    private float l = 0.0f;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private int p = 0;
    private int q = 0;
    private ArrayList<BitmapDescriptor> r = new ArrayList<>();
    private int s = 20;
    private boolean t = false;
    private boolean u = false;
    private boolean v;

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.r = arrayList;
        return this;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return this.r;
    }

    public final MarkerOptions period(int i2) {
        if (i2 <= 1) {
            this.s = 1;
        } else {
            this.s = i2;
        }
        return this;
    }

    public final int getPeriod() {
        return this.s;
    }

    public final boolean isPerspective() {
        return this.o;
    }

    public final MarkerOptions perspective(boolean z) {
        this.o = z;
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        this.g = latLng;
        return this;
    }

    public final MarkerOptions setFlat(boolean z) {
        this.u = z;
        return this;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            if (this.r == null) {
                try {
                    this.r = new ArrayList<>();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.r.clear();
            this.r.add(bitmapDescriptor);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this;
    }

    public final MarkerOptions anchor(float f2, float f3) {
        this.j = f2;
        this.k = f3;
        return this;
    }

    public final MarkerOptions setInfoWindowOffset(int i2, int i3) {
        this.p = i2;
        this.q = i3;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.h = str;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.i = str;
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.m = z;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.n = z;
        return this;
    }

    public final MarkerOptions setGps(boolean z) {
        this.t = z;
        return this;
    }

    public final LatLng getPosition() {
        return this.g;
    }

    public final String getTitle() {
        return this.h;
    }

    public final String getSnippet() {
        return this.i;
    }

    public final BitmapDescriptor getIcon() {
        ArrayList<BitmapDescriptor> arrayList = this.r;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.r.get(0);
    }

    public final float getAnchorU() {
        return this.j;
    }

    public final int getInfoWindowOffsetX() {
        return this.p;
    }

    public final int getInfoWindowOffsetY() {
        return this.q;
    }

    public final float getAnchorV() {
        return this.k;
    }

    public final boolean isDraggable() {
        return this.m;
    }

    public final boolean isVisible() {
        return this.n;
    }

    public final boolean isGps() {
        return this.t;
    }

    public final boolean isFlat() {
        return this.u;
    }

    public final MarkerOptions zIndex(float f2) {
        this.l = f2;
        return this;
    }

    public final float getZIndex() {
        return this.l;
    }

    public final MarkerOptions alpha(float f2) {
        this.b = f2;
        return this;
    }

    public final float getAlpha() {
        return this.b;
    }

    public final MarkerOptions autoOverturnInfoWindow(boolean z) {
        this.c = z;
        return this;
    }

    public final boolean isInfoWindowAutoOverturn() {
        return this.c;
    }

    public final MarkerOptions displayLevel(int i2) {
        this.e = i2;
        return this;
    }

    public final int getDisplayLevel() {
        return this.e;
    }

    public final MarkerOptions rotateAngle(float f2) {
        this.f = f2;
        return this;
    }

    public final float getRotateAngle() {
        return this.f;
    }

    public final MarkerOptions infoWindowEnable(boolean z) {
        this.d = z;
        return this;
    }

    public final boolean isInfoWindowEnable() {
        return this.d;
    }

    public final MarkerOptions belowMaskLayer(boolean z) {
        this.v = z;
        return this;
    }

    public final boolean isBelowMaskLayer() {
        return this.v;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.g, i2);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeFloat(this.j);
        parcel.writeFloat(this.k);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeBooleanArray(new boolean[]{this.n, this.m, this.t, this.u, this.c, this.d, this.v});
        parcel.writeString(this.a);
        parcel.writeInt(this.s);
        parcel.writeList(this.r);
        parcel.writeFloat(this.l);
        parcel.writeFloat(this.b);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        ArrayList<BitmapDescriptor> arrayList = this.r;
        if (arrayList != null && arrayList.size() != 0) {
            parcel.writeParcelable(this.r.get(0), i2);
        }
    }
}
