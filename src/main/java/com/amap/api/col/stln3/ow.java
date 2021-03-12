package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: GeocodeSearchCore */
public final class ow implements IGeocodeSearch {
    private Context a;
    private GeocodeSearch.OnGeocodeSearchListener b;
    private Handler c = nu.a();

    public ow(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ AMapException -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[Catch:{ AMapException -> 0x0031 }] */
    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.services.geocoder.RegeocodeAddress getFromLocation(com.amap.api.services.geocoder.RegeocodeQuery r3) throws com.amap.api.services.core.AMapException {
        /*
            r2 = this;
            android.content.Context r0 = r2.a     // Catch:{ AMapException -> 0x0031 }
            com.amap.api.col.stln3.ns.a(r0)     // Catch:{ AMapException -> 0x0031 }
            r0 = 0
            if (r3 != 0) goto L_0x0009
        L_0x0008:
            goto L_0x0019
        L_0x0009:
            com.amap.api.services.core.LatLonPoint r1 = r3.getPoint()     // Catch:{ AMapException -> 0x0031 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r3.getLatLonType()     // Catch:{ AMapException -> 0x0031 }
            if (r1 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = 1
            goto L_0x0019
        L_0x0018:
            goto L_0x0008
        L_0x0019:
            if (r0 == 0) goto L_0x0029
            com.amap.api.col.stln3.oe r0 = new com.amap.api.col.stln3.oe     // Catch:{ AMapException -> 0x0031 }
            android.content.Context r1 = r2.a     // Catch:{ AMapException -> 0x0031 }
            r0.<init>(r1, r3)     // Catch:{ AMapException -> 0x0031 }
            java.lang.Object r3 = r0.a()     // Catch:{ AMapException -> 0x0031 }
            com.amap.api.services.geocoder.RegeocodeAddress r3 = (com.amap.api.services.geocoder.RegeocodeAddress) r3     // Catch:{ AMapException -> 0x0031 }
            return r3
        L_0x0029:
            com.amap.api.services.core.AMapException r3 = new com.amap.api.services.core.AMapException     // Catch:{ AMapException -> 0x0031 }
            java.lang.String r0 = "无效的参数 - IllegalArgumentException"
            r3.<init>(r0)     // Catch:{ AMapException -> 0x0031 }
            throw r3     // Catch:{ AMapException -> 0x0031 }
        L_0x0031:
            r3 = move-exception
            java.lang.String r0 = "GeocodeSearch"
            java.lang.String r1 = "getFromLocationAsyn"
            com.amap.api.col.stln3.nl.a(r3, r0, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ow.getFromLocation(com.amap.api.services.geocoder.RegeocodeQuery):com.amap.api.services.geocoder.RegeocodeAddress");
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            ns.a(this.a);
            if (geocodeQuery != null) {
                return (List) new np(this.a, geocodeQuery).a();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            nl.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ow.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        nu.i iVar = new nu.i();
                        iVar.b = ow.this.b;
                        obtainMessage.obj = iVar;
                        iVar.a = new RegeocodeResult(regeocodeQuery, ow.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ow.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ow.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ow.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.what = 200;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        nu.e eVar = new nu.e();
                        eVar.b = ow.this.b;
                        obtainMessage.obj = eVar;
                        eVar.a = new GeocodeResult(geocodeQuery, ow.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ow.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ow.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }
}
