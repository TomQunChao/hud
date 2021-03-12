package com.amap.api.col.stln3;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class ts extends tw {
    protected Context h;
    protected rj i;

    public abstract byte[] a();

    public abstract byte[] d();

    public boolean g() {
        return true;
    }

    public ts(Context context, rj rjVar) {
        if (context != null) {
            this.h = context.getApplicationContext();
        }
        this.i = rjVar;
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getParams() {
        String f = qy.f(this.h);
        String a = rb.a();
        Context context = this.h;
        String a2 = rb.a(context, a, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    @Override // com.amap.api.col.stln3.tw
    public final byte[] getEntityBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(e());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ru.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            ru.a(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    private static byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(rk.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ru.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            ru.a(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (g()) {
                byte[] a = rb.a(this.h, i());
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a2 = rk.a(f());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = rk.a(h());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ru.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            ru.a(th2, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    public String h() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.i.c(), this.i.a());
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "2.1";
    }

    protected static byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d = d();
            if (d != null) {
                if (d.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(d));
                    byteArrayOutputStream.write(d);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ru.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ru.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ru.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
        throw th;
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] a = a();
            if (a != null) {
                if (a.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    Context context = this.h;
                    byte[] a2 = re.a(a);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ru.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ru.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ru.a(th3, "bre", "gred");
        }
        throw th;
        return new byte[]{0};
    }

    /* access modifiers changed from: protected */
    public boolean i() {
        return false;
    }
}
