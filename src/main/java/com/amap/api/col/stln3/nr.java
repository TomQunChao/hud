package com.amap.api.col.stln3;

import android.support.v4.app.NotificationCompat;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.traffic.TrafficStatusEvaluation;
import com.amap.api.services.traffic.TrafficStatusInfo;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public final class nr {
    private static String[] a = {"010", "021", "022", "023", "1852", "1853"};

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.nr.a(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities") || (optJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), m(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pois")) == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(d(optJSONObject));
            }
        }
        return arrayList;
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    nl.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    nl.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(b(jSONObject, "entr_location"));
        poiItem.setExit(b(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, "website"));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        poiItem.setBusinessArea(a(jSONObject, "business_area"));
        poiItem.setEmail(a(jSONObject, NotificationCompat.CATEGORY_EMAIL));
        String a3 = a(jSONObject, "indoor_map");
        int i = 0;
        if (a3 == null || a3.equals("") || a3.equals("0")) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        arrayList.add(j(optJSONObject3));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        String str = "";
        String str2 = "";
        if (jSONObject.has("indoor_data") && (optJSONObject2 = jSONObject.optJSONObject("indoor_data")) != null && optJSONObject2.has("cpid") && optJSONObject2.has("floor")) {
            str = a(optJSONObject2, "cpid");
            i = m(a(optJSONObject2, "floor"));
            str2 = a(optJSONObject2, "truefloor");
        }
        poiItem.setIndoorDate(new IndoorData(str, i, str2));
        String str3 = "";
        String str4 = "";
        if (jSONObject.has("biz_ext") && (optJSONObject = jSONObject.optJSONObject("biz_ext")) != null) {
            str3 = a(optJSONObject, "open_time");
            str4 = a(optJSONObject, "rating");
        }
        poiItem.setPoiExtension(new PoiItemExtension(str3, str4));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        List<Photo> x = x(jSONObject.optJSONObject("deep_info"));
        if (x.size() == 0) {
            x = x(jSONObject);
        }
        poiItem.setPhotos(x);
        return poiItem;
    }

    private static SubPoiItem j(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    nl.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    nl.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("busstops")) == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(k(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusStationItem k(JSONObject jSONObject) throws JSONException {
        BusStationItem l = l(jSONObject);
        if (l == null) {
            return l;
        }
        l.setAdCode(a(jSONObject, "adcode"));
        l.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            l.setBusLineItems(arrayList);
            return l;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m(optJSONObject));
            }
        }
        l.setBusLineItems(arrayList);
        return l;
    }

    private static BusStationItem l(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    private static BusLineItem m(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(c(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> f(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(n(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusLineItem n(JSONObject jSONObject) throws JSONException {
        BusLineItem m = m(jSONObject);
        if (m == null) {
            return m;
        }
        m.setFirstBusTime(nl.c(a(jSONObject, "start_time")));
        m.setLastBusTime(nl.c(a(jSONObject, "end_time")));
        m.setBusCompany(a(jSONObject, "company"));
        m.setDistance(n(a(jSONObject, "distance")));
        m.setBasicPrice(n(a(jSONObject, "basic_price")));
        m.setTotalPrice(n(a(jSONObject, "total_price")));
        m.setBounds(c(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            m.setBusStations(arrayList);
            return m;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(l(optJSONObject));
            }
        }
        m.setBusStations(arrayList);
        return m;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        String optString;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    DistrictItem districtItem2 = new DistrictItem();
                    districtItem2.setCitycode(a(optJSONObject, "citycode"));
                    districtItem2.setAdcode(a(optJSONObject, "adcode"));
                    districtItem2.setName(a(optJSONObject, "name"));
                    districtItem2.setLevel(a(optJSONObject, "level"));
                    districtItem2.setCenter(b(optJSONObject, "center"));
                    if (optJSONObject.has("polyline") && (optString = optJSONObject.optString("polyline")) != null && optString.length() > 0) {
                        districtItem2.setDistrictBoundary(optString.split("\\|"));
                    }
                    a(optJSONObject.optJSONArray("districts"), new ArrayList(), districtItem2);
                    arrayList.add(districtItem2);
                }
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static ArrayList<GeocodeAddress> g(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("geocodes")) == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GeocodeAddress geocodeAddress = new GeocodeAddress();
                geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                geocodeAddress.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                geocodeAddress.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                geocodeAddress.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                geocodeAddress.setTownship(a(optJSONObject, "township"));
                geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                geocodeAddress.setLatLonPoint(b(optJSONObject, "location"));
                geocodeAddress.setLevel(a(optJSONObject, "level"));
                arrayList.add(geocodeAddress);
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> h(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a2 = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, "direction"));
                crossroad.setDistance(n(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(b(optJSONObject, "location"));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(b(optJSONObject, "location"));
                regeocodeRoad.setDirection(a(optJSONObject, "direction"));
                regeocodeRoad.setDistance(n(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, DistrictSearchQuery.KEYWORDS_COUNTRY));
        regeocodeAddress.setProvince(a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(b(optJSONObject, "location"));
        streetNumber.setDirection(a(optJSONObject, "direction"));
        streetNumber.setDistance(n(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    businessArea.setCenterPoint(b(optJSONObject2, "location"));
                    businessArea.setName(a(optJSONObject2, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        regeocodeAddress.setBusinessAreas(arrayList);
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && k(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static boolean k(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        for (String str2 : a) {
            if (str.trim().equals(str2.trim())) {
                return true;
            }
        }
        return false;
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(b(optJSONObject, "origin"));
            busRouteResult.setTargetPos(b(optJSONObject, "destination"));
            busRouteResult.setTaxiCost(n(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(optJSONArray));
            return busRouteResult;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        TaxiItem taxiItem;
        RouteRailwayItem routeRailwayItem;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(n(a(optJSONObject, "cost")));
                busPath.setDuration(p(a(optJSONObject, "duration")));
                busPath.setNightBus(q(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(n(a(optJSONObject, "walking_distance")));
                busPath.setDistance(n(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            BusStep busStep = null;
                            if (optJSONObject2 != null) {
                                BusStep busStep2 = new BusStep();
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("walking");
                                if (optJSONObject3 != null) {
                                    busStep2.setWalk(o(optJSONObject3));
                                }
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("bus");
                                if (optJSONObject4 != null) {
                                    busStep2.setBusLines(p(optJSONObject4));
                                }
                                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("entrance");
                                if (optJSONObject5 != null) {
                                    busStep2.setEntrance(q(optJSONObject5));
                                }
                                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("exit");
                                if (optJSONObject6 != null) {
                                    busStep2.setExit(q(optJSONObject6));
                                }
                                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("railway");
                                if (optJSONObject7 != null) {
                                    if (optJSONObject7 != null && optJSONObject7.has("id") && optJSONObject7.has("name")) {
                                        routeRailwayItem = new RouteRailwayItem();
                                        routeRailwayItem.setID(a(optJSONObject7, "id"));
                                        routeRailwayItem.setName(a(optJSONObject7, "name"));
                                        routeRailwayItem.setTime(a(optJSONObject7, "time"));
                                        routeRailwayItem.setTrip(a(optJSONObject7, "trip"));
                                        routeRailwayItem.setDistance(n(a(optJSONObject7, "distance")));
                                        routeRailwayItem.setType(a(optJSONObject7, "type"));
                                        routeRailwayItem.setDeparturestop(t(optJSONObject7.optJSONObject("departure_stop")));
                                        routeRailwayItem.setArrivalstop(t(optJSONObject7.optJSONObject("arrival_stop")));
                                        routeRailwayItem.setViastops(u(optJSONObject7));
                                        routeRailwayItem.setAlters(v(optJSONObject7));
                                        routeRailwayItem.setSpaces(w(optJSONObject7));
                                    } else {
                                        routeRailwayItem = null;
                                    }
                                    busStep2.setRailway(routeRailwayItem);
                                }
                                JSONObject optJSONObject8 = optJSONObject2.optJSONObject("taxi");
                                if (optJSONObject8 != null) {
                                    if (optJSONObject8 == null) {
                                        taxiItem = null;
                                    } else {
                                        taxiItem = new TaxiItem();
                                        taxiItem.setOrigin(b(optJSONObject8, "origin"));
                                        taxiItem.setDestination(b(optJSONObject8, "destination"));
                                        taxiItem.setDistance(n(a(optJSONObject8, "distance")));
                                        taxiItem.setDuration(n(a(optJSONObject8, "duration")));
                                        taxiItem.setSname(a(optJSONObject8, "sname"));
                                        taxiItem.setTname(a(optJSONObject8, "tname"));
                                    }
                                    busStep2.setTaxi(taxiItem);
                                }
                                if (!((busStep2.getWalk() == null || busStep2.getWalk().getSteps().size() == 0) && busStep2.getBusLines().size() == 0 && busStep2.getRailway() == null && busStep2.getTaxi() == null)) {
                                    busStep = busStep2;
                                }
                            }
                            if (busStep != null) {
                                arrayList2.add(busStep);
                                if (busStep.getWalk() != null) {
                                    f2 += busStep.getWalk().getDistance();
                                }
                                if (busStep.getBusLines() != null && busStep.getBusLines().size() > 0) {
                                    f += busStep.getBusLines().get(0).getDistance();
                                }
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    private static RouteBusWalkItem o(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(b(jSONObject, "origin"));
        routeBusWalkItem.setDestination(b(jSONObject, "destination"));
        routeBusWalkItem.setDistance(n(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(p(a(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                WalkStep walkStep = new WalkStep();
                walkStep.setInstruction(a(optJSONObject, "instruction"));
                walkStep.setOrientation(a(optJSONObject, "orientation"));
                walkStep.setRoad(a(optJSONObject, "road"));
                walkStep.setDistance(n(a(optJSONObject, "distance")));
                walkStep.setDuration(n(a(optJSONObject, "duration")));
                walkStep.setPolyline(c(optJSONObject, "polyline"));
                walkStep.setAction(a(optJSONObject, "action"));
                walkStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                arrayList.add(walkStep);
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    private static List<RouteBusLineItem> p(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        RouteBusLineItem routeBusLineItem;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                if (optJSONObject == null) {
                    routeBusLineItem = null;
                } else {
                    RouteBusLineItem routeBusLineItem2 = new RouteBusLineItem();
                    routeBusLineItem2.setDepartureBusStation(s(optJSONObject.optJSONObject("departure_stop")));
                    routeBusLineItem2.setArrivalBusStation(s(optJSONObject.optJSONObject("arrival_stop")));
                    routeBusLineItem2.setBusLineName(a(optJSONObject, "name"));
                    routeBusLineItem2.setBusLineId(a(optJSONObject, "id"));
                    routeBusLineItem2.setBusLineType(a(optJSONObject, "type"));
                    routeBusLineItem2.setDistance(n(a(optJSONObject, "distance")));
                    routeBusLineItem2.setDuration(n(a(optJSONObject, "duration")));
                    routeBusLineItem2.setPolyline(c(optJSONObject, "polyline"));
                    routeBusLineItem2.setFirstBusTime(nl.c(a(optJSONObject, "start_time")));
                    routeBusLineItem2.setLastBusTime(nl.c(a(optJSONObject, "end_time")));
                    routeBusLineItem2.setPassStationNum(m(a(optJSONObject, "via_num")));
                    routeBusLineItem2.setPassStations(r(optJSONObject));
                    routeBusLineItem = routeBusLineItem2;
                }
                arrayList.add(routeBusLineItem);
            }
        }
        return arrayList;
    }

    private static Doorway q(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(b(jSONObject, "location"));
        return doorway;
    }

    private static List<BusStationItem> r(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(s(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusStationItem s(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        return busStationItem;
    }

    private static RailwayStationItem t(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(b(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(q(a(jSONObject, "start")));
        railwayStationItem.setisEnd(q(a(jSONObject, "end")));
        railwayStationItem.setWait(n(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> u(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(t(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> v(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> w(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new RailwaySpace(a(optJSONObject, "code"), n(a(optJSONObject, "cost"))));
            }
        }
        return arrayList;
    }

    public static DriveRouteResult b(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(b(optJSONObject, "origin"));
            driveRouteResult.setTargetPos(b(optJSONObject, "destination"));
            driveRouteResult.setTaxiCost(n(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                DrivePath drivePath = new DrivePath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(n(a(optJSONObject2, "distance")));
                    drivePath.setDuration(p(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(n(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(n(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(m(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(m(a(optJSONObject2, "restriction")));
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(n(a(optJSONObject3, "distance")));
                                driveStep.setTolls(n(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(n(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(n(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(c(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                b(driveStep, optJSONObject3);
                                a(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            }
                        }
                        drivePath.setSteps(arrayList2);
                        arrayList.add(drivePath);
                    }
                }
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            nl.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(m(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, NotificationCompat.CATEGORY_STATUS));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                driveStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                driveStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                nl.a(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static WalkRouteResult c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(b(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(n(a(optJSONObject2, "distance")));
                    walkPath.setDuration(p(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(n(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(n(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(c(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherLive;
                    }
                    localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherLive.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherLive.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherLive.setWeather(a(optJSONObject, "weather"));
                    localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
                    localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
                    localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
                    localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
                    return localWeatherLive;
                }
            }
            return localWeatherLive;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherForecast e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                                    localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                                    localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                                    localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                                    localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                                    localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                                    localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                                    localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                                    localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                                    localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                                    arrayList.add(localDayWeatherForecast);
                                }
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                            return localWeatherForecast;
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                    return localWeatherForecast;
                }
            }
            return localWeatherForecast;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.optString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    public static LatLonPoint b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return l(jSONObject.optString(str));
        }
        return null;
    }

    private static ArrayList<LatLonPoint> c(JSONObject jSONObject, String str) throws JSONException {
        String[] split;
        if (!jSONObject.has(str)) {
            return null;
        }
        String optString = jSONObject.optString(str);
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : optString.split(";")) {
            arrayList.add(l(str2));
        }
        return arrayList;
    }

    private static LatLonPoint l(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static boolean f(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    private static int m(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            nl.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    private static float n(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            nl.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static double o(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            nl.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    private static long p(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            nl.a(e, "JSONHelper", "str2long");
            return 0;
        }
    }

    private static boolean q(String str) {
        if (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) {
            return false;
        }
        return true;
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(b(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(n(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static List<Photo> x(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            Photo photo = new Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> i(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(y(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(y(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static RoutePOIItem y(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(b(jSONObject, "location"));
        routePOIItem.setDistance(n(a(jSONObject, "distance")));
        routePOIItem.setDuration(n(a(jSONObject, "duration")));
        return routePOIItem;
    }

    public static RideRouteResult g(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(b(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RidePath z = z(optJSONArray.optJSONObject(i));
                    if (z != null) {
                        arrayList.add(z);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath z2 = z(optJSONObject2.optJSONObject("path"));
                if (z2 != null) {
                    arrayList.add(z2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath z(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(n(a(jSONObject, "distance")));
            ridePath.setDuration(p(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(n(a(optJSONObject, "distance")));
                        rideStep.setDuration(n(a(optJSONObject, "duration")));
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TrafficStatusResult h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("trafficinfo")) {
                return null;
            }
            TrafficStatusResult trafficStatusResult = new TrafficStatusResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("trafficinfo");
            trafficStatusResult.setDescription(a(optJSONObject, "description"));
            if (optJSONObject.has("evaluation")) {
                TrafficStatusEvaluation trafficStatusEvaluation = new TrafficStatusEvaluation();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("evaluation");
                trafficStatusEvaluation.setExpedite(a(optJSONObject2, "expedite"));
                trafficStatusEvaluation.setCongested(a(optJSONObject2, "congested"));
                trafficStatusEvaluation.setBlocked(a(optJSONObject2, "blocked"));
                trafficStatusEvaluation.setUnknown(a(optJSONObject2, EnvironmentCompat.MEDIA_UNKNOWN));
                trafficStatusEvaluation.setStatus(a(optJSONObject2, NotificationCompat.CATEGORY_STATUS));
                trafficStatusEvaluation.setDescription(a(optJSONObject2, "description"));
                trafficStatusResult.setEvaluation(trafficStatusEvaluation);
            }
            if (!optJSONObject.has("roads")) {
                return trafficStatusResult;
            }
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("roads");
            if (opt == null) {
                trafficStatusResult.setRoads(arrayList);
                return trafficStatusResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TrafficStatusInfo A = A(optJSONArray.optJSONObject(i));
                    if (A != null) {
                        arrayList.add(A);
                    }
                }
            }
            trafficStatusResult.setRoads(arrayList);
            return trafficStatusResult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static TrafficStatusInfo A(JSONObject jSONObject) throws AMapException {
        TrafficStatusInfo trafficStatusInfo = new TrafficStatusInfo();
        try {
            trafficStatusInfo.setName(a(jSONObject, "name"));
            trafficStatusInfo.setStatus(a(jSONObject, NotificationCompat.CATEGORY_STATUS));
            trafficStatusInfo.setAngle(m(a(jSONObject, "angle")));
            trafficStatusInfo.setSpeed(n(a(jSONObject, "speed")));
            trafficStatusInfo.setDirection(a(jSONObject, "direction"));
            trafficStatusInfo.setLcodes(a(jSONObject, "lcodes"));
            trafficStatusInfo.setCoordinates(c(jSONObject, "polyline"));
            return trafficStatusInfo;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseRoadInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DistanceResult i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                distanceItem.setOriginId(m(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(m(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(n(a(jSONObject2, "distance")));
                distanceItem.setDuration(n(a(jSONObject2, "duration")));
                String a2 = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(a2)) {
                    distanceItem.setErrorInfo(a2);
                    distanceItem.setErrorCode(m(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TruckRouteRestult j(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(b(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                TruckPath truckPath = new TruckPath();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                truckPath.setDistance(n(a(jSONObject2, "distance")));
                truckPath.setDuration(p(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, "strategy"));
                truckPath.setTolls(n(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(n(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(m(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(m(a(jSONObject2, "restriction")));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        TruckStep truckStep = new TruckStep();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            truckStep.setInstruction(a(optJSONObject2, "instruction"));
                            truckStep.setOrientation(a(optJSONObject2, "orientation"));
                            truckStep.setRoad(a(optJSONObject2, "road"));
                            truckStep.setDistance(n(a(optJSONObject2, "distance")));
                            truckStep.setTolls(n(a(optJSONObject2, "tolls")));
                            truckStep.setTollDistance(n(a(optJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                            truckStep.setDuration(n(a(optJSONObject2, "duration")));
                            truckStep.setPolyline(c(optJSONObject2, "polyline"));
                            truckStep.setAction(a(optJSONObject2, "action"));
                            truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                            a(truckStep, optJSONObject2);
                            b(truckStep, optJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                truckStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(m(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, NotificationCompat.CATEGORY_STATUS));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                truckStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            nl.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }
}
