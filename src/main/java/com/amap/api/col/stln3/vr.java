package com.amap.api.col.stln3;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;

/* compiled from: Parser */
public final class vr {
    private StringBuilder a = new StringBuilder();
    private AMapLocationClientOption b = new AMapLocationClientOption();

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0261, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0263, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0264, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02bf, code lost:
        r15.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e9, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ea, code lost:
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0107, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0127, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0128, code lost:
        r17 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0145, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0146, code lost:
        r18 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0163, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0164, code lost:
        r19 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0198, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0199, code lost:
        r20 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0246 A[Catch:{ Throwable -> 0x0257, all -> 0x0261 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0261 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.vc a(com.amap.api.col.stln3.vc r22, byte[] r23) {
        /*
        // Method dump skipped, instructions count: 709
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vr.a(com.amap.api.col.stln3.vc, byte[]):com.amap.api.col.stln3.vc");
    }

    private void a(vc vcVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str2) && (this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN ? !str.contains("市") || !str.equals(str2) : !str2.equals(str))) {
            sb2.append(str2);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(str4);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb2.append(str5);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                sb2.append("Near " + str6);
                sb = new StringBuilder("Near ");
                sb.append(str6);
            } else {
                sb2.append("靠近");
                sb2.append(str6);
                sb2.append(" ");
                sb = new StringBuilder("在");
                sb.append(str6);
                sb.append("附近");
            }
            vcVar.setDescription(sb.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", vcVar.getCityCode());
        bundle.putString("desc", sb2.toString());
        bundle.putString("adcode", vcVar.getAdCode());
        vcVar.setExtras(bundle);
        vcVar.g(sb2.toString());
        String adCode = vcVar.getAdCode();
        if (adCode == null || adCode.trim().length() <= 0 || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            vcVar.setAddress(sb2.toString());
        } else {
            vcVar.setAddress(sb2.toString().replace(" ", ""));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089 A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00da A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ed A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fa A[Catch:{ Throwable -> 0x0115 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.vc a(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vr.a(java.lang.String):com.amap.api.col.stln3.vc");
    }

    private static String b(String str) {
        if ("[]".equals(str)) {
            return "";
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d A[Catch:{ Throwable -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.stln3.vc a(java.lang.String r6, android.content.Context r7, com.amap.api.col.stln3.ty r8) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.vr.a(java.lang.String, android.content.Context, com.amap.api.col.stln3.ty):com.amap.api.col.stln3.vc");
    }
}
