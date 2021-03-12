package com.alibaba.idst.nls.internal.protocol.GdsContent;

public class PriorQud {
    private String action;
    private int count;
    private Object data;
    private Object expect;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public Object getExpect() {
        return this.expect;
    }

    public void setExpect(Object obj) {
        this.expect = obj;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
