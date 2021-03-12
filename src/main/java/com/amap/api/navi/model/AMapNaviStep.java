package com.amap.api.navi.model;

import java.util.List;

public class AMapNaviStep {
    private int iconType;
    private List<AMapNaviLink> mAMapNaviLinks;
    private int mChargeLength;
    private List<NaviLatLng> mCoords;
    private int mEndIndex;
    private int mLength;
    private int mStartIndex;
    private int mTime;

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public void setStartIndex(int i) {
        this.mStartIndex = i;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public void setEndIndex(int i) {
        this.mEndIndex = i;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i) {
        this.mLength = i;
    }

    public int getTime() {
        return this.mTime;
    }

    public void setTime(int i) {
        this.mTime = i;
    }

    public int getChargeLength() {
        return this.mChargeLength;
    }

    public void setChargeLength(int i) {
        this.mChargeLength = i;
    }

    public List<NaviLatLng> getCoords() {
        return this.mCoords;
    }

    public void setCoords(List<NaviLatLng> list) {
        this.mCoords = list;
    }

    public List<AMapNaviLink> getLinks() {
        return this.mAMapNaviLinks;
    }

    public void setLinks(List<AMapNaviLink> list) {
        this.mAMapNaviLinks = list;
    }

    public int getTrafficLightNumber() {
        try {
            int i = 0;
            for (AMapNaviLink aMapNaviLink : this.mAMapNaviLinks) {
                if (aMapNaviLink.getTrafficLights()) {
                    i++;
                }
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setIconType(int i) {
        this.iconType = i;
    }

    public int getIconType() {
        return this.iconType;
    }
}
