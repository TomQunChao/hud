package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;

/* compiled from: PoiSearchCore */
public class oz implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;
    private PoiSearch.SearchBound a;
    private PoiSearch.Query b;
    private Context c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j = null;

    public oz(Context context, PoiSearch.Query query) {
        this.c = context.getApplicationContext();
        setQuery(query);
        this.j = nu.a();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public String getLanguage() {
        return this.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r0.getCenter() == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e9, code lost:
        if (r9.a.equals(r9.g) == false) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01bc A[Catch:{ AMapException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c3 A[Catch:{ AMapException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0114 A[Catch:{ AMapException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0120 A[Catch:{ AMapException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0164 A[Catch:{ AMapException -> 0x01c4 }] */
    @Override // com.amap.api.services.interfaces.IPoiSearch
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.poisearch.PoiResult searchPOI() throws com.amap.api.services.core.AMapException {
        /*
        // Method dump skipped, instructions count: 470
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.oz.searchPOI():com.amap.api.services.poisearch.PoiResult");
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.oz.AnonymousClass1 */

                public final void run() {
                    nu.h hVar;
                    Message obtainMessage = oz.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        poiResult = oz.this.searchPOI();
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                        hVar = new nu.h();
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        hVar = new nu.h();
                    } catch (Throwable th) {
                        nu.h hVar2 = new nu.h();
                        hVar2.b = oz.this.d;
                        hVar2.a = poiResult;
                        obtainMessage.obj = hVar2;
                        obtainMessage.setData(bundle);
                        oz.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                    hVar.b = oz.this.d;
                    hVar.a = poiResult;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    oz.this.j.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiItem searchPOIId(String str) throws AMapException {
        ns.a(this.c);
        return (PoiItem) new nz(this.c, str).a();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIIdAsyn(final String str) {
        ok.a().a(new Runnable() {
            /* class com.amap.api.col.stln3.oz.AnonymousClass2 */

            public final void run() {
                nu.g gVar;
                Message obtainMessage = nu.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    poiItem = oz.this.searchPOIId(str);
                    bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    gVar = new nu.g();
                } catch (AMapException e) {
                    nl.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    gVar = new nu.g();
                } catch (Throwable th) {
                    nu.g gVar2 = new nu.g();
                    gVar2.b = oz.this.d;
                    gVar2.a = poiItem;
                    obtainMessage.obj = gVar2;
                    obtainMessage.setData(bundle);
                    oz.this.j.sendMessage(obtainMessage);
                    throw th;
                }
                gVar.b = oz.this.d;
                gVar.a = poiItem;
                obtainMessage.obj = gVar;
                obtainMessage.setData(bundle);
                oz.this.j.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setBound(PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.SearchBound getBound() {
        return this.a;
    }
}
