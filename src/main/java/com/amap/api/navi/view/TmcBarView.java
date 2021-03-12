package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.amap.api.col.stln3.kp;
import com.amap.api.navi.model.AMapTrafficStatus;
import java.util.List;

public class TmcBarView extends View {
    private static final int DISTANCE_MAX = 50000;
    private static final int DISTANCE_MID = 5000;
    private static final int DISTANCE_MIN = 10;
    private int jamTrafficColor;
    private float mCursorPos;
    float mCursorRatio;
    ImageView mDefaultTmcBarCarView;
    private Paint mPaint;
    private Path mPath;
    private int mPathHeight;
    private int mRouteTotalLength;
    private final TmcTag mTagCache;
    private List<AMapTrafficStatus> mTmcBarItems;
    private TmcBarListener mTmcBarListener;
    private float[] radiusArray;
    private int slowTrafficColor;
    private int smoothTrafficColor;
    private int unknownTrafficColor;
    private int veryJamTrafficColor;

    public interface TmcBarListener {
        void dismissBottomTag();

        void showBottomTag(TmcTag tmcTag);
    }

    public static class TmcTag {
        public int bgResId;
        public int index;
        public int roadLength;
        public int status;
        public int textColor;
        public int translationY;
        public float viewHeight;
    }

    public TmcBarView(Context context) {
        super(context);
        this.mTagCache = new TmcTag();
        this.mPath = new Path();
        this.radiusArray = new float[8];
        this.mDefaultTmcBarCarView = null;
        this.mCursorRatio = 1.0f;
        init();
    }

    public TmcBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTagCache = new TmcTag();
        this.mPath = new Path();
        this.radiusArray = new float[8];
        this.mDefaultTmcBarCarView = null;
        this.mCursorRatio = 1.0f;
        init();
    }

    public TmcBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTagCache = new TmcTag();
        this.mPath = new Path();
        this.radiusArray = new float[8];
        this.mDefaultTmcBarCarView = null;
        this.mCursorRatio = 1.0f;
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public void setData(List<AMapTrafficStatus> list, int i) {
        this.mTmcBarItems = list;
        this.mRouteTotalLength = i;
    }

    public void setCarView(ImageView imageView) {
        this.mDefaultTmcBarCarView = imageView;
    }

    public void setCursorPos(int i) {
        this.mCursorRatio = (((float) i) * 1.0f) / (((float) this.mRouteTotalLength) * 1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            int width = getWidth();
            int height = getHeight();
            if (this.mCursorRatio > 1.0f) {
                this.mCursorRatio = 1.0f;
            }
            float f = (float) height;
            this.mCursorPos = this.mCursorRatio * f;
            if (this.mDefaultTmcBarCarView != null) {
                this.mDefaultTmcBarCarView.setTranslationY(this.mCursorPos);
                this.mDefaultTmcBarCarView.invalidate();
            }
            if (this.mTmcBarItems != null && height > 0) {
                if (this.mPathHeight != height) {
                    this.mPath.reset();
                    for (int i = 0; i < this.radiusArray.length; i++) {
                        this.radiusArray[i] = ((float) width) / 2.0f;
                    }
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, (float) width, f), this.radiusArray, Path.Direction.CW);
                    this.mPathHeight = height;
                }
                canvas.save();
                canvas.clipPath(this.mPath);
                int size = this.mTmcBarItems.size();
                float f2 = (f * 1.0f) / (((float) this.mRouteTotalLength) * 1.0f);
                float f3 = 0.0f;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    AMapTrafficStatus aMapTrafficStatus = this.mTmcBarItems.get(i2);
                    float round = ((float) Math.round(((float) aMapTrafficStatus.getLength()) * f2 * 100.0f)) * 0.01f;
                    f3 += round;
                    canvas.drawRect(0.0f, f3 - round, (float) width, f3, getPaintInColor(getColor(aMapTrafficStatus.getStatus())));
                }
                if (f3 < f) {
                    canvas.drawRect(0.0f, f3, (float) width, f, getPaintInColor(getColor(this.mTmcBarItems.get(0).getStatus())));
                }
                if (f > this.mCursorPos) {
                    canvas.drawRect(0.0f, this.mCursorPos, (float) width, f, getPaintInColor(getColor(-1)));
                }
                if (this.mTmcBarListener != null) {
                    this.mTmcBarListener.dismissBottomTag();
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Paint getPaintInColor(int i) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
        this.mPaint.setColor(i);
        return this.mPaint;
    }

    public void setUnknownTrafficColor(int i) {
        this.unknownTrafficColor = i;
    }

    public void setSmoothTrafficColor(int i) {
        this.smoothTrafficColor = i;
    }

    public void setSlowTrafficColor(int i) {
        this.slowTrafficColor = i;
    }

    public void setJamTrafficColor(int i) {
        this.jamTrafficColor = i;
    }

    public void setVeryJamTrafficColor(int i) {
        this.veryJamTrafficColor = i;
    }

    private int getColor(int i) {
        switch (i) {
            case 0:
                int i2 = this.unknownTrafficColor;
                if (i2 != 0) {
                    return i2;
                }
                return Color.rgb(kp.UNKNOWN.a(), kp.UNKNOWN.b(), kp.UNKNOWN.c());
            case 1:
                int i3 = this.smoothTrafficColor;
                if (i3 != 0) {
                    return i3;
                }
                return Color.rgb(kp.UNBLOCK.a(), kp.UNBLOCK.b(), kp.UNBLOCK.c());
            case 2:
                int i4 = this.slowTrafficColor;
                if (i4 != 0) {
                    return i4;
                }
                return Color.rgb(kp.SLOW.a(), kp.SLOW.b(), kp.SLOW.c());
            case 3:
                int i5 = this.jamTrafficColor;
                if (i5 != 0) {
                    return i5;
                }
                return Color.rgb(kp.BLOCK.a(), kp.BLOCK.b(), kp.BLOCK.c());
            case 4:
                int i6 = this.veryJamTrafficColor;
                if (i6 != 0) {
                    return i6;
                }
                return Color.rgb(kp.GRIDLOCKED.a(), kp.GRIDLOCKED.b(), kp.GRIDLOCKED.c());
            default:
                return Color.rgb(kp.NOTRAFFIC.a(), kp.NOTRAFFIC.b(), kp.NOTRAFFIC.c());
        }
    }

    public void setTacBarListener(TmcBarListener tmcBarListener) {
        this.mTmcBarListener = tmcBarListener;
    }
}
