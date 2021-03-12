package com.amap.api.track;

import android.content.Context;
import com.amap.api.track.query.model.AddTerminalRequest;
import com.amap.api.track.query.model.AddTrackRequest;
import com.amap.api.track.query.model.DistanceRequest;
import com.amap.api.track.query.model.HistoryTrackRequest;
import com.amap.api.track.query.model.LatestPointRequest;
import com.amap.api.track.query.model.OnTrackListener;
import com.amap.api.track.query.model.QueryTerminalRequest;
import com.amap.api.track.query.model.QueryTrackRequest;

public final class AMapTrackClient {
    private a a;

    public AMapTrackClient(Context context) {
        this.a = new a(context);
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public final void setCacheSize(int i) {
        this.a.a(i);
    }

    public final void setInterval(int i, int i2) {
        this.a.a(i, i2);
    }

    public final void setLocationMode(int i) {
        this.a.b(i);
    }

    public final void setOnTrackListener(OnTrackLifecycleListener onTrackLifecycleListener) {
        this.a.a(onTrackLifecycleListener);
    }

    public final void setProtocolType(int i) {
        this.a.c(i);
    }

    public final void startGather(OnTrackLifecycleListener onTrackLifecycleListener) {
        this.a.b(onTrackLifecycleListener);
    }

    public final void startTrack(TrackParam trackParam, OnTrackLifecycleListener onTrackLifecycleListener) {
        this.a.a(trackParam, onTrackLifecycleListener);
    }

    public final void setTrackId(long j) {
        this.a.a(j);
    }

    public final long getTrackId() {
        return this.a.a();
    }

    public final void stopGather(OnTrackLifecycleListener onTrackLifecycleListener) {
        this.a.c(onTrackLifecycleListener);
    }

    public final void stopTrack(TrackParam trackParam, OnTrackLifecycleListener onTrackLifecycleListener) {
        this.a.b(trackParam, onTrackLifecycleListener);
    }

    public final void queryTerminal(QueryTerminalRequest queryTerminalRequest, OnTrackListener onTrackListener) {
        this.a.a(queryTerminalRequest, onTrackListener);
    }

    public final void addTerminal(AddTerminalRequest addTerminalRequest, OnTrackListener onTrackListener) {
        this.a.a(addTerminalRequest, onTrackListener);
    }

    public final void queryDistance(DistanceRequest distanceRequest, OnTrackListener onTrackListener) {
        this.a.a(distanceRequest, onTrackListener);
    }

    public final void queryLatestPoint(LatestPointRequest latestPointRequest, OnTrackListener onTrackListener) {
        this.a.a(latestPointRequest, onTrackListener);
    }

    public final void queryHistoryTrack(HistoryTrackRequest historyTrackRequest, OnTrackListener onTrackListener) {
        this.a.a(historyTrackRequest, onTrackListener);
    }

    public final void queryTerminalTrack(QueryTrackRequest queryTrackRequest, OnTrackListener onTrackListener) {
        this.a.a(queryTrackRequest, onTrackListener);
    }

    public final void addTrack(AddTrackRequest addTrackRequest, OnTrackListener onTrackListener) {
        this.a.a(addTrackRequest, onTrackListener);
    }
}
