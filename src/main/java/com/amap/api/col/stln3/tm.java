package com.amap.api.col.stln3;

import com.amap.api.track.ErrorCode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class tm implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), q);
    private static final ThreadFactory q = new ThreadFactory() {
        /* class com.amap.api.col.stln3.tm.AnonymousClass1 */
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    };
    private static final OutputStream s = new OutputStream() {
        /* class com.amap.api.col.stln3.tm.AnonymousClass3 */

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    };
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private long j = 0;
    private Writer k;
    private int l = 1000;
    private final LinkedHashMap<String, c> m = new LinkedHashMap<>(0, 0.75f, true);
    private int n;
    private tn o;
    private long p = 0;
    private final Callable<Void> r = new Callable<Void>() {
        /* class com.amap.api.col.stln3.tm.AnonymousClass2 */

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (tm.this) {
                if (tm.this.k == null) {
                    return null;
                }
                tm.this.m();
                if (tm.this.k()) {
                    tm.this.j();
                    tm.this.n = 0;
                }
                return null;
            }
        }
    };

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = ErrorCode.Response.SUCCESS;
        }
        this.l = i2;
    }

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor = b;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            b.shutdown();
        }
    }

    private static ThreadPoolExecutor g() {
        try {
            if (b != null) {
                if (!b.isShutdown()) {
                    return b;
                }
            }
            b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    private tm(File file, long j2) {
        this.c = file;
        this.g = 1;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = 1;
        this.h = j2;
    }

    public static tm a(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            tm tmVar = new tm(file, j2);
            if (tmVar.d.exists()) {
                try {
                    tmVar.h();
                    tmVar.i();
                    tmVar.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmVar.d, true), tp.a));
                    return tmVar;
                } catch (Throwable th) {
                    tmVar.e();
                }
            }
            file.mkdirs();
            tm tmVar2 = new tm(file, j2);
            tmVar2.j();
            return tmVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[Catch:{ EOFException -> 0x0118 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.tm.h():void");
    }

    private void i() throws IOException {
        a(this.e);
        Iterator<c> it = this.m.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.i) {
                    this.j += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.i) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void j() throws IOException {
        if (this.k != null) {
            this.k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), tp.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.m.values()) {
                if (cVar.e != null) {
                    bufferedWriter.write("DIRTY " + cVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), tp.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized b a(String str) throws IOException {
        l();
        e(str);
        c cVar = this.m.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.i; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(cVar.a(i3));
            } catch (FileNotFoundException e2) {
                while (i2 < this.i && inputStreamArr[i2] != null) {
                    tp.a(inputStreamArr[i2]);
                    i2++;
                }
                return null;
            }
        }
        this.n++;
        this.k.append((CharSequence) ("READ " + str + '\n'));
        if (k()) {
            g().submit(this.r);
        }
        return new b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    private synchronized a d(String str) throws IOException {
        l();
        e(str);
        c cVar = this.m.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.m.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        a aVar = new a(this, cVar, (byte) 0);
        cVar.e = aVar;
        Writer writer = this.k;
        writer.write("DIRTY " + str + '\n');
        this.k.flush();
        return aVar;
    }

    public final File b() {
        return this.c;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(a aVar, boolean z) throws IOException {
        c cVar = aVar.b;
        if (cVar.e == aVar) {
            if (z && !cVar.d) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (!aVar.c[i2]) {
                        aVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!cVar.b(i2).exists()) {
                        aVar.c();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.i; i3++) {
                File b2 = cVar.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i3);
                    b2.renameTo(a2);
                    long j2 = cVar.c[i3];
                    long length = a2.length();
                    cVar.c[i3] = length;
                    this.j = (this.j - j2) + length;
                }
            }
            this.n++;
            cVar.e = null;
            if (cVar.d || z) {
                cVar.d = true;
                this.k.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j3 = this.p;
                    this.p = 1 + j3;
                    cVar.f = j3;
                }
            } else {
                this.m.remove(cVar.b);
                this.k.write("REMOVE " + cVar.b + '\n');
            }
            this.k.flush();
            if (this.j > this.h || k()) {
                g().submit(this.r);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean k() {
        int i2 = this.n;
        return i2 >= 2000 && i2 >= this.m.size();
    }

    public final synchronized boolean c(String str) throws IOException {
        l();
        e(str);
        c cVar = this.m.get(str);
        if (cVar != null) {
            if (cVar.e == null) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                    }
                    this.j -= cVar.c[i2];
                    cVar.c[i2] = 0;
                }
                this.n++;
                this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.m.remove(str);
                if (k()) {
                    g().submit(this.r);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean c() {
        return this.k == null;
    }

    private void l() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void d() throws IOException {
        l();
        m();
        this.k.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.k != null) {
            Iterator it = new ArrayList(this.m.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.e != null) {
                    cVar.e.c();
                }
            }
            m();
            this.k.close();
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
    public void m() throws java.io.IOException {
        /*
            r5 = this;
        L_0x0000:
            long r0 = r5.j
            long r2 = r5.h
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0014
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.stln3.tm$c> r0 = r5.m
            int r0 = r0.size()
            int r1 = r5.l
            if (r0 <= r1) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return
        L_0x0014:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.stln3.tm$c> r0 = r5.m
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getKey()
            java.lang.String r0 = (java.lang.String) r0
            r5.c(r0)
            com.amap.api.col.stln3.tn r0 = r5.o
            if (r0 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.tm.m():void");
    }

    public final void e() throws IOException {
        close();
        tp.a(this.c);
    }

    private static void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        /* synthetic */ b(tm tmVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j, inputStreamArr, jArr);
        }

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.d) {
                tp.a(inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* synthetic */ a(tm tmVar, c cVar, byte b2) {
            this(cVar);
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[tm.this.i];
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0002a aVar;
            if (tm.this.i > 0) {
                synchronized (tm.this) {
                    if (this.b.e == this) {
                        if (!this.b.d) {
                            this.c[0] = true;
                        }
                        File b2 = this.b.b(0);
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException e2) {
                            tm.this.c.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b2);
                            } catch (FileNotFoundException e3) {
                                return tm.s;
                            }
                        }
                        aVar = new C0002a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + tm.this.i);
        }

        public final void b() throws IOException {
            if (this.d) {
                tm.this.a((tm) this, (a) false);
                tm.this.c(this.b.b);
            } else {
                tm.this.a((tm) this, (a) true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            tm.this.a((tm) this, (a) false);
        }

        /* access modifiers changed from: private */
        /* renamed from: com.amap.api.col.stln3.tm$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        public class C0002a extends FilterOutputStream {
            /* synthetic */ C0002a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C0002a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    a.this.d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    a.this.d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    a.this.d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    a.this.d = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DiskLruCache */
    public final class c {
        private final String b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        /* synthetic */ c(tm tmVar, String str, byte b2) {
            this(str);
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == tm.this.i) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        cVar.c[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException e2) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        private c(String str) {
            this.b = str;
            this.c = new long[tm.this.i];
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.c;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File file = tm.this.c;
            return new File(file, this.b + "." + i);
        }

        public final File b(int i) {
            File file = tm.this.c;
            return new File(file, this.b + "." + i + ".tmp");
        }
    }
}
