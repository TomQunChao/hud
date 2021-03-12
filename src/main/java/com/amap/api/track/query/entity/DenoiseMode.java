package com.amap.api.track.query.entity;

public class DenoiseMode {
    public static final int DENOSE = 1;
    public static final int NON_DENOSE = 0;

    public static int getDenoseMode(int i) {
        if (i == 1) {
            return 1;
        }
        return 0;
    }
}
