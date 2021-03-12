package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class RectParticleShape extends ParticleShapeModule {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public RectParticleShape(float f, float f2, float f3, float f4, boolean z) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.isUseRatio = z;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRectParticleShape(this.a, this.b, this.c, this.d, this.isUseRatio);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }
}
