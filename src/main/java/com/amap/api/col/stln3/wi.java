package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MapLocationManager */
public class wi implements Inner_3dMap_locationManagerBase {
    Context a = null;
    ArrayList<Inner_3dMap_locationListener> b = new ArrayList<>();
    Object c = new Object();
    Handler d = null;
    a e = null;
    Handler f = null;
    Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
    wm h = null;
    Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    boolean j = false;

    /* compiled from: MapLocationManager */
    static class a extends HandlerThread {
        wi a;

        public a(String str, wi wiVar) {
            super(str);
            this.a = wiVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.a.h = new wm(this.a.a, this.a.d);
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

    public wi(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
            try {
                this.d = Looper.myLooper() == null ? new wk(this.a.getMainLooper(), this) : new wk(this);
            } catch (Throwable th) {
                wy.a(th, "MapLocationManager", "initResultHandler");
            }
            try {
                this.e = new a("locaitonClientActionThread", this);
                this.e.setPriority(5);
                this.e.start();
                this.f = a(this.e.getLooper());
            } catch (Throwable th2) {
                wy.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private Handler a(Looper looper) {
        Handler handler;
        synchronized (this.c) {
            this.f = new wj(looper, this);
            handler = this.f;
        }
        return handler;
    }

    private void a(int i2) {
        synchronized (this.c) {
            if (this.f != null) {
                this.f.removeMessages(i2);
            }
        }
    }

    private void a(int i2, Object obj, long j2) {
        synchronized (this.c) {
            if (this.f != null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = obj;
                this.f.sendMessageDelayed(obtain, j2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            if (!this.j) {
                this.j = true;
                a(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT, null, 0);
            }
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.j) {
                if (!"GPS".equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                    inner_3dMap_location.setProvider("lbs");
                }
                inner_3dMap_location.setAltitude(xb.b(inner_3dMap_location.getAltitude()));
                inner_3dMap_location.setBearing(xb.a(inner_3dMap_location.getBearing()));
                inner_3dMap_location.setSpeed(xb.a(inner_3dMap_location.getSpeed()));
                Iterator<Inner_3dMap_locationListener> it = this.b.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(inner_3dMap_location);
                    } catch (Throwable th) {
                    }
                }
            }
            if (this.g.isOnceLocation()) {
                c();
            }
        } catch (Throwable th2) {
            wy.a(th2, "MapLocationManager", "callBackLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                if (!this.b.contains(inner_3dMap_locationListener)) {
                    this.b.add(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                wy.a(th, "MapLocationManager", "doSetLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.g = inner_3dMap_locationOption;
        if (this.g == null) {
            this.g = new Inner_3dMap_locationOption();
        }
        wm wmVar = this.h;
        if (wmVar != null) {
            wmVar.a(this.g);
        }
        if (this.j && !this.i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.i = this.g.getLocationMode();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        long j2 = 1000;
        try {
            if (this.h != null) {
                this.h.a();
            }
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT, null, j2);
            }
        } catch (Throwable th) {
            if (!this.g.isOnceLocation()) {
                if (this.g.getInterval() >= 1000) {
                    j2 = this.g.getInterval();
                }
                a(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT, null, j2);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.b.isEmpty() && this.b.contains(inner_3dMap_locationListener)) {
                    this.b.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                wy.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.b.isEmpty()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            this.j = false;
            a(1004);
            a(AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT);
            if (this.h != null) {
                this.h.c();
            }
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        c();
        wm wmVar = this.h;
        if (wmVar != null) {
            wmVar.d();
        }
        ArrayList<Inner_3dMap_locationListener> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
        synchronized (this.c) {
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }
        if (this.e != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    wz.a(this.e, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable th) {
                }
            }
            this.e.quit();
        }
        this.e = null;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void destroy() {
        try {
            a(1007, null, 0);
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0);
        } catch (Throwable th) {
            wy.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void startLocation() {
        try {
            a(1004, null, 0);
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "startLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void stopLocation() {
        try {
            a(1006, null, 0);
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0);
        } catch (Throwable th) {
            wy.a(th, "MapLocationManager", "stopLocation");
        }
    }
}
