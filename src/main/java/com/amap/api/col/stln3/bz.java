package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.col.stln3.ci;
import com.autonavi.ae.gmap.GLMapRender;

/* compiled from: AMapGLTextureView */
public final class bz extends ci implements cp {
    protected boolean a;
    private co b;
    private GLMapRender c;

    public bz(Context context) {
        this(context, (byte) 0);
    }

    private bz(Context context, byte b2) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = false;
        hl.a(this);
        this.b = new bw(this, context);
    }

    public final co a() {
        return this.b;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hj hjVar) {
        super.a((ci.e) hjVar);
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hk hkVar) {
        super.a((ci.f) hkVar);
    }

    @Override // com.amap.api.col.stln3.cp
    public final void b() {
        c();
        try {
            if (this.c != null) {
                this.c.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.amap.api.col.stln3.ci, com.amap.api.col.stln3.cp
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.amap.api.col.stln3.ci
    public final void c() {
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                /* class com.amap.api.col.stln3.bz.AnonymousClass1 */

                public final void run() {
                    try {
                        if (bz.this.c != null) {
                            bz.this.c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            int i = 0;
            while (!this.c.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 20) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                i = i2;
            }
        }
        super.c();
    }

    @Override // com.amap.api.col.stln3.ci
    public final void d() {
        super.d();
    }

    @Override // com.amap.api.col.stln3.ci
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        requestRender();
        try {
            Thread.sleep(100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            if (this.c != null) {
                this.c.renderPause();
                this.a = false;
            }
            requestRender();
        } else if (i == 0) {
            try {
                if (this.c != null) {
                    this.c.renderResume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ci
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c != null) {
                this.c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.d();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.ci
    public final void onDetachedFromWindow() {
    }
}
