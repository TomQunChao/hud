package com.amap.api.col.stln3;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: BottomDialogBase */
abstract class mv extends Dialog {
    /* access modifiers changed from: protected */
    public abstract void a();

    public mv(Context context) {
        super(context);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            a();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }
}
