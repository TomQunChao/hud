package com.amap.api.col.stln3;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.stln3.gs;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMapCustomStyleManager */
public final class bv implements gs.a {
    private co a;
    private CustomMapStyleOptions b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private int f = 1;
    private Context g;
    private byte[] h = null;
    private byte[] i = null;
    private byte[] j = null;
    private byte[] k = null;
    private byte[] l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private gs q;
    private byte[] r = null;
    private boolean s = false;

    public bv(co coVar, Context context) {
        this.a = coVar;
        this.g = context;
        this.m = false;
        this.n = false;
    }

    public final void a() {
        if (this.b != null && !this.n) {
            try {
                MapConfig mapConfig = this.a.getMapConfig();
                if (mapConfig != null) {
                    synchronized (this) {
                        if (mapConfig.isHideLogoEnable()) {
                            if (this.a != null && this.a.k() != null) {
                                if (this.a.k().isLogoEnable()) {
                                    if (!this.b.isEnable()) {
                                        this.a.k().setLogoEnable(true);
                                    } else if (this.p) {
                                        this.a.k().setLogoEnable(false);
                                    }
                                } else if (!this.p) {
                                    this.a.k().setLogoEnable(true);
                                }
                            }
                        }
                        if (this.c) {
                            if (this.b.isEnable()) {
                                this.a.a().setNativeMapModeAndStyle(this.f, 0, 0, 0, false, false, null);
                                mapConfig.setCustomStyleEnable(true);
                                this.c = false;
                            } else {
                                this.a.a().setNativeMapModeAndStyle(this.f, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime(), mapConfig.getMapStyleState(), false, false, null);
                                this.p = false;
                                if (mapConfig.isCustomStyleEnable()) {
                                    if (mapConfig.getMapStyleMode() == 0) {
                                        if (mapConfig.getMapStyleTime() == 0) {
                                            if (mapConfig.getMapStyleState() == 0) {
                                                if (this.i == null) {
                                                    Context context = this.g;
                                                    this.i = c(FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
                                                }
                                                byte[] bArr = this.h;
                                                this.a.a().setCustomStyleData(this.f, this.i, this.h);
                                                this.p = false;
                                            }
                                        }
                                    }
                                    f();
                                    mapConfig.setCustomStyleEnable(false);
                                }
                                this.c = false;
                                return;
                            }
                        }
                        if (this.e) {
                            String styleTexturePath = this.b.getStyleTexturePath();
                            if (this.b.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                                this.b.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                            }
                            if (this.b.getStyleTextureData() != null) {
                                this.s = true;
                                if (mapConfig.isProFunctionAuthEnable()) {
                                    this.o = true;
                                    this.a.a().setCustomStyleTexture(this.f, this.b.getStyleTextureData());
                                    mapConfig.setUseProFunction(true);
                                } else {
                                    f();
                                }
                            } else {
                                f();
                                this.s = false;
                            }
                            this.e = false;
                        }
                        if (this.d) {
                            String styleDataPath = this.b.getStyleDataPath();
                            if (this.b.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                                this.b.setStyleData(FileUtil.readFileContents(styleDataPath));
                            }
                            if (this.b.getStyleData() == null) {
                                if (this.r == null) {
                                    if (this.p) {
                                        this.c = true;
                                        this.b.setEnable(false);
                                    }
                                    this.d = false;
                                }
                            }
                            if (this.l == null) {
                                Context context2 = this.g;
                                this.l = FileUtil.readFileContentsFromAssets(context2, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE);
                            }
                            byte[] styleData = this.r != null ? this.r : this.b.getStyleData();
                            if (!b(styleData)) {
                                he.a();
                            } else {
                                this.a.a().setCustomStyleData(this.f, styleData, this.l);
                                this.p = true;
                                if (this.a != null) {
                                    this.a.resetRenderTime();
                                }
                            }
                            this.d = false;
                        }
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "AMapCustomStyleManager", "updateStyle");
            }
        }
    }

    private static boolean b(byte[] bArr) {
        gw a2;
        if (bArr == null) {
            return true;
        }
        try {
            if (!(bArr.length >= 10240 || (a2 = gz.a((byte[]) bArr.clone())) == null || a2.a() == null)) {
                try {
                    new JSONObject(a2.a());
                    return false;
                } catch (JSONException e2) {
                    rx.c(e2, "AMapCustomStyleManager", "checkData");
                }
            }
        } catch (Throwable th) {
            rx.c(th, "AMapCustomStyleManager", "checkData");
        }
        return true;
    }

    private void f() {
        if (this.o) {
            if (this.k == null) {
                Context context = this.g;
                this.k = FileUtil.readFileContentsFromAssets(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.o = false;
            this.a.a().setCustomStyleTexture(this.f, this.k);
        }
    }

    public final void a(CustomMapStyleOptions customMapStyleOptions) {
        if (this.b != null && customMapStyleOptions != null) {
            synchronized (this) {
                if (!this.m) {
                    this.m = true;
                    if (this.b.isEnable()) {
                        this.c = true;
                    }
                }
                if (this.b.isEnable() != customMapStyleOptions.isEnable()) {
                    this.b.setEnable(customMapStyleOptions.isEnable());
                    this.c = true;
                }
                if (this.b.isEnable()) {
                    if (!TextUtils.equals(this.b.getStyleId(), customMapStyleOptions.getStyleId())) {
                        this.b.setStyleId(customMapStyleOptions.getStyleId());
                        String styleId = this.b.getStyleId();
                        if (!TextUtils.isEmpty(styleId)) {
                            if (this.a != null && this.a.getMapConfig() != null) {
                                if (this.a.getMapConfig().isProFunctionAuthEnable()) {
                                    if (this.q == null) {
                                        this.q = new gs(this.g, this);
                                    }
                                    this.q.a(styleId);
                                    this.q.b();
                                }
                            }
                        }
                    }
                    if (!TextUtils.equals(this.b.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                        this.b.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                        this.d = true;
                    }
                    if (this.b.getStyleData() != customMapStyleOptions.getStyleData()) {
                        this.b.setStyleData(customMapStyleOptions.getStyleData());
                        this.d = true;
                    }
                    if (!TextUtils.equals(this.b.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                        this.b.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                        this.e = true;
                    }
                    if (this.b.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                        this.b.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                        this.e = true;
                    }
                    ia.a(this.g, true);
                } else {
                    g();
                    ia.a(this.g, false);
                }
            }
        }
    }

    public final void b() {
        if (this.b != null) {
            synchronized (this) {
                if (!(this.a == null || this.a.getMapConfig() == null)) {
                    if (!this.a.getMapConfig().isProFunctionAuthEnable()) {
                        this.b.setStyleId(null);
                        this.r = null;
                    }
                }
                this.e = true;
                this.d = true;
                this.c = true;
            }
        }
    }

    private static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.stln3.gs.a
    public final void a(byte[] bArr) {
        if (this.b != null) {
            synchronized (this) {
                if (this.a != null) {
                    MapConfig mapConfig = this.a.getMapConfig();
                    if (mapConfig != null && mapConfig.isProFunctionAuthEnable()) {
                        mapConfig.setUseProFunction(true);
                        this.r = bArr;
                        this.d = true;
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.b == null) {
            this.b = new CustomMapStyleOptions();
        }
    }

    public final boolean d() {
        return this.b != null;
    }

    public final void e() {
        synchronized (this) {
            if (this.b != null) {
                this.b.setEnable(false);
                g();
                this.c = true;
            }
        }
    }

    private void g() {
        CustomMapStyleOptions customMapStyleOptions = this.b;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.b.setStyleDataPath(null);
            this.b.setStyleData(null);
            this.b.setStyleTexturePath(null);
            this.b.setStyleTextureData(null);
        }
    }
}
