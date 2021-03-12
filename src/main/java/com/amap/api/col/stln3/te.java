package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.tt;
import java.util.List;

/* compiled from: SoDownloadThread */
public final class te implements tt.a {
    private tw a;
    private tt b;
    private ta c;
    private ti d;
    private ti e;
    private ti f;
    private sw g;
    private rj h;
    private Context i;

    public te(Context context, ta taVar, rj rjVar, ti tiVar, ti tiVar2, ti tiVar3, sw swVar) {
        this.d = tiVar;
        this.e = tiVar2;
        this.f = tiVar3;
        this.g = swVar;
        try {
            this.i = context.getApplicationContext();
            this.h = rjVar;
            this.c = taVar;
            this.a = new td(this.c);
            this.b = new tt(this.a);
        } catch (Throwable th) {
        }
    }

    public final void a() {
        try {
            if (b()) {
                sw.d(this.g.a(this.h.a()));
                this.b.a(this);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3 A[Catch:{ Throwable -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc A[Catch:{ Throwable -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b() {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.te.b():boolean");
    }

    private static boolean a(ti tiVar, ti tiVar2) {
        if (tiVar2 == null || tiVar2.d() == null || TextUtils.isEmpty(tiVar2.c())) {
            return false;
        }
        if (tiVar == null || tiVar.d() == null || TextUtils.isEmpty(tiVar.c())) {
            return true;
        }
        if (tc.a(tiVar.c(), tiVar2.c()) > 0) {
            return false;
        }
        List<tg> d2 = tiVar.d();
        List<tg> d3 = tiVar2.d();
        for (int i2 = 0; i2 < d3.size(); i2++) {
            tg tgVar = d3.get(i2);
            for (int i3 = 0; i3 < d2.size(); i3++) {
                tg tgVar2 = d2.get(i3);
                if (tgVar.f().equals(tgVar2.f()) && tc.a(tgVar.e(), tgVar2.e()) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onDownload(byte[] bArr, long j) {
        this.c.a(bArr, j);
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onStop() {
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onException(Throwable th) {
        this.c.b();
    }

    @Override // com.amap.api.col.stln3.tt.a
    public final void onFinish() {
        this.c.a(this.i);
    }
}
