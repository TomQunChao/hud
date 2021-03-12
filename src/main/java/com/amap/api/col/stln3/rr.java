package com.amap.api.col.stln3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAAESEncryptProcessor */
public final class rr extends ro {
    public rr() {
    }

    public rr(ro roVar) {
        super(roVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ro
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return re.a(bArr);
    }
}
