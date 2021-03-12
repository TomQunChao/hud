package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.stln3.cf;
import com.amap.api.col.stln3.qz;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: AuthTask */
public final class ce extends Thread {
    WeakReference<co> a = null;
    private Context b;

    public ce(Context context, co coVar) {
        this.b = context;
        this.a = new WeakReference<>(coVar);
    }

    public final void run() {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        qz.a.e eVar;
        JSONObject optJSONObject3;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                rf.a().a(this.b);
                qz.a a2 = qz.a(this.b, ic.f(), "14S" + ";" + "11K" + ";" + "001" + ";" + "14M" + ";" + "14L" + ";" + "151" + ";" + "14Z" + ";" + "154" + ";" + "156" + ";" + "15C", null);
                boolean z = true;
                if (qz.a != 1) {
                    if (a2 != null && this.a != null && this.a.get() != null) {
                        Message obtainMessage = this.a.get().getMainHandler().obtainMessage();
                        obtainMessage.what = 2;
                        if (a2.a != null) {
                            obtainMessage.obj = a2.a;
                        }
                        this.a.get().getMainHandler().sendMessage(obtainMessage);
                    }
                }
                if (!(a2 == null || a2.w == null)) {
                    JSONObject optJSONObject4 = a2.w.optJSONObject("154");
                    if (optJSONObject4 != null) {
                        if (qz.a(optJSONObject4.getString("able"), true)) {
                            String optString = optJSONObject4.optString("mc");
                            String optString2 = optJSONObject4.optString("si");
                            if (!TextUtils.isEmpty(optString)) {
                                ht.a(this.b, "approval_number", "mc", (Object) optString);
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                ht.a(this.b, "approval_number", "si", (Object) optString2);
                            }
                        }
                    }
                }
                if (!(a2 == null || a2.x == null)) {
                    rj f = ic.f();
                    if (f != null) {
                        f.a(a2.x.a);
                    }
                }
                if (!(!MapsInitializer.isDownloadCoordinateConvertLibrary() || a2 == null || a2.B == null)) {
                    new rc(this.b, "3dmap", a2.B.a, a2.B.b).a();
                }
                if (a2 != null) {
                    try {
                        qz.a.C0001a aVar = a2.x;
                        if (aVar != null) {
                            hz.a(this.b, "maploc", "ue", Boolean.valueOf(aVar.a));
                            JSONObject jSONObject = aVar.c;
                            int optInt = jSONObject.optInt("fn", 1000);
                            int optInt2 = jSONObject.optInt("mpn", 0);
                            if (optInt2 > 500) {
                                optInt2 = 500;
                            }
                            if (optInt2 < 30) {
                                optInt2 = 30;
                            }
                            uf.a(optInt, qz.a(jSONObject.optString("igu"), false));
                            hz.a(this.b, "maploc", "opn", Integer.valueOf(optInt2));
                        }
                    } catch (Throwable th) {
                        rx.c(th, "AuthUtil", "loadConfigDataUploadException");
                    }
                }
                if (a2 != null) {
                    try {
                        if (a2.w != null && (optJSONObject3 = a2.w.optJSONObject("14M")) != null && optJSONObject3.has("able") && qz.a(optJSONObject3.getString("able"), true)) {
                            int i = 2592000;
                            if (optJSONObject3.has("time")) {
                                i = Math.max(60, optJSONObject3.getInt("time"));
                            }
                            if (!(System.currentTimeMillis() - ht.a(this.b, "Map3DCache", "time", (Long) 0L).longValue() <= ((long) (i * 1000)) || this.a == null || this.a.get() == null)) {
                                this.a.get().e();
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (!(a2 == null || a2.w == null)) {
                    try {
                        JSONObject optJSONObject5 = a2.w.optJSONObject("14L");
                        if (optJSONObject5 != null && optJSONObject5.has("able")) {
                            boolean a3 = qz.a(optJSONObject5.getString("able"), false);
                            if (!(this.a == null || this.a.get() == null)) {
                                co coVar = this.a.get();
                                if (a3) {
                                    z = false;
                                }
                                coVar.g(z);
                            }
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                if (!(a2 == null || a2.y == null)) {
                    qz.a.d dVar = a2.y;
                    if (dVar != null) {
                        String str = dVar.b;
                        String str2 = dVar.a;
                        String str3 = dVar.c;
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                            new si(this.b, null, ic.f()).a();
                        } else {
                            new si(this.b, new sj(str2, str), ic.f()).a();
                        }
                    } else {
                        new si(this.b, null, ic.f()).a();
                    }
                }
                if (!(a2 == null || a2.G == null)) {
                    su.a().a(this.b, hh.a(), a2.G);
                }
                if (!(a2 == null || a2.z == null || (eVar = a2.z) == null || !eVar.a)) {
                    su.a().a(this.b, hh.a(), AeUtil.SO_FILENAME);
                    Context context = this.b;
                    rj f2 = ic.f();
                    hh.a().c();
                    su.a(context, f2, Arrays.asList("libAMapSDK_MAP_v6_6_0", "libAMapSDK_NAVI_v6_5_0", "librtbt800.so", "libwtbt800.so", "libztcodec2.so"));
                }
                if (!(a2 == null || a2.w == null || (optJSONObject2 = a2.w.optJSONObject("156")) == null)) {
                    hn.a(qz.a(optJSONObject2.optString("able"), false));
                }
                if (!(a2 == null || a2.w == null || (optJSONObject = a2.w.optJSONObject("15C")) == null)) {
                    final boolean a4 = qz.a(optJSONObject.optString("able"), false);
                    final String optString3 = optJSONObject.optString("logo_day_url");
                    final String optString4 = optJSONObject.optString("logo_day_md5");
                    final String optString5 = optJSONObject.optString("logo_night_url");
                    final String optString6 = optJSONObject.optString("logo_night_md5");
                    ib.a().a(new Runnable() {
                        /* class com.amap.api.col.stln3.ce.AnonymousClass1 */

                        public final void run() {
                            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString3)) {
                                boolean z = a4;
                                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                                String str2 = optString3;
                                String str3 = optString4;
                                if (z) {
                                    cf.d dVar = new cf.d(str2, str3, str);
                                    dVar.a("amap_web_logo", "md5_day");
                                    Context context = ce.this.b;
                                    ic.f();
                                    new cf(context, dVar).a();
                                }
                                if (!(ce.this.a == null || ce.this.a.get() == null)) {
                                    ce.this.a.get().a(str, z, 0);
                                }
                            }
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString5)) {
                                boolean z2 = a4;
                                String str4 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
                                String str5 = optString5;
                                String str6 = optString6;
                                if (z2) {
                                    cf.d dVar2 = new cf.d(str5, str6, str4);
                                    dVar2.a("amap_web_logo", "md5_night");
                                    Context context2 = ce.this.b;
                                    ic.f();
                                    new cf(context2, dVar2).a();
                                }
                                if (ce.this.a != null && ce.this.a.get() != null) {
                                    ce.this.a.get().a(str4, z2, 1);
                                }
                            }
                        }
                    });
                }
                rx.a(this.b, ic.f());
                interrupt();
                if (this.a != null && this.a.get() != null) {
                    this.a.get().setRunLowFrame(false);
                }
            }
        } catch (Throwable th4) {
            interrupt();
            rx.c(th4, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th4.printStackTrace();
        }
    }
}
