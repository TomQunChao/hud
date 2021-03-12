package com.amap.api.navi.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

public class NightModeImageView extends ImageView implements NightMode {
    boolean current;
    Drawable dayModeBackGround;
    Drawable dayModeSrc;
    Drawable nightModeBackGround;
    Drawable nightModeSrc;

    public NightModeImageView(Context context) {
        this(context, null);
    }

    public NightModeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NightModeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.current = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NightModeImageView, i, 0);
        this.nightModeSrc = obtainStyledAttributes.getDrawable(1);
        this.dayModeSrc = obtainStyledAttributes.getDrawable(0);
        this.dayModeBackGround = obtainStyledAttributes.getDrawable(2);
        this.nightModeBackGround = obtainStyledAttributes.getDrawable(3);
        processNightMode(this.current);
        obtainStyledAttributes.recycle();
    }

    public void setDayNightModeImageResource(int i, int i2) {
        this.dayModeSrc = mm.a().getDrawable(i);
        this.nightModeSrc = mm.a().getDrawable(i2);
        processNightMode(this.current);
    }

    @Override // com.amap.api.navi.view.NightMode
    @TargetApi(16)
    public void processNightMode(boolean z) {
        this.current = z;
        if (z) {
            Drawable drawable = this.nightModeSrc;
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            Drawable drawable2 = this.dayModeBackGround;
            if (drawable2 != null) {
                setBackground(drawable2);
                return;
            }
            return;
        }
        Drawable drawable3 = this.dayModeSrc;
        if (drawable3 != null) {
            setImageDrawable(drawable3);
        }
        Drawable drawable4 = this.nightModeBackGround;
        if (drawable4 != null) {
            setBackground(drawable4);
        }
    }
}
