package com.autonavi.ae.route;

import android.content.Context;
import com.autonavi.ae.route.model.LightBarItem;
import com.autonavi.ae.route.model.RerouteOption;
import com.autonavi.ae.route.model.RouteConfig;
import com.autonavi.ae.route.model.RouteOption;
import com.autonavi.ae.route.model.TmcRoutePath;
import com.autonavi.ae.route.observer.HttpInterface;
import com.autonavi.ae.route.observer.RouteObserver;
import com.autonavi.ae.route.route.CalcRouteResult;

public class RouteService {
    int buffLen = 1024;
    private Context mContext;
    private HttpInterface mHttpProcess;
    private long mPtr;
    private RouteObserver mRouteObserver;

    public static native CalcRouteResult decodeRouteData(byte[] bArr);

    public static native LightBarItem[] decodeRouteTmcBar(byte[] bArr, TmcRoutePath tmcRoutePath);

    public static native String getRouteVersion();

    public static native String getSdkVersion();

    private final native void init(RouteConfig routeConfig);

    public native void abortRoutePlan();

    public native int control(int i, String str);

    public final native void destroy();

    public native void processHttpData(int i, int i2, byte[] bArr);

    public native void processHttpError(int i, int i2);

    public native int requestRoute(RouteOption routeOption);

    public native int reroute(RerouteOption rerouteOption);

    public RouteService(RouteConfig routeConfig, Context context) {
        init(routeConfig);
        this.mContext = context;
    }

    public void setRouteObserver(RouteObserver routeObserver) {
        this.mRouteObserver = routeObserver;
    }

    public void registerHttpProcesser(HttpInterface httpInterface) {
        this.mHttpProcess = httpInterface;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0069 A[SYNTHETIC, Splitter:B:42:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075 A[SYNTHETIC, Splitter:B:47:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0081 A[SYNTHETIC, Splitter:B:53:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x009b A[SYNTHETIC, Splitter:B:64:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a7 A[SYNTHETIC, Splitter:B:69:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] readAssetsFile(int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.route.RouteService.readAssetsFile(int, int):byte[]");
    }
}
