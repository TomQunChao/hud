package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ParamMapUtil */
public final class qe {
    private HashMap<String, String> a = new HashMap<>();

    public final qe a(String str, String str2) {
        return a(str, str2, true);
    }

    public final qe a(String str, String str2, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return this;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.a.put(str, str2);
        return this;
    }

    public final qe a(String str, int i) {
        return a(str, i, true);
    }

    public final qe a(String str, int i, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return this;
        }
        HashMap<String, String> hashMap = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        hashMap.put(str, sb.toString());
        return this;
    }

    public final qe a(String str, long j) {
        return a(str, j, true);
    }

    public final qe a(String str, long j, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return this;
        }
        HashMap<String, String> hashMap = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        hashMap.put(str, sb.toString());
        return this;
    }

    public final HashMap<String, String> a() {
        return this.a;
    }
}
