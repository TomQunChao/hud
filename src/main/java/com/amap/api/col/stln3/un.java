package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy */
public final class un extends up {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public un(Context context, up upVar) {
        super(upVar);
        this.e = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.up
    public final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[(a2.length + bArr.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            rk.a(byteArrayOutputStream, "1.2." + a + "." + b);
            rk.a(byteArrayOutputStream, "Android");
            rk.a(byteArrayOutputStream, rd.v(context));
            rk.a(byteArrayOutputStream, rd.m(context));
            rk.a(byteArrayOutputStream, rd.h(context));
            rk.a(byteArrayOutputStream, Build.MANUFACTURER);
            rk.a(byteArrayOutputStream, Build.MODEL);
            rk.a(byteArrayOutputStream, Build.DEVICE);
            rk.a(byteArrayOutputStream, rd.x(context));
            rk.a(byteArrayOutputStream, qy.c(context));
            rk.a(byteArrayOutputStream, qy.d(context));
            rk.a(byteArrayOutputStream, qy.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return bArr;
        throw th;
    }
}
