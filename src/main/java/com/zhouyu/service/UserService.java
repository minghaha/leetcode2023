package com.zhouyu.service;

import com.spring.Component;
import com.spring.ComponentScan;
import com.spring.Scope;

/**
 * Created on 2023/1/31.
 *
 * @author lichuanming
 */
//@Scope("Singleton")
@Component
public class UserService {
    public void test() {
        System.out.println("test");
    }
}
