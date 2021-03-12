package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.idst.nls.internal.connector.NetDefine;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.fence.GeoFenceManagerBase;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.track.ErrorCode;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: GeoFenceManager */
public class bl implements GeoFenceManagerBase {
    vz a = null;
    Context b = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    volatile int f = 1;
    ArrayList<GeoFence> g = new ArrayList<>();
    c h = null;
    Object i = new Object();
    Object j = new Object();
    a k = null;
    b l = null;
    volatile boolean m = false;
    volatile boolean n = false;
    volatile boolean o = false;
    bm p = null;
    bn q = null;
    AMapLocationClient r = null;
    volatile AMapLocation s = null;
    long t = 0;
    AMapLocationClientOption u = null;
    int v = 0;
    AMapLocationListener w = new AMapLocationListener() {
        /* class com.amap.api.col.stln3.bl.AnonymousClass1 */

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!bl.this.y && bl.this.o) {
                    bl.this.s = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            bl.this.t = wc.b();
                            bl.this.a(5, null, 0);
                            z = true;
                        } else {
                            bl blVar = bl.this;
                            bl.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        bl.this.v = 0;
                        bl.this.a(6, null, 0);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!bl.this.m) {
                        bl.this.a(7);
                        bundle.putLong("interval", 2000);
                        bl.this.a(8, bundle, 2000);
                    }
                    bl.this.v++;
                    if (bl.this.v >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        bl.this.a(1002, bundle);
                    }
                }
            } catch (Throwable th) {
            }
        }
    };
    final int x = 3;
    volatile boolean y = false;
    private Object z = new Object();

    public bl(Context context) {
        try {
            this.b = context.getApplicationContext();
            e();
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManger", "<init>");
        }
    }

    private void e() {
        if (!this.o) {
            this.o = true;
        }
        if (!this.n) {
            try {
                if (Looper.myLooper() == null) {
                    this.h = new c(this.b.getMainLooper());
                } else {
                    this.h = new c();
                }
            } catch (Throwable th) {
                vu.a(th, "GeoFenceManger", "init 1");
            }
            try {
                this.l = new b("fenceActionThread");
                this.l.setPriority(5);
                this.l.start();
                this.k = new a(this.l.getLooper());
            } catch (Throwable th2) {
                vu.a(th2, "GeoFenceManger", "init 2");
            }
            try {
                this.p = new bm(this.b);
                this.q = new bn();
                this.u = new AMapLocationClientOption();
                this.r = new AMapLocationClient(this.b);
                this.u.setLocationCacheEnable(true);
                this.u.setNeedAddress(false);
                this.r.setLocationListener(this.w);
                if (this.a == null) {
                    this.a = new vz();
                }
            } catch (Throwable th3) {
                vu.a(th3, "GeoFenceManger", "initBase");
            }
            this.n = true;
            try {
                if (this.d != null && this.c == null) {
                    createPendingIntent(this.d);
                }
            } catch (Throwable th4) {
                vu.a(th4, "GeoFenceManger", "init 4");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        bl.this.b(message.getData());
                        return;
                    case 1:
                        bl.this.c(message.getData());
                        return;
                    case 2:
                        bl.this.e(message.getData());
                        return;
                    case 3:
                        bl.this.d(message.getData());
                        return;
                    case 4:
                        bl.this.f(message.getData());
                        return;
                    case 5:
                        bl.this.c();
                        return;
                    case 6:
                        bl.this.a(bl.this.s);
                        return;
                    case 7:
                        bl.this.b();
                        return;
                    case 8:
                        bl.this.j(message.getData());
                        return;
                    case 9:
                        bl.this.a(message.getData());
                        return;
                    case 10:
                        bl.this.a();
                        return;
                    case 11:
                        bl.this.h(message.getData());
                        return;
                    case 12:
                        bl.this.g(message.getData());
                        return;
                    case 13:
                        bl.this.d();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: GeoFenceManager */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public c() {
        }

        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        bl.this.i(data);
                        return;
                    case 1001:
                        try {
                            bl.this.a((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            bl.this.b(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable th3) {
            }
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public PendingIntent createPendingIntent(String str) {
        synchronized (this.z) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(qy.c(this.b));
                this.c = PendingIntent.getBroadcast(this.b, 0, intent, 0);
                this.d = str;
                if (this.g != null && !this.g.isEmpty()) {
                    Iterator<GeoFence> it = this.g.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.c;
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void setActivateAction(int i2) {
        try {
            e();
            if (i2 <= 7) {
                if (i2 > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("activatesAction", i2);
                    a(9, bundle, 0);
                }
            }
            i2 = 1;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("activatesAction", i2);
            a(9, bundle2, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        int i2 = 1;
        if (bundle != null) {
            try {
                i2 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                vu.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f != i2) {
            if (this.g != null && !this.g.isEmpty()) {
                Iterator<GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1);
                }
            }
            f();
        }
        this.f = i2;
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable th) {
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void addRoundGeoFence(DPoint dPoint, float f2, String str) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d) {
                        if (dPoint.getLatitude() >= -90.0d) {
                            if (dPoint.getLongitude() <= 180.0d) {
                                if (dPoint.getLongitude() >= -180.0d) {
                                    GeoFence a2 = a(bundle, false);
                                    i2 = b(a2);
                                    if (i2 == 0) {
                                        arrayList.add(a2);
                                    }
                                }
                            }
                        }
                    }
                    a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle2.putParcelableArrayList("resultList", arrayList);
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1000, bundle2);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void addPolygonGeoFence(List<DPoint> list, String str) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i2 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null) {
                    if (parcelableArrayList.size() > 2) {
                        GeoFence a2 = a(bundle, true);
                        i2 = b(a2);
                        if (i2 == 0) {
                            arrayList.add(a2);
                        }
                    }
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i2);
            bundle2.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle2);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    private GeoFence a(Bundle bundle, boolean z2) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z2) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = b(arrayList);
            }
            geoFence.setMaxDis2Center(b(dPoint, arrayList));
            geoFence.setMinDis2Center(a(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f2 = bundle.getFloat("fenceRadius", 1000.0f);
            if (f2 <= 0.0f) {
                f2 = 1000.0f;
            }
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.f);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1);
        geoFence.setPendingIntent(this.c);
        StringBuilder sb = new StringBuilder();
        sb.append(bn.a());
        geoFence.setFenceId(sb.toString());
        vz vzVar = this.a;
        if (vzVar != null) {
            vzVar.a(this.b, 2);
        }
        return geoFence;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[Catch:{ Throwable -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016 A[Catch:{ Throwable -> 0x004c }] */
    @Override // com.amap.api.fence.GeoFenceManagerBase
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addNearbyGeoFence(java.lang.String r3, java.lang.String r4, com.amap.api.location.DPoint r5, float r6, int r7, java.lang.String r8) {
        /*
            r2 = this;
            r2.e()     // Catch:{ Throwable -> 0x004c }
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0011
            r0 = 1195593728(0x47435000, float:50000.0)
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            goto L_0x0014
        L_0x0011:
            r6 = 1161527296(0x453b8000, float:3000.0)
        L_0x0014:
            if (r7 > 0) goto L_0x0019
            r7 = 10
            goto L_0x001a
        L_0x0019:
        L_0x001a:
            r0 = 25
            if (r7 <= r0) goto L_0x0021
            r7 = 25
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Throwable -> 0x004c }
            r0.<init>()     // Catch:{ Throwable -> 0x004c }
            java.lang.String r1 = "keyWords"
            r0.putString(r1, r3)     // Catch:{ Throwable -> 0x004c }
            java.lang.String r3 = "poiType"
            r0.putString(r3, r4)     // Catch:{ Throwable -> 0x004c }
            java.lang.String r3 = "centerPoint"
            r0.putParcelable(r3, r5)     // Catch:{ Throwable -> 0x004c }
            java.lang.String r3 = "aroundRadius"
            r0.putFloat(r3, r6)     // Catch:{ Throwable -> 0x004c }
            java.lang.String r3 = "searchSize"
            r0.putInt(r3, r7)     // Catch:{ Throwable -> 0x004c }
            java.lang.String r3 = "customId"
            r0.putString(r3, r8)     // Catch:{ Throwable -> 0x004c }
            r3 = 3
            r4 = 0
            r2.a(r3, r0, r4)     // Catch:{ Throwable -> 0x004c }
            return
        L_0x004c:
            r3 = move-exception
            java.lang.String r4 = "GeoFenceManager"
            java.lang.String r5 = "addNearbyGeoFence"
            com.amap.api.col.stln3.vu.a(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.bl.addNearbyGeoFence(java.lang.String, java.lang.String, com.amap.api.location.DPoint, float, int, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void d(Bundle bundle) {
        b(2, bundle);
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void addKeywordGeoFence(String str, String str2, String str3, int i2, String str4) {
        try {
            e();
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(Bundle bundle) {
        b(1, bundle);
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void addDistrictGeoFence(String str, String str2) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(Bundle bundle) {
        b(3, bundle);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(int i2, Bundle bundle) {
        int i3;
        boolean z2;
        int i4;
        String str;
        int i5;
        int i6;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                i3 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i7 = bundle.getInt("searchSize", 10);
                float f2 = bundle.getFloat("aroundRadius", 3000.0f);
                if (!TextUtils.isEmpty(string2)) {
                    switch (i2) {
                        case 1:
                            if (TextUtils.isEmpty(string4)) {
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                        case 2:
                            if (dPoint != null) {
                                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                                    a("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                                }
                                z2 = true;
                                break;
                            }
                            z2 = false;
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.d);
                    bundle3.putLong("expiration", -1);
                    bundle3.putInt("activatesAction", this.f);
                    switch (i2) {
                        case 1:
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            str = this.p.a(this.b, "http://restapi.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i7));
                            break;
                        case 2:
                            double c2 = wc.c(dPoint.getLatitude());
                            double c3 = wc.c(dPoint.getLongitude());
                            int intValue = Float.valueOf(f2).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            str = this.p.a(this.b, "http://restapi.amap.com/v3/place/around?", string2, string4, String.valueOf(i7), String.valueOf(c2), String.valueOf(c3), String.valueOf(intValue));
                            break;
                        case 3:
                            str = this.p.a(this.b, "http://restapi.amap.com/v3/config/district?", string2);
                            break;
                        default:
                            str = null;
                            break;
                    }
                    int i8 = 4;
                    if (str != null) {
                        if (1 == i2) {
                            bn bnVar = this.q;
                            i5 = bn.a(str, arrayList2, bundle3);
                        } else {
                            i5 = 0;
                        }
                        if (2 == i2) {
                            bn bnVar2 = this.q;
                            i5 = bn.b(str, arrayList2, bundle3);
                        }
                        if (3 == i2) {
                            i6 = this.q.c(str, arrayList2, bundle3);
                        } else {
                            i6 = i5;
                        }
                        if (i6 != 10000) {
                            if (!(i6 == 1 || i6 == 7)) {
                                switch (i6) {
                                    case 4:
                                    case 5:
                                        break;
                                    default:
                                        switch (i6) {
                                            case 16:
                                            case 17:
                                                break;
                                            default:
                                                switch (i6) {
                                                    case ErrorCode.Response.SUCCESS /*{ENCODED_INT: 10000}*/:
                                                        i6 = 0;
                                                        break;
                                                    case GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO /*{ENCODED_INT: 10001}*/:
                                                    case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*{ENCODED_INT: 10002}*/:
                                                    case 10007:
                                                    case 10008:
                                                    case 10009:
                                                    case 10012:
                                                    case 10013:
                                                        i6 = 7;
                                                        break;
                                                    case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /*{ENCODED_INT: 10003}*/:
                                                    case 10004:
                                                    case 10005:
                                                    case 10006:
                                                    case 10010:
                                                    case 10011:
                                                    case 10014:
                                                    case 10015:
                                                    case 10016:
                                                    case 10017:
                                                        i6 = 4;
                                                        break;
                                                    default:
                                                        switch (i6) {
                                                            case NetDefine.HTTP_READ_TIMEOUT:
                                                            case 20001:
                                                            case 20002:
                                                                i6 = 1;
                                                                break;
                                                            case 20003:
                                                            default:
                                                                i6 = 8;
                                                                break;
                                                        }
                                                }
                                        }
                                }
                            }
                            if (i6 != 0) {
                                a("添加围栏失败", i6, "searchErrCode is " + i6, new String[0]);
                            }
                            i4 = i6;
                        } else if (arrayList2.isEmpty()) {
                            i4 = 16;
                        } else {
                            i4 = a(arrayList2);
                            if (i4 == 0) {
                                arrayList.addAll(arrayList2);
                            } else {
                                i8 = i4;
                            }
                        }
                    }
                    i4 = i8;
                } else {
                    i4 = 1;
                }
                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i3 = i4;
            }
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i3);
        } catch (Throwable th) {
            bundle2.putInt(MyLocationStyle.ERROR_CODE, 0);
            a(1000, bundle2);
            throw th;
        }
        a(1000, bundle2);
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void removeGeoFence() {
        try {
            this.o = false;
            a(10, null, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            if (this.g != null) {
                if (!this.g.isEmpty()) {
                    if (!this.g.contains(geoFence)) {
                        return false;
                    }
                    if (this.g.size() == 1) {
                        this.o = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    a(11, bundle, 0);
                    return true;
                }
            }
            this.o = false;
            a(10, null, 0);
            return true;
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void setGeoFenceAble(String str, boolean z2) {
        try {
            e();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z2);
            a(12, bundle, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z2 = true;
                        boolean z3 = bundle.getBoolean("ab", true);
                        if (this.g != null) {
                            if (!this.g.isEmpty()) {
                                Iterator<GeoFence> it = this.g.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    GeoFence next = it.next();
                                    if (next.getFenceId().equals(string)) {
                                        next.setAble(z3);
                                        break;
                                    }
                                }
                            }
                        }
                        if (!z3) {
                            if (this.g != null) {
                                if (!this.g.isEmpty()) {
                                    Iterator<GeoFence> it2 = this.g.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (it2.next().isAble()) {
                                                z2 = false;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (z2) {
                                d();
                                return;
                            }
                            return;
                        }
                        f();
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public List<GeoFence> getAllGeoFence() {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            return (ArrayList) this.g.clone();
        } catch (Throwable th) {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    public final void h(Bundle bundle) {
        try {
            if (this.g != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.g.contains(geoFence)) {
                    this.g.remove(geoFence);
                }
                if (this.g.size() <= 0) {
                    a();
                } else {
                    f();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            if (this.n) {
                if (this.g != null) {
                    this.g.clear();
                    this.g = null;
                }
                if (!this.o) {
                    try {
                        synchronized (this.i) {
                            if (this.k != null) {
                                this.k.removeCallbacksAndMessages(null);
                            }
                            this.k = null;
                        }
                    } catch (Throwable th) {
                        vu.a(th, "GeoFenceManager", "destroyActionHandler");
                    }
                    if (this.r != null) {
                        this.r.stopLocation();
                        this.r.onDestroy();
                    }
                    this.r = null;
                    if (this.l != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.l.quitSafely();
                        } else {
                            this.l.quit();
                        }
                    }
                    this.l = null;
                    this.p = null;
                    synchronized (this.z) {
                        if (this.c != null) {
                            this.c.cancel();
                        }
                        this.c = null;
                    }
                    try {
                        synchronized (this.j) {
                            if (this.h != null) {
                                this.h.removeCallbacksAndMessages(null);
                            }
                            this.h = null;
                        }
                    } catch (Throwable th2) {
                        vu.a(th2, "GeoFenceManager", "destroyResultHandler");
                    }
                    if (this.a != null) {
                        this.a.b(this.b);
                    }
                    this.m = false;
                    this.n = false;
                }
            }
        } catch (Throwable th3) {
        }
    }

    private int b(GeoFence geoFence) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            if (this.g.contains(geoFence)) {
                return 17;
            }
            this.g.add(geoFence);
            return 0;
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private int a(List<GeoFence> list) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                b(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Bundle bundle, long j2) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    Message obtainMessage = this.k.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.k.sendMessageDelayed(obtainMessage, j2);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    this.k.removeMessages(i2);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Bundle bundle) {
        try {
            synchronized (this.j) {
                if (this.h != null) {
                    Message obtainMessage = this.h.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.h.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    int i2 = bundle.getInt(MyLocationStyle.ERROR_CODE);
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                    if (parcelableArrayList == null) {
                        parcelableArrayList = new ArrayList();
                    }
                    String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    if (string == null) {
                        string = "";
                    }
                    if (this.e != null) {
                        this.e.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i2, string);
                    }
                    if (i2 == 0) {
                        f();
                    }
                }
            } catch (Throwable th) {
                vu.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    private void f() {
        if (!this.y && this.k != null) {
            boolean z2 = false;
            if (this.s != null && wc.a(this.s) && wc.b() - this.t < 10000) {
                z2 = true;
            }
            if (z2) {
                a(6, null, 0);
                a(5, null, 0);
                return;
            }
            a(7);
            a(7, null, 0);
        }
    }

    private static Bundle a(GeoFence geoFence, String str, String str2, int i2, int i3) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i2);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i3);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        try {
            if (this.b != null) {
                synchronized (this.z) {
                    if (this.c != null) {
                        Intent intent = new Intent();
                        intent.putExtras(a(null, null, null, 4, i2));
                        this.c.send(this.b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(GeoFence geoFence) {
        try {
            synchronized (this.z) {
                if (this.b != null) {
                    if (this.c == null) {
                        if (geoFence.getPendingIntent() == null) {
                            return;
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    if (this.d != null) {
                        intent.setAction(this.d);
                    }
                    intent.setPackage(qy.c(this.b));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.b, 0, intent);
                    } else {
                        this.c.send(this.b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapLocation aMapLocation) {
        try {
            if (this.y || this.g == null) {
                return;
            }
            if (!this.g.isEmpty()) {
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                    Iterator<GeoFence> it = this.g.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        if (next.isAble() && b(aMapLocation, next) && a(next, this.f)) {
                            next.setCurrentLocation(aMapLocation);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("geoFence", next);
                            a(1001, bundle);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        try {
            if (this.r != null) {
                g();
                this.u.setOnceLocation(true);
                this.r.setLocationOption(this.u);
                this.r.startLocation();
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    private void g() {
        try {
            if (this.m) {
                a(8);
            }
            if (this.r != null) {
                this.r.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(Bundle bundle) {
        try {
            if (this.r != null) {
                long j2 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j2 = bundle.getLong("interval", 2000);
                }
                this.u.setOnceLocation(false);
                this.u.setInterval(j2);
                this.r.setLocationOption(this.u);
                if (!this.m) {
                    this.r.stopLocation();
                    this.r.startLocation();
                    this.m = true;
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        float f2;
        try {
            if (!this.y && wc.a(this.s)) {
                AMapLocation aMapLocation = this.s;
                ArrayList<GeoFence> arrayList = this.g;
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && arrayList != null && !arrayList.isEmpty()) {
                    DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    Iterator<GeoFence> it = arrayList.iterator();
                    float f3 = Float.MAX_VALUE;
                    while (true) {
                        if (!it.hasNext()) {
                            f2 = f3;
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.isAble()) {
                            float a2 = wc.a(dPoint, next.getCenter());
                            if (a2 > next.getMinDis2Center() && a2 < next.getMaxDis2Center()) {
                                f2 = 0.0f;
                                break;
                            }
                            if (a2 > next.getMaxDis2Center()) {
                                f3 = Math.min(f3, a2 - next.getMaxDis2Center());
                            }
                            if (a2 < next.getMinDis2Center()) {
                                f3 = Math.min(f3, next.getMinDis2Center() - a2);
                            }
                        }
                    }
                } else {
                    f2 = Float.MAX_VALUE;
                }
                if (f2 != Float.MAX_VALUE) {
                    if (f2 < 1000.0f) {
                        a(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong("interval", 2000);
                        a(8, bundle, 500);
                    } else if (f2 < 5000.0f) {
                        g();
                        a(7);
                        a(7, null, 10000);
                    } else {
                        g();
                        a(7);
                        a(7, null, (long) (((f2 - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    private static DPoint b(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (DPoint dPoint2 : list) {
                d2 += dPoint2.getLatitude();
                d3 += dPoint2.getLongitude();
            }
            return new DPoint(wc.c(d2 / ((double) list.size())), wc.c(d3 / ((double) list.size())));
        } catch (Throwable th) {
            vu.a(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    static float a(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.min(f2, wc.a(dPoint, dPoint2));
            }
        }
        return f2;
    }

    static float b(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.max(f2, wc.a(dPoint, dPoint2));
            }
        }
        return f2;
    }

    private static boolean a(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2;
        try {
            if (wc.a(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                switch (geoFence.getType()) {
                    case 0:
                    case 2:
                        DPoint center = geoFence.getCenter();
                        if (wc.a(new double[]{center.getLatitude(), center.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= geoFence.getRadius()) {
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        boolean z3 = false;
                        for (List<DPoint> list : geoFence.getPointList()) {
                            try {
                                if (list.size() < 3 ? false : vu.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list)) {
                                    z3 = true;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = z3;
                                vu.a(th, "Utils", "isInGeoFence");
                                return z2;
                            }
                        }
                        return z3;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            vu.a(th, "Utils", "isInGeoFence");
            return z2;
        }
    }

    private static boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2 = true;
        try {
            if (a(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(wc.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3) {
                    if (wc.b() - geoFence.getEnterTime() > 600000) {
                        geoFence.setStatus(3);
                        return true;
                    }
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            vu.a(th, "Utils", "isFenceStatusChanged");
            return z2;
        }
    }

    private static boolean a(GeoFence geoFence, int i2) {
        boolean z2 = false;
        if ((i2 & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z2 = true;
                }
            } catch (Throwable th) {
                vu.a(th, "Utils", "remindStatus");
                return false;
            }
        }
        if ((i2 & 2) == 2) {
            if (geoFence.getStatus() == 2) {
                z2 = true;
            }
        }
        if ((i2 & 4) == 4 && geoFence.getStatus() == 3) {
            return true;
        }
        return z2;
    }

    static void a(String str, int i2, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:" + i2);
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:" + str2);
        stringBuffer.append("\n");
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        stringBuffer.toString();
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void pauseGeoFence() {
        try {
            e();
            this.y = true;
            a(13, null, 0);
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        try {
            a(7);
            a(8);
            if (this.r != null) {
                this.r.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public void resumeGeoFence() {
        try {
            e();
            if (this.y) {
                this.y = false;
                f();
            }
        } catch (Throwable th) {
            vu.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    @Override // com.amap.api.fence.GeoFenceManagerBase
    public boolean isPause() {
        return this.y;
    }
}
