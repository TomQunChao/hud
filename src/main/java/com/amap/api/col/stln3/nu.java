package com.amap.api.col.stln3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageHandler */
public final class nu extends Handler {
    private static nu a;

    /* compiled from: MessageHandler */
    public static class a {
        public BusLineResult a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class b {
        public BusStationResult a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class c {
        public CloudItemDetail a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class d {
        public CloudResult a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class e {
        public GeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class f {
        public List<NearbySearch.NearbyListener> a;
        public NearbySearchResult b;
    }

    /* compiled from: MessageHandler */
    public static class g {
        public PoiItem a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class h {
        public PoiResult a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class i {
        public RegeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class j {
        public RoutePOISearchResult a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class k {
        public LocalWeatherForecastResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class l {
        public LocalWeatherLiveResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    public static synchronized nu a() {
        nu nuVar;
        synchronized (nu.class) {
            if (a == null) {
                if (Looper.myLooper() != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        a = new nu();
                    }
                }
                a = new nu(Looper.getMainLooper());
            }
            nuVar = a;
        }
        return nuVar;
    }

    nu() {
    }

    private nu(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        Bundle data;
        e eVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        g gVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data2;
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        List<NearbySearch.NearbyListener> list;
        c cVar;
        k kVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data3;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data4;
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data5;
        Bundle data6;
        Bundle data7;
        try {
            BusLineResult busLineResult = null;
            NearbySearchResult nearbySearchResult = null;
            BusStationResult busStationResult = null;
            ArrayList arrayList = null;
            switch (message.arg1) {
                case 1:
                    RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
                    if (onRouteSearchListener == null) {
                        return;
                    }
                    if (message.what == 100) {
                        Bundle data8 = message.getData();
                        if (data8 != null) {
                            onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data8.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 101) {
                        Bundle data9 = message.getData();
                        if (data9 != null) {
                            onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data9.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 102) {
                        Bundle data10 = message.getData();
                        if (data10 != null) {
                            onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data10.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 103) {
                        Bundle data11 = message.getData();
                        if (data11 != null) {
                            onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data11.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 104 && (data = message.getData()) != null) {
                        onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt(MyLocationStyle.ERROR_CODE));
                        return;
                    } else {
                        return;
                    }
                case 2:
                    if (message.what == 201) {
                        i iVar = (i) message.obj;
                        if (!(iVar == null || (onGeocodeSearchListener2 = iVar.b) == null)) {
                            onGeocodeSearchListener2.onRegeocodeSearched(iVar.a, message.arg2);
                            return;
                        }
                        return;
                    } else if (message.what == 200 && (eVar = (e) message.obj) != null && (onGeocodeSearchListener = eVar.b) != null) {
                        onGeocodeSearchListener.onGeocodeSearched(eVar.a, message.arg2);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    a aVar = (a) message.obj;
                    if (!(aVar == null || (onBusLineSearchListener = aVar.b) == null)) {
                        if (message.what == 1000) {
                            busLineResult = aVar.a;
                        }
                        onBusLineSearchListener.onBusLineSearched(busLineResult, message.what);
                        return;
                    }
                    return;
                case 4:
                    DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
                    if (onDistrictSearchListener != null) {
                        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
                        return;
                    }
                    return;
                case 5:
                    Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
                    if (inputtipsListener != null) {
                        if (message.what == 1000) {
                            arrayList = message.getData().getParcelableArrayList("result");
                        }
                        inputtipsListener.onGetInputtips(arrayList, message.what);
                        return;
                    }
                    return;
                case 6:
                    if (message.what == 600) {
                        h hVar = (h) message.obj;
                        if (!(hVar == null || (onPoiSearchListener = hVar.b) == null || (data2 = message.getData()) == null)) {
                            onPoiSearchListener.onPoiSearched(hVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 602 && (gVar = (g) message.obj) != null) {
                        PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
                        Bundle data12 = message.getData();
                        if (data12 != null) {
                            onPoiSearchListener2.onPoiItemSearched(gVar.a, data12.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 7:
                    b bVar = (b) message.obj;
                    if (!(bVar == null || (onBusStationSearchListener = bVar.b) == null)) {
                        if (message.what == 1000) {
                            busStationResult = bVar.a;
                        }
                        onBusStationSearchListener.onBusStationSearched(busStationResult, message.what);
                        return;
                    }
                    return;
                case 8:
                    List<NearbySearch.NearbyListener> list2 = (List) message.obj;
                    if (list2 == null) {
                        return;
                    }
                    if (list2.size() != 0) {
                        for (NearbySearch.NearbyListener nearbyListener : list2) {
                            nearbyListener.onUserInfoCleared(message.what);
                        }
                        return;
                    }
                    return;
                case 9:
                    f fVar = (f) message.obj;
                    if (!(fVar == null || (list = fVar.a) == null)) {
                        if (list.size() != 0) {
                            if (message.what == 1000) {
                                nearbySearchResult = fVar.b;
                            }
                            for (NearbySearch.NearbyListener nearbyListener2 : list) {
                                nearbyListener2.onNearbyInfoSearched(nearbySearchResult, message.what);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    List<NearbySearch.NearbyListener> list3 = (List) message.obj;
                    if (list3 == null) {
                        return;
                    }
                    if (list3.size() != 0) {
                        for (NearbySearch.NearbyListener nearbyListener3 : list3) {
                            nearbyListener3.onNearbyInfoUploaded(message.what);
                        }
                        return;
                    }
                    return;
                case 11:
                    int i2 = message.arg2;
                    ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
                    String string = message.getData().getString("shareurlkey");
                    if (onShareSearchListener != null) {
                        switch (message.what) {
                            case 1100:
                                onShareSearchListener.onPoiShareUrlSearched(string, i2);
                                return;
                            case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /*{ENCODED_INT: 1101}*/:
                                onShareSearchListener.onLocationShareUrlSearched(string, i2);
                                return;
                            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /*{ENCODED_INT: 1102}*/:
                                onShareSearchListener.onNaviShareUrlSearched(string, i2);
                                return;
                            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /*{ENCODED_INT: 1103}*/:
                                onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                                return;
                            case 1104:
                                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                                return;
                            case 1105:
                                onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                                return;
                            default:
                                return;
                        }
                    } else {
                        return;
                    }
                case 12:
                    if (message.what == 700) {
                        d dVar = (d) message.obj;
                        if (dVar != null) {
                            dVar.b.onCloudSearched(dVar.a, message.arg2);
                            return;
                        }
                        return;
                    } else if (message.what == 701 && (cVar = (c) message.obj) != null) {
                        cVar.b.onCloudItemDetailSearched(cVar.a, message.arg2);
                        return;
                    } else {
                        return;
                    }
                case 13:
                    if (message.what == 1301) {
                        l lVar = (l) message.obj;
                        if (!(lVar == null || (onWeatherSearchListener2 = lVar.b) == null || (data4 = message.getData()) == null)) {
                            onWeatherSearchListener2.onWeatherLiveSearched(lVar.a, data4.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 1302 && (kVar = (k) message.obj) != null && (onWeatherSearchListener = kVar.b) != null && (data3 = message.getData()) != null) {
                        onWeatherSearchListener.onWeatherForecastSearched(kVar.a, data3.getInt(MyLocationStyle.ERROR_CODE));
                        return;
                    } else {
                        return;
                    }
                case 14:
                    j jVar = (j) message.obj;
                    if (!(jVar == null || (onRoutePOISearchListener = jVar.b) == null || (data5 = message.getData()) == null)) {
                        onRoutePOISearchListener.onRoutePoiSearched(jVar.a, data5.getInt(MyLocationStyle.ERROR_CODE));
                        return;
                    }
                    return;
                case 15:
                    TrafficSearch.OnTrafficSearchListener onTrafficSearchListener = (TrafficSearch.OnTrafficSearchListener) message.obj;
                    if (onTrafficSearchListener == null) {
                        return;
                    }
                    if (message.what == 300) {
                        Bundle data13 = message.getData();
                        if (data13 != null) {
                            onTrafficSearchListener.onRoadTrafficSearched((TrafficStatusResult) message.getData().getParcelable("result"), data13.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 301) {
                        Bundle data14 = message.getData();
                        if (data14 != null) {
                            onTrafficSearchListener.onRoadTrafficSearched((TrafficStatusResult) message.getData().getParcelable("result"), data14.getInt(MyLocationStyle.ERROR_CODE));
                            return;
                        }
                        return;
                    } else if (message.what == 302) {
                        message.getData();
                        return;
                    } else {
                        return;
                    }
                case 16:
                    DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
                    if (!(onDistanceSearchListener == null || message.what != 400 || (data6 = message.getData()) == null)) {
                        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data6.getInt(MyLocationStyle.ERROR_CODE));
                    }
                    return;
                case 17:
                    RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
                    if (!(onTruckRouteSearchListener == null || message.what != 104 || (data7 = message.getData()) == null)) {
                        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data7.getInt(MyLocationStyle.ERROR_CODE));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            nl.a(th, "MessageHandler", "handleMessage");
        }
    }
}
