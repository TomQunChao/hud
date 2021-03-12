package com.amap.api.navi.model;

import com.amap.api.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public class AMapNaviPath {
    private int allLength;
    private int allTime;
    private LatLngBounds bounds;
    private List<AMapNaviCameraInfo> cameras;
    private NaviLatLng carToFootPoint;
    private NaviLatLng center;
    private int[] cityAdcodeList;
    private int dataVersion;
    private NaviLatLng endPoi;
    private List<AMapNaviForbiddenInfo> forbiddenInfos;
    private String labels;
    private List<NaviLatLng> lightList;
    private List<AMapNaviLimitInfo> limitInfos;
    private List<NaviLatLng> list;
    private List<AMapNaviStep> mSteps;
    private long pathid;
    private AMapRestrictionInfo restrictionInfo;
    private NaviLatLng startPoi;
    private int stepsCount;
    private int strategy;
    private int tollCost = 0;
    private List<AMapTrafficStatus> trafficStatuses = new ArrayList();
    private List<NaviLatLng> wayPoi;
    public int[] wayPointIndex = null;

    public long getPathid() {
        return this.pathid;
    }

    public void setPathid(long j) {
        this.pathid = j;
    }

    public void setCameras(List<AMapNaviCameraInfo> list2) {
        this.cameras = list2;
    }

    public List<AMapNaviCameraInfo> getAllCameras() {
        return this.cameras;
    }

    public int[] getWayPointIndex() {
        return this.wayPointIndex;
    }

    public List<NaviLatLng> getWayPoint() {
        return this.wayPoi;
    }

    /* access modifiers changed from: package-private */
    public void setWayPoint(List<NaviLatLng> list2) {
        this.wayPoi = list2;
    }

    public NaviLatLng getStartPoint() {
        return this.startPoi;
    }

    /* access modifiers changed from: package-private */
    public void setStartPoint(NaviLatLng naviLatLng) {
        this.startPoi = naviLatLng;
    }

    public NaviLatLng getEndPoint() {
        return this.endPoi;
    }

    /* access modifiers changed from: package-private */
    public void setEndPoint(NaviLatLng naviLatLng) {
        this.endPoi = naviLatLng;
    }

    public NaviLatLng getCenterForPath() {
        return this.center;
    }

    /* access modifiers changed from: package-private */
    public void setCenter(NaviLatLng naviLatLng) {
        this.center = naviLatLng;
    }

    public LatLngBounds getBoundsForPath() {
        return this.bounds;
    }

    /* access modifiers changed from: package-private */
    public void setBounds(LatLngBounds latLngBounds) {
        this.bounds = latLngBounds;
    }

    public List<AMapNaviStep> getSteps() {
        return this.mSteps;
    }

    /* access modifiers changed from: package-private */
    public void setSteps(List<AMapNaviStep> list2) {
        this.mSteps = list2;
    }

    public List<NaviLatLng> getCoordList() {
        return this.list;
    }

    /* access modifiers changed from: package-private */
    public void setList(List<NaviLatLng> list2) {
        this.list = list2;
    }

    /* access modifiers changed from: package-private */
    public AMapNaviStep getStep(int i) {
        return null;
    }

    public int getAllLength() {
        return this.allLength;
    }

    /* access modifiers changed from: package-private */
    public void setAllLength(int i) {
        this.allLength = i;
    }

    public int getStrategy() {
        return this.strategy;
    }

    /* access modifiers changed from: package-private */
    public void setStrategy(int i) {
        this.strategy = i;
    }

    public int getAllTime() {
        return this.allTime;
    }

    /* access modifiers changed from: package-private */
    public void setAllTime(int i) {
        this.allTime = i;
    }

    public int getStepsCount() {
        return this.stepsCount;
    }

    /* access modifiers changed from: package-private */
    public void setStepsCount(int i) {
        this.stepsCount = i;
    }

    public int getTollCost() {
        return this.tollCost;
    }

    /* access modifiers changed from: package-private */
    public void setTollCost(int i) {
        this.tollCost = i;
    }

    public void setTrafficStatus(List<AMapTrafficStatus> list2) {
        this.trafficStatuses = list2;
    }

    public List<AMapTrafficStatus> getTrafficStatuses() {
        return this.trafficStatuses;
    }

    public void setLabels(String str) {
        this.labels = str;
    }

    public String getLabels() {
        return this.labels;
    }

    public void setRestrictionInfo(AMapRestrictionInfo aMapRestrictionInfo) {
        this.restrictionInfo = aMapRestrictionInfo;
    }

    public AMapRestrictionInfo getRestrictionInfo() {
        return this.restrictionInfo;
    }

    public void setCityAdcodeList(int[] iArr) {
        this.cityAdcodeList = iArr;
    }

    public int[] getCityAdcodeList() {
        return this.cityAdcodeList;
    }

    public NaviLatLng getCarToFootPoint() {
        return this.carToFootPoint;
    }

    public void setCarToFootPoint(NaviLatLng naviLatLng) {
        this.carToFootPoint = naviLatLng;
    }

    public void setDataVersion(int i) {
        this.dataVersion = i;
    }

    public int getDataVersion() {
        return this.dataVersion;
    }

    public void setLightList(List<NaviLatLng> list2) {
        this.lightList = list2;
    }

    public List<NaviLatLng> getLightList() {
        return this.lightList;
    }

    public List<AMapNaviLimitInfo> getLimitInfos() {
        return this.limitInfos;
    }

    public void setLimitInfos(List<AMapNaviLimitInfo> list2) {
        this.limitInfos = list2;
    }

    public List<AMapNaviForbiddenInfo> getForbiddenInfos() {
        return this.forbiddenInfos;
    }

    public void setForbiddenInfos(List<AMapNaviForbiddenInfo> list2) {
        this.forbiddenInfos = list2;
    }
}
