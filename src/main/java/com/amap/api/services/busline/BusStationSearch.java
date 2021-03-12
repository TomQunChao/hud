package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.os;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

public class BusStationSearch {
    private IBusStationSearch a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        try {
            this.a = (IBusStationSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.BusStationSearchWrapper", os.class, new Class[]{Context.class, BusStationQuery.class}, new Object[]{context, busStationQuery});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new os(context, busStationQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }
}
