package com.amap.api.col.stln3;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public final class sf extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c = false;
    private sb a;

    public sf(Context context, String str, int i, sb sbVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.a = sbVar;
    }

    /* compiled from: DB */
    public static class a extends ContextWrapper {
        private String a;
        private Context b;

        public a(Context context, String str) {
            super(context);
            this.a = str;
            this.b = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0084 A[SYNTHETIC, Splitter:B:20:0x0084] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.File getDatabasePath(java.lang.String r5) {
            /*
            // Method dump skipped, instructions count: 174
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.stln3.sf.a.getDatabasePath(java.lang.String):java.io.File");
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable th) {
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.b.getApplicationContext().getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable th) {
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.b.getApplicationContext().getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i);
    }
}
