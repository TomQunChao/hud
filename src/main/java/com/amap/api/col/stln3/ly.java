package com.amap.api.col.stln3;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: SharedPreferenceUtil */
public final class ly {
    private static String a(lt ltVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(ltVar);
            String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), "utf-8");
            objectOutputStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static lt a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes("utf-8"), 0)));
            lt ltVar = (lt) objectInputStream.readObject();
            objectInputStream.close();
            return ltVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, lt ltVar) {
        try {
            SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
            edit.putString(str2, a(ltVar));
            edit.apply();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static lt a(Context context, String str, String str2) {
        try {
            String string = context.getApplicationContext().getSharedPreferences(str, 0).getString(str2, null);
            if (string != null) {
                return a(string);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tts_config", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tts_config", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tts_config", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static boolean b(Context context, String str, boolean z) {
        return context.getSharedPreferences("tts_config", 0).getBoolean(str, z);
    }

    public static String c(Context context, String str, String str2) {
        return context.getSharedPreferences("tts_config", 0).getString(str, str2);
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("tts_config", 0).getInt(str, i);
    }
}
