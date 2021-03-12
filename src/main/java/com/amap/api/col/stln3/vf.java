package com.amap.api.col.stln3;

import android.support.v4.os.EnvironmentCompat;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: Cgi */
public final class vf {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = -113;
    public int k = 0;
    public short l = 0;
    public long m = 0;
    public boolean n = false;
    public boolean o = true;

    public vf(int i2, boolean z) {
        this.k = i2;
        this.n = z;
    }

    public final String toString() {
        switch (this.k) {
            case 1:
                return String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
            case 2:
                return String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
            case 3:
                return String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
            case 4:
                return String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n));
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof vf)) {
            return false;
        }
        vf vfVar = (vf) obj;
        switch (vfVar.k) {
            case 1:
                if (this.k == 1 && vfVar.c == this.c && vfVar.d == this.d && vfVar.b == this.b) {
                    return true;
                }
                return false;
            case 2:
                if (this.k == 2 && vfVar.i == this.i && vfVar.h == this.h && vfVar.g == this.g) {
                    return true;
                }
                return false;
            case 3:
                if (this.k == 3 && vfVar.c == this.c && vfVar.d == this.d && vfVar.b == this.b) {
                    return true;
                }
                return false;
            case 4:
                if (this.k == 4 && vfVar.c == this.c && vfVar.d == this.d && vfVar.b == this.b) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final int hashCode() {
        int hashCode = String.valueOf(this.k).hashCode();
        if (this.k == 2) {
            return hashCode + String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode() + String.valueOf(this.g).hashCode();
        }
        return hashCode + String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode() + String.valueOf(this.b).hashCode();
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.k);
            jSONObject.put("registered", this.n);
            jSONObject.put("mcc", this.a);
            jSONObject.put("mnc", this.b);
            jSONObject.put("lac", this.c);
            jSONObject.put("cid", this.d);
            jSONObject.put("sid", this.g);
            jSONObject.put("nid", this.h);
            jSONObject.put("bid", this.i);
            jSONObject.put("sig", this.j);
        } catch (Throwable th) {
            vu.a(th, "cgi", "toJson");
        }
        return jSONObject;
    }
}
