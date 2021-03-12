package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: PoiHandler */
abstract class ny<T, V> extends nd<T, V> {
    public ny(Context context, T t) {
        super(context, t);
    }

    protected static boolean c(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return true;
        }
        return false;
    }
}
