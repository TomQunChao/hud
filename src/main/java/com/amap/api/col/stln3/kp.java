package com.amap.api.col.stln3;

/* compiled from: TmcColor */
public enum kp {
    NOTRAFFIC(209, 209, 209),
    UNKNOWN(0, 145, 255),
    UNBLOCK(0, 186, 31),
    SLOW(255, 186, 0),
    BLOCK(243, 29, 32),
    GRIDLOCKED(168, 9, 11);
    
    private int g;
    private int h;
    private int i;

    private kp(int i2, int i3, int i4) {
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public final String toString() {
        return super.toString() + "(" + this.g + "，" + this.h + "，" + this.i + ")";
    }

    public final int a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    public final int c() {
        return this.i;
    }
}
