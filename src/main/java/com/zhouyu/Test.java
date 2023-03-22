package com.zhouyu;

import com.spring.ZhouyuApplicationContext;
import com.zhouyu.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created on 2023/1/31.
 *
 * @author lichuanming
 */
public class Test {
    public static void main(String[] args) {
        //ZhouyuApplicationContext applicationContext = new ZhouyuApplicationContext(AppConfig.class);
        //UserService userService = (UserService)applicationContext.getBean("userService");
        //userService.test();
        //System.out.println(userService);
        //
        //UserService userService1 = (UserService)applicationContext.getBean("userService");
        //System.out.println(userService1);
        //PriorityQueue
        //
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        ////String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        ////System.out.println(beanDefinitionNames);
        //
        ////UserService userService = (UserService)applicationContext.getBean("userService");
        userService.test();

        //System.out.println(new Date());



    }

}
