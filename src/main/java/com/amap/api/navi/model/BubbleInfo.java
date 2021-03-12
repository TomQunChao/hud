package com.amap.api.navi.model;

import com.amap.api.maps.model.LatLng;

public class BubbleInfo {
    LatLng bubblePosition = null;
    int bubblePositionScreen = 0;
    String detailInfo;
    boolean isFast = false;
    String timeInfo;
    boolean toll;
    String trafficInfo;

    public LatLng getBubblePosition() {
        return this.bubblePosition;
    }

    public void setBubblePosition(LatLng latLng) {
        this.bubblePosition = latLng;
    }

    public int getBubblePositionScreen() {
        return this.bubblePositionScreen;
    }

    public void setBubblePositionScreen(int i) {
        this.bubblePositionScreen = i;
    }

    public boolean isFast() {
        return this.isFast;
    }

    public void setFast(boolean z) {
        this.isFast = z;
    }

    public String getTimeInfo() {
        return this.timeInfo;
    }

    public void setTimeInfo(String str) {
        this.timeInfo = str;
    }

    public String getDetailInfo() {
        return this.detailInfo;
    }

    public void setDetailInfo(String str) {
        this.detailInfo = str;
    }

    public boolean isToll() {
        return this.toll;
    }

    public void setToll(boolean z) {
        this.toll = z;
    }

    public String getTrafficInfo() {
        return this.trafficInfo;
    }

    public void setTrafficInfo(String str) {
        this.trafficInfo = str;
    }
}
