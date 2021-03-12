package com.amap.api.col.stln3;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/* compiled from: ToastUtils */
public final class ma {
    private static Toast a;
    private static View b;

    public static void a(Context context, CharSequence charSequence) {
        if (context != null) {
            c(context.getApplicationContext(), charSequence);
        }
    }

    public static void b(Context context, CharSequence charSequence) {
        if (context != null) {
            c(context.getApplicationContext(), charSequence);
        }
    }

    private static void c(Context context, CharSequence charSequence) {
        try {
            if (a == null) {
                a = new Toast(context);
            }
            if (b == null) {
                b = Toast.makeText(context, "", 0).getView();
            }
            a.setView(b);
            a.setText(charSequence);
            a.setDuration(0);
            a.setGravity(17, 0, 0);
            a.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
