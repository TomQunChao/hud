package com.autonavi.amap.mapcore.message;

import com.autonavi.ae.gmap.AbstractMapMessage;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

public abstract class AbstractGestureMapMessage extends AbstractMapMessage {
    public int anchorX;
    public int anchorY;
    public int height = 0;
    public boolean isGestureScaleByMapCenter = false;
    public boolean isUseAnchor = false;
    private int state = 0;
    public int width = 0;

    @Override // com.autonavi.ae.gmap.AbstractMapMessage
    public abstract int getType();

    public abstract void runCameraUpdate(GLMapState gLMapState);

    public AbstractGestureMapMessage(int i) {
        this.state = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.state = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    /* access modifiers changed from: protected */
    public void win2geo(GLMapState gLMapState, int i, int i2, IPoint iPoint) {
        gLMapState.screenToP20Point(i, i2, iPoint);
    }

    /* access modifiers changed from: protected */
    public IPoint getAnchorGeoPoint(GLMapState gLMapState, int i, int i2) {
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point(i, i2, obtain);
        return obtain;
    }

    public int getMapGestureState() {
        return this.state;
    }
}
