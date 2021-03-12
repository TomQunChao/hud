package com.amap.api.col.stln3;

import android.content.Context;
import android.opengl.GLES20;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Gl3dModelManager */
public final class cj {
    private long a = 0;
    private Context b;
    private co c;
    private List<fr> d = new ArrayList();
    private List<Integer> e = new ArrayList();

    public cj(Context context, co coVar) {
        this.b = context;
        this.c = coVar;
    }

    public final GL3DModel a(GL3DModelOptions gL3DModelOptions) {
        GL3DModel gL3DModel;
        if (gL3DModelOptions == null) {
            return null;
        }
        fr frVar = new fr(this, gL3DModelOptions, this.c);
        StringBuilder sb = new StringBuilder("model_");
        long j = this.a;
        this.a = 1 + j;
        sb.append(j);
        frVar.a(sb.toString());
        synchronized (this.d) {
            this.d.add(frVar);
            gL3DModel = new GL3DModel(frVar);
        }
        return gL3DModel;
    }

    public final void a() {
        for (fr frVar : this.d) {
            if (frVar.isVisible()) {
                frVar.j();
            }
        }
    }

    public final void b() {
        List<fr> list = this.d;
        if (list != null) {
            list.clear();
        }
    }

    public final void c() {
        List<fr> list = this.d;
        if (list != null) {
            for (fr frVar : list) {
                frVar.destroy();
            }
            this.d.clear();
        }
    }

    public final void d() {
        List<Integer> list = this.e;
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                GLES20.glDeleteTextures(1, new int[]{it.next().intValue()}, 0);
            }
        }
    }

    public final void a(String str) {
        try {
            if (this.d != null && this.d.size() > 0) {
                fr frVar = null;
                int i = 0;
                while (true) {
                    if (i >= this.d.size()) {
                        break;
                    }
                    frVar = this.d.get(i);
                    if (str.equals(frVar.getId())) {
                        break;
                    }
                    i++;
                }
                if (frVar != null) {
                    this.d.remove(frVar);
                    frVar.destroy();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i) {
        this.e.add(Integer.valueOf(i));
    }
}
