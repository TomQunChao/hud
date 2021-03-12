package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alibaba.idst.nls.NlsClient;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* compiled from: DistanceSearchCore */
public class ou implements IDistanceSearch {
    private static final String a = ou.class.getSimpleName();
    private Context b;
    private Handler c = nu.a();
    private DistanceSearch.OnDistanceSearchListener d;

    public ou(Context context) {
        this.b = context.getApplicationContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ AMapException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ AMapException -> 0x004e }] */
    @Override // com.amap.api.services.interfaces.IDistanceSearch
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.route.DistanceResult calculateRouteDistance(com.amap.api.services.route.DistanceSearch.DistanceQuery r3) throws com.amap.api.services.core.AMapException {
        /*
            r2 = this;
            android.content.Context r0 = r2.b     // Catch:{ AMapException -> 0x004e }
            com.amap.api.col.stln3.ns.a(r0)     // Catch:{ AMapException -> 0x004e }
            if (r3 == 0) goto L_0x0046
            com.amap.api.services.core.LatLonPoint r0 = r3.getDestination()     // Catch:{ AMapException -> 0x004e }
            r1 = 1
            if (r0 != 0) goto L_0x000f
        L_0x000e:
            goto L_0x0023
        L_0x000f:
            java.util.List r0 = r3.getOrigins()     // Catch:{ AMapException -> 0x004e }
            if (r0 == 0) goto L_0x0022
            java.util.List r0 = r3.getOrigins()     // Catch:{ AMapException -> 0x004e }
            int r0 = r0.size()     // Catch:{ AMapException -> 0x004e }
            if (r0 > 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = 0
            goto L_0x0023
        L_0x0022:
            goto L_0x000e
        L_0x0023:
            if (r1 != 0) goto L_0x003e
            com.amap.api.services.route.DistanceSearch$DistanceQuery r3 = r3.clone()     // Catch:{ AMapException -> 0x004e }
            com.amap.api.col.stln3.nm r0 = new com.amap.api.col.stln3.nm     // Catch:{ AMapException -> 0x004e }
            android.content.Context r1 = r2.b     // Catch:{ AMapException -> 0x004e }
            r0.<init>(r1, r3)     // Catch:{ AMapException -> 0x004e }
            java.lang.Object r0 = r0.a()     // Catch:{ AMapException -> 0x004e }
            com.amap.api.services.route.DistanceResult r0 = (com.amap.api.services.route.DistanceResult) r0     // Catch:{ AMapException -> 0x004e }
            if (r0 == 0) goto L_0x003c
            r0.setDistanceQuery(r3)     // Catch:{ AMapException -> 0x004e }
            goto L_0x003d
        L_0x003c:
        L_0x003d:
            return r0
        L_0x003e:
            com.amap.api.services.core.AMapException r3 = new com.amap.api.services.core.AMapException     // Catch:{ AMapException -> 0x004e }
            java.lang.String r0 = "无效的参数 - IllegalArgumentException"
            r3.<init>(r0)     // Catch:{ AMapException -> 0x004e }
            throw r3     // Catch:{ AMapException -> 0x004e }
        L_0x0046:
            com.amap.api.services.core.AMapException r3 = new com.amap.api.services.core.AMapException     // Catch:{ AMapException -> 0x004e }
            java.lang.String r0 = "无效的参数 - IllegalArgumentException"
            r3.<init>(r0)     // Catch:{ AMapException -> 0x004e }
            throw r3     // Catch:{ AMapException -> 0x004e }
        L_0x004e:
            r3 = move-exception
            java.lang.String r0 = com.amap.api.col.stln3.ou.a
            java.lang.String r1 = "calculateWalkRoute"
            com.amap.api.col.stln3.nl.a(r3, r0, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ou.calculateRouteDistance(com.amap.api.services.route.DistanceSearch$DistanceQuery):com.amap.api.services.route.DistanceResult");
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        ok.a().a(new Runnable() {
            /* class com.amap.api.col.stln3.ou.AnonymousClass1 */

            public final void run() {
                Message obtainMessage = nu.a().obtainMessage();
                obtainMessage.what = NlsClient.ErrorCode.ERROR_FORMAT;
                obtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResult = null;
                try {
                    distanceResult = ou.this.calculateRouteDistance(distanceQuery);
                    bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                } catch (AMapException e) {
                    bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                } catch (Throwable th) {
                    obtainMessage.obj = ou.this.d;
                    bundle.putParcelable("result", distanceResult);
                    obtainMessage.setData(bundle);
                    ou.this.c.sendMessage(obtainMessage);
                    throw th;
                }
                obtainMessage.obj = ou.this.d;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                ou.this.c.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.d = onDistanceSearchListener;
    }
}
