package com.amap.api.maps.model.particle;

import com.amap.api.col.stln3.gb;

public class ParticleOverlay {
    private gb a;

    public ParticleOverlay(gb gbVar) {
        this.a = gbVar;
    }

    public void setVisible(boolean z) {
        try {
            this.a.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            this.a.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i, int i2) {
        try {
            this.a.a(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i) {
        try {
            this.a.a(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDuration(long j) {
        try {
            this.a.a(j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j) {
        try {
            this.a.b(j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            this.a.a(velocityGenerate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z) {
        try {
            this.a.a(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            this.a.a(particleShapeModule);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            this.a.a(particleEmissionModule);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        try {
            return this.a.c();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            this.a.a(particleOverLifeModule);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            this.a.a(colorGenerate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
