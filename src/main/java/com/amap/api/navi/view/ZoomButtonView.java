package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

public class ZoomButtonView extends LinearLayout {
    private ImageButton zoomInBtn;
    private ImageButton zoomOutBtn;

    public ZoomButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ZoomButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ZoomButtonView(Context context) {
        super(context);
        init();
    }

    public ImageButton getZoomOutBtn() {
        return this.zoomOutBtn;
    }

    public ImageButton getZoomInBtn() {
        return this.zoomInBtn;
    }

    private void init() {
        try {
            View a = mm.a(getContext(), R.layout.amap_navi_api_zoom_button_view, null);
            addView(a);
            this.zoomOutBtn = (ImageButton) a.findViewById(R.id.navi_sdk_autonavi_zoom_out);
            this.zoomInBtn = (ImageButton) a.findViewById(R.id.navi_sdk_autonavi_zoom_in);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
