package com.amap.api.col.stln3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: DBHelper */
public final class qh extends SQLiteOpenHelper {
    Context a = null;

    public qh(Context context) {
        super(context, "LOC_MONITOR_DB", (SQLiteDatabase.CursorFactory) null, 1);
        this.a = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ti_locdata (locdata VARCHAR(5000) NULL , ctime BIGINT(16) NULL, terminalid VARCHAR(5000) NULL );");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final long a(pt ptVar) {
        if (ptVar == null) {
            return -1;
        }
        return a(ptVar.a(this.a), ptVar.b(), ptVar.a());
    }

    private long a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || j2 <= 0) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("locdata", str);
        contentValues.put("ctime", Long.valueOf(j2));
        contentValues.put("terminalid", Long.valueOf(j));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            qr.a("DB LOC_MONITOR_DB is null");
            return -1;
        }
        long insert = writableDatabase.insert("ti_locdata", null, contentValues);
        if (insert < 0) {
            try {
                writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS ti_locdata (locdata VARCHAR(5000) NULL , ctime BIGINT(16) NULL, terminalid VARCHAR(5000) NULL );");
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
            writableDatabase.close();
        }
        return insert;
    }

    public final void a(Set<Long> set) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            qr.a("DB LOC_MONITOR_DB is null");
        } else if (set == null || set.size() <= 0) {
            qr.a("changeStatus dataIds is null or size is 0");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("   ( ");
            int i = 0;
            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                stringBuffer.append("ctime=" + it.next());
                int i2 = i + 1;
                if (i < set.size() - 1) {
                    stringBuffer.append(" OR ");
                }
                i = i2;
            }
            stringBuffer.append("  ) ");
            writableDatabase.delete("ti_locdata", stringBuffer.toString(), null);
            writableDatabase.close();
        }
    }

    public final ArrayList<pt> a(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            qr.a("DB LOC_MONITOR_DB is null");
            return new ArrayList<>();
        }
        Cursor query = writableDatabase.query(true, "ti_locdata", new String[]{"rowid", "locdata", "ctime"}, null, null, null, null, "ctime desc", String.valueOf(i));
        if (query == null) {
            qr.a("cursor is null , when cursor is " + query.toString());
        }
        ArrayList<pt> arrayList = new ArrayList<>();
        while (query.moveToNext()) {
            pt a2 = pt.a(this.a, query.getString(1), query.getLong(2));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        query.close();
        writableDatabase.close();
        return arrayList;
    }

    public final void b(int i) {
        HashSet hashSet;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            qr.a("DB LOC_MONITOR_DB is null");
            hashSet = new HashSet();
        } else {
            Cursor query = writableDatabase.query(true, "ti_locdata", new String[]{"rowid", "locdata", "ctime"}, null, null, null, null, "ctime asc", String.valueOf(i));
            if (query == null) {
                qr.a("cursor is null , when cursor is " + query.toString());
            }
            HashSet hashSet2 = new HashSet();
            while (query.moveToNext()) {
                hashSet2.add(Long.valueOf(query.getLong(2)));
            }
            query.close();
            writableDatabase.close();
            hashSet = hashSet2;
        }
        a(hashSet);
    }

    public final long a() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long queryNumEntries = DatabaseUtils.queryNumEntries(writableDatabase, "ti_locdata");
        writableDatabase.close();
        return queryNumEntries;
    }

    public static void b() {
    }
}
