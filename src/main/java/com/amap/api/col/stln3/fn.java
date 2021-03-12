package com.amap.api.col.stln3;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: AbstractGlOverlay */
public abstract class fn {
    private co a;

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);

    public void destroy() {
        co coVar = this.a;
    }
}
