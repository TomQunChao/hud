package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.Type;

/* access modifiers changed from: package-private */
/* compiled from: EnumSerializer */
public final class an implements ay {
    an() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        if ((bdVar.c & be.WriteEnumUsingToString.w) != 0) {
            String str = ((Enum) obj).toString();
            if ((bdVar.c & be.UseSingleQuotes.w) != 0) {
                bdVar.b(str);
            } else {
                bdVar.a(str, (char) 0, false);
            }
        } else {
            bdVar.b(((Enum) obj).ordinal());
        }
    }
}
