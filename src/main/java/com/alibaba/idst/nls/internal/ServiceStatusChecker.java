package com.alibaba.idst.nls.internal;

import android.content.Context;
import com.alibaba.idst.nls.internal.common.Codecs;
import com.alibaba.idst.nls.internal.common.DeviceId;
import com.nlspeech.nlscodec.NlsCodec2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServiceStatusChecker {
    private static final int MIN_CHECK_INTERVAL = 300000;
    private static AtomicBoolean sIsChecking = new AtomicBoolean(false);
    private static boolean sIsRpcAvailable = false;
    private static boolean sIsSerivceAvailable = true;
    private static long sLastCheckTime = 0;
    private static List<ServiceStatusListener> sPendingListeners = new ArrayList();

    public interface ServiceStatusListener {
        void onServiceStatus(boolean z, boolean z2);
    }

    public static void check(ServiceStatusListener serviceStatusListener, Context context) {
        doCheck(serviceStatusListener, context);
    }

    public static long getLastCheckTime() {
        return sLastCheckTime;
    }

    public static boolean isServiceAvailable() {
        return sIsSerivceAvailable;
    }

    public static boolean isRpcAvailable() {
        return sIsRpcAvailable;
    }

    public static void setServiceCheckUrl(String str) {
    }

    private static void doCheck(final ServiceStatusListener serviceStatusListener, final Context context) {
        new Thread("ServiceStatusCheckerThread") {
            /* class com.alibaba.idst.nls.internal.ServiceStatusChecker.AnonymousClass1 */

            public final void run() {
                NlsCodec2.getInstance();
                boolean z = true;
                if (!ServiceStatusChecker.sIsChecking.compareAndSet(false, true)) {
                    synchronized (ServiceStatusChecker.sPendingListeners) {
                        if (serviceStatusListener != null) {
                            ServiceStatusChecker.sPendingListeners.add(serviceStatusListener);
                        }
                    }
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ServiceStatusChecker.sLastCheckTime < 300000) {
                    ServiceStatusListener serviceStatusListener = serviceStatusListener;
                    if (serviceStatusListener != null) {
                        serviceStatusListener.onServiceStatus(ServiceStatusChecker.sIsSerivceAvailable, ServiceStatusChecker.sIsRpcAvailable);
                    }
                    ServiceStatusChecker.sIsChecking.set(false);
                    return;
                }
                long unused = ServiceStatusChecker.sLastCheckTime = currentTimeMillis;
                CheckStatus serviceStatus = ServiceStatusChecker.getServiceStatus();
                byte[] bArr = new byte[0];
                try {
                    bArr = DeviceId.getDeviceId(context).getBytes();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int i = 0;
                for (byte b : bArr) {
                    i ^= b;
                }
                boolean unused2 = ServiceStatusChecker.sIsSerivceAvailable = ServiceStatusChecker.calcAvailability(i, serviceStatus.streamStatus) && NlsCodec2.getInstance().isAvailable() && Codecs.getInstanse().isAvailable();
                if (!ServiceStatusChecker.calcAvailability(i, serviceStatus.rpcStatus) || !NlsCodec2.getInstance().isAvailable() || !Codecs.getInstanse().isAvailable()) {
                    z = false;
                }
                boolean unused3 = ServiceStatusChecker.sIsRpcAvailable = z;
                ServiceStatusListener serviceStatusListener2 = serviceStatusListener;
                if (serviceStatusListener2 != null) {
                    serviceStatusListener2.onServiceStatus(ServiceStatusChecker.sIsSerivceAvailable, ServiceStatusChecker.sIsRpcAvailable);
                }
                synchronized (ServiceStatusChecker.sPendingListeners) {
                    for (ServiceStatusListener serviceStatusListener3 : ServiceStatusChecker.sPendingListeners) {
                        serviceStatusListener3.onServiceStatus(ServiceStatusChecker.sIsSerivceAvailable, ServiceStatusChecker.sIsRpcAvailable);
                    }
                    ServiceStatusChecker.sPendingListeners.clear();
                }
                ServiceStatusChecker.sIsChecking.set(false);
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public static boolean calcAvailability(int i, int i2) {
        boolean z = false;
        if (i2 != 0 && i % Math.abs(i2) == 0) {
            z = true;
        }
        if (i2 < 0) {
            return !z;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static CheckStatus getServiceStatus() {
        return new CheckStatus();
    }

    /* access modifiers changed from: private */
    public static class CheckStatus {
        public int rpcStatus;
        public int streamStatus;

        private CheckStatus() {
            this.streamStatus = 1;
            this.rpcStatus = 1;
        }
    }
}
