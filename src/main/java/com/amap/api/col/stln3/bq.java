package com.amap.api.col.stln3;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.amap.api.location.APSServiceBase;

/* compiled from: ApsServiceCore */
public class bq implements APSServiceBase {
    bp a = null;
    Context b = null;
    Messenger c = null;

    public bq(Context context) {
        this.b = context.getApplicationContext();
        this.a = new bp(this.b);
    }

    @Override // com.amap.api.location.APSServiceBase
    public IBinder onBind(Intent intent) {
        this.a.b(intent);
        this.a.a(intent);
        this.c = new Messenger(this.a.b());
        return this.c.getBinder();
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onCreate() {
        try {
            bp.f();
            this.a.j = wc.b();
            this.a.k = wc.a();
            this.a.a();
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "onCreate");
        }
    }

    @Override // com.amap.api.location.APSServiceBase
    public int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onDestroy() {
        try {
            if (this.a != null) {
                this.a.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            vu.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
