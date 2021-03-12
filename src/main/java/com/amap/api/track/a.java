package com.amap.api.track;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.col.stln3.qr;
import com.amap.api.track.ErrorCode;
import com.amap.api.track.b;
import com.amap.api.track.d;
import com.amap.api.track.e;
import com.amap.api.track.query.model.AddTerminalRequest;
import com.amap.api.track.query.model.AddTrackRequest;
import com.amap.api.track.query.model.DistanceRequest;
import com.amap.api.track.query.model.HistoryTrackRequest;
import com.amap.api.track.query.model.LatestPointRequest;
import com.amap.api.track.query.model.OnTrackListener;
import com.amap.api.track.query.model.ParamErrorResponse;
import com.amap.api.track.query.model.QueryTerminalRequest;
import com.amap.api.track.query.model.QueryTrackRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: AMapTrackClientCore */
final class a {
    f a = f.a();
    private e b;
    private WeakReference<Context> c;
    private ServiceConnection d;
    private int e;
    private HashMap<OnTrackLifecycleListener, BinderC0003a> f = new HashMap<>();

    public a(Context context) {
        if (context != null) {
            this.c = new WeakReference<>(context);
        }
    }

    public final void a(int i) {
        this.a.a(i);
        e eVar = this.b;
        if (eVar != null) {
            try {
                eVar.a(i);
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final void a(int i, int i2) {
        this.a.a(i, i2);
        e eVar = this.b;
        if (eVar != null) {
            try {
                eVar.a(i, i2);
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final void b(int i) {
        this.a.b(i);
        e eVar = this.b;
        if (eVar != null) {
            try {
                eVar.b(i);
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final void a(OnTrackLifecycleListener onTrackLifecycleListener) {
        if (this.b != null) {
            try {
                this.b.c(d(onTrackLifecycleListener));
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final void c(int i) {
        this.a.c(i);
        this.e = i;
        e eVar = this.b;
        if (eVar != null) {
            try {
                eVar.c(i);
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final void a(final TrackParam trackParam, final OnTrackLifecycleListener onTrackLifecycleListener) {
        if (trackParam == null || b()) {
            if (onTrackLifecycleListener != null) {
                onTrackLifecycleListener.onStartTrackCallback(2018, ErrorCode.TrackListen.START_TRACK_TRACK_IS_INVALID_MSG);
            }
        } else if (!trackParam.isServiceValid()) {
            if (onTrackLifecycleListener != null) {
                onTrackLifecycleListener.onStartTrackCallback(2019, ErrorCode.TrackListen.START_TRACK_SERVICE_IS_INVALID_MSG);
            }
        } else if (trackParam.isTerminalValid()) {
            final d d2 = d(onTrackLifecycleListener);
            e eVar = this.b;
            if (eVar != null) {
                try {
                    eVar.a(trackParam, this.a, this.a.b(), d2);
                    return;
                } catch (RemoteException e2) {
                    qr.a("AMapTrackClientCore RemoteException " + e2);
                    if (onTrackLifecycleListener != null) {
                        onTrackLifecycleListener.onStartGatherCallback(ErrorCode.TrackListen.REMOTE_EX, ErrorCode.TrackListen.REMOTE_EX_MSG);
                    }
                }
            }
            this.d = new ServiceConnection() {
                /* class com.amap.api.track.a.AnonymousClass1 */

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.b = e.a.a(iBinder);
                    if (a.this.b == null) {
                        qr.a("ITrackService is null");
                        return;
                    }
                    OnTrackLifecycleListener onTrackLifecycleListener = onTrackLifecycleListener;
                    if (onTrackLifecycleListener != null) {
                        onTrackLifecycleListener.onBindServiceCallback(2001, ErrorCode.TrackListen.BIND_SUCCESS_MSG);
                    }
                    try {
                        a.this.b.a(trackParam, a.this.a, a.this.a.b(), d2);
                    } catch (RemoteException e) {
                        qr.a("MonitorServiceUtil start service " + e);
                        OnTrackLifecycleListener onTrackLifecycleListener2 = onTrackLifecycleListener;
                        if (onTrackLifecycleListener2 != null) {
                            onTrackLifecycleListener2.onStartGatherCallback(ErrorCode.TrackListen.REMOTE_EX, ErrorCode.TrackListen.REMOTE_EX_MSG);
                        }
                    }
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    a.this.b = null;
                }
            };
            if (!b()) {
                Context context = this.c.get();
                context.bindService(new Intent(context, AMapTrackService.class), this.d, 1);
            }
        } else if (onTrackLifecycleListener != null) {
            onTrackLifecycleListener.onStartTrackCallback(2020, ErrorCode.TrackListen.START_TRACK_TERMINAL_IS_INVALID_MSG);
        }
    }

    public final void b(OnTrackLifecycleListener onTrackLifecycleListener) {
        if (this.b != null) {
            try {
                this.b.a(d(onTrackLifecycleListener));
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
                if (onTrackLifecycleListener != null) {
                    onTrackLifecycleListener.onStartGatherCallback(ErrorCode.TrackListen.REMOTE_EX, ErrorCode.TrackListen.REMOTE_EX_MSG);
                }
            }
        } else if (onTrackLifecycleListener != null) {
            onTrackLifecycleListener.onStartGatherCallback(2003, ErrorCode.TrackListen.SERVICE_NOT_STARTED_MSG);
        }
    }

    public final void c(OnTrackLifecycleListener onTrackLifecycleListener) {
        if (this.b != null) {
            try {
                this.b.b(d(onTrackLifecycleListener));
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
                if (onTrackLifecycleListener != null) {
                    onTrackLifecycleListener.onStopGatherCallback(ErrorCode.TrackListen.REMOTE_EX, ErrorCode.TrackListen.REMOTE_EX_MSG);
                }
            }
        } else if (onTrackLifecycleListener != null) {
            onTrackLifecycleListener.onStopGatherCallback(2003, ErrorCode.TrackListen.SERVICE_NOT_STARTED_MSG);
        }
    }

    public final void a(long j) {
        e eVar = this.b;
        if (eVar != null) {
            try {
                eVar.a(j);
            } catch (Exception e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
            }
        }
    }

    public final long a() {
        e eVar = this.b;
        if (eVar == null) {
            return -1;
        }
        try {
            return eVar.a();
        } catch (Exception e2) {
            qr.a("AMapTrackClientCore RemoteException " + e2);
            return -1;
        }
    }

    public final void b(TrackParam trackParam, OnTrackLifecycleListener onTrackLifecycleListener) {
        ServiceConnection serviceConnection;
        if (this.b != null) {
            try {
                this.b.a(trackParam, d(onTrackLifecycleListener));
                this.b = null;
            } catch (RemoteException e2) {
                qr.a("AMapTrackClientCore RemoteException " + e2);
                if (onTrackLifecycleListener != null) {
                    onTrackLifecycleListener.onStopTrackCallback(ErrorCode.TrackListen.REMOTE_EX, ErrorCode.TrackListen.REMOTE_EX_MSG);
                }
            }
            Context context = this.c.get();
            if (context != null && (serviceConnection = this.d) != null) {
                context.unbindService(serviceConnection);
            }
        } else if (onTrackLifecycleListener != null) {
            onTrackLifecycleListener.onStopTrackCallback(2003, ErrorCode.TrackListen.SERVICE_NOT_STARTED_MSG);
        }
    }

    private d d(OnTrackLifecycleListener onTrackLifecycleListener) {
        BinderC0003a aVar;
        if (onTrackLifecycleListener == null) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(onTrackLifecycleListener);
            if (aVar == null) {
                aVar = new BinderC0003a(onTrackLifecycleListener);
            }
            this.f.put(onTrackLifecycleListener, aVar);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: com.amap.api.track.a$a  reason: collision with other inner class name */
    /* compiled from: AMapTrackClientCore */
    public class BinderC0003a extends d.a {
        private OnTrackLifecycleListener b;
        private final Handler c;

        static /* synthetic */ void a(BinderC0003a aVar, Message message) {
            Bundle bundle = (Bundle) message.obj;
            int i = bundle.getInt("error_code_key");
            String string = bundle.getString("error_msg_key");
            switch (message.what) {
                case 0:
                    aVar.b.onStartTrackCallback(i, string);
                    return;
                case 1:
                    aVar.b.onStartGatherCallback(i, string);
                    return;
                case 2:
                    aVar.b.onStopGatherCallback(i, string);
                    return;
                case 3:
                    aVar.b.onStopTrackCallback(i, string);
                    return;
                default:
                    return;
            }
        }

        public BinderC0003a(OnTrackLifecycleListener onTrackLifecycleListener) {
            this.b = onTrackLifecycleListener;
            this.c = new Handler(a.this) {
                /* class com.amap.api.track.a.BinderC0003a.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    BinderC0003a.a(BinderC0003a.this, message);
                }
            };
        }

        private void a(int i, int i2, String str) {
            if (this.c != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                obtain.what = i;
                bundle.putInt("error_code_key", i2);
                if (str == null) {
                    str = "";
                }
                bundle.putString("error_msg_key", str);
                obtain.obj = bundle;
                this.c.sendMessage(obtain);
            }
        }

        @Override // com.amap.api.track.d
        public final void a(int i, String str) throws RemoteException {
            a(0, i, str);
        }

        @Override // com.amap.api.track.d
        public final void b(int i, String str) throws RemoteException {
            a(3, i, str);
        }

        @Override // com.amap.api.track.d
        public final void c(int i, String str) throws RemoteException {
            a(1, i, str);
        }

        @Override // com.amap.api.track.d
        public final void d(int i, String str) throws RemoteException {
            a(2, i, str);
        }
    }

    private boolean b() {
        WeakReference<Context> weakReference = this.c;
        return weakReference == null || weakReference.get() == null;
    }

    public final void a(QueryTerminalRequest queryTerminalRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), queryTerminalRequest, this.e, onTrackListener);
    }

    public final void a(AddTerminalRequest addTerminalRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), addTerminalRequest, this.e, onTrackListener);
    }

    public final void a(DistanceRequest distanceRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), distanceRequest, this.e, onTrackListener);
    }

    public final void a(LatestPointRequest latestPointRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), latestPointRequest, this.e, onTrackListener);
    }

    public final void a(HistoryTrackRequest historyTrackRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), historyTrackRequest, this.e, onTrackListener);
    }

    public final void a(QueryTrackRequest queryTrackRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), queryTrackRequest, this.e, onTrackListener);
    }

    public final void a(AddTrackRequest addTrackRequest, OnTrackListener onTrackListener) {
        if (b() && onTrackListener != null) {
            onTrackListener.onParamErrorCallback(new ParamErrorResponse("Context is null"));
        }
        b.C0004b.a.a(this.c.get(), addTrackRequest, this.e, onTrackListener);
    }
}
