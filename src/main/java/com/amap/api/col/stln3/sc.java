package com.amap.api.col.stln3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.amap.api.col.stln3.sf;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public final class sc {
    private static Map<Class<? extends sb>, sb> d = new HashMap();
    private sf a;
    private SQLiteDatabase b;
    private sb c;

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends com.amap.api.col.stln3.sb>, com.amap.api.col.stln3.sb> */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized sb a(Class<? extends sb> cls) throws IllegalAccessException, InstantiationException {
        sb sbVar;
        synchronized (sc.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            sbVar = d.get(cls);
        }
        return sbVar;
    }

    public sc(Context context, sb sbVar) {
        try {
            this.a = new sf(context.getApplicationContext(), sbVar.b(), sbVar.c(), sbVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = sbVar;
    }

    public sc(Context context, sb sbVar, String str) {
        try {
            boolean equals = "mounted".equals(Environment.getExternalStorageState());
            if (!TextUtils.isEmpty(str) && equals) {
                context = new sf.a(context.getApplicationContext(), str);
            }
            this.a = new sf(context, sbVar.b(), sbVar.c(), sbVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = sbVar;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    public final <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            String a2 = a(b(cls));
            if (!TextUtils.isEmpty(a2)) {
                this.b = a();
                if (this.b != null) {
                    try {
                        this.b.delete(a2, str, null);
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th) {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public final <T> void a(String str, Object obj) {
        synchronized (this.c) {
            if (obj != null) {
                sd b2 = b(obj.getClass());
                String a2 = a(b2);
                if (!TextUtils.isEmpty(a2)) {
                    ContentValues a3 = a(obj, b2);
                    if (a3 != null) {
                        this.b = a();
                        if (this.b != null) {
                            try {
                                this.b.update(a2, a3, str, null);
                                if (this.b != null) {
                                    this.b.close();
                                    this.b = null;
                                }
                            } catch (Throwable th) {
                                if (this.b != null) {
                                    this.b.close();
                                    this.b = null;
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            List a2 = a(str, (Class) obj.getClass(), false);
            if (a2 != null) {
                if (a2.size() != 0) {
                    a(str, obj);
                }
            }
            a(obj);
        }
    }

    public final <T> void a(T t) {
        synchronized (this.c) {
            this.b = a();
            if (this.b != null) {
                try {
                    a(this.b, (Object) t);
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                    throw th;
                }
            }
        }
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues a2;
        sd b2 = b(t.getClass());
        String a3 = a(b2);
        if (!TextUtils.isEmpty(a3) && t != null && sQLiteDatabase != null && (a2 = a((Object) t, b2)) != null) {
            sQLiteDatabase.insert(a3, null, a2);
        }
    }

    public final <T> void a(List<T> list) {
        synchronized (this.c) {
            if (list != null) {
                if (list.size() != 0) {
                    this.b = a();
                    if (this.b != null) {
                        try {
                            this.b.beginTransaction();
                            for (T t : list) {
                                a(this.b, (Object) t);
                            }
                            this.b.setTransactionSuccessful();
                            try {
                                if (this.b.inTransaction()) {
                                    this.b.endTransaction();
                                }
                            } catch (Throwable th) {
                                ru.a(th, "dbs", "ild");
                            }
                            try {
                                this.b.close();
                                this.b = null;
                            } catch (Throwable th2) {
                                ru.a(th2, "dbs", "ild");
                            }
                        } catch (Throwable th3) {
                            ru.a(th3, "dbs", "ild");
                        }
                    }
                    return;
                }
            }
            return;
        }
        this.b.close();
        this.b = null;
        throw th;
        throw th;
        this.b.close();
        this.b = null;
    }

    public final <T> List<T> a(String str, Class<T> cls, boolean z) {
        Throwable th;
        Cursor cursor;
        Throwable th2;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            sd b2 = b(cls);
            String a2 = a(b2);
            if (this.b == null) {
                this.b = a(z);
            }
            if (this.b == null || TextUtils.isEmpty(a2) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a2, null, str, null, null, null, null);
                if (cursor == null) {
                    try {
                        this.b.close();
                        this.b = null;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th3) {
                                if (!z) {
                                    ru.a(th3, "dbs", "sld");
                                }
                            }
                        }
                        try {
                            if (this.b != null) {
                                this.b.close();
                                this.b = null;
                            }
                        } catch (Throwable th4) {
                            if (!z) {
                                ru.a(th4, "dbs", "sld");
                            }
                        }
                        return arrayList;
                    } catch (Throwable th5) {
                        th2 = th5;
                    }
                } else {
                    while (cursor.moveToNext()) {
                        arrayList.add(a(cursor, cls, b2));
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th6) {
                            if (!z) {
                                ru.a(th6, "dbs", "sld");
                            }
                        }
                    }
                    try {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th7) {
                        if (!z) {
                            ru.a(th7, "dbs", "sld");
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th8) {
                th = th8;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th9) {
                        if (!z) {
                            ru.a(th9, "dbs", "sld");
                        }
                    }
                }
                try {
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th10) {
                    if (!z) {
                        ru.a(th10, "dbs", "sld");
                    }
                }
                throw th;
            }
        }
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return a(str, (Class) cls, false);
    }

    private static <T> T a(Cursor cursor, Class<T> cls, sd sdVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, sdVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(se.class);
            if (annotation != null) {
                se seVar = (se) annotation;
                int b2 = seVar.b();
                int columnIndex = cursor.getColumnIndex(seVar.a());
                switch (b2) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private static ContentValues a(Object obj, sd sdVar) {
        ContentValues contentValues = new ContentValues();
        Field[] a2 = a(obj.getClass(), sdVar.b());
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(se.class);
            if (annotation != null) {
                se seVar = (se) annotation;
                switch (seVar.b()) {
                    case 1:
                        contentValues.put(seVar.a(), Short.valueOf(field.getShort(obj)));
                        continue;
                    case 2:
                        contentValues.put(seVar.a(), Integer.valueOf(field.getInt(obj)));
                        continue;
                    case 3:
                        contentValues.put(seVar.a(), Float.valueOf(field.getFloat(obj)));
                        continue;
                    case 4:
                        contentValues.put(seVar.a(), Double.valueOf(field.getDouble(obj)));
                        continue;
                    case 5:
                        contentValues.put(seVar.a(), Long.valueOf(field.getLong(obj)));
                        continue;
                    case 6:
                        contentValues.put(seVar.a(), (String) field.get(obj));
                        continue;
                    case 7:
                        try {
                            contentValues.put(seVar.a(), (byte[]) field.get(obj));
                            continue;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                ru.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private SQLiteDatabase a() {
        try {
            if (this.b != null) {
                if (!this.b.isReadOnly()) {
                    return this.b;
                }
            }
            if (this.b != null) {
                this.b.close();
            }
            this.b = this.a.getWritableDatabase();
        } catch (Throwable th) {
            ru.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> String a(sd sdVar) {
        if (sdVar == null) {
            return null;
        }
        return sdVar.a();
    }

    private static <T> sd b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(sd.class);
        if (!(annotation != null)) {
            return null;
        }
        return (sd) annotation;
    }
}
