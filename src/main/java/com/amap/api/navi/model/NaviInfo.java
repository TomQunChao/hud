package com.amap.api.navi.model;

import android.graphics.Bitmap;
import com.autonavi.wtbt.DGNaviInfo;

public class NaviInfo {
    @Deprecated
    public NaviLatLng cameraCoord;
    @Deprecated
    public NaviLatLng currentCoord;
    public int currentSpeed;
    private Bitmap iconBitmap = null;
    @Deprecated
    public int m_CameraDist;
    public int m_CameraSpeed;
    public int m_CameraType;
    @Deprecated
    public int m_CarDirection;
    public int m_CurLinkNum;
    public int m_CurPointNum;
    public String m_CurRoadName;
    public int m_CurSegNum;
    public int m_HawkIndex;
    public int m_Icon;
    public double m_Latitude;
    public int m_LimitedSpeed;
    @Deprecated
    public double m_Longitude;
    public String m_NextRoadName;
    public int m_RouteRemainDis;
    public int m_RouteRemainTime;
    public int m_SAPADist;
    @Deprecated
    public int m_SAPAType;
    public int m_SegRemainDis;
    public int m_SegRemainTime;
    public int m_SegTipsDis;
    public int m_Split;
    public int m_Type;
    public AMapNotAvoidInfo notAvoidInfo;

    public NaviInfo() {
    }

    public NaviInfo(DGNaviInfo dGNaviInfo) {
        try {
            this.m_Type = dGNaviInfo.m_Type;
            this.m_CurRoadName = dGNaviInfo.m_CurRoadName;
            this.m_NextRoadName = dGNaviInfo.m_NextRoadName;
            this.m_SAPADist = dGNaviInfo.m_SAPADist;
            this.m_CameraDist = dGNaviInfo.m_CameraDist;
            this.m_CameraType = dGNaviInfo.m_CameraType;
            this.m_CameraSpeed = dGNaviInfo.m_CameraSpeed;
            this.m_RouteRemainDis = dGNaviInfo.m_RouteRemainDis;
            this.m_RouteRemainTime = dGNaviInfo.m_RouteRemainTime;
            this.m_Latitude = dGNaviInfo.m_Latitude;
            this.m_Longitude = dGNaviInfo.m_Longitude;
            this.m_SegRemainDis = dGNaviInfo.m_SegRemainDis;
            this.m_SegRemainTime = dGNaviInfo.m_SegRemainTime;
            this.m_CarDirection = dGNaviInfo.m_CarDirection;
            this.currentCoord = new NaviLatLng(dGNaviInfo.m_Latitude, dGNaviInfo.m_Longitude);
            this.m_CurSegNum = dGNaviInfo.m_CurSegNum;
            this.m_CurLinkNum = dGNaviInfo.m_CurLinkNum;
            this.m_CurPointNum = dGNaviInfo.m_CurPointNum;
            this.m_Icon = dGNaviInfo.m_Icon;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviInfo(com.autonavi.rtbt.DGNaviInfo dGNaviInfo) {
        try {
            this.m_Type = dGNaviInfo.m_Type;
            this.m_CurRoadName = dGNaviInfo.m_CurRoadName;
            this.m_NextRoadName = dGNaviInfo.m_NextRoadName;
            this.m_SAPADist = dGNaviInfo.m_SAPADist;
            this.m_CameraDist = dGNaviInfo.m_CameraDist;
            this.m_CameraType = dGNaviInfo.m_CameraType;
            this.m_CameraSpeed = dGNaviInfo.m_CameraSpeed;
            this.m_RouteRemainDis = dGNaviInfo.m_RouteRemainDis;
            this.m_RouteRemainTime = dGNaviInfo.m_RouteRemainTime;
            this.m_Latitude = dGNaviInfo.m_Latitude;
            this.m_Longitude = dGNaviInfo.m_Longitude;
            this.m_SegRemainDis = dGNaviInfo.m_SegRemainDis;
            this.m_SegRemainTime = dGNaviInfo.m_SegRemainTime;
            this.m_CarDirection = dGNaviInfo.m_CarDirection;
            this.currentCoord = new NaviLatLng(dGNaviInfo.m_Latitude, dGNaviInfo.m_Longitude);
            this.m_CurSegNum = dGNaviInfo.m_CurSegNum;
            this.m_CurLinkNum = dGNaviInfo.m_CurLinkNum;
            this.m_CurPointNum = dGNaviInfo.m_CurPointNum;
            this.m_Icon = dGNaviInfo.m_Icon;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(int i) {
        this.currentSpeed = i;
    }

    public int getNaviType() {
        return this.m_Type;
    }

    public void setNaviType(int i) {
        this.m_Type = i;
    }

    public String getCurrentRoadName() {
        return this.m_CurRoadName;
    }

    public void setCurrentRoadName(String str) {
        this.m_CurRoadName = str;
    }

    public String getNextRoadName() {
        return this.m_NextRoadName;
    }

    public void setNextRoadName(String str) {
        this.m_NextRoadName = str;
    }

    public int getServiceAreaDistance() {
        return this.m_SAPADist;
    }

    public void setServiceAreaDistance(int i) {
        this.m_SAPADist = i;
    }

    public int getCameraDistance() {
        return this.m_CameraDist;
    }

    public void setCameraDistance(int i) {
        this.m_CameraDist = i;
    }

    public int getCameraType() {
        return this.m_CameraType;
    }

    public void setCameraType(int i) {
        this.m_CameraType = i;
    }

    public int getLimitSpeed() {
        return this.m_CameraSpeed;
    }

    public void setLimitSpeed(int i) {
        this.m_CameraSpeed = i;
    }

    public int getIconType() {
        return this.m_Icon;
    }

    public void setIconType(int i) {
        this.m_Icon = i;
    }

    public int getPathRetainDistance() {
        return this.m_RouteRemainDis;
    }

    public void setPathRetainDistance(int i) {
        this.m_RouteRemainDis = i;
    }

    public int getPathRetainTime() {
        return this.m_RouteRemainTime;
    }

    public void setPathRetainTime(int i) {
        this.m_RouteRemainTime = i;
    }

    public int getCurStepRetainDistance() {
        return this.m_SegRemainDis;
    }

    public void setCurStepRetainDistance(int i) {
        this.m_SegRemainDis = i;
    }

    public int getCurStepRetainTime() {
        return this.m_SegRemainTime;
    }

    public void setCurStepRetainTime(int i) {
        this.m_SegRemainTime = i;
    }

    public int getDirection() {
        return this.m_CarDirection;
    }

    public void setDirection(int i) {
        this.m_CarDirection = i;
    }

    public NaviLatLng getCoord() {
        return this.currentCoord;
    }

    public void setCoord(NaviLatLng naviLatLng) {
        this.currentCoord = naviLatLng;
    }

    public int getCurStep() {
        return this.m_CurSegNum;
    }

    public void setCurStep(int i) {
        this.m_CurSegNum = i;
    }

    public int getCurLink() {
        return this.m_CurLinkNum;
    }

    public void setCurLink(int i) {
        this.m_CurLinkNum = i;
    }

    public int getCurPoint() {
        return this.m_CurPointNum;
    }

    public void setCurPoint(int i) {
        this.m_CurPointNum = i;
    }

    public NaviLatLng getCameraCoord() {
        return this.cameraCoord;
    }

    public void setCameraCoord(NaviLatLng naviLatLng) {
        this.cameraCoord = naviLatLng;
    }

    public void setLatitude(double d) {
        this.m_Latitude = d;
    }

    public void setLongitude(double d) {
        this.m_Longitude = d;
    }

    public Bitmap getIconBitmap() {
        return this.iconBitmap;
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }
}
