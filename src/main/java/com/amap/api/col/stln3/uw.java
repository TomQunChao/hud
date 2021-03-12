package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: WiFiUplateStrategy */
public final class uw extends uv {
    private Context b;
    private boolean c = false;

    public uw(Context context) {
        this.b = context;
        this.c = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.uv
    public final boolean a() {
        return rd.r(this.b) == 1 || this.c;
    }
}
