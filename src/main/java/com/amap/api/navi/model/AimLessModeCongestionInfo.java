package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.CruiseCongestionInfo;

public class AimLessModeCongestionInfo {
    private AMapCongestionLink[] amapCongestionLinks;
    private int congestionStatus;
    private double eventLat;
    private double eventLon;
    private int eventType;
    private int length;
    private String roadName;
    private int time;

    public AimLessModeCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        this.time = cruiseCongestionInfo.etaTime;
        this.length = cruiseCongestionInfo.length;
        this.roadName = cruiseCongestionInfo.roadName;
        this.congestionStatus = cruiseCongestionInfo.congestionStatus;
        this.eventType = cruiseCongestionInfo.eventType;
        this.eventLon = cruiseCongestionInfo.eventLon;
        this.eventLat = cruiseCongestionInfo.eventLat;
        this.amapCongestionLinks = new AMapCongestionLink[cruiseCongestionInfo.linkDatas.length];
        int i = 0;
        while (true) {
            AMapCongestionLink[] aMapCongestionLinkArr = this.amapCongestionLinks;
            if (i < aMapCongestionLinkArr.length) {
                aMapCongestionLinkArr[i] = new AMapCongestionLink(cruiseCongestionInfo.linkDatas[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public AMapCongestionLink[] getAmapCongestionLinks() {
        return this.amapCongestionLinks;
    }

    public int getEventType() {
        return this.eventType;
    }

    public void setEventType(int i) {
        this.eventType = i;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String str) {
        this.roadName = str;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public int getCongestionStatus() {
        return this.congestionStatus;
    }

    public void setCongestionStatus(int i) {
        this.congestionStatus = i;
    }

    public double getEventLon() {
        return this.eventLon;
    }

    public void setEventLon(double d) {
        this.eventLon = d;
    }

    public double getEventLat() {
        return this.eventLat;
    }

    public void setEventLat(double d) {
        this.eventLat = d;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
