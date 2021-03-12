package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: Req */
public final class wx {
    public static String J = null;
    public static String L = null;
    public String A = null;
    public String B = null;
    public ArrayList<wr> C = new ArrayList<>();
    public String D = null;
    public String E = null;
    public ArrayList<ScanResult> F = new ArrayList<>();
    public String G = null;
    public String H = null;
    public byte[] I = null;
    public String K = null;
    public String M = null;
    private byte[] N = null;
    private int O = 0;
    public String a = "1";
    public short b = 0;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;
    public int z = 0;

    private String a(String str, int i2) {
        String[] split = this.B.split("\\*")[i2].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L_0x000f
            int r4 = r0.length     // Catch:{ Throwable -> 0x003f }
            if (r4 == r1) goto L_0x001c
        L_0x000f:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ Throwable -> 0x003f }
            r1 = 0
        L_0x0012:
            int r4 = r0.length     // Catch:{ Throwable -> 0x003f }
            if (r1 >= r4) goto L_0x001c
            java.lang.String r4 = "0"
            r0[r1] = r4     // Catch:{ Throwable -> 0x003f }
            int r1 = r1 + 1
            goto L_0x0012
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r4 = r0.length     // Catch:{ Throwable -> 0x003f }
            if (r1 >= r4) goto L_0x0059
            r4 = r0[r1]     // Catch:{ Throwable -> 0x003f }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x003f }
            r5 = 2
            if (r4 <= r5) goto L_0x0031
            r4 = r0[r1]     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = r4.substring(r3, r5)     // Catch:{ Throwable -> 0x003f }
            r0[r1] = r4     // Catch:{ Throwable -> 0x003f }
        L_0x0031:
            r4 = r0[r1]     // Catch:{ Throwable -> 0x003f }
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch:{ Throwable -> 0x003f }
            byte r4 = (byte) r4     // Catch:{ Throwable -> 0x003f }
            r2[r1] = r4     // Catch:{ Throwable -> 0x003f }
            int r1 = r1 + 1
            goto L_0x001d
        L_0x003f:
            r0 = move-exception
            java.lang.String r1 = "Req"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "getMacBa "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.amap.api.col.stln3.wy.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L_0x0059:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wx.a(java.lang.String):byte[]");
    }

    private String b(String str) {
        String str2 = this.A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + ">");
        String str4 = this.A;
        return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    public final void a(Context context, boolean z2, boolean z3, ws wsVar, wt wtVar, ConnectivityManager connectivityManager, String str) {
        String str2;
        NetworkInfo networkInfo;
        String str3;
        String str4;
        String str5;
        String str6;
        ArrayList<ScanResult> arrayList;
        int i2;
        String f2 = qy.f(context);
        int f3 = xb.f();
        this.K = str;
        String str7 = "api_serverSDK_130905";
        String str8 = "S128DF1572465B890OE3F7A13167KLEI";
        if (!z3) {
            str7 = "UC_nlp_20131029";
            str8 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i3 = wsVar.a;
        int i4 = wsVar.a & 3;
        TelephonyManager telephonyManager = wsVar.c;
        ArrayList<wr> arrayList2 = wsVar.b;
        ArrayList<wr> a2 = wsVar.a();
        ArrayList<ScanResult> a3 = wtVar.a();
        String str9 = i4 == 2 ? "1" : "0";
        if (telephonyManager != null) {
            if (TextUtils.isEmpty(wy.d)) {
                try {
                    wy.d = rd.v(context);
                } catch (Throwable th) {
                    str2 = "0";
                    wy.a(th, "Aps", "getApsReq part4");
                }
            }
            str2 = "0";
            if (TextUtils.isEmpty(wy.d)) {
                wy.d = "888888888888888";
            }
            if (TextUtils.isEmpty(wy.e)) {
                try {
                    wy.e = telephonyManager.getSubscriberId();
                } catch (SecurityException e2) {
                } catch (Throwable th2) {
                    wy.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(wy.e)) {
                wy.e = "888888888888888";
            }
        } else {
            str2 = "0";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            wy.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        WifiInfo f4 = wtVar.f();
        boolean a4 = wt.a(f4);
        if (xb.a(networkInfo) != -1) {
            String b2 = xb.b(telephonyManager);
            str3 = (!a4 || !wtVar.e()) ? "1" : "2";
            str4 = b2;
        } else {
            str4 = "";
            str3 = "";
        }
        if (!arrayList2.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            switch (i4) {
                case 1:
                    wr wrVar = arrayList2.get(0);
                    str5 = str4;
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(wrVar.a);
                    sb3.append("</mcc>");
                    sb3.append("<mnc>");
                    sb3.append(wrVar.b);
                    sb3.append("</mnc>");
                    sb3.append("<lac>");
                    sb3.append(wrVar.c);
                    sb3.append("</lac>");
                    sb3.append("<cellid>");
                    sb3.append(wrVar.d);
                    sb3.append("</cellid>");
                    sb3.append("<signal>");
                    sb3.append(wrVar.j);
                    sb3.append("</signal>");
                    String sb4 = sb3.toString();
                    int i5 = 1;
                    while (i5 < arrayList2.size()) {
                        wr wrVar2 = arrayList2.get(i5);
                        sb.append(wrVar2.c);
                        sb.append(",");
                        sb.append(wrVar2.d);
                        sb.append(",");
                        sb.append(wrVar2.j);
                        if (i5 < arrayList2.size() - 1) {
                            sb.append("*");
                        }
                        i5++;
                        sb4 = sb4;
                    }
                    str6 = sb4;
                    break;
                case 2:
                    wr wrVar3 = arrayList2.get(0);
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(wrVar3.a);
                    sb3.append("</mcc>");
                    sb3.append("<sid>");
                    sb3.append(wrVar3.g);
                    sb3.append("</sid>");
                    sb3.append("<nid>");
                    sb3.append(wrVar3.h);
                    sb3.append("</nid>");
                    sb3.append("<bid>");
                    sb3.append(wrVar3.i);
                    sb3.append("</bid>");
                    if (wrVar3.f > 0 && wrVar3.e > 0) {
                        sb3.append("<lon>");
                        sb3.append(wrVar3.f);
                        sb3.append("</lon>");
                        sb3.append("<lat>");
                        sb3.append(wrVar3.e);
                        sb3.append("</lat>");
                    }
                    sb3.append("<signal>");
                    sb3.append(wrVar3.j);
                    sb3.append("</signal>");
                    str5 = str4;
                    str6 = sb3.toString();
                    break;
                default:
                    str5 = str4;
                    str6 = "";
                    break;
            }
            sb3.delete(0, sb3.length());
        } else {
            str5 = str4;
            str6 = "";
        }
        if ((i3 & 4) != 4 || a2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(a2);
        }
        if (wtVar.e()) {
            if (a4) {
                sb2.append(wtVar.f().getBSSID());
                sb2.append(",");
                int rssi = wtVar.f().getRssi();
                if (rssi < -128 || rssi > 127) {
                    rssi = 0;
                }
                sb2.append(rssi);
                sb2.append(",");
                String ssid = f4.getSSID();
                try {
                    i2 = f4.getSSID().getBytes("UTF-8").length;
                } catch (Exception e3) {
                    i2 = 32;
                }
                if (i2 >= 32) {
                    ssid = "unkwn";
                }
                sb2.append(ssid.replace("*", "."));
            }
            if (!(a3 == null || (arrayList = this.F) == null)) {
                arrayList.clear();
                this.F.addAll(a3);
            }
        } else {
            wtVar.b();
            ArrayList<ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = !z2 ? (short) 2 : 0;
        this.c = str7;
        this.d = str8;
        this.f = xb.d();
        this.g = "android" + xb.e();
        this.h = xb.b(context);
        this.i = str9;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = str2;
        this.n = "0";
        this.o = f2;
        this.p = wy.d;
        this.q = wy.e;
        this.s = String.valueOf(f3);
        this.t = xb.d(context);
        this.v = "4.2.0";
        this.w = null;
        this.u = "";
        this.x = str5;
        this.y = str3;
        this.z = i3;
        this.A = str6;
        this.B = sb.toString();
        this.D = wsVar.e();
        this.G = wt.i();
        this.E = sb2.toString();
        try {
            if (TextUtils.isEmpty(J)) {
                J = rd.h(context);
            }
        } catch (Throwable th4) {
        }
        try {
            if (TextUtils.isEmpty(L)) {
                L = rd.b(context);
            }
        } catch (Throwable th5) {
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    /* JADX WARNING: Removed duplicated region for block: B:194:0x03ab A[Catch:{ Throwable -> 0x03c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03ae A[Catch:{ Throwable -> 0x03c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03d6 A[Catch:{ Throwable -> 0x03ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03d9 A[Catch:{ Throwable -> 0x03ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x057e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0673  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0678  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x06f9  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x06fe  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x07b0 A[Catch:{ Throwable -> 0x07c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x07b3 A[Catch:{ Throwable -> 0x07c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x07b7 A[Catch:{ Throwable -> 0x07c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x07d7 A[Catch:{ Throwable -> 0x07fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x07e8 A[SYNTHETIC, Splitter:B:356:0x07e8] */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x081c  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x081e  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x082c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
        // Method dump skipped, instructions count: 2153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wx.a():byte[]");
    }
}
