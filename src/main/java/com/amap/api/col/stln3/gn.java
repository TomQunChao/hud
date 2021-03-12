package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextDelegateImp */
public final class gn implements ge {
    private static int a = 0;
    private int A;
    private boolean B = false;
    private List<cx> C = new ArrayList();
    private boolean D = false;
    private boolean E = false;
    private float[] F = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float b = 0.0f;
    private float c = 0.0f;
    private int d = 4;
    private int e = 32;
    private FPoint f = FPoint.obtain();
    private int g;
    private BitmapDescriptor h;
    private int i;
    private int j;
    private String k;
    private LatLng l;
    private float m = 0.5f;
    private float n = 1.0f;
    private boolean o = true;
    private cu p;
    private Object q;
    private String r;
    private int s;
    private int t;
    private int u;
    private Typeface v;
    private float w;
    private Rect x = new Rect();
    private Paint y = new Paint();
    private int z;

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setRotateAngle(float f2) {
        this.c = f2;
        this.b = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void destroy(boolean z2) {
        try {
            this.D = true;
            if (z2) {
                remove();
            }
            if (this.C != null && this.C.size() > 0) {
                for (int i2 = 0; i2 < this.C.size(); i2++) {
                    cx cxVar = this.C.get(i2);
                    if (cxVar != null) {
                        if (this.p != null) {
                            this.p.a(cxVar);
                            if (this.p.c() != null) {
                                this.p.c().c(cxVar.j());
                            }
                        }
                    }
                }
                this.C.clear();
            }
            if (this.h != null) {
                this.h.recycle();
                this.h = null;
            }
            this.l = null;
            this.q = null;
        } catch (Throwable th) {
            rx.c(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public gn(TextOptions textOptions, cu cuVar) throws RemoteException {
        this.p = cuVar;
        if (textOptions.getPosition() != null) {
            this.l = textOptions.getPosition();
        }
        setAlign(textOptions.getAlignX(), textOptions.getAlignY());
        this.o = textOptions.isVisible();
        this.r = textOptions.getText();
        this.s = textOptions.getBackgroundColor();
        this.t = textOptions.getFontColor();
        this.u = textOptions.getFontSize();
        this.q = textOptions.getObject();
        this.w = textOptions.getZIndex();
        this.v = textOptions.getTypeface();
        this.k = getId();
        setRotateAngle(textOptions.getRotate());
        a();
        c();
    }

    private void a() {
        String str = this.r;
        if (str != null && str.trim().length() > 0) {
            try {
                this.y.setTypeface(this.v);
                this.y.setSubpixelText(true);
                this.y.setAntiAlias(true);
                this.y.setStrokeWidth(5.0f);
                this.y.setStrokeCap(Paint.Cap.ROUND);
                this.y.setTextSize((float) this.u);
                this.y.setTextAlign(Paint.Align.CENTER);
                this.y.setColor(this.t);
                Paint.FontMetrics fontMetrics = this.y.getFontMetrics();
                int i2 = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i3 = (int) (((((float) i2) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                this.y.getTextBounds(this.r, 0, this.r.length(), this.x);
                Bitmap createBitmap = Bitmap.createBitmap(this.x.width() + 6, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.s);
                canvas.drawText(this.r, (float) (this.x.centerX() + 3), (float) i3, this.y);
                this.h = BitmapDescriptorFactory.fromBitmap(createBitmap);
                this.i = this.h.getWidth();
                this.j = this.h.getHeight();
            } catch (Throwable th) {
                rx.c(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final synchronized boolean remove() {
        b();
        this.o = false;
        return this.p.a(this);
    }

    private void b() {
        if (this.p.c() != null) {
            this.p.c().setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final LatLng getPosition() {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final String getId() {
        if (this.k == null) {
            a++;
            this.k = "Text" + a;
        }
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setPosition(LatLng latLng) {
        this.l = latLng;
        c();
        b();
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setVisible(boolean z2) {
        if (this.o != z2) {
            this.o = z2;
            b();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final boolean isVisible() {
        return this.o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setZIndex(float f2) {
        this.w = f2;
        this.p.f();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getZIndex() {
        return this.w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setAnchor(float f2, float f3) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getAnchorU() {
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getAnchorV() {
        return this.n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        if (equals(iOverlayImage) || iOverlayImage.getId().equals(getId())) {
            return true;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    private boolean c() {
        if (this.l == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        GLMapState.lonlat2Geo(this.l.longitude, this.l.latitude, obtain);
        this.z = obtain.x;
        this.A = obtain.y;
        this.p.c().a(this.l.latitude, this.l.longitude, this.f);
        obtain.recycle();
        return true;
    }

    @Override // com.amap.api.col.stln3.ga
    public final void a(co coVar, float[] fArr, int i2, float f2) {
        if (this.o && !this.D && this.l != null && this.h != null) {
            this.f.x = (float) (this.z - coVar.getMapConfig().getSX());
            this.f.y = (float) (this.A - coVar.getMapConfig().getSY());
            try {
                float f3 = ((float) this.i) * f2;
                float f4 = f2 * ((float) this.j);
                float f5 = this.f.x;
                float f6 = this.f.y;
                float sc = coVar.getMapConfig().getSC();
                this.F[0] = f5 - (this.m * f3);
                this.F[1] = ((1.0f - this.n) * f4) + f6;
                this.F[2] = f5;
                this.F[3] = f6;
                this.F[6] = this.b;
                this.F[7] = sc;
                this.F[9] = ((1.0f - this.m) * f3) + f5;
                this.F[10] = ((1.0f - this.n) * f4) + f6;
                this.F[11] = f5;
                this.F[12] = f6;
                this.F[15] = this.b;
                this.F[16] = sc;
                this.F[18] = ((1.0f - this.m) * f3) + f5;
                this.F[19] = f6 - (this.n * f4);
                this.F[20] = f5;
                this.F[21] = f6;
                this.F[24] = this.b;
                this.F[25] = sc;
                this.F[27] = f5 - (f3 * this.m);
                this.F[28] = f6 - (f4 * this.n);
                this.F[29] = f5;
                this.F[30] = f6;
                this.F[33] = this.b;
                this.F[34] = sc;
                System.arraycopy(this.F, 0, fArr, i2, this.F.length);
            } catch (Throwable th) {
                rx.c(th, "TextDelegateImp", "drawMarker");
            }
        }
    }

    @Override // com.amap.api.col.stln3.ga
    public final void a(co coVar) {
        if (!this.E) {
            try {
                int i2 = 0;
                boolean z2 = Build.VERSION.SDK_INT >= 12;
                BitmapDescriptor bitmapDescriptor = this.h;
                if (this.C != null) {
                    for (cx cxVar : this.C) {
                        if (!(cxVar == null || this.p == null)) {
                            this.p.a(cxVar);
                        }
                    }
                    this.C.clear();
                }
                cx cxVar2 = null;
                if (!z2 || (cxVar2 = this.p.c().a(bitmapDescriptor)) == null) {
                    if (cxVar2 == null) {
                        cxVar2 = new cx(bitmapDescriptor, 0);
                    }
                    Bitmap bitmap = bitmapDescriptor.getBitmap();
                    if (bitmap != null && !bitmap.isRecycled()) {
                        int[] iArr = {0};
                        GLES20.glGenTextures(1, iArr, 0);
                        i2 = iArr[0];
                        cxVar2.a(i2);
                        if (z2) {
                            this.p.c().a(cxVar2);
                        }
                        a(cxVar2);
                        ic.a(i2, bitmap, true);
                    }
                } else {
                    i2 = cxVar2.f();
                    a(cxVar2);
                }
                this.g = i2;
                this.E = true;
            } catch (Throwable th) {
                rx.c(th, "TextDelegateImp", "loadtexture");
                th.printStackTrace();
            }
        }
    }

    private void a(cx cxVar) {
        if (cxVar != null) {
            this.C.add(cxVar);
            cxVar.g();
        }
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean j() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final void setObject(Object obj) {
        this.q = obj;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final Object getObject() {
        return this.q;
    }

    @Override // com.amap.api.col.stln3.ga
    public final int k() {
        try {
            return this.g;
        } catch (Throwable th) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public final float getRotateAngle() {
        return this.c;
    }

    @Override // com.amap.api.col.stln3.ga
    public final Rect i() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setText(String str) throws RemoteException {
        this.r = str;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final String getText() throws RemoteException {
        return this.r;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setBackgroundColor(int i2) throws RemoteException {
        this.s = i2;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final int getBackgroundColor() throws RemoteException {
        return this.s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setFontColor(int i2) throws RemoteException {
        this.t = i2;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final int getFontColor() throws RemoteException {
        return this.t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setFontSize(int i2) throws RemoteException {
        this.u = i2;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final int getFontSize() throws RemoteException {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setTypeface(Typeface typeface) throws RemoteException {
        this.v = typeface;
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final Typeface getTypeface() throws RemoteException {
        return this.v;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final void setAlign(int i2, int i3) throws RemoteException {
        this.d = i2;
        if (i2 != 4) {
            switch (i2) {
                case 1:
                    this.m = 0.0f;
                    break;
                case 2:
                    this.m = 1.0f;
                    break;
                default:
                    this.m = 0.5f;
                    break;
            }
        } else {
            this.m = 0.5f;
        }
        this.e = i3;
        if (i3 == 8) {
            this.n = 0.0f;
        } else if (i3 == 16) {
            this.n = 1.0f;
        } else if (i3 != 32) {
            this.n = 0.5f;
        } else {
            this.n = 0.5f;
        }
        b();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final int getAlignX() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IText
    public final int getAlignY() {
        return this.e;
    }

    private synchronized void d() {
        a();
        this.E = false;
        b();
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean h() {
        Rectangle geoRectangle = this.p.c().getMapConfig().getGeoRectangle();
        if (geoRectangle == null || !geoRectangle.contains(this.z, this.A)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.ga
    public final void b(boolean z2) {
        this.B = z2;
    }

    @Override // com.amap.api.col.stln3.ga
    public final boolean l() {
        return this.B;
    }
}
