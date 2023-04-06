package com.mybatis.spring.aop;

import com.mybatis.spring.ZhouyuImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(ZhouyuImportBeanDefinitionRegistrar.class)
public @interface ZhouyuMapperScan {
    String value();
}
