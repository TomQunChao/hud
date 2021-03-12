package com.amap.api.track.query.model;

import com.amap.api.track.query.entity.HistoryTrack;

public final class HistoryTrackResponse extends BaseResponse {
    private HistoryTrack e = HistoryTrack.createFromData(getData());

    public HistoryTrackResponse(BaseResponse baseResponse) {
        super(baseResponse);
    }

    public final HistoryTrack getHistoryTrack() {
        return this.e;
    }

    public final void setHistoryTrack(HistoryTrack historyTrack) {
        this.e = historyTrack;
    }
}
