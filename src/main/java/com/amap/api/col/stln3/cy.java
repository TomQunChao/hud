package com.amap.api.col.stln3;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.col.stln3.gq;
import com.amap.api.maps.model.CrossOverlay;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PboPluginTexture */
public final class cy {
    float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    float[] b = {-1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f};
    private final co c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private ExecutorService h = null;
    private boolean i = false;
    private boolean j = false;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private boolean n = false;
    private volatile EGLContext o;
    private volatile EGLConfig p;
    private EGLDisplay q = EGL14.EGL_NO_DISPLAY;
    private EGLContext r = EGL14.EGL_NO_CONTEXT;
    private EGLSurface s = EGL14.EGL_NO_SURFACE;
    private gq.f t;
    private FloatBuffer u;
    private FloatBuffer v;
    private a w;
    private CrossOverlay.GenerateCrossImageListener x;

    /* compiled from: PboPluginTexture */
    public interface a {
        int getTextureID();
    }

    static /* synthetic */ void a(cy cyVar) {
        cyVar.q = EGL14.eglGetDisplay(0);
        if (cyVar.q != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(cyVar.q, iArr, 0, iArr, 1)) {
                cyVar.q = null;
                return;
            }
            cyVar.r = EGL14.eglCreateContext(cyVar.q, cyVar.p, cyVar.o, new int[]{12440, 2, 12344}, 0);
            if (cyVar.r != EGL14.EGL_NO_CONTEXT) {
                cyVar.s = EGL14.eglCreatePbufferSurface(cyVar.q, cyVar.p, new int[]{12375, cyVar.e, 12374, cyVar.f, 12344}, 0);
                if (cyVar.s != EGL14.EGL_NO_SURFACE) {
                    EGLDisplay eGLDisplay = cyVar.q;
                    EGLSurface eGLSurface = cyVar.s;
                    if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, cyVar.r)) {
                        GLES20.glFlush();
                        cyVar.i = true;
                    }
                }
            }
        }
    }

    static /* synthetic */ void i(cy cyVar) {
        try {
            if (!cyVar.j && cyVar.w != null) {
                if (cyVar.w != null) {
                    cyVar.d = cyVar.w.getTextureID();
                }
                if (cyVar.d <= 0) {
                    String str = "renderTextureAndReadPixel failed mTextureID is <= 0 mTextureID " + cyVar.d;
                    return;
                }
                String str2 = "renderTextureAndReadPixel  mTextureID is  mTextureID " + cyVar.d;
                int i2 = 0;
                if ((cyVar.t == null || cyVar.t.b()) && cyVar.c != null) {
                    cyVar.t = (gq.f) cyVar.c.k(0);
                }
                if (cyVar.u == null) {
                    cyVar.u = ic.a(cyVar.b);
                }
                if (cyVar.v == null) {
                    cyVar.v = ic.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
                }
                GLES20.glUseProgram(cyVar.t.d);
                GLES20.glDisable(3042);
                GLES20.glBlendFunc(1, 771);
                GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, cyVar.d);
                GLES20.glEnableVertexAttribArray(cyVar.t.b);
                GLES20.glVertexAttribPointer(cyVar.t.b, 3, 5126, false, 12, (Buffer) cyVar.u);
                GLES20.glEnableVertexAttribArray(cyVar.t.c);
                GLES20.glVertexAttribPointer(cyVar.t.c, 2, 5126, false, 8, (Buffer) cyVar.v);
                Matrix.setIdentityM(cyVar.a, 0);
                Matrix.scaleM(cyVar.a, 0, 1.0f, 1.0f, 1.0f);
                GLES20.glUniformMatrix4fv(cyVar.t.a, 1, false, cyVar.a, 0);
                GLES20.glDrawArrays(6, 0, 4);
                GLES20.glDisableVertexAttribArray(cyVar.t.b);
                GLES20.glDisableVertexAttribArray(cyVar.t.c);
                GLES20.glBindTexture(3553, 0);
                GLES20.glUseProgram(0);
                GLES20.glDisable(3042);
                hl.a("drawTexure");
                GLES20.glFinish();
                cyVar.k++;
                if (cyVar.k == 50 && cyVar.x != null) {
                    if (cyVar.l == 0) {
                        cyVar.l = cyVar.e;
                    }
                    if (cyVar.m == 0) {
                        cyVar.m = cyVar.f;
                    }
                    Bitmap a2 = ic.a(cyVar.f - cyVar.m, cyVar.l, cyVar.m);
                    CrossOverlay.GenerateCrossImageListener generateCrossImageListener = cyVar.x;
                    if (!cyVar.i) {
                        i2 = -1;
                    }
                    generateCrossImageListener.onGenerateComplete(a2, i2);
                    cyVar.n = true;
                }
            }
        } catch (Throwable th) {
            CrossOverlay.GenerateCrossImageListener generateCrossImageListener2 = cyVar.x;
            if (generateCrossImageListener2 != null) {
                generateCrossImageListener2.onGenerateComplete(null, -1);
            }
        }
    }

    public cy(co coVar) {
        this.c = coVar;
        this.j = false;
        this.h = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors() * 2, 1, TimeUnit.SECONDS, this.g, new hq("AMapPboRenderThread"), new ThreadPoolExecutor.AbortPolicy());
    }

    public final void a(int i2, int i3) {
        EGLDisplay eglGetCurrentDisplay;
        this.e = i2;
        this.f = i3;
        this.o = EGL14.eglGetCurrentContext();
        if (this.o != EGL14.EGL_NO_CONTEXT && (eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay()) != EGL14.EGL_NO_DISPLAY) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglGetConfigs(eglGetCurrentDisplay, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                this.p = eGLConfigArr[0];
                ExecutorService executorService = this.h;
                if (executorService != null && !executorService.isShutdown()) {
                    this.h.execute(new Runnable() {
                        /* class com.amap.api.col.stln3.cy.AnonymousClass1 */

                        public final void run() {
                            cy.a(cy.this);
                        }
                    });
                }
            }
        }
    }

    public final void a() {
        ExecutorService executorService = this.h;
        if (executorService != null && !executorService.isShutdown()) {
            this.h.execute(new Runnable() {
                /* class com.amap.api.col.stln3.cy.AnonymousClass2 */

                public final void run() {
                    try {
                        cy.this.n = false;
                        if (!cy.this.j) {
                            cy.this.k = 0;
                            int i = 0;
                            while (!cy.this.j && cy.this.k < 5 && i < 50) {
                                i++;
                                try {
                                    Thread.sleep(16);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (!cy.this.i) {
                                    if (cy.this.x != null) {
                                        cy.this.x.onGenerateComplete(null, -1);
                                    }
                                    if (!cy.this.n) {
                                        cy.this.n = true;
                                        if (cy.this.x != null) {
                                            cy.this.x.onGenerateComplete(null, -1);
                                        }
                                    }
                                    if (cy.this.r != EGL14.EGL_NO_CONTEXT) {
                                        EGL14.eglDestroyContext(cy.this.q, cy.this.r);
                                        EGL14.eglDestroySurface(cy.this.q, cy.this.s);
                                        cy.this.r = null;
                                    }
                                    if (cy.this.q != EGL14.EGL_NO_DISPLAY) {
                                        EGL14.eglTerminate(cy.this.q);
                                        cy.this.q = null;
                                    }
                                    cy.this.r = EGL14.EGL_NO_CONTEXT;
                                    cy.this.q = EGL14.EGL_NO_DISPLAY;
                                    return;
                                }
                                GLES20.glViewport(0, 0, cy.this.e, cy.this.f);
                                GLES20.glClear(16640);
                                cy.i(cy.this);
                            }
                            if (!cy.this.n) {
                                cy.this.n = true;
                                if (cy.this.x != null) {
                                    cy.this.x.onGenerateComplete(null, -1);
                                }
                            }
                            if (cy.this.r != EGL14.EGL_NO_CONTEXT) {
                                EGL14.eglDestroyContext(cy.this.q, cy.this.r);
                                EGL14.eglDestroySurface(cy.this.q, cy.this.s);
                                cy.this.r = null;
                            }
                            if (cy.this.q != EGL14.EGL_NO_DISPLAY) {
                                EGL14.eglTerminate(cy.this.q);
                                cy.this.q = null;
                            }
                            cy.this.r = EGL14.EGL_NO_CONTEXT;
                            cy.this.q = EGL14.EGL_NO_DISPLAY;
                        }
                    } finally {
                        if (!cy.this.n) {
                            cy.this.n = true;
                            if (cy.this.x != null) {
                                cy.this.x.onGenerateComplete(null, -1);
                            }
                        }
                        if (cy.this.r != EGL14.EGL_NO_CONTEXT) {
                            EGL14.eglDestroyContext(cy.this.q, cy.this.r);
                            EGL14.eglDestroySurface(cy.this.q, cy.this.s);
                            cy.this.r = null;
                        }
                        if (cy.this.q != EGL14.EGL_NO_DISPLAY) {
                            EGL14.eglTerminate(cy.this.q);
                            cy.this.q = null;
                        }
                        cy.this.r = EGL14.EGL_NO_CONTEXT;
                        cy.this.q = EGL14.EGL_NO_DISPLAY;
                    }
                }
            });
        }
    }

    public final void b() {
        this.j = true;
        FloatBuffer floatBuffer = this.v;
        if (floatBuffer != null) {
            floatBuffer.clear();
            this.v = null;
        }
        FloatBuffer floatBuffer2 = this.u;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            this.u = null;
        }
        this.w = null;
        this.h.shutdownNow();
    }

    public final boolean c() {
        return this.j;
    }

    public final void a(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.x = generateCrossImageListener;
    }

    public final void a(a aVar) {
        this.w = aVar;
    }

    public final void b(int i2, int i3) {
        this.l = i2;
        this.m = i3;
    }
}
