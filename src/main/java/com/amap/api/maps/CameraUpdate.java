package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public final class CameraUpdate {
    AbstractCameraUpdateMessage a;

    CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
