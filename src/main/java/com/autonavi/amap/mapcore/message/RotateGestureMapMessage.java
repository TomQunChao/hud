package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;

public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta = 0.0f;
    public int pivotX = 0;
    public int pivotY = 0;

    public static RotateGestureMapMessage obtain(int i, float f, int i2, int i3) {
        RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new RotateGestureMapMessage(i, f, i2, i3);
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
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    public RotateGestureMapMessage(int i, float f, int i2, int i3) {
        super(i);
        setParams(i, f, i2, i3);
        this.angleDelta = f;
        this.pivotX = i2;
        this.pivotY = i3;
    }

    @Override // com.autonavi.ae.gmap.AbstractMapMessage, com.autonavi.amap.mapcore.message.AbstractGestureMapMessage
    public int getType() {
        return 2;
    }

    @Override // com.autonavi.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint iPoint;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i = this.pivotX;
        int i2 = this.pivotY;
        if (this.isUseAnchor) {
            i = this.anchorX;
            i2 = this.anchorY;
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
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
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
}
