package com.amap.api.col.stln3;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: BaseTask */
public class ju implements Runnable {
    protected static int a = 30000;
    protected static int b = 30000;
    protected String c;
    protected int d;
    protected String e;
    protected int f;
    protected int g;
    protected byte[] h;
    protected Context i;
    protected String j;
    protected rj k;
    protected String l;
    protected String m;
    protected String n;
    protected String o;

    public ju(Context context, String str, int i2, String str2, int i3, int i4, byte[] bArr) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.k = mj.a();
        this.j = rb.b(context);
        this.c = str;
        this.d = i2;
        this.e = str2;
        this.f = i3;
        this.g = i4;
        this.h = bArr;
        this.i = context;
        if (i3 == 1) {
            try {
                String str3 = new String(bArr, "UTF-8");
                JSONObject jSONObject = new JSONObject(str3);
                if (jSONObject.has("start")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("start");
                    this.l = jSONObject2.getString("x");
                    this.m = jSONObject2.getString("y");
                }
                if (jSONObject.has("end")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("end");
                    this.n = jSONObject3.getString("x");
                    this.o = jSONObject3.getString("y");
                }
                String str4 = "bytes:" + str3;
                String str5 = "bytes:iModuleID=" + i3 + ",iConnectID=" + i4;
                String str6 = "坐标:start_x=" + this.l + ",start_y=" + this.m + ",end_x=" + this.n + ",end_y=" + this.o;
            } catch (Throwable th) {
                th.printStackTrace();
                String str7 = "坐标位置解析错误:" + th.getMessage();
            }
        }
    }

    public static void a(int i2) {
        a = i2;
    }

    public static void b(int i2) {
        b = i2;
    }

    public void run() {
    }

    public static ty a(jt jtVar) {
        try {
            return jv.a(false, jtVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
