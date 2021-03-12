package com.amap.api.col.stln3;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.autonavi.ae.gmap.GLMapRender;

/* compiled from: AMapGLSurfaceView */
public final class by extends GLSurfaceView implements cp {
    protected boolean a;
    private co b;
    private GLMapRender c;

    public by(Context context) {
        this(context, (byte) 0);
    }

    private by(Context context, byte b2) {
        super(context, null);
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
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hj hjVar) {
        super.setEGLConfigChooser(hjVar);
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hk hkVar) {
        super.setEGLContextFactory(hkVar);
    }

    @Override // com.amap.api.col.stln3.cp
    public final void b() {
        onPause();
        try {
            if (this.c != null) {
                this.c.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    public final void onPause() {
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                /* class com.amap.api.col.stln3.by.AnonymousClass1 */

                public final void run() {
                    if (by.this.c != null) {
                        try {
                            by.this.c.onSurfaceDestory();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
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
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            if (this.c != null) {
                this.c.renderPause();
                this.a = false;
            }
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
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c != null) {
                this.c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
    }
}
