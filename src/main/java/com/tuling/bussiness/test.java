package com.tuling.bussiness;

import com.tuling.spring.TulingAppConfig;
import com.tuling.spring.ZhouyuApplicationContext;

/**
 * Created on 2023/4/10.
 *
 * @author lichuanming
 */
public class test {
    public static void main(String[] args) {
        ZhouyuApplicationContext context = new ZhouyuApplicationContext(TulingAppConfig.class);
        UserService userService =(UserService) context.getBean("userService");
        System.out.println(userService);
        //userService.test();
        userService.autowired();

    }
}
