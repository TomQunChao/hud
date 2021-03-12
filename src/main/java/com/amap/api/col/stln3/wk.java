package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: MapLocationManagerResultHandler */
public final class wk extends Handler {
    wi a = null;

    public wk(Looper looper, wi wiVar) {
        super(looper);
        this.a = wiVar;
    }

    public wk(wi wiVar) {
        this.a = wiVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                if (this.a != null) {
                    this.a.a((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                wy.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
