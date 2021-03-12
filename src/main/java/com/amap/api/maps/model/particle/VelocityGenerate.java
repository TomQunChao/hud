package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public abstract class VelocityGenerate extends AbstractNativeInstance {
    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseVelocityOverLife(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }
}
