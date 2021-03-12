package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.amap.api.col.stln3.bo;
import com.amap.api.col.stln3.rj;
import com.amap.api.col.stln3.rk;
import com.amap.api.col.stln3.sk;
import com.amap.api.col.stln3.vu;
import com.amap.api.col.stln3.wa;

public class AMapLocationClient {
    Context a;
    LocationManagerBase b;

    public AMapLocationClient(Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = a(this.a, null);
            } catch (Throwable th) {
                vu.a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = a(this.a, intent);
            } catch (Throwable th) {
                vu.a(th, "AMapLocationClient", "AMapLocationClient 2");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    private static LocationManagerBase a(Context context, Intent intent) {
        LocationManagerBase locationManagerBase;
        try {
            rj b2 = vu.b();
            wa.a(context, b2);
            boolean c = wa.c(context);
            wa.a(context);
            if (c) {
                locationManagerBase = (LocationManagerBase) sk.a(context, b2, rk.c("IY29tLmFtYXAuYXBpLmxvY2F0aW9uLkxvY2F0aW9uTWFuYWdlcldyYXBwZXI="), bo.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
            } else {
                locationManagerBase = new bo(context, intent);
            }
        } catch (Throwable th) {
            locationManagerBase = new bo(context, intent);
        }
        if (locationManagerBase == null) {
            return new bo(context, intent);
        }
        return locationManagerBase;
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption != null) {
            try {
                if (this.b != null) {
                    this.b.setLocationOption(aMapLocationClientOption);
                }
            } catch (Throwable th) {
                vu.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                if (this.b != null) {
                    this.b.setLocationListener(aMapLocationListener);
                }
            } catch (Throwable th) {
                vu.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public void startLocation() {
        try {
            if (this.b != null) {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopLocation() {
        try {
            if (this.b != null) {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.b != null) {
                return this.b.getLastKnownLocation();
            }
            return null;
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "getLastKnownLocation");
            return null;
        }
    }

    public void startAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation();
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation(webView);
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "startAssistantLocation1");
        }
    }

    public void stopAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.stopAssistantLocation();
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public String getVersion() {
        return "4.5.0";
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "setApiKey");
        }
    }

    public boolean isStarted() {
        try {
            if (this.b != null) {
                return this.b.isStarted();
            }
            return false;
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "isStarted");
            return false;
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (this.b != null) {
                this.b.unRegisterLocationListener(aMapLocationListener);
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }

    public void onDestroy() {
        try {
            if (this.b != null) {
                this.b.onDestroy();
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            if (this.b != null) {
                this.b.enableBackgroundLocation(i, notification);
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "enableBackgroundLocation");
        }
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            if (this.b != null) {
                this.b.disableBackgroundLocation(z);
            }
        } catch (Throwable th) {
            vu.a(th, "AMapLocationClient", "disableBackgroundLocation");
        }
    }
}
