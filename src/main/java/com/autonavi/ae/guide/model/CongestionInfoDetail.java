package com.autonavi.ae.guide.model;

import com.autonavi.ae.route.model.Coor3DPoint;
import com.autonavi.ae.route.model.GeoPoint;

public class CongestionInfoDetail {
    public int beginCoorIndex;
    public int beginCoorIndex3D;
    public int beginExactLength;
    public int beginExactLength3D;
    public GeoPoint beginExactPoint;
    public Coor3DPoint beginExactPoint3D;
    public int beginLinkID;
    public int beginSectionID;
    public int beginSegID;
    public int endCoorIndex;
    public int endCoorIndex3D;
    public int endExactLength;
    public int endExactLength3D;
    public GeoPoint endExactPoint;
    public Coor3DPoint endExactPoint3D;
    public int endLinkID;
    public int endSectionID;
    public int endSegID;
    public int remainDist;
    public int scopeFlag;
    public int status;
    public int timeOfSeconds;
}
