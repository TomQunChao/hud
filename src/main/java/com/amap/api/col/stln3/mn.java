package com.amap.api.col.stln3;

/* compiled from: StrategyConvert */
public final class mn {
    public static int a(boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(z2 ? "1" : "0");
            sb.append(z3 ? "1" : "0");
            sb.append(z4 ? "1" : "0");
            switch (Integer.parseInt(sb.toString())) {
                case 0:
                    return 10;
                case 1:
                    return 19;
                case 10:
                    return 14;
                case 11:
                    throw new IllegalArgumentException("高速优先与避免收费不能同时为true");
                case 100:
                    return 13;
                case 101:
                    throw new IllegalArgumentException("高速优先与不走高速不能同时为true");
                case 110:
                    return 16;
                case 1000:
                    return 12;
                case 1001:
                    return 20;
                case 1010:
                    return 17;
                case 1100:
                    return 15;
                case 1110:
                    return 18;
                default:
                    return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
