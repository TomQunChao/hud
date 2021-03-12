package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: BusLineSearchCore */
public class or implements IBusLineSearch {
    private Context a;
    private BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    private Handler g = null;

    public or(Context context, BusLineQuery busLineQuery) {
        this.a = context.getApplicationContext();
        this.c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.clone();
        }
        this.g = nu.a();
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineResult searchBusLine() throws AMapException {
        try {
            ns.a(this.a);
            if (this.d != null) {
                if (this.c != null && !nl.a(this.c.getQueryString())) {
                    if (!this.c.weakEquals(this.d)) {
                        this.d = this.c.clone();
                        this.e = 0;
                        if (this.f != null) {
                            this.f.clear();
                        }
                    }
                    if (this.e == 0) {
                        BusLineResult busLineResult = (BusLineResult) new nf(this.a, this.c.clone()).a();
                        this.f = new ArrayList<>();
                        for (int i = 0; i < this.e; i++) {
                            this.f.add(null);
                        }
                        if (this.e >= 0 && a(this.c.getPageNumber())) {
                            this.f.set(this.c.getPageNumber(), busLineResult);
                        }
                        return busLineResult;
                    }
                    int pageNumber = this.c.getPageNumber();
                    if (a(pageNumber)) {
                        BusLineResult busLineResult2 = this.f.get(pageNumber);
                        if (busLineResult2 != null) {
                            return busLineResult2;
                        }
                        BusLineResult busLineResult3 = (BusLineResult) new nf(this.a, this.c).a();
                        this.f.set(this.c.getPageNumber(), busLineResult3);
                        return busLineResult3;
                    }
                    throw new IllegalArgumentException("page out of range");
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            nl.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void searchBusLineAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.or.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        nu.a aVar = new nu.a();
                        obtainMessage.obj = aVar;
                        aVar.b = or.this.b;
                        aVar.a = or.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        or.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    or.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.c.weakEquals(busLineQuery)) {
            this.c = busLineQuery;
            this.d = busLineQuery.clone();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineQuery getQuery() {
        return this.c;
    }
}
