package com.autonavi.amap.mapcore;

public class LinkInfo {
    private int length = 0;
    private int state = 0;
    private int time = 0;

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public String toString() {
        return "状态：" + this.state + "|" + "时间：" + this.time + "|" + "长度：" + this.length;
    }
}
