package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: RoutePOISearchCore */
public class pa implements IRoutePOISearch {
    private RoutePOISearchQuery a;
    private Context b;
    private RoutePOISearch.OnRoutePOISearchListener c;
    private Handler d = null;

    public pa(Context context, RoutePOISearchQuery routePOISearchQuery) {
        this.b = context;
        this.a = routePOISearchQuery;
        this.d = nu.a();
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void searchRoutePOIAsyn() {
        ok.a().a(new Runnable() {
            /* class com.amap.api.col.stln3.pa.AnonymousClass1 */

            public final void run() {
                nu.j jVar;
                Message obtainMessage = pa.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                try {
                    routePOISearchResult = pa.this.searchRoutePOI();
                    bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    jVar = new nu.j();
                } catch (AMapException e) {
                    bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    jVar = new nu.j();
                } catch (Throwable th) {
                    nu.j jVar2 = new nu.j();
                    jVar2.b = pa.this.c;
                    jVar2.a = routePOISearchResult;
                    obtainMessage.obj = jVar2;
                    obtainMessage.setData(bundle);
                    pa.this.d.sendMessage(obtainMessage);
                    throw th;
                }
                jVar.b = pa.this.c;
                jVar.a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                pa.this.d.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public RoutePOISearchQuery getQuery() {
        return this.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[Catch:{ AMapException -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ AMapException -> 0x004c }] */
    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.routepoisearch.RoutePOISearchResult searchRoutePOI() throws com.amap.api.services.core.AMapException {
        /*
            r3 = this;
            android.content.Context r0 = r3.b     // Catch:{ AMapException -> 0x004c }
            com.amap.api.col.stln3.ns.a(r0)     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            r1 = 0
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            goto L_0x002e
        L_0x000b:
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.routepoisearch.RoutePOISearch$RoutePOISearchType r0 = r0.getSearchType()     // Catch:{ AMapException -> 0x004c }
            if (r0 != 0) goto L_0x0014
            goto L_0x000a
        L_0x0014:
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.core.LatLonPoint r0 = r0.getFrom()     // Catch:{ AMapException -> 0x004c }
            if (r0 != 0) goto L_0x002d
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.core.LatLonPoint r0 = r0.getTo()     // Catch:{ AMapException -> 0x004c }
            if (r0 != 0) goto L_0x002d
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            java.util.List r0 = r0.getPolylines()     // Catch:{ AMapException -> 0x004c }
            if (r0 != 0) goto L_0x002d
            goto L_0x000a
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 == 0) goto L_0x0044
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r3.a     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.routepoisearch.RoutePOISearchQuery r0 = r0.clone()     // Catch:{ AMapException -> 0x004c }
            com.amap.api.col.stln3.oh r1 = new com.amap.api.col.stln3.oh     // Catch:{ AMapException -> 0x004c }
            android.content.Context r2 = r3.b     // Catch:{ AMapException -> 0x004c }
            r1.<init>(r2, r0)     // Catch:{ AMapException -> 0x004c }
            java.lang.Object r0 = r1.a()     // Catch:{ AMapException -> 0x004c }
            com.amap.api.services.routepoisearch.RoutePOISearchResult r0 = (com.amap.api.services.routepoisearch.RoutePOISearchResult) r0     // Catch:{ AMapException -> 0x004c }
            return r0
        L_0x0044:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException     // Catch:{ AMapException -> 0x004c }
            java.lang.String r1 = "无效的参数 - IllegalArgumentException"
            r0.<init>(r1)     // Catch:{ AMapException -> 0x004c }
            throw r0     // Catch:{ AMapException -> 0x004c }
        L_0x004c:
            r0 = move-exception
            java.lang.String r1 = "RoutePOISearchCore"
            java.lang.String r2 = "searchRoutePOI"
            com.amap.api.col.stln3.nl.a(r0, r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.pa.searchRoutePOI():com.amap.api.services.routepoisearch.RoutePOISearchResult");
    }
}
