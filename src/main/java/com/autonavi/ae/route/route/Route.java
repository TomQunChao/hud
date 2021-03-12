package com.autonavi.ae.route.route;

import com.autonavi.ae.route.model.AbnormalSec;
import com.autonavi.ae.route.model.AvoidTrafficJamInfo;
import com.autonavi.ae.route.model.DivAndIndependInfo;
import com.autonavi.ae.route.model.ForbiddenLineInfo;
import com.autonavi.ae.route.model.ForbiddenWideHighWeightInfo;
import com.autonavi.ae.route.model.GeoPoint;
import com.autonavi.ae.route.model.GroupSegment;
import com.autonavi.ae.route.model.InspectionStationInfo;
import com.autonavi.ae.route.model.JamInfo;
import com.autonavi.ae.route.model.JamSegment;
import com.autonavi.ae.route.model.LabelInfo;
import com.autonavi.ae.route.model.LightBarItem;
import com.autonavi.ae.route.model.LineIconPoint;
import com.autonavi.ae.route.model.LineItem;
import com.autonavi.ae.route.model.PathGrayInfo;
import com.autonavi.ae.route.model.PathShadowPoint;
import com.autonavi.ae.route.model.RestAreaInfo;
import com.autonavi.ae.route.model.RestrictionInfo;
import com.autonavi.ae.route.model.RouteCamera;
import com.autonavi.ae.route.model.RouteCamera3d;
import com.autonavi.ae.route.model.RouteIncident;
import com.autonavi.ae.route.model.TDRJamFadeArea;
import com.autonavi.ae.route.model.TipInfo;
import java.util.HashMap;
import java.util.Map;

public class Route {
    private LightBarItem[] lightBarItems;
    private long mPtr;
    public Map<Object, Object> mRouteInfo = new HashMap();

    private native LightBarItem[] nativeGetLightBarItems();

    private native int nativeUpdateTmcBar(LightBarItem[] lightBarItemArr);

    public native void addRef();

    public native double[] buildRarefyPoint(int i, int i2, double d, double d2, int i3, int i4);

    public native void decreaseRefAndRelease();

    public native void destroy();

    public native AbnormalSec getAbnormalSection(int i);

    public native int getAbnormalSectionCount();

    public native int getAbnormalState();

    public native RouteCamera[] getAllCamera();

    public native RouteCamera3d[] getAllCamera3d();

    public native GeoPoint[] getAllTrafficLight();

    public native long[] getAlongRoadID(int i, int i2);

    public native AvoidTrafficJamInfo[] getAvoidTrafficJamInfo();

    public native int getBypassLimitedRoad();

    public native int[] getCityAdcodeList();

    public native GeoPoint getClosestPoint(double d, double d2);

    public native int getDiffToTMCRoute();

    public native DivAndIndependInfo getDivAndIndependInfo();

    public native GeoPoint getEndPoint();

    public native ForbiddenLineInfo[] getForbiddenLineInfo();

    public native ForbiddenWideHighWeightInfo[] getForbiddenWideHighWeightInfo();

    public native PathGrayInfo getGrayPointIndex(PathShadowPoint pathShadowPoint);

    public native GroupSegment[] getGroupSegmentList();

    public native RouteIncident[] getInRouteIncident();

    public native InspectionStationInfo[] getInspectionStationInfo(int i, int i2);

    public native JamInfo[] getJamInfoList();

    public native JamSegment[] getJamSegment();

    public native LineIconPoint[] getLineIconPoints();

    public native LineItem[] getLineItems();

    public native String getNaviID();

    public native LineItem[] getNaviLineItems();

    public native int[] getOfflineDataVersionList();

    public native long getPathId();

    public native LabelInfo[] getPathLabel();

    public native long getPreviousNaviPathID();

    public native RestAreaInfo[] getRestAreas(int i, int i2);

    public native RestrictionInfo getRestrictionInfo();

    public native double[] getRouteBound(int i, int i2, int i3);

    public native RouteIncident[] getRouteIncident();

    public native int getRouteLength();

    public native int getRouteStrategy();

    public native int getRouteTime();

    public native double[] getSegEndPointList();

    public native int getSegmentCount();

    public native GeoPoint getStartPoint();

    public native TDRJamFadeArea getTDRJamFadeAreas();

    public native TipInfo getTip();

    public native int getTollCost();

    public native int getTollLength();

    public native int getTrafficLightNum();

    public native GeoPoint[] getVIAPoints();

    public native boolean isHolidayFree();

    public native boolean isOnline();

    public native boolean isTruckPath();

    public native void resetGrayPathInfo();

    public Route() {
    }

    public Route(long j) {
        this.mPtr = j;
    }

    public long getRouteId() {
        return this.mPtr;
    }

    public LightBarItem[] getLightBarItems() {
        LightBarItem[] lightBarItemArr = this.lightBarItems;
        if (lightBarItemArr != null) {
            return lightBarItemArr;
        }
        return nativeGetLightBarItems();
    }

    public int updateTmcBar(LightBarItem[] lightBarItemArr) {
        this.lightBarItems = lightBarItemArr;
        return nativeUpdateTmcBar(lightBarItemArr);
    }

    public RouteSegment getSegment(int i) {
        if (i >= getSegmentCount() || i < 0) {
            return null;
        }
        return new RouteSegment(this.mPtr, i);
    }

    public LineItem[] getLineItems(LightBarItem[] lightBarItemArr) {
        updateTmcBar(this.lightBarItems);
        return getNaviLineItems();
    }
}
