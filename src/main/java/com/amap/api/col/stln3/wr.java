package com.amap.api.col.stln3;

import android.support.v4.os.EnvironmentCompat;
import java.util.Locale;

/* compiled from: Cgi */
public final class wr {
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

    public wr(int i2, boolean z) {
        this.k = i2;
        this.n = z;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof wr)) {
            wr wrVar = (wr) obj;
            switch (wrVar.k) {
                case 1:
                    if (this.k == 1 && wrVar.c == this.c && wrVar.d == this.d && wrVar.b == this.b) {
                        return true;
                    }
                    break;
                case 2:
                    return this.k == 2 && wrVar.i == this.i && wrVar.h == this.h && wrVar.g == this.g;
                case 3:
                    return this.k == 3 && wrVar.c == this.c && wrVar.d == this.d && wrVar.b == this.b;
                case 4:
                    return this.k == 4 && wrVar.c == this.c && wrVar.d == this.d && wrVar.b == this.b;
                default:
                    return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int hashCode = String.valueOf(this.k).hashCode();
        if (this.k == 2) {
            i3 = String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode();
            i2 = this.g;
        } else {
            i3 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
            i2 = this.b;
        }
        return hashCode + i3 + String.valueOf(i2).hashCode();
    }

    public final String toString() {
        Object[] objArr;
        String str;
        Locale locale;
        switch (this.k) {
            case 1:
                locale = Locale.CHINA;
                str = "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 2:
                locale = Locale.CHINA;
                str = "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 3:
                locale = Locale.CHINA;
                str = "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 4:
                locale = Locale.CHINA;
                str = "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return String.format(locale, str, objArr);
    }
}
