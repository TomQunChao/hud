package com.autonavi.tbt;

import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;

@Deprecated
public class TrafficFacilityInfo {
    public int boardcastType;
    public double coor_X;
    public double coor_Y;
    public int distance;
    public int limitSpeed;

    public TrafficFacilityInfo(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
        this.coor_X = aMapNaviTrafficFacilityInfo.getCoorX();
        this.coor_Y = aMapNaviTrafficFacilityInfo.getCoorY();
        this.boardcastType = aMapNaviTrafficFacilityInfo.getBroadcastType();
        this.distance = aMapNaviTrafficFacilityInfo.getDistance();
        this.limitSpeed = aMapNaviTrafficFacilityInfo.getLimitSpeed();
    }

    public TrafficFacilityInfo() {
        this.coor_X = -1.0d;
        this.coor_Y = -1.0d;
        this.boardcastType = -1;
        this.distance = 0;
        this.limitSpeed = 0;
    }
}
