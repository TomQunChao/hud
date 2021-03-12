package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GLFileUtil {
    /* JADX INFO: finally extract failed */
    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        try {
            open.read(bArr);
            closeQuietly(open);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } catch (Throwable th) {
            closeQuietly(open);
            throw th;
        }
    }

    public static void deleteFile(File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (file.isDirectory() && listFiles != null) {
                for (File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream2 = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (Exception e) {
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (Throwable th2) {
                        fileOutputStream2 = fileOutputStream;
                        th = th2;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream2);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                fileOutputStream = null;
                writeLock.unlock();
                closeQuietly(fileOutputStream);
                return;
            } catch (Throwable th3) {
                th = th3;
                writeLock.unlock();
                closeQuietly(fileOutputStream2);
                throw th;
            }
        }
        writeLock.unlock();
        closeQuietly(null);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            File file = new File(str);
            if (!file.exists()) {
                closeQuietly(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(fileInputStream);
                        return byteArray;
                    }
                }
            } catch (Exception e) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
            closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            cacheDir = new File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = context.getDir("files", 0);
        }
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/app_files");
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }
}
