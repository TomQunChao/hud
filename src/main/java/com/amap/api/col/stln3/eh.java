package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.qz;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineUpdateCityHandlerAbstract */
public final class eh extends ey<String, List<OfflineMapProvince>> {
    private Context d;

    public eh(Context context, String str) {
        super(context, str);
    }

    public final void a(Context context) {
        this.d = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.d != null) {
                ex.b(jSONObject.toString(), this.d);
            }
        } catch (Throwable th) {
            rx.c(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            if (this.d != null) {
                return ex.a(jSONObject, this.d);
            }
            return null;
        } catch (JSONException e) {
            rx.c(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final JSONObject a(qz.a aVar) {
        if (aVar == null || aVar.w == null) {
            return null;
        }
        JSONObject optJSONObject = aVar.w.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final String a() {
        return "015";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }
}
