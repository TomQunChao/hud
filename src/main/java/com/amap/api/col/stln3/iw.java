package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.navi.AMapNaviListener;
import com.autonavi.ae.guide.model.NaviInfo;
import com.autonavi.ae.route.model.LightBarInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageDispather */
public final class iw extends Handler {
    private static iw c;
    List<AMapNaviListener> a = new ArrayList();
    it b = null;
    private final String d = "MessageDispather";

    private iw(Context context) {
        super(context.getMainLooper());
    }

    public static iw a(Context context) {
        if (c == null) {
            c = new iw(context);
        }
        return c;
    }

    public final void a(AMapNaviListener aMapNaviListener) {
        if (!this.a.contains(aMapNaviListener) && aMapNaviListener != null) {
            if (!(aMapNaviListener instanceof com.amap.api.navi.core.view.a)) {
                this.a.add(0, aMapNaviListener);
            } else {
                this.a.add(aMapNaviListener);
            }
        }
    }

    public final void b(AMapNaviListener aMapNaviListener) {
        List<AMapNaviListener> list = this.a;
        if (list != null) {
            list.remove(aMapNaviListener);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 694
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public final void handleMessage(android.os.Message r12) {
        /*
        // Method dump skipped, instructions count: 2030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.iw.handleMessage(android.os.Message):void");
    }

    public final void a() {
        try {
            if (this.a != null) {
                this.a.clear();
            }
            removeCallbacksAndMessages(null);
            c = null;
            this.b = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* compiled from: MessageDispather */
    static class a {
        public Object a;
        public Object b;
        public Object c;
        LightBarInfo[] d;
        NaviInfo[] e;

        a() {
        }
    }
}
