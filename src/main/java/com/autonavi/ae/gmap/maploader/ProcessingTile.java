package com.autonavi.ae.gmap.maploader;

import com.autonavi.ae.gmap.maploader.Pools;

public class ProcessingTile {
    private static final Pools.SynchronizedPool<ProcessingTile> M_POOL = new Pools.SynchronizedPool<>(30);
    public long mCreateTime = 0;
    public String mKeyName;

    public static ProcessingTile obtain(String str) {
        ProcessingTile acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ProcessingTile(str);
        }
        acquire.setParams(str);
        return acquire;
    }

    public void recycle() {
        this.mKeyName = null;
        this.mCreateTime = 0;
        M_POOL.release(this);
    }

    public ProcessingTile(String str) {
        setParams(str);
    }

    private void setParams(String str) {
        this.mKeyName = str;
        this.mCreateTime = System.currentTimeMillis() / 1000;
    }
}
