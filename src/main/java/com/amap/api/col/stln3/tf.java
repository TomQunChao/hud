package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: SoFileCleaner */
public final class tf {
    private sz a;
    private sw b;
    private Context c;

    public tf(sz szVar, sw swVar, Context context) {
        this.a = szVar;
        this.b = swVar;
        this.c = context;
    }

    public final void a(String str) {
        a aVar = new a(this.c, this.b, str);
        sz szVar = this.a;
        if (szVar != null) {
            szVar.a(aVar);
        }
    }

    /* compiled from: SoFileCleaner */
    static class a implements Runnable {
        private int a = 2;
        private WeakReference<Context> b;
        private sw c;
        private String d;

        public a(Context context, sw swVar, String str) {
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
            this.c = swVar;
            this.d = str;
        }

        public final void run() {
            String str;
            WeakReference<Context> weakReference;
            int i = this.a;
            sw swVar = this.c;
            if (swVar != null) {
                if (i == 1) {
                    str = swVar.a();
                } else if (i == 2) {
                    str = swVar.a(this.d);
                }
                if (!TextUtils.isEmpty(str) && (weakReference = this.b) != null && weakReference.get() != null) {
                    sw.d(str);
                    if (this.a == 1) {
                        th.c(this.b.get());
                        return;
                    } else {
                        th.d(this.b.get());
                        return;
                    }
                } else {
                    return;
                }
            }
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
        }
    }
}
