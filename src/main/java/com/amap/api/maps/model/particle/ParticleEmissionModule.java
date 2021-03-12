package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.AbstractNativeInstance;

public class ParticleEmissionModule extends AbstractNativeInstance {
    private final int a;
    private final int b;

    public ParticleEmissionModule(int i, int i2) {
        this.a = i;
        this.b = i2;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateParticleEmissionModule(this.a, this.b);
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeInstance != 0) {
            AMapNativeParticleSystem.nativeReleaseParticleEmissonModule(this.nativeInstance);
            this.nativeInstance = 0;
        }
    }
}
