package com.amap.api.track.query.entity;

public class DriveMode {
    public static final int DRIVING = 0;
    public static final int RIDING = 1;
    public static final int WALKING = 2;

    public static String getDriveMode(int i) {
        switch (i) {
            case 0:
                return "driving";
            case 1:
                return "riding";
            case 2:
                return "walking";
            default:
                return "";
        }
    }
}
