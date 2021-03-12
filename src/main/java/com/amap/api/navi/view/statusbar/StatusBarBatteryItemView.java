package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.mp;
import com.amap.api.col.stln3.mq;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightMode;
import com.amap.api.navi.view.NightModeImageView;
import com.amap.api.navi.view.NightModeTextView;
import com.amap.api.navi.view.statusbar.StatusBarBatteryStateReceiver;

public class StatusBarBatteryItemView extends RelativeLayout implements NightMode, IStatusBarItemView, StatusBarBatteryStateReceiver.OnBatteryChangedCallback {
    private NightModeImageView mBatteryBgImg;
    private NightModeImageView mChargingImg;
    private int mPercent;
    private NightModeTextView mPercentTv;
    private StatusBarBatteryProgressView mProgressView;
    private int mStatus;
    StatusBarBatteryStateReceiver receiver;

    public StatusBarBatteryItemView(Context context) {
        this(context, null);
    }

    public StatusBarBatteryItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarBatteryItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPercentTv = null;
        this.mChargingImg = null;
        this.mBatteryBgImg = null;
        this.mProgressView = null;
        this.mStatus = -1;
        this.mPercent = -1;
        initView(context);
    }

    private void initView(Context context) {
        mm.a(context, R.layout.amap_navi_status_bar_battery, this);
        this.mPercentTv = (NightModeTextView) findViewById(R.id.status_bar_battery_progress_tv);
        this.mChargingImg = (NightModeImageView) findViewById(R.id.status_bar_battery_charging);
        this.mBatteryBgImg = (NightModeImageView) findViewById(R.id.status_bar_battery_bg);
        this.mProgressView = (StatusBarBatteryProgressView) findViewById(R.id.status_bar_battery_progress_view);
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void init() {
        StatusBarBatteryProgressView statusBarBatteryProgressView = this.mProgressView;
        if (statusBarBatteryProgressView != null) {
            statusBarBatteryProgressView.setNavigationBool(true);
        }
        this.receiver = new StatusBarBatteryStateReceiver();
        this.receiver.setOnBatteryChangedCallback(this);
        this.receiver.register(getContext());
        initBattery(getContext());
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void onDestroy() {
        StatusBarBatteryStateReceiver statusBarBatteryStateReceiver = this.receiver;
        if (statusBarBatteryStateReceiver != null) {
            statusBarBatteryStateReceiver.unRegister(getContext());
            this.receiver = null;
        }
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void reloadItemView(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        ViewGroup.LayoutParams layoutParams = this.mPercentTv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mBatteryBgImg.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        } else {
            marginLayoutParams2 = new ViewGroup.MarginLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mProgressView.getLayoutParams();
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        } else {
            marginLayoutParams3 = new ViewGroup.MarginLayoutParams(layoutParams3);
        }
        int[] iArr = AnonymousClass1.a;
        getContext();
        if (iArr[mq.a().ordinal()] != 1) {
            this.mChargingImg.setVisibility(8);
            this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_bg_day, R.drawable.status_bar_battery_bg_night);
            marginLayoutParams2.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.buttonPanel);
            marginLayoutParams2.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.adress);
            marginLayoutParams3.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.buttonPanel);
            marginLayoutParams3.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.async);
            marginLayoutParams3.setMargins(mm.a().getDimensionPixelSize(com.a11hud.www.R.id.beginning), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.bottom), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.blocking), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.barrier));
            marginLayoutParams.setMargins(mj.a(getContext(), 3), 0, 0, 0);
        } else if (mj.d(getContext()) != 2) {
            this.mChargingImg.setVisibility(8);
            this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_cutout_bg_day, R.drawable.status_bar_battery_cutout_bg_night);
            marginLayoutParams2.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.add);
            marginLayoutParams2.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.center_vertical);
            marginLayoutParams3.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.add);
            marginLayoutParams3.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.chains);
            marginLayoutParams3.setMargins(mm.a().getDimensionPixelSize(com.a11hud.www.R.id.all), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.amap_map_view), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.always), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.alertTitle));
            marginLayoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.mChargingImg.setVisibility(8);
            this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_bg_day, R.drawable.status_bar_battery_bg_night);
            marginLayoutParams2.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.buttonPanel);
            marginLayoutParams2.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.adress);
            marginLayoutParams3.width = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.buttonPanel);
            marginLayoutParams3.height = mm.a().getDimensionPixelSize(com.a11hud.www.R.id.async);
            marginLayoutParams3.setMargins(mm.a().getDimensionPixelSize(com.a11hud.www.R.id.beginning), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.bottom), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.blocking), mm.a().getDimensionPixelSize(com.a11hud.www.R.id.barrier));
            marginLayoutParams.setMargins(mj.a(getContext(), 3), 0, 0, 0);
        }
        this.mPercentTv.setLayoutParams(marginLayoutParams);
        this.mBatteryBgImg.setLayoutParams(marginLayoutParams2);
        this.mProgressView.setLayoutParams(marginLayoutParams3);
        this.mProgressView.initWidthHeight(i);
        int i2 = this.mStatus;
        if (i2 == 0) {
            batteryNormal(this.mPercent, i, true);
        } else if (i2 == 1) {
            batteryCharging(this.mPercent, i, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.navi.view.statusbar.StatusBarBatteryItemView$1  reason: invalid class name */
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

    private void initBattery(Context context) {
        setVisibility(8);
        this.mStatus = -1;
        this.mPercent = -1;
    }

    @Override // com.amap.api.navi.view.statusbar.StatusBarBatteryStateReceiver.OnBatteryChangedCallback
    public void onBatteryNormal(int i) {
        this.mStatus = 0;
        this.mPercent = i;
        batteryNormal(i, mj.d(getContext()), false);
    }

    private void batteryNormal(int i, int i2, boolean z) {
        if (this.mProgressView != null && this.mChargingImg != null && this.mPercentTv != null) {
            if (getVisibility() == 8) {
                setVisibility(0);
            }
            int[] iArr = AnonymousClass1.a;
            getContext();
            if (iArr[mq.a().ordinal()] != 1) {
                this.mChargingImg.setVisibility(8);
            } else if (i2 != 2) {
                this.mChargingImg.setVisibility(8);
                this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_cutout_bg_day, R.drawable.status_bar_battery_cutout_bg_night);
            } else {
                this.mChargingImg.setVisibility(8);
                this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_bg_day, R.drawable.status_bar_battery_bg_night);
            }
            NightModeTextView nightModeTextView = this.mPercentTv;
            nightModeTextView.setText(i + "%");
            this.mProgressView.setProgress(i, false, z);
        }
    }

    @Override // com.amap.api.navi.view.statusbar.StatusBarBatteryStateReceiver.OnBatteryChangedCallback
    public void onBatteryCharging(int i) {
        this.mStatus = 1;
        this.mPercent = i;
        batteryCharging(i, mj.d(getContext()), false);
    }

    private void batteryCharging(int i, int i2, boolean z) {
        if (this.mProgressView != null && this.mChargingImg != null && this.mPercentTv != null) {
            if (getVisibility() == 8) {
                setVisibility(0);
            }
            int[] iArr = AnonymousClass1.a;
            getContext();
            if (iArr[mq.a().ordinal()] != 1) {
                this.mChargingImg.setVisibility(0);
            } else if (i2 != 2) {
                this.mChargingImg.setVisibility(8);
                this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_cutout_charging_bg_day, R.drawable.status_bar_battery_cutout_charging_bg_night);
            } else {
                this.mChargingImg.setVisibility(0);
                this.mBatteryBgImg.setDayNightModeImageResource(R.drawable.status_bar_battery_bg_day, R.drawable.status_bar_battery_bg_night);
            }
            NightModeTextView nightModeTextView = this.mPercentTv;
            nightModeTextView.setText(i + "%");
            this.mProgressView.setProgress(i, true, z);
        }
    }

    public NightModeImageView getBatteryChargingImg() {
        return this.mChargingImg;
    }

    public NightModeImageView getBatteryBgImg() {
        return this.mBatteryBgImg;
    }

    public NightModeTextView getPercentTv() {
        return this.mPercentTv;
    }

    public StatusBarBatteryProgressView getBatteryProgressView() {
        return this.mProgressView;
    }

    @Override // com.amap.api.navi.view.NightMode
    public void processNightMode(boolean z) {
    }
}
