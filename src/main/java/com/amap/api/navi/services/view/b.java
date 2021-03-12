package com.amap.api.navi.services.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.enums.NaviForbidType;
import com.amap.api.navi.enums.NaviLimitType;
import com.amap.api.navi.model.AMapNaviForbiddenInfo;
import com.amap.api.navi.model.AMapNaviLimitInfo;

/* compiled from: ForbiddenTipPopWindow */
public final class b extends PopupWindow implements View.OnClickListener {
    private ImageView a;
    private TextView b;
    private TextView c;
    private View d;
    private TextView e;
    private TextView f;
    private ImageView g;

    public b(Context context) {
        View a2 = mm.a(context, R.layout.amap_navi_lbs_route_foot_layout_tip, null);
        this.a = (ImageView) a2.findViewById(R.id.navi_sdk_icon_tip_desc);
        this.b = (TextView) a2.findViewById(R.id.navi_sdk_text_tip_title);
        this.c = (TextView) a2.findViewById(R.id.navi_sdk_text_tip_desc);
        this.d = a2.findViewById(R.id.navi_sdk_layout_tip_detail);
        this.e = (TextView) a2.findViewById(R.id.navi_sdk_tip_limit_time);
        this.f = (TextView) a2.findViewById(R.id.navi_sdk_tip_limit_detail);
        this.g = (ImageView) a2.findViewById(R.id.navi_sdk_icon_tip_close);
        this.g.setOnClickListener(this);
        setOutsideTouchable(true);
        setContentView(a2);
        setHeight(((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 3);
        setWidth(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final void a(AMapNaviLimitInfo aMapNaviLimitInfo) {
        int i;
        switch (aMapNaviLimitInfo.type) {
            case 81:
                i = com.a11hud.www.R.attr.gapBetweenBars;
                break;
            case 82:
                i = com.a11hud.www.R.attr.homeLayout;
                break;
            default:
                i = 0;
                break;
        }
        this.a.setImageBitmap(BitmapFactory.decodeResource(mm.a(), i));
        String limitText = NaviLimitType.getLimitText(aMapNaviLimitInfo.type);
        this.b.setText(limitText);
        TextView textView = this.c;
        textView.setText("当前道路有" + limitText + ", 无法避开");
        this.d.setVisibility(8);
        setHeight(60);
    }

    public final void a(AMapNaviForbiddenInfo aMapNaviForbiddenInfo) {
        int i;
        switch (aMapNaviForbiddenInfo.forbiddenType) {
            case 0:
                i = com.a11hud.www.R.attr.goIcon;
                break;
            case 1:
                i = com.a11hud.www.R.attr.hideOnContentScroll;
                break;
            case 2:
                i = com.a11hud.www.R.attr.height;
                break;
            case 3:
                i = com.a11hud.www.R.attr.homeAsUpIndicator;
                break;
            case 4:
                i = com.a11hud.www.R.attr.fontWeight;
                break;
            default:
                i = 0;
                break;
        }
        this.a.setImageBitmap(BitmapFactory.decodeResource(mm.a(), i));
        String forbiddenText = NaviForbidType.getForbiddenText(aMapNaviForbiddenInfo.forbiddenType);
        this.b.setText(forbiddenText);
        TextView textView = this.c;
        textView.setText(aMapNaviForbiddenInfo.roadName + forbiddenText);
        this.d.setVisibility(0);
        TextView textView2 = this.e;
        textView2.setText("禁行时间：" + aMapNaviForbiddenInfo.forbiddenTime);
        TextView textView3 = this.f;
        textView3.setText("车型限制：" + aMapNaviForbiddenInfo.carTypeDesc);
        setHeight(120);
    }

    public final void onClick(View view) {
        dismiss();
    }
}
