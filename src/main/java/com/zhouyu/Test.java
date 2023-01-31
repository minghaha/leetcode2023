package com.zhouyu;

import com.spring.ZhouyuApplicationContext;
import com.zhouyu.service.UserService;

import java.sql.SQLOutput;

/**
 * Created on 2023/1/31.
 *
 * @author lichuanming
 */
public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext applicationContext = new ZhouyuApplicationContext(AppConfig.class);
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.test();
        System.out.println(userService);

        UserService userService1 = (UserService)applicationContext.getBean("userService");
        System.out.println(userService1);

    }

}
