package com.amap.api.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.col.stln3.jb;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.rx;
import com.amap.api.col.stln3.sk;
import com.amap.api.maps.AMap;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.NextTurnTipView;
import com.amap.api.navi.view.OverviewButtonView;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficButtonView;
import com.amap.api.navi.view.ZoomButtonView;
import com.amap.api.navi.view.ZoomInIntersectionView;

public class AMapNaviView extends FrameLayout {
    public static final int CAR_UP_MODE = 0;
    public static final int NORTH_UP_MODE = 1;
    private IAmapNaviView core;

    public AMapNaviView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            init(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            init(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviView(Context context) {
        super(context);
        try {
            init(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviView(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        super(context);
        try {
            init(aMapNaviViewOptions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public double getAnchorX() {
        try {
            return this.core.getAnchorX();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getAnchorX");
            return 0.0d;
        }
    }

    public double getAnchorY() {
        try {
            return this.core.getAnchorY();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getAnchorY");
            return 0.0d;
        }
    }

    public int getLockZoom() {
        try {
            return this.core.getLockZoom();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLockZoom");
            return 18;
        }
    }

    public void setLockZoom(int i) {
        try {
            this.core.setLockZoom(i);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLockZoom");
        }
    }

    public int getLockTilt() {
        try {
            return this.core.getLockTilt();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLockTilt");
            return 30;
        }
    }

    public void setLockTilt(int i) {
        try {
            this.core.setLockTilt(i);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLockTilt");
        }
    }

    public int getNaviMode() {
        try {
            return this.core.getNaviMode();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getNaviMode");
            return 0;
        }
    }

    public void setNaviMode(int i) {
        try {
            this.core.setNaviMode(i);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setNaviMode");
        }
    }

    public boolean isAutoChangeZoom() {
        try {
            return this.core.isAutoChangeZoom();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "isAutoChangeZoom");
            return false;
        }
    }

    public AMapNaviViewOptions getViewOptions() {
        try {
            return this.core.getViewOptions();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getViewOptions");
            return null;
        }
    }

    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        try {
            this.core.setViewOptions(aMapNaviViewOptions);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setViewOptions");
        }
    }

    public AMap getMap() {
        try {
            return this.core.getMap();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getMap");
            return null;
        }
    }

    private void init(AMapNaviViewOptions aMapNaviViewOptions) {
        try {
            mm.a(getContext().getApplicationContext());
            this.core = (IAmapNaviView) sk.a(getContext(), mj.a(), "com.amap.api.navi.wrapper.AmapNaviViewWrapper", jb.class, new Class[]{AMapNaviView.class, AMapNaviViewOptions.class}, new Object[]{this, aMapNaviViewOptions});
        } catch (Throwable th) {
            mj.a(th);
            this.core = new jb(this, aMapNaviViewOptions);
        }
        this.core.init();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            this.core.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onConfigurationChanged");
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.core.onCreate(bundle);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onCreate");
        }
    }

    public final void onResume() {
        try {
            this.core.onResume();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onResume");
        }
    }

    public final void onPause() {
        try {
            this.core.onPause();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onPause");
        }
    }

    public final void onDestroy() {
        try {
            this.core.onDestroy();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onDestroy");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.core.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onSaveInstanceState");
        }
    }

    public void displayOverview() {
        try {
            this.core.displayOverview();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "displayOverview");
        }
    }

    public void openNorthMode() {
        try {
            this.core.openNorthMode();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "openNorthMode");
        }
    }

    public void recoverLockMode() {
        try {
            this.core.recoverLockMode();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "recoverLockMode");
        }
    }

    public boolean isTrafficLine() {
        try {
            return this.core.isTrafficLine();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "isTrafficLine");
            return true;
        }
    }

    public void setTrafficLine(boolean z) {
        try {
            this.core.setTrafficLine(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "isTrafficLine");
        }
    }

    public void setAMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener) {
        try {
            this.core.setAMapNaviViewListener(aMapNaviViewListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setAMapNaviViewListener");
        }
    }

    public boolean isShowRoadEnlarge() {
        try {
            return this.core.isShowRoadEnlarge();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "isShowRoadEnlarge");
            return true;
        }
    }

    public boolean isOrientationLandscape() {
        try {
            return this.core.isOrientationLandscape();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "isOrientationLandscape");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
            this.core.layout(z, i, i2, i3, i4);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "onLayout");
        }
    }

    public DriveWayView getLazyDriveWayView() {
        try {
            return this.core.getLazyDriveWayView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyDriveWayView");
            return null;
        }
    }

    public void setLazyDriveWayView(DriveWayView driveWayView) {
        try {
            this.core.setLazyDriveWayView(driveWayView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyDriveWayView");
        }
    }

    public ZoomInIntersectionView getLazyZoomInIntersectionView() {
        try {
            return this.core.getLazyZoomInIntersectionView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyZoomInIntersectionView");
            return null;
        }
    }

    public void setLazyZoomInIntersectionView(ZoomInIntersectionView zoomInIntersectionView) {
        try {
            this.core.setLazyZoomInIntersectionView(zoomInIntersectionView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyZoomInIntersectionView");
        }
    }

    public TrafficBarView getLazyTrafficBarView() {
        try {
            return this.core.getLazyTrafficBarView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyTrafficBarView");
            return null;
        }
    }

    public void setLazyTrafficBarView(TrafficBarView trafficBarView) {
        try {
            this.core.setLazyTrafficBarView(trafficBarView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyTrafficBarView");
        }
    }

    public DirectionView getLazyDirectionView() {
        try {
            return this.core.getLazyDirectionView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyDirectionView");
            return null;
        }
    }

    public void setLazyDirectionView(DirectionView directionView) {
        try {
            this.core.setLazyDirectionView(directionView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyDirectionView");
        }
    }

    public TrafficButtonView getLazyTrafficButtonView() {
        try {
            return this.core.getLazyTrafficButtonView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyTrafficButtonView");
            return null;
        }
    }

    public void setLazyTrafficButtonView(TrafficButtonView trafficButtonView) {
        try {
            this.core.setLazyTrafficButtonView(trafficButtonView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyTrafficButtonView");
        }
    }

    public NextTurnTipView getLazyNextTurnTipView() {
        try {
            return this.core.getLazyNextTurnTipView();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "getLazyNextTurnTipView");
            return null;
        }
    }

    public void setLazyNextTurnTipView(NextTurnTipView nextTurnTipView) {
        try {
            this.core.setLazyNextTurnTipView(nextTurnTipView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyNextTurnTipView");
        }
    }

    public void zoomIn() {
        try {
            this.core.zoomIn();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "zoomIn");
        }
    }

    public void zoomOut() {
        try {
            this.core.zoomOut();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "zoomOut");
        }
    }

    public void setLazyZoomButtonView(ZoomButtonView zoomButtonView) {
        try {
            this.core.setLazyZoomButtonView(zoomButtonView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyZoomButtonView");
        }
    }

    public void setLazyOverviewButtonView(OverviewButtonView overviewButtonView) {
        try {
            this.core.setLazyOverviewButtonView(overviewButtonView);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyOverviewButtonView");
        }
    }

    public boolean isRouteOverviewNow() {
        try {
            return this.core.isRouteOverviewNow();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setLazyOverviewButtonView");
            return false;
        }
    }

    public void setOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        try {
            this.core.setOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setOnMapLoadedListener");
        }
    }

    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) {
        try {
            this.core.setOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setOnCameraChangeListener");
        }
    }

    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) {
        try {
            this.core.setOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setOnMapTouchListener");
        }
    }

    public void setRouteOverlayVisible(boolean z) {
        try {
            this.core.setRouteOverlayVisible(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setRouteOverlayVisible");
        }
    }

    public void setCarOverlayVisible(boolean z) {
        try {
            this.core.setCarOverlayVisible(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setCarOverlayVisible");
        }
    }

    public void setTrafficLightsVisible(boolean z) {
        try {
            this.core.setTrafficLightsVisible(z);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setCarOverlayVisible");
        }
    }

    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) {
        try {
            this.core.setOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setOnMarkerClickListener");
        }
    }

    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) {
        try {
            this.core.setOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviView", "setOnPolylineClickListener");
        }
    }
}
