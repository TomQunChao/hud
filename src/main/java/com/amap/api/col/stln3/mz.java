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
public final class mz extends ContextThemeWrapper {
    private static final String[] d = {"android.widget", "android.webkit", "android.app"};
    private Resources a = na.a();
    private LayoutInflater b;
    private ClassLoader c;
    private a e = new a();
    private LayoutInflater.Factory f = new LayoutInflater.Factory() {
        /* class com.amap.api.col.stln3.mz.AnonymousClass1 */

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return mz.this.a(str, context, attributeSet);
        }
    };

    public mz(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.c = classLoader;
    }

    public final Resources getResources() {
        Resources resources = this.a;
        if (resources != null) {
            return resources;
        }
        return super.getResources();
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.b == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.b = layoutInflater.cloneInContext(this);
            }
            this.b.setFactory(this.f);
            this.b = this.b.cloneInContext(this);
        }
        return this.b;
    }

    /* compiled from: PluginContext */
    public class a {
        public HashSet<String> a = new HashSet<>();
        public HashMap<String, Constructor<?>> b = new HashMap<>();

        public a() {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007c A[SYNTHETIC, Splitter:B:33:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View a(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.mz.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}
