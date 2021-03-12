package com.amap.api.col.stln3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PoiItem */
public final class ln implements Parcelable {
    public static final Parcelable.Creator<ln> a = new Parcelable.Creator<ln>() {
        /* class com.amap.api.col.stln3.ln.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ln createFromParcel(Parcel parcel) {
            return new ln(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ln[] newArray(int i) {
            return new ln[i];
        }
    };
    private lo A;
    private String B;
    private String C;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f = "";
    private int g = -1;
    private final li h;
    private final String i;
    private final String j;
    private li k;
    private li l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private lc u;
    private String v;
    private String w;
    private String x;
    private List<lv> y = new ArrayList();
    private List<lk> z = new ArrayList();

    public ln(String str, li liVar, String str2, String str3) {
        this.b = str;
        this.h = liVar;
        this.i = str2;
        this.j = str3;
    }

    public final void a(String str) {
        this.w = str;
    }

    public final void b(String str) {
        this.s = str;
    }

    public final void c(String str) {
        this.r = str;
    }

    public final void d(String str) {
        this.q = str;
    }

    public final void e(String str) {
        this.f = str;
    }

    public final void f(String str) {
        this.c = str;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final String a() {
        return this.b;
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.j;
    }

    public final li d() {
        return this.h;
    }

    public final void h(String str) {
        this.e = str;
    }

    public final li e() {
        return this.k;
    }

    public final void a(li liVar) {
        this.k = liVar;
    }

    public final li f() {
        return this.l;
    }

    public final void b(li liVar) {
        this.l = liVar;
    }

    public final void i(String str) {
        this.m = str;
    }

    public final void j(String str) {
        this.n = str;
    }

    public final void k(String str) {
        this.o = str;
    }

    public final void l(String str) {
        this.p = str;
    }

    public final void a(boolean z2) {
        this.t = z2;
    }

    public final void m(String str) {
        this.v = str;
    }

    public final void n(String str) {
        this.x = str;
    }

    public final void a(List<lv> list) {
        this.y = list;
    }

    public final void a(lc lcVar) {
        this.u = lcVar;
    }

    public final void b(List<lk> list) {
        this.z = list;
    }

    public final void a(lo loVar) {
        this.A = loVar;
    }

    public final String g() {
        return this.B;
    }

    public final void o(String str) {
        this.B = str;
    }

    public final void p(String str) {
        this.C = str;
    }

    protected ln(Parcel parcel) {
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.c = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = (li) parcel.readValue(li.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.e = parcel.readString();
        this.k = (li) parcel.readValue(li.class.getClassLoader());
        this.l = (li) parcel.readValue(li.class.getClassLoader());
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.t = zArr[0];
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readArrayList(lv.class.getClassLoader());
        this.u = (lc) parcel.readValue(lc.class.getClassLoader());
        this.z = parcel.createTypedArrayList(lk.a);
        this.A = (lo) parcel.readParcelable(lo.class.getClassLoader());
        this.B = parcel.readString();
        this.C = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeValue(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.e);
        parcel.writeValue(this.k);
        parcel.writeValue(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeBooleanArray(new boolean[]{this.t});
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeList(this.y);
        parcel.writeValue(this.u);
        parcel.writeTypedList(this.z);
        parcel.writeParcelable(this.A, i2);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ln lnVar = (ln) obj;
        String str = this.b;
        if (str == null) {
            if (lnVar.b != null) {
                return false;
            }
        } else if (!str.equals(lnVar.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.b;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return this.i;
    }
}
