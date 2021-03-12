package com.amap.api.navi;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.amap.api.navi.model.RouteOverlayOptions;

public class AMapNaviViewOptions {
    public static final int HUD_MIRROR_SHOW = 2;
    public static final int HUD_NORMAL_SHOW = 1;
    private boolean afterRouteAutoGray = false;
    private boolean autoDrawRoute = true;
    private Bitmap carBitmap;
    private Bitmap defaultOverBitmap;
    private Bitmap defaultTrafficBitmap;
    private Bitmap endBitmap;
    private Bitmap fourCornersBitmap;
    private boolean isAutoChangeZoom = false;
    private boolean isAutoDisplayOverview = false;
    private boolean isAutoLockCar = false;
    private boolean isAutoNaviViewNightMode = false;
    private boolean isCameraBubbleShow = true;
    private boolean isCameraInfoUpdateEnabled = true;
    private boolean isCompassEnabled = true;
    private boolean isLaneInfoShow = true;
    private boolean isLayoutVisible = true;
    private boolean isModelCrossDisplayShow = true;
    boolean isNaviArrowVisible = true;
    private boolean isNaviNight = false;
    private boolean isReCalculateRouteForTrafficJam = false;
    private boolean isReCalculateRouteForYaw = true;
    private boolean isRealCrossDisplayShow = true;
    private boolean isRouteListButtonShow = true;
    private boolean isScreenAlwaysBright = true;
    private boolean isSensorEnable = true;
    private boolean isSettingMenuEnabled = false;
    private boolean isTrafficBarEnabled = true;
    private boolean isTrafficInfoUpdateEnabled = true;
    private boolean isTrafficLayerEnabled = true;
    private boolean isTrafficLine = true;
    private Rect landscape;
    private int leaderLineColor = -1;
    private long lockMapDelayed = 5000;
    private RouteOverlayOptions mRouteOverlayOptions;
    private double mapCenterX = 0.5d;
    private double mapCenterY = 0.6666666666666666d;
    private String mapStylePath;
    private Bitmap monitorBitmap;
    private Bitmap pressedOverBitmap;
    private Bitmap pressedTrafficBitmap;
    private Bitmap startBitmap;
    private int tilt = 0;
    private Rect vertical;
    private Bitmap wayBitmap;
    private int zoom = 18;

    public boolean isAfterRouteAutoGray() {
        return this.afterRouteAutoGray;
    }

    public void setAfterRouteAutoGray(boolean z) {
        this.afterRouteAutoGray = z;
    }

    public boolean isAutoNaviViewNightMode() {
        return this.isAutoNaviViewNightMode;
    }

    public void setAutoNaviViewNightMode(boolean z) {
        this.isAutoNaviViewNightMode = z;
    }

    public boolean isAutoLockCar() {
        return this.isAutoLockCar;
    }

    public void setAutoLockCar(boolean z) {
        this.isAutoLockCar = z;
    }

    public boolean isCameraBubbleShow() {
        return this.isCameraBubbleShow;
    }

    public void setCameraBubbleShow(boolean z) {
        this.isCameraBubbleShow = z;
    }

    public void setSensorEnable(boolean z) {
        this.isSensorEnable = z;
    }

    public boolean isSensorEnable() {
        return this.isSensorEnable;
    }

    public RouteOverlayOptions getRouteOverlayOptions() {
        return this.mRouteOverlayOptions;
    }

    public void setRouteOverlayOptions(RouteOverlayOptions routeOverlayOptions) {
        if (routeOverlayOptions != null) {
            this.mRouteOverlayOptions = routeOverlayOptions;
        }
    }

    public void setCrossLocation(Rect rect, Rect rect2) {
        if (rect != null) {
            this.landscape = rect;
        }
        if (rect2 != null) {
            this.vertical = rect2;
        }
    }

    public Rect getLandscapeCross() {
        return this.landscape;
    }

    public Rect getVerticalCross() {
        return this.vertical;
    }

    public Bitmap getCarBitmap() {
        return this.carBitmap;
    }

    public void setCarBitmap(Bitmap bitmap) {
        this.carBitmap = bitmap;
    }

    public Bitmap getFourCornersBitmap() {
        return this.fourCornersBitmap;
    }

    public void setFourCornersBitmap(Bitmap bitmap) {
        this.fourCornersBitmap = bitmap;
    }

    public boolean isCompassEnabled() {
        return this.isCompassEnabled;
    }

    public void setCompassEnabled(Boolean bool) {
        this.isCompassEnabled = bool.booleanValue();
    }

    public boolean isTrafficBarEnabled() {
        return this.isTrafficBarEnabled;
    }

    public void setTrafficBarEnabled(Boolean bool) {
        this.isTrafficBarEnabled = bool.booleanValue();
    }

    public boolean isTrafficLayerEnabled() {
        return this.isTrafficLayerEnabled;
    }

    public void setTrafficLayerEnabled(Boolean bool) {
        this.isTrafficLayerEnabled = bool.booleanValue();
    }

    public boolean isRouteListButtonShow() {
        return this.isRouteListButtonShow;
    }

    public void setRouteListButtonShow(boolean z) {
        this.isRouteListButtonShow = z;
    }

    public boolean isNaviNight() {
        return this.isNaviNight;
    }

    public void setNaviNight(boolean z) {
        this.isNaviNight = z;
        this.mapStylePath = "";
    }

    public void setCustomMapStylePath(String str) {
        this.mapStylePath = str;
    }

    public String getCustomMapStylePath() {
        return this.mapStylePath;
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        this.startBitmap = bitmap;
    }

    public Bitmap getStartMarker() {
        return this.startBitmap;
    }

    public void setEndPointBitmap(Bitmap bitmap) {
        this.endBitmap = bitmap;
    }

    public Bitmap getEndMarker() {
        return this.endBitmap;
    }

    public void setWayPointBitmap(Bitmap bitmap) {
        this.wayBitmap = bitmap;
    }

    public Bitmap getWayMarker() {
        return this.wayBitmap;
    }

    public void setMonitorCameraBitmap(Bitmap bitmap) {
        this.monitorBitmap = bitmap;
    }

    public Bitmap getMonitorMarker() {
        return this.monitorBitmap;
    }

    public void setMonitorCameraEnabled(Boolean bool) {
    }

    public boolean isScreenAlwaysBright() {
        return this.isScreenAlwaysBright;
    }

    public void setScreenAlwaysBright(boolean z) {
        this.isScreenAlwaysBright = z;
    }

    public boolean isTrafficInfoUpdateEnabled() {
        return this.isTrafficInfoUpdateEnabled;
    }

    public void setTrafficInfoUpdateEnabled(boolean z) {
        this.isTrafficInfoUpdateEnabled = z;
    }

    public boolean isCameraInfoUpdateEnabled() {
        return this.isCameraInfoUpdateEnabled;
    }

    public void setCameraInfoUpdateEnabled(boolean z) {
        this.isCameraInfoUpdateEnabled = z;
    }

    public boolean isReCalculateRouteForYaw() {
        return this.isReCalculateRouteForYaw;
    }

    public void setReCalculateRouteForYaw(Boolean bool) {
        this.isReCalculateRouteForYaw = bool.booleanValue();
    }

    public boolean isReCalculateRouteForTrafficJam() {
        return this.isReCalculateRouteForTrafficJam;
    }

    public void setReCalculateRouteForTrafficJam(Boolean bool) {
        this.isReCalculateRouteForTrafficJam = bool.booleanValue();
    }

    public boolean isSettingMenuEnabled() {
        return this.isSettingMenuEnabled;
    }

    public void setSettingMenuEnabled(Boolean bool) {
        this.isSettingMenuEnabled = bool.booleanValue();
    }

    public boolean isTrafficLine() {
        return this.isTrafficLine;
    }

    public void setTrafficLine(boolean z) {
        this.isTrafficLine = z;
    }

    public int getLeaderLineColor() {
        return this.leaderLineColor;
    }

    public boolean isLeaderLineEnabled() {
        return this.leaderLineColor != -1;
    }

    public void setLeaderLineEnabled(int i) {
        this.leaderLineColor = i;
    }

    public boolean isLayoutVisible() {
        return this.isLayoutVisible;
    }

    public void setLayoutVisible(boolean z) {
        this.isLayoutVisible = z;
    }

    public long getLockMapDelayed() {
        return this.lockMapDelayed;
    }

    public void setLockMapDelayed(long j) {
        this.lockMapDelayed = j;
    }

    public boolean isAutoDrawRoute() {
        return this.autoDrawRoute;
    }

    public void setAutoDrawRoute(boolean z) {
        this.autoDrawRoute = z;
    }

    public boolean isRealCrossDisplayShow() {
        return this.isRealCrossDisplayShow;
    }

    public void setRealCrossDisplayShow(boolean z) {
        if (!z) {
            this.isRealCrossDisplayShow = false;
        }
    }

    public boolean isModelCrossDisplayShow() {
        return this.isModelCrossDisplayShow;
    }

    @Deprecated
    public void setCrossDisplayShow(boolean z) {
        if (!z) {
            this.isModelCrossDisplayShow = z;
        }
    }

    public void setModeCrossDisplayShow(boolean z) {
        if (!z) {
            this.isModelCrossDisplayShow = z;
        }
    }

    public boolean isLaneInfoShow() {
        return this.isLaneInfoShow;
    }

    public void setLaneInfoShow(boolean z) {
        this.isLaneInfoShow = z;
    }

    public int getZoom() {
        return this.zoom;
    }

    public void setZoom(int i) {
        if (i < 14) {
            i = 14;
        } else if (i > 18) {
            i = 18;
        }
        this.zoom = i;
    }

    public int getTilt() {
        return this.tilt;
    }

    public void setTilt(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 60) {
            i = 60;
        }
        this.tilt = i;
    }

    public boolean isAutoChangeZoom() {
        return this.isAutoChangeZoom;
    }

    public void setAutoChangeZoom(boolean z) {
        this.isAutoChangeZoom = z;
    }

    public void setPointToCenter(double d, double d2) {
        this.mapCenterX = d;
        this.mapCenterY = d2;
    }

    public double getMapCenter_X() {
        return this.mapCenterX;
    }

    public double getMapCenter_Y() {
        return this.mapCenterY;
    }

    public void setTrafficBitmap(Bitmap bitmap, Bitmap bitmap2) {
        this.defaultTrafficBitmap = bitmap;
        this.pressedTrafficBitmap = bitmap2;
    }

    public void setOverBitmap(Bitmap bitmap, Bitmap bitmap2) {
        this.defaultOverBitmap = bitmap;
        this.pressedOverBitmap = bitmap2;
    }

    public Bitmap getDefaultTrafficBitmap() {
        return this.defaultTrafficBitmap;
    }

    public Bitmap getPressedTrafficBitmap() {
        return this.pressedTrafficBitmap;
    }

    public Bitmap getDefaultOverBitmap() {
        return this.defaultOverBitmap;
    }

    public Bitmap getPressedOverBitmap() {
        return this.pressedOverBitmap;
    }

    public void setAutoDisplayOverview(boolean z) {
        this.isAutoDisplayOverview = z;
    }

    public boolean isAutoDisplayOverview() {
        return this.isAutoDisplayOverview;
    }

    public boolean isNaviArrowVisible() {
        return this.isNaviArrowVisible;
    }

    public void setNaviArrowVisible(boolean z) {
        this.isNaviArrowVisible = z;
    }
}
