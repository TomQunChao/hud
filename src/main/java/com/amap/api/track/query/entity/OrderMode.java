package com.amap.api.track.query.entity;

public class OrderMode {
    public static final int NEW_FIRST = 1;
    public static final int OLD_FIRST = 0;

    public static int getMode(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 1;
        }
    }
}
