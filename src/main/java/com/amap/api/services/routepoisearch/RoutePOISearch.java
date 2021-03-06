package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.pa;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    private IRoutePOISearch a;

    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult routePOISearchResult, int i);
    }

    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea
    }

    public RoutePOISearch(Context context, RoutePOISearchQuery routePOISearchQuery) {
        try {
            this.a = (IRoutePOISearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.RoutePOISearchWrapper", pa.class, new Class[]{Context.class, RoutePOISearchQuery.class}, new Object[]{context, routePOISearchQuery});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new pa(context, routePOISearchQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setPoiSearchListener(OnRoutePOISearchListener onRoutePOISearchListener) {
        IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch iRoutePOISearch = this.a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }
}
