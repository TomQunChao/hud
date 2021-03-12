package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: BooleanCodec */
public final class ak implements ae, ay {
    public static final ak a = new ak();

    private ak() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((bdVar.c & be.WriteNullBooleanAsFalse.w) != 0) {
                bdVar.write("false");
            } else {
                bdVar.a();
            }
        } else if (bool.booleanValue()) {
            bdVar.write("true");
        } else {
            bdVar.write("false");
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        o oVar = lVar.c;
        int a2 = oVar.a();
        if (a2 == 6) {
            oVar.a(16);
            return (T) Boolean.TRUE;
        } else if (a2 == 7) {
            oVar.a(16);
            return (T) Boolean.FALSE;
        } else if (a2 == 2) {
            int k = oVar.k();
            oVar.a(16);
            return k == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
        } else {
            Object e = lVar.e();
            if (e == null) {
                return null;
            }
            return (T) bk.k(e);
        }
    }
}
