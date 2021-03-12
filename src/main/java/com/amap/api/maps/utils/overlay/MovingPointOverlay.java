package com.amap.api.maps.utils.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MovingPointOverlay {
    private a STATUS = a.ACTION_UNKNOWN;
    private BasePointOverlay baseOverlay = null;
    private long duration = 10000;
    private LinkedList<Double> eachDistance = new LinkedList<>();
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private int index = 0;
    private AMap mAMap;
    private long mAnimationBeginTime = System.currentTimeMillis();
    private Object mLock = new Object();
    private long mStepDuration = 20;
    private ExecutorService mThreadPools;
    private MoveListener moveListener;
    private long pauseMillis;
    private LinkedList<LatLng> points = new LinkedList<>();
    private double remainDistance = 0.0d;
    private double totalDistance = 0.0d;
    private boolean useDefaultDescriptor = false;

    public interface MoveListener {
        void move(double d);
    }

    /* access modifiers changed from: private */
    public enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    private class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(MovingPointOverlay movingPointOverlay, byte b) {
            this();
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MoveSmoothThread");
        }
    }

    public MovingPointOverlay(AMap aMap, BasePointOverlay basePointOverlay) {
        if (aMap != null && basePointOverlay != null) {
            this.mAMap = aMap;
            this.mThreadPools = new ThreadPoolExecutor(1, 2, 5, TimeUnit.SECONDS, new SynchronousQueue(), new b(this, (byte) 0));
            this.baseOverlay = basePointOverlay;
        }
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            if (list != null) {
                try {
                    if (list.size() >= 2) {
                        stopMove();
                        this.points.clear();
                        for (LatLng latLng : list) {
                            if (latLng != null) {
                                this.points.add(latLng);
                            }
                        }
                        this.eachDistance.clear();
                        this.totalDistance = 0.0d;
                        int i = 0;
                        while (i < this.points.size() - 1) {
                            i++;
                            double calculateLineDistance = (double) AMapUtils.calculateLineDistance(this.points.get(i), this.points.get(i));
                            this.eachDistance.add(Double.valueOf(calculateLineDistance));
                            this.totalDistance += calculateLineDistance;
                        }
                        this.remainDistance = this.totalDistance;
                        this.baseOverlay.setPosition(this.points.get(0));
                        reset();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void reset() {
        try {
            if (this.STATUS != a.ACTION_RUNNING) {
                if (this.STATUS != a.ACTION_PAUSE) {
                    return;
                }
            }
            this.exitFlag.set(true);
            this.mThreadPools.awaitTermination(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
            this.baseOverlay.setAnimation(null);
            this.STATUS = a.ACTION_UNKNOWN;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setTotalDuration(int i) {
        this.duration = (long) (i * 1000);
    }

    public void startSmoothMove() {
        if (this.STATUS == a.ACTION_PAUSE) {
            this.STATUS = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((this.STATUS == a.ACTION_UNKNOWN || this.STATUS == a.ACTION_STOP) && this.points.size() > 0) {
            this.index = 0;
            try {
                this.mThreadPools.execute(new c(this, (byte) 0));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private IPoint getCurPosition(long j) {
        CameraPosition cameraPosition;
        MoveListener moveListener2;
        long j2 = this.duration;
        if (j > j2) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            this.index = this.points.size() - 1;
            LatLng latLng = this.points.get(this.index);
            this.index--;
            this.index = Math.max(this.index, 0);
            this.remainDistance = 0.0d;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener3 = this.moveListener;
            if (moveListener3 != null) {
                moveListener3.move(this.remainDistance);
            }
            return iPoint;
        }
        double d = this.totalDistance;
        double d2 = (((double) j) * d) / ((double) j2);
        this.remainDistance = d - d2;
        double d3 = 1.0d;
        double d4 = d2;
        int i = 0;
        while (true) {
            if (i >= this.eachDistance.size()) {
                i = 0;
                break;
            }
            double doubleValue = this.eachDistance.get(i).doubleValue();
            if (d4 > doubleValue) {
                d4 -= doubleValue;
                i++;
            } else if (doubleValue > 0.0d) {
                d3 = d4 / doubleValue;
            }
        }
        if (!(i == this.index || (moveListener2 = this.moveListener) == null)) {
            moveListener2.move(this.remainDistance);
        }
        this.index = i;
        LatLng latLng2 = this.points.get(i);
        LatLng latLng3 = this.points.get(i + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i2 = iPoint3.x - iPoint2.x;
        int i3 = iPoint3.y - iPoint2.y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 1.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (!(aMap == null || (cameraPosition = aMap.getCameraPosition()) == null)) {
                this.baseOverlay.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new IPoint((int) (((double) iPoint2.x) + (((double) i2) * d3)), (int) (((double) iPoint2.y) + (((double) i3) * d3)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d = (double) iPoint.y;
        return (float) ((Math.atan2(((double) iPoint2.x) - ((double) iPoint.x), d - ((double) iPoint2.y)) / 3.141592653589793d) * 180.0d);
    }

    public void stopMove() {
        if (this.STATUS == a.ACTION_RUNNING) {
            this.STATUS = a.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }

    public BasePointOverlay getObject() {
        return this.baseOverlay;
    }

    public LatLng getPosition() {
        BasePointOverlay basePointOverlay = this.baseOverlay;
        if (basePointOverlay != null) {
            return basePointOverlay.getPosition();
        }
        return null;
    }

    public int getIndex() {
        return this.index;
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.shutdownNow();
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeMarker() {
        try {
            if (this.baseOverlay != null) {
                this.baseOverlay.remove();
                this.baseOverlay = null;
            }
            this.points.clear();
            this.eachDistance.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            if (this.baseOverlay != null) {
                this.baseOverlay.setPosition(latLng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotate(float f) {
        CameraPosition cameraPosition;
        try {
            if (this.baseOverlay != null && this.mAMap != null && (cameraPosition = this.mAMap.getCameraPosition()) != null) {
                this.baseOverlay.setRotateAngle((360.0f - f) + cameraPosition.bearing);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.baseOverlay != null) {
                this.baseOverlay.setVisible(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMoveListener(MoveListener moveListener2) {
        this.moveListener = moveListener2;
    }

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(MovingPointOverlay movingPointOverlay, byte b) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
            java.lang.Thread.sleep(r5.a.mStepDuration);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 146
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.utils.overlay.MovingPointOverlay.c.run():void");
        }
    }
}
