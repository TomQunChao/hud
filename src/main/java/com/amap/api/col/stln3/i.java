package com.amap.api.col.stln3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JSONField */
public @interface i {
    int a() default 0;

    String b() default "";

    String c() default "";

    boolean d() default true;

    boolean e() default true;

    be[] f() default {};

    String[] g() default {};
}
