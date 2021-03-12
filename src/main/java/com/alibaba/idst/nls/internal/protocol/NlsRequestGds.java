package com.alibaba.idst.nls.internal.protocol;

import com.amap.api.col.stln3.a;
import com.amap.api.col.stln3.e;

public class NlsRequestGds {
    public e content;
    private String type = "dialogue";
    private String version = NlsRequestProto.VERSION30;

    public e getContent() {
        return this.content;
    }

    public void setContent(Content content2) {
        this.content = (e) a.b(content2);
    }

    public void setContent(String str) {
        if (str == null) {
            this.content = null;
        } else {
            this.content = (e) a.a(str);
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
