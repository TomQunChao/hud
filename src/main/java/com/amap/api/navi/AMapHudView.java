package com.amap.api.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.rx;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviPath;
import com.amap.api.navi.view.AutoNaviHudMirrorImage;
import com.autonavi.ae.guide.model.NaviCongestionInfo;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.tbt.TrafficFacilityInfo;

public class AMapHudView extends FrameLayout implements View.OnClickListener, View.OnTouchListener, MyNaviListener {
    private static final long DELAY_MILLIS = 2000;
    static final int[] HUD_IMG_ACTIONS = {R.attr.contentInsetLeft, R.attr.contentInsetLeft, R.attr.contentInsetLeft, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.controlBackground, R.attr.coordinatorLayoutStyle, R.attr.customNavigationLayout, R.attr.defaultQueryHint, R.attr.dialogCornerRadius, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.commitIcon, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.content, R.attr.contentDescription, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions};
    AMapHudViewListener aMapHudVewListener;
    private AutoNaviHudMirrorImage autonaviHudMirrorImage;
    private Handler disappearHudHandler = new Handler();
    private Runnable disappearHudTitleRunnable = new Runnable() {
        /* class com.amap.api.navi.AMapHudView.AnonymousClass1 */

        public final void run() {
            try {
                AMapHudView.this.loadHideHudTitleAnimation();
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapHudView", "disappearHudTitleRunnable");
            }
        }
    };
    private String distanceTimeTextStr;
    private View frameLayout;
    private int hudMode = 1;
    private boolean isHudMenu = true;
    boolean isLandscape = false;
    private TextView limitSpeedTextView;
    private INavi mAMapNavi;
    private int mHeight = GLMapStaticValue.ANIMATION_MOVE_TIME;
    private View mHudMirrorTitle;
    private CheckBox mMirrorModeCheckBox;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        /* class com.amap.api.navi.AMapHudView.AnonymousClass2 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            try {
                if (AMapHudView.this.autonaviHudMirrorImage != null) {
                    if (z) {
                        AMapHudView.this.hudMode = 2;
                    } else {
                        AMapHudView.this.hudMode = 1;
                    }
                    AMapHudView.this.setCheckBoxAndMirrorImageState(z);
                    AMapHudView.this.removeCallbacks();
                    AMapHudView.this.disappearHudHandler.postDelayed(AMapHudView.this.disappearHudTitleRunnable, AMapHudView.DELAY_MILLIS);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapHudView", "mOnCheckedChangeListener");
            }
        }
    };
    private int mWidth = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    private SpannableString nextRoadDisTextSpannableStr = null;
    private TextView nextRoadDistanceText;
    private TextView nextRoadNameText;
    private String nextRoadNameTextStr;
    private int resId;
    private TextView restDistanceText;
    private String restDistanceTextStr;
    private TextView restDistanceTime;
    private ImageView roadsignimg;
    private View titleBtnGoBack;

    public AMapHudView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "AMapHudView(Context context, AttributeSet attrs, int defStyle) ");
        }
    }

    public AMapHudView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "AMapHudView(Context context, AttributeSet attrs) ");
        }
    }

    public AMapHudView(Context context) {
        super(context);
        init(context);
    }

    public int getHudViewMode() {
        return this.hudMode;
    }

    public void setHudViewMode(int i) {
        try {
            this.hudMode = i;
            setCheckBoxAndMirrorImageState(this.hudMode == 2);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "setHudViewMode(int mode)");
        }
    }

    public boolean getHudMenuEnabled() {
        return this.isHudMenu;
    }

    public void setHudMenuEnabled(Boolean bool) {
        this.isHudMenu = bool.booleanValue();
    }

    public final void onCreate(Bundle bundle) {
    }

    public final void onResume() {
    }

    public final void onPause() {
    }

    public final void onDestroy() {
        try {
            if (this.autonaviHudMirrorImage != null) {
                this.autonaviHudMirrorImage.recycleMirrorBitmap();
            }
            this.aMapHudVewListener = null;
            if (this.disappearHudHandler != null) {
                this.disappearHudHandler.removeCallbacksAndMessages(null);
                this.disappearHudHandler = null;
            }
            this.mAMapNavi.destroy();
            mm.c();
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onDestroy()");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
    }

    public void setHudViewListener(AMapHudViewListener aMapHudViewListener) {
        this.aMapHudVewListener = aMapHudViewListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[Catch:{ Throwable -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038 A[Catch:{ Throwable -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(android.content.Context r3) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.AMapHudView.init(android.content.Context):void");
    }

    private void initResolution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mWidth = displayMetrics.widthPixels;
        this.mHeight = displayMetrics.heightPixels;
    }

    public boolean onTouchHudMirrorEvent(MotionEvent motionEvent) {
        try {
            if (!this.isHudMenu) {
                return true;
            }
            loadShowHudTitleAnimation();
            removeCallbacks();
            this.disappearHudHandler.postDelayed(this.disappearHudTitleRunnable, DELAY_MILLIS);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onTouchHudMirrorEvent(MotionEvent event)");
            return true;
        }
    }

    private void loadShowHudTitleAnimation() {
        View view = this.mHudMirrorTitle;
        if (view != null && view.getVisibility() == 8) {
            Animation a = mm.a(getContext(), (int) R.color.abc_btn_colored_borderless_text_material);
            this.mHudMirrorTitle.setVisibility(0);
            this.mHudMirrorTitle.startAnimation(a);
        }
    }

    private void initWidget() {
        this.mHudMirrorTitle = this.frameLayout.findViewById(R.id.navi_sdk_hudmirrortitle);
        this.autonaviHudMirrorImage = (AutoNaviHudMirrorImage) this.frameLayout.findViewById(R.id.navi_sdk_autonaviHudMirrosImage);
        this.mMirrorModeCheckBox = (CheckBox) this.frameLayout.findViewById(R.id.navi_sdk_save);
        this.nextRoadNameText = (TextView) this.frameLayout.findViewById(R.id.navi_sdk_nextRoadNameText);
        this.restDistanceText = (TextView) this.frameLayout.findViewById(R.id.navi_sdk_restDistanceText);
        this.roadsignimg = (ImageView) this.frameLayout.findViewById(R.id.navi_sdk_roadsignimg);
        this.nextRoadDistanceText = (TextView) this.frameLayout.findViewById(R.id.navi_sdk_nextRoadDistanceText);
        this.titleBtnGoBack = this.frameLayout.findViewById(R.id.navi_sdk_title_btn_goback);
        this.restDistanceTime = (TextView) this.frameLayout.findViewById(R.id.navi_sdk_restDistanceTime);
        this.limitSpeedTextView = (TextView) this.frameLayout.findViewById(R.id.navi_sdk_limitSpeedTextView);
        getScreenInfo();
        setWidgetListener();
        updateHudWidgetContent();
    }

    private void getScreenInfo() {
        AutoNaviHudMirrorImage autoNaviHudMirrorImage = this.autonaviHudMirrorImage;
        if (autoNaviHudMirrorImage != null) {
            autoNaviHudMirrorImage.mWidth = this.mWidth;
            autoNaviHudMirrorImage.mHeight = this.mHeight - 50;
        }
    }

    private void updateHudWidgetContent() {
        int i;
        TextView textView = this.nextRoadNameText;
        if (textView != null) {
            textView.setText(this.nextRoadNameTextStr);
        }
        TextView textView2 = this.nextRoadDistanceText;
        if (textView2 != null) {
            textView2.setText(this.nextRoadDisTextSpannableStr);
        }
        TextView textView3 = this.restDistanceText;
        if (textView3 != null) {
            textView3.setText(this.restDistanceTextStr);
        }
        TextView textView4 = this.restDistanceTime;
        if (textView4 != null) {
            textView4.setText(this.distanceTimeTextStr);
        }
        if (this.roadsignimg != null && (i = this.resId) != 0 && i != 1) {
            this.roadsignimg.setBackgroundDrawable(mm.a().getDrawable(HUD_IMG_ACTIONS[this.resId]));
            AutoNaviHudMirrorImage autoNaviHudMirrorImage = this.autonaviHudMirrorImage;
            if (autoNaviHudMirrorImage != null) {
                autoNaviHudMirrorImage.invalidate();
                this.autonaviHudMirrorImage.postInvalidate();
            }
        }
    }

    private void setWidgetListener() {
        AutoNaviHudMirrorImage autoNaviHudMirrorImage = this.autonaviHudMirrorImage;
        if (autoNaviHudMirrorImage != null) {
            autoNaviHudMirrorImage.setAMapHudView(this);
            setOnTouchListener(this);
        }
        CheckBox checkBox = this.mMirrorModeCheckBox;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        }
        View view = this.titleBtnGoBack;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeCallbacks() {
        Runnable runnable;
        Handler handler = this.disappearHudHandler;
        if (handler != null && (runnable = this.disappearHudTitleRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCheckBoxAndMirrorImageState(boolean z) {
        CheckBox checkBox = this.mMirrorModeCheckBox;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
        AutoNaviHudMirrorImage autoNaviHudMirrorImage = this.autonaviHudMirrorImage;
        if (autoNaviHudMirrorImage != null) {
            autoNaviHudMirrorImage.setMirrorState(z);
            this.autonaviHudMirrorImage.invalidate();
            this.autonaviHudMirrorImage.postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadHideHudTitleAnimation() {
        View view = this.mHudMirrorTitle;
        if (view != null && view.getVisibility() == 0) {
            Animation a = mm.a(getContext(), (int) R.color.abc_btn_colored_text_material);
            a.setAnimationListener(new Animation.AnimationListener() {
                /* class com.amap.api.navi.AMapHudView.AnonymousClass3 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AMapHudView.this.mHudMirrorTitle.setVisibility(8);
                }
            });
            this.mHudMirrorTitle.startAnimation(a);
        }
    }

    private boolean isHudMirror() {
        return this.hudMode == 2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        try {
            if (this.autonaviHudMirrorImage != null) {
                this.autonaviHudMirrorImage.recycleMirrorBitmap();
                this.autonaviHudMirrorImage = null;
            }
            removeAllViews();
            if (getResources().getConfiguration().orientation == 2) {
                this.frameLayout = mm.a(getContext(), R.layout.amap_navi_api_hudlayout_land, null);
            } else {
                this.frameLayout = mm.a(getContext(), R.bool.abc_config_actionMenuItemAllCaps, null);
            }
            addView(this.frameLayout);
            initResolution();
            initWidget();
            getScreenInfo();
            onNaviInfoUpdate(this.mAMapNavi.getNaviInfo());
            setCheckBoxAndMirrorImageState(isHudMirror());
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onConfigurationChanged(Configuration newConfig)");
        }
        super.onConfigurationChanged(configuration);
    }

    private void updateHudUI(NaviInfo naviInfo) {
        if (naviInfo != null) {
            try {
                this.nextRoadNameTextStr = naviInfo.m_NextRoadName;
                this.restDistanceTextStr = mj.a(naviInfo.getPathRetainDistance());
                this.nextRoadDisTextSpannableStr = switchStrFromMeter(naviInfo.m_SegRemainDis);
                this.resId = naviInfo.m_Icon;
                this.distanceTimeTextStr = mj.b(naviInfo.m_RouteRemainTime);
                if (this.mAMapNavi.getNaviSetting().isMonitorCameraEnabled() && this.mAMapNavi.getEngineType() == 0 && this.limitSpeedTextView != null && naviInfo.m_CameraSpeed > 0) {
                    TextView textView = this.limitSpeedTextView;
                    StringBuilder sb = new StringBuilder();
                    sb.append(naviInfo.m_CameraSpeed);
                    textView.setText(sb.toString());
                    this.limitSpeedTextView.setVisibility(0);
                } else if (naviInfo.m_CameraSpeed == 0 && this.limitSpeedTextView != null) {
                    this.limitSpeedTextView.setVisibility(8);
                }
                updateHudWidgetContent();
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapHudView", "updateHudUI(NaviInfo naviInfo)");
            }
        }
    }

    private SpannableString switchStrFromMeter(int i) {
        if (i >= 1000) {
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(((float) Math.round((((float) i) / 1000.0f) * 10.0f)) / 10.0f);
            return getSpanableString(context, sb.toString(), "公里");
        }
        Context context2 = getContext();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        return getSpanableString(context2, sb2.toString(), "米");
    }

    private SpannableString getSpanableString(Context context, String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        int a = mj.a(context, 60);
        int a2 = mj.a(context, 30);
        int length = str.length();
        spannableString.setSpan(new AbsoluteSizeSpan(a), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, length, 33);
        int length2 = str2.length() + length;
        spannableString.setSpan(new AbsoluteSizeSpan(a2), length, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), length, length2, 33);
        return spannableString;
    }

    public void onClick(View view) {
        try {
            if (this.titleBtnGoBack == view && this.aMapHudVewListener != null) {
                this.aMapHudVewListener.onHudViewCancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onClick(View v)");
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            onTouchHudMirrorEvent(motionEvent);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onTouch(View arg0, MotionEvent arg1)");
            return false;
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onInitNaviFailure() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onInitNaviSuccess() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onStartNavi(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onTrafficStatusUpdate() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onGetNavigationText(int i, String str) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onGetNavigationText(String str) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onEndEmulatorNavi() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onArriveDestination() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onCalculateRouteFailure(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onReCalculateRouteForYaw() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onReCalculateRouteForTrafficJam() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onArrivedWayPoint(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onGpsOpenStatus(boolean z) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onNaviInfoUpdate(NaviInfo naviInfo) {
        try {
            updateHudUI(naviInfo);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapHudView", "onNaviInfoUpdate(NaviInfo naviinfo)");
        }
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void showCross(AMapNaviCross aMapNaviCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void hideCross() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void hideLaneInfo() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onCalculateRouteSuccess(int[] iArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void notifyParallelRoad(int i) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onPlayRing(int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void carProjectionChange(AmapCarLocation amapCarLocation) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void showModeCross(AMapModelCross aMapModelCross) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void hideModeCross() {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onGpsSignalWeak(boolean z) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo2, int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onStopNavi() {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override // com.amap.api.navi.AMapNaviListener
    public void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onUpdateTmcStatus(NaviCongestionInfo naviCongestionInfo) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onSelectRouteId(int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onChangeNaviPath(int i) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onDeletePath(long[] jArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void updateBackupPath(NaviPath[] naviPathArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onSelectMainPathStatus(long j) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onInnerNaviInfoUpdate(InnerNaviInfo[] innerNaviInfoArr) {
    }

    @Override // com.amap.api.navi.MyNaviListener
    public void onSuggestChangePath(long j, long j2, int i) {
    }
}
