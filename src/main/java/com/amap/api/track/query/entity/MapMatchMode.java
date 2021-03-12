package com.amap.api.track.query.entity;

public class MapMatchMode {
    public static final int MAPMATCH = 1;
    public static final int NON_MAPMATCH = 0;

    public static int getMapMatchMode(int i) {
        if (i == 1) {
            return 1;
        }
        return 0;
    }
}
