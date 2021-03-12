package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;

/* compiled from: GlOverlayTextureManager */
public final class cn {
    private int a = -1;
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private Bitmap e = null;
    private Bitmap f = null;
    private Bitmap g = null;

    public final void a(Context context) {
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.isRecycled()) {
            this.e = ic.a(context, "amap_sdk_lineTexture.png");
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.f = ic.a(context, "amap_sdk_lineDashTexture_square.png");
        }
        Bitmap bitmap3 = this.g;
        if (bitmap3 == null || bitmap3.isRecycled()) {
            this.g = ic.a(context, "amap_sdk_lineDashTexture_circle.png");
        }
        this.a = ic.a(this.e);
        this.b = ic.b(this.f);
        this.c = ic.b(this.g);
        this.d = ic.a();
    }

    public final int a() {
        return this.a;
    }

    public final int a(int i) {
        if (i == 0) {
            return this.b;
        }
        if (i == 1) {
            return this.c;
        }
        return -1;
    }

    public final int b() {
        return this.d;
    }

    public final void c() {
        GLES20.glDeleteTextures(3, new int[]{this.a, this.b, this.c, this.d}, 0);
    }

    public final void d() {
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.g = null;
        }
        Bitmap bitmap3 = this.e;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.e = null;
        }
    }
}
