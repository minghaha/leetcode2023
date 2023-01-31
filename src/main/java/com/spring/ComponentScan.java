package com.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2023/1/31.
 *
 * @author lichuanming
 */


//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {
    String value() default "";
}
