package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.mp;
import com.amap.api.col.stln3.mq;
import com.amap.api.navi.view.NightMode;

public class StatusBarBatteryProgressView extends View implements NightMode {
    boolean isNight;
    private boolean mChargingBool;
    private boolean mNavigationBool;
    private Paint mPaint;
    private int mPercent;
    private RectF mRect;
    private int mRectRadius;
    private int mViewHeight;
    private int mViewWidth;

    public StatusBarBatteryProgressView(Context context) {
        this(context, null);
    }

    public StatusBarBatteryProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarBatteryProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = null;
        this.mPercent = -1;
        this.mChargingBool = false;
        this.mRectRadius = 0;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mRect = null;
        this.mNavigationBool = true;
        this.isNight = false;
        initView(context);
        this.mRect = new RectF();
    }

    private void initView(Context context) {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        int[] iArr = AnonymousClass1.a;
        getContext();
        if (iArr[mq.a().ordinal()] != 1) {
            this.mRectRadius = mj.a(context, 1);
        } else if (mj.d(getContext()) != 2) {
            this.mRectRadius = mj.a(context, 2);
        } else {
            this.mRectRadius = mj.a(context, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.navi.view.statusbar.StatusBarBatteryProgressView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[mp.values().length];

        static {
            try {
                a[mp.CUTOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[mp.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public void setNavigationBool(boolean z) {
        this.mNavigationBool = z;
    }

    /* access modifiers changed from: protected */
    public void initWidthHeight(int i) {
        Resources a = mm.a();
        int[] iArr = AnonymousClass1.a;
        getContext();
        if (iArr[mq.a().ordinal()] != 1) {
            this.mViewWidth = (a.getDimensionPixelSize(R.id.buttonPanel) - a.getDimensionPixelSize(R.id.beginning)) - a.getDimensionPixelSize(R.id.blocking);
            this.mViewHeight = a.getDimensionPixelSize(R.id.async);
        } else if (i != 2) {
            this.mViewWidth = (a.getDimensionPixelSize(R.id.add) - a.getDimensionPixelSize(R.id.all)) - a.getDimensionPixelSize(R.id.always);
            this.mViewHeight = a.getDimensionPixelSize(R.id.chains);
        } else {
            this.mViewWidth = (a.getDimensionPixelSize(R.id.buttonPanel) - a.getDimensionPixelSize(R.id.beginning)) - a.getDimensionPixelSize(R.id.blocking);
            this.mViewHeight = a.getDimensionPixelSize(R.id.async);
        }
        RectF rectF = this.mRect;
        if (rectF == null) {
            this.mRect = new RectF(0.0f, 0.0f, (float) this.mViewWidth, (float) this.mViewHeight);
        } else {
            rectF.set(0.0f, 0.0f, (float) this.mViewWidth, (float) this.mViewHeight);
        }
    }

    private void requestDraw(boolean z) {
        if (this.mPercent == -1) {
            this.mPercent = 0;
        }
        this.mPaint.setColor(getProgressColor(this.mPercent, this.mChargingBool, z));
        int[] iArr = AnonymousClass1.a;
        getContext();
        if (iArr[mq.a().ordinal()] != 1) {
            RectF rectF = this.mRect;
            int i = this.mViewWidth;
            rectF.left = (float) (i - ((int) ((((double) this.mPercent) / 100.0d) * ((double) i))));
        } else if (mj.d(getContext()) != 2) {
            this.mRect.right = (float) ((int) ((((double) this.mPercent) / 100.0d) * ((double) this.mViewWidth)));
        } else {
            RectF rectF2 = this.mRect;
            int i2 = this.mViewWidth;
            rectF2.left = (float) (i2 - ((int) ((((double) this.mPercent) / 100.0d) * ((double) i2))));
        }
        invalidate();
    }

    @Override // com.amap.api.navi.view.NightMode
    public void processNightMode(boolean z) {
        this.isNight = z;
        requestDraw(z);
    }

    public void setProgress(int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        int i2 = this.mPercent;
        if (i2 == -1 || z2 || i2 != i || this.mChargingBool != z) {
            this.mPercent = i;
            this.mChargingBool = z;
            if (this.mNavigationBool) {
                z3 = this.isNight;
            }
            requestDraw(z3);
        }
    }

    private int getProgressColor(int i, boolean z, boolean z2) {
        if (z) {
            return mm.a().getColor(R.dimen.abc_dropdownitem_text_padding_left);
        }
        if (i <= 20) {
            return mm.a().getColor(R.dimen.abc_disabled_alpha_material_light);
        }
        if (z2) {
            return mm.a().getColor(R.dimen.abc_dialog_padding_top_material);
        }
        return mm.a().getColor(R.dimen.abc_dialog_title_divider_material);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mRect.right != 0.0f && this.mRect.bottom != 0.0f) {
            RectF rectF = this.mRect;
            int i = this.mRectRadius;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.mPaint);
        }
    }
}
