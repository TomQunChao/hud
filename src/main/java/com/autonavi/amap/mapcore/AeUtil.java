package com.autonavi.amap.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.col.stln3.hh;
import com.amap.api.col.stln3.qx;
import com.amap.api.col.stln3.rx;
import com.amap.api.col.stln3.su;
import com.amap.api.col.stln3.ux;
import com.amap.api.col.stln3.uy;
import com.autonavi.ae.gmap.GLMapEngine;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressLint({"NewApi"})
public class AeUtil {
    private static final int BUFFER = 1024;
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    public static final String SO_FILENAME = "AMapSDK_MAP_v6_6_0";
    public static final String SO_FILENAME_NAVI = "AMapSDK_NAVI_v6_5_0";

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    public static void loadLib(Context context) {
        try {
            su.a().a(context, hh.a(), SO_FILENAME);
        } catch (Throwable th) {
            rx.c(th, "AeUtil", "loadLib");
        }
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                ux.a().a(new uy() {
                    /* class com.autonavi.amap.mapcore.AeUtil.AnonymousClass1 */

                    @Override // com.amap.api.col.stln3.uy
                    public final void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (qx e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        File file2 = new File(mapBaseStorage, CONFIGNAME);
        if (!file2.exists() || !file2.isFile() || file2.length() <= 0) {
            readAssetsFileAndSave("ae/GNaviConfig.xml", mapBaseStorage + CONFIGNAME, context);
        }
        initParam.mRootPath = mapBaseStorage;
        initParam.mConfigPath = mapBaseStorage + CONFIGNAME;
        initParam.mOfflineDataPath = str + "/map/";
        initParam.mP3dCrossPath = str;
        return initParam;
    }

    /* access modifiers changed from: private */
    public static void loadEngineRes(String str, Context context) {
        File file = new File(str, "res");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        if (!checkEngineRes(file)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open("ae/res.zip");
                decompress(inputStream, file.getAbsolutePath());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length < 2) {
            return false;
        }
        return true;
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0, null);
    }

    private static void decompress(InputStream inputStream, String str, long j, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        boolean z = false;
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                String name = nextEntry.getName();
                if (TextUtils.isEmpty(name) || name.contains("../")) {
                    z = true;
                } else {
                    File file3 = new File(file2.getPath() + File.separator + name);
                    fileProber(file3);
                    if (nextEntry.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        i += decompressFile(file3, zipInputStream, (long) i, j, zipCompressProgressListener, unZipFileBrake);
                    }
                    zipInputStream.closeEntry();
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
        z = true;
        if (z && file != null) {
            try {
                file.delete();
            } catch (Exception e) {
            }
        }
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && zipCompressProgressListener != null) {
                    long j3 = ((((long) i) + j) * 100) / j2;
                    if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                        zipCompressProgressListener.onFinishProgress(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x006c A[SYNTHETIC, Splitter:B:40:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0078 A[SYNTHETIC, Splitter:B:45:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008a A[SYNTHETIC, Splitter:B:52:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0096 A[SYNTHETIC, Splitter:B:57:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void readAssetsFileAndSave(java.lang.String r4, java.lang.String r5, android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.AeUtil.readAssetsFileAndSave(java.lang.String, java.lang.String, android.content.Context):void");
    }
}
