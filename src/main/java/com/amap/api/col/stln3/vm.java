package com.amap.api.col.stln3;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: SdCardDbCreator */
public class vm implements sb {
    @Override // com.amap.api.col.stln3.sb
    public final String b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.stln3.sb
    public final int c() {
        return 1;
    }

    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            vu.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }
}
