package com.amap.api.navi.model;

import com.autonavi.wtbt.NaviGuideItem;

public class NaviGuide extends NaviGuideItem {
    public AMapNaviGuide aMapNaviGuide;
    private NaviLatLng coord;
    private int segCount;
    private int startSegId;
    private int toll;

    public NaviGuide(NaviGuideItem naviGuideItem) {
        try {
            this.m_Length = naviGuideItem.m_Length;
            this.m_Icon = naviGuideItem.m_Icon;
            this.m_Name = naviGuideItem.m_Name;
            this.m_UseTime = naviGuideItem.m_UseTime;
            this.coord = new NaviLatLng(naviGuideItem.m_Latitude, naviGuideItem.m_Longitude);
            this.aMapNaviGuide = new AMapNaviGuide(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviGuide(com.autonavi.rtbt.NaviGuideItem naviGuideItem) {
        try {
            this.m_Length = naviGuideItem.m_Length;
            this.m_Icon = naviGuideItem.m_Icon;
            this.m_Name = naviGuideItem.m_Name;
            this.m_UseTime = naviGuideItem.m_UseTime;
            this.coord = new NaviLatLng(naviGuideItem.m_Latitude, naviGuideItem.m_Longitude);
            this.aMapNaviGuide = new AMapNaviGuide(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviGuide() {
        this.aMapNaviGuide = new AMapNaviGuide();
    }

    public NaviLatLng getCoord() {
        return this.coord;
    }

    public void setCoord(NaviLatLng naviLatLng) {
        try {
            this.coord = naviLatLng;
            this.aMapNaviGuide.setCoord(this.coord);
            this.m_Latitude = naviLatLng.getLatitude();
            this.m_Longitude = naviLatLng.getLongitude();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getLength() {
        return this.m_Length;
    }

    public void setLength(int i) {
        try {
            this.m_Length = i;
            this.aMapNaviGuide.setLength(this.m_Length);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIconType() {
        return this.m_Icon;
    }

    public void setIconType(int i) {
        try {
            this.m_Icon = i;
            this.aMapNaviGuide.setIconType(this.m_Icon);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getName() {
        return this.m_Name;
    }

    public void setName(String str) {
        try {
            this.m_Name = str;
            this.aMapNaviGuide.setName(this.m_Name);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getTime() {
        return this.m_UseTime;
    }

    public void setTime(int i) {
        try {
            this.m_UseTime = i;
            this.aMapNaviGuide.setTime(this.m_UseTime);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setToll(int i) {
        try {
            this.toll = i;
            this.aMapNaviGuide.setToll(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getToll() {
        return this.toll;
    }

    public void setStartSegId(int i) {
        try {
            this.startSegId = i;
            this.aMapNaviGuide.setStartSegId(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getStartSegId() {
        return this.startSegId;
    }

    public void setSegCount(int i) {
        try {
            this.segCount = i;
            this.aMapNaviGuide.setSegCount(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getSegCount() {
        return this.segCount;
    }
}
