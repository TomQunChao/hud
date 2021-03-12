package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: StringCodec */
public final class bf implements ae, ay {
    public static bf a = new bf();

    private bf() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        String str = (String) obj;
        bd bdVar = arVar.b;
        if (str == null) {
            bdVar.a();
        } else {
            bdVar.a(str);
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        return (T) lVar.g();
    }
}
