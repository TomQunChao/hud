package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* compiled from: DynamicSoManager */
public final class mh {
    private static mh c;
    boolean a = true;
    private Context b;
    private String d = "com.alibaba.idst.nls.tts.TtsManager";
    private Object e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    public static mh a(Context context) {
        if (c == null) {
            c = new mh(context);
        }
        return c;
    }

    private mh(Context context) {
        this.b = context;
    }

    public final boolean a() {
        try {
            if (mf.a() && mf.b()) {
                rj a2 = mj.a("offtts", "1.0.0");
                this.f = sk.b(this.b, a2);
                String a3 = sk.a(this.b, a2);
                if (TextUtils.isEmpty(a3)) {
                    return false;
                }
                if (!this.f || !new File(a3).exists()) {
                    mi.a(a3);
                } else {
                    this.g = ly.b(this.b, "tts_so_unzip", false);
                    if (!this.g) {
                        String f2 = f();
                        String substring = a3.substring(a3.lastIndexOf(File.separator) + 1, a3.lastIndexOf("."));
                        Context context = this.b;
                        mi.a(context.getFilesDir().getAbsolutePath() + "/tts");
                        mi.a(f2);
                        if (!f2.endsWith(File.separator)) {
                            f2 = f2 + File.separator;
                        }
                        mi.a(f2);
                        mi.a(a3, f2 + substring);
                        this.g = true;
                        ly.a(this.b, "tts_so_unzip", true);
                    }
                    if (this.g) {
                        this.e = sk.a(this.b, a2, this.d, null, new Class[]{Context.class}, new Object[]{this.b});
                        this.h = b(a3);
                        if (this.h) {
                            try {
                                if (!(this.b == null || this.e == null)) {
                                    ml.a(this.e, "init", me.a, me.b);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.h;
    }

    private String f() {
        return this.b.getFilesDir().getAbsolutePath() + File.separator + "ttszip";
    }

    private boolean b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String f2 = f();
            String substring = str.substring(str.lastIndexOf(File.separator) + 1, str.lastIndexOf("."));
            String a2 = rk.a(this.b);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(File.separator);
            sb.append(substring);
            sb.append(File.separator);
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.append("assets");
            sb2.append(File.separator);
            String str2 = sb + "libs" + File.separator + a2 + File.separator;
            File file = new File(str2);
            if (file.exists()) {
                if (!file.isFile()) {
                    if (new File(sb2.toString()).exists() && this.e != null) {
                        boolean booleanValue = ((Boolean) ml.a(this.e, "loadSo", str2)).booleanValue();
                        boolean booleanValue2 = ((Boolean) ml.a(this.e, "loadAssertResource", sb2.toString())).booleanValue();
                        if (!booleanValue || !booleanValue2) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            if (this.a && this.b != null && this.e != null) {
                ml.a(this.e, "playText", str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            if (this.b != null) {
                if (this.e != null) {
                    ml.a(this.e, "stopSpeak", new Object[0]);
                }
                this.a = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c() {
        try {
            if (this.b != null) {
                if (this.e != null) {
                    ml.a(this.e, "destroy", new Object[0]);
                }
                c = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean d() {
        return this.h;
    }

    public final void e() {
        this.a = true;
    }
}
