package com.amap.api.col.stln3;

import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;

/* compiled from: EngineStyleKeyItem */
public final class gv {
    int a;
    int[] b;
    int c;
    int d;
    String e;
    String f;
    String g;

    public gv(int i, int[] iArr, String str, String str2, String str3) {
        this.a = i;
        this.b = iArr;
        this.e = str;
        this.f = str2;
        this.g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.c = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        if ("regions".equals(str)) {
            this.c = 1001;
        } else if ("water".equals(str)) {
            this.c = 1002;
        } else if ("buildings".equals(str)) {
            this.c = 1003;
        } else if ("roads".equals(str)) {
            this.c = 1004;
        } else if ("labels".equals(str)) {
            this.c = AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT;
        } else if ("borders".equals(str)) {
            this.c = 1006;
        }
        this.d = (i * 1000) + iArr.hashCode();
    }
}
