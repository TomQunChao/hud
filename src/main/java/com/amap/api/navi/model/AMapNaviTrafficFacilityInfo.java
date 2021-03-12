package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.TrafficFacilityInfo;

public class AMapNaviTrafficFacilityInfo extends TrafficFacilityInfo {
    public AMapNaviTrafficFacilityInfo(TrafficFacilityInfo trafficFacilityInfo) {
        try {
            this.type = trafficFacilityInfo.type;
            this.longitude = trafficFacilityInfo.longitude;
            this.latitude = trafficFacilityInfo.latitude;
            this.distance = trafficFacilityInfo.distance;
            this.limitSpeed = trafficFacilityInfo.limitSpeed;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getLimitSpeed() {
        return this.limitSpeed;
    }

    public void setLimitSpeed(int i) {
        this.limitSpeed = i;
    }

    public double getCoorX() {
        return this.longitude;
    }

    public void setCoorX(double d) {
        this.longitude = d;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public int getBroadcastType() {
        return this.type;
    }

    public void setBroadcastType(int i) {
        this.type = i;
    }

    public double getCoorY() {
        return this.latitude;
    }

    public void setCoorY(double d) {
        this.latitude = d;
    }
}
