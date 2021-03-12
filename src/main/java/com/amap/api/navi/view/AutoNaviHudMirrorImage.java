package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.amap.api.col.stln3.rx;
import com.amap.api.navi.AMapHudView;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

public class AutoNaviHudMirrorImage extends RelativeLayout {
    private Bitmap hudMirrorBitmap;
    private Canvas hudMirrorCanvas;
    private Matrix hudMirrorMatrix;
    private Paint hudMirrorPaint;
    private AMapHudView mAMapHudView;
    public int mHeight = GLMapStaticValue.ANIMATION_MOVE_TIME;
    private boolean mIsMirror = false;
    public int mWidth = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;

    public AutoNaviHudMirrorImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            invalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.mIsMirror) {
            if (this.hudMirrorBitmap == null) {
                this.hudMirrorBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.RGB_565);
            }
            if (this.hudMirrorCanvas == null) {
                this.hudMirrorCanvas = new Canvas(this.hudMirrorBitmap);
            }
            if (this.hudMirrorPaint == null) {
                this.hudMirrorPaint = new Paint();
            }
            if (this.hudMirrorMatrix == null) {
                this.hudMirrorMatrix = new Matrix();
            }
            this.hudMirrorPaint.setAntiAlias(true);
            this.hudMirrorCanvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            super.dispatchDraw(this.hudMirrorCanvas);
            this.hudMirrorMatrix.setScale(1.0f, -1.0f);
            this.hudMirrorMatrix.postTranslate(0.0f, (float) this.mHeight);
            canvas.drawBitmap(this.hudMirrorBitmap, this.hudMirrorMatrix, this.hudMirrorPaint);
            return;
        }
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
        super.dispatchDraw(canvas);
    }

    public void recycleMirrorBitmap() {
        try {
            if (this.hudMirrorBitmap != null) {
                this.hudMirrorBitmap.recycle();
                this.hudMirrorBitmap = null;
            }
            this.hudMirrorCanvas = null;
            this.hudMirrorMatrix = null;
            this.hudMirrorPaint = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.mAMapHudView == null) {
                return true;
            }
            this.mAMapHudView.onTouchHudMirrorEvent(motionEvent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AutoNaviHudMirrorImage", "onTouchEvent(MotionEvent event)");
            return true;
        }
    }

    public void setAMapHudView(AMapHudView aMapHudView) {
        this.mAMapHudView = aMapHudView;
    }

    public boolean getMirrorState() {
        return this.mIsMirror;
    }

    public void setMirrorState(boolean z) {
        this.mIsMirror = z;
    }
}
