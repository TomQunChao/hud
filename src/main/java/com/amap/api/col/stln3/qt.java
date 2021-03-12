package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.qz;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: AuthTask */
public final class qt extends Thread {
    private WeakReference<Context> a;
    private a b;

    /* compiled from: AuthTask */
    public interface a {
        void a();
    }

    private qt(Context context, a aVar) {
        if (context != null) {
            this.a = new WeakReference<>(context);
        }
        this.b = aVar;
    }

    public static qt a(Context context, a aVar) {
        return new qt(context, aVar);
    }

    public final void run() {
        try {
            if (this.a == null) {
                return;
            }
            if (this.a.get() != null) {
                String str = "14D";
                rj a2 = qv.a();
                if (a2 != null) {
                    qz.a a3 = qz.a(this.a.get(), a2, str, null);
                    if (this.b != null) {
                        if (qz.a == 0) {
                            this.b.a();
                            return;
                        }
                        a aVar = this.b;
                        JSONObject jSONObject = a3.v;
                        if (aVar != null && jSONObject != null) {
                            a aVar2 = this.b;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            qr.a("AuthConfigManager failed " + th);
        }
    }
}
