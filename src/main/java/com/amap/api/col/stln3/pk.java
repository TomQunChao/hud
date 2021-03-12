package com.amap.api.col.stln3;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TraceManager */
public class pk implements LocationSource.OnLocationChangedListener, LBSTraceBase {
    private static final TimeUnit s = TimeUnit.SECONDS;
    int a = Runtime.getRuntime().availableProcessors();
    private Context b;
    private CoordinateConverter c;
    private ExecutorService d;
    private ExecutorService e;
    private long f = 2000;
    private int g = 5;
    private TraceStatusListener h;
    private dt i;
    private List<TraceLocation> j = new ArrayList();
    private int k = 0;
    private int l = 0;
    private long m = 0;
    private c n;
    private TraceLocation o = null;
    private List<LatLng> p = new ArrayList();
    private List<LatLng> q = new ArrayList();
    private List<LatLng> r = new ArrayList();
    private BlockingQueue<Runnable> t = new LinkedBlockingQueue();
    private BlockingQueue<Runnable> u = new LinkedBlockingQueue();

    public pk(Context context) {
        this.b = context.getApplicationContext();
        this.c = new CoordinateConverter(this.b);
        this.n = new c(Looper.getMainLooper());
        rf.a().a(this.b);
        this.d = new ThreadPoolExecutor(1, this.a * 2, 1, s, this.t, new hq("AMapTraceManagerProcess"), new ThreadPoolExecutor.AbortPolicy());
        this.e = new ThreadPoolExecutor(1, this.a * 2, 1, s, this.u, new hq("AMapTraceManagerRequest"), new ThreadPoolExecutor.AbortPolicy());
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
        try {
            this.d.execute(new a(i2, list, i3, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setLocationInterval(long j2) {
        this.f = j2;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setTraceStatusInterval(int i2) {
        this.g = Math.max(i2, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void startTrace(TraceStatusListener traceStatusListener) {
        if (this.b != null) {
            this.m = System.currentTimeMillis();
            this.h = traceStatusListener;
            if (this.i == null) {
                this.i = new dt(this.b);
                this.i.a(this.f);
                this.i.activate(this);
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        if (this.h != null) {
            try {
                if (System.currentTimeMillis() - this.m >= 30000) {
                    if (this.h != null) {
                        this.h.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                    }
                }
                this.m = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i2 = extras.getInt(MyLocationStyle.ERROR_CODE);
                if (i2 != 0) {
                    String str = "Locate failed [errorCode:\"" + i2 + "\"  errorInfo:" + extras.getString(MyLocationStyle.ERROR_INFO) + "\"]";
                    return;
                }
                synchronized (this.j) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    TraceLocation traceLocation2 = this.o;
                    if (!(traceLocation2 != null && traceLocation2.getLatitude() == traceLocation.getLatitude() && traceLocation2.getLongitude() == traceLocation.getLongitude())) {
                        this.j.add(traceLocation);
                        this.o = traceLocation;
                        this.k++;
                        if (this.k == this.g) {
                            this.l += this.k;
                            int size = this.j.size();
                            if (size >= this.g) {
                                if (size <= 50) {
                                    ArrayList arrayList = new ArrayList(this.j);
                                    queryProcessedTrace(0, arrayList, 1, new b(arrayList));
                                } else {
                                    int i3 = size - 50;
                                    if (i3 >= 0) {
                                        a(new ArrayList(this.j.subList(i3 - this.g, i3)));
                                        ArrayList arrayList2 = new ArrayList(this.j.subList(i3, size));
                                        queryProcessedTrace(i3, arrayList2, 1, new b(arrayList2));
                                    }
                                }
                            }
                            this.k = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(List<TraceLocation> list) {
        Throwable th;
        pk pkVar = this;
        synchronized (pkVar.r) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        if (pkVar.r.size() > 0) {
                            LatLng latLng = null;
                            double d2 = 0.0d;
                            TraceLocation traceLocation = null;
                            double d3 = 0.0d;
                            for (TraceLocation traceLocation2 : list) {
                                if (traceLocation2 != null) {
                                    if (traceLocation == null) {
                                        traceLocation = traceLocation2;
                                    } else {
                                        double a2 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                                        if (a2 <= 100.0d) {
                                            d3 += a2;
                                            traceLocation = traceLocation2;
                                        }
                                    }
                                }
                            }
                            Iterator<LatLng> it = pkVar.r.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                LatLng next = it.next();
                                if (next == null) {
                                    it.remove();
                                } else if (latLng == null) {
                                    pkVar.p.add(next);
                                    it.remove();
                                    latLng = next;
                                } else {
                                    try {
                                        d2 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                        if (d2 >= d3) {
                                            break;
                                        }
                                        pkVar = this;
                                        pkVar.p.add(next);
                                        it.remove();
                                        it = it;
                                        latLng = next;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }
    }

    private static double a(double d2, double d3, double d4, double d5) {
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        double d7 = d3 > d5 ? d3 - d5 : d5 - d3;
        return Math.sqrt((d6 * d6) + (d7 * d7));
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void stopTrace() {
        dt dtVar = this.i;
        if (dtVar != null) {
            dtVar.deactivate();
            this.i = null;
        }
        this.t.clear();
        this.u.clear();
        List<TraceLocation> list = this.j;
        if (list != null) {
            synchronized (list) {
                if (this.j != null) {
                    this.j.clear();
                }
                this.l = 0;
                this.k = 0;
                this.m = 0;
                this.o = null;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void destroy() {
        try {
            stopTrace();
            if (this.d != null && !this.d.isShutdown()) {
                this.d.shutdownNow();
                this.d = null;
            }
            if (this.e != null && !this.e.isShutdown()) {
                this.e.shutdownNow();
                this.e = null;
            }
            this.j = null;
            this.h = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b = null;
        this.c = null;
    }

    /* compiled from: TraceManager */
    class b implements TraceListener {
        private final List<TraceLocation> b;

        public b(List<TraceLocation> list) {
            this.b = list;
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (pk.this.r != null) {
                arrayList.addAll(pk.this.r);
            }
            List<TraceLocation> list = this.b;
            if (list != null) {
                int size = list.size();
                if (this.b.size() > pk.this.g) {
                    for (int i2 = size - pk.this.g; i2 < size; i2++) {
                        TraceLocation traceLocation = this.b.get(i2);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i, List<LatLng> list, int i2, int i3) {
            a(i, list);
        }

        private void a(int i, List<LatLng> list) {
            try {
                synchronized (pk.this.r) {
                    pk.this.r.clear();
                    pk.this.r.addAll(list);
                }
                pk.this.q.clear();
                if (i == 0) {
                    pk.this.q.addAll(pk.this.r);
                } else {
                    pk.this.q.addAll(pk.this.p);
                    pk.this.q.addAll(pk.this.r);
                }
                pk.this.h.onTraceStatus(pk.this.j, pk.this.q, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TraceManager */
    public class a implements Runnable {
        private List<TraceLocation> b = new ArrayList();
        private int c;
        private int d;
        private List<TraceLocation> e;
        private String f;
        private TraceListener g;

        public a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.c = i2;
            this.d = i;
            this.e = list;
            this.f = hu.a();
            this.g = traceListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084 A[Catch:{ Throwable -> 0x01ae }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 435
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.pk.a.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: TraceManager */
    public static class c extends Handler {
        private TraceListener a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.a = traceListener;
        }

        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.a != null && (data = message.getData()) != null) {
                    int i = data.getInt("lineID");
                    switch (message.what) {
                        case 100:
                            this.a.onTraceProcessing(i, message.arg1, (List) message.obj);
                            return;
                        case 101:
                            this.a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                            return;
                        case 102:
                            this.a.onRequestFailed(i, (String) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
