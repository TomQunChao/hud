package com.amap.api.col.stln3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* compiled from: MapFragmentDelegateImp */
public class ct implements IMapFragmentDelegate {
    public static volatile Context a;
    public int b = 0;
    private IAMap c;
    private int d = 0;
    private AMapOptions e;

    public ct(int i) {
        this.d = i % 3;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setContext(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions aMapOptions) {
        this.e = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public IAMap getMap() throws RemoteException {
        if (this.c == null) {
            if (a == null) {
                return null;
            }
            int i = a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                ch.a = 0.5f;
            } else if (i <= 160) {
                ch.a = 0.8f;
            } else if (i <= 240) {
                ch.a = 0.87f;
            } else if (i <= 320) {
                ch.a = 1.0f;
            } else if (i <= 480) {
                ch.a = 1.5f;
            } else if (i <= 640) {
                ch.a = 1.8f;
            } else {
                ch.a = 0.9f;
            }
            int i2 = this.d;
            if (i2 == 0) {
                this.c = new by(a).a();
            } else if (i2 == 1) {
                this.c = new bz(a).a();
            } else {
                this.c = new bx(a).a();
            }
        }
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.e = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        if (a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            this.c = getMap();
            this.c.setVisibilityEx(this.b);
            if (this.e == null && bundle != null) {
                byte[] byteArray = bundle.getByteArray("MAP_OPTIONS");
                if (byteArray != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(byteArray, 0, byteArray.length);
                    obtain.setDataPosition(0);
                    this.e = AMapOptions.CREATOR.createFromParcel(obtain);
                }
            }
            AMapOptions aMapOptions = this.e;
            if (!(aMapOptions == null || this.c == null)) {
                CameraPosition camera = aMapOptions.getCamera();
                if (camera != null) {
                    this.c.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
                }
                UiSettings aMapUiSettings = this.c.getAMapUiSettings();
                aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
                aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
                aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
                aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
                aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
                aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
                aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
                aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
                this.c.setMapType(aMapOptions.getMapType());
                this.c.setZOrderOnTop(aMapOptions.getZOrderOnTop());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.c.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onResume() throws RemoteException {
        IAMap iAMap = this.c;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onPause() throws RemoteException {
        IAMap iAMap = this.c;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroy() throws RemoteException {
        IAMap iAMap = this.c;
        if (iAMap != null) {
            iAMap.clear();
            this.c.destroy();
            this.c = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onLowMemory() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.c != null) {
            if (this.e == null) {
                this.e = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                this.e = this.e.camera(getMap().getCameraPosition());
                this.e.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setVisibility(int i) {
        this.b = i;
        IAMap iAMap = this.c;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i);
        }
    }
}
