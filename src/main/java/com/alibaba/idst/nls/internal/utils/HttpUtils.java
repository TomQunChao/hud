package com.alibaba.idst.nls.internal.utils;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;

public class HttpUtils {
    private static final int BUFFER_SIZE = 1024;
    private static final int CONNECTION_TIME_OUT = 15000;
    private static final int READ_TIME_OUT = 20000;

    public static String getStringFromUrl(String str) {
        Throwable th;
        Exception e;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            setCommonSettings(httpURLConnection);
            CharBuffer allocate = CharBuffer.allocate(1024);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode > 299) {
                closeFd(null);
                return null;
            }
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(httpURLConnection.getInputStream()));
            } catch (FileNotFoundException e2) {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(httpURLConnection.getErrorStream()));
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (inputStreamReader.read(allocate) > 0) {
                    allocate.flip();
                    sb.append(allocate.toString());
                    allocate.clear();
                }
                String sb2 = sb.toString();
                closeFd(inputStreamReader);
                return sb2;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    closeFd(inputStreamReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader2 = inputStreamReader;
                    closeFd(inputStreamReader2);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            inputStreamReader = null;
            e.printStackTrace();
            closeFd(inputStreamReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeFd(inputStreamReader2);
            throw th;
        }
    }

    private static void setCommonSettings(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("connection", "close");
        httpURLConnection.setConnectTimeout(CONNECTION_TIME_OUT);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setInstanceFollowRedirects(true);
    }

    public static void closeFd(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
