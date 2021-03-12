package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

public class AMapPermissionActivity extends Activity {
    private boolean a = true;
    protected String[] needPermissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"};

    static /* synthetic */ void a(AMapPermissionActivity aMapPermissionActivity) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + aMapPermissionActivity.getPackageName()));
            aMapPermissionActivity.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        List<String> a2;
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 23 && this.a) {
                String[] strArr = this.needPermissions;
                try {
                    if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23 && (a2 = a(strArr)) != null && a2.size() > 0) {
                        try {
                            getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) a2.toArray(new String[a2.size()]), 0);
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @TargetApi(23)
    private List<String> a(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (a(str) == 0) {
                        if (!b(str)) {
                        }
                    }
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable th) {
            return -1;
        }
    }

    private boolean b(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(int[] iArr) {
        try {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && i == 0 && !a(iArr)) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("提示");
                    builder.setMessage("当前应用缺少必要权限。\\n\\n请点击\\\"设置\\\"-\\\"权限\\\"-打开所需权限");
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        /* class com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                AMapPermissionActivity.this.finish();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        /* class com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                AMapPermissionActivity.a(AMapPermissionActivity.this);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.a = false;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
