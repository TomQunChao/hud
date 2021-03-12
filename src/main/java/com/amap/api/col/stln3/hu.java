package com.amap.api.col.stln3;

import java.util.Locale;
import java.util.Random;

/* compiled from: RandomUtil */
public final class hu {
    private static String a = "0123456789";

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        String format = String.format(Locale.US, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        String a2 = new a(a, nextInt3).a(nextInt2, format);
        return a2 + String.format(Locale.US, "%01d", Integer.valueOf(nextInt2)) + String.format(Locale.US, "%02d", Integer.valueOf(nextInt3));
    }

    /* access modifiers changed from: package-private */
    /* compiled from: RandomUtil */
    public static class a {
        private String a;
        private int b;
        private int c;

        public a(String str, int i) {
            this.b = 1103515245;
            this.c = 12345;
            this.a = a(str, i, str.length());
        }

        public a() {
            this((byte) 0);
        }

        private a(byte b2) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        private int a(int i) {
            return (int) (((((long) i) * ((long) this.b)) + ((long) this.c)) & 2147483647L);
        }

        private String a(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                int a2 = a(i);
                int i4 = a2 % length;
                i = a(a2);
                int i5 = i % length;
                char charAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, charAt);
            }
            return stringBuffer.toString();
        }

        public final String a(int i, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.a.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt = str.charAt(i2);
                this.a.length();
                int indexOf = this.a.indexOf(charAt);
                if (indexOf < 0) {
                    break;
                }
                this.a.length();
                sb.append(this.a.charAt(((indexOf + i) + i2) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }
    }
}
