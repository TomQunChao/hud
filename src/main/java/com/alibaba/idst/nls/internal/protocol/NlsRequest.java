package com.alibaba.idst.nls.internal.protocol;

import android.content.Context;
import com.alibaba.idst.nls.internal.protocol.NlsRequestASR;
import com.alibaba.idst.nls.internal.protocol.NlsRequestContext;
import com.amap.api.col.stln3.a;
import com.amap.api.col.stln3.e;
import com.amap.api.col.stln3.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.UUID;

public class NlsRequest {
    private String app_key;
    private Boolean bstream_attached = false;
    public NlsRequestContext context = new NlsRequestContext();
    private String id = UUID.randomUUID().toString().replaceAll("-", "");
    private long requestTime = System.currentTimeMillis();
    public RequestSet requests = new RequestSet();
    private String session_id;
    private String version = NlsRequestProto.VERSION40;

    public static class RequestSet {
        public NlsRequestASR asr_in = null;
        public NlsRequestASR.out asr_out = null;
        public NlsRequestDs ds_in = null;
        @i(d = false)
        public RawJsonText ext_userIn = null;
        @i(d = false)
        public String ext_userInName = null;
        public NlsRequestGds gds_in = null;
        public NlsRequestTTS tts_in = null;
    }

    public Boolean getBstream_attached() {
        return this.bstream_attached;
    }

    public void initId() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.requestTime = System.currentTimeMillis();
    }

    public void setBstream_attached(Boolean bool) {
        this.bstream_attached = bool;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getSession_id() {
        return this.session_id;
    }

    public void setSession_id(String str) {
        this.session_id = str;
    }

    public void authorize(String str, String str2, String str3) {
        this.context.auth = new NlsRequestAuth();
        if (this.requests.asr_in != null) {
            this.context.auth.add_Request("asr");
        }
        if (this.requests.ds_in != null) {
            this.context.auth.add_Request("ds");
        }
        if (this.requests.gds_in != null) {
            this.context.auth.add_Request("gds");
        }
        if (this.requests.tts_in != null) {
            this.context.auth.add_Request("tts");
        }
        this.context.auth.Authorize(str, str2, str3);
    }

    public void authorize(String str, String str2) {
        authorize(str, str2, toGMTString(new Date()));
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getApp_key() {
        return this.app_key;
    }

    public void setApp_key(String str) {
        this.app_key = str;
    }

    public void setAsr_req(NlsRequestASR nlsRequestASR) {
        this.requests.asr_in = nlsRequestASR;
        setBstream_attached(Boolean.valueOf(nlsRequestASR != null));
    }

    public void setAsr_out(NlsRequestASR.out out) {
        this.requests.asr_out = out;
    }

    public void setAsr_sc(String str) {
        NlsRequestASR nlsRequestASR = new NlsRequestASR();
        nlsRequestASR.asrSC = str;
        setAsr_req(nlsRequestASR);
    }

    public void setAsrResposeMode(NlsRequestASR.mode mode) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        if (mode.equals(NlsRequestASR.mode.STREAMING)) {
            this.requests.asr_in.response_mode = "0";
        } else if (mode.equals(NlsRequestASR.mode.NORMAL)) {
            this.requests.asr_in.response_mode = "1";
        }
    }

    public void setAsrModel(String str) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.model = str;
    }

    public void setAsrMaxEndSilence(int i) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.max_end_silence = i;
    }

    public void setAsr_fake(String str) {
        if (this.requests.asr_out == null) {
            this.requests.asr_out = new NlsRequestASR.out();
        }
        this.requests.asr_out.fake = true;
        this.requests.asr_out.result = str;
        setBstream_attached(false);
    }

    public void setAsrUserId(String str) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.user_id = str;
    }

    public void setAsrVocabularyId(String str) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.vocabulary_id = str;
    }

    public void setAsrOrganizationId(String str) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.organization_id = str;
    }

    public void setAsrCustomizationId(String str) {
        if (this.requests.asr_in == null) {
            this.requests.asr_in = new NlsRequestASR();
        }
        this.requests.asr_in.customization_id = str;
    }

    public void setGds_content(Content content) {
        setGdsContent(content);
    }

    public void setGdsContent(Content content) {
        if (this.requests.gds_in == null) {
            this.requests.gds_in = new NlsRequestGds();
        }
        this.requests.gds_in.setContent(content);
    }

    public void setGds_content(String str) {
        setGdsContent(str);
    }

    public void setGdsContent(String str) {
        if (this.requests.gds_in == null) {
            this.requests.gds_in = new NlsRequestGds();
        }
        this.requests.gds_in.setContent(str);
    }

    public void enableGdsDebug(boolean z) {
        this.context.debug.GDS_AllResultCode = z;
    }

    public void enableCloudNLUResult() {
        this.context.application.application_id = "com.aliyun.dataapi.nls.api.nlu";
        this.context.device.device_type = "aliyun.dataapi.nls";
        this.context.application.setUser_id("com.aliyun.dataapi.nls.api.nlu");
        this.context.device.setDevice_id("com.aliyun.dataapi.nls.api.nlu");
        setDs_req("{}");
    }

    public void setDs_type(String str) {
        if (this.requests.ds_in == null) {
            this.requests.ds_in = new NlsRequestDs();
        }
        this.requests.ds_in.setType(str);
    }

    public void setDs_req(String str) {
        if (this.requests.ds_in == null) {
            this.requests.ds_in = new NlsRequestDs();
        }
        this.requests.ds_in.setContent(str);
    }

    public void initTts() {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
    }

    public void setTts_req(String str) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setText(str);
    }

    public void setTts_req(String str, String str2) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        setTts_req(str);
        this.requests.tts_in.setSample_rate(str2);
    }

    public void setTtsEncodeType(String str) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setEncode_type(str);
    }

    public void setTtsSpeechRate(int i) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        if (i > 500) {
            i = 500;
        } else if (i < -500) {
            i = -500;
        }
        this.requests.tts_in.setSpeech_rate(i);
    }

    public void setTtsVolume(int i) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.requests.tts_in.setVolume(i);
    }

    public void setTtsNus(int i) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setNus(i);
    }

    public void setTtsPitchRate(int i) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setPitch_rate(i);
    }

    public void setTtsBackgroundMusic(int i) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setBackground_music_id(i);
    }

    public void setTtsBackgroundMusic(int i, int i2) {
        setTtsBackgroundMusic(i);
        this.requests.tts_in.setBackground_music_offset(i2);
    }

    public void setTtsBackgroundMusic(int i, int i2, int i3) {
        setTtsBackgroundMusic(i, i2);
        this.requests.tts_in.setBackground_music_volume(i3);
    }

    public void setTtsVoice(String str) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setVoice(str);
    }

    public void setTtsReference(String str) {
        if (this.requests.tts_in == null) {
            this.requests.tts_in = new NlsRequestTTS();
        }
        this.requests.tts_in.setRefer(str);
    }

    @i(d = false)
    public String getTts_req() {
        if (this.requests.tts_in == null) {
            return null;
        }
        return this.requests.tts_in.getText();
    }

    public void setDeviceInfo(NlsRequestContext.DeviceInfo deviceInfo) {
        this.context.device = deviceInfo;
    }

    @i(d = false)
    public void setLocationInfo(NlsRequestContext.LocationInfo locationInfo) {
        this.context.location = locationInfo;
    }

    @i(d = false)
    public NlsRequestContext.LocationInfo getLocationInfo() {
        return this.context.location;
    }

    public void setExt_userData(String str, String str2) {
        RequestSet requestSet = this.requests;
        requestSet.ext_userInName = str;
        requestSet.ext_userIn = new RawJsonText(str2);
    }

    public String getExt_userData(String str) {
        if (this.requests.ext_userInName.equals(str)) {
            return this.requests.ext_userIn.text;
        }
        return null;
    }

    public NlsRequest() {
    }

    public NlsRequest(NlsRequestProto nlsRequestProto) {
        InitRequest(nlsRequestProto);
    }

    public NlsRequest(Context context2) {
        InitRequest(new NlsRequestProto(context2));
    }

    public void InitRequest(NlsRequestProto nlsRequestProto) {
        this.context.application.application_id = nlsRequestProto.getApp_id();
        this.context.application.user_id = nlsRequestProto.getApp_user_id();
        this.context.application.version = nlsRequestProto.getApp_version();
        this.context.application.service_id = nlsRequestProto.getService_id();
        this.context.application.service_version = nlsRequestProto.getService_version();
        this.context.device.device_type = nlsRequestProto.getDevice_type();
        this.context.device.device_id = nlsRequestProto.getDevice_id();
        this.context.device.device_brand = nlsRequestProto.getDevice_brand();
        this.context.device.device_uuid = nlsRequestProto.getDevice_uuid();
        this.context.device.device_model = nlsRequestProto.getDevice_model();
        this.context.device.device_imei = nlsRequestProto.getDevice_imei();
        this.context.device.device_mac = nlsRequestProto.getDevice_mac();
        this.context.device.system_locale = nlsRequestProto.getDevice_system_locale();
        this.context.device.timezone = nlsRequestProto.getDevice_timezone();
        this.context.device.os_type = nlsRequestProto.getOs_type();
        this.context.device.os_version = nlsRequestProto.getOs_version();
        this.context.device.network_type = nlsRequestProto.getNetwork_type();
    }

    public e ParseExtUserIn(NlsRequest nlsRequest) {
        e eVar = (e) a.b(nlsRequest);
        if (nlsRequest.requests.ext_userInName != null && !nlsRequest.requests.ext_userInName.equals("")) {
            e c = eVar.c("requests");
            c.put(nlsRequest.requests.ext_userInName, e.a(nlsRequest.requests.ext_userIn.text));
            eVar.put("requests", c);
        }
        return eVar;
    }

    public static String toGMTString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }
}
