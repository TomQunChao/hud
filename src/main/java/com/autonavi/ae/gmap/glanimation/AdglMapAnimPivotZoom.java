package com.autonavi.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.IPoint;

public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam = null;

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            float mapZoomer = gLMapState.getMapZoomer();
            if (((double) Math.abs(this.mapLevelTo - mapZoomer)) < 1.0E-6d) {
                this.isOver = true;
                this.hasCheckParams = true;
                return;
            }
            this.zoomParam.setFromValue(mapZoomer);
            this.zoomParam.setToValue(this.mapLevelTo);
            if (!this.zoomCenter) {
                IPoint obtain = IPoint.obtain();
                gLMapState.getMapGeoCenter(obtain);
                this.beginCenterGeoX = obtain.x;
                this.beginCenterGeoY = obtain.y;
                IPoint obtain2 = IPoint.obtain();
                gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
                this.pivotGeoX = obtain2.x;
                this.pivotGeoY = obtain2.y;
                obtain.recycle();
                obtain2.recycle();
            }
            this.hasCheckParams = true;
            this.isOver = false;
            this.startTime = SystemClock.uptimeMillis();
        }
    }

    public AdglMapAnimPivotZoom(int i) {
        reset();
        this.duration = i;
    }

    public void setToMapZoomAndPivot(float f, int i, Point point) {
        this.zoomParam = new AbstractAdglAnimationParam1V();
        this.zoomParam.setInterpolatorType(i, 1.0f);
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 3.0f) {
            f = 3.0f;
        }
        this.mapLevelTo = f;
        if (point != null) {
            this.winPivotX = (float) point.x;
            this.winPivotY = (float) point.y;
            this.zoomCenter = false;
        }
    }

    @Override // com.autonavi.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState != null) {
            if (!this.hasCheckParams) {
                commitAnimation(obj);
            }
            if (!this.isOver) {
                this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
                float f = ((float) this.offsetTime) / ((float) this.duration);
                if (f > 1.0f) {
                    this.isOver = true;
                    f = 1.0f;
                }
                if (f >= 0.0f && f <= 1.0f) {
                    this.zoomParam.setNormalizedTime(f);
                    float curValue = this.zoomParam.getCurValue();
                    if (curValue > 20.0f) {
                        this.isOver = true;
                        curValue = 20.0f;
                    }
                    if (curValue < 3.0f) {
                        this.isOver = true;
                        curValue = 3.0f;
                    }
                    if (!this.zoomCenter) {
                        float pow = (float) Math.pow(2.0d, (double) (curValue - this.zoomParam.getFromValue()));
                        int i = this.pivotGeoX;
                        int i2 = this.beginCenterGeoX;
                        float f2 = 1.0f - (1.0f / pow);
                        int i3 = (int) (((float) (i - i2)) * f2);
                        int i4 = this.pivotGeoY;
                        int i5 = this.beginCenterGeoY;
                        gLMapState.setMapGeoCenter(i2 + i3, i5 + ((int) (((float) (i4 - i5)) * f2)));
                    }
                    gLMapState.setMapZoomer(curValue);
                }
            }
        }
    }
}
