package com.amap.api.track.query.entity;

import com.amap.api.location.AMapLocationClientOption;

public class LocationMode {
    public static final int BATTERY_SAVING = 3;
    public static final int DEVICE_SENSORS = 2;
    public static final int HIGHT_ACCURACY = 1;

    public static AMapLocationClientOption.AMapLocationMode getLocationMode(int i) {
        switch (i) {
            case 1:
                return AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
            case 2:
                return AMapLocationClientOption.AMapLocationMode.Device_Sensors;
            case 3:
                return AMapLocationClientOption.AMapLocationMode.Battery_Saving;
            default:
                return AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        }
    }
}
