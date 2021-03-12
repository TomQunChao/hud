package com.alibaba.idst.nls.internal.protocol;

import com.amap.api.col.stln3.a;
import com.amap.api.col.stln3.e;

public class NlsRequestDs {
    private RawJsonText content = null;
    private String type = "dialogue";
    public String version = "1.0";

    public e getContent() {
        return a.b(this.content.text);
    }

    public void setContent(String str) {
        if (str == null) {
            this.content = null;
        } else {
            this.content = new RawJsonText(str);
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
        this.content = new RawJsonText("{}");
    }
}
