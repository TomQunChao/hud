package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoInfoEntity */
public final class ti implements Parcelable {
    int a;
    int b;
    String c;
    String d;
    boolean e;
    boolean f;
    List<tg> g;
    private String h;
    private String i;
    private String j;
    private String k;

    public ti() {
        this.g = new ArrayList();
    }

    public ti(ti tiVar) {
        this();
        if (tiVar != null) {
            this.e = tiVar.e;
            this.d = tiVar.d;
            this.h = tiVar.h;
            this.i = tiVar.i;
            this.b = tiVar.b;
            this.a = tiVar.a;
            this.j = tiVar.j;
            this.c = tiVar.c;
            this.k = tiVar.k;
            this.g = tiVar.d();
        }
    }

    public ti(String str, String str2, String str3, boolean z, boolean z2) {
        this.g = new ArrayList();
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = z2;
        try {
            String[] split = str.split("/");
            this.k = split[split.length - 1];
            String[] split2 = this.k.split("_");
            this.h = split2[0];
            this.j = split2[1];
            this.i = split2[2];
            try {
                this.a = Integer.parseInt(split2[3]);
                this.b = Integer.parseInt(split2[4].split("\\.")[0]);
            } catch (Throwable th) {
            }
            this.g = a(this.h, str3);
        } catch (Throwable th2) {
        }
    }

    private ti(String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, boolean z, List<tg> list) {
        this.g = new ArrayList();
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.a = i2;
        this.b = i3;
        this.c = str4;
        this.d = str5;
        this.k = str6;
        this.e = z;
        this.g = list;
    }

    public final String a() {
        return this.h;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.j;
    }

    public final List<tg> d() {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        return this.g;
    }

    public final tg a(String str) {
        if (this.g == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (tg tgVar : this.g) {
            if (tgVar.f().equals(str)) {
                return tgVar;
            }
        }
        return null;
    }

    public static boolean a(ti tiVar) {
        if (tiVar != null && !TextUtils.isEmpty(tiVar.h) && tc.a(tiVar.j) && tc.a(tiVar.i) && tiVar.b > 0 && tiVar.a > 0 && tiVar.d() != null && tiVar.d().size() != 0) {
            return true;
        }
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(e());
    }

    static {
        new Parcelable.Creator() {
            /* class com.amap.api.col.stln3.ti.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ti.b(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ti[i];
            }
        };
    }

    private List<tg> a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            String uuid = UUID.randomUUID().toString();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    tg a2 = tg.a(jSONArray.getString(i2), this);
                    a2.a(uuid);
                    a2.b(str);
                    arrayList.add(a2);
                } catch (JSONException e2) {
                }
            }
            return arrayList;
        } catch (JSONException e3) {
            return new ArrayList();
        }
    }

    public static ti b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ti();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new ti(jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optInt("dk", -1), jSONObject.optInt("ck", -1), "", jSONObject.optString("ek", ""), "", jSONObject.optBoolean("lk", false), tg.c(jSONObject.optString("jk", "")));
        } catch (Throwable th) {
            sw.c("SoFile#fromJson json ex " + th);
            return new ti();
        }
    }

    public final String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ak", this.h);
            jSONObject.put("bk", this.i);
            jSONObject.put("ik", this.j);
            jSONObject.put("ck", this.b);
            jSONObject.put("dk", this.a);
            jSONObject.put("ek", this.d);
            jSONObject.put("lk", this.e);
            jSONObject.put("jk", tg.a(this.g));
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }
}
