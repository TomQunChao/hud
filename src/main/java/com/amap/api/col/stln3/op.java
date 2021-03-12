package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: WeatherSearchHandler */
abstract class op<T, V> extends nd<T, V> {
    public op(Context context, T t) {
        super(context, t);
    }

    public final T e() {
        return (T) this.d;
    }

    @Override // com.amap.api.col.stln3.tw
    public String getURL() {
        return nk.a() + "/weather/weatherInfo?";
    }
}
