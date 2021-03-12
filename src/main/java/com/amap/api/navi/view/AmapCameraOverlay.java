package com.amap.api.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.widget.TextView;
import com.a11hud.www.R;
import com.amap.api.col.stln3.mj;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.rx;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class AmapCameraOverlay {
    boolean isRouteOverlayVisible = true;
    private boolean isVisible = true;
    private BitmapDescriptor mBusLeftIcon = null;
    private BitmapDescriptor mBusRightIcon = null;
    private BitmapDescriptor mCameraIcon = null;
    private BitmapDescriptor mCameraLeftIcon = null;
    private BitmapDescriptor mCameraRightIcon = null;
    private Context mContext;
    private boolean mLastFlag = false;
    private BitmapDescriptor mRedLeftIcon = null;
    private BitmapDescriptor mRedRightIcon = null;
    private Bitmap mSpeedLeftIcon = null;
    private Bitmap mSpeedRightIcon = null;
    private BitmapDescriptor mYingjiLeftIcon = null;
    private BitmapDescriptor mYingjiRightIcon = null;
    private Map<String, List<Marker>> markerMap = new HashMap();

    public AmapCameraOverlay(Context context) {
        try {
            this.mCameraIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.arrowHeadLength));
            this.mBusLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.buttonPanelSideLayout));
            this.mBusRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.buttonStyle));
            this.mCameraLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.buttonStyleSmall));
            this.mCameraRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.buttonTint));
            this.mYingjiLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.buttonTintMode));
            this.mYingjiRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.chainUseRtl));
            this.mRedLeftIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.checkboxStyle));
            this.mRedRightIcon = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mm.a(), R.attr.checkedTextViewStyle));
            this.mSpeedRightIcon = BitmapFactory.decodeResource(mm.a(), R.attr.closeItemLayout);
            this.mSpeedLeftIcon = BitmapFactory.decodeResource(mm.a(), R.attr.closeIcon);
            this.mContext = context;
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "CameraOverlay", "CameraOverlay()");
        }
    }

    public void draw(AMap aMap, AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
        int i;
        boolean z;
        float f;
        int i2;
        int i3;
        int i4;
        try {
            if (this.isRouteOverlayVisible) {
                boolean z2 = false;
                int i5 = 0;
                while (aMapNaviCameraInfoArr != null && i5 < aMapNaviCameraInfoArr.length) {
                    AMapNaviCameraInfo aMapNaviCameraInfo = aMapNaviCameraInfoArr[i5];
                    if ((aMapNaviCameraInfo.getCameraType() != 0 || aMapNaviCameraInfo.getCameraSpeed() != 0) && aMap != null) {
                        String str = aMapNaviCameraInfo.getX() + "-" + aMapNaviCameraInfo.getCameraType() + "-" + aMapNaviCameraInfo.getY();
                        if (this.markerMap.keySet().contains(str)) {
                            String str2 = "key 包含在 map 中,距离摄像头:" + aMapNaviCameraInfo.getCameraDistance() + "米";
                            i = i5;
                        } else {
                            if (this.mLastFlag) {
                                this.mLastFlag = z2;
                                z = false;
                            } else {
                                this.mLastFlag = true;
                                z = true;
                            }
                            ArrayList arrayList = new ArrayList();
                            int cameraType = aMapNaviCameraInfo.getCameraType();
                            if (z) {
                                f = 1.0f;
                            } else {
                                f = 0.0f;
                            }
                            i = i5;
                            Marker addMarker = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(0.5f, 0.5f).icon(this.mCameraIcon));
                            addMarker.setVisible(this.isVisible);
                            arrayList.add(addMarker);
                            String str3 = "key 不包含在 map 中,摄像头类型=" + cameraType + ",距离:" + aMapNaviCameraInfo.getCameraDistance();
                            switch (cameraType) {
                                case 0:
                                    TextView textView = new TextView(this.mContext);
                                    textView.setTextColor(SupportMenu.CATEGORY_MASK);
                                    textView.setGravity(49);
                                    int cameraSpeed = aMapNaviCameraInfo.getCameraSpeed();
                                    if (cameraSpeed > 99) {
                                        textView.setTextSize(1, 17.0f);
                                        i2 = mj.a(this.mContext, 10);
                                    } else {
                                        textView.setTextSize(1, 20.0f);
                                        i2 = mj.a(this.mContext, 8);
                                    }
                                    if (z) {
                                        i3 = mj.a(this.mContext, 3);
                                        i4 = 0;
                                    } else {
                                        i4 = mj.a(this.mContext, 3);
                                        i3 = 0;
                                    }
                                    textView.setPadding(i4, i2, i3, 0);
                                    textView.setText(String.valueOf(cameraSpeed));
                                    Bitmap bitmap = z ? this.mSpeedLeftIcon : this.mSpeedRightIcon;
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        textView.setBackground(new BitmapDrawable(mm.a(), bitmap));
                                    } else {
                                        textView.setBackgroundDrawable(new BitmapDrawable(mm.a(), bitmap));
                                    }
                                    Marker addMarker2 = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(f, 0.7f).icon(BitmapDescriptorFactory.fromView(textView)));
                                    addMarker2.setVisible(this.isVisible);
                                    arrayList.add(addMarker2);
                                    break;
                                case 1:
                                case 3:
                                    Marker addMarker3 = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(f, 0.7f).icon(z ? this.mCameraLeftIcon : this.mCameraRightIcon));
                                    addMarker3.setVisible(this.isVisible);
                                    arrayList.add(addMarker3);
                                    break;
                                case 2:
                                    Marker addMarker4 = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(f, 0.7f).icon(z ? this.mRedLeftIcon : this.mRedRightIcon));
                                    addMarker4.setVisible(this.isVisible);
                                    arrayList.add(addMarker4);
                                    break;
                                case 4:
                                    Marker addMarker5 = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(f, 0.7f).icon(z ? this.mBusLeftIcon : this.mBusRightIcon));
                                    addMarker5.setVisible(this.isVisible);
                                    arrayList.add(addMarker5);
                                    break;
                                case 5:
                                    Marker addMarker6 = aMap.addMarker(new MarkerOptions().position(new LatLng(aMapNaviCameraInfo.getY(), aMapNaviCameraInfo.getX())).anchor(f, 0.7f).icon(z ? this.mYingjiLeftIcon : this.mYingjiRightIcon));
                                    addMarker6.setVisible(this.isVisible);
                                    arrayList.add(addMarker6);
                                    break;
                            }
                            this.markerMap.put(str, arrayList);
                        }
                        i5 = i + 1;
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (this.markerMap != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry<String, List<Marker>> entry : this.markerMap.entrySet()) {
                        int i6 = 0;
                        boolean z3 = false;
                        while (aMapNaviCameraInfoArr != null && i6 < aMapNaviCameraInfoArr.length) {
                            AMapNaviCameraInfo aMapNaviCameraInfo2 = aMapNaviCameraInfoArr[i6];
                            if ((aMapNaviCameraInfo2.getX() + "-" + aMapNaviCameraInfo2.getCameraType() + "-" + aMapNaviCameraInfo2.getY()).equals(entry.getKey())) {
                                z3 = true;
                            }
                            i6++;
                        }
                        if (!z3) {
                            List<Marker> value = entry.getValue();
                            arrayList2.add(entry.getKey());
                            for (int i7 = 0; i7 < value.size(); i7++) {
                                value.get(i7).remove();
                            }
                            value.clear();
                        }
                    }
                    for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                        this.markerMap.remove(arrayList2.get(i8));
                    }
                }
            }
        } catch (Throwable th) {
            mj.a(th);
            rx.c(th, "CameraOverlay", "draw(AMap aMap, LatLng latLng)");
        }
    }

    public void removeAllCamera() {
        try {
            if (this.markerMap != null) {
                for (Map.Entry<String, List<Marker>> entry : this.markerMap.entrySet()) {
                    List<Marker> value = entry.getValue();
                    for (int i = 0; i < value.size(); i++) {
                        value.get(i).remove();
                    }
                    value.clear();
                }
                this.markerMap.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRouteOverlayVisible(boolean z) {
        this.isRouteOverlayVisible = z;
    }

    public void setAllCameraVisible(boolean z) {
        this.isVisible = z;
        try {
            if (this.markerMap != null) {
                for (Map.Entry<String, List<Marker>> entry : this.markerMap.entrySet()) {
                    List<Marker> value = entry.getValue();
                    for (int i = 0; i < value.size(); i++) {
                        value.get(i).setVisible(z);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.markerMap != null) {
                removeAllCamera();
                this.markerMap.clear();
            }
            if (this.mCameraIcon != null) {
                this.mCameraIcon.recycle();
            }
            if (this.mBusLeftIcon != null) {
                this.mBusLeftIcon.recycle();
                this.mBusLeftIcon = null;
            }
            if (this.mBusRightIcon != null) {
                this.mBusRightIcon.recycle();
                this.mBusRightIcon = null;
            }
            if (this.mCameraRightIcon != null) {
                this.mCameraRightIcon.recycle();
                this.mCameraRightIcon = null;
            }
            if (this.mCameraLeftIcon != null) {
                this.mCameraLeftIcon.recycle();
                this.mCameraLeftIcon = null;
            }
            if (this.mYingjiRightIcon != null) {
                this.mYingjiRightIcon.recycle();
                this.mYingjiRightIcon = null;
            }
            if (this.mYingjiLeftIcon != null) {
                this.mYingjiLeftIcon.recycle();
                this.mYingjiLeftIcon = null;
            }
            if (this.mRedRightIcon != null) {
                this.mRedRightIcon.recycle();
                this.mRedRightIcon = null;
            }
            if (this.mRedLeftIcon != null) {
                this.mRedLeftIcon.recycle();
                this.mRedLeftIcon = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCameraBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.mCameraIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setBusBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            try {
                this.mBusLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (bitmap2 != null) {
            this.mBusRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setCameraMoniterBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            this.mCameraLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
        }
        if (bitmap2 != null) {
            this.mCameraRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setEmergencyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            this.mYingjiLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
        }
        if (bitmap2 != null) {
            this.mYingjiRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }

    public void setRedLightBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null) {
            try {
                this.mRedLeftIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (bitmap2 != null) {
            this.mRedRightIcon = BitmapDescriptorFactory.fromBitmap(bitmap2);
        }
    }
}
