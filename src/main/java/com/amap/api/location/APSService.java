package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.stln3.bq;
import com.amap.api.col.stln3.rk;
import com.amap.api.col.stln3.sk;
import com.amap.api.col.stln3.vu;
import com.amap.api.col.stln3.vx;
import com.amap.api.col.stln3.wa;
import com.amap.api.col.stln3.wc;

public class APSService extends Service {
    APSServiceBase a;
    int b = 0;
    boolean c = false;

    public IBinder onBind(Intent intent) {
        try {
            return this.a.onBind(intent);
        } catch (Throwable th) {
            vu.a(th, "APSService", "onBind");
            return null;
        }
    }

    public void onCreate() {
        try {
            if (wa.d(this)) {
                this.a = (APSServiceBase) sk.a(this, vu.b(), rk.c("AY29tLmFtYXAuYXBpLmxvY2F0aW9uLkFQU1NlcnZpY2VXcmFwcGVy"), bq.class, new Class[]{Context.class}, new Object[]{this});
            } else if (this.a == null) {
                this.a = new bq(this);
            }
        } catch (Throwable th) {
        }
        try {
            if (this.a == null) {
                this.a = new bq(this);
            }
            this.a.onCreate();
        } catch (Throwable th2) {
            vu.a(th2, "APSService", "onCreate");
        }
        super.onCreate();
    }

    private boolean a() {
        if (wc.j(getApplicationContext())) {
            int i = -1;
            try {
                i = vx.b(getApplication().getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable th) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                if (a()) {
                    int intExtra = intent.getIntExtra("g", 0);
                    if (intExtra == 1) {
                        int intExtra2 = intent.getIntExtra("i", 0);
                        Notification notification = (Notification) intent.getParcelableExtra("h");
                        if (!(intExtra2 == 0 || notification == null)) {
                            startForeground(intExtra2, notification);
                            this.c = true;
                            this.b++;
                        }
                    } else if (intExtra == 2) {
                        if (intent.getBooleanExtra("j", true)) {
                            if (this.b > 0) {
                                this.b--;
                            }
                        }
                        if (this.b <= 0) {
                            stopForeground(true);
                            this.c = false;
                        } else {
                            stopForeground(false);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        try {
            return this.a.onStartCommand(intent, i, i2);
        } catch (Throwable th2) {
            vu.a(th2, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }

    public void onDestroy() {
        try {
            this.a.onDestroy();
            if (this.c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            vu.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }
}
