package com.autonavi.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.amap.api.col.stln3.co;
import com.autonavi.ae.gmap.gloverlay.GLOverlay;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID = 1;
    protected T mGLOverlay;
    protected Vector<E> mItemList = null;
    protected int mLastFocusedIndex;
    protected co mMapView;

    public abstract void addItem(E e);

    /* access modifiers changed from: protected */
    public abstract void iniGLOverlay();

    public abstract void resumeMarker(Bitmap bitmap);

    public BaseMapOverlay(int i, Context context, co coVar) {
        this.mEngineID = i;
        this.mContext = context;
        this.mMapView = coVar;
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public void setVisible(boolean z) {
        T t = this.mGLOverlay;
        if (t != null) {
            t.setVisible(z);
        }
    }

    public boolean isVisible() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isVisible();
        }
        return false;
    }

    public void setClickable(boolean z) {
        T t = this.mGLOverlay;
        if (t != null) {
            t.setClickable(z);
        }
    }

    public boolean isClickable() {
        T t = this.mGLOverlay;
        if (t != null) {
            return t.isClickable();
        }
        return false;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            if (this.mGLOverlay == null) {
                return true;
            }
            this.mGLOverlay.removeAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public final E getItem(int i) {
        try {
            synchronized (this.mItemList) {
                if (i >= 0) {
                    if (i <= this.mItemList.size() - 1) {
                        return this.mItemList.get(i);
                    }
                }
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void removeItem(int i) {
        if (i >= 0) {
            try {
                if (i <= this.mItemList.size() - 1) {
                    if (i == this.mLastFocusedIndex) {
                        this.mLastFocusedIndex = -1;
                        clearFocus();
                    }
                    this.mItemList.remove(i);
                    if (this.mGLOverlay != null) {
                        this.mGLOverlay.removeItem(i);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }

    public void removeItem(E e) {
        if (e != null) {
            try {
                synchronized (this.mItemList) {
                    removeItem(this.mItemList.indexOf(e));
                }
            } catch (IndexOutOfBoundsException e2) {
            }
        }
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public void releaseInstance() {
        this.mMapView.queueEvent(new Runnable() {
            /* class com.autonavi.ae.gmap.gloverlay.BaseMapOverlay.AnonymousClass1 */

            public void run() {
                if (BaseMapOverlay.this.getGLOverlay() != null) {
                    if (BaseMapOverlay.this.mMapView != null && BaseMapOverlay.this.mMapView.isMaploaded()) {
                        BaseMapOverlay.this.mMapView.removeEngineGLOverlay(BaseMapOverlay.this);
                    }
                    BaseMapOverlay.this.getGLOverlay().releaseInstance();
                    BaseMapOverlay.this.mGLOverlay = null;
                }
            }
        });
    }
}
