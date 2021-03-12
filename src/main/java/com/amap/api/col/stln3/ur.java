package com.amap.api.col.stln3;

import java.io.File;

/* compiled from: FileNumUpdateStrategy */
public final class ur extends uv {
    private int b;
    private String c;

    public ur(int i, String str, uv uvVar) {
        super(uvVar);
        this.b = i;
        this.c = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.uv
    public final boolean a() {
        if (a(this.c) < this.b) {
            return false;
        }
        return true;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            rx.c(th, "fus", "gfn");
            return 0;
        }
    }
}
