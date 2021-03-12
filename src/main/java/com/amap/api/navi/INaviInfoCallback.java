package com.amap.api.navi;

import android.view.View;
import com.amap.api.navi.model.AMapNaviLocation;

public interface INaviInfoCallback {
    View getCustomNaviBottomView();

    View getCustomNaviView();

    void onArriveDestination(boolean z);

    void onArrivedWayPoint(int i);

    void onCalculateRouteFailure(int i);

    void onCalculateRouteSuccess(int[] iArr);

    void onExitPage(int i);

    void onGetNavigationText(String str);

    void onInitNaviFailure();

    void onLocationChange(AMapNaviLocation aMapNaviLocation);

    void onReCalculateRoute(int i);

    void onStartNavi(int i);

    void onStopSpeaking();

    void onStrategyChanged(int i);
}
