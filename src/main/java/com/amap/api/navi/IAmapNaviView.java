package com.amap.api.navi;

import android.content.res.Configuration;
import android.os.Bundle;
import com.amap.api.maps.AMap;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.NextTurnTipView;
import com.amap.api.navi.view.OverviewButtonView;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficButtonView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.amap.api.navi.view.ZoomButtonView;
import com.amap.api.navi.view.ZoomInIntersectionView;

public interface IAmapNaviView {
    void displayOverview();

    double getAnchorX();

    double getAnchorY();

    DirectionView getLazyDirectionView();

    DriveWayView getLazyDriveWayView();

    NextTurnTipView getLazyNextTurnTipView();

    TrafficBarView getLazyTrafficBarView();

    TrafficButtonView getLazyTrafficButtonView();

    TrafficProgressBar getLazyTrafficProgressBarView();

    ZoomInIntersectionView getLazyZoomInIntersectionView();

    int getLockTilt();

    int getLockZoom();

    AMap getMap();

    int getNaviMode();

    AMapNaviViewOptions getViewOptions();

    void init();

    boolean isAutoChangeZoom();

    boolean isOrientationLandscape();

    boolean isRouteOverviewNow();

    boolean isShowRoadEnlarge();

    boolean isTrafficLine();

    void layout(boolean z, int i, int i2, int i3, int i4);

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void openNorthMode();

    void recoverLockMode();

    void setAMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener);

    void setCarOverlayVisible(boolean z);

    void setLazyDirectionView(DirectionView directionView);

    void setLazyDriveWayView(DriveWayView driveWayView);

    void setLazyNextTurnTipView(NextTurnTipView nextTurnTipView);

    void setLazyOverviewButtonView(OverviewButtonView overviewButtonView);

    void setLazyTrafficBarView(TrafficBarView trafficBarView);

    void setLazyTrafficButtonView(TrafficButtonView trafficButtonView);

    void setLazyTrafficProgressBarView(TrafficProgressBar trafficProgressBar);

    void setLazyZoomButtonView(ZoomButtonView zoomButtonView);

    void setLazyZoomInIntersectionView(ZoomInIntersectionView zoomInIntersectionView);

    void setLockTilt(int i);

    void setLockZoom(int i);

    void setNaviMode(int i);

    void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener);

    void setOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener);

    void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener);

    void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener);

    void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener);

    void setRouteOverlayVisible(boolean z);

    void setTrafficLightsVisible(boolean z);

    void setTrafficLine(boolean z);

    void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions);

    void zoomIn();

    void zoomOut();
}
