package com.amap.api.navi;

import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.autonavi.tbt.TrafficFacilityInfo;

public interface AMapNaviListener {
    @Deprecated
    void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo);

    @Deprecated
    void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo);

    void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr);

    void hideCross();

    void hideLaneInfo();

    void hideModeCross();

    void notifyParallelRoad(int i);

    void onArriveDestination();

    void onArrivedWayPoint(int i);

    void onCalculateRouteFailure(int i);

    void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult);

    void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult);

    void onCalculateRouteSuccess(int[] iArr);

    void onEndEmulatorNavi();

    void onGetNavigationText(int i, String str);

    void onGetNavigationText(String str);

    void onGpsOpenStatus(boolean z);

    void onInitNaviFailure();

    void onInitNaviSuccess();

    void onLocationChange(AMapNaviLocation aMapNaviLocation);

    void onNaviInfoUpdate(NaviInfo naviInfo);

    @Deprecated
    void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo);

    void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData);

    void onPlayRing(int i);

    void onReCalculateRouteForTrafficJam();

    void onReCalculateRouteForYaw();

    void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr);

    void onStartNavi(int i);

    void onTrafficStatusUpdate();

    void showCross(AMapNaviCross aMapNaviCross);

    void showLaneInfo(AMapLaneInfo aMapLaneInfo);

    void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2);

    void showModeCross(AMapModelCross aMapModelCross);

    void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo);

    void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat);

    void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr);

    void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i);
}
