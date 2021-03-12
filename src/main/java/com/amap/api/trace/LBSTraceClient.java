package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.stln3.ic;
import com.amap.api.col.stln3.pk;
import com.amap.api.col.stln3.rj;
import com.amap.api.col.stln3.sk;
import java.util.List;

public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;
    private static LBSTraceBase a;
    private static volatile LBSTraceClient b;

    public LBSTraceClient(Context context) {
        a(context);
    }

    private LBSTraceClient() {
    }

    public static LBSTraceClient getInstance(Context context) {
        if (b == null) {
            synchronized (LBSTraceClient.class) {
                if (b == null) {
                    a(context);
                    b = new LBSTraceClient();
                }
            }
        }
        return b;
    }

    private static void a(Context context) {
        if (context != null) {
            try {
                rj f = ic.f();
                a = (LBSTraceBase) sk.a(context.getApplicationContext(), f, "com.amap.api.wrapper.LBSTraceClientWrapper", pk.class, new Class[]{Context.class}, new Object[]{context.getApplicationContext()});
            } catch (Throwable th) {
                a = new pk(context.getApplicationContext());
            }
        }
    }

    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i, list, i2, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a = null;
            b = null;
        }
    }
}
