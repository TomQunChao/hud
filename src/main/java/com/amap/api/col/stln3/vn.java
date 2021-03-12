package com.amap.api.col.stln3;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* compiled from: DnsManager */
public final class vn {
    private static vn c = null;
    vq a;
    int b;
    private Object d;
    private Context e;
    private ExecutorService f;
    private boolean g;
    private boolean h;
    private final int i;
    private String j;
    private String k;
    private String[] l;
    private final int m;
    private final int n;

    private vn() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = true;
        this.a = null;
        this.i = 2;
        this.j = "";
        this.k = "";
        this.l = null;
        this.b = 0;
        this.m = 5;
        this.n = 2;
    }

    private vn(Context context) {
        this.d = null;
        this.e = null;
        this.f = null;
        int i2 = 0;
        this.g = false;
        this.h = true;
        this.a = null;
        this.i = 2;
        this.j = "";
        this.k = "";
        this.l = null;
        this.b = 0;
        this.m = 5;
        this.n = 2;
        this.e = context;
        Context context2 = this.e;
        try {
            if (vt.v()) {
                rj a2 = vu.a("HttpDNS", "1.0.0");
                if (vz.a(context2, a2)) {
                    try {
                        this.d = sk.a(context2, a2, "com.autonavi.httpdns.HttpDnsManager", null, new Class[]{Context.class}, new Object[]{context2});
                    } catch (Throwable th) {
                    }
                    vz.a(context2, "HttpDns", this.d != null ? 1 : i2);
                }
            }
        } catch (Throwable th2) {
            vu.a(th2, "DNSManager", "initHttpDns");
        }
    }

    public static vn a(Context context) {
        if (c == null) {
            c = new vn(context);
        }
        return c;
    }

    private boolean e() {
        if (vt.v() && this.d != null && !f() && wb.b(this.e, "pref", "dns_faile_count_total", 0L) < 2) {
            return true;
        }
        return false;
    }

    public final void a(vq vqVar) {
        String str;
        try {
            this.g = false;
            if (e() && vqVar != null) {
                this.a = vqVar;
                String url = vqVar.getURL();
                String host = new URL(url).getHost();
                if ("http://abroad.apilocate.amap.com/mobile/binary".equals(url)) {
                    return;
                }
                if (!"abroad.apilocate.amap.com".equals(host)) {
                    if ("apilocate.amap.com".equalsIgnoreCase(host)) {
                        str = "httpdns.apilocate.amap.com";
                    } else {
                        str = host;
                    }
                    String a2 = a(str);
                    if (this.h && TextUtils.isEmpty(a2)) {
                        this.h = false;
                        a2 = wb.b(this.e, "ip", "last_ip", "");
                        if (!TextUtils.isEmpty(a2)) {
                            this.j = a2;
                        }
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        this.k = a2;
                        vqVar.e = url.replace(host, a2);
                        vqVar.getRequestHead().put("host", str);
                        vqVar.a(str);
                        this.g = true;
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void a() {
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        if (TextUtils.isEmpty(this.j) || !this.k.equals(this.j)) {
            String str = this.k;
            this.j = str;
            wb.a(this.e, "ip", "last_ip", str);
        }
    }

    public final void b() {
        if (this.g) {
            wb.a(this.e, "pref", "dns_faile_count_total", 0L);
        }
    }

    private String a(String str) {
        String str2 = null;
        if (e()) {
            int i2 = 1;
            try {
                String[] strArr = (String[]) vx.a(this.d, "getIpsByHostAsync", str);
                if (strArr != null && strArr.length > 0) {
                    if (this.l == null) {
                        this.l = strArr;
                        str2 = strArr[0];
                    } else if (a(strArr, this.l)) {
                        str2 = this.l[0];
                    } else {
                        this.l = strArr;
                        str2 = strArr[0];
                    }
                }
            } catch (Throwable th) {
                i2 = 0;
            }
            vz.b(this.e, "HttpDns", i2);
        }
        return str2;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 == null) {
            return false;
        }
        if (strArr == null && strArr2 != null) {
            return false;
        }
        if (strArr == null && strArr2 == null) {
            return true;
        }
        try {
            if (strArr.length != strArr2.length) {
                return false;
            }
            ArrayList arrayList = new ArrayList(12);
            ArrayList arrayList2 = new ArrayList(12);
            arrayList.addAll(Arrays.asList(strArr));
            arrayList2.addAll(Arrays.asList(strArr2));
            Collections.sort(arrayList);
            Collections.sort(arrayList2);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!((String) arrayList.get(i2)).equals(arrayList2.get(i2))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean f() {
        int i2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                i2 = Integer.parseInt(property);
            } else {
                str = Proxy.getHost(this.e);
                i2 = Proxy.getPort(this.e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            i2 = -1;
        }
        return (str == null || i2 == -1) ? false : true;
    }

    public final void c() {
        String[] strArr;
        try {
            if (e()) {
                if (!(!this.g || this.l == null || (strArr = this.l) == null)) {
                    try {
                        if (strArr.length > 1) {
                            ArrayList arrayList = new ArrayList(12);
                            arrayList.addAll(Arrays.asList(strArr));
                            Iterator it = arrayList.iterator();
                            it.remove();
                            arrayList.add((String) it.next());
                            arrayList.toArray(strArr);
                        }
                    } catch (Throwable th) {
                    }
                }
                if (this.b <= 5 && this.g) {
                    if (this.f == null) {
                        this.f = rx.d();
                    }
                    if (!this.f.isShutdown()) {
                        this.f.submit(new a(this.a));
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(vq vqVar) {
        try {
            vqVar.e = vu.a();
            long b2 = wb.b(this.e, "pref", "dns_faile_count_total", 0L);
            if (b2 < 2) {
                tr.a();
                tr.a(vqVar, false);
                long j2 = b2 + 1;
                if (j2 >= 2) {
                    wa.a(this.e, "HttpDNS", "dns failed too much");
                }
                wb.a(this.e, "pref", "dns_faile_count_total", j2);
            }
        } catch (Throwable th) {
            wb.a(this.e, "pref", "dns_faile_count_total", 0L);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: DnsManager */
    public class a implements Runnable {
        vq a = null;

        a(vq vqVar) {
            this.a = vqVar;
        }

        public final void run() {
            vn.this.b++;
            vn.this.b(this.a);
            vn vnVar = vn.this;
            vnVar.b--;
        }
    }

    public static void d() {
        c = null;
    }
}
