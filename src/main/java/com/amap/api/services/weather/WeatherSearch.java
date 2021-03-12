package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.pe;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.interfaces.IWeatherSearch;

public class WeatherSearch {
    private IWeatherSearch a = null;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i);
    }

    public WeatherSearch(Context context) {
        try {
            this.a = (IWeatherSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.WeatherSearchWrapper", pe.class, new Class[]{Context.class}, new Object[]{context});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new pe(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }
}
