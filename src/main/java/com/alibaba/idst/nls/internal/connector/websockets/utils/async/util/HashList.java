package com.alibaba.idst.nls.internal.connector.websockets.utils.async.util;

import java.util.ArrayList;
import java.util.Hashtable;

public class HashList<T> extends Hashtable<String, ArrayList<T>> {
    private static final long serialVersionUID = 1;

    public boolean contains(String str) {
        ArrayList arrayList = (ArrayList) get(str);
        return arrayList != null && arrayList.size() > 0;
    }

    public void add(String str, T t) {
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            put(str, arrayList);
        }
        arrayList.add(t);
    }
}
