package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.ps;
import com.amap.api.track.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: DataSyncerManager */
public final class px {
    private pw a;
    private qq b;
    private ps.a c;

    public px(qq qqVar, pw pwVar, ps.a aVar) {
        this.b = qqVar;
        this.a = pwVar;
        this.c = aVar;
    }

    public final void a(qq qqVar) {
        this.b = qqVar;
    }

    public final void a(Context context) {
        ps.a aVar;
        if (context != null) {
            int e = this.b.e();
            List<pt> a2 = this.a.a(e);
            List<pt> b2 = this.a.b(e);
            if (!qc.a(context) && (aVar = this.c) != null) {
                aVar.a(true, 2016, ErrorCode.TrackListen.START_TRACK_NET_CONNECTED_MSG);
            }
            if (qc.a(context)) {
                a(context, a2, this.a.b());
            } else {
                this.a.a(a2);
                this.a.b(a2);
            }
            if (qc.a(context)) {
                a(context, b2, this.a.a());
            }
        }
    }

    private void a(Context context, List<pt> list, py pyVar) {
        List<pt> list2;
        if (list != null && list.size() > 0) {
            if (list == null) {
                list2 = list;
            } else {
                list2 = new ArrayList<>();
                String str = "";
                long j = -1;
                long j2 = -1;
                long j3 = -1;
                for (pt ptVar : list) {
                    if (ptVar != null && ((ptVar.b() > 0 || !TextUtils.isEmpty(str)) && ptVar.c() > 0)) {
                        if (j < 0 && j2 < 0) {
                            j = ptVar.b();
                            j2 = ptVar.c();
                            j3 = ptVar.d();
                            str = ptVar.e();
                        }
                        if (j == ptVar.b() && j2 == ptVar.c()) {
                            long d = ptVar.d();
                            boolean z = false;
                            if ((j3 <= 0 && d <= 0) || j3 == d) {
                                String e = ptVar.e();
                                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(e)) {
                                    z = true;
                                } else if (!TextUtils.isEmpty(str)) {
                                    z = str.equals(e);
                                }
                                if (z) {
                                    list2.add(ptVar);
                                }
                            }
                        }
                    }
                }
            }
            long a2 = a(list2);
            long d2 = d(list2);
            long b2 = b(list2);
            String c2 = c(list2);
            if (a2 < 0) {
                this.c.a(this.b.a(d2, a2), 2021, ErrorCode.TrackListen.START_TRACK_CREATE_TERMINAL_FAIL_MSG);
                return;
            }
            qb qbVar = new qb(qc.a(context, new qa(d2, a2, b2, c2, list2), this.b.i()));
            ps.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.b.a(d2, a2), qbVar.getErrorCode(), qbVar.getErrorMsg());
            }
            Set<Long> a3 = qbVar.a(list2);
            if (pyVar == null) {
                qr.a("data cacher is null");
            } else {
                pyVar.a(a3);
            }
        }
    }

    private static long a(List<pt> list) {
        if (list == null) {
            return -1;
        }
        for (pt ptVar : list) {
            if (ptVar != null && ptVar.b() > 0) {
                return ptVar.b();
            }
        }
        return -1;
    }

    private static long b(List<pt> list) {
        if (list == null) {
            return -1;
        }
        for (pt ptVar : list) {
            if (ptVar != null && ptVar.d() > 0) {
                return ptVar.d();
            }
        }
        return -1;
    }

    private static String c(List<pt> list) {
        if (list == null) {
            return "";
        }
        for (pt ptVar : list) {
            if (!(ptVar == null || TextUtils.isEmpty(ptVar.e()))) {
                return ptVar.e();
            }
        }
        return "";
    }

    private static long d(List<pt> list) {
        if (list == null) {
            return 0;
        }
        for (pt ptVar : list) {
            if (ptVar != null && ptVar.c() >= 0) {
                return ptVar.c();
            }
        }
        return 0;
    }
}
