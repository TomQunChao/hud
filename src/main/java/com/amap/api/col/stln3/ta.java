package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: SoDownloadItem */
public final class ta {
    private ti a;
    private sw b;
    private RandomAccessFile c;

    public ta(ti tiVar, sw swVar) {
        this.a = tiVar;
        this.b = swVar;
    }

    public final String a() {
        ti tiVar = this.a;
        if (tiVar == null) {
            return "";
        }
        return tiVar.c;
    }

    public final void a(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.b.b(this.a.a()));
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.c = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                }
            }
            try {
                this.c.seek(j);
                this.c.write(bArr);
            } catch (IOException e2) {
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, sw swVar) {
        ti b2;
        boolean z;
        if (!(context == null || (b2 = th.b(context)) == null || !ti.a(b2))) {
            if (!sw.c(b2.d, swVar.b(b2.a()))) {
                sw.e(swVar.b(b2.a()));
                th.d(context);
                return;
            }
            String b3 = swVar.b(b2.a());
            b2.a();
            sw.b(b3, swVar.b());
            b2.a();
            if (!tb.a(swVar.c())) {
                th.d(context);
                b2.a();
                sw.d(swVar.b());
                return;
            }
            b2.a();
            String c2 = swVar.c();
            b2.a();
            sw.a(context, c2, swVar.b());
            b2.a();
            String b4 = swVar.b();
            if (TextUtils.isEmpty(b4)) {
                z = false;
            } else if (b2.g != null) {
                Iterator<tg> it = b2.g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    tg next = it.next();
                    String f = next.f();
                    String str = next.a;
                    if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(str)) {
                        if (!sw.c(str, b4 + File.separator + sw.a(context, f))) {
                            z = false;
                            break;
                        }
                    } else {
                        z = false;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                ti a2 = th.a(context);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                a(b2, a2, arrayList, arrayList2);
                b2.d().addAll(arrayList2);
                for (int i = 0; i < arrayList.size(); i++) {
                    tg tgVar = (tg) arrayList.get(i);
                    a2.d().remove(tgVar);
                    String f2 = tgVar.f();
                    sw.e(swVar.a() + File.separator + sw.a(context, f2));
                }
                for (int i2 = 0; i2 < b2.d().size(); i2++) {
                    String f3 = b2.d().get(i2).f();
                    StringBuilder sb = new StringBuilder();
                    b2.a();
                    sb.append(swVar.b());
                    sb.append(File.separator);
                    sb.append(sw.a(context, f3));
                    String sb2 = sb.toString();
                    sw.a(sb2, swVar.a() + File.separator + sw.a(context, f3));
                }
                th.a(context, b2);
                th.d(context);
                b2.a();
                sw.d(swVar.b());
                sw.e(swVar.b(b2.a()));
                return;
            }
            th.d(context);
            sw.d(swVar.a());
            sw.d(swVar.a(b2.a()));
        }
    }

    private static void a(ti tiVar, ti tiVar2, List<tg> list, List<tg> list2) {
        List<tg> d = tiVar2.d();
        List<tg> d2 = tiVar.d();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < d.size(); i++) {
            tg tgVar = d.get(i);
            for (int i2 = 0; i2 < d2.size(); i2++) {
                if (d2.get(i2).f().equals(tgVar.f())) {
                    hashSet.add(tgVar.b());
                }
            }
        }
        for (int i3 = 0; i3 < d.size(); i3++) {
            if (hashSet.contains(d.get(i3).b())) {
                list.add(d.get(i3));
            } else {
                list2.add(d.get(i3));
            }
        }
    }

    public final void a(Context context) {
        try {
            if (this.c != null) {
                try {
                    this.c.close();
                } catch (IOException e) {
                }
                if (!sw.c(this.a.d, this.b.b(this.a.a()))) {
                    sw.e(this.b.b(this.a.a()));
                    th.d(context);
                    return;
                }
                th.b(context, this.a);
            }
        } catch (Throwable th) {
            sw.d(this.b.a());
            sw.d(this.b.a(this.a.a()));
        }
    }

    public final void b() {
        try {
            if (this.c != null) {
                try {
                    this.c.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable th) {
        }
    }
}
