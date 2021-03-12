package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: HeaderAddStrategy */
public final class ul extends up {
    private Context a;
    private String b;
    private ro e;
    private Object[] f;

    public ul(Context context, up upVar, ro roVar, String str, Object... objArr) {
        super(upVar);
        this.a = context;
        this.b = str;
        this.e = roVar;
        this.f = objArr;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.up
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = rk.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        Context context = this.a;
        String a3 = rk.a(this.e.b(rk.a(b())));
        return rk.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }

    private String b() {
        try {
            return String.format(rk.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "ofm", "gpj");
            return "";
        }
    }
}
