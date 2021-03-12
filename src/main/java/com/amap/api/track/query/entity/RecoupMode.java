package com.amap.api.track.query.entity;

public class RecoupMode {
    public static final int DRIVING = 1;
    public static final int STRAIGHT_LINE = 0;

    public static int getMode(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return -1;
        }
    }

    public static boolean isValid(int i) {
        return i == 1 || i == 0;
    }
}
