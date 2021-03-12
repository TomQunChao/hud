package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import org.json.JSONObject;

/* compiled from: AMapLocationServer */
public final class vc extends AMapLocation {
    protected String d = "";
    boolean e = true;
    String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private String g = null;
    private String h = "";
    private int i;
    private String j = "";
    private String k = "new";
    private JSONObject l = null;
    private String m = "";
    private String n = "";
    private long o = 0;
    private String p = null;

    public vc(String str) {
        super(str);
    }

    public final String a() {
        return this.g;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001f
            java.lang.String r0 = "0"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0012
            r2 = 0
            r1.i = r2
            goto L_0x0023
        L_0x0012:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x001e
            r2 = 1
            r1.i = r2
            goto L_0x0023
        L_0x001e:
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            r2 = -1
            r1.i = r2
        L_0x0023:
            int r2 = r1.i
            if (r2 != 0) goto L_0x002d
            java.lang.String r2 = "WGS84"
            super.setCoordType(r2)
            return
        L_0x002d:
            java.lang.String r2 = "GCJ02"
            super.setCoordType(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vc.c(java.lang.String):void");
    }

    public final String d() {
        return this.j;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.k;
    }

    public final void e(String str) {
        this.k = str;
    }

    public final JSONObject f() {
        return this.l;
    }

    public final void a(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public final String g() {
        return this.m;
    }

    public final vc h() {
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return null;
        }
        vc vcVar = new vc("");
        vcVar.setProvider(getProvider());
        vcVar.setLongitude(wc.f(split[0]));
        vcVar.setLatitude(wc.f(split[1]));
        vcVar.setAccuracy(wc.g(split[2]));
        vcVar.setCityCode(getCityCode());
        vcVar.setAdCode(getAdCode());
        vcVar.setCountry(getCountry());
        vcVar.setProvince(getProvince());
        vcVar.setCity(getCity());
        vcVar.setTime(getTime());
        vcVar.k = this.k;
        vcVar.c(String.valueOf(this.i));
        if (!wc.a(vcVar)) {
            return null;
        }
        return vcVar;
    }

    public final boolean i() {
        return this.e;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String j() {
        return this.f;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final long k() {
        return this.o;
    }

    public final void a(long j2) {
        this.o = j2;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            switch (i2) {
                case 1:
                    json.put("retype", this.j);
                    json.put("cens", this.n);
                    json.put("coord", this.i);
                    json.put("mcell", this.m);
                    json.put("desc", this.d);
                    json.put("address", getAddress());
                    if (this.l != null) {
                        if (!wc.a(json, "offpct")) {
                            break;
                        } else {
                            json.put("offpct", this.l.getString("offpct"));
                            break;
                        }
                    }
                    break;
                case 2:
                case 3:
                    break;
                default:
                    return json;
            }
            json.put("type", this.k);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (Throwable th) {
            vu.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                vu.a(this, jSONObject);
                this.k = jSONObject.optString("type", this.k);
                this.j = jSONObject.optString("retype", this.j);
                String optString = jSONObject.optString("cens", this.n);
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split("\\*");
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String str = split[i2];
                        if (!TextUtils.isEmpty(str)) {
                            String[] split2 = str.split(",");
                            setLongitude(wc.f(split2[0]));
                            setLatitude(wc.f(split2[1]));
                            setAccuracy((float) wc.h(split2[2]));
                            break;
                        }
                        i2++;
                    }
                    this.n = optString;
                }
                this.d = jSONObject.optString("desc", this.d);
                c(jSONObject.optString("coord", String.valueOf(this.i)));
                this.m = jSONObject.optString("mcell", this.m);
                this.e = jSONObject.optBoolean("isReversegeo", this.e);
                this.f = jSONObject.optString("geoLanguage", this.f);
                if (wc.a(jSONObject, "poiid")) {
                    setBuildingId(jSONObject.optString("poiid"));
                }
                if (wc.a(jSONObject, "pid")) {
                    setBuildingId(jSONObject.optString("pid"));
                }
                if (wc.a(jSONObject, "floor")) {
                    setFloor(jSONObject.optString("floor"));
                }
                if (wc.a(jSONObject, "flr")) {
                    setFloor(jSONObject.optString("flr"));
                }
            } catch (Throwable th) {
                vu.a(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    public final void g(String str) {
        this.d = str;
    }

    public final String l() {
        return this.p;
    }

    public final void h(String str) {
        this.p = str;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
            jSONObject.put("nb", this.p);
        } catch (Throwable th) {
            vu.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
