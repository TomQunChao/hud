package com.amap.api.col.stln3;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* compiled from: AMapGLRenderer */
public final class bx implements cp {
    protected boolean a;
    private co b;

    public bx(Context context) {
        this(context, (byte) 0);
    }

    private bx(Context context, byte b2) {
        this.b = null;
        this.a = false;
        this.b = new bw(this, context);
    }

    public final co a() {
        return this.b;
    }

    @Override // com.amap.api.col.stln3.cp
    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.amap.api.col.stln3.cp
    public final boolean isEnabled() {
        if (this.b != null) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.stln3.cp
    public final void setVisibility(int i) {
    }

    @Override // com.amap.api.col.stln3.cp
    public final void requestRender() {
    }

    @Override // com.amap.api.col.stln3.cp
    public final int getRenderMode() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.cp
    public final boolean postDelayed(Runnable runnable, long j) {
        return false;
    }

    @Override // com.amap.api.col.stln3.cp
    public final boolean post(Runnable runnable) {
        return false;
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hj hjVar) {
    }

    @Override // com.amap.api.col.stln3.cp
    public final void a(hk hkVar) {
    }

    @Override // com.amap.api.col.stln3.cp
    public final void b() {
    }

    @Override // com.amap.api.col.stln3.cp
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    @Override // com.amap.api.col.stln3.cp
    public final int getWidth() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.cp
    public final int getHeight() {
        return 0;
    }

    @Override // com.amap.api.col.stln3.cp
    public final void setRenderMode(int i) {
    }
}
