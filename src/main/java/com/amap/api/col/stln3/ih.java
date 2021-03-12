package com.amap.api.col.stln3;

/* compiled from: RectPacker */
public class ih {
    b a = new b(new c(0, 0, 512, 1024));

    /* access modifiers changed from: package-private */
    /* compiled from: RectPacker */
    public enum a {
        FAIL,
        PERFECT,
        FIT
    }

    public final c a(int i, int i2, String str) {
        b a2 = this.a.a(i, i2, str);
        if (a2 != null) {
            return new c(a2.b.a, a2.b.b, a2.b.c, a2.b.d);
        }
        return null;
    }

    public final boolean a(String str) {
        return this.a.a(str);
    }

    public final int a() {
        return this.a.b.c;
    }

    public final int b() {
        return this.a.b.d;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: RectPacker */
    public class b {
        static final /* synthetic */ boolean e = (!ih.class.desiredAssertionStatus());
        String a;
        c b;
        b c = null;
        b d = null;

        b(c cVar) {
            this.b = cVar;
        }

        /* access modifiers changed from: package-private */
        public final b a(int i, int i2, String str) {
            c cVar;
            c cVar2;
            b bVar = this;
            while (bVar.a()) {
                if (bVar.a != null) {
                    return null;
                }
                switch ((i > bVar.b.c || i2 > bVar.b.d) ? a.FAIL : (i == bVar.b.c && i2 == bVar.b.d) ? a.PERFECT : a.FIT) {
                    case FAIL:
                        return null;
                    case PERFECT:
                        bVar.a = str;
                        return bVar;
                    case FIT:
                        int i3 = bVar.b.c - i;
                        int i4 = bVar.b.d - i2;
                        if (!e && i3 < 0) {
                            throw new AssertionError();
                        } else if (e || i4 >= 0) {
                            if (i3 > i4) {
                                cVar2 = new c(bVar.b.a, bVar.b.b, i, bVar.b.d);
                                cVar = new c(cVar2.a + i, bVar.b.b, bVar.b.c - i, bVar.b.d);
                            } else {
                                cVar2 = new c(bVar.b.a, bVar.b.b, bVar.b.c, i2);
                                cVar = new c(bVar.b.a, cVar2.b + i2, bVar.b.c, bVar.b.d - i2);
                            }
                            bVar.c = new b(cVar2);
                            bVar.d = new b(cVar);
                            break;
                        } else {
                            throw new AssertionError();
                        }
                }
                bVar = bVar.c;
            }
            b a2 = bVar.c.a(i, i2, str);
            if (a2 == null) {
                return bVar.d.a(i, i2, str);
            }
            return a2;
        }

        private boolean a() {
            return this.c == null;
        }

        private boolean b() {
            return this.a != null || !a();
        }

        /* access modifiers changed from: package-private */
        public final boolean a(String str) {
            if (!a()) {
                boolean a2 = this.c.a(str);
                if (!a2) {
                    a2 = this.d.a(str);
                }
                if (a2 && !this.c.b() && !this.d.b()) {
                    this.c = null;
                    this.d = null;
                }
                return a2;
            } else if (!str.equals(this.a)) {
                return false;
            } else {
                this.a = null;
                return true;
            }
        }
    }

    /* compiled from: RectPacker */
    public static class c {
        public int a;
        public int b;
        public int c;
        public int d;

        c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public final String toString() {
            return "[ x: " + this.a + ", y: " + this.b + ", w: " + this.c + ", h: " + this.d + " ]";
        }
    }
}
