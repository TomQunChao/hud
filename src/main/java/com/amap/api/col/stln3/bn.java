package com.amap.api.col.stln3;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeoFenceSearchResultParser */
public final class bn {
    private static long a = 0;

    public static int a(String str, List<GeoFence> list, Bundle bundle) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c = 0;
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt != 1) {
                return optInt2;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null) {
                return optInt2;
            }
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                GeoFence geoFence = new GeoFence();
                PoiItem poiItem = new PoiItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                poiItem.setPoiId(jSONObject2.optString("id"));
                poiItem.setPoiName(jSONObject2.optString("name"));
                poiItem.setPoiType(jSONObject2.optString("type"));
                poiItem.setTypeCode(jSONObject2.optString("typecode"));
                poiItem.setAddress(jSONObject2.optString("address"));
                String optString = jSONObject2.optString("location");
                if (optString != null) {
                    String[] split = optString.split(",");
                    poiItem.setLongitude(Double.parseDouble(split[c]));
                    poiItem.setLatitude(Double.parseDouble(split[1]));
                    List<List<DPoint>> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    i = optInt2;
                    DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                    arrayList2.add(dPoint);
                    arrayList.add(arrayList2);
                    geoFence.setPointList(arrayList);
                    geoFence.setCenter(dPoint);
                } else {
                    i = optInt2;
                }
                poiItem.setTel(jSONObject2.optString("tel"));
                poiItem.setProvince(jSONObject2.optString("pname"));
                poiItem.setCity(jSONObject2.optString("cityname"));
                poiItem.setAdname(jSONObject2.optString("adname"));
                geoFence.setPoiItem(poiItem);
                StringBuilder sb = new StringBuilder();
                sb.append(a());
                geoFence.setFenceId(sb.toString());
                if (bundle != null) {
                    geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                    geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                    geoFence.setType(2);
                    geoFence.setRadius(bundle.getFloat("fenceRadius"));
                    geoFence.setExpiration(bundle.getLong("expiration"));
                    geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                }
                if (list != null) {
                    list.add(geoFence);
                }
                i2++;
                optInt2 = i;
                c = 0;
            }
            return optInt2;
        } catch (Throwable th) {
            return 5;
        }
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        return a(str, list, bundle);
    }

    public final int c(String str, List<GeoFence> list, Bundle bundle) {
        String str2;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str3;
        long j;
        float f;
        int i2;
        int i3;
        String str4;
        String str5;
        GeoFence geoFence;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            float f2 = 0.0f;
            long j2 = 0;
            String str6 = null;
            if (bundle != null) {
                str6 = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string = bundle.getString("pendingIntentAction");
                float f3 = bundle.getFloat("fenceRadius");
                long j3 = bundle.getLong("expiration");
                i = bundle.getInt("activatesAction", 1);
                str2 = string;
                f2 = f3;
                j2 = j3;
            } else {
                str2 = null;
                i = 0;
            }
            if (optInt != 1) {
                return optInt2;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return optInt2;
            }
            int i4 = 0;
            while (i4 < optJSONArray.length()) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                GeoFence geoFence2 = new GeoFence();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                String optString = jSONObject2.optString("citycode");
                String optString2 = jSONObject2.optString("adcode");
                String optString3 = jSONObject2.optString("name");
                String string2 = jSONObject2.getString("center");
                DPoint dPoint = new DPoint();
                if (string2 != null) {
                    String[] split = string2.split(",");
                    arrayList2 = arrayList3;
                    arrayList = arrayList4;
                    dPoint.setLatitude(Double.parseDouble(split[1]));
                    dPoint.setLongitude(Double.parseDouble(split[0]));
                    geoFence2.setCenter(dPoint);
                } else {
                    arrayList2 = arrayList3;
                    arrayList = arrayList4;
                }
                geoFence2.setCustomId(str6);
                geoFence2.setPendingIntentAction(str2);
                geoFence2.setType(3);
                geoFence2.setRadius(f2);
                geoFence2.setExpiration(j2);
                geoFence2.setActivatesAction(i);
                StringBuilder sb = new StringBuilder();
                sb.append(a());
                geoFence2.setFenceId(sb.toString());
                String optString4 = jSONObject2.optString("polyline");
                if (optString4 != null) {
                    String[] split2 = optString4.split("\\|");
                    int length = split2.length;
                    i2 = i;
                    float f4 = Float.MAX_VALUE;
                    int i5 = 0;
                    float f5 = Float.MIN_VALUE;
                    while (i5 < length) {
                        String str7 = split2[i5];
                        DistrictItem districtItem = new DistrictItem();
                        List<DPoint> arrayList5 = new ArrayList<>();
                        districtItem.setCitycode(optString);
                        districtItem.setAdcode(optString2);
                        districtItem.setDistrictName(optString3);
                        String[] split3 = str7.split(";");
                        int i6 = 0;
                        while (i6 < split3.length) {
                            String[] split4 = split3[i6].split(",");
                            if (split4.length > 1) {
                                String str8 = split4[1];
                                String str9 = split4[0];
                                str5 = str6;
                                str4 = optString2;
                                double parseDouble = Double.parseDouble(str8);
                                geoFence = geoFence2;
                                i3 = length;
                                arrayList5.add(new DPoint(parseDouble, Double.parseDouble(str9)));
                            } else {
                                str5 = str6;
                                str4 = optString2;
                                geoFence = geoFence2;
                                i3 = length;
                            }
                            i6++;
                            geoFence2 = geoFence;
                            optString3 = optString3;
                            optString = optString;
                            split3 = split3;
                            str6 = str5;
                            optString2 = str4;
                            length = i3;
                        }
                        if (((float) arrayList5.size()) > 100.0f) {
                            try {
                                arrayList5 = a(arrayList5, 100.0f);
                            } catch (Throwable th) {
                                return 5;
                            }
                        }
                        arrayList.add(arrayList5);
                        districtItem.setPolyline(arrayList5);
                        arrayList2.add(districtItem);
                        f5 = Math.max(f5, bl.b(dPoint, arrayList5));
                        f4 = Math.min(f4, bl.a(dPoint, arrayList5));
                        i5++;
                        geoFence2 = geoFence2;
                        arrayList = arrayList;
                        f2 = f2;
                        split2 = split2;
                        j2 = j2;
                        optString3 = optString3;
                        optString = optString;
                        str6 = str6;
                        optString2 = optString2;
                        length = length;
                    }
                    f = f2;
                    j = j2;
                    str3 = str6;
                    geoFence2.setMaxDis2Center(f5);
                    geoFence2.setMinDis2Center(f4);
                    geoFence2.setDistrictItemList(arrayList2);
                    geoFence2.setPointList(arrayList);
                    if (list != null) {
                        list.add(geoFence2);
                    }
                } else {
                    i2 = i;
                    f = f2;
                    j = j2;
                    str3 = str6;
                }
                i4++;
                optJSONArray = optJSONArray;
                optInt2 = optInt2;
                i = i2;
                f2 = f;
                j2 = j;
                str6 = str3;
            }
            return optInt2;
        } catch (Throwable th2) {
            return 5;
        }
    }

    public static synchronized long a() {
        long j;
        synchronized (bn.class) {
            long b = wc.b();
            if (b > a) {
                a = b;
            } else {
                a++;
            }
            j = a;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.amap.api.location.DPoint> a(java.util.List<com.amap.api.location.DPoint> r29, float r30) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bn.a(java.util.List, float):java.util.List");
    }
}
