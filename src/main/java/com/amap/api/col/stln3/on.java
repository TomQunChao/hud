package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherForecastHandler */
public final class on extends op<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast i = new LocalWeatherForecast();

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nc
    public final /* synthetic */ Object a(String str) throws AMapException {
        this.i = nr.e(str);
        return this.i;
    }

    @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.op
    public final /* bridge */ /* synthetic */ String getURL() {
        return super.getURL();
    }

    public on(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.nd
    public final String d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.d).getCity();
        if (!nr.f(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + qy.f(this.g));
        return stringBuffer.toString();
    }
}
