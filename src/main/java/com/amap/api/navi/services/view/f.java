package com.amap.api.navi.services.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.view.ForbiddenTipView;
import com.amap.api.navi.view.SuggestPathPopView;

/* compiled from: SuggestPathPopWindow */
public final class f extends PopupWindow {
    public static int a = 108;
    SuggestPathPopView b;

    public f(Context context) {
        View a2 = mm.a(context, R.layout.amap_navi_lbs_route_foot_layout_suggestpath, null);
        this.b = (SuggestPathPopView) a2.findViewById(R.id.navi_sdk_lbs_suggestpath_tip);
        this.b.setBackgroundResource(com.a11hud.www.R.attr.textAppearanceLargePopupMenu);
        setContentView(a2);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setHeight(this.b.getHeight());
        setWidth(-1);
        setFocusable(false);
    }

    public final void a(String str, String str2, long j) {
        this.b.updatePathInfo(str, str2, j);
        this.b.setTipListener(new ForbiddenTipView.TipVisibleListener() {
            /* class com.amap.api.navi.services.view.f.AnonymousClass1 */

            @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
            public final void onTipShow() {
            }

            @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
            public final void onTipHide() {
                f.this.dismiss();
            }
        });
    }

    public static void a() {
    }
}
