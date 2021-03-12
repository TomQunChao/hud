package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.IFrameWTBT;
import com.autonavi.wtbt.CarLocation;
import com.autonavi.wtbt.DGNaviInfo;

/* compiled from: FrameForWTBT */
public final class ji implements IFrameWTBT {
    InnerNaviInfo a;
    private NaviInfo b;
    private int c;
    private js d;
    private Context e;
    private iw f;

    public ji(Context context, js jsVar) {
        try {
            this.a = new InnerNaviInfo();
            this.d = jsVar;
            this.e = context;
            this.f = jsVar.t();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4) {
        try {
            if (this.d != null) {
                jg.a().execute(new kc(this.d, this.e, str, i3, str2, i, i2, bArr));
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForWTBT", "requestHttp(int moduleID, int connectID, int type, String url,\nString head, byte[] data, int dataLength)");
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
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
            rx.c(th, "FrameForWTBT", "updateNaviInfo(DGNaviInfo dgNaviInfo)");
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
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
                rx.c(th, "FrameForWTBT", "playNaviSound(int soundType, String soundStr)");
            }
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void endEmulatorNavi() {
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
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
            rx.c(th, "FrameForWTBT", "arriveWay(int wayId)");
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void offRoute() {
        try {
            if (this.f != null) {
                this.f.obtainMessage(30).sendToTarget();
            }
            if (this.d != null) {
                this.d.e();
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "FrameForWTBT", "offRoute()");
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void routeDestroy() {
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void carLocationChange(CarLocation carLocation) {
        if (carLocation != null) {
            try {
                this.c = carLocation.m_Speed;
                AMapNaviLocation aMapNaviLocation = new AMapNaviLocation();
                aMapNaviLocation.setBearing((float) carLocation.m_CarDir);
                aMapNaviLocation.setSpeed((float) carLocation.m_Speed);
                aMapNaviLocation.setAccuracy(iu.b());
                aMapNaviLocation.setAltitude(iu.c());
                aMapNaviLocation.setType(2);
                aMapNaviLocation.setMatchStatus(carLocation.m_MatchStatus);
                aMapNaviLocation.setCoord(new NaviLatLng(carLocation.m_Latitude, carLocation.m_Longitude));
                aMapNaviLocation.setTime(System.currentTimeMillis());
                if (this.f != null) {
                    this.f.obtainMessage(22, aMapNaviLocation).sendToTarget();
                    String str = "FrameForWTBT carLocationChange(rtbt位置回调),Latitude=" + carLocation.m_Latitude + ",Longitude=" + carLocation.m_Longitude;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "FrameForWTBT", "carLocationChange(CarLocation carLocation)");
            }
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void carProjectionChange(CarLocation carLocation) {
        try {
            AmapCarLocation amapCarLocation = new AmapCarLocation(carLocation);
            if (this.f != null) {
                this.f.obtainMessage(33, amapCarLocation).sendToTarget();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "FrameForWTBT", "carProjectionChange(CarLocation carLocation)");
        }
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void setRouteRequestState(int i) {
        int i2;
        int i3 = 12;
        if (i == 1) {
            try {
                if (this.d != null) {
                    i2 = this.d.c(0);
                } else {
                    i2 = -1;
                }
                if (this.f == null) {
                    return;
                }
                if (i2 != -1) {
                    int[] iArr = {12};
                    this.f.obtainMessage(28, iArr).sendToTarget();
                    a(40, i, iArr);
                    return;
                }
                this.f.obtainMessage(29, -1).sendToTarget();
                a(41, i, null);
                jy.a("http://restapi.amap.com/v3/direction/walking".replace("http://restapi.amap.com/", ""), i);
            } catch (Throwable th) {
                th.printStackTrace();
                mj.a(th);
                rx.c(th, "FrameForWTBT", "setRouteRequestState(int requestRouteState)");
            }
        } else {
            switch (i) {
                case 2:
                    i3 = 2;
                    break;
                case 3:
                    i3 = 3;
                    break;
                case 4:
                    i3 = 6;
                    break;
                default:
                    switch (i) {
                        case 9:
                            i3 = 9;
                            break;
                        case 10:
                            i3 = 10;
                            break;
                        case 11:
                            i3 = 11;
                            break;
                        case 12:
                            break;
                        case 13:
                            i3 = 20;
                            break;
                        default:
                            i3 = 19;
                            break;
                    }
            }
            if (this.f != null) {
                this.f.obtainMessage(29, Integer.valueOf(i3)).sendToTarget();
                a(41, i3, null);
                jy.a("http://restapi.amap.com/v3/direction/walking".replace("http://restapi.amap.com/", ""), i3);
            }
        }
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

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final int getPlayState() {
        return 0;
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void lockScreenNaviTips(String str, int i, int i2) {
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final void vibratePhoneTips(int i, int i2) {
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
    public final int GetDialect() {
        return 0;
    }

    @Override // com.autonavi.wtbt.IFrameForWTBT
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
            rx.c(th, "FrameForTBT", "initFailure()");
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
            rx.c(th, "FrameForTBT", "onStartNavi(int flag)");
        }
    }

    @Override // com.amap.api.col.stln3.jl
    public final NaviInfo c() {
        return this.b;
    }
}
