package com.amap.api.col.stln3;

import android.net.Uri;
import android.util.SparseArray;
import com.amap.api.track.query.entity.ProtocolType;

/* compiled from: WebConfig */
public final class qg {
    public static SparseArray<String> a = null;

    public static String a(int i, int i2) {
        SparseArray<String> sparseArray = a;
        if (sparseArray == null || sparseArray.size() == 0) {
            SparseArray<String> sparseArray2 = new SparseArray<>();
            a = sparseArray2;
            sparseArray2.put(101, "terminal/add");
            a.put(201, "terminal/lastpoint");
            a.put(202, "terminal/distance");
            a.put(203, "terminal/points");
            a.put(301, "point/upload");
            a.put(302, "trace/add");
            a.put(304, "terminal/list");
            a.put(306, "terminal/trsearch");
        }
        Uri build = new Uri.Builder().scheme(ProtocolType.isHttps(i) ? "https" : "http").authority("tsapi.amap.com").appendEncodedPath("v1/track/").appendEncodedPath(a.get(i2)).build();
        if (build == null || build.toString() == null) {
            return "";
        }
        return build.toString();
    }
}
