package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.stln3.ic;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f, double d) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (((double) AMapUtils.calculateLineDistance(new LatLng(dPoint.x, dPoint.y), latLng)) < d) {
                            return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (!(list == null || latLng == null)) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                    }
                    return null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f) {
        int i;
        double d;
        Pair<Integer, DPoint> pair;
        double d2;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        if (list2 == null || dPoint2 == null || list.size() == 0 || list.size() < 2) {
            return null;
        }
        int size = list.size();
        int i2 = 1;
        double d3 = 0.0d;
        DPoint dPoint3 = list2.get(0);
        Pair<Integer, DPoint> pair2 = null;
        int i3 = 1;
        while (true) {
            int i4 = size - 1;
            if (i3 > i4) {
                return pair2;
            }
            DPoint dPoint4 = list2.get(i3);
            if (i3 == i4 && dPoint4.equals(dPoint2)) {
                return new Pair<>(Integer.valueOf(i3), dPoint2);
            }
            if (!checkRotateIsMatch(dPoint3, dPoint4, f)) {
                i = i3;
                pair = pair2;
                d2 = d3;
            } else if (dPoint3.equals(dPoint2)) {
                return new Pair<>(Integer.valueOf(i3 - i2), dPoint2);
            } else {
                d2 = d3;
                i = i3;
                pair = pair2;
                Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.x, dPoint2.y, dPoint3.x, dPoint3.y, dPoint4.x, dPoint4.y);
                if (pair == null) {
                    d = ((Double) pointToSegDist.first).doubleValue();
                    pair2 = new Pair<>(Integer.valueOf(i - 1), pointToSegDist.second);
                } else if (d2 > ((Double) pointToSegDist.first).doubleValue()) {
                    d = ((Double) pointToSegDist.first).doubleValue();
                    pair2 = new Pair<>(Integer.valueOf(i - 1), pointToSegDist.second);
                }
                d3 = d;
                dPoint3 = dPoint4;
                dPoint2 = dPoint;
                i2 = 1;
                i3 = i + 1;
                list2 = list;
            }
            d = d2;
            pair2 = pair;
            d3 = d;
            dPoint3 = dPoint4;
            dPoint2 = dPoint;
            i2 = 1;
            i3 = i + 1;
            list2 = list;
        }
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f) {
        if (f == -1.0f) {
            return true;
        }
        if (dPoint == null || dPoint2 == null) {
            return false;
        }
        float abs = Math.abs((ic.a(dPoint, dPoint2) + 360.0f) - f) % 360.0f;
        if (abs > 180.0f) {
            abs = 360.0f - abs;
        }
        if (abs < 50.0f) {
            return true;
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d8 * d8) + (d10 * d10))), new DPoint(d3, d4));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return new Pair<>(Double.valueOf(Math.sqrt((d13 * d13) + (d14 * d14))), new DPoint(d5, d6));
        }
        double d15 = d11 / d12;
        double d16 = d3 + (d7 * d15);
        double d17 = d4 + (d9 * d15);
        double d18 = d - d16;
        double d19 = d17 - d2;
        return new Pair<>(Double.valueOf(Math.sqrt((d18 * d18) + (d19 * d19))), new DPoint(d16, d17));
    }
}
