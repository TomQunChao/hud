package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mm;

public class NextTurnTipView extends ImageView {
    private int[] customIconTypeDrawables;
    private Resources customRes;
    private int[] defaultIconTypes = {R.attr.arrowShaftLength, R.attr.arrowShaftLength, R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.editTextStyle, R.attr.elevation, R.attr.emptyVisibility, R.attr.expandActivityOverflowButtonDrawable, R.attr.firstBaselineToTopHeight, R.attr.font, R.attr.fontFamily, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.splitTrack};
    private long mLastIconType = -1;
    private Bitmap nextTurnBitmap;

    public Resources getCustomResources() {
        return this.customRes;
    }

    public int[] getCustomIconTypeDrawables() {
        return this.customIconTypeDrawables;
    }

    public void setCustomIconTypes(Resources resources, int[] iArr) {
        if (resources != null && iArr != null) {
            try {
                this.customRes = resources;
                this.customIconTypeDrawables = new int[(iArr.length + 2)];
                for (int i = 0; i < iArr.length; i++) {
                    this.customIconTypeDrawables[i + 2] = iArr[i];
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NextTurnTipView(Context context) {
        super(context);
    }

    public void recycleResource() {
        try {
            if (this.nextTurnBitmap != null) {
                this.nextTurnBitmap.recycle();
                this.nextTurnBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setIconType(int i) {
        try {
            if (this.mLastIconType != ((long) i)) {
                if (i > 19) {
                    i = 9;
                }
                recycleResource();
                if (this.customIconTypeDrawables == null || this.customRes == null) {
                    this.nextTurnBitmap = BitmapFactory.decodeResource(mm.a(), this.defaultIconTypes[i]);
                } else {
                    this.nextTurnBitmap = BitmapFactory.decodeResource(this.customRes, this.customIconTypeDrawables[i]);
                }
                setImageBitmap(this.nextTurnBitmap);
                this.mLastIconType = (long) i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }
}
