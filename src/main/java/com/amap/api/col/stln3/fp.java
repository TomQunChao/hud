package com.amap.api.col.stln3;

import android.os.RemoteException;
import android.support.v4.internal.view.SupportMenu;
import com.amap.api.maps.model.BuildingOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapNativeBuildingRenderer;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BuildingOverlayDelegateImp */
public final class fp implements fu, fz {
    long a = -1;
    private cm b;
    private BuildingOverlayOptions c;
    private List<BuildingOverlayOptions> d = new ArrayList();
    private List<BuildingOverlayOptions> e;
    private boolean f = true;
    private String g;
    private float h;
    private boolean i;
    private gq j;

    public fp(cm cmVar) {
        try {
            this.b = cmVar;
            if (this.c == null) {
                this.c = new BuildingOverlayOptions();
                this.c.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.c.setBuildingLatlngs(arrayList);
                this.c.setBuildingTopColor(SupportMenu.CATEGORY_MASK);
                this.c.setBuildingSideColor(-12303292);
                this.c.setVisible(true);
                this.c.setZIndex(1.0f);
                this.d.add(this.c);
                a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final String getId() {
        if (this.g == null) {
            this.g = this.b.a("Building");
        }
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final void setZIndex(float f2) {
        try {
            this.h = f2;
            this.b.d();
            synchronized (this) {
                this.c.setZIndex(this.h);
            }
            a(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final float getZIndex() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final void setVisible(boolean z) {
        this.f = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final boolean isVisible() {
        return this.f;
    }

    @Override // com.amap.api.col.stln3.fu
    public final void a(BuildingOverlayOptions buildingOverlayOptions) {
        if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.c = buildingOverlayOptions;
            }
            a(true);
        }
    }

    @Override // com.amap.api.col.stln3.fu
    public final void a(List<BuildingOverlayOptions> list) {
        if (list != null && list.size() > 0) {
            synchronized (this) {
                this.e = list;
            }
            a(false);
        }
    }

    @Override // com.amap.api.col.stln3.fu
    public final List<BuildingOverlayOptions> c() {
        return this.e;
    }

    @Override // com.amap.api.col.stln3.fu
    public final BuildingOverlayOptions d() {
        BuildingOverlayOptions buildingOverlayOptions;
        synchronized (this) {
            buildingOverlayOptions = this.c;
        }
        return buildingOverlayOptions;
    }

    private void a(boolean z) {
        try {
            synchronized (this) {
                if (z) {
                    this.d.set(0, this.c);
                } else {
                    this.d.removeAll(this.e);
                    this.d.set(0, this.c);
                    this.d.addAll(this.e);
                }
                this.i = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay, com.amap.api.col.stln3.fu
    public final void destroy() {
        synchronized (this) {
            if (this.a != -1) {
                AMapNativeBuildingRenderer.nativeDestory(this.a);
                if (this.d != null) {
                    this.d.clear();
                }
                this.e = null;
                this.c = null;
                this.a = -1;
            }
        }
    }

    @Override // com.amap.api.col.stln3.fz
    public final void a(MapConfig mapConfig) throws RemoteException {
        if (mapConfig != null) {
            try {
                if (this.a != -1) {
                    synchronized (this) {
                        if (this.a != -1) {
                            if (this.i) {
                                AMapNativeBuildingRenderer.nativeClearBuildingOptions(this.a);
                                for (int i2 = 0; i2 < this.d.size(); i2++) {
                                    AMapNativeBuildingRenderer.addBuildingOptions(this.a, this.d.get(i2));
                                }
                                this.i = false;
                            }
                            AMapNativeBuildingRenderer.render(this.a, mapConfig.getViewMatrix(), mapConfig.getProjectionMatrix(), mapConfig.getSX(), mapConfig.getSY(), mapConfig.getSZ(), mapConfig.getCurTileIds());
                        }
                    }
                    return;
                }
                this.a = AMapNativeBuildingRenderer.nativeCreate();
                if (!(this.a == -1 || this.j == null)) {
                    AMapNativeBuildingRenderer.nativeSetGLShaderManager(this.a, this.j.a());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
    public final boolean a() {
        return true;
    }

    @Override // com.amap.api.col.stln3.fz
    public final boolean b() {
        return false;
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
    public final void remove() throws RemoteException {
    }

    public final void a(gq gqVar) {
        this.j = gqVar;
    }
}
