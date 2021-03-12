package com.amap.api.navi.model;

import android.text.TextUtils;
import java.util.List;

public class AMapNaviLink {
    private List<NaviLatLng> mCoords;
    private boolean mIsTrafficLightIn;
    private int mLength;
    private int mLinkType;
    private int mRoadClass;
    private String mRoadName;
    private int mRoadType;
    private int mTime;
    private int ownership;
    private int trafficStatus;

    public String getRoadName() {
        return this.mRoadName;
    }

    public void setRoadName(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.mRoadName = str;
            } else if (this.ownership == 1) {
                this.mRoadName = "内部道路";
            } else {
                this.mRoadName = "无名道路";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i) {
        this.mLength = i;
    }

    public List<NaviLatLng> getCoords() {
        return this.mCoords;
    }

    public void setCoords(List<NaviLatLng> list) {
        this.mCoords = list;
    }

    public int getTime() {
        return this.mTime;
    }

    public void setTime(int i) {
        this.mTime = i;
    }

    public int getRoadClass() {
        return this.mRoadClass;
    }

    public void setRoadClass(int i) {
        this.mRoadClass = i;
    }

    public boolean getTrafficLights() {
        return this.mIsTrafficLightIn;
    }

    public void setTrafficLights(boolean z) {
        this.mIsTrafficLightIn = z;
    }

    public int getRoadType() {
        return this.mRoadType;
    }

    public void setRoadType(int i) {
        this.mRoadType = i;
    }

    public void setOwnership(int i) {
        this.ownership = i;
    }

    public int getLinkType() {
        return this.mLinkType;
    }

    public void setLinkType(int i) {
        this.mLinkType = i;
    }

    public int getTrafficStatus() {
        return this.trafficStatus;
    }

    public void setTrafficStatus(int i) {
        this.trafficStatus = i;
    }
}
