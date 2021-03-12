package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import org.json.JSONObject;

/* compiled from: MapLocationModel */
public final class wl extends Inner_3dMap_location {
    boolean a = true;
    private String b = null;
    private String c = "";
    private int d;
    private String e = "";
    private String f = "new";
    private JSONObject g = null;
    private String h = "";
    private String i = "";
    private long j = 0;
    private String k = null;

    public wl(String str) {
        super(str);
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int c() {
        return this.d;
    }

    public final void c(String str) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (getProvider().equals(GeocodeSearch.GPS)) {
                this.d = 0;
                return;
            } else if (str.equals("0")) {
                this.d = 0;
                return;
            } else if (str.equals("1")) {
                i2 = 1;
                this.d = i2;
            }
        }
        i2 = -1;
        this.d = i2;
    }

    public final String d() {
        return this.e;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final JSONObject e() {
        return this.g;
    }

    public final void e(String str) {
        this.desc = str;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                wy.a(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            switch (i2) {
                case 1:
                    json.put("retype", this.e);
                    json.put("cens", this.i);
                    json.put("poiid", this.buildingId);
                    json.put("floor", this.floor);
                    json.put("coord", this.d);
                    json.put("mcell", this.h);
                    json.put("desc", this.desc);
                    json.put("address", getAddress());
                    if (this.g != null && xb.a(json, "offpct")) {
                        json.put("offpct", this.g.getString("offpct"));
                        break;
                    }
                case 2:
                case 3:
                    break;
                default:
                    return json;
            }
            json.put("type", this.f);
            json.put("isReversegeo", this.a);
            return json;
        } catch (Throwable th) {
            wy.a(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson(i2);
            jSONObject.put("nb", this.k);
        } catch (Throwable th) {
            wy.a(th, "MapLocationModel", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
