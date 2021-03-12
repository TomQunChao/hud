package com.autonavi.ae.gmap.gloverlay;

import com.amap.api.col.stln3.co;
import com.autonavi.ae.gmap.GLMapEngine;

public abstract class GLOverlay {
    protected boolean isNightStyle = false;
    protected int mCode;
    protected int mEngineID;
    protected co mGLMapView;
    boolean mIsInBundle = false;
    protected int mItemPriority = 0;
    protected long mNativeInstance = 0;

    public enum EAMapOverlayTpye {
        AMAPOVERLAY_POINT,
        AMAPOVERLAY_POLYLINE,
        AMAPOVERLAY_POLYGON,
        AMAPOVERLAY_ARC,
        AMAPOVERLAY_ARROW,
        AMAPOVERLAY_VECTOR,
        AMAPOVERLAY_GROUP,
        AMAPOVERLAY_MODEL,
        AMAPOVERLAY_PLANE
    }

    private static native int nativeGetCount(long j);

    private static native int nativeGetOverlayPriority(long j);

    private static native int nativeGetSubType(long j);

    private static native int nativeGetType(long j);

    private static native boolean nativeIsClickable(long j);

    private static native boolean nativeIsVisible(long j);

    private static native void nativeRemoveAll(long j);

    private static native void nativeRemoveItem(long j, int i);

    private static native void nativeSetClickable(long j, boolean z);

    private static native void nativeSetMaxDisplayLevel(long j, float f);

    private static native void nativeSetMinDisplayLevel(long j, float f);

    private static native void nativeSetOverlayItemPriority(long j, int i);

    private static native void nativeSetOverlayOnTop(long j, boolean z);

    private static native void nativeSetOverlayPriority(long j, int i);

    private static native void nativeSetShownMaxCount(long j, int i);

    protected static native void nativeSetVisible(long j, boolean z);

    public GLOverlay(int i, co coVar, int i2) {
        this.mEngineID = i;
        this.mGLMapView = coVar;
        this.mCode = i2;
        this.mNativeInstance = 0;
        this.mItemPriority = 0;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getCode() {
        return this.mCode;
    }

    public int getType() {
        long j = this.mNativeInstance;
        if (j == 0) {
            return -1;
        }
        return nativeGetType(j);
    }

    public int getSubType() {
        long j = this.mNativeInstance;
        if (j == 0) {
            return -1;
        }
        return nativeGetSubType(j);
    }

    public void removeItem(int i) {
        long j = this.mNativeInstance;
        if (j != 0) {
            nativeRemoveItem(j, i);
        }
    }

    public void removeAll() {
        long j = this.mNativeInstance;
        if (j != 0) {
            nativeRemoveAll(j);
            co coVar = this.mGLMapView;
        }
    }

    public int getSize() {
        long j = this.mNativeInstance;
        if (j == 0) {
            return 0;
        }
        return nativeGetCount(j);
    }

    public void setVisible(boolean z) {
        long j = this.mNativeInstance;
        if (j != 0) {
            nativeSetVisible(j, z);
        }
    }

    public boolean isVisible() {
        long j = this.mNativeInstance;
        if (j == 0) {
            return false;
        }
        return nativeIsVisible(j);
    }

    public void setClickable(boolean z) {
        long j = this.mNativeInstance;
        if (j != 0) {
            nativeSetClickable(j, z);
        }
    }

    public boolean isClickable() {
        long j = this.mNativeInstance;
        if (j == 0) {
            return false;
        }
        return nativeIsClickable(j);
    }

    public void clearFocus() {
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public void setMaxCountShown(int i) {
        nativeSetShownMaxCount(this.mNativeInstance, i);
    }

    public void setOverlayOnTop(boolean z) {
        nativeSetOverlayOnTop(this.mNativeInstance, z);
    }

    public void setMinDisplayLevel(float f) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f);
    }

    public void setMaxDisplayLevel(float f) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f);
    }

    public void setOverlayPriority(int i) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i);
        co coVar = this.mGLMapView;
        if (coVar != null && coVar.a() != null && (overlayBundle = this.mGLMapView.a().getOverlayBundle(this.mEngineID)) != null) {
            overlayBundle.sortOverlay();
        }
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public void setOverlayItemPriority(int i) {
        this.mItemPriority = i;
    }

    /* access modifiers changed from: package-private */
    public void releaseInstance() {
        long j = this.mNativeInstance;
        if (j != 0) {
            this.mNativeInstance = 0;
            GLMapEngine.destroyOverlay(this.mEngineID, j);
        }
    }

    public void useNightStyle(boolean z) {
        this.isNightStyle = z;
    }
}
