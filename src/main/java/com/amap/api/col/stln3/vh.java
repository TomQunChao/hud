package com.amap.api.col.stln3;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: CoManager */
public final class vh {
    boolean a = false;
    boolean b = false;
    private String c = "com.amap.opensdk.co.CoManager";
    private Context d;
    private Object e = null;
    private int f = -1;
    private boolean g = false;

    public vh(Context context) {
        this.d = context;
    }

    public final void a() {
        try {
            if (!vt.C()) {
                c();
            } else if (!vt.E()) {
                if (this.a) {
                    try {
                        if (this.e != null) {
                            vx.a(this.e, "destroyCollect", new Object[0]);
                        }
                    } catch (Throwable th) {
                        vu.a(th, "APSCoManager", "destroyCollection");
                    }
                    this.a = false;
                }
            } else if (!this.a) {
                e();
                if (this.e != null) {
                    vx.a(this.e, "startCollect", new Object[0]);
                    this.a = true;
                }
            }
        } catch (Throwable th2) {
            vu.a(th2, "APSCoManager", "startCollection");
        }
    }

    public final String b() {
        try {
            if (!vt.C()) {
                c();
                return null;
            } else if (this.e != null) {
                return (String) vx.a(this.e, "getCollectVersion", new Object[0]);
            } else {
                return null;
            }
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "getCollectionVersion");
            return null;
        }
    }

    public final vc a(vg vgVar, List<ScanResult> list, vc vcVar) {
        try {
            if (!d()) {
                return vcVar;
            }
            if (vcVar != null) {
                if (vcVar.getErrorCode() == 7) {
                    return vcVar;
                }
            }
            e();
            if (this.e != null) {
                this.b = true;
                String a2 = a(vgVar);
                ScanResult[] a3 = a(list);
                Object a4 = vx.a(this.e, "getOfflineLoc", new Class[]{String.class, ScanResult[].class, Boolean.TYPE}, new Object[]{a2, a3, false});
                if (a4 != null) {
                    JSONObject jSONObject = new JSONObject((String) a4);
                    vc vcVar2 = new vc("lbs");
                    vcVar2.b(jSONObject);
                    if (wc.a(vcVar2)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (vcVar2.e().equals("file")) {
                            stringBuffer.append("基站离线定位");
                        } else if (vcVar2.e().equals("wifioff")) {
                            stringBuffer.append("WIFI离线定位");
                        } else {
                            stringBuffer.append("离线定位，");
                            stringBuffer.append(vcVar2.e());
                        }
                        if (vcVar != null) {
                            stringBuffer.append("，在线定位失败原因:" + vcVar.getErrorInfo());
                        }
                        vcVar2.setTrustedLevel(2);
                        vcVar2.setLocationDetail(stringBuffer.toString());
                        vcVar2.setLocationType(8);
                    }
                    return vcVar2;
                }
            }
            return vcVar;
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "getOffLoc");
        }
    }

    private boolean d() {
        if (!vt.C()) {
            c();
            return false;
        } else if (vt.D()) {
            return true;
        } else {
            if (this.b) {
                try {
                    if (this.e != null) {
                        vx.a(this.e, "destroyOfflineLoc", new Object[0]);
                    }
                } catch (Throwable th) {
                    vu.a(th, "APSCoManager", "destroyOffline");
                }
                this.b = false;
            }
            return false;
        }
    }

    private void a(vg vgVar, List<ScanResult> list, vc vcVar, int i) {
        try {
            if (d() && wc.a(vcVar)) {
                e();
                if (this.e != null) {
                    String a2 = a(vgVar);
                    ScanResult[] a3 = a(list);
                    if (i == 1) {
                        vx.a(this.e, "trainingFps", new Class[]{String.class, ScanResult[].class}, new Object[]{a2, a3});
                    } else if (i == 2) {
                        vx.a(this.e, "correctOfflineLocation", new Class[]{String.class, ScanResult[].class, Double.TYPE, Double.TYPE}, new Object[]{a2, a3, Double.valueOf(vcVar.getLatitude()), Double.valueOf(vcVar.getLongitude())});
                    } else {
                        return;
                    }
                    this.b = true;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("action-");
            sb.append(1 == i ? "training" : "correct");
            vu.a(th, "APSCoManager", sb.toString());
        }
    }

    public final void b(vg vgVar, List<ScanResult> list, vc vcVar) {
        try {
            a(vgVar, list, vcVar, 1);
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "trainingFps");
        }
    }

    public final void c(vg vgVar, List<ScanResult> list, vc vcVar) {
        try {
            a(vgVar, list, vcVar, 2);
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "correctOffLoc");
        }
    }

    public final void c() {
        try {
            if (this.e != null) {
                vx.a(this.e, "destroy", new Object[0]);
            }
            this.a = false;
            this.b = false;
            this.e = null;
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "destroy");
        }
    }

    private static String a(vg vgVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (vgVar == null) {
                return null;
            }
            vf c2 = vgVar.c();
            vf d2 = vgVar.d();
            if (c2 != null) {
                jSONObject.put("mainCgi", c2.a());
            }
            if (d2 != null) {
                jSONObject.put("mainCgi2", d2.a());
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "buildCgiJsonStr");
            return null;
        }
    }

    private static ScanResult[] a(List<ScanResult> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            ScanResult[] scanResultArr = new ScanResult[list.size()];
            for (int i = 0; i < list.size(); i++) {
                scanResultArr[i] = list.get(i);
            }
            return scanResultArr;
        } catch (Throwable th) {
            vu.a(th, "APSCoManager", "buildScanResults");
            return null;
        }
    }

    private void e() {
        try {
            if (this.e == null && !this.g && vt.G()) {
                rj a2 = vu.a("co", "1.0.0");
                this.g = vz.a(this.d, a2);
                if (this.g) {
                    try {
                        this.e = sk.a(this.d, a2, this.c, null, new Class[]{Context.class}, new Object[]{this.d});
                        try {
                            if (this.d != null) {
                                String a3 = a(this.d);
                                if (this.e != null) {
                                    vx.a(this.e, "init", a3);
                                }
                            }
                        } catch (Throwable th) {
                            vu.a(th, "APSCoManager", "setConfig");
                        }
                        String a4 = sk.a(this.d, a2);
                        if (!TextUtils.isEmpty(a4)) {
                            StringBuffer stringBuffer = new StringBuffer();
                            String str = this.d.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "loc_cozip";
                            String substring = a4.substring(a4.lastIndexOf(File.separator) + 1, a4.lastIndexOf("."));
                            boolean c2 = wc.c(str, substring);
                            boolean b2 = wb.b(this.d, "pref", "ok4", false);
                            if (!c2 || b2) {
                                wb.a(this.d, "pref", "ok4", false);
                                a(a4, str, substring);
                            }
                            String a5 = rk.a(this.d);
                            if (!TextUtils.isEmpty(a5)) {
                                stringBuffer.append(str);
                                stringBuffer.append(File.separator);
                                stringBuffer.append(substring);
                                stringBuffer.append(File.separator);
                                stringBuffer.append("libs");
                                stringBuffer.append(File.separator);
                                stringBuffer.append(a5);
                                stringBuffer.append(File.separator);
                                stringBuffer.append("libapssdk.so");
                                String stringBuffer2 = stringBuffer.toString();
                                File file = new File(stringBuffer2);
                                if (!file.exists()) {
                                    a(a4, str, substring);
                                }
                                if (file.exists() && this.e != null) {
                                    vx.a(this.e, "loadSo", stringBuffer2);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                    }
                } else {
                    this.g = true;
                }
            }
            try {
                int F = vt.F();
                if (this.f != F) {
                    this.f = F;
                    if (this.e != null) {
                        vx.a(this.e, "setCloudConfigVersion", Integer.valueOf(F));
                    }
                }
            } catch (Throwable th3) {
                vu.a(th3, "APSCoManager", "setCloudVersion");
            }
        } catch (Throwable th4) {
            vu.a(th4, "APSCoManager", "initOffLocation");
        }
    }

    private static void a(String str, String str2, String str3) {
        if (!str2.endsWith(File.separator)) {
            str2 = str2 + File.separator;
        }
        wc.e(str2);
        wc.b(str, str2 + str3);
    }

    private static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sv", "4.5.0");
            jSONObject.put("als", "S128DF1572465B890OE3F7A13167KLEI");
            jSONObject.put("pn", qy.c(context));
            jSONObject.put("ak", qy.f(context));
            jSONObject.put("ud", rd.h(context));
            jSONObject.put("au", rd.b(context));
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }
}
