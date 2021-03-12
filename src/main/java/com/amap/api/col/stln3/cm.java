package com.amap.api.col.stln3;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: GlOverlayLayer */
public final class cm {
    co a;
    a b = new a();
    private gq c;
    private int d = 0;
    private List<fz> e = new Vector(500);
    private List<cx> f = new ArrayList();
    private int[] g = new int[1];
    private Handler h = new Handler(Looper.getMainLooper());
    private Runnable i = new Runnable() {
        /* class com.amap.api.col.stln3.cm.AnonymousClass1 */

        public final synchronized void run() {
            try {
                synchronized (cm.this) {
                    if (cm.this.e != null && cm.this.e.size() > 0) {
                        Collections.sort(cm.this.e, cm.this.b);
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "MapOverlayImageView", "changeOverlayIndex");
            }
        }
    };

    public final synchronized String a(String str) {
        this.d++;
        return str + this.d;
    }

    public final fu a() throws RemoteException {
        fp fpVar = new fp(this);
        fpVar.a(this.c);
        a(fpVar);
        return fpVar;
    }

    public final gq b() {
        return this.c;
    }

    /* compiled from: GlOverlayLayer */
    static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            fz fzVar = (fz) obj;
            fz fzVar2 = (fz) obj2;
            if (fzVar == null || fzVar2 == null) {
                return 0;
            }
            try {
                if (fzVar.getZIndex() > fzVar2.getZIndex()) {
                    return 1;
                }
                if (fzVar.getZIndex() < fzVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Throwable th) {
                rx.c(th, "GlOverlayLayer", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public cm(co coVar) {
        this.a = coVar;
    }

    public final void a(gq gqVar) {
        this.c = gqVar;
    }

    public final synchronized void b(String str) {
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    fz fzVar = null;
                    Iterator<fz> it = this.e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        fz next = it.next();
                        if (str.equals(next.getId())) {
                            fzVar = next;
                            break;
                        }
                    }
                    this.e.clear();
                    if (fzVar != null) {
                        this.e.add(fzVar);
                    }
                    return;
                }
            } catch (Throwable th) {
                rx.c(th, "GlOverlayLayer", "clear");
                th.printStackTrace();
                String str2 = "GlOverlayLayer clear erro" + th.getMessage();
                return;
            }
        }
        this.e.clear();
        h();
    }

    private synchronized void h() {
        this.d = 0;
    }

    public final synchronized void c() {
        try {
            for (fz fzVar : this.e) {
                fzVar.destroy();
            }
            b(null);
        } catch (Throwable th) {
            rx.c(th, "GlOverlayLayer", "destory");
            th.printStackTrace();
            String str = "GlOverlayLayer destory erro" + th.getMessage();
        }
    }

    private synchronized fz d(String str) throws RemoteException {
        for (fz fzVar : this.e) {
            if (fzVar != null && fzVar.getId().equals(str)) {
                return fzVar;
            }
        }
        return null;
    }

    public final synchronized gd a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        gl glVar = new gl(this, polylineOptions);
        if (this.c != null) {
            glVar.a(this.c);
        }
        a(glVar);
        return glVar;
    }

    public final synchronized fy a(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        gi giVar = new gi(this.a);
        giVar.setTopColor(navigateArrowOptions.getTopColor());
        giVar.setPoints(navigateArrowOptions.getPoints());
        giVar.setVisible(navigateArrowOptions.isVisible());
        giVar.setWidth(navigateArrowOptions.getWidth());
        giVar.setZIndex(navigateArrowOptions.getZIndex());
        a(giVar);
        return giVar;
    }

    public final synchronized gc a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        gk gkVar = new gk(this.a);
        gkVar.setFillColor(polygonOptions.getFillColor());
        gkVar.setPoints(polygonOptions.getPoints());
        gkVar.setHoleOptions(polygonOptions.getHoleOptions());
        gkVar.setVisible(polygonOptions.isVisible());
        gkVar.setStrokeWidth(polygonOptions.getStrokeWidth());
        gkVar.setZIndex(polygonOptions.getZIndex());
        gkVar.setStrokeColor(polygonOptions.getStrokeColor());
        a(gkVar);
        return gkVar;
    }

    public final synchronized fv a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        fq fqVar = new fq(this.a);
        fqVar.setFillColor(circleOptions.getFillColor());
        fqVar.setCenter(circleOptions.getCenter());
        fqVar.setVisible(circleOptions.isVisible());
        fqVar.setHoleOptions(circleOptions.getHoleOptions());
        fqVar.setStrokeWidth(circleOptions.getStrokeWidth());
        fqVar.setZIndex(circleOptions.getZIndex());
        fqVar.setStrokeColor(circleOptions.getStrokeColor());
        fqVar.setRadius(circleOptions.getRadius());
        fqVar.setDottedLineType(circleOptions.getStrokeDottedLineType());
        a(fqVar);
        return fqVar;
    }

    public final synchronized ft a(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        fo foVar = new fo(this.a);
        foVar.setStrokeColor(arcOptions.getStrokeColor());
        foVar.a(arcOptions.getStart());
        foVar.b(arcOptions.getPassed());
        foVar.c(arcOptions.getEnd());
        foVar.setVisible(arcOptions.isVisible());
        foVar.setStrokeWidth(arcOptions.getStrokeWidth());
        foVar.setZIndex(arcOptions.getZIndex());
        a(foVar);
        return foVar;
    }

    public final synchronized fw a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        fs fsVar = new fs(this.a, this);
        fsVar.a(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        fsVar.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        fsVar.setImage(groundOverlayOptions.getImage());
        fsVar.setPosition(groundOverlayOptions.getLocation());
        fsVar.setPositionFromBounds(groundOverlayOptions.getBounds());
        fsVar.setBearing(groundOverlayOptions.getBearing());
        fsVar.setTransparency(groundOverlayOptions.getTransparency());
        fsVar.setVisible(groundOverlayOptions.isVisible());
        fsVar.setZIndex(groundOverlayOptions.getZIndex());
        a(fsVar);
        return fsVar;
    }

    public final synchronized gb a(ParticleOverlayOptions particleOverlayOptions) throws RemoteException {
        if (particleOverlayOptions == null) {
            return null;
        }
        gj gjVar = new gj(this);
        gjVar.a(particleOverlayOptions);
        a(gjVar);
        return gjVar;
    }

    private void a(fz fzVar) throws RemoteException {
        this.e.add(fzVar);
        d();
    }

    public final synchronized boolean c(String str) throws RemoteException {
        fz d2 = d(str);
        if (d2 == null) {
            return false;
        }
        return this.e.remove(d2);
    }

    public final synchronized void d() {
        this.h.removeCallbacks(this.i);
        this.h.postDelayed(this.i, 10);
    }

    public final synchronized void a(boolean z, int i2) {
        try {
            synchronized (this.f) {
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    cx cxVar = this.f.get(i3);
                    if (cxVar != null) {
                        cxVar.h();
                        if (cxVar.i() <= 0) {
                            this.g[0] = cxVar.f();
                            GLES20.glDeleteTextures(1, this.g, 0);
                            if (this.a != null) {
                                this.a.c(cxVar.j());
                            }
                        }
                    }
                }
                this.f.clear();
            }
            MapConfig mapConfig = this.a.getMapConfig();
            if (mapConfig != null) {
                int size = this.e.size();
                for (fz fzVar : this.e) {
                    if (fzVar.isVisible()) {
                        if (size > 20) {
                            if (fzVar.a()) {
                                if (z) {
                                    if (fzVar.getZIndex() <= ((float) i2)) {
                                        fzVar.a(mapConfig);
                                    }
                                } else if (fzVar.getZIndex() > ((float) i2)) {
                                    fzVar.a(mapConfig);
                                }
                            }
                        } else if (z) {
                            if (fzVar.getZIndex() <= ((float) i2)) {
                                fzVar.a(mapConfig);
                            }
                        } else if (fzVar.getZIndex() > ((float) i2)) {
                            fzVar.a(mapConfig);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "GlOverlayLayer", "draw");
        }
    }

    public final void a(cx cxVar) {
        synchronized (this.f) {
            if (cxVar != null) {
                this.f.add(cxVar);
            }
        }
    }

    public final cx a(BitmapDescriptor bitmapDescriptor) {
        co coVar = this.a;
        if (coVar != null) {
            return coVar.a(bitmapDescriptor, true);
        }
        return null;
    }

    public final synchronized fz a(LatLng latLng) {
        for (fz fzVar : this.e) {
            if (fzVar != null && fzVar.b() && (fzVar instanceof gd) && ((gd) fzVar).a(latLng)) {
                return fzVar;
            }
        }
        return null;
    }

    public final co e() {
        return this.a;
    }

    public final float[] f() {
        co coVar = this.a;
        if (coVar != null) {
            return coVar.A();
        }
        return new float[16];
    }

    public final void g() {
        co coVar = this.a;
        if (coVar != null) {
            coVar.setRunLowFrame(false);
        }
    }
}
