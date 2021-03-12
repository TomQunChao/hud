package com.amap.api.col.stln3;

import android.opengl.GLSurfaceView;

/* compiled from: IGLSurfaceView */
public interface cp {
    void a(hj hjVar);

    void a(hk hkVar);

    void b();

    int getHeight();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i);
}
