package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class ConstantRotationOverLife extends RotationOverLife {
    private float a = 0.0f;

    public ConstantRotationOverLife(float f) {
        this.a = f;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateConstantRotationOverLife(this.a);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.a;
    }
}
