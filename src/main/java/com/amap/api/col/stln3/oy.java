package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.stln3.nu;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearbySearchCore */
public class oy implements INearbySearch {
    private static long e = 0;
    private List<NearbySearch.NearbyListener> a = new ArrayList();
    private String b;
    private Context c;
    private nu d;
    private ExecutorService f;
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();
    private UploadInfoCallback k;
    private TimerTask l;

    static /* synthetic */ int a(oy oyVar, UploadInfo uploadInfo) {
        return oyVar.i ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : oyVar.a(uploadInfo);
    }

    public oy(Context context) {
        this.c = context.getApplicationContext();
        this.d = nu.a();
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.a.add(nearbyListener);
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener != null) {
            try {
                this.a.remove(nearbyListener);
            } catch (Throwable th) {
                nl.a(th, "NearbySearch", "removeNearbyListener");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void clearUserInfoAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.oy.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = oy.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = oy.this.a;
                    try {
                        oy.this.a();
                        obtainMessage.what = 1000;
                        if (oy.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        nl.a(e, "NearbySearch", "clearUserInfoAsyn");
                        if (oy.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (oy.this.d != null) {
                            oy.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    oy.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int a() throws AMapException {
        try {
            if (this.i) {
                throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            } else if (a(this.b)) {
                ns.a(this.c);
                return ((Integer) new nv(this.c, this.b).a()).intValue();
            } else {
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void setUserID(String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i2) {
        if (i2 < 7000) {
            i2 = 7000;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i) {
                if (this.l != null) {
                    this.l.cancel();
                }
            }
            this.i = true;
            this.l = new a(this, (byte) 0);
            this.j.schedule(this.l, 0, (long) i2);
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void stopUploadNearbyInfoAuto() {
        try {
            if (this.l != null) {
                this.l.cancel();
            }
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "stopUploadNearbyInfoAuto");
        }
        this.i = false;
        this.l = null;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int a(UploadInfo uploadInfo) {
        try {
            ns.a(this.c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = userID;
            }
            if (!userID.equals(this.h)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point == null) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
            }
            if (point.equals(this.g)) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
            }
            new nx(this.c, uploadInfo).a();
            this.g = point.copy();
            return 1000;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable th) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() {
            /* class com.amap.api.col.stln3.oy.AnonymousClass2 */

            public final void run() {
                try {
                    Message obtainMessage = oy.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = oy.this.a;
                    obtainMessage.what = oy.a(oy.this, uploadInfo);
                    oy.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    nl.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.oy.AnonymousClass3 */

                public final void run() {
                    Message obtainMessage = oy.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    nu.f fVar = new nu.f();
                    fVar.a = oy.this.a;
                    obtainMessage.obj = fVar;
                    try {
                        fVar.b = oy.this.searchNearbyInfo(nearbyQuery);
                        obtainMessage.what = 1000;
                        if (oy.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        nl.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                        if (oy.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (oy.this.d != null) {
                            oy.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    oy.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0013 A[Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }] */
    @Override // com.amap.api.services.interfaces.INearbySearch
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.nearby.NearbySearchResult searchNearbyInfo(com.amap.api.services.nearby.NearbySearch.NearbyQuery r3) throws com.amap.api.services.core.AMapException {
        /*
            r2 = this;
            android.content.Context r0 = r2.c     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            com.amap.api.col.stln3.ns.a(r0)     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            r0 = 0
            if (r3 != 0) goto L_0x0009
        L_0x0008:
            goto L_0x0011
        L_0x0009:
            com.amap.api.services.core.LatLonPoint r1 = r3.getCenterPoint()     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0008
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 == 0) goto L_0x0021
            com.amap.api.col.stln3.nw r0 = new com.amap.api.col.stln3.nw     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            android.content.Context r1 = r2.c     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            r0.<init>(r1, r3)     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            java.lang.Object r3 = r0.a()     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            com.amap.api.services.nearby.NearbySearchResult r3 = (com.amap.api.services.nearby.NearbySearchResult) r3     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            return r3
        L_0x0021:
            com.amap.api.services.core.AMapException r3 = new com.amap.api.services.core.AMapException     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            java.lang.String r0 = "无效的参数 - IllegalArgumentException"
            r3.<init>(r0)     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
            throw r3     // Catch:{ AMapException -> 0x0039, Throwable -> 0x0029 }
        L_0x0029:
            r3 = move-exception
            java.lang.String r0 = "NearbySearch"
            java.lang.String r1 = "searchNearbyInfo"
            com.amap.api.col.stln3.nl.a(r3, r0, r1)
            com.amap.api.services.core.AMapException r3 = new com.amap.api.services.core.AMapException
            java.lang.String r0 = "未知错误"
            r3.<init>(r0)
            throw r3
        L_0x0039:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.oy.searchNearbyInfo(com.amap.api.services.nearby.NearbySearch$NearbyQuery):com.amap.api.services.nearby.NearbySearchResult");
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            nl.a(th, "NearbySearch", "destryoy");
        }
    }

    /* compiled from: NearbySearchCore */
    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(oy oyVar, byte b) {
            this();
        }

        public final void run() {
            try {
                if (oy.this.k != null) {
                    int a2 = oy.this.a((oy) oy.this.k.OnUploadInfoCallback());
                    Message obtainMessage = oy.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = oy.this.a;
                    obtainMessage.what = a2;
                    oy.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                nl.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }
}
