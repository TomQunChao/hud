package com.amap.api.navi;

import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.autonavi.ae.guide.model.NaviCongestionInfo;

public interface MyNaviListener extends AMapNaviListener {
    void carProjectionChange(AmapCarLocation amapCarLocation);

    void onChangeNaviPath(int i);

    void onDeletePath(long[] jArr);

    void onGpsSignalWeak(boolean z);

    void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo);

    void onInnerNaviInfoUpdate(InnerNaviInfo[] innerNaviInfoArr);

    void onSelectMainPathStatus(long j);

    void onSelectRouteId(int i);

    void onStopNavi();

    void onSuggestChangePath(long j, long j2, int i);

    void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo);

    void updateBackupPath(NaviPath[] naviPathArr);
}
