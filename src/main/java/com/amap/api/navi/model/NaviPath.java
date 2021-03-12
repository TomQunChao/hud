package com.amap.api.navi.model;

import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.route.model.RestrictionInfo;
import java.util.ArrayList;
import java.util.List;

public class NaviPath {
    private int allLength;
    private int allTime;
    public AMapNaviPath amapNaviPath = new AMapNaviPath();
    public LatLngBounds bounds;
    private List<AMapNaviCameraInfo> cameras;
    public NaviLatLng center;
    private NaviLatLng endPoi;
    private List<AMapNaviForbiddenInfo> forbiddenInfos;
    private List<AMapNaviGuide> guideList = new ArrayList();
    private long id;
    List<IndependInfo> independInfo = null;
    private List<AMapNaviLimitInfo> limitInfos;
    private List<NaviLatLng> list;
    private List<AMapNaviStep> listStep;
    private NaviLatLng maxCoordForPath = new NaviLatLng(0.0d, 0.0d);
    private NaviLatLng minCoordForPath = new NaviLatLng(2.147483647E9d, 2.147483647E9d);
    private long pathId;
    private NaviLatLng startPoi;
    private int stepsCount;
    private int strategy;
    private int tollCost = 0;
    private List<NaviLatLng> wayPoi;

    public void setCameras(List<AMapNaviCameraInfo> list2) {
        try {
            this.cameras = list2;
            this.amapNaviPath.setCameras(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<AMapNaviCameraInfo> getCameras() {
        return this.cameras;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public List<NaviLatLng> getWayPoint() {
        return this.wayPoi;
    }

    public void setWayPoint(List<NaviLatLng> list2) {
        try {
            this.wayPoi = list2;
            this.amapNaviPath.setWayPoint(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviLatLng getStartPoint() {
        return this.startPoi;
    }

    public void setStartPoint(NaviLatLng naviLatLng) {
        try {
            this.startPoi = naviLatLng;
            this.amapNaviPath.setStartPoint(naviLatLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviLatLng getEndPoint() {
        return this.endPoi;
    }

    public void setEndPoint(NaviLatLng naviLatLng) {
        try {
            this.endPoi = naviLatLng;
            this.amapNaviPath.setEndPoint(naviLatLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NaviLatLng getMaxCoordForPath() {
        return this.maxCoordForPath;
    }

    public NaviLatLng getMinCoordForPath() {
        return this.minCoordForPath;
    }

    public NaviLatLng getCenterForPath() {
        return this.center;
    }

    public void setCenter(NaviLatLng naviLatLng) {
        try {
            this.center = naviLatLng;
            this.amapNaviPath.setCenter(naviLatLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public LatLngBounds getBoundsForPath() {
        return this.bounds;
    }

    public void setBounds(LatLngBounds latLngBounds) {
        try {
            this.bounds = latLngBounds;
            this.amapNaviPath.setBounds(latLngBounds);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<AMapNaviStep> getSteps() {
        return this.listStep;
    }

    public void setListStep(List<AMapNaviStep> list2) {
        try {
            this.listStep = list2;
            this.amapNaviPath.setSteps(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<NaviLatLng> getCoordList() {
        return this.list;
    }

    public void setList(List<NaviLatLng> list2) {
        try {
            this.list = list2;
            this.amapNaviPath.setList(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getAllLength() {
        return this.allLength;
    }

    public void setAllLength(int i) {
        try {
            this.allLength = i;
            this.amapNaviPath.setAllLength(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getStrategy() {
        return this.strategy;
    }

    public void setStrategy(int i) {
        try {
            this.strategy = i;
            this.amapNaviPath.setStrategy(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLabels(String str) {
        try {
            this.amapNaviPath.setLabels(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getAllTime() {
        return this.allTime;
    }

    public void setAllTime(int i) {
        try {
            this.allTime = i;
            this.amapNaviPath.setAllTime(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getStepsCount() {
        return this.stepsCount;
    }

    public void setStepsCount(int i) {
        try {
            this.stepsCount = i;
            this.amapNaviPath.setStepsCount(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getTollCost() {
        return this.tollCost;
    }

    public void setTollCost(int i) {
        try {
            this.tollCost = i;
            this.amapNaviPath.setTollCost(this.tollCost);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setGuideList(List<AMapNaviGuide> list2) {
        try {
            this.guideList.clear();
            this.guideList.addAll(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<AMapNaviGuide> getGuideList() {
        return this.guideList;
    }

    public void setTrafficStatus(List<AMapTrafficStatus> list2) {
        try {
            this.amapNaviPath.setTrafficStatus(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRestrictionInfo(RestrictionInfo restrictionInfo) {
        try {
            this.amapNaviPath.setRestrictionInfo(new AMapRestrictionInfo(restrictionInfo));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCityAdcodeList(int[] iArr) {
        try {
            this.amapNaviPath.setCityAdcodeList(iArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCarToFootPoint(NaviLatLng naviLatLng) {
        try {
            this.amapNaviPath.setCarToFootPoint(naviLatLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLightList(List<NaviLatLng> list2) {
        try {
            this.amapNaviPath.setLightList(list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public long getPathId() {
        return this.pathId;
    }

    public void setPathId(long j) {
        this.pathId = j;
        this.amapNaviPath.setPathid(j);
    }

    public List<AMapNaviLimitInfo> getLimitInfos() {
        return this.limitInfos;
    }

    public void setLimitInfos(List<AMapNaviLimitInfo> list2) {
        this.limitInfos = list2;
        this.amapNaviPath.setLimitInfos(list2);
    }

    public List<AMapNaviForbiddenInfo> getForbiddenInfos() {
        return this.forbiddenInfos;
    }

    public void setForbiddenInfos(List<AMapNaviForbiddenInfo> list2) {
        this.forbiddenInfos = list2;
        this.amapNaviPath.setForbiddenInfos(list2);
    }

    public List<IndependInfo> getIndependInfo() {
        return this.independInfo;
    }

    public void setIndependInfo(List<IndependInfo> list2) {
        this.independInfo = list2;
    }
}
