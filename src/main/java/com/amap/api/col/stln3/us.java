package com.amap.api.col.stln3;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy */
public final class us extends uv {
    private Context b;
    private boolean c;
    private int d;
    private int e;

    public us(Context context, boolean z, int i, int i2) {
        this.b = context;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.uv
    public final boolean a() {
        if (rd.r(this.b) == 1) {
            return true;
        }
        if (!this.c) {
            return false;
        }
        String a = rv.a(this.b, "iKey");
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String[] split = a.split("\\|");
        if (split == null || split.length < 2) {
            rv.b(this.b, "iKey");
            return true;
        }
        if (!rk.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.e) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.uv
    public final int b() {
        int i;
        if (rd.r(this.b) == 1 || (i = this.d) <= 0) {
            i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (this.a != null) {
            return Math.max(i, this.a.b());
        }
        return i;
    }

    @Override // com.amap.api.col.stln3.uv
    public final void a(int i) {
        if (rd.r(this.b) != 1) {
            String a = rk.a(System.currentTimeMillis(), "yyyyMMdd");
            String a2 = rv.a(this.b, "iKey");
            if (!TextUtils.isEmpty(a2)) {
                String[] split = a2.split("\\|");
                if (split == null || split.length < 2) {
                    rv.b(this.b, "iKey");
                } else if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.b;
            rv.a(context, "iKey", a + "|" + i);
        }
    }
}
