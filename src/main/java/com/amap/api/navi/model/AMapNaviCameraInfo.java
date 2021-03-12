package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.NaviCamera;
import com.autonavi.ae.guide.model.NaviIntervalCamera;
import com.autonavi.ae.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.ae.route.model.RouteCamera;

public class AMapNaviCameraInfo {
    private int averageSpeed;
    private int cameraDistance;
    private int cameraSpeed;
    private int cameraType;
    private int distance;
    private int reasonableSpeedInRemainDist;
    private int[] speed;
    private double x;
    private double y;

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(int i) {
        this.averageSpeed = i;
    }

    public int getReasonableSpeedInRemainDist() {
        return this.reasonableSpeedInRemainDist;
    }

    public void setReasonableSpeedInRemainDist(int i) {
        this.reasonableSpeedInRemainDist = i;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public int[] getSpeed() {
        return this.speed;
    }

    public void setSpeed(int[] iArr) {
        this.speed = iArr;
    }

    public AMapNaviCameraInfo() {
    }

    public AMapNaviCameraInfo(NaviCamera naviCamera) {
        try {
            this.x = naviCamera.lon;
            this.y = naviCamera.lat;
            this.cameraType = naviCamera.type;
            if (naviCamera.speed != null) {
                this.cameraSpeed = naviCamera.speed.length > 0 ? naviCamera.speed[0] : 0;
            }
            this.cameraDistance = naviCamera.distance;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviCameraInfo(RouteCamera routeCamera) {
        try {
            this.x = routeCamera.longitude;
            this.y = routeCamera.latitude;
            this.cameraType = routeCamera.cameraType;
            this.cameraSpeed = routeCamera.cameraSpeed;
            this.cameraDistance = 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void update(NaviIntervalCamera naviIntervalCamera) {
        try {
            this.x = naviIntervalCamera.lon;
            this.y = naviIntervalCamera.lat;
            this.cameraType = naviIntervalCamera.type;
            this.cameraSpeed = naviIntervalCamera.speed[0];
            this.speed = naviIntervalCamera.speed;
            this.distance = naviIntervalCamera.distance;
            this.cameraDistance = naviIntervalCamera.distance;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void update(NaviIntervalCameraDynamicInfo naviIntervalCameraDynamicInfo) {
        try {
            this.cameraSpeed = naviIntervalCameraDynamicInfo.speed[0];
            this.cameraDistance = naviIntervalCameraDynamicInfo.remainDistance;
            this.distance = naviIntervalCameraDynamicInfo.distance;
            this.averageSpeed = naviIntervalCameraDynamicInfo.averageSpeed;
            this.reasonableSpeedInRemainDist = naviIntervalCameraDynamicInfo.reasonableSpeedInRemainDist;
            this.speed = naviIntervalCameraDynamicInfo.speed;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int getCameraDistance() {
        return this.cameraDistance;
    }

    public int getCameraSpeed() {
        return this.cameraSpeed;
    }

    public int getCameraType() {
        return this.cameraType;
    }
}
