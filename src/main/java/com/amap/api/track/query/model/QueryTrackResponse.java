package com.amap.api.track.query.model;

import com.amap.api.col.stln3.qd;
import com.amap.api.track.query.entity.Track;
import java.util.List;

public class QueryTrackResponse extends BaseResponse {
    private List<Track> e;
    private int f;

    public QueryTrackResponse(BaseResponse baseResponse) {
        super(baseResponse);
        qd a = new qd().a(getData());
        String c = a.c("tracks");
        int h = a.h("counts");
        this.e = Track.createTracks(c);
        this.f = h;
    }

    public List<Track> getTracks() {
        return this.e;
    }

    public int getCount() {
        return this.f;
    }
}
