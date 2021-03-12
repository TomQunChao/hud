package com.amap.api.col.stln3;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiPointOverlayManagerLayer */
public final class dx {
    gq a;
    private List<IMultiPointOverlay> b = new ArrayList();
    private AMap.OnMultiPointClickListener c;
    private co d;

    public dx(co coVar) {
        this.d = coVar;
    }

    public final gq a() {
        this.a = this.d.B();
        return this.a;
    }

    public final synchronized void b() {
        this.c = null;
        try {
            synchronized (this.b) {
                for (IMultiPointOverlay iMultiPointOverlay : this.b) {
                    iMultiPointOverlay.destroy(false);
                }
                this.b.clear();
            }
        } catch (Throwable th) {
            rx.c(th, "MultiPointOverlayManagerLayer", "destory");
            th.printStackTrace();
        }
    }

    public final synchronized void c() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
        } catch (Throwable th) {
            rx.c(th, "MultiPointOverlayManagerLayer", "clear");
            th.printStackTrace();
        }
    }

    public final synchronized IMultiPointOverlay a(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        dw dwVar = new dw(multiPointOverlayOptions, this);
        synchronized (this.b) {
            this.b.add(dwVar);
        }
        return dwVar;
    }

    public final void a(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        try {
            synchronized (this.b) {
                for (IMultiPointOverlay iMultiPointOverlay : this.b) {
                    iMultiPointOverlay.draw(mapConfig, fArr, fArr2);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "MultiPointOverlayManagerLayer", "draw");
            th.printStackTrace();
        }
    }

    public final boolean a(IPoint iPoint) {
        MultiPointItem onClick;
        boolean z = false;
        if (this.c == null) {
            return false;
        }
        synchronized (this.b) {
            for (IMultiPointOverlay iMultiPointOverlay : this.b) {
                if (!(iMultiPointOverlay == null || (onClick = iMultiPointOverlay.onClick(iPoint)) == null)) {
                    if (this.c != null) {
                        z = this.c.onPointClick(onClick);
                    }
                    return z;
                }
            }
            return false;
        }
    }

    public final void a(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.c = onMultiPointClickListener;
    }

    public final void d() {
        co coVar = this.d;
        if (coVar != null) {
            coVar.setRunLowFrame(false);
        }
    }

    public final void a(dw dwVar) {
        this.b.remove(dwVar);
    }
}
