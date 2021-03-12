package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.model.AMapLaneInfo;
import com.autonavi.ae.guide.model.LaneInfo;

public class DriveWayView extends LinearLayout {
    private int[] driveWayBackgroundId;
    private int[] driveWayForegroundId;
    private int driveWayHeight;
    private int driveWaySize;
    private int driveWayWidth;
    LinearLayout.LayoutParams imgLp;
    LinearLayout.LayoutParams lp;
    private AMapNaviView mAMapNaviView;
    private int mItemLineWidth;

    public DriveWayView(Context context) {
        this(context, null);
    }

    public DriveWayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DriveWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.driveWayWidth = 0;
        this.driveWayHeight = 0;
        this.driveWaySize = 0;
        this.driveWayBackgroundId = new int[]{R.attr.tint, R.attr.tintMode, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor, R.attr.titleTextStyle, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.tooltipFrameBackground, R.attr.tooltipText, R.attr.track, R.attr.trackTint, R.attr.trackTintMode, R.attr.ttcIndex, R.attr.viewInflaterClass, R.attr.viewInflaterClass};
        this.driveWayForegroundId = new int[]{R.attr.voiceIcon, R.attr.windowActionBar, R.attr.title, R.attr.windowFixedHeightMinor, R.attr.titleMarginBottom, R.attr.windowMinWidthMinor, R.attr.titleMarginStart, R.attr.titleMarginTop, com.amap.api.navi.R.drawable.landfront_88, R.attr.titleTextAppearance, R.attr.titleTextColor, R.attr.titleTextStyle, R.attr.toolbarNavigationButtonStyle, com.amap.api.navi.R.drawable.landfront_dd, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.tooltipFrameBackground, R.attr.tooltipText, R.attr.track, R.attr.trackTint, R.attr.trackTintMode, com.amap.api.navi.R.drawable.landfront_kk, com.amap.api.navi.R.drawable.landfront_ll, com.amap.api.navi.R.drawable.landfront_ll};
        this.mAMapNaviView = null;
        this.lp = new LinearLayout.LayoutParams(-2, mj.a(context, 56));
        this.imgLp = new LinearLayout.LayoutParams(mj.a(context, 36), mj.a(context, 56));
        this.driveWayWidth = 0;
        this.driveWayHeight = 0;
        this.driveWaySize = 0;
        this.mItemLineWidth = mm.a().getDrawable(R.attr.tickMarkTintMode).getIntrinsicWidth();
        init(context);
    }

    public int getDriveWayWidth() {
        return this.driveWayWidth;
    }

    public void setAMapNaviView(AMapNaviView aMapNaviView) {
        this.mAMapNaviView = aMapNaviView;
    }

    public void loadDriveWayBitmap(byte[] bArr, byte[] bArr2) {
        try {
            removeAllViews();
            this.driveWaySize = parseDriveWaySize(bArr);
            if (this.driveWaySize != 0) {
                for (int i = 0; i < this.driveWaySize; i++) {
                    buildDriveWay(bArr[i], bArr2[i], i, this.driveWaySize);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void loadDriveWayBitmap(AMapLaneInfo aMapLaneInfo) {
        try {
            removeAllViews();
            this.driveWaySize = aMapLaneInfo.laneCount;
            if (this.driveWaySize != 0) {
                for (int i = 0; i < this.driveWaySize; i++) {
                    buildDriveWay(aMapLaneInfo.backgroundLane[i], aMapLaneInfo.frontLane[i], i, this.driveWaySize);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void loadDriveWayBitmap(LaneInfo laneInfo) {
        try {
            removeAllViews();
            this.driveWaySize = laneInfo.laneCount;
            if (this.driveWaySize != 0) {
                for (int i = 0; i < this.driveWaySize; i++) {
                    buildDriveWay(laneInfo.backLane[i], laneInfo.frontLane[i], i, this.driveWaySize);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private int parseDriveWaySize(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & 255) == 255) {
                return i;
            }
        }
        return 0;
    }

    private boolean isThisLaneRecommended(int i) {
        return i != 255;
    }

    private boolean isComplexLane(int i) {
        return i == 14 || i == 2 || i == 4 || i == 9 || i == 10 || i == 11 || i == 12 || i == 6 || i == 7 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20;
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int complexBitmap(int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 292
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.DriveWayView.complexBitmap(int, int):int");
    }

    public void setDefaultTopMargin(int i) {
        int i2;
        try {
            if (this.mAMapNaviView != null) {
                if (!this.mAMapNaviView.isOrientationLandscape()) {
                    if (this.mAMapNaviView.isShowRoadEnlarge()) {
                        i2 = ((i * 3) / 8) - (this.driveWayHeight >> 1);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                        layoutParams.setMargins(0, i2, 0, 0);
                        setLayoutParams(layoutParams);
                    }
                }
                i2 = i + 10;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams2.setMargins(0, i2, 0, 0);
                setLayoutParams(layoutParams2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void buildDriveWay(int i, int i2, int i3, int i4) {
        int i5;
        if (i4 == 1) {
            i5 = com.amap.api.navi.R.drawable.navi_lane_shape_bg_over;
        } else if (i4 > 1 && i3 == 0) {
            i5 = com.amap.api.navi.R.drawable.navi_lane_shape_bg_left;
        } else if (i4 <= 1 || i3 != i4 - 1) {
            i5 = com.amap.api.navi.R.drawable.navi_lane_shape_bg_center;
        } else {
            i5 = com.amap.api.navi.R.drawable.navi_lane_shape_bg_right;
        }
        if (isComplexLane(i)) {
            addView(createImageView(complexBitmap(i, i2), i5), this.imgLp);
        } else if (isThisLaneRecommended(i2)) {
            addView(createImageView(this.driveWayForegroundId[i2], i5), this.imgLp);
        } else {
            addView(createImageView(this.driveWayBackgroundId[i], i5), this.imgLp);
        }
        if (i4 > 1 && i3 < i4 - 1) {
            addView(createLine(), this.lp);
        }
    }

    private View createImageView(int i, int i2) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(BitmapFactory.decodeResource(mm.a(), i));
        imageView.setBackgroundDrawable(mm.a().getDrawable(i2));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    private void init(Context context) {
        this.lp.gravity = 16;
        this.imgLp.gravity = 17;
        this.driveWayWidth = mj.a(context, 36);
        this.driveWayHeight = mj.a(context, 56);
        setGravity(1);
    }

    private View createLine() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.tickMarkTintMode));
        imageView.setBackgroundColor(mm.a().getColor(R.dimen.abc_text_size_body_1_material));
        return imageView;
    }

    public int getDriveWaySize() {
        return this.driveWaySize;
    }

    public int getDriveWayBgHeight() {
        return this.driveWayHeight;
    }

    public int getDriveWaysWidth() {
        int i = this.driveWayWidth;
        int i2 = this.driveWaySize;
        return (i * i2) + ((i2 - 1) * this.mItemLineWidth);
    }
}
