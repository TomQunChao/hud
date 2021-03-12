package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.amap.api.track.query.model.BaseResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* compiled from: UploadPointResponse */
public final class qb extends BaseResponse {
    public qb(BaseResponse baseResponse) {
        super(baseResponse);
    }

    private static HashSet<Integer> a(String str) {
        HashSet<Integer> hashSet = new HashSet<>();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                int optInt = jSONArray.getJSONObject(i).optInt("_err_point_index", -1);
                if (optInt >= 0) {
                    hashSet.add(Integer.valueOf(optInt));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<java.lang.Long> a(java.util.List<com.amap.api.col.stln3.pt> r5) {
        /*
            r4 = this;
            boolean r0 = r4.isSuccess()
            if (r0 == 0) goto L_0x000b
            java.util.Set r5 = b(r5)
            return r5
        L_0x000b:
            r0 = 20101(0x4e85, float:2.8168E-41)
            int r1 = r4.getErrorCode()
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0020
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            return r5
        L_0x0020:
            int r0 = r4.getErrorCode()
            r1 = 20010(0x4e2a, float:2.804E-41)
            if (r0 == r1) goto L_0x002d
            switch(r0) {
                case 20050: goto L_0x002d;
                case 20051: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            r0 = 0
            goto L_0x002e
        L_0x002d:
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x0035
            java.util.Set r5 = b(r5)
            return r5
        L_0x0035:
            r0 = 20100(0x4e84, float:2.8166E-41)
            int r1 = r4.getErrorCode()
            if (r0 != r1) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r2 = 0
        L_0x003f:
            if (r2 == 0) goto L_0x0046
            java.util.Set r5 = r4.c(r5)
            return r5
        L_0x0046:
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            return r5
            switch-data {20050->0x002d, 20051->0x002d, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.qb.a(java.util.List):java.util.Set");
    }

    private static Set<Long> b(List<pt> list) {
        HashSet hashSet = new HashSet();
        if (list == null) {
            return hashSet;
        }
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Long.valueOf(list.get(i).a()));
        }
        return hashSet;
    }

    private Set<Long> c(List<pt> list) {
        HashSet hashSet = new HashSet();
        HashSet<Integer> a = a(new qd().a(getData()).c("errorpoints"));
        if (list == null) {
            return hashSet;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!a.contains(Integer.valueOf(i))) {
                hashSet.add(Long.valueOf(list.get(i).a()));
            }
        }
        return hashSet;
    }
}
