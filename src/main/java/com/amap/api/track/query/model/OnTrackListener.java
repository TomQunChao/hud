package com.amap.api.track.query.model;

public interface OnTrackListener {
    void onAddTrackCallback(AddTrackResponse addTrackResponse);

    void onCreateTerminalCallback(AddTerminalResponse addTerminalResponse);

    void onDistanceCallback(DistanceResponse distanceResponse);

    void onHistoryTrackCallback(HistoryTrackResponse historyTrackResponse);

    void onLatestPointCallback(LatestPointResponse latestPointResponse);

    void onParamErrorCallback(ParamErrorResponse paramErrorResponse);

    void onQueryTerminalCallback(QueryTerminalResponse queryTerminalResponse);

    void onQueryTrackCallback(QueryTrackResponse queryTrackResponse);
}
