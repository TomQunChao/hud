package com.amap.api.navi.model;

import com.autonavi.ae.guide.model.NotAvoidInfo;

public class AMapNotAvoidInfo {
    public static final int FORBID_GO_STRAIGHT = 4;
    public static final int FORBID_TURN_LEFT = 0;
    public static final int FORBID_TURN_LEFT_ROUND = 2;
    public static final int FORBID_TURN_RIGHT = 1;
    public static final int FORBID_TURN_RIGHT_ROUND = 3;
    public static final int LIMIT_HEIGHT = 1;
    public static final int LIMIT_RUN = 4;
    public static final int LIMIT_WEIGHT = 3;
    public static final int LIMIT_WIDTH = 2;
    public NaviLatLng coord2D;
    public NaviLatLng coord3D;
    public int distToCar;
    public int forbidType;
    public int type;
    public boolean valid;

    public AMapNotAvoidInfo(NotAvoidInfo notAvoidInfo) {
        this.type = notAvoidInfo.type;
        this.distToCar = notAvoidInfo.distToCar;
        this.coord2D = new NaviLatLng(notAvoidInfo.lat2D, notAvoidInfo.lon2D);
        this.coord3D = new NaviLatLng(notAvoidInfo.lat3D, notAvoidInfo.lon3D);
        this.forbidType = notAvoidInfo.forbidType;
    }

    public static String getLimitText(int i) {
        if (i == 1) {
            return "限高";
        }
        if (i == 2) {
            return "限宽";
        }
        if (i == 3) {
            return "限重";
        }
        if (i == 4) {
            return "禁行";
        }
        return null;
    }

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
