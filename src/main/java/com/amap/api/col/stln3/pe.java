package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherSearchCore */
public class pe implements IWeatherSearch {
    private Context a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f = null;

    static /* synthetic */ LocalWeatherLiveResult b(pe peVar) throws AMapException {
        ns.a(peVar.a);
        WeatherSearchQuery weatherSearchQuery = peVar.b;
        if (weatherSearchQuery != null) {
            oo ooVar = new oo(peVar.a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) ooVar.e(), (LocalWeatherLive) ooVar.a());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    static /* synthetic */ LocalWeatherForecastResult f(pe peVar) throws AMapException {
        ns.a(peVar.a);
        WeatherSearchQuery weatherSearchQuery = peVar.b;
        if (weatherSearchQuery != null) {
            on onVar = new on(peVar.a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) onVar.e(), (LocalWeatherForecast) onVar.a());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public pe(Context context) {
        this.a = context.getApplicationContext();
        this.f = nu.a();
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void searchWeatherAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pe.AnonymousClass1 */

                public final void run() {
                    nu.k kVar;
                    nu.l lVar;
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (pe.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            nl.a(e, "WeatherSearch", "searchWeatherAsyn");
                        }
                    } else if (pe.this.b.getType() == 1) {
                        try {
                            pe.this.d = pe.b(pe.this);
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            lVar = new nu.l();
                        } catch (AMapException e2) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e2.getErrorCode());
                            nl.a(e2, "WeatherSearch", "searchWeatherAsyn");
                            lVar = new nu.l();
                        } catch (Throwable th) {
                            nu.l lVar2 = new nu.l();
                            obtainMessage.what = 1301;
                            lVar2.b = pe.this.c;
                            lVar2.a = pe.this.d;
                            obtainMessage.obj = lVar2;
                            obtainMessage.setData(bundle);
                            pe.this.f.sendMessage(obtainMessage);
                            throw th;
                        }
                        obtainMessage.what = 1301;
                        lVar.b = pe.this.c;
                        lVar.a = pe.this.d;
                        obtainMessage.obj = lVar;
                        obtainMessage.setData(bundle);
                        pe.this.f.sendMessage(obtainMessage);
                    } else if (pe.this.b.getType() == 2) {
                        try {
                            pe.this.e = pe.f(pe.this);
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            kVar = new nu.k();
                        } catch (AMapException e3) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e3.getErrorCode());
                            nl.a(e3, "WeatherSearch", "searchWeatherAsyn");
                            kVar = new nu.k();
                        } catch (Throwable th2) {
                            nu.k kVar2 = new nu.k();
                            obtainMessage.what = 1302;
                            kVar2.b = pe.this.c;
                            kVar2.a = pe.this.e;
                            obtainMessage.obj = kVar2;
                            obtainMessage.setData(bundle);
                            pe.this.f.sendMessage(obtainMessage);
                            throw th2;
                        }
                        obtainMessage.what = 1302;
                        kVar.b = pe.this.c;
                        kVar.a = pe.this.e;
                        obtainMessage.obj = kVar;
                        obtainMessage.setData(bundle);
                        pe.this.f.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }
}
