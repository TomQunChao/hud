package com.amap.api.col.stln3;

import android.support.v7.widget.ActivityChooserView;

/* compiled from: UpdateStrategy */
public abstract class uv {
    uv a;

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public uv() {
    }

    public uv(uv uvVar) {
        this.a = uvVar;
    }

    public final boolean c() {
        uv uvVar = this.a;
        if (!(uvVar != null ? uvVar.c() : true)) {
            return false;
        }
        return a();
    }

    public void a(boolean z) {
        uv uvVar = this.a;
        if (uvVar != null) {
            uvVar.a(z);
        }
    }

    public int b() {
        int i;
        uv uvVar = this.a;
        if (uvVar != null) {
            i = uvVar.b();
        } else {
            i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return Math.min((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, i);
    }

    public void a(int i) {
        uv uvVar = this.a;
        if (uvVar != null) {
            uvVar.a(i);
        }
    }
}
