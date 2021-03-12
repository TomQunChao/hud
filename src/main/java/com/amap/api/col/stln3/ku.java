package com.amap.api.col.stln3;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amap.api.col.stln3.ld;
import com.amap.api.col.stln3.lq;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.R;
import com.amap.api.navi.view.LoadingView;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SearchPage */
public final class ku extends ke implements TextWatcher, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, ld.a, lq.a {
    private ImageView A;
    private InputMethodManager B = null;
    private Poi C;
    private lt D;
    private LinkedList<lw> E;
    private TextView F;
    private final int G = 1000001;
    private Dialog H;
    private View.OnClickListener I = new View.OnClickListener() {
        /* class com.amap.api.col.stln3.ku.AnonymousClass1 */

        public final void onClick(View view) {
            if (view.getId() == 2147479647) {
                ku.a(ku.this);
            }
            ku.this.H.dismiss();
        }
    };
    boolean h = false;
    int i = 10;
    private final String j = "SearchPage";
    private final String k = "search_history";
    private String l = "北京";
    private String m = "输入起点";
    private String n = "";
    private int o;
    private int p;
    private AutoCompleteTextView q;
    private ListView r;
    private List<lw> s;
    private kl t;
    private ProgressBar u;
    private View v;
    private ImageView w;
    private View x;
    private TextView y;
    private LoadingView z;

    static /* synthetic */ void a(ku kuVar) {
        kuVar.E.clear();
        kuVar.t.a(kuVar.E);
        kuVar.t.notifyDataSetChanged();
        ly.a(kuVar.g, "search_history", "search_history", null);
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a(Bundle bundle) {
        super.a(bundle);
        this.g.setRequestedOrientation(1);
        try {
            this.B = (InputMethodManager) this.g.getSystemService("input_method");
            if (bundle != null) {
                this.l = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY, "北京");
                this.m = bundle.getString("hint", "请输入位置");
                this.n = bundle.getString("content", "");
                this.o = bundle.getInt("input_type", 0);
                this.p = bundle.getInt("input_type_mid", 0);
            }
            this.q = (AutoCompleteTextView) this.v.findViewById(R.id.navi_sdk_search_input);
            this.r = (ListView) this.v.findViewById(R.id.navi_sdk_resultList);
            this.u = (ProgressBar) this.v.findViewById(R.id.navi_sdk_search_loading);
            this.y = (TextView) this.v.findViewById(R.id.navi_sdk_tv_msg);
            this.w = (ImageView) this.v.findViewById(R.id.navi_sdk_rl_iv_back);
            this.x = this.v.findViewById(R.id.navi_sdk_rl_iv_loc);
            this.z = (LoadingView) this.v.findViewById(R.id.navi_sdk_loading);
            this.A = (ImageView) this.v.findViewById(R.id.navi_sdk_iv_clean);
            this.r.setOnItemClickListener(this);
            this.r.setOnTouchListener(this);
            this.r.setCacheColorHint(0);
            this.w.setOnTouchListener(this);
            this.x.setOnClickListener(this);
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.A.setOnClickListener(this);
            this.q.addTextChangedListener(this);
            this.q.setHint(this.m);
            this.q.setText(this.n);
            this.q.requestFocus();
            this.q.setSelection(this.n.length());
            this.F = new TextView(this.g);
            this.F.setLayoutParams(new AbsListView.LayoutParams(-1, mj.a(this.g, 40)));
            this.F.setGravity(17);
            this.F.setText("清除历史搜索记录");
            this.F.setTextColor(Color.parseColor("#4287FF"));
            this.F.setId(1000001);
            this.r.addFooterView(this.F);
            this.F.setOnClickListener(this);
            String str = "SearchPage-->onCreate(),city=" + this.l + ",content=" + this.n;
            this.t = new kl(this.g);
            this.r.setAdapter((ListAdapter) this.t);
            this.D = ly.a(this.g, "search_history", "search_history");
            if (this.D == null) {
                this.D = new lt();
                this.E = new LinkedList<>();
            } else {
                this.E = this.D.a();
                if (this.E == null) {
                    this.E = new LinkedList<>();
                }
                if (this.E != null && this.E.size() > 0) {
                    this.t.a(this.E);
                    this.t.notifyDataSetChanged();
                    this.r.setVisibility(0);
                }
            }
            mq.a(this.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.h = false;
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a() {
        AutoCompleteTextView autoCompleteTextView = this.q;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setFocusable(true);
            this.q.requestFocus();
            k();
        }
    }

    public final void onClick(View view) {
        a(view);
    }

    @Override // com.amap.api.col.stln3.ke
    public final void a(View view) {
        try {
            int id = view.getId();
            if (id == 2147479791) {
                try {
                    j();
                    Poi a = this.g.getSearchResult().a();
                    Bundle bundle = new Bundle();
                    bundle.putInt("from", 3);
                    bundle.putBoolean("needRecalculate", false);
                    if (a == null) {
                        a("您没有开启GPS，无法定位到当前位置");
                        return;
                    }
                    if (b(a)) {
                        if (c(a)) {
                            bundle.putBoolean("needRecalculate", true);
                        }
                    }
                    bundle.putInt("input_type", this.o);
                    bundle.putInt("input_type_mid", this.p);
                    this.g.closeScr(bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (id == 2147479790) {
                this.q.setText("");
            } else if (id == 1000001) {
                try {
                    if (this.H == null) {
                        this.H = new Dialog(this.g);
                        this.H.requestWindowFeature(1);
                        this.H.getWindow().setBackgroundDrawableResource(17170445);
                    }
                    View a2 = mm.a(this.g, R.layout.amap_navi_lbs_exit_dialog, null);
                    TextView textView = (TextView) a2.findViewById(R.id.navi_sdk_lbs_dialog_cancle);
                    TextView textView2 = (TextView) a2.findViewById(R.id.navi_sdk_lbs_dialog_ok);
                    textView.setOnClickListener(this.I);
                    textView2.setOnClickListener(this.I);
                    this.H.setContentView(a2);
                    this.H.setCancelable(false);
                    ((TextView) a2.findViewById(R.id.navi_sdk_strategy_select_title)).setText("是否要清除历史搜索记录？");
                    textView.setText("取消");
                    textView2.setText("确定");
                    this.H.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
        }
    }

    private void j() {
        View peekDecorView = this.g.getWindow().peekDecorView();
        if (peekDecorView != null) {
            this.B.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    private void k() {
        AutoCompleteTextView autoCompleteTextView = this.q;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.requestFocus();
            this.B.showSoftInput(this.q, 2);
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final View e() {
        try {
            this.v = mm.a(this.g, R.layout.amap_navi_lbs_activity_search, null);
            return this.v;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.ke
    public final void g() {
        super.g();
        k();
    }

    @Override // com.amap.api.col.stln3.ke
    public final void h() {
        super.h();
    }

    @Override // com.amap.api.col.stln3.ke
    public final void i() {
        super.i();
        j();
    }

    @Override // com.amap.api.col.stln3.ke
    public final void f() {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        try {
            if (!mj.b(this.v.getContext())) {
                this.y.setText("当前网络不可用，无法进行搜索");
                this.y.setVisibility(0);
                a(false);
                return;
            }
            if (this.y.getVisibility() == 0) {
                this.y.setVisibility(8);
            }
            String trim = charSequence.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                a(true);
                lf lfVar = new lf(trim, this.l);
                if (this.g != null) {
                    if (iu.a(this.g.getApplicationContext()) != null) {
                        lfVar.a(new li(iu.a(this.g.getApplicationContext()).getLatitude(), iu.a(this.g.getApplicationContext()).getLongitude()));
                    }
                    ld ldVar = new ld(this.g.getApplicationContext(), lfVar);
                    ldVar.a(this);
                    ldVar.a();
                    return;
                }
                return;
            }
            this.A.setVisibility(8);
            l();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.q.getText().toString())) {
            this.A.setVisibility(8);
            l();
        }
    }

    private void l() {
        LinkedList<lw> linkedList = this.E;
        if (linkedList != null && linkedList.size() > 0) {
            this.r.setVisibility(0);
            this.t.a(this.E);
            this.t.notifyDataSetChanged();
            this.F.setVisibility(0);
        }
    }

    @Override // com.amap.api.col.stln3.ld.a
    public final void a(List<lw> list, int i2) {
        a(false);
        try {
            if (!TextUtils.isEmpty(this.q.getText().toString())) {
                this.A.setVisibility(0);
                if (i2 == 1000) {
                    this.s = new ArrayList();
                    for (lw lwVar : list) {
                        if (lwVar.b() != null) {
                            this.s.add(lwVar);
                        }
                    }
                    if (this.s != null) {
                        if (!this.s.isEmpty()) {
                            this.r.setVisibility(0);
                            this.F.setVisibility(8);
                            this.t.a(this.s);
                            this.t.notifyDataSetChanged();
                            return;
                        }
                    }
                    this.y.setText("抱歉，没有搜索到结果，请换个关键词试试");
                    this.y.setVisibility(0);
                    this.r.setVisibility(8);
                    return;
                }
                this.y.setText("出错了，请稍后重试");
                this.y.setVisibility(0);
            }
        } catch (Throwable th) {
            this.y.setText("出错了，请稍后重试");
            this.y.setVisibility(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        try {
            j();
            if (this.s == null) {
                if (this.E == null) {
                    return;
                }
            }
            lw lwVar = (lw) adapterView.getItemAtPosition(i2);
            this.C = new Poi(lwVar.c(), new LatLng(lwVar.b().b(), lwVar.b().a()), lwVar.a());
            if (!TextUtils.isEmpty(this.C.getPoiId())) {
                lq.b bVar = new lq.b(this.C.getName(), "", this.l);
                bVar.b();
                bVar.a();
                lq lqVar = new lq(this.g, bVar);
                lqVar.a(this);
                lqVar.a(this.C.getPoiId());
                c();
                return;
            }
            a(this.C);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Poi poi) {
        j();
        Bundle bundle = new Bundle();
        bundle.putInt("from", 3);
        bundle.putBoolean("needRecalculate", false);
        if (b(poi) && c(poi)) {
            bundle.putBoolean("needRecalculate", true);
        }
        bundle.putInt("input_type", this.o);
        bundle.putInt("input_type_mid", this.p);
        this.g.closeScr(bundle);
    }

    @Override // com.amap.api.col.stln3.ke
    public final boolean b() {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putInt("from", 3);
            bundle.putBoolean("needRecalculate", false);
            bundle.putInt("input_type", this.o);
            bundle.putInt("input_type_mid", this.p);
            this.g.closeScr(bundle);
        } catch (Throwable th) {
        }
        return false;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (view.getId() != 2147479787) {
                return false;
            }
            b();
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean b(Poi poi) {
        Poi b = this.g.getSearchResult().b();
        Poi f = this.g.getSearchResult().f();
        Poi c = this.g.getSearchResult().c();
        Poi d = this.g.getSearchResult().d();
        Poi e = this.g.getSearchResult().e();
        String str = "";
        int i2 = this.o;
        if (i2 == 0) {
            if (b != null && b.getCoordinate().equals(poi.getCoordinate())) {
                return false;
            }
            if (f != null && a(f, poi) && c == null && d == null && e == null) {
                str = "起点与终点不能相同";
            }
            if (c != null && a(c, poi)) {
                str = "起点与途经点不能相同";
            }
            if (d != null && a(d, poi)) {
                str = "起点与途经点不能相同";
            }
            if (e != null && a(e, poi)) {
                str = "起点与途经点不能相同";
            }
        } else if (i2 == 1) {
            if (f != null && a(f, poi)) {
                return false;
            }
            if (b != null && a(b, poi) && c == null && d == null && e == null) {
                str = "起点与终点不能相同";
            }
            if (c != null && a(c, poi)) {
                str = "终点与途经点不能相同";
            }
            if (d != null && a(d, poi)) {
                str = "终点与途经点不能相同";
            }
            if (e != null && a(e, poi)) {
                str = "终点与途经点不能相同";
            }
        } else if (i2 == 2) {
            int i3 = this.p;
            if (i3 == 0) {
                if (c != null && c.getCoordinate().equals(poi.getCoordinate())) {
                    return false;
                }
            } else if (i3 == 1) {
                if (d != null && a(d, poi)) {
                    return false;
                }
            } else if (i3 == 2 && e != null && a(e, poi)) {
                return false;
            }
            if (b != null && a(b, poi)) {
                str = "起点与途经点不能相同";
            }
            if (f != null && a(f, poi)) {
                str = "终点与途经点不能相同";
            }
            if (c != null && a(c, poi)) {
                str = "途经点不能相同";
            }
            if (d != null && a(d, poi)) {
                str = "途经点不能相同";
            }
            if (e != null && a(e, poi)) {
                str = "途经点不能相同";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        a(str);
        return false;
    }

    private static boolean a(Poi poi, Poi poi2) {
        if (!poi.getCoordinate().equals(poi2.getCoordinate()) || !poi.getName().equals(poi2.getName()) || !TextUtils.equals(poi.getPoiId(), poi2.getPoiId())) {
            return false;
        }
        return true;
    }

    private void a(String str) {
        ma.b(this.g, str);
    }

    private boolean c(Poi poi) {
        ko searchResult = this.g.getSearchResult();
        if (searchResult == null) {
            return false;
        }
        int i2 = this.o;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    switch (this.p) {
                        case 0:
                            searchResult.c(poi);
                            break;
                        case 1:
                            searchResult.d(poi);
                            break;
                        case 2:
                            searchResult.e(poi);
                            break;
                    }
                }
            } else {
                searchResult.f(poi);
            }
        } else {
            searchResult.b(poi);
        }
        if (searchResult.b() == null || searchResult.f() == null) {
            return false;
        }
        return true;
    }

    private void a(boolean z2) {
        if (z2) {
            try {
                this.A.setVisibility(8);
                this.u.setVisibility(0);
                this.z.showLoading();
                this.z.setVisibility(0);
            } catch (Throwable th) {
            }
        } else {
            this.u.setVisibility(8);
            this.z.hideLoading();
            this.z.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.stln3.lq.a
    public final void a(ln lnVar, int i2) {
        Poi poi;
        try {
            d();
            if (!this.h) {
                LatLng latLng = null;
                if (i2 == 1000) {
                    if (lnVar != null) {
                        li f = lnVar.f();
                        li e = lnVar.e();
                        if (this.o == 0) {
                            if (f != null) {
                                latLng = new LatLng(f.b(), f.a());
                            } else if (e != null) {
                                latLng = new LatLng(e.b(), e.a());
                            }
                        }
                        if (this.o != 1) {
                            if (this.o == 2) {
                            }
                        }
                        if (e != null) {
                            latLng = new LatLng(e.b(), e.a());
                        }
                    } else {
                        return;
                    }
                }
                if (latLng != null) {
                    poi = new Poi(this.C.getName(), latLng, this.C.getPoiId());
                } else {
                    poi = this.C;
                }
                lw lwVar = new lw();
                lwVar.a(lnVar.a());
                lwVar.b(lnVar.b());
                lwVar.e(lnVar.c());
                lwVar.a(lnVar.d());
                int i3 = -1;
                int i4 = 0;
                while (true) {
                    if (i4 >= this.E.size()) {
                        break;
                    } else if (lnVar.a().trim().equals(this.E.get(i4).a())) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 != 0) {
                    if (i3 > 0) {
                        this.E.remove(i3);
                    } else if (this.E.size() >= this.i) {
                        this.E.removeLast();
                    }
                    this.E.addFirst(lwVar);
                    this.D.a(this.E);
                    ly.a(this.g, "search_history", "search_history", this.D);
                }
                a(poi);
                this.h = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
