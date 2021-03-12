package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: OfflineMapRemoveTask */
public final class eg {
    private Context a;

    public eg(Context context) {
        this.a = context;
    }

    public final void a(dz dzVar) {
        if (dzVar != null) {
            String pinyin = dzVar.getPinyin();
            boolean a2 = a(pinyin, this.a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z = false;
            boolean z2 = a(pinyin, this.a, "map/") || a2;
            if (b(ex.b(dzVar.getUrl()), this.a, "map/") || z2) {
                z = true;
            }
            if (z) {
                dzVar.i();
            } else {
                dzVar.h();
            }
        }
    }

    private static boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b = ic.b(context);
        try {
            File file = new File(b + str2 + str + ".dat");
            if (file.exists() && !ex.b(file)) {
                return false;
            }
            try {
                ex.a(b + str2);
                ex.a(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a2 = ic.a(context);
        try {
            File file = new File(a2 + str2 + str);
            if (file.exists() && !ex.b(file)) {
                return false;
            }
            try {
                ex.a(a2 + str2);
                ex.a(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
