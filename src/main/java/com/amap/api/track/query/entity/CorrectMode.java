package com.amap.api.track.query.entity;

public class CorrectMode {
    public static final int DRIVING = 1;
    public static final int NONE = 0;

    public static String getMode(int i) {
        if (i != 1) {
            return "n";
        }
        return "driving";
    }
}
