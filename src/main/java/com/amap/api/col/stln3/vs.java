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
public final class vs {
    public static String J = null;
    public static String L = null;
    public String A = null;
    public String B = null;
    public ArrayList<vf> C = new ArrayList<>();
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

    /* JADX WARNING: Removed duplicated region for block: B:287:0x06ba  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x06bf  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0743  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0749  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0804 A[Catch:{ Throwable -> 0x081b }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0809 A[Catch:{ Throwable -> 0x081b }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x080e A[Catch:{ Throwable -> 0x081b }] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x082e A[Catch:{ Throwable -> 0x0856 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0841 A[SYNTHETIC, Splitter:B:354:0x0841] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x087a  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x087c  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x088a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
        // Method dump skipped, instructions count: 2249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vs.a():byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[Catch:{ Throwable -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vs.a(java.lang.String):byte[]");
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

    public final void a(Context context, boolean z2, boolean z3, vg vgVar, vi viVar, ConnectivityManager connectivityManager, String str, String str2) {
        String str3;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ArrayList<ScanResult> arrayList;
        int i2;
        String f2 = qy.f(context);
        int f3 = wc.f();
        this.K = str2;
        String str10 = "api_serverSDK_130905";
        String str11 = "S128DF1572465B890OE3F7A13167KLEI";
        if (!z3) {
            str10 = "UC_nlp_20131029";
            str11 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int e2 = vgVar.e();
        int f4 = vgVar.f();
        TelephonyManager g2 = vgVar.g();
        ArrayList<vf> a2 = vgVar.a();
        String str12 = "";
        ArrayList<vf> b2 = vgVar.b();
        ArrayList<ScanResult> c2 = viVar.c();
        if (f4 == 2) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        if (g2 != null) {
            if (TextUtils.isEmpty(vu.d)) {
                try {
                    vu.d = rd.v(context);
                    str4 = "0";
                } catch (Throwable th) {
                    str4 = "0";
                    vu.a(th, "Aps", "getApsReq part4");
                }
            } else {
                str4 = "0";
            }
            if (TextUtils.isEmpty(vu.d)) {
                vu.d = "888888888888888";
            }
            if (TextUtils.isEmpty(vu.e)) {
                try {
                    vu.e = g2.getSubscriberId();
                } catch (SecurityException e3) {
                } catch (Throwable th2) {
                    vu.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(vu.e)) {
                vu.e = "888888888888888";
            }
        } else {
            str4 = "0";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            vu.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        WifiInfo h2 = viVar.h();
        boolean a3 = vi.a(h2);
        if (wc.a(networkInfo) != -1) {
            str6 = wc.b(g2);
            if (!a3 || !viVar.g()) {
                str5 = "1";
            } else {
                str5 = "2";
            }
        } else {
            str6 = "";
            str5 = "";
        }
        if (!a2.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            switch (f4) {
                case 1:
                    str8 = str6;
                    vf vfVar = a2.get(0);
                    str7 = "0";
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(vfVar.a);
                    sb3.append("</mcc>");
                    sb3.append("<mnc>");
                    sb3.append(vfVar.b);
                    sb3.append("</mnc>");
                    sb3.append("<lac>");
                    sb3.append(vfVar.c);
                    sb3.append("</lac>");
                    sb3.append("<cellid>");
                    sb3.append(vfVar.d);
                    sb3.append("</cellid>");
                    sb3.append("<signal>");
                    sb3.append(vfVar.j);
                    sb3.append("</signal>");
                    String sb4 = sb3.toString();
                    int i3 = 1;
                    while (i3 < a2.size()) {
                        vf vfVar2 = a2.get(i3);
                        sb.append(vfVar2.c);
                        sb.append(",");
                        sb.append(vfVar2.d);
                        sb.append(",");
                        sb.append(vfVar2.j);
                        if (i3 < a2.size() - 1) {
                            sb.append("*");
                        }
                        i3++;
                        sb4 = sb4;
                    }
                    str12 = sb4;
                    break;
                case 2:
                    vf vfVar3 = a2.get(0);
                    str8 = str6;
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(vfVar3.a);
                    sb3.append("</mcc>");
                    sb3.append("<sid>");
                    sb3.append(vfVar3.g);
                    sb3.append("</sid>");
                    sb3.append("<nid>");
                    sb3.append(vfVar3.h);
                    sb3.append("</nid>");
                    sb3.append("<bid>");
                    sb3.append(vfVar3.i);
                    sb3.append("</bid>");
                    if (vfVar3.f > 0 && vfVar3.e > 0) {
                        sb3.append("<lon>");
                        sb3.append(vfVar3.f);
                        sb3.append("</lon>");
                        sb3.append("<lat>");
                        sb3.append(vfVar3.e);
                        sb3.append("</lat>");
                    }
                    sb3.append("<signal>");
                    sb3.append(vfVar3.j);
                    sb3.append("</signal>");
                    str7 = "0";
                    str12 = sb3.toString();
                    break;
                default:
                    str7 = "0";
                    str8 = str6;
                    break;
            }
            sb3.delete(0, sb3.length());
            str9 = str12;
        } else {
            str7 = "0";
            str8 = str6;
            str9 = str12;
        }
        if ((e2 & 4) != 4 || b2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(b2);
        }
        if (viVar.g()) {
            if (a3) {
                sb2.append(viVar.h().getBSSID());
                sb2.append(",");
                int rssi = viVar.h().getRssi();
                if (rssi < -128) {
                    rssi = 0;
                } else if (rssi > 127) {
                    rssi = 0;
                }
                sb2.append(rssi);
                sb2.append(",");
                String ssid = h2.getSSID();
                try {
                    i2 = h2.getSSID().getBytes("UTF-8").length;
                } catch (Exception e4) {
                    i2 = 32;
                }
                if (i2 >= 32) {
                    ssid = "unkwn";
                }
                sb2.append(ssid.replace("*", "."));
            }
            if (!(c2 == null || (arrayList = this.F) == null)) {
                arrayList.clear();
                this.F.addAll(c2);
            }
        } else {
            viVar.d();
            ArrayList<ScanResult> arrayList2 = this.F;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        if (!z2) {
            this.b = 2;
        } else {
            this.b = 0;
        }
        this.c = str10;
        this.d = str11;
        this.f = wc.d();
        this.g = "android" + wc.e();
        this.h = wc.b(context);
        this.i = str3;
        this.j = "0";
        this.k = "0";
        this.l = str7;
        this.m = "0";
        this.n = str4;
        this.o = f2;
        this.p = vu.d;
        this.q = vu.e;
        this.s = String.valueOf(f3);
        this.t = wc.i(context);
        this.v = "4.5.0";
        this.w = str;
        this.u = "";
        this.x = str8;
        this.y = str5;
        this.z = e2;
        this.A = str9;
        this.B = sb.toString();
        this.D = vgVar.k();
        this.G = vi.l();
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
}
