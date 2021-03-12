package com.amap.api.col.stln3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: SerializeConfig */
public final class bc {
    public static final bc a = new bc();
    protected String b = "@type";
    public g c;
    private final bi<ay> d = new bi<>();

    public bc() {
        this.d.a(Boolean.class, ak.a);
        this.d.a(Character.class, av.a);
        this.d.a(Byte.class, ap.a);
        this.d.a(Short.class, ap.a);
        this.d.a(Integer.class, ap.a);
        this.d.a(Long.class, ap.a);
        this.d.a(Float.class, ax.a);
        this.d.a(Double.class, ax.a);
        this.d.a(Number.class, ax.a);
        this.d.a(BigDecimal.class, aj.a);
        this.d.a(BigInteger.class, aj.a);
        this.d.a(String.class, bf.a);
        this.d.a(Object[].class, ag.a);
        this.d.a(Class.class, av.a);
        this.d.a(SimpleDateFormat.class, av.a);
        this.d.a(Locale.class, av.a);
        this.d.a(Currency.class, av.a);
        this.d.a(TimeZone.class, av.a);
        this.d.a(UUID.class, av.a);
        this.d.a(URI.class, av.a);
        this.d.a(URL.class, av.a);
        this.d.a(Pattern.class, av.a);
        this.d.a(Charset.class, av.a);
    }

    public final ay a(Class<?> cls) {
        au auVar;
        Class<? super Object> superclass;
        boolean z;
        av avVar;
        ay a2 = this.d.a(cls);
        if (a2 != null) {
            return a2;
        }
        if (Map.class.isAssignableFrom(cls)) {
            bi<ay> biVar = this.d;
            au auVar2 = new au();
            biVar.a(cls, auVar2);
            auVar = auVar2;
        } else if (AbstractSequentialList.class.isAssignableFrom(cls)) {
            bi<ay> biVar2 = this.d;
            al alVar = al.a;
            biVar2.a(cls, alVar);
            auVar = alVar;
        } else if (List.class.isAssignableFrom(cls)) {
            bi<ay> biVar3 = this.d;
            at atVar = new at();
            biVar3.a(cls, atVar);
            auVar = atVar;
        } else if (Collection.class.isAssignableFrom(cls)) {
            bi<ay> biVar4 = this.d;
            al alVar2 = al.a;
            biVar4.a(cls, alVar2);
            auVar = alVar2;
        } else if (Date.class.isAssignableFrom(cls)) {
            bi<ay> biVar5 = this.d;
            am amVar = am.a;
            biVar5.a(cls, amVar);
            auVar = amVar;
        } else if (c.class.isAssignableFrom(cls)) {
            bi<ay> biVar6 = this.d;
            av avVar2 = av.a;
            biVar6.a(cls, avVar2);
            auVar = avVar2;
        } else if (aq.class.isAssignableFrom(cls)) {
            bi<ay> biVar7 = this.d;
            av avVar3 = av.a;
            biVar7.a(cls, avVar3);
            auVar = avVar3;
        } else if (f.class.isAssignableFrom(cls)) {
            bi<ay> biVar8 = this.d;
            av avVar4 = av.a;
            biVar8.a(cls, avVar4);
            auVar = avVar4;
        } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
            bi<ay> biVar9 = this.d;
            an anVar = new an();
            biVar9.a(cls, anVar);
            auVar = anVar;
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            ay a3 = a(componentType);
            bi<ay> biVar10 = this.d;
            ah ahVar = new ah(componentType, a3);
            biVar10.a(cls, ahVar);
            auVar = ahVar;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            as asVar = new as(cls, this.c);
            asVar.a |= be.WriteClassName.w;
            this.d.a(cls, asVar);
            auVar = asVar;
        } else if (TimeZone.class.isAssignableFrom(cls)) {
            bi<ay> biVar11 = this.d;
            av avVar5 = av.a;
            biVar11.a(cls, avVar5);
            auVar = avVar5;
        } else if (Charset.class.isAssignableFrom(cls)) {
            bi<ay> biVar12 = this.d;
            av avVar6 = av.a;
            biVar12.a(cls, avVar6);
            auVar = avVar6;
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            bi<ay> biVar13 = this.d;
            av avVar7 = av.a;
            biVar13.a(cls, avVar7);
            auVar = avVar7;
        } else if (Calendar.class.isAssignableFrom(cls)) {
            bi<ay> biVar14 = this.d;
            am amVar2 = am.a;
            biVar14.a(cls, amVar2);
            auVar = amVar2;
        } else {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            boolean z2 = false;
            int i = 0;
            while (true) {
                z = true;
                if (i >= length) {
                    z = false;
                    break;
                }
                Class<?> cls2 = interfaces[i];
                if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                    z2 = true;
                    z = false;
                } else if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                    break;
                } else {
                    i++;
                }
            }
            z2 = true;
            z = false;
            if (z2 || z) {
                ay a4 = a(cls.getSuperclass());
                this.d.a(cls, a4);
                return a4;
            }
            if (cls.getName().startsWith("android.net.Uri$")) {
                avVar = av.a;
            } else {
                avVar = new as(cls, this.c);
            }
            this.d.a(cls, avVar);
            auVar = avVar;
        }
        if (auVar == null) {
            return this.d.a(cls);
        }
        return auVar;
    }
}
