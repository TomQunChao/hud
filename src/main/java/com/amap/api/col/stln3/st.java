package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.stln3.sn;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* compiled from: Utils */
public final class st {
    private static boolean a(sc scVar, sj sjVar) {
        try {
            List<sr> a = sn.a.a(scVar, sjVar.b, "used");
            if (a == null || a.size() <= 0 || b(a.get(0).e(), sjVar.d) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            ru.a(th, "dDownLoad", "isUsed");
        }
    }

    static boolean a(Context context, sj sjVar, rj rjVar) {
        sc scVar = new sc(context, sp.a());
        if (a(scVar, sjVar)) {
            return true;
        }
        sr a = sn.a.a(scVar, sjVar.a);
        if (a != null) {
            return a(context, scVar, a, sjVar, rjVar);
        }
        return false;
    }

    private static boolean a(final Context context, final sc scVar, sr srVar, sj sjVar, final rj rjVar) {
        String str = sjVar.b;
        String str2 = sjVar.c;
        final String str3 = sjVar.d;
        if ("errorstatus".equals(srVar.f())) {
            try {
                if (!new File(sn.b(context, rjVar.a(), rjVar.b())).exists()) {
                    if (!TextUtils.isEmpty(sn.a(context, scVar, rjVar))) {
                        ss.b().a().submit(new Runnable() {
                            /* class com.amap.api.col.stln3.st.AnonymousClass2 */

                            public final void run() {
                                try {
                                    sn.a(context, rjVar);
                                } catch (Throwable th) {
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
            }
            return true;
        }
        final String a = sn.a(context, sjVar.a);
        if (!new File(a).exists()) {
            return false;
        }
        List b = scVar.b(sr.a(sn.a(context, str, str2), str, str2, str3), sr.class);
        if (b != null && b.size() > 0) {
            return true;
        }
        sn.a(context, str, rjVar.b());
        try {
            ss.b().a().submit(new Runnable() {
                /* class com.amap.api.col.stln3.st.AnonymousClass1 */

                public final void run() {
                    try {
                        sn.a(context, scVar, rjVar, a, str3);
                        sn.a(context, rjVar);
                    } catch (Throwable th) {
                        ru.a(th, "dDownLoad", "processDownloadedFile()");
                    }
                }
            });
        } catch (Throwable th2) {
        }
        return true;
    }

    static boolean a(Context context, boolean z) {
        if (!z) {
            return rd.r(context) == 1;
        }
    }

    static boolean a(sj sjVar) {
        return Build.VERSION.SDK_INT >= sjVar.f && Build.VERSION.SDK_INT <= sjVar.e;
    }

    static boolean a(rj rjVar, sj sjVar) {
        if (rjVar != null && rjVar.a().equals(sjVar.b) && rjVar.b().equals(sjVar.c)) {
            return true;
        }
        return false;
    }

    static PublicKey a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        Throwable th2;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(re.b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    a(byteArrayInputStream);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return publicKey;
            } catch (Throwable th4) {
                th2 = th4;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th = th5;
            try {
                a(byteArrayInputStream);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            throw th;
        }
        try {
            ru.a(th2, "DyLoader", "init");
            try {
                a(byteArrayInputStream);
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
            return null;
        } catch (Throwable th8) {
            th = th8;
            a(byteArrayInputStream);
            throw th;
        }
        return null;
    }

    private static int b(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i < min) {
                    i2 = split[i].length() - split2[i].length();
                    if (i2 == 0) {
                        i2 = split[i].compareTo(split2[i]);
                        if (i2 != 0) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return i2 != 0 ? i2 : split.length - split2.length;
        } catch (Exception e) {
            ru.a(e, "Utils", "compareVersion");
            return -1;
        }
    }

    static void a(List<sr> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                sr srVar = list.get(i);
                sr srVar2 = list.get(i3);
                if (b(srVar2.e(), srVar.e()) > 0) {
                    list.set(i, srVar2);
                    list.set(i3, srVar);
                }
            }
            i = i2;
        }
    }

    static boolean a(String str, String str2) {
        String a = rg.a(str);
        if (a == null || !a.equalsIgnoreCase(str2)) {
            return false;
        }
        return true;
    }

    static boolean a(sc scVar, String str, String str2, rj rjVar) {
        sr a = sn.a.a(scVar, str);
        if (a == null || !rjVar.b().equals(a.d()) || !a(str2, a.b())) {
            return false;
        }
        return true;
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
