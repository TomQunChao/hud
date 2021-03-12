package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.stln3.dz;
import com.amap.api.col.stln3.ea;
import com.amap.api.col.stln3.ee;
import com.amap.api.col.stln3.ic;
import com.amap.api.col.stln3.rf;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager {
    ee a;
    ea b;
    private Context c;
    private OfflineMapDownloadListener d;
    private OfflineLoadedListener e;
    private Handler f = new Handler(this.c.getMainLooper());
    private Handler g = new Handler(this.c.getMainLooper());

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        a(context);
        rf.a().a(this.c);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context) {
        this.c = context.getApplicationContext();
        ea.b = false;
        this.b = ea.a(this.c);
        this.b.a(new ea.a() {
            /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1 */

            @Override // com.amap.api.col.stln3.ea.a
            public final void a(final dz dzVar) {
                if (OfflineMapManager.this.d != null && dzVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            try {
                                OfflineMapManager.this.d.onDownload(dzVar.c().b(), dzVar.getcompleteCode(), dzVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override // com.amap.api.col.stln3.ea.a
            public final void b(final dz dzVar) {
                if (OfflineMapManager.this.d != null && dzVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            try {
                                if (!dzVar.c().equals(dzVar.g)) {
                                    if (!dzVar.c().equals(dzVar.a)) {
                                        OfflineMapManager.this.d.onCheckUpdate(false, dzVar.getCity());
                                        return;
                                    }
                                }
                                OfflineMapManager.this.d.onCheckUpdate(true, dzVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override // com.amap.api.col.stln3.ea.a
            public final void c(final dz dzVar) {
                if (OfflineMapManager.this.d != null && dzVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass3 */

                        public final void run() {
                            try {
                                if (dzVar.c().equals(dzVar.a)) {
                                    OfflineMapManager.this.d.onRemove(true, dzVar.getCity(), "");
                                } else {
                                    OfflineMapManager.this.d.onRemove(false, dzVar.getCity(), "");
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override // com.amap.api.col.stln3.ea.a
            public final void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass4 */

                        public final void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.b.a();
            this.a = this.b.f;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.b.d(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            if (ic.d(this.c)) {
                OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
                if (itemByProvinceName != null) {
                    Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
                    while (it.hasNext()) {
                        final String city = it.next().getCity();
                        this.g.post(new Runnable() {
                            /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass2 */

                            public final void run() {
                                try {
                                    OfflineMapManager.this.b.d(city);
                                } catch (AMapException e) {
                                    rx.c(e, "OfflineMapManager", "downloadByProvinceName");
                                }
                            }
                        });
                    }
                    return;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException(AMapException.ERROR_CONNECTION);
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                rx.c(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw ((AMapException) th);
        }
    }

    public final void remove(String str) {
        try {
            if (this.b.b(str)) {
                this.b.c(str);
                return;
            }
            OfflineMapProvince c2 = this.a.c(str);
            if (c2 != null) {
                if (c2.getCityList() != null) {
                    Iterator<OfflineMapCity> it = c2.getCityList().iterator();
                    while (it.hasNext()) {
                        final String city = it.next().getCity();
                        this.g.post(new Runnable() {
                            /* class com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass3 */

                            public final void run() {
                                OfflineMapManager.this.b.c(city);
                            }
                        });
                    }
                    return;
                }
            }
            if (this.d != null) {
                this.d.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.a();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.a.b(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.a.c(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.a.b();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.a.e();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.f();
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.c();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.d();
    }

    private void a(String str) throws AMapException {
        this.b.a(str);
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    public final void restart() {
    }

    public final void stop() {
        this.b.d();
    }

    public final void pause() {
        this.b.e();
    }

    public final void destroy() {
        try {
            if (this.b != null) {
                this.b.f();
            }
            this.d = null;
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
            }
            this.f = null;
            if (this.g != null) {
                this.g.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }
}
