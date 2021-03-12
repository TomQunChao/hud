package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: CgiManager */
public final class ws {
    int a = 0;
    ArrayList<wr> b = new ArrayList<>();
    TelephonyManager c = null;
    long d = 0;
    CellLocation e;
    boolean f = false;
    PhoneStateListener g = null;
    String h = null;
    boolean i = false;
    StringBuilder j = null;
    HandlerThread k = null;
    private Context l;
    private String m = null;
    private ArrayList<wr> n = new ArrayList<>();
    private int o = -113;
    private wq p = null;
    private Object q;
    private int r = 0;
    private long s = 0;
    private boolean t = false;
    private Object u = new Object();

    /* compiled from: CgiManager */
    class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (ws.this.u) {
                    if (!ws.this.t) {
                        ws wsVar = ws.this;
                        wsVar.g = new PhoneStateListener() {
                            /* class com.amap.api.col.stln3.ws.AnonymousClass1 */

                            public final void onCellLocationChanged(CellLocation cellLocation) {
                                try {
                                    if (ws.this.a(cellLocation)) {
                                        ws.this.e = cellLocation;
                                        ws.this.f = true;
                                        ws.this.s = xb.b();
                                    }
                                } catch (Throwable th) {
                                }
                            }

                            public final void onServiceStateChanged(ServiceState serviceState) {
                                try {
                                    switch (serviceState.getState()) {
                                        case 0:
                                            ws.this.b();
                                            return;
                                        case 1:
                                            ws.this.d();
                                            return;
                                        default:
                                            return;
                                    }
                                } catch (Throwable th) {
                                }
                            }

                            public final void onSignalStrengthChanged(int i) {
                                int i2 = -113;
                                try {
                                    switch (ws.this.a) {
                                        case 1:
                                        case 2:
                                            i2 = xb.a(i);
                                            break;
                                    }
                                    ws.a(ws.this, i2);
                                } catch (Throwable th) {
                                }
                            }

                            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                                if (signalStrength != null) {
                                    int i = -113;
                                    try {
                                        switch (ws.this.a) {
                                            case 1:
                                                i = xb.a(signalStrength.getGsmSignalStrength());
                                                break;
                                            case 2:
                                                i = signalStrength.getCdmaDbm();
                                                break;
                                        }
                                        ws.a(ws.this, i);
                                    } catch (Throwable th) {
                                    }
                                }
                            }
                        };
                        int i = 0;
                        try {
                            i = wz.b("android.telephony.PhoneStateListener", xb.c() < 7 ? "LISTEN_SIGNAL_STRENGTH" : "LISTEN_SIGNAL_STRENGTHS");
                        } catch (Throwable th) {
                        }
                        if (i == 0) {
                            try {
                                wsVar.c.listen(wsVar.g, 16);
                            } catch (Throwable th2) {
                            }
                        } else {
                            wsVar.c.listen(wsVar.g, 16 | i);
                        }
                    }
                }
            } catch (Throwable th3) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    public ws(Context context) {
        Object a2;
        this.l = context;
        if (this.c == null) {
            this.c = (TelephonyManager) xb.a(this.l, "phone");
        }
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                Context context2 = this.l;
                this.a = c(cellLocation);
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                wy.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                this.r = j();
                switch (this.r) {
                    case 1:
                        a2 = xb.a(this.l, "phone_msim");
                        break;
                    case 2:
                        a2 = xb.a(this.l, "phone2");
                        break;
                    default:
                        a2 = xb.a(this.l, "phone2");
                        break;
                }
                this.q = a2;
            } catch (Throwable th2) {
            }
            if (this.k == null) {
                this.k = new a("listenerPhoneStateThread");
                this.k.start();
            }
        }
        this.p = new wq();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = wz.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        r11 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b1 A[RETURN] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.telephony.CellLocation a(java.util.List<android.telephony.CellInfo> r11) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ws.a(java.util.List):android.telephony.CellLocation");
    }

    private static wr a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        wr wrVar = new wr(i2, z);
        wrVar.a = i3;
        wrVar.b = i4;
        wrVar.c = i5;
        wrVar.d = i6;
        wrVar.j = i7;
        return wrVar;
    }

    @SuppressLint({"NewApi"})
    private wr a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a2 = xb.a(this.c);
        try {
            i4 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
                i3 = i4;
            } catch (Throwable th) {
                i3 = i4;
                i2 = 0;
                wr a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a3.g = cellIdentity.getSystemId();
                a3.h = cellIdentity.getNetworkId();
                a3.i = cellIdentity.getBasestationId();
                a3.e = cellIdentity.getLatitude();
                a3.f = cellIdentity.getLongitude();
                return a3;
            }
        } catch (Throwable th2) {
            i4 = 0;
            i3 = i4;
            i2 = 0;
            wr a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a32.g = cellIdentity.getSystemId();
            a32.h = cellIdentity.getNetworkId();
            a32.i = cellIdentity.getBasestationId();
            a32.e = cellIdentity.getLatitude();
            a32.f = cellIdentity.getLongitude();
            return a32;
        }
        wr a322 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a322.g = cellIdentity.getSystemId();
        a322.h = cellIdentity.getNetworkId();
        a322.i = cellIdentity.getBasestationId();
        a322.e = cellIdentity.getLatitude();
        a322.f = cellIdentity.getLongitude();
        return a322;
    }

    @SuppressLint({"NewApi"})
    private static wr a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static wr a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        return a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static wr a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        return a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
    }

    private static wr a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            wr wrVar = new wr(1, false);
            wrVar.a = Integer.parseInt(strArr[0]);
            wrVar.b = Integer.parseInt(strArr[1]);
            wrVar.c = wz.b(neighboringCellInfo, "getLac", new Object[0]);
            wrVar.d = neighboringCellInfo.getCid();
            wrVar.j = xb.a(neighboringCellInfo.getRssi());
            return wrVar;
        } catch (Throwable th) {
            wy.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void a(CellLocation cellLocation, String[] strArr) {
        wr a2;
        if (!(cellLocation == null || this.c == null)) {
            this.b.clear();
            if (b(cellLocation)) {
                this.a = 1;
                ArrayList<wr> arrayList = this.b;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                wr wrVar = new wr(1, true);
                wrVar.a = xb.d(strArr[0]);
                wrVar.b = xb.d(strArr[1]);
                wrVar.c = gsmCellLocation.getLac();
                wrVar.d = gsmCellLocation.getCid();
                wrVar.j = this.o;
                arrayList.add(wrVar);
                List<NeighboringCellInfo> neighboringCellInfo = this.c.getNeighboringCellInfo();
                if (!(neighboringCellInfo == null || neighboringCellInfo.isEmpty())) {
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (neighboringCellInfo2 != null && a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid()) && (a2 = a(neighboringCellInfo2, strArr)) != null && !this.b.contains(a2)) {
                            this.b.add(a2);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(ws wsVar, int i2) {
        if (i2 == -113) {
            wsVar.o = -113;
            return;
        }
        wsVar.o = i2;
        switch (wsVar.a) {
            case 1:
            case 2:
                ArrayList<wr> arrayList = wsVar.b;
                if (arrayList != null && !arrayList.isEmpty()) {
                    try {
                        wsVar.b.get(0).j = wsVar.o;
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private static boolean a(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && a(cellIdentityGsm.getLac()) && b(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && a(cellIdentityLte.getTac()) && b(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && a(cellIdentityWcdma.getLac()) && b(cellIdentityWcdma.getCid());
    }

    private static boolean b(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.i || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            wy.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private CellLocation f() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.h = null;
                if (b(cellLocation)) {
                    this.e = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                wy.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation g() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation f2 = f();
        if (b(f2)) {
            return f2;
        }
        if (xb.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        CellLocation a3 = a(telephonyManager, "getCellLocationGemini", 1);
        if (a3 != null) {
        }
        return a3;
    }

    private CellLocation h() {
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> i2 = i();
            if (i2.isInstance(obj)) {
                Object cast = i2.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            wy.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> i() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (this.r) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            wy.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private int j() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable th) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable th2) {
            }
        }
        return this.r;
    }

    public final ArrayList<wr> a() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(CellLocation cellLocation) {
        Throwable th;
        String str;
        String str2;
        if (cellLocation == null) {
            return false;
        }
        Context context = this.l;
        switch (c(cellLocation)) {
            case 1:
                try {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "CgiManager";
                    str = "cgiUseful Cgi.I_GSM_T";
                    break;
                }
            case 2:
                try {
                    return wz.b(cellLocation, "getSystemId", new Object[0]) > 0 && wz.b(cellLocation, "getNetworkId", new Object[0]) >= 0 && wz.b(cellLocation, "getBaseStationId", new Object[0]) >= 0;
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "CgiManager";
                    str = "cgiUseful Cgi.I_CDMA_T";
                    break;
                }
            default:
                return true;
        }
        wy.a(th, str2, str);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:154:0x029b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x029c, code lost:
        r12.h = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c8, code lost:
        if (r5 == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0155, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0156, code lost:
        com.amap.api.col.stln3.wy.a(r0, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0182, code lost:
        r4 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x024b A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:76:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x029b A[ExcHandler: SecurityException (r0v0 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[Catch:{ SecurityException -> 0x029b, Throwable -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046 A[Catch:{ SecurityException -> 0x029b, Throwable -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[Catch:{ SecurityException -> 0x029b, Throwable -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[Catch:{ SecurityException -> 0x029b, Throwable -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ SecurityException -> 0x029b, Throwable -> 0x0292 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0199  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
        // Method dump skipped, instructions count: 692
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ws.b():void");
    }

    public final void c() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0;
        synchronized (this.u) {
            this.t = true;
        }
        TelephonyManager telephonyManager = this.c;
        if (!(telephonyManager == null || (phoneStateListener = this.g) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                wy.a(th, "CgiManager", "destroy");
            }
        }
        this.g = null;
        HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.k = null;
        }
        this.o = -113;
        this.c = null;
        this.q = null;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.h = null;
        this.e = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String e() {
        return this.m;
    }
}
