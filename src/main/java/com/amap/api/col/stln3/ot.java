package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.stln3.nu;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;

/* compiled from: CloudSearchCore */
public class ot implements ICloudSearch {
    private Context a;
    private CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    private Handler f = nu.a();

    public ot(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (r3.getLongitude() < r4.getLongitude()) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3 A[Catch:{ Throwable -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.services.cloud.CloudResult a(com.amap.api.services.cloud.CloudSearch.Query r11) throws com.amap.api.services.core.AMapException {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ot.a(com.amap.api.services.cloud.CloudSearch$Query):com.amap.api.services.cloud.CloudResult");
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ot.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 700;
                        nu.d dVar = new nu.d();
                        dVar.b = ot.this.b;
                        obtainMessage.obj = dVar;
                        dVar.a = ot.this.a((ot) query);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ot.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    ot.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CloudItemDetail a(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            try {
                return (CloudItemDetail) new ni(this.a, new oc(str, str2)).a();
            } catch (Throwable th) {
                nl.a(th, "CloudSearch", "searchCloudDetail");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return null;
                }
                throw ((AMapException) th);
            }
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ot.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 701;
                        nu.c cVar = new nu.c();
                        cVar.b = ot.this.b;
                        obtainMessage.obj = cVar;
                        cVar.a = ot.this.a((ot) str, str2);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ot.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    ot.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
