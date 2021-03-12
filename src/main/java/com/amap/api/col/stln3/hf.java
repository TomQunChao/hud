package com.amap.api.col.stln3;

import android.text.TextUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* compiled from: BaseTileProvider */
public final class hf implements TileProvider {
    Random a = new Random();
    private final int b = 256;
    private final int c = 256;
    private MapConfig d;

    public hf(MapConfig mapConfig) {
        this.d = mapConfig;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            byte[] a2 = a(i, i2, i3, this.d != null ? this.d.getMapLanguage() : "zh_cn");
            if (a2 == null) {
                return NO_TILE;
            }
            return Tile.obtain(this.b, this.c, a2);
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    private byte[] a(int i, int i2, int i3, String str) throws IOException {
        try {
            return new a(i, i2, i3, str).makeHttpRequest();
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: BaseTileProvider */
    public class a extends hb {
        private int e;
        private int f;
        private int g;
        private String h;
        private String i = "";

        public a(int i2, int i3, int i4, String str) {
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = str;
            this.i = (hv.a(this.e, this.f, this.g) || this.g < 7) ? String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((hf.this.a.nextInt(100000) % 4) + 1)) : MapsInitializer.isLoadWorldGridMap() ? "http://restapi.amap.com/v4/gridmap?" : null;
            setProxy(rh.a(ct.a));
            setConnectionTimeout(5000);
            setSoTimeout(50000);
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public final Map<String, String> getRequestHead() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", ch.c);
            hashtable.put("Accept-Encoding", "gzip");
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.6.0", "3dmap"));
            hashtable.put("x-INFO", rb.a(ct.a));
            hashtable.put("key", qy.f(ct.a));
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        private static String a(String str) {
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(b(str2));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        }

        private static String b(String str) {
            if (str == null) {
                return str;
            }
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                rx.c(e2, "AbstractProtocalHandler", "strReEncoder");
                return "";
            } catch (Exception e3) {
                rx.c(e3, "AbstractProtocalHandler", "strReEncoderException");
                return "";
            }
        }

        @Override // com.amap.api.col.stln3.tw, com.amap.api.col.stln3.hb
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.stln3.tw
        public final String getURL() {
            String str;
            if (TextUtils.isEmpty(this.i)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(qy.f(ct.a));
            stringBuffer.append("&channel=amapapi");
            if (hv.a(this.e, this.f, this.g) || this.g < 7) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.g);
                stringBuffer.append("&x=");
                stringBuffer.append(this.e);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f);
                str = "&lang=en&size=1&scale=1&style=7";
            } else {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.e);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.g);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.h);
                    str = "&scale=2";
                }
                String stringBuffer2 = stringBuffer.toString();
                String a = a(stringBuffer2);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(stringBuffer2);
                String a2 = rb.a();
                stringBuffer3.append("&ts=" + a2);
                stringBuffer3.append("&scode=" + rb.a(ct.a, a2, a));
                sb.append(stringBuffer3.toString());
                return sb.toString();
            }
            stringBuffer.append(str);
            String stringBuffer22 = stringBuffer.toString();
            String a3 = a(stringBuffer22);
            StringBuffer stringBuffer32 = new StringBuffer();
            stringBuffer32.append(stringBuffer22);
            String a22 = rb.a();
            stringBuffer32.append("&ts=" + a22);
            stringBuffer32.append("&scode=" + rb.a(ct.a, a22, a3));
            sb.append(stringBuffer32.toString());
            return sb.toString();
        }
    }
}
