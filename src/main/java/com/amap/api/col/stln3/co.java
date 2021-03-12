package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;

/* compiled from: IAMapDelegate */
public interface co extends IAMap {
    float[] A();

    gq B();

    void C();

    int a(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    cx a(BitmapDescriptor bitmapDescriptor);

    cx a(BitmapDescriptor bitmapDescriptor, boolean z);

    LatLngBounds a(LatLng latLng, float f);

    GLMapEngine a();

    void a(double d, double d2, FPoint fPoint);

    void a(double d, double d2, IPoint iPoint);

    void a(float f, float f2, IPoint iPoint);

    void a(int i);

    void a(int i, float f);

    void a(int i, int i2);

    void a(int i, int i2, PointF pointF);

    void a(int i, int i2, DPoint dPoint);

    void a(int i, int i2, FPoint fPoint);

    void a(int i, int i2, IPoint iPoint);

    void a(int i, MotionEvent motionEvent);

    void a(int i, AbstractGestureMapMessage abstractGestureMapMessage);

    void a(Location location) throws RemoteException;

    void a(cg cgVar) throws RemoteException;

    void a(cx cxVar);

    void a(AMapWidgetListener aMapWidgetListener);

    void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void a(IPoint iPoint);

    void a(String str, boolean z, int i);

    void a(boolean z);

    void a(boolean z, boolean z2);

    void a(boolean z, byte[] bArr);

    boolean a(MotionEvent motionEvent);

    boolean a(String str) throws RemoteException;

    float b();

    void b(double d, double d2, IPoint iPoint);

    void b(int i, int i2, DPoint dPoint);

    void b(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void b(boolean z);

    boolean b(int i);

    boolean b(MotionEvent motionEvent);

    boolean b(String str);

    int c(int i);

    void c();

    void c(String str);

    void c(boolean z);

    String d(String str);

    void d(int i);

    void d(boolean z);

    boolean d();

    float e(int i);

    void e();

    void e(boolean z);

    GLMapState f();

    void f(int i);

    void f(boolean z);

    int g();

    void g(int i);

    void g(boolean z);

    int h();

    void h(int i);

    float i(int i);

    void i();

    float j();

    cr k();

    gp k(int i);

    float l(int i);

    void l();

    void m();

    boolean n();

    Point o();

    View p();

    boolean q();

    int r();

    int s();

    float u();

    float v();

    void w();

    float x();

    Context y();

    void z();
}
