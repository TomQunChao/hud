package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.List;

/* compiled from: LocDataEntity */
public final class pt {
    private AMapLocation a;
    private long b;
    private long c;
    private long d;
    private String e;
    private long f;
    private String g;

    private pt() {
        this(null, -1, -1, -1, "", System.currentTimeMillis());
    }

    public pt(AMapLocation aMapLocation, long j, long j2, long j3, String str, long j4) {
        this.b = j;
        this.c = j2;
        this.f = j3;
        this.g = str;
        this.a = aMapLocation;
        this.d = j4;
        this.e = "";
        if (this.f < 0) {
            this.f = -1;
        }
    }

    public final long a() {
        return this.d;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.f;
    }

    public final String e() {
        String str;
        return (this.f <= 0 && (str = this.g) != null) ? str : "";
    }

    private static pt a(Context context, String str) {
        pt ptVar;
        String str2;
        pt ptVar2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        pt ptVar3 = new pt();
        String b2 = ql.b(context, str);
        AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
        try {
            String[] split = b2.split("#");
            long parseLong = Long.parseLong(split[0]);
            long parseLong2 = Long.parseLong(split[1]);
            long parseLong3 = Long.parseLong(split[2]);
            String str3 = split[3];
            long parseLong4 = Long.parseLong(split[4]);
            String str4 = split[5];
            ptVar2 = ptVar3;
            str2 = b2;
            try {
                aMapLocation.setLatitude(Double.parseDouble(split[6]));
                aMapLocation.setLongitude(Double.parseDouble(split[7]));
                aMapLocation.setAccuracy(Float.parseFloat(split[8]));
                aMapLocation.setAltitude(Double.parseDouble(split[9]));
                aMapLocation.setBearing(Float.parseFloat(split[10]));
                aMapLocation.setGpsAccuracyStatus(Integer.parseInt(split[11]));
                aMapLocation.setProvider(split[12]);
                aMapLocation.setLocationType(Integer.parseInt(split[13]));
                aMapLocation.setErrorCode(Integer.parseInt(split[14]));
                aMapLocation.setErrorInfo(split[15]);
                ptVar = new pt(aMapLocation, parseLong, parseLong2, parseLong3, str3, parseLong4);
                try {
                    ptVar.e = str4;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                ptVar = ptVar2;
                qr.b("create LocDataEntity exception " + str2);
                return ptVar;
            }
        } catch (Exception e4) {
            ptVar2 = ptVar3;
            str2 = b2;
            ptVar = ptVar2;
            qr.b("create LocDataEntity exception " + str2);
            return ptVar;
        }
        return ptVar;
    }

    public static pt a(Context context, String str, long j) {
        pt a2 = a(context, str);
        if (a2 == null) {
            return null;
        }
        a2.d = j;
        return a2;
    }

    public final String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append("#");
        stringBuffer.append(this.c);
        stringBuffer.append("#");
        stringBuffer.append(this.f);
        stringBuffer.append("#");
        stringBuffer.append(this.g);
        stringBuffer.append("#");
        stringBuffer.append(this.d);
        stringBuffer.append("#");
        stringBuffer.append(this.e);
        stringBuffer.append("#");
        try {
            stringBuffer.append(this.a.getLatitude());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getLongitude());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getAccuracy());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getAltitude());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getBearing());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getGpsAccuracyStatus());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getProvider());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getLocationType());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getErrorCode());
            stringBuffer.append("#");
            stringBuffer.append(this.a.getErrorInfo());
            stringBuffer.append("#");
        } catch (Exception e2) {
            qr.b("getLocalStr exception " + this.a);
        }
        return ql.a(context, stringBuffer.toString());
    }

    private String g() {
        try {
            qo a2 = new qo().a();
            qo b2 = a2.b("location", qm.a(this.a.getLongitude()) + "," + qm.a(this.a.getLatitude()));
            StringBuilder sb = new StringBuilder();
            sb.append(this.d);
            qo b3 = b2.b("locatetime", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.a.getSpeed());
            qo b4 = b3.b("speed", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.a.getBearing());
            qo b5 = b4.b("direction", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.a.getAltitude());
            qo b6 = b5.b("height", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.a.getAccuracy());
            return b6.b("accuracy", sb5.toString()).a("props", this.e).b();
        } catch (Exception e2) {
            return "";
        }
    }

    public static String a(List<pt> list) {
        if (list == null) {
            return "";
        }
        qn qnVar = new qn();
        qnVar.a();
        for (pt ptVar : list) {
            qnVar.a(ptVar.g());
        }
        return qnVar.b();
    }

    public final boolean f() {
        boolean z = true;
        boolean z2 = (this.c > 0) & (this.b > 0);
        if (this.a == null) {
            z = false;
        }
        return z2 & z;
    }
}
