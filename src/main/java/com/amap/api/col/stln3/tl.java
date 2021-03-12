package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: SPUtil */
public final class tl {
    private String a;

    public tl(String str) {
        this.a = rg.b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public final void a(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(this.a, 0).edit();
            edit.putBoolean(str, z);
            if (edit == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable th) {
        }
    }

    public final boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        try {
            return context.getSharedPreferences(this.a, 0).getBoolean(str, true);
        } catch (Throwable th) {
            return true;
        }
    }
}
