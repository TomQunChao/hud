package com.amap.api.navi.enums;

public class NaviLimitType {
    public static final int TYPE_ACCIDENT_AREA = 6;
    public static final int TYPE_CHECK_POINT = 91;
    public static final int TYPE_CROSSWIND_AREA = 16;
    public static final int TYPE_DOUBLE_NARROW = 15;
    public static final int TYPE_FAILWAY_CROSS = 8;
    public static final int TYPE_FALLING_ROCKS = 7;
    public static final int TYPE_LEFT_INTERFLOW = 1;
    public static final int TYPE_LEFT_NARROW = 13;
    public static final int TYPE_LINKING_TURN = 5;
    public static final int TYPE_MAX_SPEED_LIMIT = 10;
    public static final int TYPE_MIN_SPEED_LIMIT = 11;
    public static final int TYPE_REVERSE_TURN = 4;
    public static final int TYPE_RIGHT_INTERFLOW = 2;
    public static final int TYPE_RIGHT_NARROW = 14;
    public static final int TYPE_SHARP_TURN = 3;
    public static final int TYPE_SLIPPERY = 9;
    public static final int TYPE_TRUCK_HEIGHT_LIMIT = 81;
    public static final int TYPE_TRUCK_WEIGHT_LIMIT = 83;
    public static final int TYPE_TRUCK_WIDTH_LIMIT = 82;
    public static final int TYPE_VILLAGE = 12;

    public static String getLimitText(int i) {
        if (i == 81) {
            return "限高";
        }
        if (i == 82) {
            return "限宽";
        }
        if (i == 83) {
            return "限重";
        }
        return null;
    }
}
