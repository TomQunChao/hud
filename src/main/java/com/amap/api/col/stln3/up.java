package com.amap.api.col.stln3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class up {
    up c;
    byte[] d = null;

    /* access modifiers changed from: protected */
    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    up() {
    }

    up(up upVar) {
        this.c = upVar;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        up upVar = this;
        while (true) {
            byte[] a = upVar.a(upVar.d);
            upVar = upVar.c;
            if (upVar == null) {
                return a;
            }
            upVar.d = a;
        }
    }

    public void b(byte[] bArr) {
    }
}
