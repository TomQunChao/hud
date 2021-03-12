package com.amap.api.col.stln3;

/* compiled from: ADDNumEncryptProcessor */
public final class rm extends ro {
    rm() {
    }

    public rm(ro roVar) {
        super(roVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ro
    public final byte[] a(byte[] bArr) {
        return rk.a(rk.a(bArr) + "||1");
    }
}
