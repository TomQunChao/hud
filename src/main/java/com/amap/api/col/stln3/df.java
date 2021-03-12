package com.amap.api.col.stln3;

import android.graphics.Point;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: AbstractCameraScrollMessage */
public final class df extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(GLMapState gLMapState) {
        float f = this.xPixel;
        float f2 = this.yPixel;
        float f3 = (((float) this.width) / 2.0f) + f;
        float f4 = (((float) this.height) / 2.0f) + f2;
        Point point = new Point();
        gLMapState.screenToP20Point((int) f3, (int) f4, point);
        gLMapState.setMapGeoCenter(point.x, point.y);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }
}
