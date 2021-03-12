package com.amap.api.col.stln3;

import android.content.Context;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.ae.route.model.POIInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: Ae8Utils */
public final class iv {
    private static String a = "http://restapi.amap.com";

    public static POIInfo[] a(List<NaviLatLng> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        POIInfo[] pOIInfoArr = new POIInfo[list.size()];
        for (int i = 0; i < list.size(); i++) {
            NaviLatLng naviLatLng = list.get(i);
            POIInfo pOIInfo = new POIInfo();
            pOIInfo.naviLat = naviLatLng.getLatitude();
            pOIInfo.naviLon = naviLatLng.getLongitude();
            pOIInfo.latitude = naviLatLng.getLatitude();
            pOIInfo.longitude = naviLatLng.getLongitude();
            pOIInfo.poiLat = naviLatLng.getLatitude();
            pOIInfo.poiLon = naviLatLng.getLongitude();
            pOIInfo.type = 1;
            pOIInfoArr[i] = pOIInfo;
        }
        return pOIInfoArr;
    }

    public static POIInfo[] a(ln lnVar, int i) {
        li liVar;
        POIInfo[] pOIInfoArr = new POIInfo[1];
        if (lnVar.f() != null) {
            liVar = lnVar.f();
        } else if (lnVar.e() != null) {
            liVar = lnVar.e();
        } else {
            liVar = lnVar.d();
        }
        pOIInfoArr[0] = a(lnVar, liVar, i);
        return pOIInfoArr;
    }

    public static POIInfo[] b(ln lnVar, int i) {
        li liVar;
        POIInfo[] pOIInfoArr = new POIInfo[1];
        if (lnVar.e() != null) {
            liVar = lnVar.e();
        } else {
            liVar = lnVar.d();
        }
        pOIInfoArr[0] = a(lnVar, liVar, i);
        return pOIInfoArr;
    }

    public static POIInfo[] b(List<ln> list) {
        li liVar;
        if (list == null || list.size() <= 0) {
            return null;
        }
        POIInfo[] pOIInfoArr = new POIInfo[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ln lnVar = list.get(i);
            if (lnVar != null) {
                if (lnVar.e() != null) {
                    liVar = lnVar.e();
                } else {
                    liVar = lnVar.d();
                }
                if (lnVar.a() != null) {
                    pOIInfoArr[i] = a(lnVar, liVar, 2);
                } else {
                    pOIInfoArr[i] = a(lnVar, liVar, 1);
                }
            }
        }
        return pOIInfoArr;
    }

    private static POIInfo a(ln lnVar, li liVar, int i) {
        POIInfo pOIInfo = new POIInfo();
        if (liVar == null) {
            return null;
        }
        pOIInfo.latitude = liVar.b();
        pOIInfo.longitude = liVar.a();
        pOIInfo.poiLat = lnVar.d().b();
        pOIInfo.poiLon = lnVar.d().a();
        pOIInfo.poiID = lnVar.a();
        pOIInfo.typeCode = lnVar.g();
        pOIInfo.type = i;
        pOIInfo.name = lnVar.b();
        return pOIInfo;
    }

    public static List<NaviLatLng> a(POIInfo[] pOIInfoArr) {
        ArrayList arrayList = new ArrayList();
        if (pOIInfoArr == null || pOIInfoArr.length <= 0) {
            return arrayList;
        }
        for (POIInfo pOIInfo : pOIInfoArr) {
            arrayList.add(new NaviLatLng(pOIInfo.latitude, pOIInfo.longitude));
        }
        return arrayList;
    }

    public static byte[] a(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(2);
            dataOutputStream.writeShort(str.length());
            dataOutputStream.write(str.getBytes("UTF-8"));
            dataOutputStream.writeShort(bArr.length);
            dataOutputStream.write(bArr);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:786)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:130)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:825)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:130)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:696)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:50)
        */
    public static java.lang.String a(int r3) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.iv.a(int):java.lang.String");
    }

    public static ty a(Context context, String str, int i, byte[] bArr) {
        if (i != 102) {
            try {
                String str2 = "request host==" + str;
                if (i == 3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("key", qy.f(context));
                    String a2 = rb.a();
                    String a3 = rb.a(context, a2, rk.b(hashMap));
                    hashMap.put("ts", a2);
                    hashMap.put("scode", a3);
                    jt jtVar = new jt(context, str, bArr, null, hashMap);
                    jtVar.setConnectionTimeout(NetDefine.HTTP_READ_TIMEOUT);
                    jtVar.setSoTimeout(NetDefine.HTTP_READ_TIMEOUT);
                    return jv.a(true, jtVar);
                }
                jw jwVar = new jw(context, str, bArr, null);
                jwVar.setConnectionTimeout(NetDefine.HTTP_READ_TIMEOUT);
                jwVar.setSoTimeout(NetDefine.HTTP_READ_TIMEOUT);
                return jv.a(true, jwVar);
            } catch (qx e) {
                e.printStackTrace();
                rx.a(mj.a(), str.replace(a, ""), e);
                return null;
            }
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Accept-Encoding", "gzip,deflate");
            hashMap2.put("engineurl", "truck_navi");
            hashMap2.put("User-Agent", "AMAP_SDK_Android_NAVI_6.5.0");
            String b = rb.b(context);
            hashMap2.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.5.0", "navi"));
            hashMap2.put("X-INFO", b);
            hashMap2.put("logversion", "2.1");
            hashMap2.put("Content-Type", "text/plain");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("key", qy.f(context));
            String a4 = rb.a();
            String a5 = rb.a(context, a4, rk.b(hashMap3));
            hashMap3.put("ts", a4);
            hashMap3.put("scode", a5);
            jt jtVar2 = new jt(context, str, bArr, hashMap2, hashMap3);
            jtVar2.setConnectionTimeout(NetDefine.HTTP_READ_TIMEOUT);
            jtVar2.setSoTimeout(NetDefine.HTTP_READ_TIMEOUT);
            return jv.a(true, jtVar2);
        }
    }
}
