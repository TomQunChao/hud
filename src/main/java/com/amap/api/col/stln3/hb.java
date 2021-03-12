package com.amap.api.col.stln3;

import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* compiled from: AbstractAMapRequest */
public abstract class hb extends tw {
    protected boolean isPostFlag = true;

    /* access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws qx {
        int protocol = MapsInitializer.getProtocol();
        tv c = tv.c();
        if (protocol == 1) {
            if (this.isPostFlag) {
                return c.b(this);
            }
            return tv.d(this);
        } else if (protocol != 2) {
            return null;
        } else {
            if (this.isPostFlag) {
                return tv.a(this);
            }
            return tv.e(this);
        }
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.stln3.tw
    public Map<String, String> getRequestHead() {
        return null;
    }
}
