package com.amap.api.col.stln3;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: MiscCodec */
public final class av implements ae, ay {
    public static final av a = new av();

    private av() {
    }

    @Override // com.amap.api.col.stln3.ay
    public final void a(ar arVar, Object obj, Object obj2, Type type) throws IOException {
        bd bdVar = arVar.b;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                arVar.a("");
            } else if ((bdVar.c & be.WriteNullListAsEmpty.w) == 0 || !Enumeration.class.isAssignableFrom(bk.c(type))) {
                bdVar.a();
            } else {
                bdVar.write("[]");
            }
        } else if (obj instanceof Pattern) {
            arVar.a(((Pattern) obj).pattern());
        } else if (obj instanceof TimeZone) {
            arVar.a(((TimeZone) obj).getID());
        } else if (obj instanceof Currency) {
            arVar.a(((Currency) obj).getCurrencyCode());
        } else if (obj instanceof Class) {
            arVar.a(((Class) obj).getName());
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == 0) {
                arVar.a("\u0000");
            } else {
                arVar.a(ch.toString());
            }
        } else {
            int i = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((bdVar.c & be.WriteClassName.w) == 0 || obj.getClass() == type) {
                    bdVar.a(pattern);
                    return;
                }
                bdVar.write(123);
                bdVar.a("@type", false);
                arVar.a(obj.getClass().getName());
                bdVar.write(44);
                bdVar.a("val", false);
                bdVar.a(pattern);
                bdVar.write(125);
            } else if (obj instanceof f) {
                ((f) obj).a(arVar.b);
            } else if (obj instanceof c) {
                bdVar.write(((c) obj).a());
            } else if (obj instanceof aq) {
                ((aq) obj).a();
            } else if (obj instanceof Enumeration) {
                Type type2 = null;
                if ((bdVar.c & be.WriteClassName.w) != 0 && (type instanceof ParameterizedType)) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                }
                Enumeration enumeration = (Enumeration) obj;
                bb bbVar = arVar.j;
                arVar.a(bbVar, obj, obj2);
                try {
                    bdVar.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object nextElement = enumeration.nextElement();
                        int i2 = i + 1;
                        if (i != 0) {
                            bdVar.write(44);
                        }
                        if (nextElement == null) {
                            bdVar.a();
                        } else {
                            arVar.a.a(nextElement.getClass()).a(arVar, nextElement, Integer.valueOf(i2 - 1), type2);
                        }
                        i = i2;
                    }
                    bdVar.write(93);
                } finally {
                    arVar.j = bbVar;
                }
            } else {
                arVar.a(obj.toString());
            }
        }
    }

    @Override // com.amap.api.col.stln3.ae
    public final <T> T a(l lVar, Type type, Object obj) {
        Object obj2;
        if (type == StackTraceElement.class) {
            o oVar = lVar.c;
            if (oVar.a() == 8) {
                oVar.f();
                return null;
            } else if (oVar.a() == 12 || oVar.a() == 16) {
                String str = null;
                String str2 = null;
                String str3 = null;
                int i = 0;
                while (true) {
                    String a2 = oVar.a(lVar.a);
                    if (a2 == null) {
                        if (oVar.a() == 13) {
                            break;
                        } else if (oVar.a() == 16) {
                            continue;
                        }
                    }
                    oVar.d();
                    if ("className".equals(a2)) {
                        if (oVar.a() == 8) {
                            str = null;
                        } else if (oVar.a() == 4) {
                            str = oVar.m();
                        } else {
                            throw new d("syntax error");
                        }
                    } else if ("methodName".equals(a2)) {
                        if (oVar.a() == 8) {
                            str2 = null;
                        } else if (oVar.a() == 4) {
                            str2 = oVar.m();
                        } else {
                            throw new d("syntax error");
                        }
                    } else if ("fileName".equals(a2)) {
                        if (oVar.a() == 8) {
                            str3 = null;
                        } else if (oVar.a() == 4) {
                            str3 = oVar.m();
                        } else {
                            throw new d("syntax error");
                        }
                    } else if ("lineNumber".equals(a2)) {
                        if (oVar.a() == 8) {
                            i = 0;
                        } else if (oVar.a() == 2) {
                            i = oVar.k();
                        } else {
                            throw new d("syntax error");
                        }
                    } else if ("nativeMethod".equals(a2)) {
                        if (oVar.a() == 8 || oVar.a() == 6 || oVar.a() == 7) {
                            oVar.a(16);
                        } else {
                            throw new d("syntax error");
                        }
                    } else if (a2 != "@type") {
                        throw new d("syntax error : " + a2);
                    } else if (oVar.a() == 4) {
                        String m = oVar.m();
                        if (!m.equals("java.lang.StackTraceElement")) {
                            throw new d("syntax error : " + m);
                        }
                    } else if (oVar.a() != 8) {
                        throw new d("syntax error");
                    }
                    if (oVar.a() == 13) {
                        break;
                    }
                }
                oVar.a(16);
                return (T) new StackTraceElement(str, str2, str3, i);
            } else {
                throw new d("syntax error: " + p.a(oVar.a()));
            }
        } else {
            o oVar2 = lVar.c;
            if (lVar.e == 2) {
                lVar.e = 0;
                lVar.a(16);
                if (oVar2.a() != 4) {
                    throw new d("syntax error");
                } else if ("val".equals(oVar2.m())) {
                    oVar2.f();
                    lVar.a(17);
                    obj2 = lVar.e();
                    lVar.a(13);
                } else {
                    throw new d("syntax error");
                }
            } else {
                obj2 = lVar.e();
            }
            if (obj2 == null) {
                return null;
            }
            if (obj2 instanceof String) {
                String str4 = (String) obj2;
                if (str4.length() == 0) {
                    return null;
                }
                if (type == UUID.class) {
                    return (T) UUID.fromString(str4);
                }
                if (type == Class.class) {
                    return (T) bk.a(str4, lVar.b.c);
                }
                if (type == Locale.class) {
                    String[] split = str4.split("_");
                    return split.length == 1 ? (T) new Locale(split[0]) : split.length == 2 ? (T) new Locale(split[0], split[1]) : (T) new Locale(split[0], split[1], split[2]);
                } else if (type == URI.class) {
                    return (T) URI.create(str4);
                } else {
                    if (type == URL.class) {
                        try {
                            return (T) new URL(str4);
                        } catch (MalformedURLException e) {
                            throw new d("create url error", e);
                        }
                    } else if (type == Pattern.class) {
                        return (T) Pattern.compile(str4);
                    } else {
                        if (type == Charset.class) {
                            return (T) Charset.forName(str4);
                        }
                        if (type == Currency.class) {
                            return (T) Currency.getInstance(str4);
                        }
                        if (type == SimpleDateFormat.class) {
                            T t = (T) new SimpleDateFormat(str4, lVar.c.n);
                            t.setTimeZone(lVar.c.m);
                            return t;
                        } else if (type == Character.TYPE || type == Character.class) {
                            return (T) bk.c((Object) str4);
                        } else {
                            if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
                                return (T) TimeZone.getTimeZone(str4);
                            }
                            try {
                                return (T) Class.forName("android.net.Uri").getMethod("parse", String.class).invoke(null, str4);
                            } catch (Exception e2) {
                                throw new d("parse android.net.Uri error.", e2);
                            }
                        }
                    }
                }
            } else {
                if (obj2 instanceof e) {
                    e eVar = (e) obj2;
                    if (type == Currency.class) {
                        String d = eVar.d("currency");
                        if (d != null) {
                            return (T) Currency.getInstance(d);
                        }
                        String d2 = eVar.d("currencyCode");
                        if (d2 != null) {
                            return (T) Currency.getInstance(d2);
                        }
                    }
                    if (type == Map.Entry.class) {
                        return (T) eVar.entrySet().iterator().next();
                    }
                }
                throw new d("except string value");
            }
        }
    }
}
