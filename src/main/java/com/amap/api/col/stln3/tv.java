package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.util.Map;

/* compiled from: NetManger */
public final class tv extends tr {
    private static tv c;
    private ux d;
    private Handler e;

    public static tv b() {
        return a(true);
    }

    public static tv c() {
        return a(false);
    }

    private static synchronized tv a(boolean z) {
        tv tvVar;
        synchronized (tv.class) {
            try {
                if (c == null) {
                    c = new tv(z);
                } else if (z && c.d == null) {
                    c.d = ux.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            tvVar = c;
        }
        return tvVar;
    }

    private tv(boolean z) {
        if (z) {
            try {
                this.d = ux.b();
            } catch (Throwable th) {
                rx.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.e = new a();
        }
    }

    @Override // com.amap.api.col.stln3.tr
    public final byte[] b(tw twVar) throws qx {
        try {
            ty a2 = a(twVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (qx e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public static byte[] d(tw twVar) throws qx {
        try {
            ty c2 = c(twVar, false);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (qx e2) {
            throw e2;
        } catch (Throwable th) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public static byte[] e(tw twVar) throws qx {
        try {
            ty c2 = c(twVar, true);
            if (c2 != null) {
                return c2.a;
            }
            return null;
        } catch (qx e2) {
            throw e2;
        } catch (Throwable th) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public static Map<String, String> b(tw twVar, boolean z) throws qx {
        Proxy proxy;
        try {
            c(twVar);
            if (twVar.c == null) {
                proxy = null;
            } else {
                proxy = twVar.c;
            }
            tu tuVar = new tu(twVar.a, twVar.b, proxy, z);
            String url = twVar.getURL();
            boolean isIPRequest = twVar.isIPRequest();
            String iPDNSName = twVar.getIPDNSName();
            Map<String, String> requestHead = twVar.getRequestHead();
            Map<String, String> params = twVar.getParams();
            twVar.isIgnoreGZip();
            return tuVar.a(url, isIPRequest, iPDNSName, requestHead, params);
        } catch (qx e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ty c(tw twVar, boolean z) throws qx {
        Proxy proxy;
        try {
            c(twVar);
            if (twVar.c == null) {
                proxy = null;
            } else {
                proxy = twVar.c;
            }
            return new tu(twVar.a, twVar.b, proxy, z).a(twVar.getURL(), twVar.isIPRequest(), twVar.getIPDNSName(), twVar.getRequestHead(), twVar.getParams(), twVar.isIgnoreGZip());
        } catch (qx e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public static synchronized void d() {
        synchronized (tv.class) {
            try {
                if (c != null) {
                    tv tvVar = c;
                    try {
                        if (tvVar.d != null) {
                            ux.c();
                        }
                        if (tvVar.e != null) {
                            tvVar.e.removeCallbacksAndMessages(null);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    c = null;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* compiled from: NetManger */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        tx txVar = ((ua) message.obj).b;
                        return;
                    case 1:
                        ua uaVar = (ua) message.obj;
                        tx txVar2 = uaVar.b;
                        qx qxVar = uaVar.a;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
