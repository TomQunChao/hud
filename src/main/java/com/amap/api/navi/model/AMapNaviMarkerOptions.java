package com.amap.api.navi.model;

import com.amap.api.maps.model.BitmapDescriptor;

public class AMapNaviMarkerOptions {
    private BitmapDescriptor bitmapDescriptor;
    private NaviLatLng position;
    private String title = "";
    private float zIndex = 0.0f;

    public NaviLatLng getPosition() {
        return this.position;
    }

    public void setPosition(NaviLatLng naviLatLng) {
        this.position = naviLatLng;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public float getzIndex() {
        return this.zIndex;
    }

    public void setzIndex(float f) {
        this.zIndex = f;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
