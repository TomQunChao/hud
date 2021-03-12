package com.amap.api.col.stln3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.stln3.ld;
import com.amap.api.col.stln3.lq;
import com.amap.api.maps.model.MyLocationStyle;
import java.util.ArrayList;

/* compiled from: MessageHandler */
public final class lj extends Handler {
    private static lj a;

    /* compiled from: MessageHandler */
    public static class a {
        public ln a;
        public lq.a b;
    }

    /* compiled from: MessageHandler */
    public static class b {
        public lp a;
        public lq.a b;
    }

    public static synchronized lj a() {
        lj ljVar;
        synchronized (lj.class) {
            if (a == null) {
                if (Looper.myLooper() != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        a = new lj();
                    }
                }
                a = new lj(Looper.getMainLooper());
            }
            ljVar = a;
        }
        return ljVar;
    }

    lj() {
    }

    private lj(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        a aVar;
        try {
            switch (message.arg1) {
                case 5:
                    ld.a aVar2 = (ld.a) message.obj;
                    if (aVar2 != null) {
                        ArrayList arrayList = null;
                        if (message.what == 1000) {
                            arrayList = message.getData().getParcelableArrayList("result");
                        }
                        aVar2.a(arrayList, message.what);
                        return;
                    }
                    return;
                case 6:
                    if (message.what == 600) {
                        b bVar = (b) message.obj;
                        if (!(bVar == null || bVar.b == null)) {
                            Bundle data = message.getData();
                            if (data != null) {
                                data.getInt(MyLocationStyle.ERROR_CODE);
                                lp lpVar = bVar.a;
                                return;
                            }
                            return;
                        }
                    } else if (message.what == 602 && (aVar = (a) message.obj) != null) {
                        lq.a aVar3 = aVar.b;
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            aVar3.a(aVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
                        }
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
        }
    }
}
