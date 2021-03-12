package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

public class GLTranslateAnimation extends GLAnimation {
    public double mCurXDelta = 0.0d;
    public double mCurYDelta = 0.0d;
    public double mFromXDelta = 0.0d;
    public double mFromYDelta = 0.0d;
    public double mToXDelta = 0.0d;
    public double mToYDelta = 0.0d;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        double d = this.mFromXDelta;
        this.mCurXDelta = d;
        this.mCurYDelta = this.mFromYDelta;
        double d2 = this.mToXDelta;
        if (d != d2) {
            this.mCurXDelta = d + ((d2 - d) * ((double) f));
        }
        double d3 = this.mFromYDelta;
        double d4 = this.mToYDelta;
        if (d3 != d4) {
            this.mCurYDelta = d3 + ((d4 - d3) * ((double) f));
        }
        gLTransformation.x = this.mCurXDelta;
        gLTransformation.y = this.mCurYDelta;
    }
}
