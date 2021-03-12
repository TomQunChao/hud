package com.amap.api.col.stln3;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: MapParser */
public final class wo {
    private StringBuilder a = new StringBuilder();

    public final wl a(String str, Context context, ty tyVar) {
        wl wlVar = new wl("");
        wlVar.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(NotificationCompat.CATEGORY_STATUS) || !jSONObject.has("info")) {
                StringBuilder sb = this.a;
                sb.append("json is error " + str);
            }
            String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:" + th.getMessage());
            wy.a(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            StringBuilder sb4 = this.a;
            sb4.append("#SHA1AndPackage#");
            sb4.append(qy.e(context));
            String str2 = tyVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb5 = this.a;
                sb5.append(" #gsid#");
                sb5.append(str2);
            }
            String str3 = tyVar.c;
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb6 = this.a;
                sb6.append(" #csid#" + str3);
            }
        } catch (Throwable th2) {
        }
        wlVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            StringBuilder sb7 = this.a;
            sb7.delete(0, sb7.length());
        }
        return wlVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c6, code lost:
        if (r2 == null) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c8, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02f9, code lost:
        if (0 == 0) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0302, code lost:
        if (r13.a.length() <= 0) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0304, code lost:
        r14 = r13.a;
        r14.delete(0, r14.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x030d, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.wl a(byte[] r14) {
        /*
        // Method dump skipped, instructions count: 788
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.wo.a(byte[]):com.amap.api.col.stln3.wl");
    }
}
