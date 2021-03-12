package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utility */
public final class ex {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                b(jSONObject4.toString(), context);
                jSONObject2 = jSONObject4.optJSONObject("result");
            } catch (JSONException e) {
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                rx.c(e, "Utility", "parseJson");
                e.printStackTrace();
                jSONObject2 = optJSONObject;
            }
        } else {
            jSONObject2 = jSONObject.optJSONObject("result");
        }
        if (jSONObject2 != null) {
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject2 == null) {
                return arrayList;
            }
            jSONObject3 = optJSONObject2.optJSONObject("offlinemapinfo_with_province");
        } else {
            jSONObject3 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        if (jSONObject3.has("version")) {
            ea.d = a(jSONObject3, "version");
        }
        JSONArray optJSONArray = jSONObject3.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(a(optJSONObject3));
            }
        }
        JSONArray optJSONArray2 = jSONObject3.optJSONArray("others");
        JSONObject jSONObject5 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject5 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject5 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject5));
        return arrayList;
    }

    private static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(c(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, "size")));
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray != null) {
            if (optJSONArray.length() == 0) {
                arrayList.add(b(jSONObject));
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(b(optJSONObject));
                }
            }
        }
        offlineMapProvince.setCityList(arrayList);
        return offlineMapProvince;
    }

    private static String c(String str) {
        if ("000001".equals(str)) {
            return "100000";
        }
        return str;
    }

    private static OfflineMapCity b(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(c(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, "size")));
        return offlineMapCity;
    }

    public static long a(File file) {
        long j;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j = a(file2);
            } else {
                j = file2.length();
            }
            j2 += j;
        }
        return j2;
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String a(Context context, String str) {
        try {
            return ic.a(hw.a(context).open(str));
        } catch (Throwable th) {
            rx.c(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x005e A[SYNTHETIC, Splitter:B:35:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[SYNTHETIC, Splitter:B:40:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0084 A[SYNTHETIC, Splitter:B:48:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090 A[SYNTHETIC, Splitter:B:53:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a0 A[SYNTHETIC, Splitter:B:60:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ac A[SYNTHETIC, Splitter:B:65:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r5) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ex.c(java.io.File):java.lang.String");
    }

    public static void a(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(ic.c(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists() && file.getName().contains(str)) {
                    b(file);
                }
            }
            a(ic.c(context));
        }
    }

    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A[SYNTHETIC, Splitter:B:33:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r5, android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ex.b(java.lang.String, android.content.Context):void");
    }

    public static String b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
            }
            return null;
        } catch (Throwable th) {
            rx.c(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }
}
