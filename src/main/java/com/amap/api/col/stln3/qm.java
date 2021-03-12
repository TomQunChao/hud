package com.amap.api.col.stln3;

import android.util.SparseArray;
import java.text.DecimalFormat;

/* compiled from: FormatUtil */
public final class qm {
    private static SparseArray<DecimalFormat> a;
    private static int b = 8;

    public static String a(double d) {
        if (a == null) {
            a = new SparseArray<>();
        }
        DecimalFormat decimalFormat = a.get(6);
        if (decimalFormat == null) {
            decimalFormat = a(6);
            a.put(6, decimalFormat);
        }
        return decimalFormat.format(d);
    }

    private static DecimalFormat a(int i) {
        if (6 > b) {
            i = 2;
        }
        StringBuffer stringBuffer = new StringBuffer("0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("0");
        }
        return new DecimalFormat(stringBuffer.toString());
    }
}
