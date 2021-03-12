package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.gr;
import com.amap.api.maps.MapsInitializer;

/* compiled from: CustomStyleTask */
public final class gs implements Runnable {
    private Context a;
    private co b;
    private gr c;
    private a d;

    /* compiled from: CustomStyleTask */
    public interface a {
        void a(byte[] bArr);
    }

    public gs(Context context, a aVar) {
        this.a = context;
        this.d = aVar;
        if (this.c == null) {
            this.c = new gr(this.a, "", (byte) 0);
        }
    }

    public gs(Context context, co coVar) {
        this.a = context;
        this.b = coVar;
        if (this.c == null) {
            this.c = new gr(this.a, "");
        }
    }

    public final void a(String str) {
        gr grVar = this.c;
        if (grVar != null) {
            grVar.b(str);
        }
    }

    public final void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.c != null) {
                    gr.a aVar = (gr.a) this.c.a();
                    if (aVar != null && aVar.a != null) {
                        if (this.d != null) {
                            this.d.a(aVar.a);
                        } else if (this.b != null) {
                            this.b.a(this.b.getMapConfig().isCustomStyleEnable(), aVar.a);
                        }
                    }
                }
                rx.a(this.a, ic.f());
                if (this.b != null) {
                    this.b.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            rx.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void a() {
        this.a = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    public final void b() {
        ib.a().a(this);
    }
}
