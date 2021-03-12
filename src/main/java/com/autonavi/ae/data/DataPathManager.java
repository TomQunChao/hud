package com.autonavi.ae.data;

public final class DataPathManager {
    private long mShadow = 0;

    private native long nativeInit(long j);

    DataPathManager(long j) {
        this.mShadow = nativeInit(j);
    }
}
