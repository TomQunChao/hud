package com.amap.api.navi;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.a11hud.www.R;
import com.amap.api.col.stln3.ke;
import com.amap.api.col.stln3.kn;
import com.amap.api.col.stln3.ko;
import com.amap.api.col.stln3.ks;
import com.amap.api.col.stln3.kt;
import com.amap.api.col.stln3.ku;
import com.amap.api.col.stln3.lz;
import com.amap.api.col.stln3.mm;
import com.amap.api.col.stln3.mo;
import com.amap.api.navi.model.AMapCarInfo;
import com.amap.api.navi.model.AMapNaviMarkerOptions;
import com.amap.api.navi.services.view.c;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;

public class AmapRouteActivity extends CheckPermissionsActivity implements View.OnClickListener {
    private static final int PAGE_STACK_LENGTH = 32;
    protected static AmapRouteActivity context;
    private static int pageStackLength = 0;
    private ke currentModule;
    private kn currentPage;
    public int defaultOrientation = GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER;
    public Handler handler = new Handler() {
        /* class com.amap.api.navi.AmapRouteActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    AmapRouteActivity.this.newScr(new kn(3, null));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    };
    private boolean isNeedDestroyDriveManagerInstanceWhenNaviExit = true;
    private boolean isShowExitNaviDialog = true;
    private ks naviPage;
    public int orientation = this.defaultOrientation;
    private kn[] pageStack = new kn[32];
    private int pageStackTop = -1;
    private kt routePage;
    private ku searchPage;
    private ko searchResult = new ko();

    public Handler getHandler() {
        return this.handler;
    }

    public ko getSearchResult() {
        return this.searchResult;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onCreate(Bundle bundle) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
        }
        try {
            super.onCreate(bundle);
            getWindow().addFlags(1024);
            context = this;
            getWindow().setSoftInputMode(32);
            this.orientation = getRequestedOrientation();
            mm.a(getApplicationContext());
            int i2 = R.drawable.$ic_launcher_foreground__0;
            Bundle bundleExtra = getIntent().getBundleExtra(AmapNaviPage.THEME_DATA);
            if (bundleExtra != null) {
                i2 = bundleExtra.getInt(AmapNaviPage.THEME_ID);
            }
            mm.b(this, i2);
            getWindow().setFormat(-3);
            this.pageStackTop = -1;
            pageStackLength = 0;
            Bundle bundleExtra2 = getIntent().getBundleExtra("data");
            if (bundleExtra2 != null) {
                bundleExtra2.putInt("from", 4);
                z = bundleExtra2.getBoolean(AmapNaviPage.PAGE_TYPE, false);
                this.isNeedDestroyDriveManagerInstanceWhenNaviExit = bundleExtra2.getBoolean(AmapNaviPage.ISNEEDDESTROYDRIVEMANAGERINSTANCEWHENNAVIEXIT, true);
                this.isShowExitNaviDialog = bundleExtra2.getBoolean(AmapNaviPage.ISSHOWEXITNAVIDIALOG, true);
                getSearchResult().a((AMapCarInfo) bundleExtra2.getParcelable(AmapNaviPage.CAR_INFO));
                AMapNavi.getInstance(this).setUseInnerVoice(bundleExtra2.getBoolean(AmapNaviPage.ISUSEINNERVOICE), true);
                AMapNavi.getInstance(this).setMultipleRouteNaviMode(bundleExtra2.getBoolean(AmapNaviPage.ISMULTIPLEROUTENAVIMODE));
                i = bundleExtra2.getInt(AmapNaviPage.PLANSTRATEGY, -1);
            } else {
                z = false;
                i = 10;
            }
            if (z) {
                newScr(new kn(2, bundleExtra2));
            } else {
                newScr(new kn(1, bundleExtra2));
            }
            if (i != -1) {
                boolean[] zArr = new boolean[4];
                switch (i) {
                    case 1:
                    case 14:
                        z5 = false;
                        z4 = true;
                        z3 = false;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 2:
                    case 5:
                    case 10:
                    case 11:
                    default:
                        z5 = false;
                        z4 = false;
                        z3 = false;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 3:
                    case 15:
                        z5 = true;
                        z4 = false;
                        z3 = true;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 4:
                    case 12:
                        z5 = true;
                        z4 = false;
                        z3 = false;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 6:
                    case 13:
                        z5 = false;
                        z4 = false;
                        z3 = true;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 7:
                    case 16:
                        z5 = false;
                        z4 = true;
                        z3 = true;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 8:
                    case 17:
                        z5 = true;
                        z4 = true;
                        z3 = false;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 9:
                    case 18:
                        z5 = true;
                        z4 = true;
                        z3 = true;
                        z2 = false;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 19:
                        z5 = false;
                        z4 = false;
                        z3 = false;
                        z2 = true;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                    case 20:
                        z5 = true;
                        z4 = false;
                        z3 = false;
                        z2 = true;
                        zArr[0] = z5;
                        zArr[1] = z4;
                        zArr[2] = z3;
                        zArr[3] = z2;
                        lz.a(this, zArr[0]);
                        lz.b(this, zArr[1]);
                        lz.c(this, zArr[2]);
                        lz.d(this, zArr[3]);
                        break;
                }
            } else {
                i = mo.a(context);
            }
            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
            if (callback != null) {
                callback.onStrategyChanged(i);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.currentModule.e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void switchScr(kn knVar) {
        try {
            if (this.currentModule != null) {
                this.currentModule.f();
                this.currentModule = null;
            }
            this.currentModule = creator(knVar);
            if (this.currentModule != null) {
                this.currentPage = knVar;
                this.currentModule.a(this);
                this.currentModule.a(this.currentPage.b);
                this.currentModule.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void newScr(kn knVar) {
        try {
            pageStackLength++;
            switchScr(knVar);
            this.pageStackTop = (this.pageStackTop + 1) % 32;
            this.pageStack[this.pageStackTop] = knVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private ke creator(kn knVar) {
        try {
            switch (knVar.a) {
                case 1:
                    if (this.routePage == null) {
                        this.routePage = new kt();
                    }
                    return this.routePage;
                case 2:
                    if (this.naviPage == null) {
                        this.naviPage = new ks();
                    }
                    return this.naviPage;
                case 3:
                    if (this.searchPage == null) {
                        this.searchPage = new ku();
                    }
                    return this.searchPage;
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            if (this.currentModule != null) {
                ke keVar = this.currentModule;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.navi.CheckPermissionsActivity
    public void onResume() {
        try {
            super.onResume();
            if (this.currentModule != null) {
                this.currentModule.g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            if (this.currentModule != null) {
                this.currentModule.i();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            if (this.currentModule != null) {
                this.currentModule.h();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showLoadingDialog() {
        showLoadingDialog("loadingFragment");
    }

    public void removeLoadingDialog() {
        removeLoadingDialog("loadingFragment");
    }

    public void showLoadingDialog(String str) {
        try {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            c cVar = new c();
            cVar.setCancelable(true);
            cVar.show(getFragmentManager(), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeLoadingDialog(String str) {
        try {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr() {
        try {
            if (!backScr(null)) {
                if (this.currentModule != null) {
                    this.currentModule.f();
                }
                destroyNavi();
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!backScr(bundle)) {
                if (this.currentModule != null) {
                    this.currentModule.f();
                }
                destroyNavi();
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean backScr(Bundle bundle) {
        try {
            if ((pageStackLength != 1 || this.currentModule == null) && pageStackLength > 1) {
                pageStackLength--;
                this.pageStackTop = ((this.pageStackTop - 1) + 32) % 32;
                kn knVar = this.pageStack[this.pageStackTop];
                knVar.b = bundle;
                switchScr(knVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.currentModule != null) {
                this.currentModule.f();
                this.currentModule = null;
            }
            this.currentPage = null;
            this.pageStack = null;
            if (this.routePage != null) {
                this.routePage.f();
                this.routePage = null;
            }
            if (this.naviPage != null) {
                this.naviPage.f();
                this.naviPage = null;
            }
            if (this.searchPage != null) {
                this.searchPage.f();
                this.searchPage = null;
            }
            callBackExitPage();
            context = null;
            mm.c();
            AmapNaviPage.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            if (this.currentModule != null) {
                this.currentModule.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void destroyNavi() {
        if (this.isNeedDestroyDriveManagerInstanceWhenNaviExit) {
            AMapNavi.getInstance(this).stopNavi();
            AMapNavi.getInstance(this).destroy();
        }
    }

    public void onBackPressed() {
        try {
            if (this.currentModule != null && !this.currentModule.b()) {
                return;
            }
            if (backScr(null)) {
                destroyNavi();
                return;
            }
            destroyNavi();
            this.pageStackTop = -1;
            pageStackLength = 0;
            super.onBackPressed();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isShowExitNaviDialog() {
        return this.isShowExitNaviDialog;
    }

    private void callBackExitPage() {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onExitPage(2);
        }
    }

    public void addPositionMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (this.currentModule instanceof ks) {
            this.naviPage.a(aMapNaviMarkerOptions);
        }
    }

    public void updateMarkerPosition(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (this.currentModule instanceof ks) {
            this.naviPage.b(aMapNaviMarkerOptions);
        }
    }

    public void removePositionMarker(AMapNaviMarkerOptions aMapNaviMarkerOptions) {
        if (this.currentModule instanceof ks) {
            this.naviPage.c(aMapNaviMarkerOptions);
        }
    }
}
