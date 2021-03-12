package com.amap.api.col.stln3;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.stln3.tr;
import com.amap.api.maps.AMapException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: HttpUrlUtil */
public final class tu {
    private int a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private a j;
    private tr.a k;

    tu(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, (byte) 0);
    }

    private tu(int i2, int i3, Proxy proxy, boolean z, byte b2) {
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = rf.a().b(z);
        if (rf.c()) {
            this.c = false;
        }
        this.k = null;
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ru.a(th, "ht", "ic");
        }
        if (this.c) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.d = instance;
            } catch (Throwable th2) {
                ru.a(th2, "ht", "ne");
            }
        }
        this.j = new a((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.h = j2;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j2) {
        this.g = j2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011e A[SYNTHETIC, Splitter:B:71:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0140 A[SYNTHETIC, Splitter:B:82:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0159 A[SYNTHETIC, Splitter:B:89:0x0159] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, boolean r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, byte[] r14, com.amap.api.col.stln3.tt.a r15) {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.tu.a(java.lang.String, boolean, java.lang.String, java.util.Map, java.util.Map, byte[], com.amap.api.col.stln3.tt$a):void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> a(String str, boolean z, String str2, Map<String, String> map, Map<String, String> map2) throws qx {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            String a2 = a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a2 != null) {
                stringBuffer.append("?");
                stringBuffer.append(a2);
            }
            HttpURLConnection a3 = a(stringBuffer.toString(), z, str2, map, false);
            if (a3.getResponseCode() < 400) {
                HashMap hashMap = new HashMap();
                int i2 = 0;
                while (i2 < 50 && (headerFieldKey = a3.getHeaderFieldKey(i2)) != null) {
                    hashMap.put(headerFieldKey.toLowerCase(), a3.getHeaderField(headerFieldKey));
                    i2++;
                }
                if (a3 != null) {
                    try {
                        a3.disconnect();
                    } catch (Throwable th) {
                        ru.a(th, "hth", "mgr");
                    }
                }
                return hashMap;
            }
            throw new qx("http读取header失败");
        } catch (ConnectException e2) {
            throw new qx(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException e3) {
            throw new qx("url异常 - MalformedURLException");
        } catch (UnknownHostException e4) {
            throw new qx("未知主机 - UnKnowHostException");
        } catch (SocketException e5) {
            throw new qx(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e6) {
            throw new qx("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e7) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        } catch (IOException e8) {
            throw new qx("IO 操作异常 - IOException");
        } catch (qx e9) {
            throw e9;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th3) {
                    ru.a(th3, "hth", "mgr");
                }
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final ty a(String str, boolean z, String str2, Map<String, String> map, Map<String, String> map2, boolean z2) throws qx {
        HttpURLConnection httpURLConnection = null;
        try {
            String a2 = a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a2 != null) {
                stringBuffer.append("?");
                stringBuffer.append(a2);
            }
            HttpURLConnection a3 = a(stringBuffer.toString(), z, str2, map, false);
            ty a4 = a(a3, z2);
            if (a3 != null) {
                try {
                    a3.disconnect();
                } catch (Throwable th) {
                    ru.a(th, "ht", "mgr");
                }
            }
            return a4;
        } catch (ConnectException e2) {
            throw new qx(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException e3) {
            throw new qx("url异常 - MalformedURLException");
        } catch (UnknownHostException e4) {
            throw new qx("未知主机 - UnKnowHostException");
        } catch (SocketException e5) {
            throw new qx(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e6) {
            throw new qx("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e7) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        } catch (IOException e8) {
            throw new qx("IO 操作异常 - IOException");
        } catch (qx e9) {
            throw e9;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th3) {
                    ru.a(th3, "ht", "mgr");
                }
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final ty a(String str, boolean z, String str2, Map<String, String> map, byte[] bArr, boolean z2) throws qx {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection a2 = a(str, z, str2, map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a2.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            ty a3 = a(a2, z2);
            if (a2 != null) {
                try {
                    a2.disconnect();
                } catch (Throwable th) {
                    ru.a(th, "ht", "mPt");
                }
            }
            return a3;
        } catch (ConnectException e2) {
            e2.printStackTrace();
            throw new qx(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException e3) {
            e3.printStackTrace();
            throw new qx("url异常 - MalformedURLException");
        } catch (UnknownHostException e4) {
            e4.printStackTrace();
            throw new qx("未知主机 - UnKnowHostException");
        } catch (SocketException e5) {
            e5.printStackTrace();
            throw new qx(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e6) {
            e6.printStackTrace();
            throw new qx("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e7) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        } catch (IOException e8) {
            e8.printStackTrace();
            throw new qx("IO 操作异常 - IOException");
        } catch (qx e9) {
            ru.a(e9, "ht", "mPt");
            throw e9;
        } catch (Throwable th2) {
            ru.a(th2, "ht", "mPt");
        }
        throw th;
    }

    private HttpURLConnection a(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        URLConnection uRLConnection;
        HttpURLConnection httpURLConnection;
        rd.b();
        if (map == null) {
            map = new HashMap<>();
        }
        b a2 = this.j.a();
        if (z && !TextUtils.isEmpty(str2)) {
            a2 = this.j.a(str2);
        }
        String str3 = "";
        if (tr.a == 1) {
            str3 = tr.b;
        }
        if (!TextUtils.isEmpty(str3)) {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            str = parse.buildUpon().encodedAuthority(str3).build().toString();
            if (map != null) {
                map.put("targetHost", host);
            }
            if (this.c) {
                this.j.b(str3);
            }
        }
        if (this.c) {
            str = rf.a(str);
        }
        URL url = new URL(str);
        tr.a aVar = this.k;
        if (aVar != null) {
            Proxy proxy = this.e;
            uRLConnection = aVar.a();
        } else {
            uRLConnection = null;
        }
        if (uRLConnection == null) {
            Proxy proxy2 = this.e;
            if (proxy2 != null) {
                uRLConnection = url.openConnection(proxy2);
            } else {
                uRLConnection = url.openConnection();
            }
        }
        if (this.c) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.d.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a2);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        a(map, httpURLConnection);
        if (z2) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x016a A[SYNTHETIC, Splitter:B:75:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017e A[SYNTHETIC, Splitter:B:80:0x017e] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0192 A[SYNTHETIC, Splitter:B:85:0x0192] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a6 A[SYNTHETIC, Splitter:B:90:0x01a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.col.stln3.ty a(java.net.HttpURLConnection r11, boolean r12) throws com.amap.api.col.stln3.qx, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 441
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.tu.a(java.net.HttpURLConnection, boolean):com.amap.api.col.stln3.ty");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.i);
        } catch (Throwable th) {
            ru.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
    }

    /* access modifiers changed from: private */
    /* compiled from: HttpUrlUtil */
    public static class b implements HostnameVerifier {
        private String a;
        private String b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(String str) {
            this.a = str;
        }

        public final void b(String str) {
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: HttpUrlUtil */
    public static class a {
        private Vector<b> a;
        private volatile b b;

        private a() {
            this.a = new Vector<>();
            this.b = new b((byte) 0);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final b a() {
            return this.b;
        }

        public final b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                b bVar = this.a.get(i);
                if (bVar != null && bVar.a().equals(str)) {
                    return bVar;
                }
            }
            b bVar2 = new b((byte) 0);
            bVar2.b(str);
            this.a.add(bVar2);
            return bVar2;
        }

        public final void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b.a(str);
            }
        }
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(key));
            sb.append("=");
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }
}
