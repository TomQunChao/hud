package com.amap.api.col.stln3;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: BaseLoader */
public abstract class sl extends ClassLoader {
    protected final Context a;
    protected final Map<String, Class<?>> b = new HashMap();
    protected DexFile c = null;
    volatile boolean d = true;
    protected rj e;
    protected String f;
    protected volatile boolean g = false;
    protected volatile boolean h = false;

    public sl(Context context, rj rjVar) {
        super(context.getClassLoader());
        this.a = context;
        this.e = rjVar;
    }

    public final boolean a() {
        return this.c != null;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
            if (this.c != null) {
                if (this.h) {
                    synchronized (this.c) {
                        this.c.wait();
                    }
                }
                this.g = true;
                this.c.close();
            }
        } catch (Throwable th) {
            ru.a(th, "BaseLoader", "releaseDexFile()");
        }
    }
}
