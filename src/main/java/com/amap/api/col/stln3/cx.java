package com.amap.api.col.stln3;

import com.amap.api.maps.model.BitmapDescriptor;

/* compiled from: OverlayTextureItem */
public final class cx {
    private String a;
    private BitmapDescriptor b;
    private int c;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 1.0f;
    private float g = 1.0f;
    private int h = 0;

    public final float a() {
        return this.e;
    }

    public final void a(float f2) {
        this.e = f2;
    }

    public final float b() {
        return this.d;
    }

    public final void b(float f2) {
        this.d = f2;
    }

    public final float c() {
        return this.f;
    }

    public final void c(float f2) {
        this.f = f2;
    }

    public final float d() {
        return this.g;
    }

    public final void d(float f2) {
        this.g = f2;
    }

    public cx(BitmapDescriptor bitmapDescriptor, int i) {
        this.b = bitmapDescriptor;
        this.c = i;
        this.a = hu.a();
    }

    public final BitmapDescriptor e() {
        return this.b;
    }

    public final int f() {
        return this.c;
    }

    public final void g() {
        this.h++;
    }

    public final void h() {
        this.h--;
    }

    public final int i() {
        return this.h;
    }

    public final String j() {
        return this.a;
    }

    public final void a(int i) {
        this.c = i;
    }
}
