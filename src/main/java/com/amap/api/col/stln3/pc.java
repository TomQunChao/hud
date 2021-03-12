package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* compiled from: ShareSearchCore */
public class pc implements IShareSearch {
    private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    private static final String f = String.valueOf("");
    private Context a;
    private ShareSearch.OnShareSearchListener g;

    public pc(Context context) {
        this.a = context;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.g = onShareSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass1 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1100;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchPoiShareUrl = pc.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchPoiShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass2 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchBusRouteShareUrl = pc.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchBusRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass3 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1105;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchWalkRouteShareUrl = pc.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass4 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1104;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchDrivingRouteShareUrl = pc.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass5 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchNaviShareUrl = pc.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchNaviShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.pc.AnonymousClass6 */

                public final void run() {
                    if (pc.this.g != null) {
                        Message obtainMessage = nu.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
                        obtainMessage.obj = pc.this.g;
                        try {
                            String searchLocationShareUrl = pc.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchLocationShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            nu.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        nu.a().sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return (String) new oi(this.a, String.format(e, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).a();
                }
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        String str;
        if (shareNaviQuery != null) {
            try {
                ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
                if (fromAndTo.getTo() != null) {
                    LatLonPoint from = fromAndTo.getFrom();
                    LatLonPoint to = fromAndTo.getTo();
                    int naviMode = shareNaviQuery.getNaviMode();
                    if (fromAndTo.getFrom() == null) {
                        str = String.format(d, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    } else {
                        str = String.format(d, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    }
                    return (String) new oi(this.a, str).a();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchNaviShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        if (latLonSharePoint != null) {
            try {
                return (String) new oi(this.a, String.format(c, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).a();
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchLocationShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        if (shareBusRouteQuery != null) {
            try {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return (String) new oi(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, f, f, f)).a();
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchBusRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        if (shareDrivingRouteQuery != null) {
            try {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return (String) new oi(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, f, f, f)).a();
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        if (shareWalkRouteQuery != null) {
            try {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return (String) new oi(this.a, String.format(b, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, f, f, f)).a();
            } catch (AMapException e2) {
                nl.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
                throw e2;
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }
}
