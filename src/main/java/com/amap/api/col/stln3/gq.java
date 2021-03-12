package com.amap.api.col.stln3;

import android.opengl.GLES20;
import com.autonavi.amap.mapcore.gles.AMapNativeGLShaderManager;

/* compiled from: GlShaderManager */
public final class gq {
    private d a;
    private f b;
    private c c;
    private e d;
    private a e;
    private b f;
    private long g;

    public gq() {
        this.g = 0;
        this.g = AMapNativeGLShaderManager.nativeCreateGLShaderManager();
    }

    public final long a() {
        return this.g;
    }

    private synchronized gp c() {
        if (this.a == null) {
            this.a = new d("texture_normal.glsl");
        }
        return this.a;
    }

    private synchronized gp d() {
        if (this.b == null) {
            this.b = new f("texture.glsl");
        }
        return this.b;
    }

    private synchronized gp e() {
        if (this.c == null) {
            this.c = new c("texture_layer.glsl");
        }
        return this.c;
    }

    private synchronized gp f() {
        if (this.d == null) {
            this.d = new e("point.glsl");
        }
        return this.d;
    }

    private synchronized a g() {
        if (this.e == null) {
            this.e = new a();
        }
        return this.e;
    }

    public final gp a(int i) {
        switch (i) {
            case 0:
                return d();
            case 1:
                return c();
            case 2:
                return e();
            case 3:
                return f();
            case 4:
                return g();
            case 5:
                return h();
            default:
                return null;
        }
    }

    private synchronized gp h() {
        if (this.f == null) {
            this.f = new b();
        }
        return this.f;
    }

    public final synchronized void b() {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        if (this.g != 0) {
            AMapNativeGLShaderManager.nativeDestroyGLShaderManager(this.g);
            this.g = 0;
        }
    }

    /* compiled from: GlShaderManager */
    public static class e extends gp {
        public int a;
        public int b;
        public int c;

        e(String str) {
            if (a(str)) {
                this.a = c("aMVPMatrix");
                this.c = c("aColor");
                this.b = b("aVertex");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class c extends gp {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        c(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
                this.g = c("aTransform");
                this.h = c("aColor");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class f extends gp {
        public int a;
        public int b;
        public int c;

        f(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class d extends gp {
        public int a;
        public int b;
        public int c;
        public int g;
        public int h;

        d(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                hl.a("getUniform");
                this.h = c("aMapBearing");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
                this.g = b("aBearingTiltAlpha");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class a extends gp {
        String a = ("precision highp float;\n        attribute vec4 aVertex;\n        attribute vec2 aTexture;\n        uniform vec4 aMapAttribute;\n        uniform mat4 aMVPMatrix;\n        uniform mat4 aProjection;\n        uniform vec3 aInstanceOffset[" + du.a + "];\n        varying vec2 texture;\n        mat4 rotationMatrix(vec3 axis, float angle)\n        {\n           axis = normalize(axis);\n           float s = sin(angle);\n           float c = cos(angle);\n           float oc = 1.0 - c;\n           return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,\n                 oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,\n                 oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,\n                 0.0,                                0.0,                                0.0,                                1.0);\n        }\n        void main(){\n            int instance = int(aVertex.w);\n            vec3 offset_value = aInstanceOffset[instance];\n            mat4 marker_rotate_mat4 = rotationMatrix(vec3(0,0,1.0), offset_value.z * 0.01745);\n            float map_rotate = -aMapAttribute.z * 0.01745;\n            float map_tilt = aMapAttribute.w * 0.01745;\n            //tilt旋转矩阵\n            mat4 map_tilt_mat4 = rotationMatrix(vec3(1,0,0), map_tilt);\n            //bearing旋转矩阵\n            mat4 map_rotate_mat4 = rotationMatrix(vec3(0,0,1), map_rotate);\n                 \n            //旋转图片\n            vec4 pos_1 = marker_rotate_mat4 * vec4(aVertex.xy * aMapAttribute.xy, 0,1);\n                  \n            //让marker站立，tilt旋转之后z轴值有可能不是0\n            vec4 pos_2 =  map_tilt_mat4 * pos_1;\n                  \n            //旋转 bearing\n            vec4 pos_3 =  map_rotate_mat4 * pos_2;\n" + "            gl_Position = aProjection * aMVPMatrix * vec4(pos_3.xy + offset_value.xy, pos_3.z, 1.0);\n            texture = aTexture;\n        }");
        String b = "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }";
        public int c;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;

        public a() {
            if (a(this.a, this.b)) {
                this.g = c("aMVPMatrix");
                this.k = c("aProjection");
                this.i = c("aInstanceOffset");
                this.j = c("aMapAttribute");
                this.c = b("aVertex");
                this.h = b("aTexture");
            }
        }
    }

    /* compiled from: GlShaderManager */
    public static class b extends gp {
        String a = "precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }";
        String b = "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }";
        public int c;
        public int g;
        public int h;

        public b() {
            if (a(this.a, this.b)) {
                this.c = GLES20.glGetAttribLocation(this.d, "aVertex");
                this.h = GLES20.glGetAttribLocation(this.d, "aTexture");
                this.g = GLES20.glGetUniformLocation(this.d, "aMVPMatrix");
            }
        }
    }
}
