package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* compiled from: InfoCollectUtils */
public class hn {
    private static boolean a = false;
    private static volatile hn d;
    private Hashtable<String, String> b = new Hashtable<>();
    private WeakReference<Context> c = null;

    private hn() {
    }

    public static hn a() {
        if (d == null) {
            synchronized (hn.class) {
                if (d == null) {
                    d = new hn();
                }
            }
        }
        return d;
    }

    public static void b() {
        if (d != null) {
            if (d.b != null && d.b.size() > 0) {
                synchronized (d.b) {
                    d.c();
                    if (d.c != null) {
                        d.c.clear();
                    }
                }
            }
            d = null;
        }
        a = false;
    }

    public static void a(boolean z) {
        a = z;
    }

    public static void a(int i) {
        if (a) {
            a = i < 1000;
        }
    }

    public final void a(Context context) {
        if (context != null) {
            this.c = new WeakReference<>(context);
        }
    }

    public final void a(LatLng latLng, String str, String str2) {
        Hashtable<String, String> hashtable;
        if (!a) {
            this.b.clear();
        } else if (latLng != null && !TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("{");
            stringBuffer.append("\"lon\":");
            stringBuffer.append(latLng.longitude);
            stringBuffer.append(",");
            stringBuffer.append("\"lat\":");
            stringBuffer.append(latLng.latitude);
            stringBuffer.append(",");
            stringBuffer.append("\"title\":\"");
            stringBuffer.append(str);
            stringBuffer.append("\",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            stringBuffer.append("\"snippet\":\"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            stringBuffer.append("}");
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2 != null && (hashtable = this.b) != null) {
                synchronized (hashtable) {
                    String b2 = rg.b(stringBuffer2);
                    if (this.b != null && !this.b.contains(b2)) {
                        this.b.put(b2, stringBuffer2);
                    }
                    boolean z = false;
                    if (this.b != null && this.b.size() > 20) {
                        z = true;
                    }
                    if (z) {
                        c();
                    }
                }
            }
        }
    }

    private void c() {
        WeakReference<Context> weakReference;
        if (!a) {
            this.b.clear();
        } else if (this.b != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            int size = this.b.size();
            if (size > 0) {
                stringBuffer.append("[");
                for (String str : this.b.values()) {
                    i++;
                    stringBuffer.append(str);
                    if (i < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!(TextUtils.isEmpty(stringBuffer2) || (weakReference = this.c) == null || weakReference.get() == null)) {
                    ud.a(stringBuffer2, this.c.get());
                }
            }
            this.b.clear();
        }
    }
}
