package com.amap.api.col.stln3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: NaviSensorHelper */
public final class jq {
    long a = 0;
    boolean b = false;
    private Context c;
    private Sensor d;
    private SensorManager e;
    private HandlerThread f;
    private a g;
    private float h = 0.0f;
    private int i = 0;
    private boolean j = false;
    private SensorEventListener k = new SensorEventListener() {
        /* class com.amap.api.col.stln3.jq.AnonymousClass1 */

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            if (System.currentTimeMillis() - jq.this.a > 100) {
                jq.this.a = System.currentTimeMillis();
                jq.this.h = f;
                jq.this.j = true;
                if (jq.this.g != null) {
                    a aVar = jq.this.g;
                    boolean z = jq.this.j;
                    int unused = jq.this.i;
                    aVar.a(z, jq.this.h);
                }
                String str = ",lastDirection=" + jq.this.h + ",lastAccuracy=" + jq.this.i;
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            if (sensor.getType() == 3) {
                jq.this.i = i;
            }
        }
    };

    /* compiled from: NaviSensorHelper */
    public interface a {
        void a(boolean z, float f);
    }

    public jq(Context context) {
        this.c = context;
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a() {
        try {
            if (!this.b) {
                if (this.e == null) {
                    this.e = (SensorManager) this.c.getSystemService("sensor");
                }
                if (this.d == null) {
                    this.d = this.e.getDefaultSensor(3);
                }
                if (this.f == null) {
                    this.f = new HandlerThread(getClass().getName() + "_NaviSensorThread");
                    this.f.start();
                }
                this.e.registerListener(this.k, this.d, 1, new Handler(this.f.getLooper()));
                this.b = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            this.d = null;
            if (this.e != null) {
                this.e.unregisterListener(this.k);
                this.e = null;
            }
            if (this.f != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f.quitSafely();
                } else {
                    this.f.quit();
                }
                this.f = null;
            }
            this.j = false;
            this.b = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
