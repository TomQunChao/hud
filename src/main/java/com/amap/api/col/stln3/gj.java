package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;
import com.autonavi.amap.mapcore.AMapNativeParticleSystem;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ParticleLayerDelegateImp */
public final class gj implements gb {
    float a = 1.0f;
    int b = 0;
    int c = 0;
    private long d = 0;
    private gq e;
    private cm f;
    private boolean g = true;
    private float h = 1.0f;
    private String i;
    private BitmapDescriptor j;
    private boolean k = false;
    private List<cx> l = new ArrayList();
    private int m = 0;
    private ParticleOverlayOptions n = new ParticleOverlayOptions();
    private boolean o = false;
    private float p = -1.0f;
    private float q = -1.0f;
    private float[] r = new float[16];
    private float[] s = new float[16];
    private float[] t = new float[16];

    public gj(cm cmVar) {
        this.f = cmVar;
    }

    public final void a(ParticleOverlayOptions particleOverlayOptions) {
        synchronized (this) {
            if (particleOverlayOptions != null) {
                BitmapDescriptor icon = particleOverlayOptions.getIcon();
                if (icon != null) {
                    synchronized (this) {
                        if (!icon.equals(this.j)) {
                            this.k = false;
                            this.j = icon;
                        }
                    }
                }
                this.n.setMaxParticles(particleOverlayOptions.getMaxParticles());
                this.n.setLoop(particleOverlayOptions.isLoop());
                this.n.setDuration(particleOverlayOptions.getDuration());
                this.n.setParticleLifeTime(particleOverlayOptions.getParticleLifeTime());
                this.n.setParticleEmissionModule(particleOverlayOptions.getParticleEmissionModule());
                this.n.setParticleShapeModule(particleOverlayOptions.getParticleShapeModule());
                this.n.setParticleStartSpeed(particleOverlayOptions.getParticleStartSpeed());
                this.n.setParticleStartColor(particleOverlayOptions.getParticleStartColor());
                this.n.setParticleOverLifeModule(particleOverlayOptions.getParticleOverLifeModule());
                this.n.setStartParticleSize(particleOverlayOptions.getStartParticleW(), particleOverlayOptions.getstartParticleH());
                this.n.zIndex(particleOverlayOptions.getZIndex());
                this.h = this.n.getZIndex();
                this.n.setVisible(particleOverlayOptions.isVisibile());
                this.g = this.n.isVisibile();
                this.o = true;
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void remove() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.i == null) {
            this.i = this.f.a("Particle");
        }
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setZIndex(float f2) throws RemoteException {
        this.h = f2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.g = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void destroy() {
        Bitmap bitmap;
        List<cx> list = this.l;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                cx cxVar = this.l.get(i2);
                if (cxVar != null) {
                    cm cmVar = this.f;
                    if (cmVar != null) {
                        cmVar.a(cxVar);
                    }
                    if (this.f.e() != null) {
                        this.f.e().c(cxVar.j());
                    }
                }
            }
            this.l.clear();
        }
        BitmapDescriptor bitmapDescriptor = this.j;
        if (!(bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap()) == null)) {
            bitmap.recycle();
            this.j = null;
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.nativeDestroy(j2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public final void setAboveMaskLayer(boolean z) {
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        int i2;
        cm cmVar;
        gq gqVar;
        if (this.e == null) {
            this.e = this.f.b();
        }
        if (this.e != null) {
            if (this.d == 0) {
                this.d = AMapNativeParticleSystem.nativeCreate();
                long j2 = this.d;
                if (!(j2 == 0 || (gqVar = this.e) == null)) {
                    AMapNativeParticleSystem.nativeSetGLShaderManager(j2, gqVar.a());
                }
            }
            if (this.d != 0) {
                synchronized (this) {
                    if (this.o) {
                        if (this.d != 0) {
                            a(this.n.getMaxParticles());
                            a(this.n.getDuration());
                            a(this.n.isLoop());
                            if (this.d != 0) {
                                AMapNativeParticleSystem.setPreWram(this.d, true);
                            }
                            b(this.n.getParticleLifeTime());
                            a(this.n.getParticleStartSpeed());
                            if (this.n.getParticleEmissionModule() != null) {
                                a(this.n.getParticleEmissionModule());
                            }
                            if (this.n.getParticleShapeModule() != null) {
                                a(this.n.getParticleShapeModule());
                            }
                            if (this.n.getParticleStartColor() != null) {
                                a(this.n.getParticleStartColor());
                            }
                            if (this.n.getParticleOverLifeModule() != null) {
                                a(this.n.getParticleOverLifeModule());
                            }
                            a(this.n.getStartParticleW(), this.n.getstartParticleH());
                        }
                        this.o = false;
                    }
                }
                if (!this.k) {
                    boolean z = Build.VERSION.SDK_INT >= 12;
                    BitmapDescriptor bitmapDescriptor = this.j;
                    List<cx> list = this.l;
                    if (list != null) {
                        for (cx cxVar : list) {
                            if (!(cxVar == null || (cmVar = this.f) == null)) {
                                cmVar.a(cxVar);
                            }
                        }
                        this.l.clear();
                    }
                    cx cxVar2 = null;
                    if (!z || (cxVar2 = this.f.a(bitmapDescriptor)) == null) {
                        if (cxVar2 == null) {
                            cxVar2 = new cx(bitmapDescriptor, 0);
                        }
                        Bitmap bitmap = bitmapDescriptor.getBitmap();
                        if (bitmap == null || bitmap.isRecycled()) {
                            i2 = 0;
                        } else {
                            int[] iArr = {0};
                            GLES20.glGenTextures(1, iArr, 0);
                            int i3 = iArr[0];
                            cxVar2.a(i3);
                            if (z) {
                                this.f.e().a(cxVar2);
                            }
                            a(cxVar2);
                            ic.a(i3, bitmap, true);
                            i2 = i3;
                        }
                    } else {
                        i2 = cxVar2.f();
                        a(cxVar2);
                    }
                    this.k = true;
                } else {
                    i2 = this.m;
                }
                this.m = i2;
                int i4 = this.m;
                if (i4 != 0) {
                    AMapNativeParticleSystem.nativeSetTextureId(this.d, i4);
                    cm cmVar2 = this.f;
                    if (cmVar2 != null) {
                        cmVar2.g();
                    }
                    if (!(this.b == mapConfig.getMapWidth() && this.c == mapConfig.getMapHeight())) {
                        this.b = mapConfig.getMapWidth();
                        this.c = mapConfig.getMapHeight();
                        int i5 = this.b;
                        int i6 = this.c;
                        this.a = i5 > i6 ? ((float) i5) / ((float) i6) : ((float) i6) / ((float) i5);
                        if (this.b > this.c) {
                            this.p = -this.a;
                            this.q = 1.0f;
                        } else {
                            this.p = -1.0f;
                            this.q = this.a;
                        }
                        float[] fArr = this.r;
                        float f2 = this.p;
                        float f3 = this.q;
                        Matrix.orthoM(fArr, 0, f2, -f2, -f3, f3, 3.0f, 7.0f);
                        Matrix.setLookAtM(this.s, 0, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                    }
                    Matrix.multiplyMM(this.t, 0, this.r, 0, this.s, 0);
                    Matrix.translateM(this.t, 0, this.p, this.q, 0.0f);
                    Matrix.scaleM(this.t, 0, Math.abs(this.p * 2.0f) / ((float) this.b), Math.abs(this.q * 2.0f) / ((float) this.c), 0.0f);
                    AMapNativeParticleSystem.nativeRender(this.d, (float[]) this.t.clone(), mapConfig.getProjectionMatrix(), mapConfig.getSX(), mapConfig.getSY(), mapConfig.getSZ(), (float) this.b, (float) this.c);
                }
            }
        }
    }

    private void a(cx cxVar) {
        if (cxVar != null) {
            this.l.add(cxVar);
            cxVar.g();
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean a() {
        return true;
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return false;
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(int i2, int i3) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setStartParticleSize(i2, i3);
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.setStartParticleSize(j2, (float) i2, (float) i3);
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(int i2) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setMaxParticles(i2);
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.setMaxParticles(j2, i2);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(long j2) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setDuration(j2);
        }
        long j3 = this.d;
        if (j3 != 0) {
            AMapNativeParticleSystem.setDuration(j3, j2);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void b(long j2) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleLifeTime(j2);
        }
        long j3 = this.d;
        if (j3 != 0) {
            AMapNativeParticleSystem.setParticleLifeTime(j3, j2);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(VelocityGenerate velocityGenerate) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
        }
        if (this.d != 0 && velocityGenerate != null) {
            if (velocityGenerate.getNativeInstance() == 0) {
                velocityGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleStartSpeed(this.d, velocityGenerate.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(boolean z) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setLoop(z);
        }
        long j2 = this.d;
        if (j2 != 0) {
            AMapNativeParticleSystem.setLoop(j2, z);
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(ParticleShapeModule particleShapeModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleShapeModule(particleShapeModule);
        }
        if (this.d != 0 && particleShapeModule != null) {
            if (particleShapeModule.getNativeInstance() == 0) {
                particleShapeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleShapeModule(this.d, particleShapeModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(ParticleEmissionModule particleEmissionModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
        }
        if (this.d != 0 && particleEmissionModule != null) {
            if (particleEmissionModule.getNativeInstance() == 0) {
                particleEmissionModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleEmission(this.d, particleEmissionModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final int c() {
        long j2 = this.d;
        if (j2 != 0) {
            return AMapNativeParticleSystem.getCurrentParticleNum(j2);
        }
        return 0;
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(ParticleOverLifeModule particleOverLifeModule) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
        }
        if (this.d != 0 && particleOverLifeModule != null) {
            if (particleOverLifeModule.getNativeInstance() == 0) {
                particleOverLifeModule.createNativeInstace();
            }
            AMapNativeParticleSystem.setParticleOverLifeModule(this.d, particleOverLifeModule.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }

    @Override // com.amap.api.col.stln3.gb
    public final void a(ColorGenerate colorGenerate) {
        ParticleOverlayOptions particleOverlayOptions = this.n;
        if (particleOverlayOptions != null) {
            particleOverlayOptions.setParticleStartColor(colorGenerate);
        }
        if (this.d != 0 && colorGenerate != null) {
            if (colorGenerate.getNativeInstance() == 0) {
                colorGenerate.createNativeInstace();
            }
            AMapNativeParticleSystem.setStartColor(this.d, colorGenerate.getNativeInstance());
        } else if (this.n != null) {
            synchronized (this) {
                this.o = true;
            }
        }
    }
}
