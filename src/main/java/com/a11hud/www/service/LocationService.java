package com.a11hud.www.service;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

public class LocationService {
    private Context context;
    private AMapLocationListener locationListener = null;
    private AMapLocationClient mapLocationClient = null;

    public LocationService(Context context2, AMapLocationListener locationListener2) {
        this.context = context2;
        this.mapLocationClient = new AMapLocationClient(context2);
        this.mapLocationClient.setLocationOption(getDefaultLocationOptions());
        this.locationListener = locationListener2;
        setLocationListener(locationListener2);
    }

    private AMapLocationClientOption getDefaultLocationOptions() {
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(1000);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setMockEnable(true);
        mLocationOption.setHttpTimeOut(20000);
        mLocationOption.setLocationCacheEnable(false);
        return mLocationOption;
    }

    public void setLocationListener(AMapLocationListener locationListener2) {
        this.mapLocationClient.setLocationListener(locationListener2);
    }

    public boolean isEnabled() {
        AMapLocationClient aMapLocationClient = this.mapLocationClient;
        return aMapLocationClient != null && aMapLocationClient.isStarted();
    }

    public void start() {
        this.mapLocationClient.startLocation();
    }

    public void stop() {
        this.mapLocationClient.stopLocation();
    }

    public void destory() {
        this.mapLocationClient.unRegisterLocationListener(this.locationListener);
        this.mapLocationClient.onDestroy();
    }
}
