package com.amap.api.col.stln3;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil */
public final class rf {
    private volatile b a = new b((byte) 0);
    private tl b = new tl("HttpsDecisionUtil");

    /* access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil */
    public static class a {
        static rf a = new rf();
    }

    public static rf a() {
        return a.a;
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.a(this.b.a(context, "isTargetRequired"));
        this.a.a(context);
    }

    public final void b(Context context) {
        this.b.a(context, "isTargetRequired", true);
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(z);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.b.a(context, "isTargetRequired", z);
        this.a.a(z);
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        return this.a.a();
    }

    /* access modifiers changed from: private */
    /* compiled from: HttpsDecisionUtil */
    public static class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void b(boolean z) {
            this.d = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a() {
            /*
                r5 = this;
                boolean r0 = r5.d
                r1 = 1
                if (r0 != 0) goto L_0x0030
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto L_0x000e
                r0 = 1
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                boolean r4 = r5.a
                if (r4 == 0) goto L_0x0024
                int r4 = r5.b
                if (r4 > 0) goto L_0x001a
                r4 = 28
            L_0x001a:
                if (r4 < r2) goto L_0x001e
                r2 = 1
                goto L_0x001f
            L_0x001e:
                r2 = 0
            L_0x001f:
                if (r2 == 0) goto L_0x0022
                goto L_0x0024
            L_0x0022:
                r2 = 0
                goto L_0x0025
            L_0x0024:
                r2 = 1
            L_0x0025:
                if (r0 == 0) goto L_0x002b
                if (r2 == 0) goto L_0x002b
                r0 = 1
                goto L_0x002c
            L_0x002b:
                r0 = 0
            L_0x002c:
                if (r0 == 0) goto L_0x002f
                goto L_0x0030
            L_0x002f:
                return r3
            L_0x0030:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.rf.b.a():boolean");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable th) {
            return str;
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final boolean b(boolean z) {
        if (c()) {
            return false;
        }
        if (z || b()) {
            return true;
        }
        return false;
    }
}
