package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Inputtips */
public final class ld {
    private lg a = null;

    /* compiled from: Inputtips */
    public interface a {
        void a(List<lw> list, int i);
    }

    public ld(Context context, lf lfVar) {
        if (this.a == null) {
            try {
                this.a = new lg(context, lfVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(a aVar) {
        lg lgVar = this.a;
        if (lgVar != null) {
            lgVar.a(aVar);
        }
    }

    public final void a() {
        lg lgVar = this.a;
        if (lgVar != null) {
            try {
                jg.a().execute(new Runnable() {
                    /* class com.amap.api.col.stln3.lg.AnonymousClass1 */

                    public final void run() {
                        try {
                            Message obtainMessage = lj.a().obtainMessage();
                            obtainMessage.obj = lg.this.b;
                            obtainMessage.arg1 = 5;
                            try {
                                ArrayList<? extends Parcelable> a2 = lg.this.a((lg) lg.this.d);
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("result", a2);
                                obtainMessage.setData(bundle);
                                obtainMessage.what = 1000;
                            } catch (kv e) {
                                obtainMessage.what = e.b();
                            } finally {
                                lg.this.c.sendMessage(obtainMessage);
                            }
                        } catch (Throwable th) {
                        }
                    }
                });
            } catch (Throwable th) {
            }
        }
    }
}
