package com.amap.api.maps.model.particle;

import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import java.util.Random;

public class RandomColorBetWeenTwoConstants extends ColorGenerate {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float[] i = {1.0f, 1.0f, 1.0f, 1.0f};
    private Random j = new Random();

    public RandomColorBetWeenTwoConstants(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a = f2 / 255.0f;
        this.b = f3 / 255.0f;
        this.c = f4 / 255.0f;
        this.d = f5 / 255.0f;
        this.e = f6 / 255.0f;
        this.f = f7 / 255.0f;
        this.g = f8 / 255.0f;
        this.h = f9 / 255.0f;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateRandomColorBetWeenTwoConstants(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.i;
        float nextFloat = this.j.nextFloat();
        float f2 = this.e;
        float f3 = this.a;
        fArr[0] = (nextFloat * (f2 - f3)) + f3;
        float[] fArr2 = this.i;
        float nextFloat2 = this.j.nextFloat();
        float f4 = this.f;
        float f5 = this.b;
        fArr2[1] = (nextFloat2 * (f4 - f5)) + f5;
        float[] fArr3 = this.i;
        float nextFloat3 = this.j.nextFloat();
        float f6 = this.g;
        float f7 = this.c;
        fArr3[2] = (nextFloat3 * (f6 - f7)) + f7;
        float[] fArr4 = this.i;
        float nextFloat4 = this.j.nextFloat();
        float f8 = this.h;
        float f9 = this.d;
        fArr4[3] = (nextFloat4 * (f8 - f9)) + f9;
        return this.i;
    }
}
