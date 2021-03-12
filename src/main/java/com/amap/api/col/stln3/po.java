package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.pm;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.track.ErrorCode;

/* compiled from: LocMonitorDataManager */
public final class po {
    private static int i = 5;
    private qq a;
    private AMapLocationListener b;
    private ps c;
    private Context d;
    private a e;
    private volatile AMapLocation f = null;
    private pm.b g;
    private AMapLocation h;

    /* compiled from: LocMonitorDataManager */
    public interface a {
        void a(int i, String str);

        void b(int i, String str);

        void c(int i, String str);

        void d(int i, String str);

        void e(int i, String str);
    }

    static /* synthetic */ void b(po poVar) {
        try {
            poVar.c.a(poVar.d);
        } catch (Exception e2) {
            qr.a("syncLocDataToRemote ex " + e2);
        }
    }

    static /* synthetic */ void c(po poVar) {
        if (poVar.f == null || poVar.d == null) {
            qr.a("LocSceduleExecutor return cause of lastLoc or mContext is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - poVar.f.getTime() > poVar.a.c() * ((long) i)) {
            qr.a("long time , no SDK location callback " + (currentTimeMillis - poVar.f.getTime()) + " , while the interval is " + poVar.a.c());
        }
        AMapLocation aMapLocation = poVar.h;
        AMapLocation aMapLocation2 = poVar.f;
        boolean z = false;
        if (qp.a(aMapLocation) && qp.a(aMapLocation2) && aMapLocation.getLatitude() == aMapLocation2.getLatitude() && aMapLocation.getLongitude() == aMapLocation2.getLongitude()) {
            z = true;
        }
        if (z) {
            qr.a("same loc , so discard the " + poVar.f);
            return;
        }
        pt ptVar = new pt(poVar.f, poVar.a.f(), poVar.a.b(), poVar.a.g(), poVar.a.h(), currentTimeMillis);
        poVar.h = poVar.f;
        pm.b bVar = poVar.g;
        if (bVar != null) {
            ptVar.a(bVar.a());
        }
        ps psVar = poVar.c;
        Context context = poVar.d;
        psVar.a(ptVar);
    }

    public po(qq qqVar, ps psVar, a aVar) {
        this.a = qqVar;
        this.c = psVar;
        this.e = aVar;
        this.b = new AMapLocationListener() {
            /* class com.amap.api.col.stln3.po.AnonymousClass1 */

            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation == null) {
                    qr.a("AMapLocation is NULL");
                } else if (aMapLocation.getErrorCode() != 0) {
                    qr.a("AMapLocation failed " + aMapLocation.getErrorCode() + " , " + aMapLocation.getErrorInfo());
                    if (po.this.e != null) {
                        po.this.e.e(aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
                    }
                } else if (qp.a(aMapLocation)) {
                    po.this.f = aMapLocation;
                }
            }
        };
    }

    public final void a(pm.b bVar) {
        this.g = bVar;
    }

    public final AMapLocationListener a() {
        return this.b;
    }

    public final void a(Context context) {
        a aVar;
        this.d = context;
        if (!pr.a().a(1002) || (aVar = this.e) == null) {
            pr.a().a(1002, "pack_exe_thread_name", new Runnable() {
                /* class com.amap.api.col.stln3.po.AnonymousClass2 */

                public final void run() {
                    try {
                        po.b(po.this);
                    } catch (Throwable th) {
                        qr.b("syncLocDataToCache ex " + th);
                    }
                }
            }, this.a.d());
            if (this.e == null) {
                return;
            }
            if (qc.a(context)) {
                this.e.a(ErrorCode.TrackListen.START_TRACK_SUCEE, ErrorCode.TrackListen.START_TRACK_SUCEE_MSG);
            } else {
                this.e.a(ErrorCode.TrackListen.START_TRACK_SUCEE_NO_NETWORK, ErrorCode.TrackListen.START_TRACK_SUCEE_NO_NETWORK_MSG);
            }
        } else {
            aVar.a(ErrorCode.TrackListen.START_TRACK_ALREADY_STARTED, ErrorCode.TrackListen.START_TRACK_ALREADY_STARTED_MSG);
        }
    }

    public final void b() {
        a aVar;
        a aVar2;
        if (this.d == null) {
            this.e.b(ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED, ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED_MSG);
        } else if (!pr.a().a(1002) && (aVar2 = this.e) != null) {
            aVar2.b(ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED, ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED_MSG);
        } else if (!pr.a().a(1001) || (aVar = this.e) == null) {
            pr.a().a(1001, "gather_exe_thread_name", new Runnable() {
                /* class com.amap.api.col.stln3.po.AnonymousClass3 */

                public final void run() {
                    try {
                        po.c(po.this);
                    } catch (Throwable th) {
                        qr.b("syncLocDataToCache ex " + th);
                    }
                }
            }, this.a.c());
            this.e.b(2010, ErrorCode.TrackListen.START_GATHER_SUCEE_MSG);
        } else {
            aVar.b(ErrorCode.TrackListen.START_GATHER_ALREADY_STARTED, ErrorCode.TrackListen.START_GATHER_ALREADY_STARTED_MSG);
        }
    }

    public final void a(boolean z) {
        a aVar;
        a aVar2;
        a aVar3;
        if (!z && !pr.a().a(1002) && (aVar3 = this.e) != null) {
            aVar3.c(2011, ErrorCode.TrackListen.STOP_GATHER_TRACK_NOT_STARTED_MSG);
        } else if (z || pr.a().a(1001) || (aVar2 = this.e) == null) {
            pr.a().b(1001);
            if (!z && (aVar = this.e) != null) {
                aVar.c(2013, ErrorCode.TrackListen.STOP_GATHER_SUCCE_MSG);
            }
        } else {
            aVar2.c(2012, ErrorCode.TrackListen.STOP_GATHER_GATHER_NOT_STARTED_MSG);
        }
    }

    public final void b(boolean z) {
        a aVar;
        if (z || pr.a().a(1002) || (aVar = this.e) == null) {
            ps psVar = this.c;
            if (psVar != null) {
                psVar.a();
            }
            this.d = null;
            pr.a().b(1002);
            if (!z) {
                this.e.d(2014, ErrorCode.TrackListen.STOP_TRACK_SUCCE_MSG);
                return;
            }
            return;
        }
        aVar.d(2011, ErrorCode.TrackListen.STOP_GATHER_TRACK_NOT_STARTED_MSG);
    }

    public final void a(qq qqVar) {
        if (this.a.c() != qqVar.c() && pr.a().a(1001)) {
            pr.a().a(1001, qqVar.c());
        }
        if (this.a.d() != qqVar.d() && pr.a().a(1002)) {
            pr.a().a(1002, qqVar.d());
        }
        this.a = qqVar;
    }
}
