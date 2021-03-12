package com.amap.api.navi;

public interface AMapNaviViewListener {
    void onLockMap(boolean z);

    void onMapTypeChanged(int i);

    boolean onNaviBackClick();

    void onNaviCancel();

    void onNaviMapMode(int i);

    void onNaviSetting();

    void onNaviTurnClick();

    void onNaviViewLoaded();

    void onNaviViewShowMode(int i);

    void onNextRoadClick();

    void onScanViewButtonClick();
}
