package com.amap.api.col.stln3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: JSONType */
public @interface j {
    String[] a() default {};

    String[] b() default {};

    be[] c() default {};

    n[] d() default {};

    Class<?> e() default Void.class;

    String f() default "";

    String g() default "";

    Class<?>[] h() default {};

    g i() default g.CamelCase;
}
