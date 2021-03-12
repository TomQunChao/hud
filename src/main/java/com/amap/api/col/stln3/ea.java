package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: OfflineDownloadManager */
public class ea {
    public static String a = "";
    public static boolean b = false;
    public static String d = "";
    private static volatile ea k;
    List<dz> c = new Vector();
    b e = null;
    public ee f;
    eg g;
    ed h = null;
    private Context i;
    private boolean j = true;
    private a l;
    private ej m;
    private ep n;
    private ExecutorService o = null;
    private ExecutorService p = null;
    private ExecutorService q = null;
    private boolean r = true;

    /* compiled from: OfflineDownloadManager */
    public interface a {
        void a();

        void a(dz dzVar);

        void b(dz dzVar);

        void c(dz dzVar);
    }

    private ea(Context context) {
        this.i = context;
    }

    public static ea a(Context context) {
        if (k == null) {
            synchronized (ea.class) {
                if (k == null) {
                    if (!b) {
                        k = new ea(context.getApplicationContext());
                    }
                }
            }
        }
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ed A[Catch:{ JSONException -> 0x0105 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ea.a():void");
    }

    public final void b() {
        Iterator<ek> it = this.n.a().iterator();
        while (it.hasNext()) {
            ek next = it.next();
            if (!(next == null || next.c() == null || next.e().length() <= 0)) {
                if (!(next.l == 4 || next.l == 7 || next.l < 0)) {
                    next.l = 3;
                }
                dz g2 = g(next.c());
                if (g2 != null) {
                    String d2 = next.d();
                    if (d2 == null || !b(d, d2)) {
                        g2.a(next.l);
                        g2.setCompleteCode(next.g());
                    } else {
                        g2.a(7);
                    }
                    if (next.d().length() > 0) {
                        g2.setVersion(next.d());
                    }
                    List<String> b2 = this.n.b(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : b2) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    g2.a(stringBuffer.toString());
                    ee eeVar = this.f;
                    if (eeVar != null) {
                        eeVar.a(g2);
                    }
                }
            }
        }
        a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                rx.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void a(final String str) {
        if (str == null) {
            try {
                if (this.l != null) {
                    this.l.b(null);
                }
            } catch (Throwable th) {
                rx.c(th, "OfflineDownloadManager", "checkUpdate");
            }
        } else {
            if (this.o == null) {
                this.o = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hq("AMapOfflineCheckUpdate"), new ThreadPoolExecutor.AbortPolicy());
            }
            this.o.execute(new Runnable() {
                /* class com.amap.api.col.stln3.ea.AnonymousClass1 */

                public final void run() {
                    dz g = ea.this.g(str);
                    if (g != null) {
                        try {
                            if (!g.c().equals(g.c)) {
                                if (!g.c().equals(g.e)) {
                                    String pinyin = g.getPinyin();
                                    if (pinyin.length() > 0) {
                                        String d = ea.this.n.d(pinyin);
                                        if (d == null) {
                                            d = g.getVersion();
                                        }
                                        if (ea.d.length() > 0 && d != null) {
                                            ea eaVar = ea.this;
                                            if (ea.b(ea.d, d)) {
                                                g.j();
                                            }
                                        }
                                    }
                                }
                            }
                            if (ea.this.l != null) {
                                synchronized (ea.this) {
                                    try {
                                        ea.this.l.b(g);
                                    } catch (Throwable th) {
                                        rx.c(th, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            if (ea.this.l != null) {
                                synchronized (ea.this) {
                                    ea.this.l.b(g);
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            rx.c(th2, "OfflineDownloadManager", "checkUpdatefinally");
                        }
                    }
                    ea.this.g();
                    eb ebVar = (eb) new ec(ea.this.i, ea.d).c();
                    if (ea.this.l != null) {
                        if (ebVar == null) {
                            if (ea.this.l != null) {
                                synchronized (ea.this) {
                                    try {
                                        ea.this.l.b(g);
                                    } catch (Throwable th3) {
                                        rx.c(th3, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (ebVar.a()) {
                            ea.this.c();
                        }
                    }
                    if (ea.this.l != null) {
                        synchronized (ea.this) {
                            try {
                                ea.this.l.b(g);
                            } catch (Throwable th4) {
                                rx.c(th4, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                    return;
                    throw th;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() throws AMapException {
        if (!ic.d(this.i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() throws AMapException {
        if (this.f != null) {
            eh ehVar = new eh(this.i, "");
            ehVar.a(this.i);
            List<OfflineMapProvince> list = (List) ehVar.c();
            if (this.c != null) {
                this.f.a(list);
            }
            List<dz> list2 = this.c;
            if (list2 != null) {
                synchronized (list2) {
                    Iterator<OfflineMapProvince> it = this.f.a().iterator();
                    while (it.hasNext()) {
                        Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                        while (it2.hasNext()) {
                            OfflineMapCity next = it2.next();
                            for (dz dzVar : this.c) {
                                if (next.getPinyin().equals(dzVar.getPinyin())) {
                                    String version = dzVar.getVersion();
                                    if (dzVar.getState() == 4 && d.length() > 0) {
                                        if (b(d, version)) {
                                            dzVar.j();
                                            dzVar.setUrl(next.getUrl());
                                            dzVar.s();
                                        }
                                    }
                                    dzVar.setCity(next.getCity());
                                    dzVar.setUrl(next.getUrl());
                                    dzVar.s();
                                    dzVar.setAdcode(next.getAdcode());
                                    dzVar.setVersion(next.getVersion());
                                    dzVar.setSize(next.getSize());
                                    dzVar.setCode(next.getCode());
                                    dzVar.setJianpin(next.getJianpin());
                                    dzVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        for (int i2 = 0; i2 < str2.length(); i2++) {
            try {
                if (str.charAt(i2) > str2.charAt(i2)) {
                    return true;
                }
                if (str.charAt(i2) < str2.charAt(i2)) {
                    return false;
                }
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public final boolean b(String str) {
        if (g(str) == null) {
            return false;
        }
        return true;
    }

    public final void c(String str) {
        dz g2 = g(str);
        if (g2 == null) {
            a aVar = this.l;
            if (aVar != null) {
                try {
                    aVar.c(g2);
                } catch (Throwable th) {
                    rx.c(th, "OfflineDownloadManager", "remove");
                }
            }
        } else {
            d(g2);
            a(g2, true);
        }
    }

    public final void a(dz dzVar) {
        a(dzVar, false);
    }

    private void a(final dz dzVar, final boolean z) {
        if (this.g == null) {
            this.g = new eg(this.i);
        }
        if (this.p == null) {
            this.p = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hq("AMapOfflineRemove"), new ThreadPoolExecutor.AbortPolicy());
        }
        try {
            this.p.execute(new Runnable() {
                /* class com.amap.api.col.stln3.ea.AnonymousClass2 */

                public final void run() {
                    try {
                        if (!dzVar.c().equals(dzVar.a)) {
                            if (dzVar.getState() != 7) {
                                if (dzVar.getState() != -1) {
                                    ea.this.g.a(dzVar);
                                    if (ea.this.l != null) {
                                        ea.this.l.c(dzVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                            ea.this.g.a(dzVar);
                            if (z && ea.this.l != null) {
                                ea.this.l.c(dzVar);
                            }
                        } else if (ea.this.l != null) {
                            ea.this.l.c(dzVar);
                        }
                    } catch (Throwable th) {
                        rx.c(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            rx.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public final void b(dz dzVar) {
        try {
            if (this.m != null) {
                this.m.a(dzVar, this.i);
            }
        } catch (qx e2) {
            e2.printStackTrace();
        }
    }

    public final void c(dz dzVar) {
        ee eeVar = this.f;
        if (eeVar != null) {
            eeVar.a(dzVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = dzVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    public final void d() {
        synchronized (this.c) {
            for (dz dzVar : this.c) {
                if (!dzVar.c().equals(dzVar.c)) {
                    if (dzVar.c().equals(dzVar.b)) {
                    }
                }
                d(dzVar);
                dzVar.g();
            }
        }
    }

    public final void e() {
        synchronized (this.c) {
            Iterator<dz> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dz next = it.next();
                if (next.c().equals(next.c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void f() {
        ExecutorService executorService = this.o;
        if (executorService != null && !executorService.isShutdown()) {
            this.o.shutdownNow();
        }
        ExecutorService executorService2 = this.q;
        if (executorService2 != null && !executorService2.isShutdown()) {
            this.q.shutdownNow();
        }
        ed edVar = this.h;
        if (edVar != null) {
            if (edVar.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.e = null;
        }
        ej ejVar = this.m;
        if (ejVar != null) {
            ejVar.b();
        }
        ee eeVar = this.f;
        if (eeVar != null) {
            eeVar.g();
        }
        k = null;
        b = true;
        this.j = true;
        synchronized (this) {
            this.l = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private dz g(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.c) {
            for (dz dzVar : this.c) {
                if (!str.equals(dzVar.getCity())) {
                    if (str.equals(dzVar.getPinyin())) {
                    }
                }
                return dzVar;
            }
            return null;
        }
    }

    private dz h(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.c) {
            for (dz dzVar : this.c) {
                if (str.equals(dzVar.getCode())) {
                    return dzVar;
                }
            }
            return null;
        }
    }

    public final void d(String str) throws AMapException {
        dz g2 = g(str);
        if (str == null || str.length() <= 0 || g2 == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        f(g2);
    }

    public final void e(String str) throws AMapException {
        dz h2 = h(str);
        if (h2 != null) {
            f(h2);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void f(final dz dzVar) throws AMapException {
        g();
        if (dzVar != null) {
            if (this.q == null) {
                this.q = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hq("AMapOfflineDownload"), new ThreadPoolExecutor.AbortPolicy());
            }
            try {
                this.q.execute(new Runnable() {
                    /* class com.amap.api.col.stln3.ea.AnonymousClass3 */

                    public final void run() {
                        try {
                            if (ea.this.j) {
                                ea.this.g();
                                eb ebVar = (eb) new ec(ea.this.i, ea.d).c();
                                if (ebVar != null) {
                                    ea.this.j = false;
                                    if (ebVar.a()) {
                                        ea.this.c();
                                    }
                                }
                            }
                            dzVar.setVersion(ea.d);
                            dzVar.f();
                        } catch (AMapException e) {
                            e.printStackTrace();
                        } catch (Throwable th) {
                            rx.c(th, "OfflineDownloadManager", "startDownloadRunnable");
                        }
                    }
                });
            } catch (Throwable th) {
                rx.c(th, "startDownload", "downloadExcecRunnable");
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    public final void d(dz dzVar) {
        ej ejVar = this.m;
        if (ejVar != null) {
            ejVar.a(dzVar);
        }
    }

    public final void e(dz dzVar) {
        ej ejVar = this.m;
        if (ejVar != null) {
            ejVar.b(dzVar);
        }
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    /* compiled from: OfflineDownloadManager */
    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof dz) {
                    dz dzVar = (dz) obj;
                    String str = "OfflineMapHandler handleMessage CitObj  name: " + dzVar.getCity() + " complete: " + dzVar.getcompleteCode() + " status: " + dzVar.getState();
                    if (ea.this.l != null) {
                        ea.this.l.a(dzVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final String f(String str) {
        dz g2;
        if (str == null || (g2 = g(str)) == null) {
            return "";
        }
        return g2.getAdcode();
    }
}
