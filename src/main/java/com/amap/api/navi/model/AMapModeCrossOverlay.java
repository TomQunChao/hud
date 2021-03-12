package com.amap.api.navi.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;
import java.io.InputStream;

public class AMapModeCrossOverlay {
    private GLCrossVector.AVectorCrossAttr attr;
    private CrossOverlay crossOverlay;
    boolean dayMode = true;
    a handler = null;
    CrossOverlay.GenerateCrossImageListener imageListener = new CrossOverlay.GenerateCrossImageListener() {
        /* class com.amap.api.navi.model.AMapModeCrossOverlay.AnonymousClass1 */

        @Override // com.amap.api.maps.model.CrossOverlay.GenerateCrossImageListener
        public final void onGenerateComplete(Bitmap bitmap, int i) {
            if (bitmap != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.obj = bitmap;
                    obtain.arg1 = i;
                    if (AMapModeCrossOverlay.this.handler != null) {
                        AMapModeCrossOverlay.this.handler.sendMessage(obtain);
                    }
                    if (AMapModeCrossOverlay.this.crossOverlay != null) {
                        AMapModeCrossOverlay.this.crossOverlay.remove();
                        AMapModeCrossOverlay.this.crossOverlay = null;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private AMap mAMap;
    private Context mContext;
    OnCreateBitmapFinish mCrossImageListener = null;
    int nHeight = 500;
    int nWidth = 1080;

    public interface OnCreateBitmapFinish {
        void onGenerateComplete(Bitmap bitmap, int i);
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int i) {
        this.nWidth = i;
        GLCrossVector.AVectorCrossAttr aVectorCrossAttr = this.attr;
        if (aVectorCrossAttr != null) {
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, i, this.nHeight);
        }
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setHeight(int i) {
        this.nHeight = i;
        GLCrossVector.AVectorCrossAttr aVectorCrossAttr = this.attr;
        if (aVectorCrossAttr != null) {
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, this.nWidth, i);
        }
    }

    public boolean isDayMode() {
        return this.dayMode;
    }

    public void setDayMode(boolean z) {
        this.dayMode = z;
        GLCrossVector.AVectorCrossAttr aVectorCrossAttr = this.attr;
        if (aVectorCrossAttr != null) {
            aVectorCrossAttr.dayMode = z;
        }
    }

    public AMapModeCrossOverlay(Context context, AMap aMap) {
        this.mAMap = aMap;
        this.mContext = context;
        if (context != null && aMap != null) {
            if (this.attr == null) {
                this.attr = new GLCrossVector.AVectorCrossAttr();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.nWidth = displayMetrics.widthPixels;
            this.nHeight = (this.nWidth * 6) / 11;
            this.handler = new a(context.getMainLooper());
            this.attr.stAreaRect = new Rect(0, 0, this.nWidth, this.nHeight);
            this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
            GLCrossVector.AVectorCrossAttr aVectorCrossAttr = this.attr;
            aVectorCrossAttr.fArrowBorderWidth = 22;
            aVectorCrossAttr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            GLCrossVector.AVectorCrossAttr aVectorCrossAttr2 = this.attr;
            aVectorCrossAttr2.fArrowLineWidth = 18;
            aVectorCrossAttr2.stArrowLineColor = Color.argb(255, 255, 253, 65);
            this.attr.dayMode = this.dayMode;
        }
    }

    public void showCrossOverlay(byte[] bArr) {
        if (bArr != null) {
            try {
                InputStream open = this.mContext.getAssets().open("amap_navi_vector3d_arrow_in.png");
                CrossOverlayOptions crossOverlayOptions = new CrossOverlayOptions();
                if (this.attr != null) {
                    crossOverlayOptions.setAttribute(this.attr);
                }
                if (open != null) {
                    crossOverlayOptions.setRes(BitmapFactory.decodeStream(open));
                }
                this.crossOverlay = this.mAMap.addCrossOverlay(crossOverlayOptions);
                this.crossOverlay.setData(bArr);
                this.crossOverlay.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void hideCrossOverlay() {
        CrossOverlay crossOverlay2 = this.crossOverlay;
        if (crossOverlay2 != null) {
            crossOverlay2.remove();
        }
    }

    public void setCrossOverlayLocation(Rect rect) {
        GLCrossVector.AVectorCrossAttr aVectorCrossAttr = this.attr;
        if (aVectorCrossAttr != null) {
            aVectorCrossAttr.stAreaRect = rect;
        }
    }

    private int dp2px(int i) {
        Context context = this.mContext;
        if (i == 0) {
            return 0;
        }
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviView", "dp2px(int dipValue)");
            return i;
        }
    }

    public void createModelCrossBitMap(byte[] bArr, OnCreateBitmapFinish onCreateBitmapFinish) {
        if (onCreateBitmapFinish != null) {
            this.mCrossImageListener = onCreateBitmapFinish;
        }
        try {
            GLCrossVector.AVectorCrossAttr aVectorCrossAttr = new GLCrossVector.AVectorCrossAttr();
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, this.nWidth, this.nHeight);
            aVectorCrossAttr.stAreaColor = Color.argb(217, 95, 95, 95);
            aVectorCrossAttr.fArrowBorderWidth = dp2px(22);
            aVectorCrossAttr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            aVectorCrossAttr.fArrowLineWidth = dp2px(18);
            aVectorCrossAttr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            aVectorCrossAttr.fArrowLineWidth = 18;
            aVectorCrossAttr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            aVectorCrossAttr.dayMode = this.dayMode;
            InputStream open = this.mContext.getAssets().open("amap_navi_vector3d_arrow_in.png");
            if (this.crossOverlay != null) {
                this.crossOverlay.remove();
                this.crossOverlay = null;
            }
            this.crossOverlay = this.mAMap.addCrossOverlay(new CrossOverlayOptions().setAttribute(aVectorCrossAttr).setRes(BitmapFactory.decodeStream(open)));
            this.crossOverlay.setImageMode(true);
            this.crossOverlay.setGenerateCrossImageListener(this.imageListener);
            this.crossOverlay.setData(bArr);
            this.crossOverlay.setVisible(true);
            open.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                Bitmap bitmap = (Bitmap) message.obj;
                int i = message.arg1;
                if (AMapModeCrossOverlay.this.mCrossImageListener != null) {
                    AMapModeCrossOverlay.this.mCrossImageListener.onGenerateComplete(bitmap, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.handleMessage(message);
        }
    }
}
