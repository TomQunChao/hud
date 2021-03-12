package com.amap.api.col.stln3;

/* compiled from: SoLoaderEntity */
public final class sv {
    private rj a;
    private boolean b = true;

    public sv(rj rjVar) {
        this.a = rjVar;
        this.b = false;
    }

    public final rj a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        rj rjVar = this.a;
        if (rjVar == null) {
            return "";
        }
        return rjVar.a();
    }
}
