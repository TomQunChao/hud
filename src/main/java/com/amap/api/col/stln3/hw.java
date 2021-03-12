package com.amap.api.col.stln3;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: ResourcesUtil */
public final class hw {
    private static boolean a;

    static {
        a = false;
        a = new File("/system/framework/amap.jar").exists();
    }

    public static AssetManager a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (Throwable th) {
                rx.c(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int b(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }
}
