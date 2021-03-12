package com.amap.api.services.traffic;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.pd;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;

public class TrafficSearch {
    public static int ROAD_LEVEL_CITY_QUICK_WAY = 2;
    public static int ROAD_LEVEL_HIGH_WAY = 1;
    public static int ROAD_LEVEL_HIGH_WAY_BYROAD = 3;
    public static int ROAD_LEVEL_MAIN_WAY = 4;
    public static int ROAD_LEVEL_NONAME_WAY = 6;
    public static int ROAD_LEVEL_NORMAL_WAY = 5;
    private ITrafficSearch a;

    public interface OnTrafficSearchListener {
        void onRoadTrafficSearched(TrafficStatusResult trafficStatusResult, int i);
    }

    public TrafficSearch(Context context) {
        try {
            this.a = (ITrafficSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.TrafficSearchWrapper", pd.class, new Class[]{Context.class}, new Object[]{context});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new pd(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setTrafficSearchListener(OnTrafficSearchListener onTrafficSearchListener) {
        ITrafficSearch iTrafficSearch = this.a;
        if (iTrafficSearch != null) {
            iTrafficSearch.setTrafficSearchListener(onTrafficSearchListener);
        }
    }

    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        ITrafficSearch iTrafficSearch = this.a;
        if (iTrafficSearch != null) {
            return iTrafficSearch.loadTrafficByRoad(roadTrafficQuery);
        }
        return null;
    }

    public void loadTrafficByRoadAsyn(RoadTrafficQuery roadTrafficQuery) {
        ITrafficSearch iTrafficSearch = this.a;
        if (iTrafficSearch != null) {
            iTrafficSearch.loadTrafficByRoadAsyn(roadTrafficQuery);
        }
    }

    public TrafficStatusResult loadTrafficByCircle(CircleTrafficQuery circleTrafficQuery) throws AMapException {
        ITrafficSearch iTrafficSearch = this.a;
        if (iTrafficSearch != null) {
            return iTrafficSearch.loadTrafficByCircle(circleTrafficQuery);
        }
        return null;
    }

    public void loadTrafficByCircleAsyn(CircleTrafficQuery circleTrafficQuery) {
        ITrafficSearch iTrafficSearch = this.a;
        if (iTrafficSearch != null) {
            iTrafficSearch.loadTrafficByCircleAsyn(circleTrafficQuery);
        }
    }
}
