package com.amap.api.col.stln3;

import android.util.Pair;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: AbstractCameraBoundsMessage */
public final class dd extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(GLMapState gLMapState) {
        Pair<Float, IPoint> a = ic.a(this, this.mapConfig);
        if (a != null) {
            gLMapState.setMapZoomer(((Float) a.first).floatValue());
            gLMapState.setMapGeoCenter(((IPoint) a.second).x, ((IPoint) a.second).y);
            gLMapState.setCameraDegree(0.0f);
            gLMapState.setMapAngle(0.0f);
        }
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }
}
