package com.amap.api.col.stln3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public final class uj extends up {
    ByteArrayOutputStream a = new ByteArrayOutputStream();

    public uj() {
    }

    public uj(up upVar) {
        super(upVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.up
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.a.toByteArray();
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.stln3.up
    public final void b(byte[] bArr) {
        try {
            this.a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
