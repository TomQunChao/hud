package com.amap.api.track.query.entity;

import android.text.TextUtils;

public class AccuracyMode {
    public static String createAccurationMode(int i, int i2) {
        if (i <= 0 && i2 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (i > 0) {
            stringBuffer.append(i);
        }
        stringBuffer.append("-");
        if (i2 > 0) {
            stringBuffer.append(i2);
        }
        return stringBuffer.toString();
    }

    public static boolean isValid(String str) {
        return !TextUtils.isEmpty(str);
    }
}
