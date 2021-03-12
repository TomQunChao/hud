package com.amap.api.col.stln3;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: VersionUtil */
public final class tc {
    private static Pattern a = null;

    public static int a(String str, String str2) {
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
        } catch (Throwable th) {
            ru.a(th, "Utils", "compareVersion");
            return -1;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (a == null) {
            a = Pattern.compile("[\\d+\\.]+");
        }
        return a.matcher(str).matches();
    }
}
