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
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: CgiManager */
public final class vg {
    int a = 0;
    ArrayList<vf> b = new ArrayList<>();
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
    private ArrayList<vf> n = new ArrayList<>();
    private int o = -113;
    private ve p = null;
    private Object q;
    private int r = 0;
    private long s = 0;
    private boolean t = false;
    private Object u = new Object();

    static /* synthetic */ void a(vg vgVar, int i2) {
        if (i2 == -113) {
            vgVar.o = -113;
            return;
        }
        vgVar.o = i2;
        switch (vgVar.a) {
            case 1:
            case 2:
                ArrayList<vf> arrayList = vgVar.b;
                if (arrayList != null && !arrayList.isEmpty()) {
                    try {
                        vgVar.b.get(0).j = vgVar.o;
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

    public vg(Context context) {
        Object a2;
        this.l = context;
        if (this.c == null) {
            this.c = (TelephonyManager) wc.a(this.l, "phone");
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
                vu.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                this.r = r();
                switch (this.r) {
                    case 1:
                        a2 = wc.a(this.l, "phone_msim");
                        break;
                    case 2:
                        a2 = wc.a(this.l, "phone2");
                        break;
                    default:
                        a2 = wc.a(this.l, "phone2");
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
        this.p = new ve();
    }

    public final ArrayList<vf> a() {
        return this.b;
    }

    public final ArrayList<vf> b() {
        return this.n;
    }

    public final vf c() {
        if (this.i) {
            return null;
        }
        ArrayList<vf> arrayList = this.b;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public final vf d() {
        if (this.i) {
            return null;
        }
        ArrayList<vf> arrayList = this.n;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.a & 3;
    }

    private CellLocation n() {
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
                vu.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    public final TelephonyManager g() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019e, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019f, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02bc, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02bd, code lost:
        r9.h = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02c3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e7, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e8, code lost:
        if (r10 != false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0175, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0176, code lost:
        com.amap.api.col.stln3.vu.a(r10, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x026b A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:89:0x0183] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02bc A[ExcHandler: SecurityException (r10v1 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x008d A[EDGE_INSN: B:170:0x008d->B:41:0x008d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[Catch:{ SecurityException -> 0x02bc, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[Catch:{ SecurityException -> 0x02bc, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[Catch:{ SecurityException -> 0x02bc, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021 A[Catch:{ SecurityException -> 0x02bc, Throwable -> 0x02b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 724
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vg.a(boolean, boolean):void");
    }

    public final void h() {
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
                vu.a(th, "CgiManager", "destroy");
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
    public final boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        Context context = this.l;
        switch (c(cellLocation)) {
            case 1:
                try {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
                } catch (Throwable th) {
                    vu.a(th, "CgiManager", "cgiUseful Cgi.I_GSM_T");
                    return true;
                }
            case 2:
                try {
                    if (vx.b(cellLocation, "getSystemId", new Object[0]) <= 0 || vx.b(cellLocation, "getNetworkId", new Object[0]) < 0 || vx.b(cellLocation, "getBaseStationId", new Object[0]) < 0) {
                        return false;
                    }
                    return true;
                } catch (Throwable th2) {
                    vu.a(th2, "CgiManager", "cgiUseful Cgi.I_CDMA_T");
                    return true;
                }
            default:
                return true;
        }
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private static boolean a(int i2, int i3) {
        if (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) {
            return false;
        }
        return true;
    }

    private void a(CellLocation cellLocation, String[] strArr, boolean z) {
        List<NeighboringCellInfo> neighboringCellInfo;
        vf a2;
        if (!(cellLocation == null || this.c == null)) {
            this.b.clear();
            if (b(cellLocation)) {
                this.a = 1;
                ArrayList<vf> arrayList = this.b;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                vf vfVar = new vf(1, true);
                vfVar.a = wc.h(strArr[0]);
                vfVar.b = wc.h(strArr[1]);
                vfVar.c = gsmCellLocation.getLac();
                vfVar.d = gsmCellLocation.getCid();
                vfVar.j = this.o;
                arrayList.add(vfVar);
                if (!z && (neighboringCellInfo = this.c.getNeighboringCellInfo()) != null && !neighboringCellInfo.isEmpty()) {
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (neighboringCellInfo2 != null && a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid()) && (a2 = a(neighboringCellInfo2, strArr)) != null && !this.b.contains(a2)) {
                            this.b.add(a2);
                        }
                    }
                }
            }
        }
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        CellLocation cellLocation;
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = vx.a(obj, str, objArr);
            if (a2 != null) {
                cellLocation = (CellLocation) a2;
            } else {
                cellLocation = null;
            }
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable th) {
        }
    }

    @SuppressLint({"NewApi"})
    private CellLocation o() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation n2 = n();
        if (b(n2)) {
            return n2;
        }
        if (wc.c() >= 18) {
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
            return a3;
        }
        return a3;
    }

    private CellLocation p() {
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> q2 = q();
            if (q2.isInstance(obj)) {
                Object cast = q2.cast(obj);
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
            vu.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> q() {
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
            vu.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[RETURN] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.telephony.CellLocation a(java.util.List<android.telephony.CellInfo> r11) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vg.a(java.util.List):android.telephony.CellLocation");
    }

    private static vf a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            vf vfVar = new vf(1, false);
            vfVar.a = Integer.parseInt(strArr[0]);
            vfVar.b = Integer.parseInt(strArr[1]);
            vfVar.c = vx.b(neighboringCellInfo, "getLac", new Object[0]);
            vfVar.d = neighboringCellInfo.getCid();
            vfVar.j = wc.a(neighboringCellInfo.getRssi());
            return vfVar;
        } catch (Throwable th) {
            vu.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.h = null;
        this.e = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    private int r() {
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

    public final String j() {
        return this.h;
    }

    public final String k() {
        return this.m;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityCdma cellIdentityCdma) {
        if (cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityGsm cellIdentityGsm) {
        if (cellIdentityGsm != null && a(cellIdentityGsm.getLac()) && b(cellIdentityGsm.getCid())) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityWcdma cellIdentityWcdma) {
        if (cellIdentityWcdma != null && a(cellIdentityWcdma.getLac()) && b(cellIdentityWcdma.getCid())) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(CellIdentityLte cellIdentityLte) {
        if (cellIdentityLte != null && a(cellIdentityLte.getTac()) && b(cellIdentityLte.getCi())) {
            return true;
        }
        return false;
    }

    private static boolean a(int i2) {
        if (i2 == -1 || i2 == 0 || i2 > 65535) {
            return false;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private static vf a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static vf a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        return a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static vf a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        return a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
    }

    private static vf a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        vf vfVar = new vf(i2, z);
        vfVar.a = i3;
        vfVar.b = i4;
        vfVar.c = i5;
        vfVar.d = i6;
        vfVar.j = i7;
        return vfVar;
    }

    @SuppressLint({"NewApi"})
    private vf a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a2 = wc.a(this.c);
        try {
            i4 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
                i3 = i4;
            } catch (Throwable th) {
                i3 = i4;
                i2 = 0;
                vf a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
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
            vf a32 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a32.g = cellIdentity.getSystemId();
            a32.h = cellIdentity.getNetworkId();
            a32.i = cellIdentity.getBasestationId();
            a32.e = cellIdentity.getLatitude();
            a32.f = cellIdentity.getLongitude();
            return a32;
        }
        vf a322 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a322.g = cellIdentity.getSystemId();
        a322.h = cellIdentity.getNetworkId();
        a322.i = cellIdentity.getBasestationId();
        a322.e = cellIdentity.getLatitude();
        a322.f = cellIdentity.getLongitude();
        return a322;
    }

    private static boolean b(int i2) {
        if (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) {
            return false;
        }
        return true;
    }

    public final String l() {
        if (this.i) {
            i();
        }
        StringBuilder sb = this.j;
        if (sb == null) {
            this.j = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if ((this.a & 3) == 1) {
            for (int i2 = 1; i2 < this.b.size(); i2++) {
                StringBuilder sb2 = this.j;
                sb2.append("#");
                sb2.append(this.b.get(i2).b);
                StringBuilder sb3 = this.j;
                sb3.append("|");
                sb3.append(this.b.get(i2).c);
                StringBuilder sb4 = this.j;
                sb4.append("|");
                sb4.append(this.b.get(i2).d);
            }
        }
        if (this.j.length() > 0) {
            this.j.deleteCharAt(0);
        }
        return this.j.toString();
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
            vu.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    public final boolean m() {
        try {
            if (this.c != null && (!TextUtils.isEmpty(this.c.getSimOperator()) || !TextUtils.isEmpty(this.c.getSimCountryIso()))) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            int a2 = wc.a(wc.c(this.l));
            if (a2 == 0 || a2 == 4 || a2 == 2 || a2 == 5 || a2 == 3) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    /* compiled from: CgiManager */
    class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (vg.this.u) {
                    if (!vg.this.t) {
                        vg vgVar = vg.this;
                        vgVar.g = new PhoneStateListener() {
                            /* class com.amap.api.col.stln3.vg.AnonymousClass1 */

                            public final void onCellLocationChanged(CellLocation cellLocation) {
                                try {
                                    if (vg.this.a(cellLocation)) {
                                        vg.this.e = cellLocation;
                                        vg.this.f = true;
                                        vg.this.s = wc.b();
                                    }
                                } catch (Throwable th) {
                                }
                            }

                            public final void onSignalStrengthChanged(int i) {
                                int i2 = -113;
                                try {
                                    switch (vg.this.a) {
                                        case 1:
                                            i2 = wc.a(i);
                                            break;
                                        case 2:
                                            i2 = wc.a(i);
                                            break;
                                    }
                                    vg.a(vg.this, i2);
                                } catch (Throwable th) {
                                }
                            }

                            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                                if (signalStrength != null) {
                                    int i = -113;
                                    try {
                                        switch (vg.this.a) {
                                            case 1:
                                                i = wc.a(signalStrength.getGsmSignalStrength());
                                                break;
                                            case 2:
                                                i = signalStrength.getCdmaDbm();
                                                break;
                                        }
                                        vg.a(vg.this, i);
                                    } catch (Throwable th) {
                                    }
                                }
                            }

                            public final void onServiceStateChanged(ServiceState serviceState) {
                                try {
                                    switch (serviceState.getState()) {
                                        case 0:
                                            vg.this.a(false, false);
                                            return;
                                        case 1:
                                            vg.this.i();
                                            return;
                                        default:
                                            return;
                                    }
                                } catch (Throwable th) {
                                }
                            }
                        };
                        int i = 0;
                        if (wc.c() < 7) {
                            try {
                                i = vx.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTH");
                            } catch (Throwable th) {
                            }
                        } else {
                            i = vx.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
                        }
                        if (i == 0) {
                            try {
                                vgVar.c.listen(vgVar.g, 16);
                            } catch (Throwable th2) {
                            }
                        } else {
                            vgVar.c.listen(vgVar.g, 16 | i);
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
}
