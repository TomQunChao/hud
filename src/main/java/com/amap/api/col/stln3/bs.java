package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import org.json.JSONObject;

/* compiled from: H5LocationClient */
public final class bs {
    Object a = new Object();
    AMapLocationClientOption b = null;
    a c = null;
    private Context d;
    private AMapLocationClient e = null;
    private WebView f = null;
    private String g = "AMap.Geolocation.cbk";
    private volatile boolean h = false;

    static /* synthetic */ void a(bs bsVar, final String str) {
        try {
            if (bsVar.f == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView = bsVar.f;
                webView.evaluateJavascript("javascript:" + bsVar.g + "('" + str + "')", new ValueCallback<String>() {
                    /* class com.amap.api.col.stln3.bs.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                    }
                });
                return;
            }
            bsVar.f.post(new Runnable() {
                /* class com.amap.api.col.stln3.bs.AnonymousClass2 */

                public final void run() {
                    WebView webView = bs.this.f;
                    webView.loadUrl("javascript:" + bs.this.g + "('" + str + "')");
                }
            });
        } catch (Throwable th) {
            vu.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    public bs(Context context, WebView webView) {
        this.d = context.getApplicationContext();
        this.f = webView;
        this.c = new a();
    }

    public final void a() {
        if (this.f != null && this.d != null && Build.VERSION.SDK_INT >= 17 && !this.h) {
            try {
                this.f.getSettings().setJavaScriptEnabled(true);
                this.f.addJavascriptInterface(this, "AMapAndroidLoc");
                if (!TextUtils.isEmpty(this.f.getUrl())) {
                    this.f.reload();
                }
                if (this.e == null) {
                    this.e = new AMapLocationClient(this.d);
                    this.e.setLocationListener(this.c);
                }
                this.h = true;
            } catch (Throwable th) {
            }
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.h = false;
            if (this.e != null) {
                this.e.unRegisterLocationListener(this.c);
                this.e.stopLocation();
                this.e.onDestroy();
                this.e = null;
            }
            this.b = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A[Catch:{ Throwable -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069 A[Catch:{ Throwable -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0074 A[Catch:{ Throwable -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075 A[Catch:{ Throwable -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b A[Catch:{ Throwable -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getLocation(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bs.getLocation(java.lang.String):void");
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.h && (aMapLocationClient = this.e) != null) {
            aMapLocationClient.stopLocation();
        }
    }

    /* access modifiers changed from: private */
    public static String b(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        if (aMapLocation == null) {
            try {
                jSONObject.put(MyLocationStyle.ERROR_CODE, -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } catch (Throwable th) {
            }
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put(MyLocationStyle.ERROR_CODE, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", aMapLocation.getLongitude());
            jSONObject2.put("y", aMapLocation.getLatitude());
            jSONObject2.put("precision", (double) aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.getLocationType());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, aMapLocation.getCountry());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
            jSONObject2.put("cityCode", aMapLocation.getCityCode());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
            jSONObject2.put("adCode", aMapLocation.getAdCode());
            jSONObject2.put("street", aMapLocation.getStreet());
            jSONObject2.put("streetNum", aMapLocation.getStreetNum());
            jSONObject2.put("floor", aMapLocation.getFloor());
            jSONObject2.put("address", aMapLocation.getAddress());
            jSONObject.put("result", jSONObject2);
        } else {
            jSONObject.put(MyLocationStyle.ERROR_CODE, aMapLocation.getErrorCode());
            jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
        }
        return jSONObject.toString();
    }

    /* compiled from: H5LocationClient */
    class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (bs.this.h) {
                bs.a(bs.this, bs.b(aMapLocation));
            }
        }
    }
}
