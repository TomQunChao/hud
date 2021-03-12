package com.amap.api.col.stln3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* compiled from: AMapMessageHandler */
public final class ca implements Handler.Callback {
    private Map<Integer, cw> a = new Hashtable();
    private Handler b;
    private HandlerThread c;
    private bw d;
    private boolean e = false;

    public ca(bw bwVar) {
        this.d = bwVar;
        this.c = new HandlerThread("AMapMessageHandler");
        this.c.start();
        this.b = new Handler(this.c.getLooper(), this);
        this.e = false;
    }

    public final boolean handleMessage(Message message) {
        try {
            if (this.e || message == null) {
                return false;
            }
            cw cwVar = (cw) message.obj;
            int i = message.what;
            if (i == 1) {
                this.d.j(((Integer) cwVar.b).intValue());
            } else if (i == 153) {
                synchronized (this.a) {
                    Set<Integer> keySet = this.a.keySet();
                    if (keySet.size() > 0) {
                        for (Integer num : keySet) {
                            cw remove = this.a.remove(num);
                            this.b.obtainMessage(remove.a, remove).sendToTarget();
                        }
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(cw cwVar) {
        try {
            if (!this.e && cwVar != null) {
                int i = cwVar.a;
                if (cwVar.a != 153) {
                    synchronized (this.a) {
                        if (i < 33) {
                            this.a.put(Integer.valueOf(i), cwVar);
                        }
                    }
                } else if (this.a != null && this.a.size() > 0) {
                    this.b.obtainMessage(153).sendToTarget();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        this.e = true;
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
