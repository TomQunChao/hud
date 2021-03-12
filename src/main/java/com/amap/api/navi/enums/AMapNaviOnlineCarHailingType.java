package com.amap.api.navi.enums;

public enum AMapNaviOnlineCarHailingType {
    NONE(0),
    PICKUP(1),
    TRANSPORT(2);
    
    private int value;

    private AMapNaviOnlineCarHailingType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
