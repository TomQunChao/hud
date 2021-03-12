package com.amap.api.navi.services.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.lz;
import com.amap.api.col.stln3.md;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INaviInfoCallback;

/* compiled from: StrategyPopWindow */
public final class e extends PopupWindow implements View.OnClickListener {
    private static int m = 5;
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private View E;
    private View F;
    Drawable a;
    Drawable b;
    int c;
    int d;
    Drawable e;
    Drawable f;
    Drawable g;
    Drawable h;
    Drawable i;
    Drawable j;
    Drawable k;
    Drawable l;
    private Context n;
    private View o;
    private View p;
    private View q;
    private View r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public static void a() {
        m = 5;
    }

    public static int b() {
        return m;
    }

    public static void c() {
        m--;
    }

    public e(final Context context) {
        Resources a2;
        int i2;
        if (mm.b == R.drawable.abc_btn_borderless_material) {
            this.a = mm.a().getDrawable(R.attr.measureWithLargestChild);
            this.b = mm.a().getDrawable(R.attr.switchPadding);
            this.c = Color.parseColor("#B4343437");
            this.d = Color.parseColor("#FF343437");
            this.e = mm.a().getDrawable(R.attr.layout_constraintVertical_bias);
            this.f = mm.a().getDrawable(R.attr.layout_constraintVertical_weight);
            this.g = mm.a().getDrawable(R.attr.layout_constraintHorizontal_weight);
            this.h = mm.a().getDrawable(R.attr.layout_constraintLeft_toLeftOf);
            this.i = mm.a().getDrawable(R.attr.layout_constraintRight_toRightOf);
            this.j = mm.a().getDrawable(R.attr.layout_constraintStart_toStartOf);
            this.k = mm.a().getDrawable(R.attr.layout_constraintWidth_percent);
            a2 = mm.a();
            i2 = R.attr.layout_editor_absoluteX;
        } else if (mm.b == R.drawable.abc_action_bar_item_background_material) {
            this.a = mm.a().getDrawable(R.attr.navigationMode);
            this.b = mm.a().getDrawable(R.attr.switchStyle);
            this.c = Color.parseColor("#7F202022");
            this.d = Color.parseColor("#CC202022");
            this.e = mm.a().getDrawable(R.attr.layout_constraintWidth_max);
            this.f = mm.a().getDrawable(R.attr.layout_constraintWidth_default);
            this.g = mm.a().getDrawable(R.attr.layout_constraintRight_creator);
            this.h = mm.a().getDrawable(R.attr.layout_constraintLeft_toRightOf);
            this.i = mm.a().getDrawable(R.attr.layout_constraintTop_toBottomOf);
            this.j = mm.a().getDrawable(R.attr.layout_constraintTop_creator);
            this.k = mm.a().getDrawable(R.attr.layout_goneMarginBottom);
            a2 = mm.a();
            i2 = R.attr.layout_editor_absoluteY;
        } else {
            this.a = mm.a().getDrawable(R.attr.maxButtonHeight);
            this.b = mm.a().getDrawable(R.attr.switchMinWidth);
            this.c = ViewCompat.MEASURED_STATE_MASK;
            this.d = -1;
            this.e = mm.a().getDrawable(R.attr.layout_constraintTop_toTopOf);
            this.f = mm.a().getDrawable(R.attr.layout_constraintVertical_chainStyle);
            this.g = mm.a().getDrawable(R.attr.layout_constraintHorizontal_chainStyle);
            this.h = mm.a().getDrawable(R.attr.layout_constraintLeft_creator);
            this.i = mm.a().getDrawable(R.attr.layout_constraintRight_toLeftOf);
            this.j = mm.a().getDrawable(R.attr.layout_constraintStart_toEndOf);
            this.k = mm.a().getDrawable(R.attr.layout_constraintWidth_min);
            a2 = mm.a();
            i2 = R.attr.layout_dodgeInsetEdges;
        }
        this.l = a2.getDrawable(i2);
        this.n = context;
        View a3 = mm.a(context, com.amap.api.navi.R.layout.amap_navi_lbs_route_foot_layout_strategy, null);
        this.F = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_layout_strategy);
        ((RadioGroup) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_rg_broadcast_model)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.amap.api.navi.services.view.e.AnonymousClass1 */

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                try {
                    e.a();
                    AMapNavi instance = AMapNavi.getInstance(context);
                    if (instance != null) {
                        if (i == 2147479640) {
                            AMapNavi.setTtsPlaying(false);
                            if (instance.getIsUseInnerVoice() && md.a(context) != null) {
                                md.a(context).b();
                            }
                            instance.setBroadcastMode(2);
                        }
                        if (i == 2147479641) {
                            AMapNavi.setTtsPlaying(false);
                            if (instance.getIsUseInnerVoice() && md.a(context) != null) {
                                md.a(context).b();
                            }
                            instance.setBroadcastMode(1);
                        }
                        if (i == 2147479642) {
                            if (instance.getIsUseInnerVoice() && md.a(context) != null) {
                                md.a(context).a();
                            }
                            AMapNavi.setTtsPlaying(true);
                            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
                            if (callback != null) {
                                callback.onStopSpeaking();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.E = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_rly_broadcast);
        this.o = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab1);
        this.p = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab2);
        this.q = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab3);
        this.r = a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab4);
        this.A = (ImageView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab1_image);
        this.B = (ImageView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab2_image);
        this.C = (ImageView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab3_image);
        this.D = (ImageView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab4_image);
        this.w = (TextView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab1_text);
        this.x = (TextView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab2_text);
        this.y = (TextView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab3_text);
        this.z = (TextView) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_tab4_text);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        ((Button) a3.findViewById(com.amap.api.navi.R.id.navi_sdk_strategy_select_complete)).setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.navi.services.view.e.AnonymousClass2 */

            public final void onClick(View view) {
                try {
                    e.this.dismiss();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (!AmapNaviPage.getInstance().isShowRouteStrategyPreferenceView()) {
            this.F.setVisibility(8);
            this.E.setBackground(null);
            this.F.setBackground(null);
            a3.setBackgroundResource(R.attr.searchViewStyle);
        }
        setOutsideTouchable(true);
        setContentView(a3);
        setHeight(((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 2);
        setWidth(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(-1342177280));
        this.s = lz.a(context, "NAVI_STRATEGY_TAB1");
        this.t = lz.a(context, "NAVI_STRATEGY_TAB2");
        this.u = lz.a(context, "NAVI_STRATEGY_TAB3");
        this.v = lz.a(context, "NAVI_STRATEGY_TAB4");
    }

    public final void d() {
        if (this.s) {
            this.o.setBackgroundDrawable(this.b);
            this.A.setImageDrawable(this.f);
            this.w.setTextColor(this.d);
        } else {
            this.o.setBackgroundDrawable(this.a);
            this.A.setImageDrawable(this.e);
            this.w.setTextColor(this.c);
        }
        if (this.t) {
            this.p.setBackgroundDrawable(this.b);
            this.B.setImageDrawable(this.h);
            this.x.setTextColor(this.d);
        } else {
            this.p.setBackgroundDrawable(this.a);
            this.B.setImageDrawable(this.g);
            this.x.setTextColor(this.c);
        }
        if (this.u) {
            this.q.setBackgroundDrawable(this.b);
            this.C.setImageDrawable(this.j);
            this.y.setTextColor(this.d);
        } else {
            this.q.setBackgroundDrawable(this.a);
            this.C.setImageDrawable(this.i);
            this.y.setTextColor(this.c);
        }
        if (this.v) {
            this.r.setBackgroundDrawable(this.b);
            this.D.setImageDrawable(this.l);
            this.z.setTextColor(this.d);
            return;
        }
        this.r.setBackgroundDrawable(this.a);
        this.D.setImageDrawable(this.k);
        this.z.setTextColor(this.c);
    }

    public final void a(boolean z2) {
        View view = this.E;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void onClick(View view) {
        TextView textView;
        int i2;
        try {
            int id = view.getId();
            if (id == 2147479733) {
                if (this.s) {
                    lz.a(this.n, false);
                    this.s = false;
                    this.o.setBackgroundDrawable(this.a);
                    this.A.setImageDrawable(this.e);
                    textView = this.w;
                    i2 = this.c;
                } else {
                    lz.a(this.n, true);
                    this.s = true;
                    this.o.setBackgroundDrawable(this.b);
                    this.A.setImageDrawable(this.f);
                    textView = this.w;
                    i2 = this.d;
                }
            } else if (id == 2147479736) {
                if (this.t) {
                    lz.b(this.n, false);
                    this.t = false;
                    this.p.setBackgroundDrawable(this.a);
                    this.B.setImageDrawable(this.g);
                    textView = this.x;
                    i2 = this.c;
                } else {
                    if (this.v) {
                        this.r.performClick();
                    }
                    lz.b(this.n, true);
                    this.t = true;
                    this.p.setBackgroundDrawable(this.b);
                    this.B.setImageDrawable(this.h);
                    textView = this.x;
                    i2 = this.d;
                }
            } else if (id != 2147479739) {
                if (id == 2147479742) {
                    if (this.v) {
                        lz.d(this.n, false);
                        this.v = false;
                        this.r.setBackgroundDrawable(this.a);
                        this.D.setImageDrawable(this.k);
                        textView = this.z;
                        i2 = this.c;
                    } else {
                        if (this.u) {
                            this.q.performClick();
                        }
                        if (this.t) {
                            this.p.performClick();
                        }
                        lz.d(this.n, true);
                        this.v = true;
                        this.r.setBackgroundDrawable(this.b);
                        this.D.setImageDrawable(this.l);
                        textView = this.z;
                        i2 = this.d;
                    }
                }
                m = 5;
            } else if (this.u) {
                lz.c(this.n, false);
                this.u = false;
                this.q.setBackgroundDrawable(this.a);
                this.C.setImageDrawable(this.i);
                textView = this.y;
                i2 = this.c;
            } else {
                if (this.v) {
                    this.r.performClick();
                }
                lz.c(this.n, true);
                this.u = true;
                this.q.setBackgroundDrawable(this.b);
                this.C.setImageDrawable(this.j);
                textView = this.y;
                i2 = this.d;
            }
            textView.setTextColor(i2);
            m = 5;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void e() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
    }
}
