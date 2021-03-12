package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/* compiled from: LocFetcherImpl */
public final class qj implements qi {
    private AMapLocationClient a;
    private AMapLocationListener b;
    private AMapLocationClientOption c;

    @Override // com.amap.api.col.stln3.qi
    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption, AMapLocationListener aMapLocationListener) {
        if (context == null) {
            qr.a("Context is null when startLocMonitor ");
            return;
        }
        this.c = aMapLocationClientOption;
        this.b = aMapLocationListener;
        if (this.a == null) {
            this.a = new AMapLocationClient(context);
            this.a.setLocationOption(this.c);
            this.a.setLocationListener(this.b);
        }
        this.a.startLocation();
    }

    @Override // com.amap.api.col.stln3.qi
    public final void a() {
        AMapLocationClient aMapLocationClient = this.a;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.a.unRegisterLocationListener(this.b);
            this.a.onDestroy();
            this.a = null;
            this.b = null;
        }
    }
}
