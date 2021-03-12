package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.NativeConfigInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoManagerCore */
public final class tk {
    private sw a;
    private sz b;
    private ti c;
    private tf d;
    private List<tg> e = new ArrayList();

    public tk(Context context) {
        this.a = new sw(context);
        this.b = new sz();
        this.d = new tf(this.b, this.a, context);
    }

    public final void a(final Context context, final rj rjVar, String str, final boolean z, final boolean z2, String str2, String str3, boolean z3) {
        this.c = th.a(context);
        final ti tiVar = new ti(str, str2, str3, z2, z3);
        final ti b2 = th.b(context);
        this.b.a(new Runnable() {
            /* class com.amap.api.col.stln3.tk.AnonymousClass1 */

            public final void run() {
                if (!z) {
                    tk tkVar = tk.this;
                    tk.a(context, rjVar.a());
                    return;
                }
                tk tkVar2 = tk.this;
                tk.a(context, rjVar.a(), z2);
                if (z2 && ti.a(tiVar)) {
                    tk tkVar3 = tk.this;
                    tkVar3.a(context, rjVar, tiVar, tkVar3.c, b2);
                }
            }
        });
    }

    public final void a(Context context, rj rjVar, ti tiVar, ti tiVar2, ti tiVar3) {
        ta taVar = new ta(tiVar, this.a);
        if (tiVar != null) {
            if (ti.a(tiVar)) {
                if (tiVar2 != null) {
                    if (ti.a(tiVar2)) {
                        List<tg> d2 = tiVar.d();
                        List<tg> d3 = tiVar2.d();
                        if (d2 != null) {
                            if (d3 != null) {
                                HashSet hashSet = new HashSet();
                                HashSet hashSet2 = new HashSet();
                                for (int i = 0; i < d2.size(); i++) {
                                    tg tgVar = d2.get(i);
                                    for (int i2 = 0; i2 < d3.size(); i2++) {
                                        tg tgVar2 = d3.get(i2);
                                        if (tgVar2.a().equals(tiVar.a()) && tg.a(tgVar2, tgVar) && tgVar.b && !tgVar2.b) {
                                            hashSet2.add(tgVar2.b());
                                            hashSet.add(tgVar2.f());
                                        }
                                    }
                                }
                                Iterator it = hashSet2.iterator();
                                boolean z = false;
                                while (it.hasNext()) {
                                    String str = (String) it.next();
                                    boolean z2 = z;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= d3.size()) {
                                            z = z2;
                                            break;
                                        }
                                        tg tgVar3 = d3.get(i3);
                                        if (!hashSet.contains(tgVar3.f())) {
                                            z = false;
                                            break;
                                        }
                                        if (tgVar3.b().equals(str)) {
                                            tgVar3.b = true;
                                            z2 = true;
                                        }
                                        i3++;
                                    }
                                }
                                if (z) {
                                    th.a(context, tiVar2);
                                }
                            }
                        }
                    }
                }
            }
        }
        new te(context, taVar, rjVar, tiVar, tiVar2, tiVar3, this.a).a();
    }

    public final boolean a(Context context, rj rjVar, String str, boolean z) {
        if (rjVar == null) {
            return false;
        }
        try {
            return b(context, rjVar, str, z);
        } catch (Throwable th) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("lib")) {
            str = "lib" + str;
        }
        if (str.endsWith(".so")) {
            return str;
        }
        return str + ".so";
    }

    private boolean b(final Context context, final rj rjVar, final String str, boolean z) {
        try {
            rk.a(context);
            int a2 = a(context, str, rjVar);
            if (this.b != null) {
                this.b.a();
            }
            if ((a2 & 4) > 0) {
                this.b.a(new Runnable() {
                    /* class com.amap.api.col.stln3.tk.AnonymousClass3 */

                    public final void run() {
                        Context context = context;
                        if (context != null) {
                            th.c(context);
                        }
                        sw.d(tk.this.a.a());
                    }
                });
            }
            if ((a2 & 8) > 0) {
                this.b.a(new Runnable() {
                    /* class com.amap.api.col.stln3.tk.AnonymousClass4 */

                    public final void run() {
                        tk tkVar = tk.this;
                        String b2 = tk.b(str);
                        tk.this.c = th.a(context);
                        tg a2 = tk.this.c.a(b2);
                        if (a2 != null && a2.g()) {
                            String b3 = a2.b();
                            ArrayList arrayList = new ArrayList();
                            ArrayList<tg> arrayList2 = new ArrayList();
                            for (tg tgVar : tk.this.c.d()) {
                                if (tgVar.b().equals(b3)) {
                                    sw.e(tk.this.a.a() + File.separator + sw.a(context, b2));
                                } else {
                                    arrayList.add(tgVar);
                                }
                            }
                            tk.this.c.g = arrayList;
                            th.a(context, tk.this.c);
                            for (tg tgVar2 : arrayList2) {
                                th.a(context, tgVar2);
                            }
                        }
                    }
                });
            }
            if ((a2 & 2) > 0) {
                this.b.a(new Runnable() {
                    /* class com.amap.api.col.stln3.tk.AnonymousClass2 */

                    public final void run() {
                        boolean z;
                        ti b2 = th.b(context);
                        if (rjVar.a().equals(b2.a())) {
                            tk tkVar = tk.this;
                            Context context = context;
                            rj rjVar = rjVar;
                            boolean z2 = true;
                            if (b2 != null && !TextUtils.isEmpty(b2.a()) && !TextUtils.isEmpty(b2.b()) && rjVar.a().equals(b2.a()) && rjVar.b().equals(b2.b()) && tc.a(rjVar.b(), b2.c()) < 0 && b2.d() != null) {
                                Iterator<tg> it = b2.d().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (th.b(context, it.next())) {
                                            break;
                                        }
                                    } else {
                                        z = true;
                                        break;
                                    }
                                }
                            } else {
                                z = false;
                            }
                            if (!z) {
                                tk.this.d.a(rjVar.a());
                                return;
                            }
                            ti a2 = th.a(context);
                            tk tkVar2 = tk.this;
                            if (b2 == null || TextUtils.isEmpty(b2.c()) || (a2 != null && !TextUtils.isEmpty(a2.c()) && tc.a(a2.c(), b2.c()) > 0)) {
                                z2 = false;
                            }
                            if (!z2) {
                                tk.this.d.a(b2.a());
                            } else {
                                ta.a(context, tk.this.a);
                            }
                        }
                    }
                });
            }
            if ((a2 & 1) > 0) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            System.loadLibrary(str);
            return !z;
        } catch (Throwable th2) {
            return false;
        }
    }

    private int a(Context context, String str, rj rjVar) {
        String str2;
        rk.a(context);
        String b2 = b(str);
        sw swVar = this.a;
        if (swVar == null || TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = swVar.a() + File.separator + sw.a(context, b(str));
        }
        this.c = th.a(context);
        tg a2 = this.c.a(b2);
        if (a2 == null || !a2.g()) {
            return 2;
        }
        if (a2 != null && a2.g() && !c(str2)) {
            return 6;
        }
        if (!c(str2)) {
            return 2;
        }
        if (th.b(context, a2)) {
            return 10;
        }
        String a3 = sw.a(context, b2);
        if (a2.b && a(context, a2, a3, rjVar)) {
            this.e.add(a2);
            System.load(str2);
            try {
                a();
                return 3;
            } catch (Throwable th) {
                return 3;
            }
        } else if (!a(context, a2, a3, rjVar)) {
            return 6;
        } else {
            return 2;
        }
    }

    public final void a() {
        List<tg> list = this.e;
        if (list != null && list.size() != 0 && tj.a) {
            NativeConfigInfo.setConfigInfo(a(tj.b, this.e, tj.c));
        }
    }

    private static String a(rj rjVar, List<tg> list, List<String> list2) {
        JSONObject jSONObject = new JSONObject();
        String a2 = tg.a(list);
        String a3 = a(list2);
        String a4 = a(rjVar);
        try {
            jSONObject.put("ik", a2);
            jSONObject.put("jk", a3);
            jSONObject.put("lk", a4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String a(rj rjVar) {
        if (rjVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sn", rjVar.a());
            jSONObject.put("sv", rjVar.b());
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    private boolean a(Context context, tg tgVar, String str, rj rjVar) {
        boolean z;
        boolean z2;
        if (tgVar == null) {
            z = false;
        } else if (TextUtils.isEmpty(tgVar.c()) || TextUtils.isEmpty(tgVar.d())) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            z2 = false;
        } else if (!rjVar.a().equals(tgVar.c()) || !rjVar.b().equals(tgVar.d()) || tc.a(rjVar.b(), tgVar.e()) >= 0) {
            z2 = false;
        } else if (th.b(context, tgVar)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (sw.c(tgVar.a, this.a.a() + File.separator + str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(String str) {
        File file = new File(str);
        return file.exists() && !file.isDirectory();
    }

    private static List<tg> a(ti tiVar, String str) {
        if (tiVar == null || tiVar.d() == null || TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        List<tg> d2 = tiVar.d();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < d2.size(); i++) {
            tg tgVar = d2.get(i);
            if (str.equals(tgVar.a())) {
                arrayList.add(tgVar);
            }
        }
        return arrayList;
    }

    public static void a(Context context, String str, boolean z) {
        try {
            ti a2 = th.a(context);
            List<tg> a3 = a(a2, str);
            boolean z2 = false;
            for (int i = 0; i < a3.size(); i++) {
                tg tgVar = a3.get(i);
                if (tgVar.b != z) {
                    tgVar.b = z;
                    z2 = true;
                }
            }
            if (z2) {
                th.a(context, a2);
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str) {
        List<tg> a2 = a(th.a(context), str);
        for (int i = 0; i < a2.size(); i++) {
            th.a(context, a2.get(i));
        }
    }
}
