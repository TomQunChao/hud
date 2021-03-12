package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.stln3.bl;
import com.amap.api.col.stln3.rk;
import com.amap.api.col.stln3.sk;
import com.amap.api.col.stln3.vu;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;

public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;
    Context a = null;
    GeoFenceManagerBase b = null;

    public GeoFenceClient(Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = a(this.a);
            } catch (Throwable th) {
                vu.a(th, "GeoFenceClient", "<init>");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private static GeoFenceManagerBase a(Context context) {
        GeoFenceManagerBase geoFenceManagerBase;
        try {
            geoFenceManagerBase = (GeoFenceManagerBase) sk.a(context, vu.b(), rk.c("EY29tLmFtYXAuYXBpLmZlbmNlLkdlb0ZlbmNlTWFuYWdlcldyYXBwZXI="), bl.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable th) {
            geoFenceManagerBase = new bl(context);
        }
        if (geoFenceManagerBase == null) {
            return new bl(context);
        }
        return geoFenceManagerBase;
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.b.createPendingIntent(str);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.setActivateAction(i);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.b.setGeoFenceListener(geoFenceListener);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.b.addRoundGeoFence(dPoint, f, str);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.b.addPolygonGeoFence(list, str);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.b.addNearbyGeoFence(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.b.addKeywordGeoFence(str, str2, str3, i, str4);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.b.addDistrictGeoFence(str, str2);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.removeGeoFence();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.b.removeGeoFence(geoFence);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.b.getAllGeoFence();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.b.setGeoFenceAble(str, z);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.pauseGeoFence();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.resumeGeoFence();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public boolean isPause() {
        try {
            return this.b.isPause();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }
}
