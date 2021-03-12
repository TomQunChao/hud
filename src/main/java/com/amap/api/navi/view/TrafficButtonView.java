package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mm;

public class TrafficButtonView extends ImageView {
    private boolean mIsTrafficOpen;
    private Bitmap trafficCloseBitmap;
    private Bitmap trafficOpenBitmap;

    public TrafficButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initBackground();
    }

    public TrafficButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initBackground();
    }

    public TrafficButtonView(Context context) {
        super(context);
        initBackground();
    }

    private void initBackground() {
        try {
            this.trafficOpenBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.lastBaselineToBottomHeight);
            this.trafficCloseBitmap = BitmapFactory.decodeResource(mm.a(), R.attr.keylines);
            setIsTrafficOpen(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reDrawBackground(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            try {
                this.trafficOpenBitmap = bitmap;
                this.trafficCloseBitmap = bitmap2;
                setIsTrafficOpen(this.mIsTrafficOpen);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean getIsTrafficOpen() {
        return this.mIsTrafficOpen;
    }

    public void setIsTrafficOpen(boolean z) {
        try {
            this.mIsTrafficOpen = z;
            if (this.mIsTrafficOpen) {
                setImageBitmap(this.trafficOpenBitmap);
            } else {
                setImageBitmap(this.trafficCloseBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recycleResource() {
        try {
            if (this.trafficCloseBitmap != null) {
                this.trafficCloseBitmap.recycle();
                this.trafficCloseBitmap = null;
            }
            if (this.trafficOpenBitmap != null) {
                this.trafficOpenBitmap.recycle();
                this.trafficOpenBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
