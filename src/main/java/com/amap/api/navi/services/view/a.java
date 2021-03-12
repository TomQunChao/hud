package com.amap.api.navi.services.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.a11hud.www.R;
import com.amap.api.navi.model.InnerNaviInfo;

/* compiled from: BaseNaviInfoLayout */
public abstract class a extends RelativeLayout {
    protected int[] a;

    public abstract void expandNaviInfo(boolean z);

    public abstract void recycle();

    public abstract void setGPSView(boolean z);

    public abstract void updateNaviInfo(InnerNaviInfo innerNaviInfo);

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new int[]{R.attr.arrowShaftLength, R.attr.arrowShaftLength, R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.editTextStyle, R.attr.elevation, R.attr.emptyVisibility, R.attr.expandActivityOverflowButtonDrawable, R.attr.firstBaselineToTopHeight, R.attr.font, R.attr.fontFamily};
    }

    public a(Context context) {
        this(context, null);
    }

    public Button getContinueButton() {
        return null;
    }

    public void showContinueButton(boolean z) {
    }

    public void updateEmulatorInfo(int i) {
    }
}
