package com.amap.api.navi.enums;

public enum NetWorkingProtocol {
    HTTP(0),
    HTTPS(1);
    
    private int value;

    private NetWorkingProtocol(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
