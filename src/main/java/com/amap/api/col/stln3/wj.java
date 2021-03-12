package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: MapLocationManagerActionHandler */
public final class wj extends Handler {
    wi a = null;

    public wj() {
    }

    public wj(Looper looper, wi wiVar) {
        super(looper);
        this.a = wiVar;
    }

    public final void handleMessage(Message message) {
        String str;
        String str2;
        switch (message.what) {
            case 1001:
                try {
                    this.a.a((Inner_3dMap_locationOption) message.obj);
                    return;
                } catch (Throwable th) {
                    th = th;
                    str = "ClientActionHandler";
                    str2 = "ACTION_SET_OPTION";
                    break;
                }
            case 1002:
                try {
                    this.a.a((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    str = "ClientActionHandler";
                    str2 = "ACTION_SET_LISTENER";
                    break;
                }
            case 1003:
                try {
                    this.a.b((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    str = "ClientActionHandler";
                    str2 = "ACTION_REMOVE_LISTENER";
                    break;
                }
            case 1004:
                try {
                    this.a.a();
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    str = "ClientActionHandler";
                    str2 = "ACTION_START_LOCATION";
                    break;
                }
            case AMapException.CODE_AMAP_ACCESS_TOO_FREQUENT /*{ENCODED_INT: 1005}*/:
                try {
                    this.a.b();
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    str = "ClientActionHandler";
                    str2 = "ACTION_GET_LOCATION";
                    break;
                }
            case 1006:
                try {
                    this.a.c();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    str = "ClientActionHandler";
                    str2 = "ACTION_STOP_LOCATION";
                    break;
                }
            case 1007:
                try {
                    this.a.d();
                    return;
                } catch (Throwable th7) {
                    wy.a(th7, "ClientActionHandler", "ACTION_DESTROY");
                    return;
                }
            default:
                return;
        }
        wy.a(th, str, str2);
    }
}
