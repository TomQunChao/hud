package com.amap.api.col.stln3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.col.stln3.go;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: AbstractImageFetcher */
public final class id extends ie {
    private TileProvider e = null;

    public id(Context context, int i, int i2) {
        super(context, i, i2);
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            activeNetworkInfo.isConnectedOrConnecting();
        }
    }

    public final void a(TileProvider tileProvider) {
        this.e = tileProvider;
    }

    private Bitmap c(go.a aVar) {
        try {
            Tile tile = this.e.getTile(aVar.a, aVar.b, aVar.c);
            if (tile == null || tile == TileProvider.NO_TILE) {
                return null;
            }
            return BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.stln3.Cif, com.amap.api.col.stln3.ie
    public final Bitmap a(Object obj) {
        return c((go.a) obj);
    }
}
