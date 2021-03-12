package com.amap.api.col.stln3;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OfflineMapDataVerify */
public final class ed extends Thread {
    private Context a;
    private ep b;

    public ed(Context context) {
        this.a = context;
        this.b = ep.a(context);
    }

    public final void run() {
        ek a2;
        String b2;
        int indexOf;
        String b3;
        int indexOf2;
        String b4;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ek> a3 = this.b.a();
        a(arrayList, "vmap/");
        a(arrayList, "map/");
        b(arrayList, "map/");
        ArrayList<String> a4 = a();
        Iterator<ek> it = a3.iterator();
        while (it.hasNext()) {
            ek next = it.next();
            if (!(next == null || next.c() == null)) {
                if (next.l == 4 || next.l == 7) {
                    boolean contains = arrayList.contains(next.h());
                    if (!(contains || (b2 = ex.b(next.f())) == null || (indexOf = arrayList.indexOf(b2)) == -1)) {
                        arrayList.set(indexOf, next.h());
                        contains = true;
                    }
                    if (contains) {
                    }
                } else {
                    boolean z = false;
                    if (next.l == 0 || next.l == 1) {
                        if (a4.contains(next.e()) || a4.contains(next.h())) {
                            z = true;
                        }
                        if (!(z || (b3 = ex.b(next.f())) == null || (indexOf2 = a4.indexOf(b3)) == -1)) {
                            a4.set(indexOf2, next.h());
                            z = true;
                        }
                        if (z) {
                        }
                    } else if (next.l == 3 && next.g() != 0) {
                        if (a4.contains(next.e()) || a4.contains(next.h())) {
                            z = true;
                        }
                        if (!(z || (b4 = ex.b(next.f())) == null || (indexOf3 = a4.indexOf(b4)) == -1)) {
                            a4.set(indexOf3, next.h());
                            z = true;
                        }
                        if (z) {
                        }
                    }
                }
                this.b.b(next);
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!a(next2, a3) && (a2 = a(next2)) != null) {
                this.b.a(a2);
            }
        }
        ea a5 = ea.a(this.a);
        if (a5 != null) {
            a5.b();
        }
    }

    private ek a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        ea a2 = ea.a(this.a);
        if (a2 == null) {
            return null;
        }
        String f = a2.f(str);
        File[] listFiles = new File(ic.c(this.a)).listFiles();
        if (listFiles == null) {
            return null;
        }
        ek ekVar = null;
        for (File file : listFiles) {
            if ((file.getName().contains(f) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                String a3 = ic.a(file);
                ek ekVar2 = new ek();
                ekVar2.b(a3);
                if (ekVar2.c() != null) {
                    return ekVar2;
                }
                ekVar = ekVar2;
            }
        }
        return ekVar;
    }

    private static boolean a(String str, ArrayList<ek> arrayList) {
        Iterator<ek> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().h())) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(ic.b(this.a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r9 != false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.ArrayList<java.lang.String> r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ed.b(java.util.ArrayList, java.lang.String):void");
    }

    private ArrayList<String> a() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(ic.c(this.a));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                arrayList.add(name.substring(0, lastIndexOf));
            }
        }
        return arrayList;
    }
}
