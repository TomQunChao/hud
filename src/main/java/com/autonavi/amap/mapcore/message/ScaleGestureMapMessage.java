package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;

public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX = 0;
    public int pivotY = 0;
    public float scaleDelta = 0.0f;

    public static ScaleGestureMapMessage obtain(int i, float f, int i2, int i3) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i, f, i2, i3);
        }
        acquire.reset();
        acquire.setParams(i, f, i2, i3);
        return acquire;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public static void destory() {
        M_POOL.destory();
    }

    private void setParams(int i, float f, int i2, int i3) {
        setState(i);
        this.scaleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public ScaleGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        setParams(i, f, i2, i3);
    }

    @Override // com.autonavi.ae.gmap.AbstractMapMessage, com.autonavi.amap.mapcore.message.AbstractGestureMapMessage
    public int getType() {
        return 1;
    }

    @Override // com.autonavi.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint iPoint;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i = this.width >> 1;
            i2 = this.height >> 1;
        }
        IPoint iPoint2 = null;
        if (i > 0 || i2 > 0) {
            iPoint2 = IPoint.obtain();
            iPoint = IPoint.obtain();
            win2geo(gLMapState, i, i2, iPoint2);
            gLMapState.setMapGeoCenter(iPoint2.x, iPoint2.y);
        } else {
            iPoint = null;
        }
        setMapZoomer(gLMapState);
        if (i > 0 || i2 > 0) {
            win2geo(gLMapState, i, i2, iPoint);
            if (iPoint2 != null) {
                gLMapState.setMapGeoCenter((iPoint2.x * 2) - iPoint.x, (iPoint2.y * 2) - iPoint.y);
            }
            gLMapState.recalculate();
        }
        if (iPoint2 != null) {
            iPoint2.recycle();
        }
        if (iPoint != null) {
            iPoint.recycle();
        }
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }
}
