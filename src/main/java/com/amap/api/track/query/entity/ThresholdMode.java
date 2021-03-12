package com.amap.api.track.query.entity;

public class ThresholdMode {
    public static final int GPS_THRESHOLD = 20;
    public static final int GPS_WIFI_THRESHOLD = 100;

    public static int getThresholdMode(int i) {
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
