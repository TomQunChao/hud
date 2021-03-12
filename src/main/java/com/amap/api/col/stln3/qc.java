package com.amap.api.col.stln3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.track.query.entity.ProtocolType;
import com.amap.api.track.query.model.BaseResponse;

/* compiled from: HttpUtil */
public final class qc {
    public static BaseResponse a(Context context, qf qfVar, int i) {
        ty tyVar;
        if (!b(context)) {
            return qu.a();
        }
        if (qfVar == null) {
            qr.a("BaseRequest is null");
            return qu.b();
        }
        qfVar.setProtocolType(i);
        qfVar.setContext(context);
        String str = "";
        try {
            if (1 == qfVar.getMethod()) {
                tv.b();
                tyVar = tv.a(qfVar, ProtocolType.isHttps(i));
            } else {
                tv.b();
                tyVar = tv.c(qfVar, ProtocolType.isHttps(i));
            }
            if (tyVar != null) {
                if (tyVar.a != null) {
                    byte[] bArr = tyVar.a;
                    if (qfVar.isOutputCipher()) {
                        bArr = ql.a(context, bArr);
                    }
                    str = rk.a(bArr);
                    return BaseResponse.createFrom(str);
                }
            }
            return qu.b();
        } catch (Exception e) {
            qr.b("ex " + e);
        }
    }

    private static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context) {
        return b(context);
    }
}
