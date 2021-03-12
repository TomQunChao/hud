package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public abstract class ParticleShapeModule extends AbstractNativeInstance {
    protected boolean isUseRatio = false;

    public abstract float[] getPoint();

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleShapeModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
