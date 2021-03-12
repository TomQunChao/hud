package com.amap.api.col.stln3;

import android.os.Bundle;
import android.view.View;
import com.amap.api.navi.AmapRouteActivity;
import com.amap.api.services.district.DistrictSearchQuery;

/* compiled from: BaseServiceModule */
public abstract class ke {
    protected final String a = DistrictSearchQuery.KEYWORDS_CITY;
    protected final String b = "content";
    protected final String c = "input_type";
    protected final String d = "input_type_mid";
    protected final String e = "from";
    protected final String f = "needRecalculate";
    protected AmapRouteActivity g = null;

    public abstract void a();

    public abstract void a(View view);

    public abstract View e();

    public abstract void f();

    public final void a(AmapRouteActivity amapRouteActivity) {
        this.g = amapRouteActivity;
    }

    public void a(Bundle bundle) {
        this.g.showScr();
    }

    public boolean b() {
        return true;
    }

    public final void c() {
        this.g.showLoadingDialog();
    }

    public final void d() {
        this.g.removeLoadingDialog();
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public final int a(float f2) {
        return mj.a(this.g, (int) f2);
    }
}
