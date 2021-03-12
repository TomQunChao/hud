package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TraceHandlerAbstract */
public final class pj extends ph<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> h;
    private Handler i = null;
    private int j = 0;
    private int k = 0;
    private String l;

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.pg
    public final /* synthetic */ Object a(String str) throws pf {
        return b(str);
    }

    public pj(Context context, Handler handler, List<TraceLocation> list, String str, int i2, int i3) {
        super(context, list);
        this.h = list;
        this.i = handler;
        this.k = i2;
        this.j = i3;
        this.l = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ph
    public final String d() {
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            TraceLocation traceLocation = this.h.get(i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i2 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                    j2 = time;
                } else {
                    if (time != 0) {
                        long j3 = time - j2;
                        if (j3 >= 1000) {
                            jSONObject.put("tm", j3 / 1000);
                            j2 = time;
                        }
                    }
                    jSONObject.put("tm", 1);
                    j2 = time;
                }
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.g = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    private static List<LatLng> b(String str) throws pf {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null) {
                if (optJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void run() {
        new ArrayList();
        try {
            pl.a().a(this.l, this.j, (List) a());
            pl.a().a(this.l).a(this.i);
        } catch (pf e) {
            pl.a();
            pl.a(this.i, this.k, e.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        String str = "key=" + qy.f(this.f);
        String a = rb.a();
        return "http://restapi.amap.com/v4/grasproad/driving?" + str + ("&ts=" + a) + ("&scode=" + rb.a(this.f, a, str));
    }
}
