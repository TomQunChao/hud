package com.amap.api.col.stln3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore */
public class ox implements IInputtipsSearch {
    private Context a;
    private Inputtips.InputtipsListener b;
    private Handler c = nu.a();
    private InputtipsQuery d;

    public ox(Context context, Inputtips.InputtipsListener inputtipsListener) {
        this.a = context.getApplicationContext();
        this.b = inputtipsListener;
    }

    public ox(Context context, InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtipsAsyn() {
        try {
            ok.a().a(new Runnable() {
                /* class com.amap.api.col.stln3.ox.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = nu.a().obtainMessage();
                    obtainMessage.obj = ox.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        ArrayList<? extends Parcelable> a2 = ox.this.a((ox) ox.this.d);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("result", a2);
                        obtainMessage.setData(bundle);
                        obtainMessage.what = 1000;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        ox.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ox.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            nl.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        this.d = new InputtipsQuery(str, str2);
        this.d.setType(str3);
        requestInputtipsAsyn();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            ns.a(this.a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                return (ArrayList) new nq(this.a, inputtipsQuery).a();
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (Throwable th) {
            nl.a(th, "Inputtips", "requestInputtips");
            if (!(th instanceof AMapException)) {
                return null;
            }
            throw ((AMapException) th);
        }
    }
}
