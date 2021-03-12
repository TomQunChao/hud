package com.amap.api.track;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amap.api.col.stln3.qc;
import com.amap.api.col.stln3.qu;
import com.amap.api.track.query.model.AddTerminalRequest;
import com.amap.api.track.query.model.AddTerminalResponse;
import com.amap.api.track.query.model.AddTrackRequest;
import com.amap.api.track.query.model.AddTrackResponse;
import com.amap.api.track.query.model.DistanceRequest;
import com.amap.api.track.query.model.DistanceResponse;
import com.amap.api.track.query.model.HistoryTrackRequest;
import com.amap.api.track.query.model.HistoryTrackResponse;
import com.amap.api.track.query.model.LatestPointRequest;
import com.amap.api.track.query.model.LatestPointResponse;
import com.amap.api.track.query.model.OnTrackListener;
import com.amap.api.track.query.model.ParamErrorResponse;
import com.amap.api.track.query.model.QueryTerminalRequest;
import com.amap.api.track.query.model.QueryTerminalResponse;
import com.amap.api.track.query.model.QueryTrackRequest;
import com.amap.api.track.query.model.QueryTrackResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: AMapTrackQueryDelegate */
public final class b {
    private ExecutorService a;
    private Handler b;
    private a c;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.track.b$b  reason: collision with other inner class name */
    /* compiled from: AMapTrackQueryDelegate */
    public static class C0004b {
        public static b a = new b();
    }

    public b() {
        this.a = null;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new a((byte) 0);
        this.a = Executors.newFixedThreadPool(3, new ThreadFactory() {
            /* class com.amap.api.track.b.AnonymousClass1 */

            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("AMapTrackQueryDelegateThread");
                return thread;
            }
        });
    }

    public final void a(final Context context, final AddTerminalRequest addTerminalRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass2 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onCreateTerminalCallback(new AddTerminalResponse(qu.a()));
                        }
                    });
                    return;
                }
                final AddTerminalResponse addTerminalResponse = new AddTerminalResponse(qc.a(context, addTerminalRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onCreateTerminalCallback(addTerminalResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final QueryTerminalRequest queryTerminalRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass3 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onQueryTerminalCallback(new QueryTerminalResponse(qu.a()));
                        }
                    });
                    return;
                }
                final QueryTerminalResponse queryTerminalResponse = new QueryTerminalResponse(qc.a(context, queryTerminalRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onQueryTerminalCallback(queryTerminalResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final DistanceRequest distanceRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass4 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onDistanceCallback(new DistanceResponse(qu.a()));
                        }
                    });
                    return;
                }
                final DistanceResponse distanceResponse = new DistanceResponse(qc.a(context, distanceRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass4.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onDistanceCallback(distanceResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final LatestPointRequest latestPointRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass5 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onLatestPointCallback(new LatestPointResponse(qu.a()));
                        }
                    });
                    return;
                }
                final LatestPointResponse latestPointResponse = new LatestPointResponse(qc.a(context, latestPointRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onLatestPointCallback(latestPointResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final HistoryTrackRequest historyTrackRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass6 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onHistoryTrackCallback(new HistoryTrackResponse(qu.a()));
                        }
                    });
                    return;
                }
                final HistoryTrackResponse historyTrackResponse = new HistoryTrackResponse(qc.a(context, historyTrackRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass6.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onHistoryTrackCallback(historyTrackResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final QueryTrackRequest queryTrackRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass7 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onHistoryTrackCallback(new HistoryTrackResponse(qu.a()));
                        }
                    });
                    return;
                }
                final QueryTrackResponse queryTrackResponse = new QueryTrackResponse(qc.a(context, queryTrackRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass7.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onQueryTrackCallback(queryTrackResponse);
                    }
                });
            }
        });
    }

    public final void a(final Context context, final AddTrackRequest addTrackRequest, final int i, final OnTrackListener onTrackListener) {
        this.a.execute(new Runnable() {
            /* class com.amap.api.track.b.AnonymousClass8 */

            public final void run() {
                final OnTrackListener onTrackListener = onTrackListener;
                if (onTrackListener == null) {
                    onTrackListener = b.this.c;
                }
                if (!qc.a(context)) {
                    b.this.b.post(new Runnable() {
                        /* class com.amap.api.track.b.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            onTrackListener.onHistoryTrackCallback(new HistoryTrackResponse(qu.a()));
                        }
                    });
                    return;
                }
                final AddTrackResponse addTrackResponse = new AddTrackResponse(qc.a(context, addTrackRequest, i));
                b.this.b.post(new Runnable() {
                    /* class com.amap.api.track.b.AnonymousClass8.AnonymousClass2 */

                    public final void run() {
                        onTrackListener.onAddTrackCallback(addTrackResponse);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* compiled from: AMapTrackQueryDelegate */
    public static class a implements OnTrackListener {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onQueryTerminalCallback(QueryTerminalResponse queryTerminalResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onCreateTerminalCallback(AddTerminalResponse addTerminalResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onDistanceCallback(DistanceResponse distanceResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onLatestPointCallback(LatestPointResponse latestPointResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onHistoryTrackCallback(HistoryTrackResponse historyTrackResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onQueryTrackCallback(QueryTrackResponse queryTrackResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onAddTrackCallback(AddTrackResponse addTrackResponse) {
        }

        @Override // com.amap.api.track.query.model.OnTrackListener
        public final void onParamErrorCallback(ParamErrorResponse paramErrorResponse) {
        }
    }
}
