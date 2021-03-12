package com.amap.api.navi.model;

public class AMapNaviGuide {
    public static int IconTypeArrivedDestination = 15;
    public static int IconTypeArrivedServiceArea = 13;
    public static int IconTypeArrivedTollGate = 14;
    public static int IconTypeArrivedTunnel = 16;
    public static int IconTypeArrivedWayPoint = 10;
    public static int IconTypeCrosswalk = 17;
    public static int IconTypeDefault = 1;
    public static int IconTypeEnterRoundabout = 11;
    public static int IconTypeLeft = 2;
    public static int IconTypeLeftAndAround = 8;
    public static int IconTypeLeftBack = 6;
    public static int IconTypeLeftFront = 4;
    public static int IconTypeLift = 23;
    public static int IconTypeNone = 0;
    public static int IconTypeOutRoundabout = 12;
    public static int IconTypeOverpass = 18;
    public static int IconTypePark = 21;
    public static int IconTypeRight = 3;
    public static int IconTypeRightBack = 7;
    public static int IconTypeRightFront = 5;
    public static int IconTypeSquare = 20;
    public static int IconTypeStaircase = 22;
    public static int IconTypeStraight = 9;
    public static int IconTypeUnderpass = 19;
    private NaviLatLng coord;
    private int mIcon;
    private int mLength;
    private String mName;
    private int mUseTime;
    private int segCount;
    private int startSegId;
    private int toll;

    public AMapNaviGuide(NaviGuide naviGuide) {
        try {
            this.mLength = naviGuide.m_Length;
            this.mIcon = naviGuide.m_Icon;
            this.mName = naviGuide.m_Name;
            this.mUseTime = naviGuide.getTime();
            this.coord = naviGuide.getCoord();
            this.segCount = naviGuide.getSegCount();
            this.startSegId = naviGuide.getStartSegId();
            this.toll = naviGuide.getToll();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    AMapNaviGuide() {
    }

    public NaviLatLng getCoord() {
        return this.coord;
    }

    /* access modifiers changed from: package-private */
    public void setCoord(NaviLatLng naviLatLng) {
        this.coord = naviLatLng;
    }

    public int getLength() {
        return this.mLength;
    }

    /* access modifiers changed from: package-private */
    public void setLength(int i) {
        this.mLength = i;
    }

    public int getIconType() {
        return this.mIcon;
    }

    /* access modifiers changed from: package-private */
    public void setIconType(int i) {
        this.mIcon = i;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public void setName(String str) {
        this.mName = str;
    }

    public int getTime() {
        return this.mUseTime;
    }

    /* access modifiers changed from: package-private */
    public void setTime(int i) {
        this.mUseTime = i;
    }

    public void setToll(int i) {
        this.toll = i;
    }

    public int getToll() {
        return this.toll;
    }

    public void setStartSegId(int i) {
        this.startSegId = i;
    }

    public int getStartSegId() {
        return this.startSegId;
    }

    public void setSegCount(int i) {
        this.segCount = i;
    }

    public int getSegCount() {
        return this.segCount;
    }
}
