package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.stln3.nk;
import com.amap.api.col.stln3.ox;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.sk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

public final class Inputtips {
    private IInputtipsSearch a = null;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        try {
            this.a = (IInputtipsSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.InputtipsSearchWrapper", ox.class, new Class[]{Context.class, InputtipsListener.class}, new Object[]{context, inputtipsListener});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ox(context, inputtipsListener);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        try {
            this.a = (IInputtipsSearch) sk.a(context, nk.a(true), "com.amap.api.services.dynamic.InputtipsSearchWrapper", ox.class, new Class[]{Context.class, InputtipsQuery.class}, new Object[]{context, inputtipsQuery});
        } catch (qx e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ox(context, inputtipsQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final InputtipsQuery getQuery() {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public final void setQuery(InputtipsQuery inputtipsQuery) {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }

    public final void setInputtipsListener(InputtipsListener inputtipsListener) {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public final void requestInputtipsAsyn() {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public final List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public final void requestInputtips(String str, String str2) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }
}
