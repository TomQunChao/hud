package com.amap.api.col.stln3;

import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.net.URLConnection;

/* compiled from: BaseNetManager */
public class tr {
    public static int a = 0;
    public static String b = "";
    private static tr c;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a();
    }

    public static tr a() {
        if (c == null) {
            c = new tr();
        }
        return c;
    }

    public static byte[] a(tw twVar) throws qx {
        try {
            ty a2 = a(twVar, true);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (qx e) {
            throw e;
        } catch (Throwable th) {
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] b(tw twVar) throws qx {
        try {
            ty a2 = a(twVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (qx e) {
            throw e;
        } catch (Throwable th) {
            ru.a(th, "bm", "msp");
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }

    protected static void c(tw twVar) throws qx {
        if (twVar == null) {
            throw new qx("requeust is null");
        } else if (twVar.getURL() == null || "".equals(twVar.getURL())) {
            throw new qx("request url is empty");
        }
    }

    public static ty a(tw twVar, boolean z) throws qx {
        Proxy proxy;
        try {
            c(twVar);
            if (twVar.c == null) {
                proxy = null;
            } else {
                proxy = twVar.c;
            }
            return new tu(twVar.a, twVar.b, proxy, z).a(twVar.b(), twVar.isIPRequest(), twVar.getIPDNSName(), twVar.getRequestHead(), twVar.c(), twVar.isIgnoreGZip());
        } catch (qx e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new qx(AMapException.ERROR_UNKNOWN);
        }
    }
}
