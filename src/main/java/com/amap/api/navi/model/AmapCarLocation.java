package com.amap.api.navi.model;

import com.autonavi.rtbt.CarLocation;

public class AmapCarLocation {
    public int mCarDir;
    public double mLatitude;
    public double mLongitude;
    public int mMatchStatus;
    public int mSpeed;

    public AmapCarLocation(CarLocation carLocation) {
        this.mLongitude = carLocation.m_Longitude;
        this.mLatitude = carLocation.m_Latitude;
        this.mCarDir = carLocation.m_CarDir;
        this.mSpeed = carLocation.m_Speed;
        this.mMatchStatus = carLocation.m_MatchStatus;
    }

    public AmapCarLocation(com.autonavi.wtbt.CarLocation carLocation) {
        this.mLongitude = carLocation.m_Longitude;
        this.mLatitude = carLocation.m_Latitude;
        this.mCarDir = carLocation.m_CarDir;
        this.mSpeed = carLocation.m_Speed;
        this.mMatchStatus = carLocation.m_MatchStatus;
    }
}
