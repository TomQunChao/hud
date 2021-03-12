package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.rtbt.CarLocation;
import com.autonavi.rtbt.DGNaviInfo;
import com.autonavi.tbt.IFrameRTBT;

/* compiled from: FrameForRTBT */
public final class jh implements IFrameRTBT {
    InnerNaviInfo a = null;
    private NaviInfo b;
    private int c;
    private jr d;
    private Context e;
    private iw f;

    public jh(Context context, jr jrVar) {
        try {
            this.a = new InnerNaviInfo();
            this.d = jrVar;
            this.e = context;
            this.f = jrVar.t();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4) {
        try {
            if (this.d != null) {
                jg.a().execute(new ka(this.d, this.e, str, i3, str2, i, i2, bArr));
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForWTBT", "requestHttp(int moduleID, int connectID, int type, String url,\n                            String head, byte[] data, int dataLength)");
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void updateNaviInfo(DGNaviInfo dGNaviInfo) {
        try {
            this.b = new NaviInfo(dGNaviInfo);
            this.b.setCurrentSpeed(this.c);
            if (this.d != null) {
                this.b.setNaviType(this.d.g());
            }
            if (this.f != null) {
                this.f.obtainMessage(1, this.b).sendToTarget();
            }
            this.a.setInnerNaviInfo(this.b);
            if (this.f != null) {
                this.f.obtainMessage(27, this.a).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "FrameForRTBT", "updateNaviInfo(DGNaviInfo dgNaviInfo)");
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void playNaviSound(int i, String str) {
        if (i != 8) {
            try {
                if (!str.contains("行进方向有误")) {
                    if (this.f != null) {
                        this.f.obtainMessage(17, str).sendToTarget();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "FrameForRTBT", "playNaviSound(int soundType, String soundStr)");
            }
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void endEmulatorNavi() {
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void arriveWay(int i) {
        try {
            if (this.f != null && i >= 0) {
                if (i != 0) {
                    this.f.obtainMessage(10, Integer.valueOf(i)).sendToTarget();
                } else if (this.d == null) {
                } else {
                    if (this.d.g() == 2) {
                        this.f.obtainMessage(9, 2).sendToTarget();
                    } else {
                        this.f.obtainMessage(9, 1).sendToTarget();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "FrameForRTBT", "arriveWay(int wayId)");
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void offRoute() {
        try {
            if (this.f != null) {
                this.f.obtainMessage(30).sendToTarget();
            }
            if (this.d != null) {
                this.d.c();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForRTBT", "offRoute()");
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void routeDestroy() {
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void carLocationChange(CarLocation carLocation) {
        if (carLocation != null) {
            try {
                this.c = carLocation.m_Speed;
                AMapNaviLocation aMapNaviLocation = new AMapNaviLocation();
                aMapNaviLocation.setBearing((float) carLocation.m_CarDir);
                aMapNaviLocation.setSpeed((float) carLocation.m_Speed);
                aMapNaviLocation.setAccuracy(iu.b());
                aMapNaviLocation.setAltitude(iu.c());
                aMapNaviLocation.setType(1);
                aMapNaviLocation.setMatchStatus(carLocation.m_MatchStatus);
                aMapNaviLocation.setCoord(new NaviLatLng(carLocation.m_Latitude, carLocation.m_Longitude));
                aMapNaviLocation.setTime(System.currentTimeMillis());
                if (this.f != null) {
                    this.f.obtainMessage(22, aMapNaviLocation).sendToTarget();
                    String str = "FrameForWTBT carLocationChange(rtbt位置回调),Latitude=" + carLocation.m_Latitude + ",Longitude=" + carLocation.m_Longitude;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "FrameForRTBT", "carLocationChange(CarLocation carLocation)");
            }
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void carProjectionChange(CarLocation carLocation) {
        try {
            AmapCarLocation amapCarLocation = new AmapCarLocation(carLocation);
            if (this.f != null) {
                this.f.obtainMessage(33, amapCarLocation).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "FrameForRTBT", "carProjectionChange(CarLocation carLocation)");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[Catch:{ Throwable -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.autonavi.rtbt.IFrameForRTBT
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRouteRequestState(int r9) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.jh.setRouteRequestState(int):void");
    }

    private void a(int i, int i2, int[] iArr) {
        if (this.f != null) {
            AMapCalcRouteResult aMapCalcRouteResult = new AMapCalcRouteResult();
            aMapCalcRouteResult.setCalcRouteType(0);
            aMapCalcRouteResult.setErrorCode(i2);
            if (iArr != null) {
                aMapCalcRouteResult.setRouteid(iArr);
            }
            this.f.obtainMessage(i, aMapCalcRouteResult).sendToTarget();
        }
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final int getPlayState() {
        return 0;
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void lockScreenNaviTips(String str, int i, int i2) {
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void vibratePhoneTips(int i, int i2) {
    }

    @Override // com.autonavi.rtbt.IFrameForRTBT
    public final void PlayVoiceType(int i) {
    }

    @Override // com.amap.api.col.stln3.jl
    public final void a() {
        this.b = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.amap.api.col.stln3.jl
    public final void b() {
        try {
            if (this.f != null) {
                this.f.sendEmptyMessage(34);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForRTBT", "initFailure()");
        }
    }

    @Override // com.amap.api.col.stln3.jl
    public final void a(int i) {
        try {
            if (this.f != null) {
                this.f.obtainMessage(26, Integer.valueOf(i)).sendToTarget();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForRTBT", "onStartNavi(int flag)");
        }
    }

    @Override // com.amap.api.col.stln3.jl
    public final NaviInfo c() {
        return this.b;
    }
}
