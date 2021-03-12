package com.amap.api.navi.view.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;
import com.amap.api.navi.view.NightModeTextView;
import com.amap.api.navi.view.statusbar.StatusBarTimeBroadcastReceiver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StatusBarTimeItemView extends NightModeTextView implements IStatusBarItemView, StatusBarTimeBroadcastReceiver.OnTimeChangeCallBack {
    private String mFormatAfternoon;
    private String mFormatBeforeDawn;
    private String mFormatEvening;
    private String mFormatForenoon;
    private String mFormatNoon;
    StatusBarTimeBroadcastReceiver receiver;

    public StatusBarTimeItemView(Context context) {
        this(context, null);
    }

    public StatusBarTimeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarTimeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.receiver = null;
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void init() {
        Resources a = mm.a();
        this.mFormatBeforeDawn = a.getString(R.string.status_bar_time_before_dawn);
        this.mFormatForenoon = a.getString(R.string.status_bar_time_forenoon);
        this.mFormatNoon = a.getString(R.string.status_bar_time_noon);
        this.mFormatAfternoon = a.getString(R.string.status_bar_time_after_noon);
        this.mFormatEvening = a.getString(R.string.status_bar_time_evening);
        this.receiver = StatusBarTimeBroadcastReceiver.getTimeBroadcastReceiver();
        this.receiver.addOnTimeChangeCallBack(this);
        setDayNightModeTextColor(com.a11hud.www.R.dimen.abc_dropdownitem_text_padding_right, com.a11hud.www.R.dimen.abc_edit_text_inset_bottom_material);
        setTextSize(0, (float) mm.a().getDimensionPixelSize(com.a11hud.www.R.id.checkbox));
        updateCurrentTime();
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void onDestroy() {
        this.receiver.removeOnTimeChangeCallBack(this);
    }

    @Override // com.amap.api.navi.view.statusbar.IStatusBarItemView
    public void reloadItemView(int i) {
    }

    public void updateCurrentTime() {
        String str;
        if (DateFormat.is24HourFormat(getContext())) {
            setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())));
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        int i = instance.get(9);
        int i2 = instance.get(10);
        int i3 = instance.get(12);
        if (i == 0) {
            if (i2 < 6) {
                str = this.mFormatBeforeDawn;
                if (i2 == 0) {
                    i2 = 12;
                }
            } else {
                str = this.mFormatForenoon;
            }
        } else if (i2 <= 0) {
            str = this.mFormatNoon;
            i2 = 12;
        } else {
            str = i2 < 6 ? this.mFormatAfternoon : this.mFormatEvening;
        }
        setText(getFormatTime(str, i2, i3));
    }

    private String getFormatTime(String str, int i, int i2) {
        Object obj;
        String str2 = str + "%s:%s";
        Object[] objArr = new Object[2];
        objArr[0] = String.valueOf(i);
        if (i2 < 10) {
            obj = "0" + i2;
        } else {
            obj = Integer.valueOf(i2);
        }
        objArr[1] = obj;
        return String.format(str2, objArr);
    }

    @Override // com.amap.api.navi.view.statusbar.StatusBarTimeBroadcastReceiver.OnTimeChangeCallBack
    public void onUpdate() {
        updateCurrentTime();
    }
}
