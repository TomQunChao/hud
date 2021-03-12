package com.amap.api.col.stln3;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/* compiled from: ApsManager */
public final class bp {
    static boolean g = false;
    private bt A = null;
    private boolean B = true;
    private String C = "";
    private final int D = 5000;
    private String E = "jsonp1";
    String a = null;
    b b = null;
    AMapLocation c = null;
    a d = null;
    Context e = null;
    uz f = null;
    HashMap<Messenger, Long> h = new HashMap<>();
    vz i = null;
    long j = 0;
    long k = 0;
    String l = null;
    AMapLocationClientOption m = null;
    AMapLocationClientOption n = new AMapLocationClientOption();
    ServerSocket o = null;
    boolean p = false;
    Socket q = null;
    boolean r = false;
    c s = null;
    private boolean t = false;
    private boolean u = false;
    private long v = 0;
    private long w = 0;
    private vc x = null;
    private long y = 0;
    private int z = 0;

    static /* synthetic */ void a(bp bpVar) {
        try {
            if (bpVar.z < vt.b()) {
                bpVar.z++;
                bpVar.f.e();
                bpVar.d.sendEmptyMessageDelayed(4, 2000);
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "doGpsFusion");
        }
    }

    static /* synthetic */ void a(bp bpVar, Messenger messenger) {
        try {
            bpVar.b(messenger);
            vt.f(bpVar.e);
            try {
                uz uzVar = bpVar.f;
                Context context = bpVar.e;
                uzVar.h();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            vu.a(th2, "ApsServiceCore", "doCallOtherSer");
        }
    }

    static /* synthetic */ void a(bp bpVar, Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (!bpVar.u) {
                        bpVar.u = true;
                        bpVar.b(messenger);
                        vt.f(bpVar.e);
                        try {
                            uz uzVar = bpVar.f;
                            Context context = bpVar.e;
                            uzVar.g();
                        } catch (Throwable th) {
                        }
                        bpVar.a(messenger);
                        if (vt.a(bpVar.y) && "1".equals(bundle.getString("isCacheLoc"))) {
                            bpVar.y = wc.b();
                            bpVar.f.e();
                        }
                        bpVar.h();
                    }
                }
            } catch (Throwable th2) {
                vu.a(th2, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    static /* synthetic */ void a(bp bpVar, Socket socket) {
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        String str2;
        Throwable th2;
        if (socket != null) {
            try {
                int i2 = vu.f;
                String str3 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    try {
                        bpVar.a(bufferedReader);
                        String g2 = bpVar.g();
                        vu.f = i2;
                        try {
                            bpVar.c(g2);
                            try {
                                bufferedReader.close();
                                socket.close();
                                return;
                            } catch (Throwable th3) {
                                vu.a(th3, "ApsServiceCore", "invokeSocketLocation part3");
                                return;
                            }
                        } catch (Throwable th4) {
                            vu.a(th4, "ApsServiceCore", "invokeSocketLocation part3");
                            return;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        try {
                            str3 = bpVar.E + "&&" + bpVar.E + "({'package':'" + bpVar.a + "','error_code':1,'error':'params error'})";
                            vu.a(th2, "ApsServiceCore", "invokeSocketLocation");
                            vu.f = i2;
                            try {
                                bpVar.c(str3);
                                try {
                                    bufferedReader.close();
                                    socket.close();
                                    return;
                                } catch (Throwable th6) {
                                    vu.a(th6, "ApsServiceCore", "invokeSocketLocation part3");
                                    return;
                                }
                            } catch (Throwable th7) {
                                vu.a(th7, "ApsServiceCore", "invokeSocketLocation part3");
                                return;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            vu.f = i2;
                            try {
                                bpVar.c(str3);
                                try {
                                    bufferedReader.close();
                                    socket.close();
                                } catch (Throwable th9) {
                                    th = th9;
                                    str = "ApsServiceCore";
                                    str2 = "invokeSocketLocation part3";
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                str = "ApsServiceCore";
                                str2 = "invokeSocketLocation part3";
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    bufferedReader = null;
                    vu.f = i2;
                    bpVar.c(str3);
                    bufferedReader.close();
                    socket.close();
                    throw th;
                }
            } catch (Throwable th12) {
                vu.a(th12, "ApsServiceCore", "invokeSocketLocation part4");
                return;
            }
        } else {
            return;
        }
        vu.a(th, str, str2);
        throw th;
        throw th;
    }

    static /* synthetic */ void b(bp bpVar) {
        uz uzVar;
        try {
            if (vt.e()) {
                uzVar = bpVar.f;
            } else {
                if (!wc.e(bpVar.e)) {
                    uzVar = bpVar.f;
                }
                bpVar.d.sendEmptyMessageDelayed(5, (long) (vt.d() * 1000));
            }
            uzVar.e();
            bpVar.d.sendEmptyMessageDelayed(5, (long) (vt.d() * 1000));
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "doOffFusion");
        }
    }

    static /* synthetic */ void b(bp bpVar, Messenger messenger) {
        bpVar.h.remove(messenger);
    }

    static /* synthetic */ void b(bp bpVar, Messenger messenger, Bundle bundle) {
        String str;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    AMapLocationClientOption b2 = bpVar.b(bundle);
                    if (bpVar.h.containsKey(messenger) && !b2.isOnceLocation()) {
                        if (wc.b() - bpVar.h.get(messenger).longValue() < 800) {
                            return;
                        }
                    }
                    AMapLocation aMapLocation = null;
                    if (!bpVar.B) {
                        bpVar.x = a(9, "init error : " + bpVar.C + "#0901");
                        bpVar.a(messenger, bpVar.x, bpVar.x.l(), 0);
                        vz.a((String) null, 2091);
                        return;
                    }
                    long b3 = wc.b();
                    long j2 = 0;
                    if (!wc.a(bpVar.x) || b3 - bpVar.w >= 600) {
                        vy vyVar = new vy();
                        vyVar.a(wc.b());
                        try {
                            bpVar.x = bpVar.f.d();
                            if (bpVar.x.getLocationType() == 6 || bpVar.x.getLocationType() == 5) {
                                j2 = bpVar.x.k();
                            }
                            vyVar.a(bpVar.x);
                            bpVar.x = bpVar.f.a(bpVar.x, new String[0]);
                        } catch (Throwable th) {
                            vz.a((String) null, 2081);
                            bpVar.x = a(8, "loc error : " + th.getMessage() + "#0801");
                            vu.a(th, "ApsServiceCore", "run part2");
                        }
                        vyVar.b(wc.b());
                        if (wc.a(bpVar.x)) {
                            bpVar.w = wc.b();
                        }
                        if (bpVar.x == null) {
                            bpVar.x = a(8, "loc is null#0801");
                        }
                        if (bpVar.x != null) {
                            String l2 = bpVar.x.l();
                            aMapLocation = bpVar.x.clone();
                            str = l2;
                        } else {
                            str = null;
                        }
                        try {
                            if (b2.isLocationCacheEnable() && bpVar.A != null) {
                                aMapLocation = bpVar.A.a(aMapLocation, str, b2.getLastLocationLifeCycle());
                            }
                        } catch (Throwable th2) {
                            vu.a(th2, "ApsServiceCore", "fixLastLocation");
                        }
                        bpVar.a(messenger, aMapLocation, str, j2);
                        vz.a(bpVar.e, vyVar);
                    } else {
                        bpVar.a(messenger, bpVar.x, bpVar.x.l(), 0);
                    }
                    bpVar.b(messenger);
                    if (vt.A()) {
                        bpVar.a(messenger);
                    }
                    if (vt.a(bpVar.y) && bpVar.x != null && (bpVar.x.getLocationType() == 2 || bpVar.x.getLocationType() == 4 || bpVar.x.getLocationType() == 9)) {
                        bpVar.y = wc.b();
                        bpVar.f.e();
                    }
                    bpVar.h();
                }
            } catch (Throwable th3) {
                vu.a(th3, "ApsServiceCore", "doLocation");
            }
        }
    }

    static /* synthetic */ void c(bp bpVar) {
        try {
            if (vt.a(bpVar.e, bpVar.v)) {
                bpVar.v = wc.a();
                bpVar.f.e();
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "doNGps");
        }
    }

    public bp(Context context) {
        this.e = context;
    }

    public final void a() {
        try {
            this.i = new vz();
            this.b = new b("amapLocCoreThread");
            this.b.setPriority(5);
            this.b.start();
            this.d = new a(this.b.getLooper());
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final Handler b() {
        return this.d;
    }

    public final void a(Intent intent) {
        a aVar;
        if ("true".equals(intent.getStringExtra("as")) && (aVar = this.d) != null) {
            aVar.sendEmptyMessageDelayed(9, 100);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ApsManager */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                bp.this.A = new bt(bp.this.e);
            } catch (Throwable th) {
                vu.a(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            bp.this.f = new uz();
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                vu.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    /* compiled from: ApsManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
            java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:459)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007b A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x009c A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c8 A[Catch:{ Throwable -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3 A[Catch:{ Throwable -> 0x00e2 }] */
        public final void handleMessage(android.os.Message r7) {
            /*
            // Method dump skipped, instructions count: 266
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bp.a.handleMessage(android.os.Message):void");
        }
    }

    /* access modifiers changed from: private */
    public static vc a(int i2, String str) {
        try {
            vc vcVar = new vc("");
            vcVar.setErrorCode(i2);
            vcVar.setLocationDetail(str);
            return vcVar;
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    private void a(Messenger messenger) {
        try {
            if (vt.d(this.e)) {
                a(messenger, 100, (Bundle) null);
            }
            this.d.removeMessages(4);
            if (vt.a()) {
                this.d.sendEmptyMessage(4);
            }
            this.d.removeMessages(5);
            if (vt.c() && vt.d() > 2) {
                this.d.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "checkConfig");
        }
    }

    private void b(Messenger messenger) {
        try {
            uz uzVar = this.f;
            uz.b(this.e);
            if (vt.q()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("ngpsAble", vt.s());
                a(messenger, 7, bundle);
                vt.r();
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Bundle bundle) {
        try {
            if (!this.t) {
                vu.a(this.e);
                if (bundle != null) {
                    this.n = vu.a(bundle.getBundle("optBundle"));
                }
                this.f.a(this.e);
                this.f.a();
                a(this.n);
                this.f.b();
                this.t = true;
                this.B = true;
                this.C = "";
            }
        } catch (Throwable th) {
            this.B = false;
            this.C = th.getMessage();
            vu.a(th, "ApsServiceCore", "init");
        }
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.f != null) {
                this.f.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (this.m != null) {
                    if (aMapLocationClientOption.isOffset() == this.m.isOffset()) {
                        if (aMapLocationClientOption.isNeedAddress() == this.m.isNeedAddress()) {
                            if (aMapLocationClientOption.isLocationCacheEnable() == this.m.isLocationCacheEnable()) {
                                if (this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                                }
                            }
                        }
                    }
                    this.w = 0;
                    this.c = null;
                }
                this.m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "setExtra");
        }
    }

    public final void c() {
        try {
            if (!this.r) {
                this.s = new c();
                this.s.start();
                this.r = true;
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "startSocket");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ApsManager */
    public class c extends Thread {
        c() {
        }

        public final void run() {
            try {
                if (!bp.this.p) {
                    bp.this.p = true;
                    bp.this.o = new ServerSocket(43689);
                }
                while (bp.this.p && bp.this.o != null) {
                    bp.this.q = bp.this.o.accept();
                    bp.a(bp.this, bp.this.q);
                }
            } catch (Throwable th) {
                vu.a(th, "ApsServiceCore", "run");
            }
            super.run();
        }
    }

    public final void d() {
        try {
            if (this.q != null) {
                this.q.close();
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "doStopScocket 1");
        }
        try {
            if (this.o != null) {
                this.o.close();
            }
        } catch (Throwable th2) {
            vu.a(th2, "ApsServiceCore", "doStopScocket 2");
        }
        try {
            if (this.s != null) {
                this.s.interrupt();
            }
        } catch (Throwable th3) {
        }
        this.s = null;
        this.o = null;
        this.p = false;
        this.r = false;
    }

    private void a(BufferedReader bufferedReader) throws Exception {
        String[] split;
        String[] split2;
        String[] split3;
        String readLine = bufferedReader.readLine();
        int i2 = 30000;
        if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
            int i3 = 30000;
            for (String str : split3) {
                String[] split4 = str.split("=");
                if (split4 != null && split4.length > 1) {
                    if ("to".equals(split4[0])) {
                        i3 = wc.h(split4[1]);
                    }
                    if ("callback".equals(split4[0])) {
                        this.E = split4[1];
                    }
                }
            }
            i2 = i3;
        }
        vu.f = i2;
    }

    private String g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (wc.e(this.e)) {
            return this.E + "&&" + this.E + "({'package':'" + this.a + "','error_code':36,'error':'app is background'})";
        }
        vc vcVar = this.x;
        if (vcVar == null || currentTimeMillis - vcVar.getTime() > 5000) {
            try {
                this.x = this.f.d();
            } catch (Throwable th) {
                vu.a(th, "ApsServiceCore", "getSocketLocResult");
            }
        }
        vc vcVar2 = this.x;
        if (vcVar2 == null) {
            return this.E + "&&" + this.E + "({'package':'" + this.a + "','error_code':8,'error':'unknown error'})";
        } else if (vcVar2.getErrorCode() != 0) {
            return this.E + "&&" + this.E + "({'package':'" + this.a + "','error_code':" + this.x.getErrorCode() + ",'error':'" + this.x.getErrorInfo() + "'})";
        } else {
            return this.E + "&&" + this.E + "({'package':'" + this.a + "','error_code':0,'error':'','location':{'y':" + this.x.getLatitude() + ",'precision':" + this.x.getAccuracy() + ",'x':" + this.x.getLongitude() + "},'version_code':'4.5.0','version':'4.5.0'})";
        }
    }

    private void c(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.q.getOutputStream(), true, "UTF-8");
        printStream.println("HTTP/1.0 200 OK");
        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    public final void e() {
        try {
            this.h.clear();
            this.h = null;
            if (this.f != null) {
                uz uzVar = this.f;
                uz.b(this.e);
            }
            if (this.d != null) {
                this.d.removeCallbacksAndMessages(null);
            }
            if (this.b != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        vx.a(this.b, HandlerThread.class, "quitSafely", new Object[0]);
                    } catch (Throwable th) {
                        this.b.quit();
                    }
                } else {
                    this.b.quit();
                }
            }
            this.b = null;
            this.d = null;
            if (this.A != null) {
                this.A.c();
                this.A = null;
            }
            d();
            this.t = false;
            this.u = false;
            this.f.f();
            vz.a(this.e);
            if (!(this.i == null || this.j == 0 || this.k == 0)) {
                long b2 = wc.b() - this.j;
                vz.a(this.e, this.i.c(this.e), this.i.d(this.e), this.k, b2);
                this.i.e(this.e);
            }
            rx.b();
            if (g) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            vu.a(th2, "ApsServiceCore", "threadDestroy");
        }
    }

    private void h() {
        try {
            if (this.f != null) {
                this.f.k();
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "startColl");
        }
    }

    private static void a(Messenger messenger, int i2, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i2;
                messenger.send(obtain);
            } catch (Throwable th) {
                vu.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Messenger messenger, AMapLocation aMapLocation, String str, long j2) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putLong("netUseTime", j2);
        this.h.put(messenger, Long.valueOf(wc.b()));
        a(messenger, 1, bundle);
    }

    private AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption a2 = vu.a(bundle.getBundle("optBundle"));
        a(a2);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                rd.a(string);
            }
        } catch (Throwable th) {
            vu.a(th, "APSManager", "parseBundle");
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Messenger messenger, Bundle bundle) {
        float f2;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (vt.x()) {
                        double d2 = bundle.getDouble("lat");
                        double d3 = bundle.getDouble("lon");
                        b(bundle);
                        if (this.c != null) {
                            f2 = wc.a(new double[]{d2, d3, this.c.getLatitude(), this.c.getLongitude()});
                            if (f2 < ((float) (vt.y() * 3))) {
                                Bundle bundle2 = new Bundle();
                                bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                                bundle2.putInt("I_MAX_GEO_DIS", vt.y() * 3);
                                bundle2.putInt("I_MIN_GEO_DIS", vt.y());
                                bundle2.putParcelable("loc", this.c);
                                a(messenger, 6, bundle2);
                            }
                        } else {
                            f2 = -1.0f;
                        }
                        if (f2 != -1.0f) {
                            if (f2 <= ((float) vt.y())) {
                                return;
                            }
                        }
                        a(bundle);
                        this.c = this.f.a(d2, d3);
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(this.l)) {
            this.l = vu.b(this.e);
        }
        if (TextUtils.isEmpty(str) || !str.equals(this.l)) {
            return false;
        }
        return true;
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            qz.a(this.e, stringExtra);
        }
        this.a = intent.getStringExtra("b");
        qy.a(this.a);
        String stringExtra2 = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra2)) {
            rd.a(stringExtra2);
        }
        vt.a = intent.getBooleanExtra("f", true);
    }

    public static void f() {
        g = false;
    }
}
