package com.amap.api.col.stln3;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: LogDBCreator */
public class sg implements sb {
    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "b"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "c"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "d"));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
        } catch (Throwable th) {
            ru.a(th, "DB", "onCreate");
        }
    }

    @Override // com.amap.api.col.stln3.sb
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }

    @Override // com.amap.api.col.stln3.sb
    public final String b() {
        return "logdb.db";
    }

    @Override // com.amap.api.col.stln3.sb
    public final int c() {
        return 1;
    }
}
