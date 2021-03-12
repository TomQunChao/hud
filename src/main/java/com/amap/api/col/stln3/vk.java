package com.amap.api.col.stln3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONObject;

/* compiled from: Cache */
public final class vk {
    Hashtable<String, ArrayList<a>> a = new Hashtable<>();
    boolean b = true;
    long c = 0;
    String d = null;
    vf e = null;
    boolean f = true;
    boolean g = true;
    String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private long i = 0;
    private boolean j = false;
    private String k = "2.0.201501131131".replace(".", "");
    private String l = null;
    private String m = null;
    private long n = 0;

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0131 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015f A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0185 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0187 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0196 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a2 A[Catch:{ Throwable -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b1 A[SYNTHETIC, Splitter:B:92:0x01b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, java.lang.StringBuilder r10, com.amap.api.col.stln3.vc r11, android.content.Context r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vk.a(java.lang.String, java.lang.StringBuilder, com.amap.api.col.stln3.vc, android.content.Context, boolean):void");
    }

    public final vc a(Context context, String str, StringBuilder sb, boolean z) {
        if (TextUtils.isEmpty(str) || !vt.u()) {
            return null;
        }
        String str2 = str + "&" + this.f + "&" + this.g + "&" + this.h;
        if (str2.contains(GeocodeSearch.GPS) || !vt.u() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.j) {
            try {
                String a2 = a(str2, sb, context);
                c();
                a(context, a2);
            } catch (Throwable th) {
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        return a(str2, sb);
    }

    private vc a(String str, StringBuilder sb) {
        a aVar;
        try {
            if (str.contains("cgiwifi")) {
                aVar = a(sb, str);
                if (aVar != null) {
                }
            } else if (str.contains("wifi")) {
                aVar = a(sb, str);
                if (aVar != null) {
                }
            } else {
                if (str.contains("cgi")) {
                    if (this.a.containsKey(str)) {
                        aVar = this.a.get(str).get(0);
                    }
                }
                aVar = null;
            }
            if (aVar != null && wc.a(aVar.a())) {
                vc a2 = aVar.a();
                a2.e("mem");
                a2.h(aVar.b());
                if (vt.b(a2.getTime())) {
                    if (wc.a(a2)) {
                        this.c = 0;
                    }
                    a2.setLocationType(4);
                    return a2;
                } else if (this.a != null && this.a.containsKey(str)) {
                    this.a.get(str).remove(aVar);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "Cache", "get1");
        }
        return null;
    }

    private boolean b() {
        long b2 = wc.b();
        long j2 = this.i;
        long j3 = b2 - j2;
        if (j2 == 0) {
            return false;
        }
        if (this.a.size() <= 360 && j3 <= 36000000) {
            return false;
        }
        return true;
    }

    private void c() {
        this.i = 0;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.j = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f9 A[LOOP:1: B:36:0x00f3->B:38:0x00f9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0113 A[LOOP:2: B:40:0x010d->B:42:0x0113, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0188 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0160 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.col.stln3.vk.a a(java.lang.StringBuilder r26, java.lang.String r27) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vk.a(java.lang.StringBuilder, java.lang.String):com.amap.api.col.stln3.vk$a");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            String[] split = str.split("#");
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr.length; i4++) {
            d3 += dArr[i4] * dArr[i4];
            d4 += dArr2[i4] * dArr2[i4];
            d2 += dArr[i4] * dArr2[i4];
            if (dArr2[i4] == 1.0d) {
                i3++;
                if (dArr[i4] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr3[0] = d2 / (Math.sqrt(d3) * Math.sqrt(d4));
        double d5 = (double) i2;
        dArr3[1] = (d5 * 1.0d) / ((double) i3);
        dArr3[2] = d5;
        for (int i5 = 0; i5 < dArr3.length - 1; i5++) {
            if (dArr3[i5] > 1.0d) {
                dArr3[i5] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (!this.j) {
            try {
                c();
                a(context, (String) null);
            } catch (Throwable th) {
                vu.a(th, "Cache", "loadDB");
            }
            this.j = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Cache */
    public static class a {
        private vc a = null;
        private String b = null;

        protected a() {
        }

        public final vc a() {
            return this.a;
        }

        public final void a(vc vcVar) {
            this.a = vcVar;
        }

        public final String b() {
            return this.b;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = null;
            } else {
                this.b = str.replace("##", "#");
            }
        }
    }

    private String a(String str, StringBuilder sb, Context context) {
        String str2;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.l == null) {
                this.l = vj.a("MD5", qy.c(context));
            }
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            String substring = str.substring(str.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                String[] split = sb.toString().split(",access");
                if (split[0].contains("#")) {
                    str2 = split[0].substring(split[0].lastIndexOf("#") + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put("mmac", str2);
            }
            try {
                return re.b(vj.c(jSONObject.toString().getBytes("UTF-8"), this.l));
            } catch (UnsupportedEncodingException e2) {
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context != null) {
            if (this.l == null) {
                this.l = vj.a("MD5", qy.c(context));
            }
            String a2 = a(str, sb, context);
            StringBuilder sb2 = new StringBuilder();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                sb2.append("CREATE TABLE IF NOT EXISTS hist");
                sb2.append(this.k);
                sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                openOrCreateDatabase.execSQL(sb2.toString());
                sb2.delete(0, sb2.length());
                sb2.append("REPLACE INTO ");
                sb2.append("hist");
                sb2.append(this.k);
                sb2.append(" VALUES (?, ?, ?, ?)");
                Object[] objArr = {a2, vj.c(sb.toString().getBytes("UTF-8"), this.l), vj.c(aMapLocation.toStr().getBytes("UTF-8"), this.l), Long.valueOf(aMapLocation.getTime())};
                for (int i2 = 1; i2 < objArr.length - 1; i2++) {
                    objArr[i2] = re.b((byte[]) objArr[i2]);
                }
                openOrCreateDatabase.execSQL(sb2.toString(), objArr);
                sb2.delete(0, sb2.length());
                sb2.delete(0, sb2.length());
                if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } catch (Throwable th) {
                sb2.delete(0, sb2.length());
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r11, java.lang.String r12) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 716
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vk.a(android.content.Context, java.lang.String):void");
    }

    public final void b(Context context) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        Throwable th2;
        try {
            c();
            if (context != null) {
                try {
                    sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                    try {
                        if (wc.a(sQLiteDatabase, "hist")) {
                            try {
                                sQLiteDatabase.delete("hist" + this.k, "time<?", new String[]{String.valueOf(wc.a() - 86400000)});
                            } catch (Throwable th3) {
                                vu.a(th3, "DB", "clearHist");
                                String message = th3.getMessage();
                                if (!TextUtils.isEmpty(message)) {
                                    message.contains("no such table");
                                }
                            }
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        } else if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            vu.a(th2, "DB", "clearHist p2");
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            this.j = false;
                            this.d = null;
                            this.n = 0;
                        } catch (Throwable th5) {
                            th = th5;
                            sQLiteDatabase.close();
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase = null;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            this.j = false;
            this.d = null;
            this.n = 0;
        } catch (Throwable th7) {
            vu.a(th7, "Cache", "destroy part");
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(vf vfVar) {
        this.e = vfVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0067 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0098 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b9 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e3 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f6 A[ADDED_TO_REGION, Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0105 A[Catch:{ Throwable -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010f A[Catch:{ Throwable -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.vc a(com.amap.api.col.stln3.vg r17, boolean r18, com.amap.api.col.stln3.vc r19, com.amap.api.col.stln3.vi r20, java.lang.StringBuilder r21, java.lang.String r22, android.content.Context r23) {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vk.a(com.amap.api.col.stln3.vg, boolean, com.amap.api.col.stln3.vc, com.amap.api.col.stln3.vi, java.lang.StringBuilder, java.lang.String, android.content.Context):com.amap.api.col.stln3.vc");
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a() {
        this.c = 0;
        this.d = null;
    }
}
