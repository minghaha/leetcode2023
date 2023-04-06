package com;

import com.mybatis.spring.ZhouyuFactoryBean;
import com.mybatis.spring.mapper.OrderMapper;
import com.mybatis.spring.mapper.UserMapper;
import com.mybatis.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 2023/4/6.
 *
 * @author lichuanming
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);




        context.refresh();
        UserServiceImpl userServiceImpl = (UserServiceImpl)context.getBean("userServiceImpl");
        userServiceImpl.test();
    }
}
