package com.amap.api.col.stln3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.col.stln3.go;
import com.amap.api.col.stln3.ig;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.stln3.if  reason: invalid class name */
/* compiled from: AbstractImageWorker */
public abstract class Cif {
    private ig a;
    private ig.a b;
    protected boolean c = false;
    protected Resources d;
    private boolean e = false;
    private final Object f = new Object();
    private c g = null;

    /* renamed from: com.amap.api.col.stln3.if$c */
    /* compiled from: AbstractImageWorker */
    public interface c {
        void a();
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap a(Object obj);

    protected Cif(Context context) {
        this.d = context.getResources();
    }

    public final void a(boolean z, go.a aVar) {
        if (aVar != null) {
            Bitmap bitmap = null;
            try {
                if (this.a != null) {
                    bitmap = this.a.a(aVar.a + "-" + aVar.b + "-" + aVar.c);
                }
                if (bitmap != null) {
                    aVar.a(bitmap);
                    return;
                }
                a aVar2 = new a(aVar);
                aVar.j = aVar2;
                aVar2.a(hc.c, Boolean.valueOf(z));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(ig.a aVar) {
        this.b = aVar;
        this.a = ig.a(this.b);
        new b().b(1);
    }

    /* access modifiers changed from: protected */
    public final ig a() {
        return this.a;
    }

    public static void a(go.a aVar) {
        a c2 = c(aVar);
        if (c2 != null) {
            c2.d();
        }
    }

    /* access modifiers changed from: private */
    public static a c(go.a aVar) {
        if (aVar != null) {
            return aVar.j;
        }
        return null;
    }

    /* renamed from: com.amap.api.col.stln3.if$a */
    /* compiled from: AbstractImageWorker */
    public class a extends hc<Boolean, Void, Bitmap> {
        private final WeakReference<go.a> e;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.stln3.hc
        public final /* synthetic */ void a(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                if (c() || Cif.this.e) {
                    bitmap2 = null;
                }
                go.a e2 = e();
                if (bitmap2 != null && !bitmap2.isRecycled() && e2 != null) {
                    e2.a(bitmap2);
                    if (Cif.this.g != null) {
                        Cif.this.g.a();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // com.amap.api.col.stln3.hc
        public final /* synthetic */ void b(Bitmap bitmap) {
            super.b(bitmap);
            synchronized (Cif.this.f) {
                try {
                    Cif.this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public a(go.a aVar) {
            this.e = new WeakReference<>(aVar);
        }

        /* access modifiers changed from: private */
        public Bitmap a(Boolean... boolArr) {
            Bitmap bitmap;
            try {
                boolean booleanValue = boolArr[0].booleanValue();
                go.a aVar = this.e.get();
                if (aVar == null) {
                    return null;
                }
                String str = aVar.a + "-" + aVar.b + "-" + aVar.c;
                synchronized (Cif.this.f) {
                    while (Cif.this.c && !c()) {
                        Cif.this.f.wait();
                    }
                }
                if (Cif.this.a == null || c() || e() == null || Cif.this.e) {
                    bitmap = null;
                } else {
                    bitmap = Cif.this.a.b(str);
                }
                if (booleanValue && bitmap == null && !c() && e() != null && !Cif.this.e) {
                    synchronized (Cif.class) {
                        bitmap = Cif.this.a((Object) aVar);
                    }
                }
                if (!(bitmap == null || Cif.this.a == null)) {
                    Cif.this.a.a(str, bitmap);
                }
                return bitmap;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private go.a e() {
            go.a aVar = this.e.get();
            if (this == Cif.c(aVar)) {
                return aVar;
            }
            return null;
        }
    }

    public final void a(boolean z) {
        synchronized (this.f) {
            this.c = z;
            if (!this.c) {
                try {
                    this.f.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.amap.api.col.stln3.if$b */
    /* compiled from: AbstractImageWorker */
    protected class b extends hc<Object, Void, Void> {
        protected b() {
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public Void a(Object... objArr) {
            try {
                switch (((Integer) objArr[0]).intValue()) {
                    case 0:
                        Cif.this.c();
                        return null;
                    case 1:
                        Cif.this.b();
                        return null;
                    case 2:
                        Cif.this.d();
                        return null;
                    case 3:
                        Cif.this.b(((Boolean) objArr[1]).booleanValue());
                        return null;
                    case 4:
                        Cif.this.e();
                        return null;
                    default:
                        return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        ig igVar = this.a;
        if (igVar != null) {
            igVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ig igVar = this.a;
        if (igVar != null) {
            igVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        ig igVar = this.a;
        if (igVar != null) {
            igVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z) {
        ig igVar = this.a;
        if (igVar != null) {
            igVar.a(z);
            this.a = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        ig igVar = this.a;
        if (igVar != null) {
            igVar.a(false);
            this.a.a();
        }
    }

    public final void f() {
        new b().b(0);
    }

    public final void c(boolean z) {
        new b().b(3, Boolean.valueOf(z));
    }

    public final void a(c cVar) {
        this.g = cVar;
    }

    public final void a(String str) {
        ig.a aVar = this.b;
        aVar.c = ig.a(ct.a, aVar.j, str);
        new b().b(4);
    }
}
