package com.amap.api.col.stln3;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.idst.nls.internal.VoiceRecorder;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.INavi;
import com.amap.api.navi.NaviSetting;
import com.amap.api.navi.enums.AMapNaviOnlineCarHailingType;
import com.amap.api.navi.enums.SoundQuality;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.ae.route.model.RerouteOption;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AMapNaviCore */
public class ja implements jm, INavi {
    boolean a = false;
    Location b = null;
    boolean c = false;
    long d = 0;
    private int e = -1;
    private int f = -1;
    private NaviSetting g;
    private boolean h = false;
    private boolean i = false;
    private jj j;
    private Context k;
    private int l = 40;
    private jc m;
    private jr n;
    private js o;
    private it p;
    private boolean q = false;
    private boolean r = false;
    private md s;
    private CoordinateConverter t;
    private boolean u;
    private boolean v = false;
    private long w;
    private Handler x = new Handler(Looper.getMainLooper()) {
        /* class com.amap.api.col.stln3.ja.AnonymousClass1 */

        public final void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (message.what == 10001) {
                    ja.a(ja.this);
                } else if (message.what == 10003) {
                    ja.b(ja.this);
                } else if (message.what == 10002) {
                    ja.b(ja.this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapNavi", "handleMessage");
            }
        }
    };

    static /* synthetic */ void a(ja jaVar) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (jaVar.w <= 0 || currentTimeMillis - jaVar.w <= 9900) {
                jaVar.v = false;
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
                return;
            }
            jaVar.v = true;
            jaVar.a(jaVar.v);
            jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
            jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
            if (jaVar.c) {
                Message obtainMessage = jaVar.x.obtainMessage();
                obtainMessage.what = GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME;
                jaVar.x.sendMessageDelayed(obtainMessage, 3000);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "checkGPSWeaker");
        }
    }

    static /* synthetic */ void b(ja jaVar) {
        try {
            jaVar.a(jaVar.v);
            if (jaVar.u && jaVar.v && !mj.a && jaVar.f == 1) {
                if (!(jaVar.m == null || jaVar.m.t() == null)) {
                    jaVar.m.t().obtainMessage(17, "当前GPS信号弱，位置更新可能延迟").sendToTarget();
                }
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
                Message obtainMessage = jaVar.x.obtainMessage();
                obtainMessage.what = GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR;
                jaVar.x.sendMessageDelayed(obtainMessage, 120000);
            } else if (!jaVar.u || !jaVar.v || !mj.a) {
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
            } else {
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
                jaVar.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
                Message obtainMessage2 = jaVar.x.obtainMessage();
                obtainMessage2.what = GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME;
                jaVar.x.sendMessageDelayed(obtainMessage2, 3000);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "checkPlayGPSWeaker");
        }
    }

    public ja(Context context) {
        try {
            this.k = context.getApplicationContext();
            rf.a().a(this.k);
            mf.a(this.k);
            mm.a(context.getApplicationContext());
            this.p = new it(this.k);
            this.p.a();
            this.g = new NaviSetting(this.k, this.p);
            if (this.m == null) {
                this.m = this.p;
            }
            this.j = new jj(this.k);
            this.j.a(this);
            this.j.a();
            this.p.a(this.j);
            Message obtainMessage = this.m.t().obtainMessage();
            obtainMessage.what = 32;
            this.m.t().sendMessageDelayed(obtainMessage, 150);
            this.s = md.a(context);
            this.s.a(this);
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "init");
        }
    }

    @Override // com.amap.api.navi.INavi
    public int strategyConvert(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        try {
            if (this.m != null) {
                return this.m.strategyConvert(z, z2, z3, z4, z5);
            }
            return 0;
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "strategyConvert");
            return 0;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void destroy() {
        try {
            if (this.j != null) {
                this.j.b();
                this.j.c();
                this.j = null;
            }
            this.g.destroy();
            if (this.n != null) {
                this.n.b();
                this.n = null;
            }
            if (this.o != null) {
                this.o.c();
                this.o = null;
            }
            if (this.p != null) {
                this.p.b();
                this.p = null;
            }
            this.m = null;
            this.q = false;
            if (this.s != null) {
                this.s.c();
                this.s = null;
            }
            jg.b();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "destroy");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startNavi(int i2) {
        this.f = i2;
        try {
            boolean z = false;
            if (this.q) {
                return false;
            }
            try {
                if (((LocationManager) this.k.getSystemService("location")).isProviderEnabled(GeocodeSearch.GPS)) {
                    z = true;
                }
                this.m.t().obtainMessage(35, Boolean.valueOf(z)).sendToTarget();
            } catch (Throwable th) {
                th.printStackTrace();
                rx.c(th, "AMapNavi", "onGpsCheck");
            }
            switch (i2) {
                case 1:
                    this.u = true;
                    this.m.a(i2);
                    if (!this.h) {
                        startGPS();
                    }
                    b();
                    break;
                case 2:
                    this.m.b(this.l);
                    this.m.a(i2);
                    break;
                case 3:
                    this.m.a(i2);
                    break;
            }
            this.q = true;
            ug ugVar = new ug(this.k, "navi", "6.5.0", "O004");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("param_long_second", this.e);
            ugVar.a(jSONObject.toString());
            uh.a(ugVar, this.k);
            return true;
        } catch (Throwable th2) {
            mj.a(th2);
            rx.c(th2, "AMapNaviCore", "startNavi");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void pauseNavi() {
        try {
            if (this.m != null) {
                this.m.h();
                this.q = false;
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "pauseNavi");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopNavi() {
        try {
            this.u = false;
            if (this.m != null) {
                this.m.i();
                this.q = false;
            }
            this.b = null;
            this.c = false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopNavi");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void resumeNavi() {
        try {
            if (this.m != null) {
                this.m.j();
            }
            this.q = true;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "resumeNavi");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean readNaviInfo() {
        try {
            if (this.m != null) {
                return this.m.k();
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "readNaviInfo");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean readTrafficInfo(int i2) {
        try {
            if (this.m != null) {
                return this.m.readTrafficInfo(i2);
            }
            return false;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "readTrafficInfo");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            return this.m.calculateDriveRoute(list, list2, list3, i2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setCarNumber(String str, String str2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            if (this.m != null) {
                this.m.setCarNumber(str, str2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setCarNumber()");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setCarInfo(AMapCarInfo aMapCarInfo) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            if (this.m != null) {
                this.m.setCarInfo(aMapCarInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNavi", "setCarInfo");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            return this.m.calculateDriveRoute(list, list2, i2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute1");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean reCalculateRoute(int i2) {
        try {
            if (this.m != null) {
                int i3 = 3;
                if (iu.g() == i2) {
                    i3 = 12;
                }
                iu.a(i2);
                RerouteOption rerouteOption = new RerouteOption();
                rerouteOption.setRerouteType(i3);
                return this.m.reCalculateRoute(rerouteOption, false);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "reCalculateRoute");
        }
        return false;
    }

    @Override // com.amap.api.navi.INavi
    public List<AMapTrafficStatus> getTrafficStatuses(int i2, int i3) {
        try {
            if (this.m != null) {
                return this.m.getTrafficStatuses(i2, i3);
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getTrafficStatuses");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public AMapNaviPath getNaviPath() {
        try {
            return this.m.m();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviPath");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public HashMap<Integer, AMapNaviPath> getNaviPaths() {
        try {
            return this.m.getMultipleNaviPathsCalculated();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviPaths");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public List<AMapNaviGuide> getNaviGuideList() {
        try {
            return this.m.n();
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "getNaviGuideList");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public NaviSetting getNaviSetting() {
        return this.g;
    }

    @Override // com.amap.api.navi.INavi
    public void setEmulatorNaviSpeed(int i2) {
        try {
            this.l = i2;
            if (this.m != null) {
                this.m.b(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNavi", "setEmulatorNaviSpeed");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setTimeForOneWord(int i2) {
        try {
            if (this.m != null) {
                this.m.g(i2);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setTimeForOneWord");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void addAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.m != null) {
                this.m.a(aMapNaviListener);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "addAMapNaviListener");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void removeAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.m != null) {
                this.m.b(aMapNaviListener);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "removeAMapNaviListener");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startGPS() {
        try {
            if (this.j == null) {
                return true;
            }
            this.j.a();
            return true;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean startGPS(long j2, int i2) {
        try {
            if (this.j == null) {
                return true;
            }
            this.j.a(j2);
            return true;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "startGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean stopGPS() {
        try {
            if (this.j == null) {
                return true;
            }
            this.j.b();
            return true;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "stopGPS");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateWalkRoute(NaviLatLng naviLatLng) {
        try {
            if (this.o == null) {
                this.o = new js(this.k);
                this.o.b();
            }
            this.m = this.o;
            this.e = 1;
            return this.m.a(naviLatLng);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateWalkRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.o == null) {
                this.o = new js(this.k);
                this.o.b();
            }
            this.m = this.o;
            this.e = 1;
            return this.m.a(naviLatLng, naviLatLng2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateWalkRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateRideRoute(NaviLatLng naviLatLng) {
        try {
            if (this.n == null) {
                this.n = new jr(this.k);
                this.n.a();
            }
            this.m = this.n;
            this.e = 2;
            return this.m.b(naviLatLng);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateRideRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.n == null) {
                this.n = new jr(this.k);
                this.n.a();
            }
            this.m = this.n;
            this.e = 2;
            return this.m.b(naviLatLng, naviLatLng2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateRideRoute");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setReCalculateRouteForYaw(boolean z) {
        try {
            if (this.m != null) {
                this.m.setReCalculateRouteForYaw(z);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setReCalculateRouteForYaw");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setReCalculateRouteForTrafficJam(boolean z) {
        try {
            if (this.m != null) {
                this.m.setReCalculateRouteForTrafficJam(z);
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "setReCalculateRouteForTrafficJam");
        }
    }

    @Override // com.amap.api.navi.INavi
    public int getEngineType() {
        return this.e;
    }

    @Override // com.amap.api.navi.INavi
    public int getNaviType() {
        return this.f;
    }

    @Override // com.amap.api.navi.INavi
    public NaviInfo getNaviInfo() {
        try {
            if (this.m != null) {
                return this.m.d();
            }
            return null;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviCore", "getNaviInfo");
            return null;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setDetectedMode(int i2) {
        try {
            if (this.m != null) {
                this.m.setDetectedMode(i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviCore", "setDetectedMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void startAimlessMode(int i2) {
        try {
            if (!this.a) {
                if (this.p == null) {
                    this.p = new it(this.k);
                }
                this.m = this.p;
                this.e = 0;
                this.m.startAimlessMode(i2);
                startGPS();
                this.q = true;
                this.a = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviCore", "startAimlessMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopAimlessMode() {
        try {
            if (this.a) {
                if (this.p == null) {
                    this.p = new it(this.k);
                }
                this.m = this.p;
                this.e = 0;
                this.m.stopAimlessMode();
                this.q = false;
                this.a = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviCore", "stopAimlessMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setConnectionTimeout(int i2) {
        if (i2 < 3000) {
            i2 = 3000;
        }
        try {
            ju.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviCore", "setConnectionTimeout");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setSoTimeout(int i2) {
        if (i2 < 3000) {
            i2 = 3000;
        }
        try {
            ju.a(i2);
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNaviCore", "setSoTimeout");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean selectRouteId(int i2) {
        try {
            if (this.e != 0 || this.m == null || this.m.c(i2) == -1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "selectRouteId");
        }
        return false;
    }

    @Override // com.amap.api.navi.INavi
    public boolean isGpsReady() {
        return this.i;
    }

    @Override // com.amap.api.navi.INavi
    public boolean setBroadcastMode(int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            if (this.m == null || !this.m.setBroadcastMode(i2)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNavi", "setBroadcastMode");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void switchParallelRoad() {
        try {
            if (this.m != null) {
                this.m.switchParallelRoad();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNavi", "switchParallelRoad");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean getIsUseExtraGPSData() {
        return this.h;
    }

    @Override // com.amap.api.navi.INavi
    public void setIsUseExtraGPSData(boolean z) {
        try {
            this.h = z;
            if (z) {
                stopGPS();
            } else {
                startGPS();
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "setIsUseExtraGPSData");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setExtraGPSData(int i2, Location location) {
        try {
            if (this.h && location != null) {
                try {
                    a(i2, location);
                } catch (Throwable th) {
                    mj.a(th);
                    rx.c(th, "AMapNaviCore", "setExtraGPSData(int type,Location location)");
                }
            }
        } catch (Throwable th2) {
            rx.c(th2, "AMapNavi", "setExtraGPSData");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setExtraGPSData(Location location) {
        setExtraGPSData(1, location);
    }

    @Override // com.amap.api.col.stln3.jm
    public final void a(Location location) {
        try {
            String str = "AmapNaviCore-->onLocationChanged(int type, Location location),mIsUseExtraGPSData=" + this.h + ",mEngineType=" + this.e;
            if (!this.h) {
                this.i = true;
                if (this.q) {
                    if (this.b == null) {
                        this.b = location;
                    }
                    if (this.b != null && !this.c) {
                        float[] fArr = new float[1];
                        Location.distanceBetween(this.b.getLatitude(), this.b.getLongitude(), location.getLatitude(), location.getLongitude(), fArr);
                        if (fArr[0] > 50.0f) {
                            this.c = true;
                        }
                    }
                }
                a(2, location);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "onLocationChanged");
        }
    }

    private void a(int i2, Location location) {
        try {
            String str = "--->  InternalLocation onLocationChanged " + location.toString();
            this.m.a(i2, location.getLongitude(), location.getLatitude());
            this.m.a(i2, location);
            if (i2 == 1) {
                if (this.t == null) {
                    this.t = new CoordinateConverter(this.k);
                    this.t.from(CoordinateConverter.CoordType.GPS);
                }
                this.t.coord(new LatLng(location.getLatitude(), location.getLongitude()));
                LatLng convert = this.t.convert();
                iu.a(new NaviLatLng(convert.latitude, convert.longitude));
            } else {
                iu.a(new NaviLatLng(location.getLatitude(), location.getLongitude()));
            }
            iu.a(location.getAccuracy(), location.getAltitude());
            if (location.getTime() != this.d) {
                b();
                this.d = location.getTime();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            rx.c(th, "AMapNavi", "setLocation");
        }
    }

    private void b() {
        try {
            this.w = System.currentTimeMillis();
            this.v = false;
            a(this.v);
            this.x.removeMessages(GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO);
            this.x.removeMessages(GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME);
            this.x.removeMessages(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
            Message obtainMessage = this.x.obtainMessage();
            obtainMessage.what = GLMapStaticValue.AM_CALLBACK_CHANGEMAPLOGO;
            this.x.sendMessageDelayed(obtainMessage, 10000);
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "gpsCallbackSendMessage");
        }
    }

    private void a(boolean z) {
        try {
            this.i = !z;
            if (this.u && this.m != null && this.m.t() != null) {
                this.m.t().obtainMessage(36, Boolean.valueOf(z)).sendToTarget();
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "sendGPSWeakStatusMessage");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setUseInnerVoice(boolean z, boolean z2) {
        try {
            this.r = z;
            ly.a(this.k, "use_inner_voice", z);
            mj.a(false);
            me.a(z2);
            me.b(z);
            if (z) {
                addAMapNaviListener(this.s);
            } else {
                removeAMapNaviListener(this.s);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "setUseInnerVoice");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean getIsUseInnerVoice() {
        return this.r;
    }

    @Override // com.amap.api.navi.INavi
    public void setUseInnerVoice(boolean z) {
        setUseInnerVoice(z, false);
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(String str, String str2, List<String> list, int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            return this.m.a(str, str2, list, i2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviCore", "calculateDriveRoute2");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(String str, List<String> list, int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            return this.m.a(str, list, i2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviCore", "calculateDriveRoute3");
            return false;
        }
    }

    public final boolean a() {
        return this.q;
    }

    @Override // com.amap.api.navi.INavi
    public void setSoundQuality(SoundQuality soundQuality) {
        try {
            if (this.s != null) {
                if (SoundQuality.High_Quality == soundQuality) {
                    this.s.a(VoiceRecorder.SAMPLE_RATE);
                }
                if (SoundQuality.Low_Quality == soundQuality) {
                    this.s.a(8000);
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNaviCore", "setSoundQuality");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setMultipleRouteNaviMode(boolean z) {
        try {
            if (!this.q) {
                this.m.a(z);
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNaviCore", "setMultipleRouteNaviMode");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void selectMainPathID(long j2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            this.m.b(j2);
        } catch (Throwable th) {
            rx.c(th, "AMapNaviCore", "selectMainPathID");
        }
    }

    @Override // com.amap.api.navi.INavi
    public boolean calculateDriveRoute(Poi poi, Poi poi2, List<Poi> list, int i2) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.m = this.p;
            this.e = 0;
            return this.m.a(poi, poi2, list, i2);
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "AMapNavi", "calculateDriveRoute4");
            return false;
        }
    }

    @Override // com.amap.api.navi.INavi
    public void stopSpeak() {
        try {
            if (this.s != null) {
                this.s.a();
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "stopSpeak");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void startSpeak() {
        try {
            if (this.s != null) {
                this.s.b();
            }
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "startSpeak");
        }
    }

    @Override // com.amap.api.navi.INavi
    public void setAMapNaviOnlineCarHailingType(AMapNaviOnlineCarHailingType aMapNaviOnlineCarHailingType) {
        try {
            if (this.p == null) {
                this.p = new it(this.k);
            }
            this.p.a(aMapNaviOnlineCarHailingType);
        } catch (Throwable th) {
            rx.c(th, "AMapNavi", "setAMapNaviOnlineCarHailingType");
        }
    }
}
