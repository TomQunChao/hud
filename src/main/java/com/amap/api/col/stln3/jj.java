package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: GpsAdapter */
public final class jj {
    private jp a;

    public jj(Context context) {
        this.a = new jp(context);
    }

    public final void a(jm jmVar) {
        this.a.a(jmVar);
    }

    public final void a() {
        jp jpVar = this.a;
        if (jpVar.a != null) {
            Inner_3dMap_locationOption inner_3dMap_locationOption = new Inner_3dMap_locationOption();
            inner_3dMap_locationOption.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            inner_3dMap_locationOption.setNeedAddress(false);
            inner_3dMap_locationOption.setInterval(1000);
            inner_3dMap_locationOption.setOffset(true);
            jpVar.a.a(inner_3dMap_locationOption);
            jpVar.a.a(jpVar.d);
            jpVar.a.a();
        }
    }

    public final void a(long j) {
        jp jpVar = this.a;
        if (jpVar.a != null) {
            Inner_3dMap_locationOption inner_3dMap_locationOption = new Inner_3dMap_locationOption();
            inner_3dMap_locationOption.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            inner_3dMap_locationOption.setNeedAddress(false);
            inner_3dMap_locationOption.setInterval(j);
            inner_3dMap_locationOption.setOffset(true);
            jpVar.a.a(inner_3dMap_locationOption);
            jpVar.a.a(jpVar.d);
            jpVar.a.a();
        }
    }

    public final void b() {
        jp jpVar = this.a;
        if (jpVar.a != null) {
            jpVar.a.b();
        }
    }

    public final void c() {
        jp jpVar = this.a;
        if (jpVar.a != null) {
            jpVar.a.c();
        }
    }

    public final float a(double d, double d2) {
        jp jpVar = this.a;
        if (jpVar.b == null || ((float) mj.a(new NaviLatLng(d, d2), new NaviLatLng(jpVar.b.getLatitude(), jpVar.b.getLongitude()))) >= ((float) jpVar.c)) {
            return 0.1111f;
        }
        return jpVar.b.getBearing();
    }
}
