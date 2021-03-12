package com.amap.api.col.stln3;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDownloadList */
public final class ee {
    public ArrayList<OfflineMapProvince> a = new ArrayList<>();
    private ep b;
    private Context c;

    public ee(Context context) {
        this.c = context;
        this.b = ep.a(context);
    }

    private void a(ek ekVar) {
        ep epVar = this.b;
        if (epVar != null && ekVar != null) {
            epVar.a(ekVar);
        }
    }

    private void b(ek ekVar) {
        ep epVar = this.b;
        if (epVar != null) {
            epVar.b(ekVar);
        }
    }

    private static boolean a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    public final ArrayList<OfflineMapProvince> a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCode().equals(str)) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final OfflineMapCity b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final OfflineMapProvince c(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.a) {
            if (this.a.size() > 0) {
                for (int i = 0; i < this.a.size(); i++) {
                    OfflineMapProvince offlineMapProvince2 = this.a.get(i);
                    Iterator<OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        }
                        if (!offlineMapProvince2.getPinyin().equals("quanguogaiyaotu")) {
                            if (!offlineMapProvince2.getProvinceCode().equals("000001")) {
                                if (offlineMapProvince2.getProvinceCode().equals("100000")) {
                                }
                            }
                        }
                        if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                            break;
                        }
                    }
                    if (offlineMapProvince != null) {
                        offlineMapProvince2.setUrl(offlineMapProvince.getUrl());
                        offlineMapProvince2.setVersion(offlineMapProvince.getVersion());
                        offlineMapProvince2.setSize(offlineMapProvince.getSize());
                        offlineMapProvince2.setPinyin(offlineMapProvince.getPinyin());
                        offlineMapProvince2.setJianpin(offlineMapProvince.getJianpin());
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i2);
                            Iterator<OfflineMapCity> it2 = cityList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    offlineMapCity = null;
                                    break;
                                }
                                offlineMapCity = it2.next();
                                if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                offlineMapCity2.setUrl(offlineMapCity.getUrl());
                                offlineMapCity2.setVersion(offlineMapCity.getVersion());
                                offlineMapCity2.setSize(offlineMapCity.getSize());
                                offlineMapCity2.setCode(offlineMapCity.getCode());
                                offlineMapCity2.setPinyin(offlineMapCity.getPinyin());
                                offlineMapCity2.setJianpin(offlineMapCity.getJianpin());
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince offlineMapProvince3 : list) {
                    this.a.add(offlineMapProvince3);
                }
            }
        }
    }

    public final ArrayList<OfflineMapCity> c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getState() != 4) {
                            if (offlineMapCity.getState() == 7) {
                            }
                        }
                        arrayList.add(offlineMapCity);
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    if (next.getState() != 4) {
                        if (next.getState() == 7) {
                        }
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (a(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    if (a(next.getState())) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean a(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.col.stln3.dz r9) {
        /*
        // Method dump skipped, instructions count: 351
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.ee.a(com.amap.api.col.stln3.dz):void");
    }

    private void b(dz dzVar) {
        File[] listFiles = new File(ic.c(this.c)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.exists() && file.getName().contains(dzVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                    file.delete();
                }
            }
        }
    }

    public final void g() {
        ArrayList<OfflineMapProvince> arrayList = this.a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.a.clear();
            }
        }
        this.b = null;
        this.c = null;
    }
}
