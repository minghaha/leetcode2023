package com.tuling.bussiness;

import com.tuling.spring.AutoWired;
import com.tuling.spring.Component;
import com.tuling.spring.Scpoe;

/**
 * Created on 2023/4/10.
 *
 * @author lichuanming
 */
@Component("userService")
public class UserService {

    @AutoWired
    OrderService orderService;


    void test(){
        System.out.println("test");
    }

    void autowired(){
        orderService.test();
    }

}
