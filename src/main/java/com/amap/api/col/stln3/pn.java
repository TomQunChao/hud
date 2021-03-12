package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.col.stln3.pm;
import com.amap.api.col.stln3.po;
import com.amap.api.col.stln3.ps;
import com.amap.api.track.ErrorCode;

/* compiled from: LocMonitorCore */
public final class pn {
    private qi a;
    private ps b;
    private qq c = null;
    private po d = null;
    private Context e;
    private pm.a f;
    private po.a g = new po.a() {
        /* class com.amap.api.col.stln3.pn.AnonymousClass1 */

        @Override // com.amap.api.col.stln3.po.a
        public final void a(int i, String str) {
            if (pn.this.f != null) {
                pn.this.f.b(i, str);
            }
        }

        @Override // com.amap.api.col.stln3.po.a
        public final void b(int i, String str) {
            if (pn.this.f != null) {
                pn.this.f.a(i, str);
            }
        }

        @Override // com.amap.api.col.stln3.po.a
        public final void c(int i, String str) {
            if (pn.this.f != null) {
                pn.this.f.c(i, str);
            }
        }

        @Override // com.amap.api.col.stln3.po.a
        public final void d(int i, String str) {
            if (pn.this.f != null) {
                pn.this.f.d(i, str);
            }
        }

        @Override // com.amap.api.col.stln3.po.a
        public final void e(int i, String str) {
            int locErrCode = ErrorCode.getLocErrCode(i);
            if (pn.this.f != null) {
                pn.this.f.a(locErrCode, str);
            }
        }
    };
    private ps.a h = new ps.a() {
        /* class com.amap.api.col.stln3.pn.AnonymousClass2 */

        /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // com.amap.api.col.stln3.ps.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean r3, int r4, java.lang.String r5) {
            /*
                r2 = this;
                com.amap.api.col.stln3.pn r0 = com.amap.api.col.stln3.pn.this
                com.amap.api.col.stln3.po$a r0 = com.amap.api.col.stln3.pn.b(r0)
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                if (r3 != 0) goto L_0x000c
                return
            L_0x000c:
                r3 = 2017(0x7e1, float:2.826E-42)
                r0 = 0
                r1 = 1
                if (r4 == r3) goto L_0x001b
                r3 = 20150(0x4eb6, float:2.8236E-41)
                if (r4 == r3) goto L_0x001b
                switch(r4) {
                    case 20050: goto L_0x001b;
                    case 20051: goto L_0x001b;
                    default: goto L_0x0019;
                }
            L_0x0019:
                r3 = 0
                goto L_0x001c
            L_0x001b:
                r3 = 1
            L_0x001c:
                if (r3 == 0) goto L_0x002d
                com.amap.api.col.stln3.pn r3 = com.amap.api.col.stln3.pn.this
                r3.b(r1)
                com.amap.api.col.stln3.pn r3 = com.amap.api.col.stln3.pn.this
                com.amap.api.col.stln3.po$a r3 = com.amap.api.col.stln3.pn.b(r3)
                r3.d(r4, r5)
                return
            L_0x002d:
                r3 = 3003(0xbbb, float:4.208E-42)
                if (r4 == r3) goto L_0x0041
                r3 = 10000(0x2710, float:1.4013E-41)
                if (r4 == r3) goto L_0x0041
                r3 = 20009(0x4e29, float:2.8039E-41)
                if (r4 == r3) goto L_0x0041
                r3 = 20052(0x4e54, float:2.8099E-41)
                if (r4 == r3) goto L_0x0041
                switch(r4) {
                    case 20100: goto L_0x0041;
                    case 20101: goto L_0x0041;
                    default: goto L_0x0040;
                }
            L_0x0040:
                goto L_0x0042
            L_0x0041:
                r0 = 1
            L_0x0042:
                if (r0 != 0) goto L_0x004e
                com.amap.api.col.stln3.pn r3 = com.amap.api.col.stln3.pn.this
                com.amap.api.col.stln3.po$a r3 = com.amap.api.col.stln3.pn.b(r3)
                r3.a(r4, r5)
                goto L_0x004f
            L_0x004e:
            L_0x004f:
                return
                switch-data {20050->0x001b, 20051->0x001b, }
                switch-data {20100->0x0041, 20101->0x0041, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.pn.AnonymousClass2.a(boolean, int, java.lang.String):void");
        }
    };

    public pn(Context context, qq qqVar, pm.a aVar) throws Exception {
        if (qqVar != null) {
            this.c = qqVar;
            this.e = context;
            this.f = aVar;
            this.a = new qj();
            this.b = new pq(this.e, this.c, this.h);
            this.d = new po(this.c, this.b, this.g);
            return;
        }
        qr.a("{@LocMonitorCore #startMonitor localOption should not be null");
        throw new Exception("{@LocMonitorCore #startMonitor localOption should not be null");
    }

    public final void a(pm.a aVar) {
        this.f = aVar;
    }

    public final void a() {
        if (pp.e()) {
            pm.a aVar = this.f;
            if (aVar != null) {
                aVar.b(ErrorCode.TrackListen.START_TRACK_ALREADY_STARTED, ErrorCode.TrackListen.START_TRACK_ALREADY_STARTED_MSG);
                return;
            }
            return;
        }
        pp.a();
        this.d.a(this.e);
    }

    public final void b() {
        if (!pp.e()) {
            pm.a aVar = this.f;
            if (aVar != null) {
                aVar.a(ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED, ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED_MSG);
            }
        } else if (pp.f()) {
            pm.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(ErrorCode.TrackListen.START_GATHER_ALREADY_STARTED, ErrorCode.TrackListen.START_GATHER_ALREADY_STARTED_MSG);
            }
        } else {
            pp.b();
            qi qiVar = this.a;
            Context context = this.e;
            qv.a();
            qiVar.a(context, this.c.j(), this.d.a());
            this.d.b();
        }
    }

    public final void a(boolean z) {
        if (pp.f() || z) {
            pp.d();
            this.a.a();
            this.d.a(z);
            return;
        }
        pm.a aVar = this.f;
        if (aVar != null) {
            aVar.c(2012, ErrorCode.TrackListen.STOP_GATHER_GATHER_NOT_STARTED_MSG);
        }
    }

    public final void b(boolean z) {
        if (z || pp.e()) {
            a(true);
            this.d.b(z);
            pp.c();
            return;
        }
        pm.a aVar = this.f;
        if (aVar != null) {
            aVar.d(ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED, ErrorCode.TrackListen.START_GATHER_TRACK_NOT_STARTED_MSG);
        }
    }

    public final void a(qq qqVar) {
        if (qqVar != null) {
            this.c = qqVar;
            if (this.b == null) {
                qr.a("Should start monitor firstly");
            }
            ps psVar = this.b;
            if (psVar != null) {
                psVar.a(this.c);
            }
            po poVar = this.d;
            if (poVar != null) {
                poVar.a(this.c);
            }
        }
    }

    public final void a(long j) {
        qq qqVar = this.c;
        if (qqVar != null) {
            qqVar.a("");
            this.c.a(j);
            a(this.c);
        }
    }

    public final long c() {
        qq qqVar = this.c;
        if (qqVar == null) {
            return -1;
        }
        return qqVar.g();
    }

    public final void a(String str) {
        qq qqVar = this.c;
        if (qqVar != null) {
            qqVar.a(0);
            this.c.a(str);
            a(this.c);
        }
    }

    public final String d() {
        if (this.c != null && c() <= 0) {
            return this.c.h();
        }
        return "";
    }

    public final void a(pm.b bVar) {
        this.d.a(bVar);
    }
}
