package com.amap.api.maps.model;

public class AMapCameraInfo {
    private float a = 0.0f;
    private float b = 1.0f;
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;

    public AMapCameraInfo(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
        this.f = f7;
    }

    public float getFov() {
        return this.a;
    }

    public float getAspectRatio() {
        return this.b;
    }

    public float getRotate() {
        return this.c;
    }

    public float getX() {
        return this.d;
    }

    public float getY() {
        return this.e;
    }

    public float getZ() {
        return this.f;
    }

    public String toString() {
        return "[fov:" + this.a + " " + "aspectRatio:" + this.b + " " + "rotate:" + this.c + " " + "pos_x:" + this.d + " " + "pos_y:" + this.e + " " + "pos_z:" + this.f + "]";
    }
}
