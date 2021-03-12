package com.amap.api.col.stln3;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: PluginContext */
public final class mk extends ContextThemeWrapper {
    private static final String[] f = {"android.widget", "android.webkit", "android.app"};
    private Resources a = mm.a();
    private Resources.Theme b;
    private LayoutInflater c;
    private ClassLoader d;
    private int e;
    private a g = new a();
    private LayoutInflater.Factory h = new LayoutInflater.Factory() {
        /* class com.amap.api.col.stln3.mk.AnonymousClass1 */

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            String str2 = "name:" + str;
            return mk.this.a(str, context, attributeSet);
        }
    };

    /* compiled from: PluginContext */
    public static class a {
        public HashSet<String> a = new HashSet<>();
        public HashMap<String, Constructor<?>> b = new HashMap<>();
    }

    public mk(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.d = classLoader;
        this.b = mm.b();
        this.e = i;
        super.onApplyThemeResource(this.b, this.e, true);
        String str = "classloader:" + this.d;
    }

    public final Resources getResources() {
        Resources resources = this.a;
        if (resources != null) {
            return resources;
        }
        return super.getResources();
    }

    public final void a(int i) {
        if (i != this.e) {
            this.e = i;
            super.onApplyThemeResource(this.b, this.e, true);
        }
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        return super.getTheme();
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.c == null) {
            this.c = ((LayoutInflater) super.getSystemService(str)).cloneInContext(this);
            this.c.setFactory(this.h);
            this.c = this.c.cloneInContext(this);
        }
        return this.c;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View a(java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mk.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}
