package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.lj;
import com.amap.api.col.stln3.lq;
import com.amap.api.maps.model.MyLocationStyle;
import java.util.Map;

/* compiled from: PoiSearchCore */
public final class lr implements lb {
    private lq.b a;
    private Context b;
    private lq.a c;
    private String d = "zh-CN";
    private Handler e = null;

    public lr(Context context, lq.b bVar) {
        this.b = context.getApplicationContext();
        this.a = bVar;
        this.e = lj.a();
    }

    @Override // com.amap.api.col.stln3.lb
    public final void a(lq.a aVar) {
        this.c = aVar;
    }

    public final ln b(String str) throws kv {
        return (ln) new ls(this.b, str).a();
    }

    @Override // com.amap.api.col.stln3.lb
    public final void a(final String str) {
        jg.a().execute(new Runnable() {
            /* class com.amap.api.col.stln3.lr.AnonymousClass1 */

            public final void run() {
                try {
                    Message obtainMessage = lj.a().obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 602;
                    Bundle bundle = new Bundle();
                    ln lnVar = null;
                    try {
                        lnVar = lr.this.b(str);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (kv e) {
                        la.a(e, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.b());
                    } finally {
                        lj.a aVar = new lj.a();
                        aVar.b = lr.this.c;
                        aVar.a = lnVar;
                        obtainMessage.obj = aVar;
                        obtainMessage.setData(bundle);
                        lr.this.e.sendMessage(obtainMessage);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.amap.api.col.stln3.lb
    public final Map<String, ln> a(lm lmVar) throws kv {
        return (Map) new ll(this.b, lmVar).a();
    }
}
