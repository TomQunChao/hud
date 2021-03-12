package com.amap.api.col.stln3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;

/* compiled from: SensorEventHelper */
public final class da implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private long c = 0;
    private float d;
    private Context e;
    private co f;
    private Marker g;
    private boolean h = true;

    public da(Context context, co coVar) {
        this.e = context.getApplicationContext();
        this.f = coVar;
        try {
            this.a = (SensorManager) context.getSystemService("sensor");
            if (this.a != null) {
                this.b = this.a.getDefaultSensor(3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
    }

    public final void b() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    public final void a(Marker marker) {
        this.g = marker;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        WindowManager windowManager;
        try {
            if (System.currentTimeMillis() - this.c >= 100) {
                if (this.f.a() != null && this.f.a().getAnimateionsCount() > 0) {
                    return;
                }
                if (sensorEvent.sensor.getType() == 3) {
                    int i = 0;
                    float f2 = sensorEvent.values[0];
                    Context context = this.e;
                    if (!(context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null)) {
                        switch (windowManager.getDefaultDisplay().getRotation()) {
                            case 1:
                                i = 90;
                                break;
                            case 2:
                                i = 180;
                                break;
                            case 3:
                                i = -90;
                                break;
                        }
                    }
                    float f3 = (f2 + ((float) i)) % 360.0f;
                    if (f3 > 180.0f) {
                        f3 -= 360.0f;
                    } else if (f3 < -180.0f) {
                        f3 += 360.0f;
                    }
                    if (Math.abs(this.d - f3) >= 3.0f) {
                        if (Float.isNaN(f3)) {
                            f3 = 0.0f;
                        }
                        this.d = f3;
                        if (this.g != null) {
                            try {
                                if (this.h) {
                                    this.f.a(dh.c(this.d));
                                    this.g.setRotateAngle(-this.d);
                                } else {
                                    this.g.setRotateAngle(360.0f - this.d);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        this.c = System.currentTimeMillis();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
