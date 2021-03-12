package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightModeImageView;

public class StatusBarBluetoothItemView extends NightModeImageView implements IStatusBarItemView {
    public StatusBarBluetoothItemView(Context context) {
        this(context, null);
    }

    public StatusBarBluetoothItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarBluetoothItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void updateBluetoothState(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void init() {
        setDayNightModeImageResource(R.drawable.status_bar_bluetooth_day, R.drawable.status_bar_bluetooth_night);
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void onDestroy() {
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void reloadItemView(int i) {
        updateBluetoothState(false);
    }
}
