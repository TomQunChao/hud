package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.view.TextureView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* compiled from: GLTextureView */
public class ci extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j a = new j((byte) 0);
    private final WeakReference<ci> b = new WeakReference<>(this);
    private i c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

    /* compiled from: GLTextureView */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView */
    public interface k {
        GL a();
    }

    public ci(Context context) {
        super(context, null);
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            if (this.c != null) {
                this.c.g();
            }
        } finally {
            super.finalize();
        }
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        a();
        if (this.f == null) {
            this.f = new m();
        }
        if (this.g == null) {
            this.g = new c(this, (byte) 0);
        }
        if (this.h == null) {
            this.h = new d((byte) 0);
        }
        this.d = renderer;
        this.c = new i(this.b);
        this.c.start();
    }

    public final void a(f fVar) {
        a();
        this.g = fVar;
    }

    public final void a(e eVar) {
        a();
        this.f = eVar;
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void requestRender() {
        this.c.b();
    }

    public int getRenderMode() {
        return this.c.a();
    }

    public void c() {
        this.c.e();
    }

    public void d() {
        this.c.f();
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            i iVar = this.c;
            if (iVar != null) {
                i2 = iVar.a();
            } else {
                i2 = 1;
            }
            this.c = new i(this.b);
            if (i2 != 1) {
                this.c.a(i2);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.g();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    /* compiled from: GLTextureView */
    private class c implements f {
        private c() {
        }

        /* synthetic */ c(ci ciVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.stln3.ci.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, ci.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (ci.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.stln3.ci.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                String str = "display:" + eGLDisplay + " context: " + eGLContext;
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLTextureView */
    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.amap.api.col.stln3.ci.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        @Override // com.amap.api.col.stln3.ci.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView */
    private abstract class a implements e {
        protected int[] a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            if (ci.this.k == 2 || ci.this.k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[(length + 2)];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (ci.this.k == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                iArr = iArr2;
            }
            this.a = iArr;
        }

        @Override // com.amap.api.col.stln3.ci.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* compiled from: GLTextureView */
    private class b extends a {
        protected int c = 8;
        protected int d = 8;
        protected int e = 8;
        protected int f = 0;
        protected int g = 16;
        protected int h = 0;
        private int[] j = new int[1];

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
        }

        @Override // com.amap.api.col.stln3.ci.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j)) {
                return this.j[0];
            }
            return 0;
        }
    }

    /* compiled from: GLTextureView */
    private class m extends b {
        public m() {
            super();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: GLTextureView */
    public static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<ci> f;

        public h(WeakReference<ci> weakReference) {
            this.f = weakReference;
        }

        public final void a() {
            this.a = (EGL10) EGLContext.getEGL();
            this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.b != EGL10.EGL_NO_DISPLAY) {
                if (this.a.eglInitialize(this.b, new int[2])) {
                    ci ciVar = this.f.get();
                    if (ciVar == null) {
                        this.d = null;
                        this.e = null;
                    } else {
                        this.d = ciVar.f.chooseConfig(this.a, this.b);
                        this.e = ciVar.g.createContext(this.a, this.b, this.d);
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext", this.a.eglGetError());
                    }
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public final boolean b() {
            if (this.a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.d != null) {
                f();
                ci ciVar = this.f.get();
                if (ciVar != null) {
                    this.c = ciVar.h.a(this.a, this.b, this.d, ciVar.getSurfaceTexture());
                } else {
                    this.c = null;
                }
                EGLSurface eGLSurface = this.c;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    this.a.eglGetError();
                    return false;
                }
                EGL10 egl10 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface2 = this.c;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.e)) {
                    return true;
                }
                b("eglMakeCurrent", this.a.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public final GL c() {
            GL gl = this.e.getGL();
            ci ciVar = this.f.get();
            if (ciVar == null) {
                return gl;
            }
            if (ciVar.i != null) {
                gl = ciVar.i.a();
            }
            if ((ciVar.j & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((ciVar.j & 1) != 0) {
                i = 1;
            }
            if ((ciVar.j & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public final void d() {
            f();
        }

        private void f() {
            EGLSurface eGLSurface = this.c;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                ci ciVar = this.f.get();
                if (ciVar != null) {
                    ciVar.h.a(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public final void e() {
            if (this.e != null) {
                ci ciVar = this.f.get();
                if (ciVar != null) {
                    ciVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GLTextureView */
    public static class i extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private h s;
        private WeakReference<ci> t;

        i(WeakReference<ci> weakReference) {
            this.t = weakReference;
        }

        public final void run() {
            setName("GLThread " + getId());
            try {
                k();
            } catch (InterruptedException e2) {
            } finally {
                ci.a.a(this);
            }
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.s.d();
            }
        }

        private void j() {
            if (this.h) {
                this.s.e();
                this.h = false;
                ci.a.c(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x023e, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x023f, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0248, code lost:
            r15 = com.amap.api.col.stln3.ci.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x024e, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
            r17.j = true;
            r17.f = true;
            com.amap.api.col.stln3.ci.a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0260, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x026c, code lost:
            if (r9 == false) goto L_0x0288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x026f, code lost:
            r0 = (javax.microedition.khronos.opengles.GL10) r17.s.c();
            com.amap.api.col.stln3.ci.a.a(r0);
            r6 = r0;
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0288, code lost:
            if (r7 == false) goto L_0x02af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x028b, code lost:
            r0 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0296, code lost:
            if (r0 == null) goto L_0x02aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0299, code lost:
            r0.d.onSurfaceCreated(r6, r17.s.d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x02aa, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x02af, code lost:
            if (r10 == false) goto L_0x02cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x02b2, code lost:
            r0 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02bd, code lost:
            if (r0 == null) goto L_0x02cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c0, code lost:
            r0.d.onSurfaceChanged(r6, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x02cb, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x02cf, code lost:
            r0 = r17.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02db, code lost:
            if (r0 == null) goto L_0x02e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x02de, code lost:
            r0.d.onDrawFrame(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x02e9, code lost:
            r0 = r17.s;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ff, code lost:
            if (r0.a.eglSwapBuffers(r0.b, r0.c) != false) goto L_0x030b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x0302, code lost:
            r0 = r0.a.eglGetError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x030b, code lost:
            r0 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x030f, code lost:
            if (r0 == 12288) goto L_0x033e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x0313, code lost:
            if (r0 == 12302) goto L_0x0339;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0316, code lost:
            com.amap.api.col.stln3.ci.h.b("eglSwapBuffers", r0);
            r2 = com.amap.api.col.stln3.ci.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0322, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r17.f = true;
            com.amap.api.col.stln3.ci.a.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0331, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0339, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0340, code lost:
            r3 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0343, code lost:
            if (r14 == false) goto L_0x0349;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0346, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x020f, code lost:
            if (r13 == null) goto L_0x021c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0212, code lost:
            r13.run();
            r13 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x021c, code lost:
            if (r8 == false) goto L_0x026c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0227, code lost:
            if (r17.s.b() == false) goto L_0x0248;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x022a, code lost:
            r8 = com.amap.api.col.stln3.ci.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x022f, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
            r17.j = true;
            com.amap.api.col.stln3.ci.a.notifyAll();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void k() throws java.lang.InterruptedException {
            /*
            // Method dump skipped, instructions count: 893
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ci.i.k():void");
        }

        private boolean l() {
            if (this.d || !this.e || this.f || this.l <= 0 || this.m <= 0) {
                return false;
            }
            return this.o || this.n == 1;
        }

        public final void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (ci.a) {
                this.n = i2;
                ci.a.notifyAll();
            }
        }

        public final int a() {
            int i2;
            synchronized (ci.a) {
                i2 = this.n;
            }
            return i2;
        }

        public final void b() {
            synchronized (ci.a) {
                this.o = true;
                ci.a.notifyAll();
            }
        }

        public final void c() {
            synchronized (ci.a) {
                this.e = true;
                this.j = false;
                ci.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d() {
            synchronized (ci.a) {
                this.e = false;
                ci.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void e() {
            synchronized (ci.a) {
                this.c = true;
                ci.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void f() {
            synchronized (ci.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                ci.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void a(int i2, int i3) {
            synchronized (ci.a) {
                this.l = i2;
                this.m = i3;
                this.r = true;
                this.o = true;
                this.p = false;
                ci.a.notifyAll();
                while (!this.b && !this.d && !this.p) {
                    if (!(this.h && this.i && l())) {
                        break;
                    }
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void g() {
            synchronized (ci.a) {
                this.a = true;
                ci.a.notifyAll();
                while (!this.b) {
                    try {
                        ci.a.wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            this.k = true;
            ci.a.notifyAll();
        }

        public final void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (ci.a) {
                    this.q.add(runnable);
                    ci.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GLTextureView */
    public static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
        }

        @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }

        private void a() {
            if (this.a.length() > 0) {
                this.a.toString();
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void a() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: GLTextureView */
    public static class j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }

        public final synchronized void a(i iVar) {
            iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public final boolean b(i iVar) {
            i iVar2 = this.g;
            if (iVar2 == iVar || iVar2 == null) {
                this.g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.e) {
                return true;
            }
            i iVar3 = this.g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.h();
            return false;
        }

        public final void c(i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public final synchronized boolean a() {
            return this.f;
        }

        public final synchronized boolean b() {
            c();
            return !this.e;
        }

        public final synchronized void a(GL10 gl10) {
            if (!this.d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.c < 131072) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.e) {
                    z = true;
                }
                this.f = z;
                this.d = true;
            }
        }

        private void c() {
            if (!this.b) {
                this.c = 131072;
                if (this.c >= 131072) {
                    this.e = true;
                }
                this.b = true;
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.c();
        onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.d();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }
}
