package com.amap.api.col.stln3;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public final class sp implements sb {
    private static sp a;

    public static synchronized sp a() {
        sp spVar;
        synchronized (sp.class) {
            if (a == null) {
                a = new sp();
            }
            spVar = a;
        }
        return spVar;
    }

    private sp() {
    }

    @Override // com.amap.api.col.stln3.sb
    public final String b() {
        return "dafile.db";
    }

    @Override // com.amap.api.col.stln3.sb
    public final int c() {
        return 1;
    }

    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            ru.a(th, "DynamicFileDBCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }
}
