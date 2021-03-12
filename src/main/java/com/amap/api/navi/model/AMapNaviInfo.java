package com.amap.api.navi.model;

@Deprecated
public class AMapNaviInfo {
    private int pathRemainDistance;
    private int pathRemainTime;

    public AMapNaviInfo(int i, int i2) {
        this.pathRemainDistance = i;
        this.pathRemainTime = i2;
    }

    public int getPathRemainDistance() {
        return this.pathRemainDistance;
    }

    public int getPathRemainTime() {
        return this.pathRemainTime;
    }
}
