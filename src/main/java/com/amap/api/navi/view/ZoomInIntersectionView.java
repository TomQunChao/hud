package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.amap.api.navi.model.AMapNaviCross;

public class ZoomInIntersectionView extends ImageView {
    private Bitmap zoomInBitmap = null;

    public ZoomInIntersectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ZoomInIntersectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZoomInIntersectionView(Context context) {
        super(context);
    }

    public void setIntersectionBitMap(AMapNaviCross aMapNaviCross) {
        try {
            this.zoomInBitmap = aMapNaviCross.getBitmap();
            setImageBitmap(this.zoomInBitmap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void recycleResource() {
        try {
            if (this.zoomInBitmap != null) {
                this.zoomInBitmap.recycle();
                this.zoomInBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
