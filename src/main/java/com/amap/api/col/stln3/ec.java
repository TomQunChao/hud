package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.qz;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineInitHandlerAbstract */
public final class ec extends ey<String, eb> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final /* synthetic */ eb a(JSONObject jSONObject) throws AMapException {
        return b(jSONObject);
    }

    public ec(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final JSONObject a(qz.a aVar) {
        if (aVar == null || aVar.w == null) {
            return null;
        }
        return aVar.w.optJSONObject("016");
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final String a() {
        return "016";
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ey
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }

    private static eb b(JSONObject jSONObject) throws AMapException {
        eb ebVar = new eb();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                ebVar.a(false);
            } else if (optString.equals("1")) {
                ebVar.a(true);
            }
            ebVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            rx.c(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return ebVar;
    }
}
