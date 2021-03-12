package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy */
public final class uu extends uv {
    private int b;
    private long c;
    private String d;
    private Context e;

    public uu(Context context, int i, String str, uv uvVar) {
        super(uvVar);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.uv
    public final boolean a() {
        long j = 0;
        if (this.c == 0) {
            String a = rv.a(this.e, this.d);
            if (!TextUtils.isEmpty(a)) {
                j = Long.parseLong(a);
            }
            this.c = j;
        }
        if (System.currentTimeMillis() - this.c < ((long) this.b)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.uv
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            rv.a(this.e, str, String.valueOf(currentTimeMillis));
        }
    }
}
