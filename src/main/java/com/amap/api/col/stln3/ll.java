package com.amap.api.col.stln3;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PoiBatchSearchIdHandler */
public final class ll extends kw<lm, Map<String, ln>> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.amap.api.col.stln3.kw
    public final /* synthetic */ Map<String, ln> a(String str) throws kv {
        return c(str);
    }

    public ll(Context context, lm lmVar) {
        super(context, lmVar);
    }

    @Override // com.amap.api.col.stln3.tw
    public final String getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(lu.a().c() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3");
        sb.append("/batch?key=");
        sb.append(qy.f(this.g));
        return sb.toString();
    }

    private static Map<String, ln> c(String str) throws kv {
        try {
            return lh.a(new JSONArray(str));
        } catch (JSONException e) {
            la.a(e, "PoiBatchSearchIdHandler", "paseJSONJSONException");
        } catch (Throwable th) {
            la.a(th, "PoiBatchSearchIdHandler", "paseJSONException");
        }
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        try {
            List<String> a = ((lm) this.d).a();
            StringBuilder sb = new StringBuilder();
            sb.append("{\"ops\":");
            sb.append("[");
            for (int i = 0; i < a.size(); i++) {
                sb.append("{");
                sb.append("\"url\":\"");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id=");
                sb2.append(a.get(i));
                sb2.append("&output=json");
                sb2.append("&extensions=all");
                sb2.append("&children=1");
                sb2.append("&language=");
                sb2.append(lu.a().b());
                sb2.append("&key=" + qy.f(this.g));
                String b = b(sb2.toString());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("/v3/place/detail?");
                stringBuffer.append((CharSequence) sb2);
                String a2 = rb.a();
                stringBuffer.append("&ts=" + a2);
                stringBuffer.append("&scode=" + rb.a(this.g, a2, b));
                sb.append(stringBuffer.toString().toString());
                sb.append("\"}");
                if (i < a.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]}");
            return sb.toString().getBytes("utf-8");
        } catch (Throwable th) {
            return null;
        }
    }
}
