package com.tuling.bussiness;

import com.tuling.spring.BeanPostProcessor;
import com.tuling.spring.Component;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created on 2023/4/11.
 *
 * @author lichuanming
 */

@Component("ZhouyuBeanPostProcessor")
public class ZhouyuBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("userService")) {
            System.out.println("jjjjjjj");
        }

        // bean
        return bean;
    }
}
