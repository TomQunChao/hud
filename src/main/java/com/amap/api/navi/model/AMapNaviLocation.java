package com.amap.api.navi.model;

public class AMapNaviLocation {
    private float accuracy;
    private double altitude;
    private float bearing;
    private NaviLatLng coord;
    public int curLinkIndex;
    public int curPointIndex;
    public int curStepIndex;
    private int matchStatus;
    private float speed;
    private long time;
    public int type = -1;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getCurStepIndex() {
        return this.curStepIndex;
    }

    public void setCurStepIndex(int i) {
        this.curStepIndex = i;
    }

    public int getCurLinkIndex() {
        return this.curLinkIndex;
    }

    public void setCurLinkIndex(int i) {
        this.curLinkIndex = i;
    }

    public int getCurPointIndex() {
        return this.curPointIndex;
    }

    public void setCurPointIndex(int i) {
        this.curPointIndex = i;
    }

    public int getMatchStatus() {
        return this.matchStatus;
    }

    public void setMatchStatus(int i) {
        this.matchStatus = i;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    public Double getAltitude() {
        return Double.valueOf(this.altitude);
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public float getBearing() {
        return this.bearing;
    }

    public void setBearing(float f) {
        this.bearing = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public Long getTime() {
        return Long.valueOf(this.time);
    }

    public void setTime(long j) {
        this.time = j;
    }

    public boolean isMatchNaviPath() {
        return this.matchStatus != 0;
    }

    public NaviLatLng getCoord() {
        return this.coord;
    }

    public void setCoord(NaviLatLng naviLatLng) {
        this.coord = naviLatLng;
    }
}
