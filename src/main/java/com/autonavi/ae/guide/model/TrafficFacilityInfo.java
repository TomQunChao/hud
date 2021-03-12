package com.autonavi.ae.guide.model;

public class TrafficFacilityInfo {
    public int distance;
    public double latitude;
    public int limitSpeed;
    public double longitude;
    public int type;

    public TrafficFacilityInfo() {
    }

    public TrafficFacilityInfo(CruiseFacilityInfo cruiseFacilityInfo) {
        this.latitude = cruiseFacilityInfo.latitude;
        this.longitude = cruiseFacilityInfo.longitude;
        this.type = cruiseFacilityInfo.type;
        this.distance = cruiseFacilityInfo.distance;
        this.limitSpeed = cruiseFacilityInfo.limitSpeed;
    }
}
