package com.amap.api.col.stln3;

import android.opengl.GLES20;

/* compiled from: GlShader */
public class gp {
    private boolean a;
    public int d;
    public int e;
    public int f;

    /* access modifiers changed from: protected */
    public final boolean a(String str, String str2) {
        this.d = b(str, str2);
        return this.d != 0;
    }

    /* access modifiers changed from: protected */
    public final boolean a(String str) {
        String str2 = "amap_sdk_shaders/" + str;
        String a2 = hd.a(str2);
        if (a2 != null) {
            int indexOf = a2.indexOf(36);
            if (indexOf < 0 || a2.charAt(indexOf + 1) != '$') {
                throw new IllegalArgumentException("not a shader file " + str2);
            }
            this.d = b(a2.substring(0, indexOf), a2.substring(indexOf + 2));
            if (this.d != 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("shader file not found: " + str2);
    }

    /* access modifiers changed from: protected */
    public final int b(String str) {
        return GLES20.glGetAttribLocation(this.d, str);
    }

    /* access modifiers changed from: protected */
    public final int c(String str) {
        return GLES20.glGetUniformLocation(this.d, str);
    }

    private int b(String str, String str2) {
        this.e = a(35633, str);
        this.f = a(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, this.e);
        GLES20.glAttachShader(glCreateProgram, this.f);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public final void a() {
        int i = this.d;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.e;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.f;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.a = true;
    }

    public final boolean b() {
        return this.a;
    }
}
