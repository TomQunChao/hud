package com.amap.api.col.stln3;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.a11hud.www.R;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: OfflineMapPage */
public final class my extends a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {
    private ImageView b;
    private RelativeLayout c;
    private DownLoadExpandListView d;
    private ListView e;
    private ExpandableListView f;
    private ImageView g;
    private ImageView h;
    private AutoCompleteTextView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private ImageView m;
    private RelativeLayout n;
    private List<OfflineMapProvince> o = new ArrayList();
    private ms p;
    private OfflineMapManager q = null;
    private mr r;
    private mt s;
    private boolean t = true;
    private boolean u = true;
    private int v = -1;
    private long w = 0;
    private mu x;
    private boolean y = true;

    @Override // com.amap.api.offlineservice.a
    public final void b() {
        View a = na.a(this.a, R.bool.abc_action_bar_embed_tabs);
        this.d = (DownLoadExpandListView) a.findViewById(R.id.META);
        this.d.setOnTouchListener(this);
        this.j = (RelativeLayout) a.findViewById(R.id.ALT);
        this.g = (ImageView) a.findViewById(R.id.FUNCTION);
        this.j.setOnClickListener(this.a);
        this.k = (RelativeLayout) a.findViewById(R.id.SYM);
        this.h = (ImageView) a.findViewById(R.id.action_bar);
        this.k.setOnClickListener(this.a);
        this.n = (RelativeLayout) a.findViewById(R.id.SHIFT);
        this.b = (ImageView) this.c.findViewById(R.id.action_mode_close_button);
        this.b.setOnClickListener(this.a);
        this.m = (ImageView) this.c.findViewById(R.id.actions);
        this.l = (ImageView) this.c.findViewById(R.id.add);
        this.l.setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.col.stln3.my.AnonymousClass1 */

            public final void onClick(View view) {
                try {
                    my.this.i.setText("");
                    my.this.l.setVisibility(8);
                    my.this.a(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) my.this.m.getLayoutParams();
                    layoutParams.leftMargin = my.this.a(95.0f);
                    my.this.m.setLayoutParams(layoutParams);
                    my.this.i.setPadding(my.this.a(105.0f), 0, 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.c.findViewById(R.id.adress).setOnTouchListener(this);
        this.i = (AutoCompleteTextView) this.c.findViewById(R.id.activity_chooser_view_content);
        this.i.addTextChangedListener(this);
        this.i.setOnTouchListener(this);
        this.e = (ListView) this.c.findViewById(R.id.all);
        this.f = (ExpandableListView) this.c.findViewById(R.id.alertTitle);
        this.f.addHeaderView(a);
        this.f.setOnTouchListener(this);
        this.f.setOnScrollListener(this);
        this.q = new OfflineMapManager(this.a, this);
        this.q.setOnOfflineLoadedListener(this);
        f();
        this.p = new ms(this.o, this.q, this.a);
        this.f.setAdapter(this.p);
        this.f.setOnGroupCollapseListener(this.p);
        this.f.setOnGroupExpandListener(this.p);
        this.f.setGroupIndicator(null);
        if (this.t) {
            this.h.setBackgroundResource(R.attr.actionBarDivider);
            this.f.setVisibility(0);
        } else {
            this.h.setBackgroundResource(R.attr.actionBarSplitStyle);
            this.f.setVisibility(8);
        }
        if (this.u) {
            this.g.setBackgroundResource(R.attr.actionBarDivider);
            this.d.setVisibility(0);
            return;
        }
        this.g.setBackgroundResource(R.attr.actionBarSplitStyle);
        this.d.setVisibility(8);
    }

    @Override // com.amap.api.offlineservice.a
    public final void a(View view) {
        try {
            int id = view.getId();
            if (id == R.id.action_mode_close_button) {
                this.a.closeScr();
            } else if (id == R.id.ALT) {
                if (this.u) {
                    this.d.setVisibility(8);
                    this.g.setBackgroundResource(R.attr.actionBarSplitStyle);
                    this.u = false;
                    return;
                }
                this.d.setVisibility(0);
                this.g.setBackgroundResource(R.attr.actionBarDivider);
                this.u = true;
            } else if (id != R.id.SYM) {
            } else {
                if (this.t) {
                    this.p.b();
                    this.h.setBackgroundResource(R.attr.actionBarSplitStyle);
                    this.t = false;
                    return;
                }
                this.p.a();
                this.h.setBackgroundResource(R.attr.actionBarDivider);
                this.t = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout d() {
        if (this.c == null) {
            this.c = (RelativeLayout) na.a(this.a, com.amap.api.navi.R.layout.amap_navi_api_navi_base_fragment);
        }
        return this.c;
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        this.q.destroy();
    }

    public final void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.x == null) {
                this.x = new mu(this.a, this.q);
            }
            this.x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.x.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.q.getOfflineMapProvinceList();
        this.o.clear();
        this.o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i2 = 0; i2 < offlineMapProvinceList.size(); i2++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i2);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.o.add(i2 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.o.add(offlineMapProvince4);
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i2, int i3, String str) {
        switch (i2) {
            case -1:
                break;
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                switch (i2) {
                    case 101:
                        try {
                            Toast.makeText(this.a, "网络异常", 0).show();
                            this.q.pause();
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                }
        }
        if (i2 == 2) {
            this.r.a();
        }
        if (this.v != i2) {
            if (this.p != null) {
                this.p.notifyDataSetChanged();
            }
            if (this.r != null) {
                this.r.notifyDataSetChanged();
            }
            if (this.s != null) {
                this.s.notifyDataSetChanged();
            }
            this.v = i2;
        } else if (System.currentTimeMillis() - this.w > 1200) {
            if (this.y) {
                this.r.notifyDataSetChanged();
            }
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z, String str, String str2) {
        mr mrVar = this.r;
        if (mrVar != null) {
            mrVar.b();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        f();
        List<OfflineMapProvince> list = this.o;
        this.s = new mt(this.q, this.a);
        this.e.setAdapter((ListAdapter) this.s);
        this.r = new mr(this.a, this, this.q, this.o);
        this.d.setAdapter(this.r);
        this.r.notifyDataSetChanged();
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean c() {
        try {
            if (this.e.getVisibility() == 0) {
                this.i.setText("");
                this.l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return super.c();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AutoCompleteTextView autoCompleteTextView = this.i;
        if (autoCompleteTextView != null && autoCompleteTextView.isFocused()) {
            this.i.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
            if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
                inputMethodManager.hideSoftInputFromWindow(this.i.getWindowToken(), 2);
            }
        }
        if (view.getId() == R.id.activity_chooser_view_content) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.leftMargin = a(18.0f);
                this.m.setLayoutParams(layoutParams);
                this.i.setPadding(a(30.0f), 0, 0, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince offlineMapProvince : this.o) {
                arrayList2.addAll(offlineMapProvince.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            a(true);
            Collections.sort(arrayList, new Comparator<OfflineMapCity>() {
                /* class com.amap.api.col.stln3.my.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
                    char[] charArray = offlineMapCity.getJianpin().toCharArray();
                    char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
                    return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
                }
            });
            this.s.a(arrayList);
            this.s.notifyDataSetChanged();
            return;
        }
        Toast.makeText(this.a, "未找到相关城市", 0).show();
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void a(boolean z) {
        int i2 = 0;
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.n.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.n.setVisibility(0);
        this.d.setVisibility(this.u ? 0 : 8);
        ExpandableListView expandableListView = this.f;
        if (!this.t) {
            i2 = 8;
        }
        expandableListView.setVisibility(i2);
        this.e.setVisibility(8);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 2) {
            this.y = false;
        } else {
            this.y = true;
        }
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
