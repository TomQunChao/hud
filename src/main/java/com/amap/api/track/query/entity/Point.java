package com.amap.api.track.query.entity;

import com.amap.api.col.stln3.qd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class Point {
    private double a;
    private double b;
    private long c;
    private float d;
    private float e;
    private double f;
    private double g;

    public final double getLat() {
        return this.a;
    }

    public final void setLat(double d2) {
        this.a = d2;
    }

    public final double getLng() {
        return this.b;
    }

    public final void setLng(double d2) {
        this.b = d2;
    }

    public final long getTime() {
        return this.c;
    }

    public final void setTime(long j) {
        this.c = j;
    }

    public final float getAccuracy() {
        return this.d;
    }

    public final void setAccuracy(float f2) {
        this.d = f2;
    }

    public final float getDirection() {
        return this.e;
    }

    public final void setDirection(float f2) {
        this.e = f2;
    }

    public final double getHeight() {
        return this.f;
    }

    public final double getSpeed() {
        return this.g;
    }

    public final void setSpeed(double d2) {
        this.g = d2;
    }

    public final void setHeight(double d2) {
        this.f = d2;
    }

    public static ArrayList<Point> createLocs(List<String> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(createLoc(list.get(i)));
        }
        return arrayList;
    }

    public static ArrayList<Point> createLocs(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(createLoc(jSONArray.getString(i)));
            } catch (JSONException e2) {
            }
        }
        return arrayList;
    }

    public static Point createLoc(String str) {
        qd a2 = new qd().a(str);
        return createLoc(a2.c("location"), a2.c("locatetime"), a2.c("accuracy"), a2.c("direction"), a2.c("height"), a2.c("speed"), a2.f("props"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.track.query.entity.Point createLoc(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            com.amap.api.track.query.entity.Point r8 = new com.amap.api.track.query.entity.Point
            r8.<init>()
            long r0 = com.amap.api.col.stln3.qs.a(r3)
            r8.c = r0
            float r3 = com.amap.api.col.stln3.qs.d(r4)
            r8.d = r3
            float r3 = com.amap.api.col.stln3.qs.d(r5)
            r8.e = r3
            double r3 = com.amap.api.col.stln3.qs.b(r6)
            r8.f = r3
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 2
            r5 = 0
            if (r3 == 0) goto L_0x0028
        L_0x0026:
            r0 = r5
            goto L_0x0039
        L_0x0028:
            java.lang.String r3 = ","
            java.lang.String[] r3 = r2.split(r3)
            int r0 = r3.length
            if (r0 == r4) goto L_0x0032
            goto L_0x0026
        L_0x0032:
            r0 = 1
            r3 = r3[r0]
            double r0 = com.amap.api.col.stln3.qs.b(r3)
        L_0x0039:
            r8.a = r0
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x0042
        L_0x0041:
            goto L_0x0053
        L_0x0042:
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            if (r3 == r4) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r3 = 0
            r2 = r2[r3]
            double r5 = com.amap.api.col.stln3.qs.b(r2)
        L_0x0053:
            r8.b = r5
            double r2 = com.amap.api.col.stln3.qs.b(r7)
            r8.g = r2
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.track.query.entity.Point.createLoc(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.amap.api.track.query.entity.Point");
    }
}
