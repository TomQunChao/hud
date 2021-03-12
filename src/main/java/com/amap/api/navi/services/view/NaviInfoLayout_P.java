package com.amap.api.navi.services.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.model.InnerNaviInfo;

public class NaviInfoLayout_P extends a {
    private Bitmap b;
    private RelativeLayout c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private TextView j;

    public NaviInfoLayout_P(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        FrameLayout frameLayout = (FrameLayout) mm.a(context, R.layout.amap_navi_lbs_naviinfo_por, null);
        this.c = (RelativeLayout) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_collapsed);
        this.d = (RelativeLayout) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_expand);
        this.e = (ImageView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_nextturn_expand);
        this.f = (TextView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_disText_expand);
        this.g = (TextView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_nextRoadText_expand);
        this.h = (ImageView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_nextturn_collapsed);
        this.i = (TextView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_disText_collapsed);
        this.j = (TextView) frameLayout.findViewById(R.id.navi_sdk_lbs_por_naviinfo_nextRoadText_collapsed);
        addView(frameLayout);
    }

    public NaviInfoLayout_P(Context context) {
        this(context, null);
    }

    @Override // com.amap.api.navi.services.view.a
    public void updateNaviInfo(InnerNaviInfo innerNaviInfo) {
        int i2;
        if (!(this.f == null || this.g == null)) {
            this.f.setText(mj.a(innerNaviInfo.getCurStepRetainDistance(), 40, 25));
            this.g.setText(innerNaviInfo.getNextRoadName());
        }
        if (!(this.i == null || this.j == null)) {
            this.i.setText(mj.a(innerNaviInfo.getCurStepRetainDistance(), 25, 15));
            this.j.setText(innerNaviInfo.getNextRoadName());
        }
        this.b = innerNaviInfo.getIconBitmap();
        int iconType = innerNaviInfo.getIconType();
        if (this.b == null) {
            if (iconType > 19) {
                i2 = com.a11hud.www.R.attr.contentInsetRight;
            } else {
                i2 = this.a[iconType];
            }
            this.b = BitmapFactory.decodeResource(mm.a(), i2);
        }
        this.h.setImageBitmap(this.b);
        this.e.setImageBitmap(this.b);
    }

    @Override // com.amap.api.navi.services.view.a
    public void expandNaviInfo(boolean z) {
        if (z) {
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    @Override // com.amap.api.navi.services.view.a
    public void recycle() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    @Override // com.amap.api.navi.services.view.a
    public void setGPSView(boolean z) {
    }
}
