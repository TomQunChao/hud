package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private Random g = new Random();

    public RandomVelocityBetweenTwoConstants(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
        this.f = f7;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomVelocityBetweenTwoConstants(this.a, this.b, this.c, this.d, this.e, this.f);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.g.nextFloat();
        float f2 = this.d;
        float f3 = this.a;
        return (nextFloat * (f2 - f3)) + f3;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.g.nextFloat();
        float f2 = this.e;
        float f3 = this.b;
        return (nextFloat * (f2 - f3)) + f3;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.g.nextFloat();
        float f2 = this.f;
        float f3 = this.c;
        return (nextFloat * (f2 - f3)) + f3;
    }
}
