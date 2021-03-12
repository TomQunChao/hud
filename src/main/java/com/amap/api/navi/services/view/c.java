package com.amap.api.navi.services.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.amap.api.col.stln3.mm;
import com.amap.api.navi.R;

/* compiled from: LoadingFragment */
public final class c extends DialogFragment {
    private Animation a;

    public final Dialog onCreateDialog(Bundle bundle) {
        return a(getActivity());
    }

    private Dialog a(Context context) {
        try {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            View a2 = mm.a(getActivity(), R.layout.amap_navi_lbs_loading, null);
            this.a = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.a.setRepeatCount(-1);
            this.a.setInterpolator(new LinearInterpolator());
            this.a.setDuration(2000);
            this.a.setRepeatCount(-1);
            ((ImageView) a2.findViewById(R.id.navi_sdk_route_select_loading)).startAnimation(this.a);
            dialog.setContentView(a2);
            dialog.setCancelable(false);
            return dialog;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        try {
            super.onDismiss(dialogInterface);
            if (this.a != null && getActivity() != null && !getActivity().isFinishing()) {
                this.a.cancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
