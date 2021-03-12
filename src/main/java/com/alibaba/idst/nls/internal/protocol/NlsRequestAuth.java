package com.alibaba.idst.nls.internal.protocol;

import com.alibaba.idst.nls.internal.utils.Base64Encoder;
import com.amap.api.col.stln3.a;
import com.amap.api.col.stln3.i;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class NlsRequestAuth {
    public AuthBody body = null;
    public Headers headers = new Headers();
    public String method = "POST";

    public static class Headers {
        public String Authorization;
        public String accept = "json";
        @i(d = false)
        private String ak_id = "";
        @i(d = false)
        private String ak_secret = "";
        @i(b = "content-type")
        public String content_type = "application/json";
        public String date;
    }

    /* access modifiers changed from: private */
    public static class AuthBody {
        public ArrayList<String> requests;

        private AuthBody() {
            this.requests = new ArrayList<>();
        }
    }

    public void add_Request(String str) {
        if (this.body == null) {
            this.body = new AuthBody();
        }
        this.body.requests.add(str);
    }

    public static String toGMTString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    private String digestMsg() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.headers.ak_secret.getBytes(), "HmacSHA1");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
        }
        byte[] doFinal = mac.doFinal(getDigestString().getBytes());
        return "Dataplus " + this.headers.ak_id + ":" + Base64Encoder.encode(doFinal);
    }

    private String getDigestString() {
        String str = (this.method + "\n") + this.headers.accept + "\n";
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(a.a(this.body).getBytes());
            str = str + Base64Encoder.encode(digest) + "\n";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (str + this.headers.content_type + "\n") + this.headers.date;
    }

    public void Authorize(String str, String str2, String str3) {
        this.headers.ak_id = str;
        this.headers.ak_secret = str2;
        Headers headers2 = this.headers;
        headers2.date = str3;
        headers2.Authorization = digestMsg();
    }
}
