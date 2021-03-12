package com.amap.api.col.stln3;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TileOverlayView */
public final class db {
    List<gf> a = new ArrayList();
    a b = new a();
    List<Integer> c = new ArrayList();
    go d = null;
    float[] e = new float[16];
    private co f;
    private Context g;

    /* access modifiers changed from: package-private */
    /* compiled from: TileOverlayView */
    public static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            gf gfVar = (gf) obj;
            gf gfVar2 = (gf) obj2;
            if (gfVar == null || gfVar2 == null) {
                return 0;
            }
            try {
                return Float.compare(gfVar.getZIndex(), gfVar2.getZIndex());
            } catch (Throwable th) {
                rx.c(th, "TileOverlayView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public db(Context context, co coVar) {
        this.f = coVar;
        this.g = context;
        TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new hf(this.f.getMapConfig()));
        tileProvider.memCacheSize(10485760);
        tileProvider.diskCacheSize(20480);
        this.d = new go(tileProvider, this, true);
    }

    public final co a() {
        return this.f;
    }

    public final void b() {
        try {
            for (Integer num : this.c) {
                ic.b(num.intValue());
            }
            this.c.clear();
            if (h()) {
                if (this.d != null) {
                    this.d.a();
                }
            }
            synchronized (this.a) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    gf gfVar = this.a.get(i);
                    if (gfVar.isVisible()) {
                        gfVar.a();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void c() {
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                gf gfVar = this.a.get(i);
                if (gfVar != null) {
                    gfVar.destroy(true);
                }
            }
            this.a.clear();
        }
    }

    public final void d() {
        synchronized (this.a) {
            Collections.sort(this.a, this.b);
        }
    }

    public final TileOverlay a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        try {
            go goVar = new go(tileOverlayOptions, this, false);
            synchronized (this.a) {
                a(goVar);
                this.a.add(goVar);
            }
            d();
            goVar.a(true);
            this.f.setRunLowFrame(false);
            return new TileOverlay(goVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final boolean a(gf gfVar) {
        boolean remove;
        synchronized (this.a) {
            remove = this.a.remove(gfVar);
        }
        return remove;
    }

    public final void a(boolean z) {
        try {
            if (h()) {
                CameraPosition cameraPosition = this.f.getCameraPosition();
                if (cameraPosition != null) {
                    if (!cameraPosition.isAbroad || cameraPosition.zoom <= 7.0f) {
                        if (this.d != null) {
                            if (this.f.getMapConfig().getMapLanguage().equals("en")) {
                                this.d.a(z);
                            }
                        }
                    } else if (this.f.getMapType() == 1) {
                        if (this.d != null) {
                            this.d.a(z);
                        }
                    } else if (this.d != null) {
                    }
                    this.d.b();
                } else {
                    return;
                }
            }
            synchronized (this.a) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    gf gfVar = this.a.get(i);
                    if (gfVar != null && gfVar.isVisible()) {
                        gfVar.a(z);
                    }
                }
            }
        } catch (Throwable th) {
            rx.c(th, "TileOverlayView", "refresh");
        }
    }

    private boolean h() {
        if (this.f == null) {
            return false;
        }
        if (MapsInitializer.isLoadWorldGridMap() || this.f.getMapConfig().getMapLanguage().equals("en")) {
            return true;
        }
        return false;
    }

    public final void b(boolean z) {
        go goVar = this.d;
        if (goVar != null) {
            goVar.b(z);
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                gf gfVar = this.a.get(i);
                if (gfVar != null) {
                    gfVar.b(z);
                }
            }
        }
    }

    public final Context e() {
        return this.g;
    }

    public final void a(int i) {
        this.c.add(Integer.valueOf(i));
    }

    public final float[] f() {
        co coVar = this.f;
        if (coVar != null) {
            return coVar.A();
        }
        return this.e;
    }

    public final void g() {
        go goVar = this.d;
        if (goVar != null) {
            goVar.clearTileCache();
            ht.a(this.g, "Map3DCache", "time", (Object) Long.valueOf(System.currentTimeMillis()));
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                gf gfVar = this.a.get(i);
                if (gfVar != null) {
                    gfVar.clearTileCache();
                }
            }
        }
    }
}
