package com.amap.api.track;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.amap.api.col.stln3.pm;
import com.amap.api.col.stln3.qt;
import com.amap.api.track.ErrorCode;
import com.amap.api.track.c;
import com.amap.api.track.e;

public final class AMapTrackService extends Service {
    d a;
    a b;
    TrackParam c;
    f d;
    pm e;
    boolean f = true;
    private final e.a g = new e.a() {
        /* class com.amap.api.track.AMapTrackService.AnonymousClass1 */

        @Override // com.amap.api.track.e
        public final void a(TrackParam trackParam, f fVar, c cVar, d dVar) throws RemoteException {
            if (!AMapTrackService.this.f) {
                dVar.a(2017, ErrorCode.TrackListen.START_TRACK_AUTH_CHECK_FAIL_MSG);
                return;
            }
            AMapTrackService aMapTrackService = AMapTrackService.this;
            aMapTrackService.a = dVar;
            aMapTrackService.b = new a(dVar);
            AMapTrackService aMapTrackService2 = AMapTrackService.this;
            aMapTrackService2.c = trackParam;
            aMapTrackService2.d = fVar;
            aMapTrackService2.d.a(cVar);
            AMapTrackService.a(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void a(d dVar) throws RemoteException {
            if (dVar != null) {
                AMapTrackService.this.a = dVar;
            }
            AMapTrackService aMapTrackService = AMapTrackService.this;
            aMapTrackService.b = new a(dVar);
            AMapTrackService.b(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void b(d dVar) throws RemoteException {
            if (dVar != null) {
                AMapTrackService aMapTrackService = AMapTrackService.this;
                aMapTrackService.a = dVar;
                aMapTrackService.b.a(dVar);
            }
            AMapTrackService.c(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void a(TrackParam trackParam, d dVar) throws RemoteException {
            if (dVar != null) {
                AMapTrackService aMapTrackService = AMapTrackService.this;
                aMapTrackService.a = dVar;
                aMapTrackService.b.a(dVar);
            }
            if (trackParam != null) {
                AMapTrackService.this.c = trackParam;
            }
            AMapTrackService.this.a((AMapTrackService) false);
            AMapTrackService aMapTrackService2 = AMapTrackService.this;
            aMapTrackService2.e = null;
            aMapTrackService2.stopSelf();
        }

        @Override // com.amap.api.track.e
        public final void a(long j) throws RemoteException {
            if (AMapTrackService.this.c != null) {
                AMapTrackService.this.c.setTrackId(j);
            }
            if (AMapTrackService.this.e != null) {
                AMapTrackService.this.e.a(j);
            }
        }

        @Override // com.amap.api.track.e
        public final long a() throws RemoteException {
            if (AMapTrackService.this.e != null) {
                return AMapTrackService.this.e.d();
            }
            if (AMapTrackService.this.c != null) {
                return AMapTrackService.this.c.getTrackId();
            }
            return -1;
        }

        @Override // com.amap.api.track.e
        public final void a(String str) throws RemoteException {
            if (AMapTrackService.this.c != null) {
                AMapTrackService.this.c.setTrackId(0);
            }
            if (AMapTrackService.this.e != null) {
                AMapTrackService.this.e.a(str);
            }
        }

        @Override // com.amap.api.track.e
        public final String b() throws RemoteException {
            if (AMapTrackService.this.e != null) {
                return AMapTrackService.this.e.e();
            }
            return "";
        }

        @Override // com.amap.api.track.e
        public final void a(int i) throws RemoteException {
            AMapTrackService.this.d.a(i);
            AMapTrackService.e(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void a(int i, int i2) throws RemoteException {
            AMapTrackService.this.d.a(i, i2);
            AMapTrackService.e(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void b(int i) throws RemoteException {
            AMapTrackService.this.d.b(i);
            AMapTrackService.e(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void c(int i) throws RemoteException {
            AMapTrackService.this.d.c(i);
            AMapTrackService.e(AMapTrackService.this);
        }

        @Override // com.amap.api.track.e
        public final void a(c cVar) throws RemoteException {
            AMapTrackService.this.d.a((c.a) cVar);
        }

        @Override // com.amap.api.track.e
        public final void c(d dVar) throws RemoteException {
            AMapTrackService aMapTrackService = AMapTrackService.this;
            aMapTrackService.a = dVar;
            if (dVar != null) {
                aMapTrackService.b.a(dVar);
            }
            if (AMapTrackService.this.e != null) {
                AMapTrackService.this.e.a(AMapTrackService.this.b);
            }
        }
    };
    private pm.b h = new pm.b() {
        /* class com.amap.api.track.AMapTrackService.AnonymousClass3 */

        @Override // com.amap.api.col.stln3.pm.b
        public final String a() {
            if (AMapTrackService.this.d == null || AMapTrackService.this.d.b() == null) {
                return "";
            }
            try {
                return AMapTrackService.this.d.b().a();
            } catch (RemoteException e) {
                return "";
            }
        }
    };

    static /* synthetic */ void a(AMapTrackService aMapTrackService) {
        qt.a(aMapTrackService, new qt.a() {
            /* class com.amap.api.track.AMapTrackService.AnonymousClass2 */

            @Override // com.amap.api.col.stln3.qt.a
            public final void a() {
                AMapTrackService aMapTrackService = AMapTrackService.this;
                aMapTrackService.f = false;
                if (aMapTrackService.a != null) {
                    try {
                        AMapTrackService.this.a.a(2017, ErrorCode.TrackListen.START_TRACK_AUTH_CHECK_FAIL_MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                AMapTrackService.this.a((AMapTrackService) true);
            }
        }).start();
        if (aMapTrackService.e == null) {
            aMapTrackService.e = new pm(aMapTrackService.getApplicationContext(), f.a(aMapTrackService.c, aMapTrackService.d), aMapTrackService.b);
        }
        aMapTrackService.e.a();
        if (aMapTrackService.c.getNotification() != null && Build.VERSION.SDK_INT >= 5) {
            aMapTrackService.startForeground(1001, aMapTrackService.c.getNotification());
        }
    }

    static /* synthetic */ void b(AMapTrackService aMapTrackService) {
        pm pmVar = aMapTrackService.e;
        if (pmVar != null) {
            pmVar.a(aMapTrackService.h);
            aMapTrackService.e.b();
        }
    }

    static /* synthetic */ void c(AMapTrackService aMapTrackService) {
        pm pmVar = aMapTrackService.e;
        if (pmVar != null) {
            pmVar.c();
        }
    }

    static /* synthetic */ void e(AMapTrackService aMapTrackService) {
        aMapTrackService.e.a(f.a(aMapTrackService.c, aMapTrackService.d));
    }

    public final IBinder onBind(Intent intent) {
        return this.g;
    }

    public final void onDestroy() {
        a(true);
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 5) {
            stopForeground(true);
        }
        pm pmVar = this.e;
        if (pmVar != null) {
            pmVar.a(z);
        }
    }

    /* access modifiers changed from: private */
    public class a implements pm.a {
        private d b;

        public a(d dVar) {
            this.b = dVar;
        }

        public final void a(d dVar) {
            this.b = dVar;
        }

        @Override // com.amap.api.col.stln3.pm.a
        public final void a(int i, String str) {
            try {
                this.b.c(i, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.amap.api.col.stln3.pm.a
        public final void b(int i, String str) {
            try {
                this.b.a(i, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.amap.api.col.stln3.pm.a
        public final void c(int i, String str) {
            try {
                this.b.d(i, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.amap.api.col.stln3.pm.a
        public final void d(int i, String str) {
            try {
                this.b.b(i, str);
                AMapTrackService.this.a = null;
                AMapTrackService.this.b = null;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
