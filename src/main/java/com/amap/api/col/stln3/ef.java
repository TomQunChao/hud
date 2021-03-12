package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.stln3.eu;

/* compiled from: OfflineMapDownloadTask */
public final class ef extends uy implements eu.a {
    private eu a;
    private ew b;
    private ez c;
    private Context e;
    private Bundle f;
    private boolean g;

    private ef(ez ezVar, Context context) {
        this.f = new Bundle();
        this.g = false;
        this.c = ezVar;
        this.e = context;
    }

    public ef(ez ezVar, Context context, byte b2) {
        this(ezVar, context);
    }

    @Override // com.amap.api.col.stln3.uy
    public final void runTask() {
        this.c.u();
        try {
            this.a = new eu(new ev(this.c.getUrl(), ic.c(this.e), this.c.v(), this.c.w()), this.c.getUrl(), this.e, this.c);
            this.a.a(this);
            this.b = new ew(this.c, this.c);
            if (!this.g) {
                this.a.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        this.g = true;
        eu euVar = this.a;
        if (euVar != null) {
            euVar.b();
        } else {
            cancelTask();
        }
        ew ewVar = this.b;
        if (ewVar != null) {
            ewVar.a();
        }
    }

    public final void b() {
        Bundle bundle = this.f;
        if (bundle != null) {
            bundle.clear();
            this.f = null;
        }
    }

    @Override // com.amap.api.col.stln3.eu.a
    public final void c() {
        ew ewVar = this.b;
        if (ewVar != null) {
            ewVar.b();
        }
    }
}
