package com.amap.api.col.stln3;

/* compiled from: LogJsonDataStrategy */
public final class um extends up {
    private StringBuilder a = new StringBuilder();
    private boolean b = true;

    public um() {
    }

    public um(up upVar) {
        super(upVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.up
    public final byte[] a(byte[] bArr) {
        byte[] a2 = rk.a(this.a.toString());
        this.d = a2;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.col.stln3.up
    public final void b(byte[] bArr) {
        String a2 = rk.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }
}
