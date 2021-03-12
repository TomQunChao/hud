package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoFileItem */
public final class tg {
    String a;
    boolean b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public tg() {
    }

    private tg(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.a = str6;
        this.b = z;
        this.h = str7;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public final String f() {
        return this.h;
    }

    public final void b(String str) {
        this.c = str;
    }

    public static tg a(String str, ti tiVar) {
        if (TextUtils.isEmpty(str)) {
            return new tg();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new tg("", "", jSONObject.optString("sdk", ""), jSONObject.optString("sdkv", ""), jSONObject.optString("sdkdynamicv", ""), jSONObject.optString("md5", ""), tiVar.e, jSONObject.optString("so_file_name", ""));
        } catch (Throwable th) {
            sw.c("SoFile#fromJson json ex " + th);
            return new tg();
        }
    }

    private static tg d(String str) {
        if (TextUtils.isEmpty(str)) {
            return new tg();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new tg(jSONObject.optString("sk", ""), jSONObject.optString("mk", ""), jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optString("ek", ""), jSONObject.optBoolean("lk", false), jSONObject.optString("nk", ""));
        } catch (Throwable th) {
            sw.c("SoFile#fromJson json ex " + th);
            return new tg();
        }
    }

    public static List<tg> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(d(jSONArray.getString(i)));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    private static String a(tg tgVar) {
        if (tgVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mk", tgVar.d);
            jSONObject.put("ak", tgVar.e);
            jSONObject.put("bk", tgVar.f);
            jSONObject.put("ik", tgVar.g);
            jSONObject.put("ek", tgVar.a);
            jSONObject.put("lk", tgVar.b);
            jSONObject.put("nk", tgVar.h);
            jSONObject.put("sk", tgVar.c);
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }

    public static String a(List<tg> list) {
        if (list == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, a(list.get(i)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final boolean g() {
        return !TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.g);
    }

    public static boolean a(tg tgVar, tg tgVar2) {
        if (tgVar2 == null || tgVar == null || !tgVar.e.equals(tgVar2.e) || !tgVar.f.equals(tgVar2.f) || !tgVar.g.equals(tgVar2.g) || !tgVar.h.equals(tgVar2.h)) {
            return false;
        }
        return true;
    }
}
