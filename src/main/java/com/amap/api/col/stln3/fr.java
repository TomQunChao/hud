package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.amap.api.col.stln3.gq;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IglModel;
import java.util.List;

/* compiled from: Gl3DModelImp */
public final class fr extends cg implements IglModel {
    private boolean A = false;
    private boolean B = false;
    private FPoint C = FPoint.obtain();
    private int D = 0;
    private int E = 0;
    private float F = 0.5f;
    private float G = 0.5f;
    private String H;
    private String I;
    private float J = -1.0f;
    float[] a = new float[16];
    float[] b = new float[16];
    Rect c = new Rect(0, 0, 0, 0);
    float d = 1.0f;
    private boolean e = true;
    private String f;
    private float[] g = new float[16];
    private cl h;
    private BitmapDescriptor i;
    private co j;
    private int k;
    private int l;
    private LatLng m;
    private GLAnimation n;
    private boolean o = true;
    private boolean p = true;
    private Bitmap q;
    private gq.b r;
    private float s;
    private Object t;
    private float u = 18.0f;
    private float v = -1.0f;
    private float w = 0.0f;
    private boolean x = false;
    private cj y;
    private int z;

    public fr(cj cjVar, GL3DModelOptions gL3DModelOptions, co coVar) {
        boolean z2 = true;
        if (gL3DModelOptions != null && coVar != null) {
            this.y = cjVar;
            this.j = coVar;
            this.i = gL3DModelOptions.getBitmapDescriptor();
            List<Float> textrue = gL3DModelOptions.getTextrue();
            List<Float> vertext = gL3DModelOptions.getVertext();
            this.m = gL3DModelOptions.getLatLng();
            this.s = gL3DModelOptions.getAngle();
            setModelFixedLength(gL3DModelOptions.getModelFixedLength());
            if (this.m != null) {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.m.longitude, this.m.latitude, obtain);
                this.k = obtain.x;
                this.l = obtain.y;
            }
            if (!(textrue == null || textrue.size() <= 0 || vertext == null)) {
                if ((vertext.size() > 0) && (this.i == null ? false : z2)) {
                    this.h = new cl(vertext, textrue);
                    this.h.a(this.s);
                }
            }
            this.a = new float[16];
            this.b = new float[4];
        }
    }

    public final void j() {
        float f2;
        float f3;
        try {
            if (this.h != null) {
                if (this.r == null) {
                    this.r = (gq.b) this.j.k(5);
                }
                if (this.v == -1.0f) {
                    this.v = this.j.l((int) this.u);
                }
                if (this.e) {
                    Bitmap bitmap = this.i.getBitmap();
                    if (bitmap != null) {
                        this.q = bitmap;
                    }
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    GLES20.glBindTexture(3553, iArr[0]);
                    GLES20.glTexParameterf(3553, 10241, 9728.0f);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLUtils.texImage2D(3553, 0, this.q, 0);
                    this.z = iArr[0];
                    this.h.a(this.z);
                    this.e = false;
                }
                if (this.o || this.n == null || this.n.hasEnded()) {
                    this.o = true;
                } else {
                    if (this.j != null) {
                        this.j.setRunLowFrame(false);
                    }
                    GLTransformation gLTransformation = new GLTransformation();
                    this.n.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
                    if (!Double.isNaN(gLTransformation.x) && !Double.isNaN(gLTransformation.y)) {
                        double d2 = gLTransformation.x;
                        double d3 = gLTransformation.y;
                        this.k = (int) d2;
                        this.l = (int) d3;
                    }
                }
                float sx = (float) (this.k - this.j.getMapConfig().getSX());
                this.C.x = sx;
                float sy = (float) (this.l - this.j.getMapConfig().getSY());
                this.C.y = sy;
                Matrix.setIdentityM(this.g, 0);
                Matrix.multiplyMM(this.g, 0, this.j.getProjectionMatrix(), 0, this.j.getViewMatrix(), 0);
                Matrix.translateM(this.g, 0, sx, sy, 0.0f);
                if (this.x) {
                    f2 = (this.j.getMapConfig().getMapPerPixelUnitLength() * this.w) / this.h.a();
                } else {
                    float mapPerPixelUnitLength = this.j.getMapConfig().getMapPerPixelUnitLength();
                    if (this.j.getMapConfig().getSZ() >= this.u) {
                        this.J = mapPerPixelUnitLength;
                        f3 = this.J;
                    } else {
                        f3 = this.v;
                    }
                    f2 = mapPerPixelUnitLength / f3;
                }
                this.d = f2;
                Matrix.scaleM(this.g, 0, this.d, this.d, this.d);
                this.h.a(this.r, this.g);
                if (this.B) {
                    this.j.m();
                    this.B = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.m = latLng;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
            this.k = obtain.x;
            this.l = obtain.y;
            obtain.recycle();
        }
        this.B = true;
        this.j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setRotateAngle(float f2) {
        this.s = f2;
        if (this.h != null) {
            this.h.a(this.s - this.j.getMapConfig().getSR());
        }
        this.B = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final float getRotateAngle() {
        return 0.0f;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IglModel
    public final LatLng getPosition() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setAnimation(Animation animation) {
        if (animation != null) {
            this.n = animation.glAnimation;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final boolean startAnimation() {
        GLAnimation gLAnimation = this.n;
        if (gLAnimation != null) {
            if (gLAnimation instanceof GLAnimationSet) {
                GLAnimationSet gLAnimationSet = (GLAnimationSet) gLAnimation;
                for (GLAnimation gLAnimation2 : gLAnimationSet.getAnimations()) {
                    a(gLAnimation2);
                    gLAnimation2.setDuration(gLAnimationSet.getDuration());
                }
            } else {
                a(gLAnimation);
            }
            this.o = false;
            this.n.start();
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final boolean remove() {
        co coVar = this.j;
        if (coVar == null) {
            return true;
        }
        coVar.b(this.f);
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setVisible(boolean z2) {
        this.p = z2;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IglModel
    public final boolean isVisible() {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setObject(Object obj) {
        this.t = obj;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final Object getObject() {
        return this.t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setZoomLimit(float f2) {
        this.u = f2;
        this.v = this.j.l((int) this.u);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void destroy() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.y.a(this.z);
        this.h.c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setGeoPoint(IPoint iPoint) {
        if (iPoint != null) {
            this.k = iPoint.x;
            this.l = iPoint.y;
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(this.k, this.l, obtain);
            this.m = new LatLng(obtain.y, obtain.x, false);
            obtain.recycle();
        }
        this.j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void showInfoWindow() {
        try {
            this.j.a(this);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation.mFromXDelta = (double) this.k;
            gLTranslateAnimation.mFromYDelta = (double) this.l;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation.mToXDelta, gLTranslateAnimation.mToYDelta, obtain);
            gLTranslateAnimation.mToXDelta = (double) obtain.x;
            gLTranslateAnimation.mToYDelta = (double) obtain.y;
            obtain.recycle();
        }
    }

    public final void a(String str) {
        this.f = str;
    }

    @Override // com.amap.api.col.stln3.cs
    public final FPoint a() {
        return this.C;
    }

    @Override // com.amap.api.col.stln3.cs
    public final LatLng b() {
        return null;
    }

    @Override // com.amap.api.col.stln3.cs
    public final void a(boolean z2) {
        this.A = z2;
        this.B = true;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int c() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int d() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int e() {
        return this.D;
    }

    @Override // com.amap.api.col.stln3.cs
    public final int f() {
        return this.E;
    }

    @Override // com.amap.api.col.stln3.cs
    public final boolean g() {
        return false;
    }

    @Override // com.amap.api.col.stln3.cs
    public final boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IglModel
    public final String getId() {
        return this.f;
    }

    @Override // com.amap.api.col.stln3.cs
    public final boolean h() {
        if (this.j.getMapConfig().getGeoRectangle().contains(this.k, this.l)) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setTitle(String str) {
        this.I = str;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setSnippet(String str) {
        this.H = str;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IglModel
    public final void setModelFixedLength(int i2) {
        if (i2 > 0) {
            this.w = (float) i2;
            this.x = true;
            return;
        }
        this.w = 0.0f;
        this.x = false;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IglModel
    public final String getTitle() {
        return this.I;
    }

    @Override // com.amap.api.col.stln3.cg, com.autonavi.amap.mapcore.interfaces.IglModel
    public final String getSnippet() {
        return this.H;
    }

    @Override // com.amap.api.col.stln3.cs
    public final Rect i() {
        try {
            GLMapState f2 = this.j.f();
            int b2 = (int) ((this.h.b() * this.d) / this.j.getMapConfig().getMapPerPixelUnitLength());
            int a2 = (int) ((this.h.a() * this.d) / this.j.getMapConfig().getMapPerPixelUnitLength());
            FPoint obtain = FPoint.obtain();
            f2.p20ToScreenPoint(this.k, this.l, obtain);
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.s, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.a, 0, this.j.getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            float[] fArr = new float[4];
            float f3 = (float) (-b2);
            this.b[0] = this.F * f3;
            float f4 = (float) a2;
            this.b[1] = this.G * f4;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.set((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]), (int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            float f5 = (float) b2;
            this.b[0] = (1.0f - this.F) * f5;
            this.b[1] = f4 * this.G;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.b[0] = f5 * (1.0f - this.F);
            float f6 = (float) (-a2);
            this.b[1] = (1.0f - this.G) * f6;
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.b[0] = f3 * this.F;
            this.b[1] = f6 * (1.0f - this.G);
            this.b[2] = 0.0f;
            this.b[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, this.b, 0);
            this.c.union((int) (obtain.x + fArr[0]), (int) (obtain.y - fArr[1]));
            this.D = this.c.centerX() - ((int) obtain.x);
            this.E = this.c.top - ((int) obtain.y);
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            rx.c(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }
}
