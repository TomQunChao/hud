package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.stln3.mx;
import com.amap.api.col.stln3.my;
import com.amap.api.col.stln3.na;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {
    private static int a = 0;
    private a b;
    private mx c;
    private mx[] d = new mx[32];
    private int e = -1;
    private my f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            na.a(getApplicationContext());
            this.e = -1;
            a = 0;
            mx mxVar = new mx();
            try {
                a++;
                a(mxVar);
                this.e = (this.e + 1) % 32;
                this.d[this.e] = mxVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(mx mxVar) {
        try {
            if (this.b != null) {
                this.b.e();
                this.b = null;
            }
            this.b = b(mxVar);
            if (this.b != null) {
                this.c = mxVar;
                this.b.a(this);
                a aVar = this.b;
                Bundle bundle = this.c.b;
                aVar.a();
                this.b.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a b(mx mxVar) {
        try {
            if (mxVar.a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new my();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            if (this.b != null) {
                a aVar = this.b;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.offlineservice.AMapPermissionActivity
    public void onResume() {
        try {
            super.onResume();
            if (this.b != null) {
                a aVar = this.b;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            if (this.b != null) {
                a aVar = this.b;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            if (this.b != null) {
                a aVar = this.b;
            }
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
            if (!a((Bundle) null)) {
                if (this.b != null) {
                    this.b.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!a(bundle)) {
                if (this.b != null) {
                    this.b.e();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            if ((a != 1 || this.b == null) && a > 1) {
                a--;
                this.e = ((this.e - 1) + 32) % 32;
                mx mxVar = this.d[this.e];
                mxVar.b = bundle;
                a(mxVar);
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
            if (this.b != null) {
                this.b.e();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            if (this.f != null) {
                this.f.e();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            if (this.b != null) {
                this.b.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.b != null && !this.b.c()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
