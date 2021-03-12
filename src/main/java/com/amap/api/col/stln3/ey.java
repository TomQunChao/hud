package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.qz;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbstractProtocalHandler */
public abstract class ey<T, V> {
    protected T a;
    protected int b = 3;
    protected Context c;

    /* access modifiers changed from: protected */
    public abstract V a(JSONObject jSONObject) throws AMapException;

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract JSONObject a(qz.a aVar);

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    public ey(Context context, T t) {
        this.c = context;
        this.a = t;
    }

    public final V c() throws AMapException {
        if (this.a != null) {
            return d();
        }
        return null;
    }

    private V d() throws AMapException {
        int i = 0;
        V v = null;
        qz.a aVar = null;
        while (i < this.b) {
            try {
                aVar = qz.a(this.c, ic.f(), a(), b());
                v = a(a(aVar));
                i = this.b;
            } catch (Throwable th) {
                rx.c(th, "AbstractProtocalHandler", "getDataMayThrow AMapException");
                th.printStackTrace();
                i++;
                if (i < this.b) {
                    continue;
                } else if (aVar == null || aVar.a == null) {
                    v = null;
                } else {
                    throw new AMapException(aVar.a);
                }
            }
        }
        return v;
    }
}
