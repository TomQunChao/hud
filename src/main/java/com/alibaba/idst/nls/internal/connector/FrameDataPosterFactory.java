package com.alibaba.idst.nls.internal.connector;

import android.content.Context;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;

public class FrameDataPosterFactory {
    private static PostFrameInterface poster = null;
    public static PosterType sDefaultPosterType = PosterType.WEBSOCKET_POSTER;

    public enum PosterType {
        HTTP_POSTER,
        WEBSOCKET_POSTER
    }

    public static PostFrameInterface newInstance(Context context, NlsRequest nlsRequest) {
        return newInstance(context, nlsRequest, sDefaultPosterType);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.idst.nls.internal.connector.FrameDataPosterFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$idst$nls$internal$connector$FrameDataPosterFactory$PosterType = new int[PosterType.values().length];

        static {
            try {
                $SwitchMap$com$alibaba$idst$nls$internal$connector$FrameDataPosterFactory$PosterType[PosterType.WEBSOCKET_POSTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static PostFrameInterface newInstance(Context context, NlsRequest nlsRequest, PosterType posterType) {
        poster = null;
        if (AnonymousClass1.$SwitchMap$com$alibaba$idst$nls$internal$connector$FrameDataPosterFactory$PosterType[posterType.ordinal()] == 1) {
            poster = new WebsocketPostFrameData(context, nlsRequest);
        }
        HttpGetQtEv.setPosterType(posterType);
        return poster;
    }

    public static void destory() {
        poster.destory();
    }
}
