package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.mp;
import com.amap.api.col.stln3.mq;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightMode;
import com.amap.api.navi.view.NightModeImageView;
import com.amap.api.navi.view.NightModeTextView;
import java.util.ArrayList;
import java.util.List;

public class NavigationStatusBarView extends RelativeLayout implements NightMode {
    private StatusBarBatteryItemView mBatteryView;
    private StatusBarBluetoothItemView mBluetoothView;
    private StatusBarGpsItemView mGpsView;
    private LinearLayout mStatusBarLeftContainerView;
    private LinearLayout mStatusBarMidContainerView;
    private LinearLayout mStatusBarRightContainerView;
    private StatusBarTimeItemView mTimeView;
    private StatusBarVolumeItemView mVolumeView;

    public NavigationStatusBarView(Context context) {
        this(context, null);
    }

    public NavigationStatusBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationStatusBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatusBarMidContainerView = null;
        this.mStatusBarLeftContainerView = null;
        this.mStatusBarRightContainerView = null;
        this.mTimeView = null;
        this.mGpsView = null;
        this.mBluetoothView = null;
        this.mVolumeView = null;
        this.mBatteryView = null;
        createView(context);
    }

    private void createView(Context context) {
        setClickable(true);
        mm.a(context, R.layout.amap_navi_status_bar_container, this);
        this.mStatusBarLeftContainerView = (LinearLayout) findViewById(R.id.status_bar_left_container);
        this.mStatusBarMidContainerView = (LinearLayout) findViewById(R.id.status_bar_mid_container);
        this.mStatusBarRightContainerView = (LinearLayout) findViewById(R.id.status_bar_right_container);
        this.mTimeView = new StatusBarTimeItemView(getContext(), null, com.a11hud.www.R.drawable.abc_btn_radio_material);
        this.mGpsView = new StatusBarGpsItemView(context);
        this.mBluetoothView = new StatusBarBluetoothItemView(context);
        this.mVolumeView = new StatusBarVolumeItemView(context);
        this.mBatteryView = new StatusBarBatteryItemView(context);
    }

    public void layoutView(Context context, int i) {
        this.mStatusBarLeftContainerView.removeAllViews();
        this.mStatusBarMidContainerView.removeAllViews();
        this.mStatusBarRightContainerView.removeAllViews();
        addTimeView(context, i);
        addGpsView(context, i);
        addBluetoothView(context, i);
        addVolumeView(context, i);
        addBatteryView(context, i);
        this.mBatteryView.reloadItemView(i);
        this.mBluetoothView.reloadItemView(i);
        this.mTimeView.reloadItemView(i);
        this.mGpsView.reloadItemView(i);
        this.mVolumeView.reloadItemView(i);
    }

    private void addStatusBarMidItem(View view, LinearLayout.LayoutParams layoutParams) {
        LinearLayout linearLayout = this.mStatusBarMidContainerView;
        if (linearLayout != null && view != null && layoutParams != null) {
            linearLayout.addView(view, layoutParams);
        }
    }

    private void addStatusBarLeftItem(View view, LinearLayout.LayoutParams layoutParams) {
        LinearLayout linearLayout = this.mStatusBarLeftContainerView;
        if (linearLayout != null && view != null && layoutParams != null) {
            linearLayout.addView(view, layoutParams);
        }
    }

    private void addStatusBarRightItem(View view, LinearLayout.LayoutParams layoutParams) {
        LinearLayout linearLayout = this.mStatusBarRightContainerView;
        if (linearLayout != null && view != null && layoutParams != null) {
            linearLayout.addView(view, layoutParams);
        }
    }

    private void initItemView(IStatusBarItemView iStatusBarItemView) {
        if (iStatusBarItemView != null) {
            iStatusBarItemView.init();
        }
    }

    public void destroyItemView(IStatusBarItemView iStatusBarItemView) {
        if (iStatusBarItemView != null) {
            iStatusBarItemView.onDestroy();
        }
    }

    public void onCreate() {
        initItemView(this.mTimeView);
        initItemView(this.mBatteryView);
        StatusBarBluetoothItemView statusBarBluetoothItemView = this.mBluetoothView;
        if (statusBarBluetoothItemView != null) {
            initItemView(statusBarBluetoothItemView);
        }
        initItemView(this.mGpsView);
        initItemView(this.mVolumeView);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        destroyItemView(this.mTimeView);
        destroyItemView(this.mBatteryView);
        StatusBarBluetoothItemView statusBarBluetoothItemView = this.mBluetoothView;
        if (statusBarBluetoothItemView != null) {
            destroyItemView(statusBarBluetoothItemView);
        }
        destroyItemView(this.mGpsView);
        destroyItemView(this.mVolumeView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.navi.view.statusbar.NavigationStatusBarView$1  reason: invalid class name */
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

    private void addTimeView(Context context, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (AnonymousClass1.a[mq.a().ordinal()] != 1) {
            addStatusBarMidItem(this.mTimeView, layoutParams);
        } else if (i != 2) {
            layoutParams.leftMargin = mj.a(context, 10);
            addStatusBarLeftItem(this.mTimeView, layoutParams);
        } else {
            addStatusBarMidItem(this.mTimeView, layoutParams);
        }
    }

    private void addGpsView(Context context, int i) {
        if (AnonymousClass1.a[mq.a().ordinal()] != 1) {
            addStatusBarLeftItem(this.mGpsView, new LinearLayout.LayoutParams(mj.a(context, 28), mj.a(context, 14)));
        } else if (i != 2) {
            addStatusBarRightItem(this.mGpsView, new LinearLayout.LayoutParams(mj.a(context, 25), mj.a(context, 15)));
        } else {
            addStatusBarLeftItem(this.mGpsView, new LinearLayout.LayoutParams(mj.a(context, 28), mj.a(context, 14)));
        }
    }

    private void addBluetoothView(Context context, int i) {
        if (AnonymousClass1.a[mq.a().ordinal()] != 1) {
            addStatusBarRightItem(this.mBluetoothView, new LinearLayout.LayoutParams(mj.a(context, 10), mj.a(context, 14)));
        } else if (i == 2) {
            addStatusBarRightItem(this.mBluetoothView, new LinearLayout.LayoutParams(mj.a(context, 10), mj.a(context, 14)));
        }
    }

    private void addVolumeView(Context context, int i) {
        if (AnonymousClass1.a[mq.a().ordinal()] != 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mj.a(context, 15), mj.a(context, 14));
            layoutParams.leftMargin = mj.a(context, 10);
            addStatusBarRightItem(this.mVolumeView, layoutParams);
        } else if (i != 2) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(mj.a(context, 15), mj.a(context, 15));
            layoutParams2.leftMargin = mj.a(context, 4);
            addStatusBarLeftItem(this.mVolumeView, layoutParams2);
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(mj.a(context, 15), mj.a(context, 14));
            layoutParams3.leftMargin = mj.a(context, 10);
            addStatusBarRightItem(this.mVolumeView, layoutParams3);
        }
    }

    private void addBatteryView(Context context, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (AnonymousClass1.a[mq.a().ordinal()] != 1) {
            layoutParams.leftMargin = mj.a(context, 10);
        } else if (i != 2) {
            layoutParams.leftMargin = mj.a(context, 6);
            layoutParams.rightMargin = mj.a(context, 8);
        } else {
            layoutParams.leftMargin = mj.a(context, 10);
        }
        addStatusBarRightItem(this.mBatteryView, layoutParams);
    }

    public StatusBarVolumeItemView getVolumeView() {
        return this.mVolumeView;
    }

    public StatusBarBluetoothItemView getBluetoothView() {
        return this.mBluetoothView;
    }

    public StatusBarGpsItemView getGPSView() {
        return this.mGpsView;
    }

    public StatusBarTimeItemView getTimeView() {
        return this.mTimeView;
    }

    public StatusBarBatteryItemView getBatteryView() {
        return this.mBatteryView;
    }

    public NightModeImageView getBatteryChargingImg() {
        StatusBarBatteryItemView statusBarBatteryItemView = this.mBatteryView;
        if (statusBarBatteryItemView == null) {
            return null;
        }
        return statusBarBatteryItemView.getBatteryChargingImg();
    }

    public NightModeImageView getBatteryBgImg() {
        StatusBarBatteryItemView statusBarBatteryItemView = this.mBatteryView;
        if (statusBarBatteryItemView == null) {
            return null;
        }
        return statusBarBatteryItemView.getBatteryBgImg();
    }

    public NightModeTextView getBatteryPercentTv() {
        StatusBarBatteryItemView statusBarBatteryItemView = this.mBatteryView;
        if (statusBarBatteryItemView == null) {
            return null;
        }
        return statusBarBatteryItemView.getPercentTv();
    }

    public StatusBarBatteryProgressView getBatteryProgressView() {
        StatusBarBatteryItemView statusBarBatteryItemView = this.mBatteryView;
        if (statusBarBatteryItemView == null) {
            return null;
        }
        return statusBarBatteryItemView.getBatteryProgressView();
    }

    private List<NightMode> getNightModeWidgetList() {
        ArrayList arrayList = new ArrayList();
        addNightMode2List(arrayList, getGPSView());
        addNightMode2List(arrayList, getBluetoothView());
        addNightMode2List(arrayList, getVolumeView());
        addNightMode2List(arrayList, getTimeView());
        addNightMode2List(arrayList, getBatteryChargingImg());
        addNightMode2List(arrayList, getBatteryPercentTv());
        addNightMode2List(arrayList, getBatteryBgImg());
        addNightMode2List(arrayList, getBatteryProgressView());
        return arrayList;
    }

    private void addNightMode2List(List<NightMode> list, NightMode nightMode) {
        if (list != null && nightMode != null) {
            list.add(nightMode);
        }
    }

    @Override // com.amap.api.navi.view.NightMode
    public void processNightMode(boolean z) {
        List<NightMode> nightModeWidgetList = getNightModeWidgetList();
        for (int i = 0; i < nightModeWidgetList.size(); i++) {
            nightModeWidgetList.get(i).processNightMode(z);
        }
    }
}
