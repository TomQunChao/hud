package com.autonavi.amap.mapcore;

public class AbstractNativeInstance {
    protected long nativeInstance = 0;

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
    }

    public void createNativeInstace() {
    }
}
