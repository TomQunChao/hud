package com.amap.api.col.stln3;

import android.content.Context;
import java.util.Map;

/* compiled from: PoiSearch */
public final class lq {
    private lb a = null;

    /* compiled from: PoiSearch */
    public interface a {
        void a(ln lnVar, int i);
    }

    public lq(Context context, b bVar) {
        if (this.a == null) {
            try {
                this.a = new lr(context, bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(a aVar) {
        lb lbVar = this.a;
        if (lbVar != null) {
            lbVar.a(aVar);
        }
    }

    public final void a(String str) {
        lb lbVar = this.a;
        if (lbVar != null) {
            lbVar.a(str);
        }
    }

    /* compiled from: PoiSearch */
    public static class b implements Cloneable {
        private String a;
        private String b;
        private String c;
        private int d = 1;
        private int e = 20;
        private String f = "zh-CN";
        private boolean g = false;
        private boolean h = false;
        private String i;
        private boolean j = true;
        private li k;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public final void a() {
            this.h = true;
        }

        public final void b() {
            this.j = false;
        }

        public final int hashCode() {
            String str = this.b;
            int i2 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.c;
            int i3 = 1231;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.g ? 1231 : 1237)) * 31;
            if (!this.h) {
                i3 = 1237;
            }
            int i4 = (hashCode2 + i3) * 31;
            String str3 = this.f;
            int hashCode3 = (((((i4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str4 = this.a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.i;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode4 + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            String str = this.b;
            if (str == null) {
                if (bVar.b != null) {
                    return false;
                }
            } else if (!str.equals(bVar.b)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null) {
                if (bVar.c != null) {
                    return false;
                }
            } else if (!str2.equals(bVar.c)) {
                return false;
            }
            String str3 = this.f;
            if (str3 == null) {
                if (bVar.f != null) {
                    return false;
                }
            } else if (!str3.equals(bVar.f)) {
                return false;
            }
            if (this.d != bVar.d || this.e != bVar.e) {
                return false;
            }
            String str4 = this.a;
            if (str4 == null) {
                if (bVar.a != null) {
                    return false;
                }
            } else if (!str4.equals(bVar.a)) {
                return false;
            }
            String str5 = this.i;
            if (str5 == null) {
                if (bVar.i != null) {
                    return false;
                }
            } else if (!str5.equals(bVar.i)) {
                return false;
            }
            if (this.g == bVar.g && this.h == bVar.h) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.amap.api.col.stln3.lq.b clone() {
            /*
                r4 = this;
                super.clone()     // Catch:{ CloneNotSupportedException -> 0x0004 }
                goto L_0x000c
            L_0x0004:
                r0 = move-exception
                java.lang.String r1 = "PoiSearch"
                java.lang.String r2 = "queryclone"
                com.amap.api.col.stln3.la.a(r0, r1, r2)
            L_0x000c:
                com.amap.api.col.stln3.lq$b r0 = new com.amap.api.col.stln3.lq$b
                java.lang.String r1 = r4.a
                java.lang.String r2 = r4.b
                java.lang.String r3 = r4.c
                r0.<init>(r1, r2, r3)
                int r1 = r4.d
                r0.d = r1
                int r1 = r4.e
                if (r1 > 0) goto L_0x0024
                r1 = 20
            L_0x0021:
                r0.e = r1
                goto L_0x002c
            L_0x0024:
                r2 = 30
                if (r1 <= r2) goto L_0x002b
                r0.e = r2
                goto L_0x002c
            L_0x002b:
                goto L_0x0021
            L_0x002c:
                java.lang.String r1 = r4.f
                java.lang.String r2 = "en"
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x0039
                java.lang.String r1 = "en"
                goto L_0x003b
            L_0x0039:
                java.lang.String r1 = "zh-CN"
            L_0x003b:
                r0.f = r1
                boolean r1 = r4.g
                r0.g = r1
                boolean r1 = r4.h
                r0.h = r1
                java.lang.String r1 = r4.i
                r0.i = r1
                com.amap.api.col.stln3.li r1 = r4.k
                r0.k = r1
                boolean r1 = r4.j
                r0.j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.lq.b.clone():com.amap.api.col.stln3.lq$b");
        }
    }

    public final Map<String, ln> a(lm lmVar) throws kv {
        lb lbVar = this.a;
        if (lbVar != null) {
            return lbVar.a(lmVar);
        }
        return null;
    }
}
