package com.amap.api.navi.services.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.R;
import com.amap.api.navi.model.InnerNaviInfo;

public class NaviInfoLayout_L extends a {
    private Bitmap b;
    private RelativeLayout c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private Button l;
    private TextView m;
    private TextView n;
    private String o;
    private String p;
    private int q;
    private int r;

    public NaviInfoLayout_L(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = "#FFFFFF";
        this.p = "#FFFFFF";
        this.q = 30;
        this.r = 30;
        LinearLayout linearLayout = (LinearLayout) mm.a(context, R.layout.amap_navi_lbs_naviinfo_land, null);
        this.c = (RelativeLayout) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_left);
        this.d = (RelativeLayout) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_top);
        this.e = (ImageView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_nextturn_view_left);
        this.f = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_DisText_left);
        this.g = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_nextRoadNameText_left);
        this.g.setTextSize(1, 22.0f);
        this.h = (ImageView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_nextturn_view_top);
        this.i = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_DisText_top);
        this.j = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_nextRoadNameText_top);
        this.i.setTextSize(1, 24.0f);
        this.j.setTextSize(1, 22.0f);
        this.l = (Button) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_navi_continue);
        this.m = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_text_time);
        this.n = (TextView) linearLayout.findViewById(R.id.navi_sdk_lbs_naviinfo_land_text_distance);
        this.k = (TextView) linearLayout.findViewById(R.id.sim_speed);
        addView(linearLayout);
    }

    public NaviInfoLayout_L(Context context) {
        this(context, null);
    }

    @Override // com.amap.api.navi.services.view.a
    public void expandNaviInfo(boolean z) {
        if (!z) {
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            return;
        }
        this.d.setVisibility(8);
        this.c.setVisibility(0);
    }

    @Override // com.amap.api.navi.services.view.a
    public void showContinueButton(boolean z) {
        super.showContinueButton(z);
        AMapNavi instance = AMapNavi.getInstance(getContext());
        if (instance != null && instance.getNaviType() == 2) {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else if (z) {
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            this.n.setVisibility(0);
        }
    }

    @Override // com.amap.api.navi.services.view.a
    public void recycle() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    @Override // com.amap.api.navi.services.view.a
    public void updateEmulatorInfo(int i2) {
        switch (i2) {
            case 1:
                this.k.setText("低速");
                return;
            case 2:
                this.k.setText("中速");
                return;
            case 3:
                this.k.setText("高速");
                return;
            default:
                return;
        }
    }

    @Override // com.amap.api.navi.services.view.a
    public void setGPSView(boolean z) {
    }

    @Override // com.amap.api.navi.services.view.a
    public Button getContinueButton() {
        return this.l;
    }

    public TextView getSimSpeedButton() {
        return this.k;
    }

    @Override // com.amap.api.navi.services.view.a
    public void updateNaviInfo(InnerNaviInfo innerNaviInfo) {
        int i2;
        int i3;
        this.f.setText(mj.a(innerNaviInfo.getCurStepRetainDistance(), 33, 20));
        this.g.setText(innerNaviInfo.getNextRoadName());
        Spanned fromHtml = Html.fromHtml(mj.a(mj.b(innerNaviInfo.getPathRetainTime()), this.o, this.p));
        int pathRetainDistance = innerNaviInfo.getPathRetainDistance();
        StringBuilder sb = new StringBuilder();
        sb.append(pathRetainDistance);
        if (sb.toString().length() >= 7) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        SpannableStringBuilder a = mj.a(pathRetainDistance, this.q - i2, this.r - i2);
        this.m.setText(fromHtml);
        TextView textView = this.n;
        textView.setText("剩余" + ((Object) a));
        this.i.setText(mj.a(innerNaviInfo.getCurStepRetainDistance(), 24, 15));
        this.j.setText(innerNaviInfo.getNextRoadName());
        this.b = innerNaviInfo.getIconBitmap();
        int iconType = innerNaviInfo.getIconType();
        if (this.b == null) {
            if (iconType > 19) {
                i3 = com.a11hud.www.R.attr.contentInsetRight;
            } else {
                i3 = this.a[iconType];
            }
            this.b = BitmapFactory.decodeResource(mm.a(), i3);
        }
        this.e.setImageBitmap(this.b);
        this.h.setImageBitmap(this.b);
    }
}
