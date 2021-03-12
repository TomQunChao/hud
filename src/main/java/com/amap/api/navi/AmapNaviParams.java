package com.amap.api.navi;

import android.os.Bundle;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.model.AMapCarInfo;
import java.util.List;

public class AmapNaviParams {
    private Bundle bundle = null;
    private AMapCarInfo carInfo;
    private Poi end;
    private boolean isMultipleRouteNaviMode = true;
    private boolean isNeedCalculateRouteWhenPresent = true;
    private boolean isNeedDestroyDriveManagerInstanceWhenNaviExit = true;
    private boolean isShowExitNaviDialog = true;
    private boolean isTrafficEnabled = false;
    private boolean isUseInnerVoice = true;
    private AmapPageType mPageType = AmapPageType.ROUTE;
    private int mRouteStrategy = -1;
    private AmapNaviTheme mTheme = AmapNaviTheme.BLUE;
    private AmapNaviType mType = AmapNaviType.DRIVER;
    private int requestCode = 0;
    private boolean showCrossImage = true;
    private boolean showRouteStrategyPreferenceView = true;
    private Poi start;
    private List<Poi> wayPoints;

    public AmapNaviParams(Poi poi) {
        this.end = poi;
    }

    public AmapNaviParams(Poi poi, List<Poi> list, Poi poi2, AmapNaviType amapNaviType) {
        this.start = poi;
        this.wayPoints = list;
        this.end = poi2;
        this.mType = amapNaviType;
    }

    public AmapNaviParams(Poi poi, List<Poi> list, Poi poi2, AmapNaviType amapNaviType, AmapPageType amapPageType) {
        this.start = poi;
        this.wayPoints = list;
        this.end = poi2;
        this.mType = amapNaviType;
        this.mPageType = amapPageType;
    }

    public AmapNaviType getNaviType() {
        return this.mType;
    }

    public AmapPageType getPageType() {
        return this.mPageType;
    }

    public Poi getEnd() {
        return this.end;
    }

    public Poi getStart() {
        return this.start;
    }

    public List<Poi> getWays() {
        return this.wayPoints;
    }

    public AmapNaviParams setTheme(AmapNaviTheme amapNaviTheme) {
        this.mTheme = amapNaviTheme;
        return this;
    }

    public AmapNaviTheme getTheme() {
        return this.mTheme;
    }

    public boolean isNeedCalculateRouteWhenPresent() {
        return this.isNeedCalculateRouteWhenPresent;
    }

    public void setNeedCalculateRouteWhenPresent(boolean z) {
        this.isNeedCalculateRouteWhenPresent = z;
    }

    public boolean isNeedDestroyDriveManagerInstanceWhenNaviExit() {
        return this.isNeedDestroyDriveManagerInstanceWhenNaviExit;
    }

    public void setNeedDestroyDriveManagerInstanceWhenNaviExit(boolean z) {
        this.isNeedDestroyDriveManagerInstanceWhenNaviExit = z;
    }

    public boolean isShowExitNaviDialog() {
        return this.isShowExitNaviDialog;
    }

    public void setShowExitNaviDialog(boolean z) {
        this.isShowExitNaviDialog = z;
    }

    public AMapCarInfo getCarInfo() {
        return this.carInfo;
    }

    public void setCarInfo(AMapCarInfo aMapCarInfo) {
        this.carInfo = aMapCarInfo;
    }

    public void setUseInnerVoice(boolean z) {
        this.isUseInnerVoice = z;
    }

    public boolean getIsUseInnerVoice() {
        return this.isUseInnerVoice;
    }

    public int getRouteStrategy() {
        return this.mRouteStrategy;
    }

    public void setRouteStrategy(int i) {
        this.mRouteStrategy = i;
    }

    public boolean isShowCrossImage() {
        return this.showCrossImage;
    }

    public void setShowCrossImage(boolean z) {
        this.showCrossImage = z;
    }

    public boolean isShowRouteStrategyPreferenceView() {
        return this.showRouteStrategyPreferenceView;
    }

    public void setShowRouteStrategyPreferenceView(boolean z) {
        this.showRouteStrategyPreferenceView = z;
    }

    public void setTrafficEnabled(boolean z) {
        this.isTrafficEnabled = z;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public boolean isMultipleRouteNaviMode() {
        return this.isMultipleRouteNaviMode;
    }

    public void setMultipleRouteNaviMode(boolean z) {
        this.isMultipleRouteNaviMode = z;
    }
}
