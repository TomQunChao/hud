package com.amap.api.col.stln3;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;

/* compiled from: IOverlayDelegate */
public interface fz extends IOverlay {
    void a(MapConfig mapConfig) throws RemoteException;

    boolean a();

    boolean b();
}
