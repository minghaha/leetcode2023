package com.zhouyu.service.impl;


import com.zhouyu.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created on 2023/1/31.
 *
 * @author lichuanming
 */
//@Scope("Singleton")
@Component
public class UserServiceImpl implements UserService {

    @Override
    public void test() {
        System.out.println("test");
    }
}
