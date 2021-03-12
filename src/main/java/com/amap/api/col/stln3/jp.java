package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;

/* compiled from: InternalLocation */
public final class jp {
    public is a = null;
    Inner_3dMap_location b = null;
    int c = 50;
    Inner_3dMap_locationListener d = new Inner_3dMap_locationListener() {
        /* class com.amap.api.col.stln3.jp.AnonymousClass1 */

        @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationListener
        public final void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
            if (inner_3dMap_location == null) {
                return;
            }
            if (inner_3dMap_location.getErrorCode() == 0) {
                if (inner_3dMap_location.getLocationType() == 1) {
                    jp.this.b = inner_3dMap_location;
                    String str = "--->  InternalLocation onLocationChanged " + inner_3dMap_location.toString();
                    if (jp.this.e != null) {
                        jp.this.e.a(inner_3dMap_location);
                    }
                }
                iu.a(new NaviLatLng(inner_3dMap_location.getLatitude(), inner_3dMap_location.getLongitude()));
                return;
            }
            String str2 = "定位失败," + inner_3dMap_location.getErrorCode() + ": " + inner_3dMap_location.getErrorInfo();
        }
    };
    private jm e;

    public jp(Context context) {
        this.a = new is(context);
    }

    public final void a(jm jmVar) {
        this.e = jmVar;
    }
}
