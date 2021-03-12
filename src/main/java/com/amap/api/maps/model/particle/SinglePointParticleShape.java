package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class SinglePointParticleShape extends ParticleShapeModule {
    float[] a;

    public SinglePointParticleShape(float f, float f2, float f3, boolean z) {
        this.a = new float[3];
        float[] fArr = this.a;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.isUseRatio = z;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateSinglePointParticleShape(this.a[0], this.a[1], this.a[2], this.isUseRatio);
        } catch (Throwable th) {
        }
    }

    public SinglePointParticleShape(float f, float f2, float f3) {
        this(f, f2, f3, false);
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.a;
    }
}
