package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GeoFenceNetManager */
public final class bm {
    tr a = null;

    public bm(Context context) {
        try {
            rf.a().a(context);
        } catch (Throwable th) {
        }
        this.a = tr.a();
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> b = b(context, str2, str3, str4, str5, null, null, null);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> b = b(context, str2, str3, null, str4, str5, str6, str7);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> b = b(context, str2, null, null, null, null, null, null);
        b.put("extensions", "all");
        return a(context, str, b);
    }

    private String a(Context context, String str, Map<String, String> map) {
        byte[] bArr;
        try {
            HashMap hashMap = new HashMap(16);
            vo voVar = new vo();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.5.0");
            String a2 = rb.a();
            String a3 = rb.a(context, a2, rk.b(map));
            map.put("ts", a2);
            map.put("scode", a3);
            voVar.b(map);
            voVar.a(hashMap);
            voVar.a(str);
            voVar.setProxy(rh.a(context));
            voVar.setConnectionTimeout(vu.f);
            voVar.setSoTimeout(vu.f);
            try {
                if (wc.j(context)) {
                    voVar.a(str.replace("http:", "https:"));
                    tr trVar = this.a;
                    bArr = tr.a(voVar);
                } else {
                    bArr = this.a.b(voVar);
                }
                return new String(bArr, "utf-8");
            } catch (Throwable th) {
                vu.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static Map<String, String> b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", qy.f(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }
}
