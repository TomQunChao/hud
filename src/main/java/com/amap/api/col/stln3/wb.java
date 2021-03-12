package com.amap.api.col.stln3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

/* compiled from: SpUtil */
public final class wb {
    @SuppressLint({"NewApi"})
    public static void a(final SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                editor.apply();
                return;
            }
            try {
                new AsyncTask<Void, Void, Void>() {
                    /* class com.amap.api.col.stln3.wb.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                    /* access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public final /* synthetic */ Void doInBackground(Void[] voidArr) {
                        return a();
                    }

                    private Void a() {
                        try {
                            if (editor == null) {
                                return null;
                            }
                            editor.commit();
                            return null;
                        } catch (Throwable th) {
                            vu.a(th, "SpUtil", "commit");
                            return null;
                        }
                    }
                }.execute(null, null, null);
            } catch (Throwable th) {
                vu.a(th, "SpUtil", "commit1");
            }
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            a(edit);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static long b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "getPrefsLong");
            return j;
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            a(edit);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "setPrefsInt");
        }
    }

    public static int b(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "getPrefsInt");
            return i;
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            a(edit);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static boolean b(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "getPrefsBoolean");
            return z;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            a(edit);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "setPrefsStr");
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            vu.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }
}
