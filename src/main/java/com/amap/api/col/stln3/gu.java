package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.gt;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.FileUtil;

/* compiled from: CustomStyleTextureTask */
public final class gu implements Runnable {
    private Context a;
    private gt b;
    private ha c;
    private a d;

    /* compiled from: CustomStyleTextureTask */
    public interface a {
        void a(String str, ha haVar);
    }

    public gu(Context context) {
        this.a = context;
        if (this.b == null) {
            this.b = new gt(this.a, "");
        }
    }

    public final void a(String str) {
        gt gtVar = this.b;
        if (gtVar != null) {
            gtVar.b(str);
        }
    }

    public final void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.b != null) {
                    gt.a aVar = (gt.a) this.b.a();
                    String str = null;
                    if (!(aVar == null || aVar.a == null)) {
                        str = FileUtil.getMapBaseStorage(this.a) + "/custom_texture_data";
                        FileUtil.writeDatasToFile(str, aVar.a);
                    }
                    if (this.d != null) {
                        this.d.a(str, this.c);
                    }
                }
                rx.a(this.a, ic.f());
            }
        } catch (Throwable th) {
            rx.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void a() {
        this.a = null;
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void b() {
        ib.a().a(this);
    }

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void a(ha haVar) {
        this.c = haVar;
    }
}
