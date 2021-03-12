package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: BusStationSearchCore */
public class os implements IBusStationSearch {
    private Context a;
    private BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public os(Context context, BusStationQuery busStationQuery) {
        this.a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = nu.a();
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationResult searchBusStation() throws AMapException {
        try {
            ns.a(this.a);
            boolean z = true;
            if (this.c != null && !nl.a(this.c.getQueryString())) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.clone();
                    this.f = 0;
                    if (this.e != null) {
                        this.e.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new nf(this.a, this.c).a();
                    this.f = busStationResult.getPageCount();
                    this.e = new ArrayList<>();
                    for (int i = 0; i <= this.f; i++) {
                        this.e.add(null);
                    }
                    if (this.f > 0) {
                        this.e.set(this.c.getPageNumber(), busStationResult);
                    }
                    return busStationResult;
                }
                int pageNumber = this.c.getPageNumber();
                if (pageNumber > this.f || pageNumber < 0) {
                    z = false;
                }
                if (z) {
                    BusStationResult busStationResult2 = this.e.get(pageNumber);
                    if (busStationResult2 != null) {
                        return busStationResult2;
                    }
                    BusStationResult busStationResult3 = (BusStationResult) new nf(this.a, this.c).a();
                    this.e.set(this.c.getPageNumber(), busStationResult3);
                    return busStationResult3;
                }
                throw new IllegalArgumentException("page out of range");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            nl.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        } catch (Throwable th) {
            nl.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void searchBusStationAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.os.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        nu.b bVar = new nu.b();
                        bVar.b = os.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = os.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        os.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    os.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.c)) {
            this.c = busStationQuery;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationQuery getQuery() {
        return this.c;
    }
}
