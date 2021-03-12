package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;

public class CurveSizeOverLife extends SizeOverLife {
    private float a;
    private float b;
    private float c;

    public CurveSizeOverLife(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateCurveSizeOverLife(this.a, this.b, this.c);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f) {
        return 0.0f;
    }
}
