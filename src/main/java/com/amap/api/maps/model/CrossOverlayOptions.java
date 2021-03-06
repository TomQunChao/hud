package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;

public class CrossOverlayOptions {
    GLCrossVector.AVectorCrossAttr a = null;
    private Bitmap b = null;

    public GLCrossVector.AVectorCrossAttr getAttribute() {
        return this.a;
    }

    public CrossOverlayOptions setAttribute(GLCrossVector.AVectorCrossAttr aVectorCrossAttr) {
        this.a = aVectorCrossAttr;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap bitmap) {
        this.b = bitmap;
        return this;
    }

    public Bitmap getRes() {
        return this.b;
    }
}
