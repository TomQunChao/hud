package com.amap.api.col.stln3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AmapLocationManager */
public class bo implements LocationManagerBase {
    private volatile boolean A = false;
    private boolean B = true;
    private boolean C = true;
    private bs D = null;
    private ServiceConnection E = new ServiceConnection() {
        /* class com.amap.api.col.stln3.bo.AnonymousClass1 */

        public final void onServiceDisconnected(ComponentName componentName) {
            bo boVar = bo.this;
            boVar.h = null;
            boVar.z = false;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                bo.this.h = new Messenger(iBinder);
                bo.this.z = true;
                bo.this.q = true;
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "onServiceConnected");
            }
        }
    };
    AMapLocationClientOption a = new AMapLocationClientOption();
    public c b;
    br c = null;
    ArrayList<AMapLocationListener> d = new ArrayList<>();
    boolean e = false;
    public boolean f = true;
    bt g;
    Messenger h = null;
    Messenger i = null;
    Intent j = null;
    int k = 0;
    b l = null;
    boolean m = false;
    AMapLocationClientOption.AMapLocationMode n = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    Object o = new Object();
    vz p = null;
    boolean q = false;
    bp r = null;
    String s = null;
    boolean t = false;
    boolean u = false;
    a v = null;
    String w = null;
    boolean x = false;
    private Context y;
    private boolean z = false;

    static /* synthetic */ void a(bo boVar) {
        boolean z2;
        try {
            boolean z3 = true;
            if (boVar.y.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                z2 = true;
            } else if (boVar.y instanceof Activity) {
                z2 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (z3) {
                AlertDialog.Builder builder = new AlertDialog.Builder(boVar.y);
                builder.setMessage(vt.f());
                if (!"".equals(vt.g()) && vt.g() != null) {
                    builder.setPositiveButton(vt.g(), new DialogInterface.OnClickListener() {
                        /* class com.amap.api.col.stln3.bo.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            bo.this.c();
                            dialogInterface.cancel();
                        }
                    });
                }
                builder.setNegativeButton(vt.h(), new DialogInterface.OnClickListener() {
                    /* class com.amap.api.col.stln3.bo.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog create = builder.create();
                if (z2) {
                    create.getWindow().setType(2003);
                }
                create.setCanceledOnTouchOutside(false);
                create.show();
                return;
            }
            boVar.c();
        } catch (Throwable th) {
            boVar.c();
            vu.a(th, "AmapLocationManager", "showDialog");
        }
    }

    static /* synthetic */ void a(bo boVar, Bundle bundle) {
        AMapLocation aMapLocation;
        AMapLocation aMapLocation2;
        long j2 = 0;
        Throwable th = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation2 = (AMapLocation) bundle.getParcelable("loc");
                boVar.w = bundle.getString("nb");
                j2 = bundle.getLong("netUseTime", 0);
                if (!(aMapLocation2 == null || aMapLocation2.getErrorCode() != 0 || boVar.c == null)) {
                    boVar.c.c();
                    if (!TextUtils.isEmpty(aMapLocation2.getAdCode())) {
                        boVar.c.A = aMapLocation2;
                    }
                }
            } catch (Throwable th2) {
                vu.a(th2, "AmapLocationManager", "resultLbsLocationSuccess");
                th = th2;
                aMapLocation = null;
            }
        } else {
            aMapLocation2 = null;
        }
        aMapLocation = boVar.c != null ? boVar.c.a(aMapLocation2, boVar.w) : aMapLocation2;
        boVar.a(aMapLocation, th, j2);
    }

    static /* synthetic */ void a(bo boVar, Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (boVar.f && boVar.h != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", vu.a(boVar.a));
                boVar.a(0, bundle);
                boVar.f = false;
            }
            boVar.a(aMapLocation, (Throwable) null, 0);
            if (boVar.C) {
                boVar.a(7, (Bundle) null);
            }
            boVar.a(1025);
            boVar.a(1025, (Object) null, 300000);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "resultGpsLocationSuccess");
        }
    }

    static /* synthetic */ void a(bo boVar, AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (boVar.d == null) {
                boVar.d = new ArrayList<>();
            }
            if (!boVar.d.contains(aMapLocationListener)) {
                boVar.d.add(aMapLocationListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    static /* synthetic */ void b(bo boVar, Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            if (aMapLocation != null) {
                AMapLocation aMapLocation2 = null;
                try {
                    if (bt.b != null) {
                        aMapLocation2 = bt.b.a();
                    } else if (boVar.g != null) {
                        aMapLocation2 = boVar.g.b();
                    }
                    vz.a(aMapLocation2, aMapLocation);
                } catch (Throwable th) {
                }
            }
            if (boVar.g.a(aMapLocation, string)) {
                boVar.g.d();
            }
        } catch (Throwable th2) {
            vu.a(th2, "AmapLocationManager", "doSaveLastLocation");
        }
    }

    static /* synthetic */ void b(bo boVar, AMapLocationListener aMapLocationListener) {
        if (!boVar.d.isEmpty() && boVar.d.contains(aMapLocationListener)) {
            boVar.d.remove(aMapLocationListener);
        }
        if (boVar.d.isEmpty()) {
            boVar.e();
        }
    }

    static /* synthetic */ void c(bo boVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i2 = data.getInt("i", 0);
                    Intent h2 = boVar.h();
                    h2.putExtra("i", i2);
                    h2.putExtra("h", (Notification) data.getParcelable("h"));
                    h2.putExtra("g", 1);
                    boVar.a(h2, true);
                }
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "doEnableBackgroundLocation");
            }
        }
    }

    static /* synthetic */ void d(bo boVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z2 = data.getBoolean("j", true);
                    Intent h2 = boVar.h();
                    h2.putExtra("j", z2);
                    h2.putExtra("g", 2);
                    boVar.a(h2, false);
                }
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "doDisableBackgroundLocation");
            }
        }
    }

    static /* synthetic */ void f(bo boVar) {
        try {
            if (boVar.B) {
                boVar.B = false;
                vc b2 = boVar.b(new uz());
                if (boVar.b()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (b2 != null && (b2.getLocationType() == 2 || b2.getLocationType() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", vu.a(boVar.a));
                    bundle.putString("isCacheLoc", str);
                    boVar.a(0, bundle);
                }
            } else {
                try {
                    if (boVar.q && !boVar.isStarted() && !boVar.u) {
                        boVar.u = true;
                        boVar.g();
                    }
                } catch (Throwable th) {
                    boVar.u = true;
                    vu.a(th, "AmapLocationManager", "doLBSLocation reStartService");
                }
                if (boVar.b()) {
                    boVar.u = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", vu.a(boVar.a));
                    bundle2.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!boVar.c.b()) {
                        boVar.a(1, bundle2);
                    }
                }
            }
            try {
                if (!boVar.a.isOnceLocation()) {
                    boVar.f();
                    return;
                }
                return;
            } catch (Throwable th2) {
                return;
            }
        } catch (Throwable th3) {
            return;
        }
        throw th;
    }

    static /* synthetic */ void h(bo boVar) {
        int i2;
        Context context;
        vz vzVar;
        boVar.c.b(boVar.a);
        if (boVar.A && !boVar.a.getLocationMode().equals(boVar.n)) {
            boVar.e();
            boVar.d();
        }
        boVar.n = boVar.a.getLocationMode();
        if (boVar.p != null) {
            if (boVar.a.isOnceLocation()) {
                vzVar = boVar.p;
                context = boVar.y;
                i2 = 0;
            } else {
                vzVar = boVar.p;
                context = boVar.y;
                i2 = 1;
            }
            vzVar.a(context, i2);
            boVar.p.a(boVar.y, boVar.a);
        }
    }

    static /* synthetic */ void i(bo boVar) {
        try {
            if (boVar.h != null) {
                boVar.k = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", vu.a(boVar.a));
                boVar.a(2, bundle);
                return;
            }
            boVar.k++;
            if (boVar.k < 10) {
                boVar.a(1008, (Object) null, 50);
            }
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "startAssistantLocationImpl");
        }
    }

    static /* synthetic */ void j(bo boVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", vu.a(boVar.a));
            boVar.a(3, bundle);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "stopAssistantLocationImpl");
        }
    }

    public bo(Context context, Intent intent) {
        this.y = context;
        this.j = intent;
        if (vu.d()) {
            try {
                wa.a(this.y, vu.b());
            } catch (Throwable th) {
            }
        }
        try {
            this.b = Looper.myLooper() == null ? new c(this.y.getMainLooper()) : new c();
        } catch (Throwable th2) {
            vu.a(th2, "AmapLocationManager", "init 1");
        }
        try {
            this.g = new bt(this.y);
        } catch (Throwable th3) {
            vu.a(th3, "AmapLocationManager", "init 5");
        }
        this.l = new b("amapLocManagerThread", this);
        this.l.setPriority(5);
        this.l.start();
        this.v = a(this.l.getLooper());
        try {
            this.c = new br(this.y, this.b);
        } catch (Throwable th4) {
            vu.a(th4, "AmapLocationManager", "init 3");
        }
        if (this.p == null) {
            this.p = new vz();
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public boolean isStarted() {
        return this.z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, Object obj, long j2) {
        synchronized (this.o) {
            if (this.v != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.v.sendMessageDelayed(obtain, j2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2) {
        synchronized (this.o) {
            if (this.v != null) {
                this.v.removeMessages(i2);
            }
        }
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.o) {
            this.v = new a(looper);
            aVar = this.v;
        }
        return aVar;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            a(PointerIconCompat.TYPE_ZOOM_IN, aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "setLocationOption");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "setLocationListener");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            a(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT, aMapLocationListener, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "unRegisterLocationListener");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startLocation() {
        try {
            a(1003, (Object) null, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "startLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopLocation() {
        try {
            a(1004, (Object) null, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "stopLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void onDestroy() {
        try {
            if (this.D != null) {
                this.D.b();
                this.D = null;
            }
            a(1011, (Object) null, 0);
            this.m = true;
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "onDestroy");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public AMapLocation getLastKnownLocation() {
        AMapLocation aMapLocation = null;
        try {
            if (!(this.g == null || (aMapLocation = this.g.b()) == null)) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startAssistantLocation() {
        try {
            a(1008, (Object) null, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "startAssistantLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startAssistantLocation(WebView webView) {
        if (this.D == null) {
            this.D = new bs(this.y, webView);
        }
        this.D.a();
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopAssistantLocation() {
        try {
            if (this.D != null) {
                this.D.b();
                this.D = null;
            }
            a(1009, (Object) null, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "stopAssistantLocation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z2 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z2) {
                    this.h = null;
                    this.z = false;
                }
                vu.a(th, "AmapLocationManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = vu.b(this.y);
        }
        bundle.putString("c", this.s);
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.setData(bundle);
        obtain.replyTo = this.i;
        if (this.h != null) {
            this.h.send(obtain);
        }
    }

    private boolean b() {
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            try {
                if (this.h != null) {
                    break;
                }
                Thread.sleep(100);
                i2++;
                if (i2 >= 50) {
                    break;
                }
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "checkAPSManager");
            }
        }
        if (this.h == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (!wc.k(this.y.getApplicationContext())) {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            } else {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.b.sendMessage(obtain);
        } else {
            z2 = true;
        }
        if (!z2) {
            if (!wc.k(this.y.getApplicationContext())) {
                vz.a((String) null, 2103);
            } else {
                vz.a((String) null, (int) AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
            }
        }
        return z2;
    }

    /* compiled from: AmapLocationManager */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public c() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (!bo.this.m || vu.d()) {
                    int i = message.what;
                    if (i != 100) {
                        switch (i) {
                            case 1:
                                try {
                                    bo.a(bo.this, message.getData());
                                    return;
                                } catch (Throwable th) {
                                    vu.a(th, "AmapLocationManager$ActionHandler", "handleMessage RESULT_LBS_LOCATIONSUCCESS");
                                    return;
                                }
                            case 2:
                                break;
                            case 3:
                                return;
                            default:
                                switch (i) {
                                    case 5:
                                        try {
                                            Bundle data = message.getData();
                                            data.putBundle("optBundle", vu.a(bo.this.a));
                                            bo.this.a((bo) 10, data);
                                            return;
                                        } catch (Throwable th2) {
                                            vu.a(th2, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONCHANGE");
                                            return;
                                        }
                                    case 6:
                                        try {
                                            Bundle data2 = message.getData();
                                            if (bo.this.c != null) {
                                                bo.this.c.a(data2);
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th3) {
                                            vu.a(th3, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_GEO_SUCCESS");
                                            return;
                                        }
                                    case 7:
                                        try {
                                            Bundle data3 = message.getData();
                                            bo.this.C = data3.getBoolean("ngpsAble");
                                            return;
                                        } catch (Throwable th4) {
                                            vu.a(th4, "AmapLocationManager$ActionHandler", "handleMessage RESULT_NGPS_ABLE");
                                            return;
                                        }
                                    case 8:
                                        vz.a((String) null, 2141);
                                        break;
                                    default:
                                        return;
                                }
                        }
                        try {
                            bo.a(bo.this, message);
                        } catch (Throwable th5) {
                            vu.a(th5, "AmapLocationManager$ActionHandler", "handleMessage RESULT_GPS_LOCATIONSUCCESS");
                        }
                    } else {
                        try {
                            bo.a(bo.this);
                        } catch (Throwable th6) {
                            vu.a(th6, "AmapLocationManager$ActionHandler", "handleMessage RESULT_FASTSKY");
                        }
                    }
                }
            } catch (Throwable th7) {
                vu.a(th7, "AmapLocationManager$MainHandler", "handleMessage");
            }
        }
    }

    private void a(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if (!(latitude == 0.0d && longitude == 0.0d) && latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d) {
                    if (longitude > 180.0d) {
                    }
                }
                vz.a("errorLatLng", aMapLocation.toStr());
                aMapLocation.setLocationType(0);
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("LatLng is error#0802");
            }
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                if (this.c.b()) {
                    return;
                }
            }
            aMapLocation.setAltitude(wc.b(aMapLocation.getAltitude()));
            aMapLocation.setBearing(wc.a(aMapLocation.getBearing()));
            aMapLocation.setSpeed(wc.a(aMapLocation.getSpeed()));
            Iterator<AMapLocationListener> it = this.d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLocationChanged(aMapLocation);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    private synchronized void a(AMapLocation aMapLocation, Throwable th, long j2) {
        try {
            if (!vu.d() || aMapLocation != null) {
                if (aMapLocation == null) {
                    aMapLocation = new AMapLocation("");
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("amapLocation is null#0801");
                }
                if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                    aMapLocation.setProvider("lbs");
                }
                AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
                aMapLocationQualityReport.setLocationMode(this.a.getLocationMode());
                if (this.c != null) {
                    aMapLocationQualityReport.setGPSSatellites(this.c.e());
                    aMapLocationQualityReport.setGpsStatus(this.c.d());
                }
                aMapLocationQualityReport.setWifiAble(wc.g(this.y));
                aMapLocationQualityReport.setNetworkType(wc.h(this.y));
                if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                    j2 = 0;
                }
                aMapLocationQualityReport.setNetUseTime(j2);
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport);
                try {
                    if (this.A) {
                        String str = this.w;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("loc", aMapLocation);
                        bundle.putString("lastLocNb", str);
                        a(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, bundle, 0);
                        vz.a(this.y, aMapLocation);
                        vz.b(this.y, aMapLocation);
                        a(aMapLocation.clone());
                    }
                } catch (Throwable th2) {
                    vu.a(th2, "AmapLocationManager", "handlerLocation part2");
                }
                if (!this.m || vu.d()) {
                    wa.b(this.y);
                    if (this.a.isOnceLocation()) {
                        e();
                    }
                }
            } else if (th != null) {
                wa.a(this.y, "loc", th.getMessage());
            } else {
                wa.a(this.y, "loc", "amaplocation is null");
            }
        } catch (Throwable th3) {
            vu.a(th3, "AmapLocationManager", "handlerLocation part3");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", vt.k()));
            intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
            intent.setData(Uri.parse(vt.i()));
            this.y.startActivity(intent);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "callAMap part2");
        }
    }

    /* access modifiers changed from: private */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: public */
    private synchronized void d() {
        if (this.a == null) {
            this.a = new AMapLocationClientOption();
        }
        if (!this.A) {
            this.A = true;
            long j2 = 0;
            switch (this.a.getLocationMode()) {
                case Battery_Saving:
                    a(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, (Object) null, 0);
                    a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, 0);
                    return;
                case Device_Sensors:
                    a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                    a(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, (Object) null, 0);
                    return;
                case Hight_Accuracy:
                    a(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, (Object) null, 0);
                    if (this.a.isGpsFirst() && this.a.isOnceLocation()) {
                        j2 = this.a.getGpsFirstTimeout();
                    }
                    a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, j2);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        try {
            a(1025);
            if (this.c != null) {
                this.c.a();
            }
            a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            this.A = false;
            this.k = 0;
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "stopLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a(12, (Bundle) null);
        this.B = true;
        this.f = true;
        this.z = false;
        this.q = false;
        e();
        vz vzVar = this.p;
        if (vzVar != null) {
            vzVar.b(this.y);
        }
        vz.a(this.y);
        bp bpVar = this.r;
        if (bpVar != null) {
            bpVar.b().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.E;
            if (serviceConnection != null) {
                this.y.unbindService(serviceConnection);
            }
        }
        try {
            if (this.x) {
                this.y.stopService(h());
            }
        } catch (Throwable th) {
        }
        this.x = false;
        ArrayList<AMapLocationListener> arrayList = this.d;
        if (arrayList != null) {
            arrayList.clear();
            this.d = null;
        }
        this.E = null;
        synchronized (this.o) {
            if (this.v != null) {
                this.v.removeCallbacksAndMessages(null);
            }
            this.v = null;
        }
        if (this.l != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    vx.a(this.l, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable th2) {
                    this.l.quit();
                }
            } else {
                this.l.quit();
            }
        }
        this.l = null;
        c cVar = this.b;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        bt btVar = this.g;
        if (btVar != null) {
            btVar.c();
            this.g = null;
        }
    }

    private vc a(uz uzVar) {
        if (!this.a.isLocationCacheEnable()) {
            return null;
        }
        try {
            return uzVar.j();
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "doFirstCacheLoc");
            return null;
        }
    }

    private static void a(uz uzVar, vc vcVar) {
        if (vcVar != null) {
            try {
                if (vcVar.getErrorCode() == 0) {
                    uzVar.a(vcVar);
                }
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.col.stln3.vc b(com.amap.api.col.stln3.uz r14) {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bo.b(com.amap.api.col.stln3.uz):com.amap.api.col.stln3.vc");
    }

    private void f() {
        if (this.a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j2 = 1000;
            if (this.a.getInterval() >= 1000) {
                j2 = this.a.getInterval();
            }
            a(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, j2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: AmapLocationManager */
    public static class b extends HandlerThread {
        bo a = null;

        public b(String str, bo boVar) {
            super(str);
            this.a = boVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.a.g.a();
                this.a.g();
                super.onLooperPrepared();
            } catch (Throwable th) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        try {
            if (this.i == null) {
                this.i = new Messenger(this.b);
            }
            try {
                this.y.bindService(h(), this.E, 1);
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "startServiceImpl");
            }
        } catch (Throwable th2) {
        }
    }

    private Intent h() {
        if (this.j == null) {
            this.j = new Intent(this.y, APSService.class);
        }
        String str = "";
        try {
            if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
                str = AMapLocationClientOption.getAPIKEY();
            } else {
                str = qy.f(this.y);
            }
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "startServiceImpl p2");
        }
        this.j.putExtra("a", str);
        this.j.putExtra("b", qy.c(this.y));
        this.j.putExtra("d", UmidtokenInfo.getUmidtoken());
        this.j.putExtra("f", AMapLocationClientOption.isDownloadCoordinateConvertLibrary());
        return this.j;
    }

    /* compiled from: AmapLocationManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                switch (message.what) {
                    case 1002:
                        try {
                            bo.a(bo.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th) {
                            vu.a(th, "AMapLocationManage$MHandlerr", "handleMessage SET_LISTENER");
                            return;
                        }
                    case 1003:
                        try {
                            bo.this.d();
                            return;
                        } catch (Throwable th2) {
                            vu.a(th2, "AMapLocationManage$MHandlerr", "handleMessage START_LOCATION");
                            return;
                        }
                    case 1004:
                        try {
                            bo.this.e();
                            return;
                        } catch (Throwable th3) {
                            vu.a(th3, "AMapLocationManage$MHandlerr", "handleMessage STOP_LOCATION");
                            return;
                        }
                    case AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT /*{ENCODED_INT: 1005}*/:
                        try {
                            bo.b(bo.this, (AMapLocationListener) message.obj);
                            return;
                        } catch (Throwable th4) {
                            vu.a(th4, "AMapLocationManage$MHandlerr", "handleMessage REMOVE_LISTENER");
                            return;
                        }
                    case 1006:
                        return;
                    case 1007:
                        return;
                    case 1008:
                        try {
                            bo.i(bo.this);
                            return;
                        } catch (Throwable th5) {
                            vu.a(th5, "AMapLocationManage$MHandlerr", "handleMessage START_SOCKET");
                            return;
                        }
                    case 1009:
                        try {
                            bo.j(bo.this);
                            return;
                        } catch (Throwable th6) {
                            vu.a(th6, "AMapLocationManage$MHandlerr", "handleMessage STOP_SOCKET");
                            return;
                        }
                    case 1010:
                        return;
                    case 1011:
                        try {
                            bo.this.a();
                            return;
                        } catch (Throwable th7) {
                            vu.a(th7, "AMapLocationManage$MHandlerr", "handleMessage DESTROY");
                            return;
                        }
                    case 1012:
                    case 1013:
                    default:
                        return;
                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW:
                        bo.b(bo.this, message);
                        return;
                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW:
                        try {
                            bo.this.c.a(bo.this.a);
                            bo.this.a((bo) 1025, (int) null, 300000L);
                            return;
                        } catch (Throwable th8) {
                            vu.a(th8, "AMapLocationManage$MHandlerr", "handleMessage START_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW:
                        try {
                            if (bo.this.c.b()) {
                                bo.this.a((bo) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (int) null, 1000L);
                                return;
                            } else {
                                bo.f(bo.this);
                                return;
                            }
                        } catch (Throwable th9) {
                            vu.a(th9, "AMapLocationManage$MHandlerr", "handleMessage START_LBS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW:
                        try {
                            bo.this.c.a();
                            bo.this.a((bo) 1025);
                            return;
                        } catch (Throwable th10) {
                            vu.a(th10, "AMapLocationManage$MHandlerr", "handleMessage STOP_GPS_LOCATION");
                            return;
                        }
                    case PointerIconCompat.TYPE_ZOOM_IN:
                        try {
                            bo.this.a = (AMapLocationClientOption) message.obj;
                            if (bo.this.a != null) {
                                bo.h(bo.this);
                                return;
                            }
                            return;
                        } catch (Throwable th11) {
                            vu.a(th11, "AMapLocationManage$MHandlerr", "handleMessage SET_OPTION");
                            return;
                        }
                    case PointerIconCompat.TYPE_ZOOM_OUT:
                        return;
                    case PointerIconCompat.TYPE_GRAB:
                        return;
                    case 1021:
                        return;
                    case 1022:
                        return;
                    case 1023:
                        try {
                            bo.c(bo.this, message);
                            return;
                        } catch (Throwable th12) {
                            vu.a(th12, "AMapLocationManage$MHandlerr", "handleMessage ACTION_ENABLE_BACKGROUND");
                            return;
                        }
                    case 1024:
                        try {
                            bo.d(bo.this, message);
                            return;
                        } catch (Throwable th13) {
                            vu.a(th13, "AMapLocationManage$MHandlerr", "handleMessage ACTION_DISABLE_BACKGROUND");
                            return;
                        }
                    case 1025:
                        try {
                            if (bo.this.c != null) {
                                if (bo.this.c.f()) {
                                    bo.this.c.a();
                                    bo.this.c.a(bo.this.a);
                                }
                                bo.this.a((bo) 1025, (int) null, 300000L);
                                return;
                            }
                            return;
                        } catch (Throwable th14) {
                            vu.a(th14, "AMapLocationManage$MHandlerr", "handleMessage ACTION_REBOOT_GPS_LOCATION");
                            return;
                        }
                }
            } catch (Throwable th15) {
                vu.a(th15, "AMapLocationManage$MHandlerr", "handleMessage");
            }
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void enableBackgroundLocation(int i2, Notification notification) {
        if (i2 != 0 && notification != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("i", i2);
                bundle.putParcelable("h", notification);
                a(1023, bundle, 0);
            } catch (Throwable th) {
                vu.a(th, "AmapLocationManager", "disableBackgroundLocation");
            }
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void disableBackgroundLocation(boolean z2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z2);
            a(1024, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "AmapLocationManager", "disableBackgroundLocation");
        }
    }

    private void a(Intent intent, boolean z2) {
        if (this.y != null) {
            if (Build.VERSION.SDK_INT < 26 || !z2) {
                this.y.startService(intent);
            } else {
                try {
                    this.y.getClass().getMethod("startForegroundService", Intent.class).invoke(this.y, intent);
                } catch (Throwable th) {
                    this.y.startService(intent);
                }
            }
            this.x = true;
        }
    }
}
