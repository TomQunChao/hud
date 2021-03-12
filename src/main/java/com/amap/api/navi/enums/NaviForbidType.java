package com.amap.api.navi.enums;

public class NaviForbidType {
    public static final int FORBID_GO_STRAIGHT = 4;
    public static final int FORBID_TURN_LEFT = 0;
    public static final int FORBID_TURN_LEFT_ROUND = 2;
    public static final int FORBID_TURN_RIGHT = 1;
    public static final int FORBID_TURN_RIGHT_ROUND = 3;

    public static String getForbiddenText(int i) {
        if (i == 0) {
            return "禁止左转";
        }
        if (i == 1) {
            return "禁止右转";
        }
        if (i == 2) {
            return "禁止左掉头";
        }
        if (i == 3) {
            return "禁止右调头";
        }
        if (i == 4) {
            return "禁止直行";
        }
        return null;
    }
}
