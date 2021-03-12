package com.amap.api.navi.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

public class NightModeTextView extends TextView implements NightMode {
    boolean current;
    Drawable dayModeBackGround;
    int dayModeSrc;
    Drawable nightModeBackGround;
    int nightModeSrc;

    public NightModeTextView(Context context) {
        this(context, null);
    }

    public NightModeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NightModeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayModeSrc = 0;
        this.nightModeSrc = 0;
        this.current = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NightModeTextView, i, 0);
        this.nightModeSrc = obtainStyledAttributes.getInt(1, mm.a().getColor(com.a11hud.www.R.dimen.abc_edit_text_inset_bottom_material));
        this.dayModeSrc = obtainStyledAttributes.getInt(0, mm.a().getColor(com.a11hud.www.R.dimen.abc_dropdownitem_text_padding_right));
        this.nightModeBackGround = obtainStyledAttributes.getDrawable(2);
        this.dayModeBackGround = obtainStyledAttributes.getDrawable(3);
        obtainStyledAttributes.recycle();
        processNightMode(this.current);
    }

    public void setDayNightModeTextColor(int i, int i2) {
        this.dayModeSrc = mm.a().getColor(i);
        this.nightModeSrc = mm.a().getColor(i2);
        processNightMode(this.current);
    }

    @Override // com.amap.api.navi.view.NightMode
    @TargetApi(16)
    public void processNightMode(boolean z) {
        this.current = z;
        if (z) {
            setTextColor(this.nightModeSrc);
            Drawable drawable = this.nightModeBackGround;
            if (drawable != null) {
                setBackground(drawable);
                return;
            }
            return;
        }
        setTextColor(this.dayModeSrc);
        Drawable drawable2 = this.dayModeBackGround;
        if (drawable2 != null) {
            setBackground(drawable2);
        }
    }
}
