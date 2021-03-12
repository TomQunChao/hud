package com.amap.api.col.stln3;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.text.TextUtils;
import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.NlsListener;
import com.alibaba.idst.nls.internal.protocol.NlsRequest;
import com.alibaba.idst.nls.internal.protocol.NlsRequestProto;
import com.amap.api.navi.enums.AliTTS;
import com.amap.api.navi.enums.NetWorkingProtocol;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ALiTTS */
public final class mc implements AudioManager.OnAudioFocusChangeListener {
    int a = AudioTrack.getMinBufferSize(this.m, 4, 2);
    AudioTrack b = new AudioTrack(3, this.m, 4, 2, this.a, 1);
    long c = 0;
    boolean d = false;
    private final String e = "ALiTTS";
    private Context f;
    private NlsClient g;
    private NlsRequest h;
    private AudioManager i = null;
    private BlockingQueue<byte[]> j = new LinkedBlockingQueue();
    private boolean k = false;
    private boolean l = true;
    private int m = 8000;
    private int n = 0;
    private boolean o = true;
    private long p = 0;
    private boolean q = false;
    private boolean r;
    private NlsListener s = new NlsListener() {
        /* class com.amap.api.col.stln3.mc.AnonymousClass1 */

        @Override // com.alibaba.idst.nls.NlsListener
        public final void onRecognizingResult(int i, NlsListener.RecognizedResult recognizedResult) {
            try {
                mc mcVar = mc.this;
                mc.b(i);
            } catch (Throwable th) {
                rx.c(th, "AliTTS", "onRecognizingResult");
                th.printStackTrace();
                mj.a(false);
            }
        }

        @Override // com.alibaba.idst.nls.NlsListener
        public final void onTtsResult(int i, byte[] bArr) {
            String str = "-------->>  onTtsResult is " + i;
            if (i != 530) {
                switch (i) {
                    case 6:
                        mc.this.k = true;
                        if (!mc.this.r) {
                            jg.a().execute(new a(mc.this, (byte) 0));
                            mc.this.r = true;
                        }
                        mc.this.j.add(bArr);
                        return;
                    case 7:
                        mc.this.j.add(bArr);
                        return;
                    case 8:
                        return;
                    default:
                        try {
                            mc mcVar = mc.this;
                            mc.b(i);
                            return;
                        } catch (Throwable th) {
                            rx.c(th, "AliTTS", "onTtsResult");
                            th.printStackTrace();
                            return;
                        }
                }
            } else {
                rx.c(new Exception("NlsClient.ErrorCode.CONNECT_ERROR"), "AliTTS", "NlsClient.ErrorCode.CONNECT_ERROR");
                mj.a(false);
            }
        }
    };

    static /* synthetic */ void b(int i2) {
        Exception exc;
        String str;
        String str2;
        switch (i2) {
            case 1:
                exc = new Exception("NlsClient.ErrorCode.RECOGNIZE_ERROR");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.RECOGNIZE_ERROR";
                break;
            case NlsClient.ErrorCode.ERROR_FORMAT:
                exc = new Exception("NlsClient.ErrorCode.ERROR_FORMAT");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_FORMAT";
                break;
            case NlsClient.ErrorCode.ERROR_NEED_DATA_PLUS_AUTH:
                exc = new Exception("NlsClient.ErrorCode.ERROR_NEED_DATA_PLUS_AUTH");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_NEED_DATA_PLUS_AUTH";
                break;
            case NlsClient.ErrorCode.ERROR_AUTH_FAILD:
                exc = new Exception("NlsClient.ErrorCode.ERROR_AUTH_FAILD");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_AUTH_FAILD";
                break;
            case NlsClient.ErrorCode.ERROR_REQUEST_TIMEOUT:
                exc = new Exception("NlsClient.ErrorCode.ERROR_REQUEST_TIMEOUT");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_REQUEST_TIMEOUT";
                break;
            case NlsClient.ErrorCode.ERROR_OVER_CONNECTION_LIMITED:
                exc = new Exception("NlsClient.ErrorCode.ERROR_OVER_CONNECTION_LIMITED");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_OVER_CONNECTION_LIMITED";
                break;
            case 500:
                exc = new Exception("NlsClient.ErrorCode.SERVER_HANDLING_ERROR");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.SERVER_HANDLING_ERROR";
                break;
            case NlsClient.ErrorCode.SERVICE_NOT_AVAILABLE:
                exc = new Exception("NlsClient.ErrorCode.SERVICE_NOT_AVAILABLE");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.SERVICE_NOT_AVAILABLE";
                break;
            case NlsClient.ErrorCode.NO_RECORDING_PERMISSION:
                rx.c(new Exception("NlsClient.ErrorCode.NO_RECORDING_PERMISSION"), "AliTTS", "NlsClient.ErrorCode.NO_RECORDING_PERMISSION");
                mj.a(false);
                return;
            case NlsClient.ErrorCode.CONNECT_ERROR:
                exc = new Exception("NlsClient.ErrorCode.CONNECT_ERROR");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.CONNECT_ERROR";
                break;
            case NlsClient.ErrorCode.ERROR_CLICK_TOOMUCH:
                exc = new Exception("NlsClient.ErrorCode.ERROR_CLICK_TOOMUCH");
                str = "AliTTS";
                str2 = "NlsClient.ErrorCode.ERROR_CLICK_TOOMUCH";
                break;
            default:
                return;
        }
        rx.c(exc, str, str2);
        mj.a(false);
    }

    public mc(Context context) {
        this.f = context;
        this.i = (AudioManager) context.getSystemService("audio");
    }

    /* compiled from: ALiTTS */
    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(mc mcVar, byte b) {
            this();
        }

        public final void run() {
            try {
                mc.this.b.play();
                while (mc.this.k) {
                    byte[] bArr = (byte[]) mc.this.j.poll();
                    if (bArr != null) {
                        if (!mc.this.q) {
                            if (mc.this.i.requestAudioFocus(mc.this, 3, 3) == 1) {
                                mc.this.q = true;
                            } else {
                                mj.a(false);
                            }
                        }
                        mc.this.b.write(bArr, 0, bArr.length);
                        mc.this.p = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - mc.this.p > 100) {
                        mc.this.g();
                        if (mj.a && System.currentTimeMillis() - mc.this.c > 2000) {
                            mj.a(false);
                        }
                    }
                }
            } catch (Throwable th) {
                rx.c(th, "AliTTS", "playTTS");
                mj.a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        if (this.q) {
            this.q = false;
            mj.a(false);
            this.i.abandonAudioFocus(this);
        }
    }

    public final void onAudioFocusChange(int i2) {
    }

    public final void a() {
        try {
            this.h = new NlsRequest(new NlsRequestProto(this.f));
            this.h.setApp_key("1ad3bf8a");
            this.h.initTts();
            NlsClient.openLog(false);
            NlsClient.configure(this.f);
            this.g = NlsClient.newInstance(this.f, this.s, null, this.h);
            if (jv.a != NetWorkingProtocol.HTTP) {
                this.g.setHost(true, "nls.dataapi.aliyun.com/websocket");
            } else if (rf.a().b()) {
                this.g.setHost(true, "nls.dataapi.aliyun.com/websocket");
            } else {
                this.g.setHost(false, "nls.dataapi.aliyun.com/websocket");
            }
            h();
            this.h.setTtsEncodeType(AliTTS.TTS_ENCODETYPE_PCM);
            this.h.setTtsSpeechRate(20);
            this.h.setTtsNus(0);
            this.h.setTtsVoice(AliTTS.TTS_VOICE_WOMAN);
            ly.a(this.f, "TTS_EXCEED_COUNT", false);
        } catch (Throwable th) {
            rx.c(th, "AliTTS", "init");
            th.printStackTrace();
        }
    }

    private void h() {
        this.h.authorize(rk.c(me.a), rk.c(me.b));
    }

    public final void a(String str) {
        try {
            this.c = System.currentTimeMillis();
            if (str != null && str.length() > 0) {
                if (this.o) {
                    this.n = ly.b(this.f, "tts_compose_count", 0);
                    me.c = ly.b(this.f, "tts_statistics_rate", 1);
                    me.d = ly.b(this.f, "tts_statistics_able", false);
                    if (ly.b(this.f, "tts_ali_able", false)) {
                        String c2 = ly.c(this.f, "tts_ali_id", null);
                        String c3 = ly.c(this.f, "tts_ali_secret", null);
                        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3)) {
                            me.a = c2;
                            me.b = c3;
                        }
                    }
                    this.o = false;
                }
                if (this.l) {
                    if (!i()) {
                        mj.a(true);
                        h();
                        NlsClient nlsClient = this.g;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.m);
                        if (!nlsClient.PostTtsRequest(str, sb.toString())) {
                            mj.a(false);
                        }
                    }
                    this.n++;
                }
            }
        } catch (Throwable th) {
            rx.c(th, "AliTTS", "playText");
            th.printStackTrace();
        }
    }

    private boolean i() {
        if (this.n >= me.c) {
            if (!me.d) {
                return false;
            }
            try {
                int i2 = me.c;
                if (this.d) {
                    i2 = 0;
                }
                jg.a().execute(new kb(this.f, i2, new jx() {
                    /* class com.amap.api.col.stln3.mc.AnonymousClass2 */

                    @Override // com.amap.api.col.stln3.jx
                    public final void a(int i) {
                        boolean z;
                        if (i == 10019 || i == 10020 || i == 10003 || i == 40000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        try {
                            mc.this.n -= me.c;
                            if (mc.this.n < 0) {
                                mc.this.n = 0;
                            }
                            mc.this.d = z;
                        } catch (Throwable th) {
                            rx.c(th, "AliTTS", "onResult");
                        }
                    }
                }));
            } catch (Throwable th) {
                rx.c(th, "AliTTS", "statisticsTTSCompose");
                th.printStackTrace();
            }
        }
        return this.d;
    }

    public final void b() {
        try {
            this.l = false;
            if (!(this.b == null || this.b.getState() == 0)) {
                this.b.stop();
            }
            if (this.j != null) {
                this.j.clear();
            }
            this.k = false;
            this.r = false;
            g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c() {
        try {
            this.k = false;
            this.r = false;
            if (this.b != null) {
                this.b.flush();
                this.b.release();
            }
            if (this.g != null) {
                this.g.destory();
                this.g = null;
            }
            this.h = null;
            g();
            mj.a(false);
            ly.a(this.f, "tts_compose_count", this.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d() {
    }

    public final void e() {
        this.l = true;
        this.k = true;
    }

    public final void f() {
        try {
            i();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.a = AudioTrack.getMinBufferSize(this.m, 4, 2);
            AudioTrack audioTrack = this.b;
            if (audioTrack != null) {
                audioTrack.flush();
                this.b.release();
                this.b = null;
            }
            this.b = new AudioTrack(3, this.m, 4, 2, this.a, 1);
        }
    }
}
