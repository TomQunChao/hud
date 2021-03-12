package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.stln3.ld;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore */
public final class lg {
    private Context a;
    private ld.a b;
    private Handler c = lj.a();
    private lf d;

    public lg(Context context, lf lfVar) {
        this.a = context.getApplicationContext();
        this.d = lfVar;
    }

    public final void a(ld.a aVar) {
        this.b = aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayList<lw> a(lf lfVar) throws kv {
        if (lfVar != null) {
            try {
                if (lfVar.a() != null && !"".equals(lfVar.a())) {
                    return (ArrayList) new le(this.a, lfVar).a();
                }
                throw new kv("无效的参数 - IllegalArgumentException");
            } catch (Throwable th) {
                return null;
            }
        } else {
            throw new kv("无效的参数 - IllegalArgumentException");
        }
    }
}
