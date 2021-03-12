package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: RouteSearchCore */
public class pb implements IRouteSearch {
    private RouteSearch.OnRouteSearchListener a;
    private RouteSearch.OnTruckRouteSearchListener b;
    private Context c;
    private Handler d = nu.a();

    public pb(Context context) {
        this.c = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(walkRouteQuery.getFromAndTo())) {
                RouteSearch.WalkRouteQuery clone = walkRouteQuery.clone();
                WalkRouteResult walkRouteResult = (WalkRouteResult) new om(this.c, clone).a();
                if (walkRouteResult != null) {
                    walkRouteResult.setWalkQuery(clone);
                }
                return walkRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            nl.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pb.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        walkRouteResult = pb.this.calculateWalkRoute(walkRouteQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pb.this.a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        pb.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pb.this.a;
                    bundle.putParcelable("result", walkRouteResult);
                    obtainMessage.setData(bundle);
                    pb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(busRouteQuery.getFromAndTo())) {
                RouteSearch.BusRouteQuery clone = busRouteQuery.clone();
                BusRouteResult busRouteResult = (BusRouteResult) new ne(this.c, clone).a();
                if (busRouteResult != null) {
                    busRouteResult.setBusQuery(clone);
                }
                return busRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            nl.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pb.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        busRouteResult = pb.this.calculateBusRoute(busRouteQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pb.this.a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        pb.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pb.this.a;
                    bundle.putParcelable("result", busRouteResult);
                    obtainMessage.setData(bundle);
                    pb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(driveRouteQuery.getFromAndTo())) {
                RouteSearch.DriveRouteQuery clone = driveRouteQuery.clone();
                DriveRouteResult driveRouteResult = (DriveRouteResult) new no(this.c, clone).a();
                if (driveRouteResult != null) {
                    driveRouteResult.setDriveQuery(clone);
                }
                return driveRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            nl.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pb.AnonymousClass3 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        driveRouteResult = pb.this.calculateDriveRoute(driveRouteQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pb.this.a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        pb.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pb.this.a;
                    bundle.putParcelable("result", driveRouteResult);
                    obtainMessage.setData(bundle);
                    pb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        if (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pb.AnonymousClass4 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        rideRouteResult = pb.this.calculateRideRoute(rideRouteQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pb.this.a;
                        bundle.putParcelable("result", rideRouteResult);
                        obtainMessage.setData(bundle);
                        pb.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pb.this.a;
                    bundle.putParcelable("result", rideRouteResult);
                    obtainMessage.setData(bundle);
                    pb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(rideRouteQuery.getFromAndTo())) {
                RouteSearch.RideRouteQuery clone = rideRouteQuery.clone();
                RideRouteResult rideRouteResult = (RideRouteResult) new of(this.c, clone).a();
                if (rideRouteResult != null) {
                    rideRouteResult.setRideQuery(clone);
                }
                return rideRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            nl.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            ns.a(this.c);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(truckRouteQuery.getFromAndTo())) {
                RouteSearch.TruckRouteQuery clone = truckRouteQuery.clone();
                TruckRouteRestult truckRouteRestult = (TruckRouteRestult) new ol(this.c, clone).a();
                if (truckRouteRestult != null) {
                    truckRouteRestult.setTruckQuery(clone);
                }
                return truckRouteRestult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e) {
            nl.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pb.AnonymousClass5 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    try {
                        truckRouteRestult = pb.this.calculateTruckRoute(truckRouteQuery);
                        bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                    } catch (AMapException e) {
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = pb.this.b;
                        bundle.putParcelable("result", truckRouteRestult);
                        obtainMessage.setData(bundle);
                        pb.this.d.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = pb.this.b;
                    bundle.putParcelable("result", truckRouteRestult);
                    obtainMessage.setData(bundle);
                    pb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }
}
