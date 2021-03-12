package com.amap.api.col.stln3;

import android.content.Context;

/* compiled from: AuthLogUtil */
public final class he {
    static String a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        a = sb.toString();
    }

    public static void a() {
        String str = a;
    }

    public static void a(Context context) {
        String str = a;
        if (context != null) {
            a("key:" + qy.f(context));
        }
        String str2 = a;
    }

    private static void a(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String str2 = "|" + str.substring(0, 78) + "|";
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        sb.toString();
    }
}
