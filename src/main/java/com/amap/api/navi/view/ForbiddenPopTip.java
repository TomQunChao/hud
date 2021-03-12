package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapRestrictionInfo;
import com.amap.api.navi.view.ForbiddenTipView;

public class ForbiddenPopTip extends PopupWindow {
    View popWindow = null;
    ForbiddenTipView tipView = null;

    public ForbiddenPopTip(Context context) {
        View a = mm.a(context, R.layout.amap_navi_lbs_foridden_tip_pop, null);
        this.popWindow = a.findViewById(R.id.navi_sdk_lbs_forbidden_pop);
        this.tipView = (ForbiddenTipView) a.findViewById(R.id.navi_sdk_lbs_forbidden_tip);
        setContentView(a);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setHeight(this.tipView.getHeight());
        setWidth(-1);
        setFocusable(false);
    }

    public void upRouteForbiddenInfo(AMapRestrictionInfo aMapRestrictionInfo) {
        this.tipView.setRestrictionInfo(aMapRestrictionInfo, -1, false);
    }

    public void upNaviRouteNotifyData(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
        this.tipView.setNotifyData(aMapNaviRouteNotifyData, 10);
        this.tipView.setForbiddenTipListener(new ForbiddenTipView.TipVisibleListener() {
            /* class com.amap.api.navi.view.ForbiddenPopTip.AnonymousClass1 */

            @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
            public final void onTipShow() {
            }

            @Override // com.amap.api.navi.view.ForbiddenTipView.TipVisibleListener
            public final void onTipHide() {
                ForbiddenPopTip.this.dismiss();
            }
        });
    }

    public void destroy() {
        ForbiddenTipView forbiddenTipView = this.tipView;
        if (forbiddenTipView != null) {
            forbiddenTipView.destroy();
        }
    }
}
