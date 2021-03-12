package com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio;

import com.alibaba.idst.nls.internal.connector.websockets.utils.async.util.HashList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class EventEmitter {
    HashList<EventCallback> callbacks = new HashList<>();

    interface OnceCallback extends EventCallback {
    }

    /* access modifiers changed from: package-private */
    public void onEvent(String str, JSONArray jSONArray, Acknowledge acknowledge) {
        List list = (List) this.callbacks.get(str);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                EventCallback eventCallback = (EventCallback) it.next();
                eventCallback.onEvent(str, jSONArray, acknowledge);
                if (eventCallback instanceof OnceCallback) {
                    it.remove();
                }
            }
        }
    }

    public void addListener(String str, EventCallback eventCallback) {
        on(str, eventCallback);
    }

    public void once(String str, final EventCallback eventCallback) {
        on(str, new OnceCallback() {
            /* class com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.EventEmitter.AnonymousClass1 */

            @Override // com.alibaba.idst.nls.internal.connector.websockets.utils.async.http.socketio.EventCallback
            public void onEvent(String str, JSONArray jSONArray, Acknowledge acknowledge) {
                eventCallback.onEvent(str, jSONArray, acknowledge);
            }
        });
    }

    public void on(String str, EventCallback eventCallback) {
        this.callbacks.add(str, eventCallback);
    }

    public void removeListener(String str, EventCallback eventCallback) {
        List list = (List) this.callbacks.get(str);
        if (list != null) {
            list.remove(eventCallback);
        }
    }
}
